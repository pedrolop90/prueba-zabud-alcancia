package com.prueba.zabud.alcancia.aplicacion.manejador.alcancia;

import com.prueba.zabud.alcancia.dominio.TipoMoneda;
import com.prueba.zabud.alcancia.dominio.servicio.alcancia.ServicioObtenerCantidadMonedasPorTipo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
@RequiredArgsConstructor
public class ManejadorObtenerCantidadMonedasPorTipo {

	private final ServicioObtenerCantidadMonedasPorTipo servicioObtenerCantidadMonedasPorTipo;

	public Integer ejecutar(TipoMoneda tipoMoneda) {
		return servicioObtenerCantidadMonedasPorTipo
				.ejecutar(tipoMoneda);
	}

}
