package com.prueba.zabud.alcancia.infraestructura.persistencia.builder;

import com.prueba.zabud.alcancia.dominio.Alcancia;
import com.prueba.zabud.alcancia.infraestructura.persistencia.entidad.AlcanciaEntity;

/**
 * @author pedro
 */
public final class AlcanciaBuilder {

	private AlcanciaBuilder() {

	}

	public static Alcancia convertirADominio(AlcanciaEntity alcanciaEntity) {
		return new Alcancia(
				alcanciaEntity.getTipoMoneda(),
				alcanciaEntity.getCantidadMonedas(),
				alcanciaEntity.getCantidadDinero()
		);
	}

	public static AlcanciaEntity convertirAEntidad(Alcancia alcancia) {
		return new AlcanciaEntity(
				alcancia.obtenerTipoMoneda(),
				alcancia.obtenerCantidadMonedas(),
				alcancia.obtenerCantidadDinero()
		);
	}

}
