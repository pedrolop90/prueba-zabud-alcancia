package com.prueba.zabud.alcancia.infraestructura.persistencia.dao;

import com.prueba.zabud.alcancia.dominio.TipoMoneda;
import com.prueba.zabud.alcancia.infraestructura.persistencia.entidad.AlcanciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pedro
 */
public interface AlcanciaDao extends JpaRepository<AlcanciaEntity, TipoMoneda>, AlcanciaCustomDao {



}
