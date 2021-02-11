package com.prueba.zabud.alcancia.infraestructura.seguridad.configuracion;

import com.prueba.zabud.alcancia.infraestructura.seguridad.autenticacion.AplicacionLoginService;
import com.prueba.zabud.alcancia.infraestructura.seguridad.jwt.JwtLoginFilter;
import com.prueba.zabud.alcancia.infraestructura.seguridad.jwt.JwtTokenAutorizacion;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author pedro
 */
@Configuration
@Profile("prod")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SeguridadProdConfiguracion extends WebSecurityConfigurerAdapter {

    private final AplicacionLoginService aplicacionLoginService;
    private final PasswordEncoder passwordEncoder;
    private final JwtPropiedades jwtPropiedades;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtLoginFilter(authenticationManager(), jwtPropiedades))
                .addFilterAfter(new JwtTokenAutorizacion(jwtPropiedades), JwtLoginFilter.class)
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(aplicacionLoginService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(aplicacionLoginService);
        return daoAuthenticationProvider;
    }
}
