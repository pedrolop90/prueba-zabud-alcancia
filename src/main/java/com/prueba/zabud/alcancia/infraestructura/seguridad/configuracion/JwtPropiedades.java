package com.prueba.zabud.alcancia.infraestructura.seguridad.configuracion;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
@ConfigurationProperties(prefix = "jwt")
@RequiredArgsConstructor
@Getter
@Setter
public class JwtPropiedades {

    private String secretKey;
    private String prefix;
    private Integer expiraInDays;

}
