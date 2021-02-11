package com.prueba.zabud.alcancia.aplicacion.manejador.alcancia;

import com.prueba.zabud.alcancia.dominio.servicio.alcancia.ServicioObtenerCantidadDineroTotal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
@RequiredArgsConstructor
public class ManejadorObtenerCantidadDineroTotal {

	private final ServicioObtenerCantidadDineroTotal servicioObtenerCantidadDineroTotal;

	public Integer ejecutar() {
		return servicioObtenerCantidadDineroTotal
				.ejecutar();
	}

}
