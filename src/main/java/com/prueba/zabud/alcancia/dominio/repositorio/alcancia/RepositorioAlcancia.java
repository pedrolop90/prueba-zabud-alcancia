package com.prueba.zabud.alcancia.dominio.repositorio.alcancia;

import com.prueba.zabud.alcancia.dominio.Alcancia;
import com.prueba.zabud.alcancia.dominio.TipoMoneda;

import java.util.Optional;

/**
 * @author pedro
 */
public interface RepositorioAlcancia {

	void guardarAlcancia(Alcancia alcancia);

	Optional<Alcancia> obtenerAlcanciaPorTipoMoneda(TipoMoneda tipoMoneda);

	Optional<Integer> obtenerCantidadDineroTotal();

}
