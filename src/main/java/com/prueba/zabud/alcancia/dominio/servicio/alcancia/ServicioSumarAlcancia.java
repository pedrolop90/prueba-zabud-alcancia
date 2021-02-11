package com.prueba.zabud.alcancia.dominio.servicio.alcancia;

import com.prueba.zabud.alcancia.dominio.Alcancia;
import com.prueba.zabud.alcancia.dominio.repositorio.alcancia.RepositorioAlcancia;

/**
 * @author pedro
 */
public class ServicioSumarAlcancia {

	private final RepositorioAlcancia repositorioAlcancia;

	public ServicioSumarAlcancia(RepositorioAlcancia repositorioAlcancia) {
		this.repositorioAlcancia = repositorioAlcancia;
	}

	public void ejecutar(Alcancia alcancia) {
		repositorioAlcancia
				.obtenerAlcanciaPorTipoMoneda(alcancia.obtenerTipoMoneda())
				.ifPresent(
						alcanciaVieja ->
								alcancia.agregarMonedas(alcanciaVieja.obtenerCantidadMonedas())
				);

		repositorioAlcancia.guardarAlcancia(alcancia);
	}

}
