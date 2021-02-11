package com.prueba.zabud.alcancia.infraestructura.seguridad.jwt;

import com.prueba.zabud.alcancia.infraestructura.seguridad.configuracion.JwtPropiedades;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author pedro
 */
@RequiredArgsConstructor
public class JwtTokenAutorizacion extends OncePerRequestFilter {

    private final JwtPropiedades jwtPropiedades;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization == null ||
                authorization.isEmpty() ||
                !authorization.startsWith(jwtPropiedades.getPrefix())
        ) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = authorization.replace(jwtPropiedades.getPrefix(), "");

            Jws<Claims> claimsJwts = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(jwtPropiedades.getSecretKey().getBytes()))
                    .parseClaimsJws(token);

            Claims body = claimsJwts.getBody();
            String username = body.getSubject();

            List<Map<String, String>> authorities = (List<Map<String, String>>) body.get("authorities");

            Set<SimpleGrantedAuthority> simpleGrantedAuthoritySet = authorities
                    .stream()
                    .map(m -> new SimpleGrantedAuthority(m.get("authority")))
                    .collect(Collectors.toSet());

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    simpleGrantedAuthoritySet
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        catch (Exception e) {
            throw new IllegalStateException("token invalido");
        }

        filterChain.doFilter(request, response);
    }
}
