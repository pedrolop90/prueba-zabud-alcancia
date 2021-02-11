package com.prueba.zabud.alcancia.infraestructura.seguridad.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.zabud.alcancia.infraestructura.seguridad.configuracion.JwtPropiedades;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author pedro
 */
@RequiredArgsConstructor
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;
	private final JwtPropiedades jwtPropiedades;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
												HttpServletResponse response) throws AuthenticationException {

		try {
			LoginDto usernameRequest = new ObjectMapper()
					.readValue(
							request.getInputStream(),
							LoginDto.class
					);
			Authentication authentication = new UsernamePasswordAuthenticationToken(
					usernameRequest.getUsername(),
					usernameRequest.getPassword()
			);
			return authenticationManager.authenticate(authentication);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response,
											FilterChain chain,
											Authentication authResult) throws IOException, ServletException {
		String token = Jwts.builder()
				.setSubject(authResult.getName())
				.claim("authorities", authResult.getAuthorities())
				.setIssuedAt(new Date())
				.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtPropiedades.getExpiraInDays())))
				.signWith(Keys.hmacShaKeyFor(jwtPropiedades.getSecretKey().getBytes()))
				.compact();
		response.addHeader("Authorization", "Bearer " + token);
	}
}
