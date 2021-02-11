package com.prueba.zabud.alcancia.aplicacion.manejador.alcancia;

import com.prueba.zabud.alcancia.dominio.TipoMoneda;
import com.prueba.zabud.alcancia.dominio.servicio.alcancia.ServicioObtenerCantidadDineroPorTipo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
@RequiredArgsConstructor
public class ManejadorObtenerCantidadDineroPorTipo {

	private final ServicioObtenerCantidadDineroPorTipo servicioObtenerCantidadDineroPorTipo;

	public Integer ejecutar(TipoMoneda tipoMoneda) {
		return servicioObtenerCantidadDineroPorTipo
				.ejecutar(tipoMoneda);
	}

}
