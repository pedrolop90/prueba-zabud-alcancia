package com.prueba.zabud.alcancia.infraestructura.seguridad.dao;


import com.prueba.zabud.alcancia.infraestructura.seguridad.entity.UsuarioEntity;

import java.util.Optional;

/**
 * @author pedro
 */
public interface UsuarioDao {

    Optional<UsuarioEntity> findByUsername(String username);

}
