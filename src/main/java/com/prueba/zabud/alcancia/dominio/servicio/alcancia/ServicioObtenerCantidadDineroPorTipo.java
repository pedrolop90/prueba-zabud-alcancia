package com.prueba.zabud.alcancia.dominio.servicio.alcancia;

import com.prueba.zabud.alcancia.dominio.Alcancia;
import com.prueba.zabud.alcancia.dominio.TipoMoneda;
import com.prueba.zabud.alcancia.dominio.repositorio.alcancia.RepositorioAlcancia;

/**
 * @author pedro
 */
public class ServicioObtenerCantidadDineroPorTipo {

	private final RepositorioAlcancia repositorioAlcancia;

	public ServicioObtenerCantidadDineroPorTipo(RepositorioAlcancia repositorioAlcancia) {this.repositorioAlcancia = repositorioAlcancia;}

	public Integer ejecutar(TipoMoneda tipoMoneda) {
		return repositorioAlcancia
				.obtenerAlcanciaPorTipoMoneda(tipoMoneda)
				.map(Alcancia::obtenerCantidadDinero)
				.orElse(0);
	}
}
