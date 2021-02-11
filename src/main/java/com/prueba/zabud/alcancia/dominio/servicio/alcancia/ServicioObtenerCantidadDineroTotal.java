package com.prueba.zabud.alcancia.dominio.servicio.alcancia;

import com.prueba.zabud.alcancia.dominio.repositorio.alcancia.RepositorioAlcancia;

/**
 * @author pedro
 */
public class ServicioObtenerCantidadDineroTotal {

	private final RepositorioAlcancia repositorioAlcancia;

	public ServicioObtenerCantidadDineroTotal(RepositorioAlcancia repositorioAlcancia) {this.repositorioAlcancia = repositorioAlcancia;}

	public Integer ejecutar() {
		return repositorioAlcancia
				.obtenerCantidadDineroTotal()
				.orElse(0);
	}
}
