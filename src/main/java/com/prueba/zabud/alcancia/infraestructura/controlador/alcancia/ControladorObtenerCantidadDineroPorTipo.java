package com.prueba.zabud.alcancia.infraestructura.controlador.alcancia;

import com.prueba.zabud.alcancia.aplicacion.manejador.alcancia.ManejadorObtenerCantidadDineroPorTipo;
import com.prueba.zabud.alcancia.dominio.TipoMoneda;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pedro
 */

@RestController
@RequestMapping("alcancias")
@RequiredArgsConstructor
public class ControladorObtenerCantidadDineroPorTipo {

	private final ManejadorObtenerCantidadDineroPorTipo manejadorObtenerCantidadDineroPorTipo;

	@GetMapping("dinero-total/{tipoMoneda}")
	@PreAuthorize("hasAnyRole('ROL_VER_ALCANCIA')")
	public ResponseEntity<Integer> obtenerCantidadDineroPorTipo(@PathVariable TipoMoneda tipoMoneda) {
		return ResponseEntity
				.ok(manejadorObtenerCantidadDineroPorTipo.ejecutar(tipoMoneda));
	}

}
