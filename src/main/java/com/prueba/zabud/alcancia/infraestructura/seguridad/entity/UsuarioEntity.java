package com.prueba.zabud.alcancia.infraestructura.seguridad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author pedro
 */
@Data
@AllArgsConstructor
public class UsuarioEntity {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

}
