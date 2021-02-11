package com.prueba.zabud.alcancia.infraestructura.controlador.alcancia;

import com.prueba.zabud.alcancia.aplicacion.manejador.alcancia.ManejadorObtenerCantidadDineroTotal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pedro
 */

@RestController
@RequestMapping("alcancias")
@RequiredArgsConstructor
public class ControladorObtenerCantidadDineroTotal {

	private final ManejadorObtenerCantidadDineroTotal manejadorObtenerCantidadDineroTotal;

	@GetMapping("dinero-total")
	@PreAuthorize("hasAnyRole('ROL_VER_ALCANCIA')")
	public ResponseEntity<Integer> obtenerCantidadDineroTotal() {
		return ResponseEntity
				.ok(manejadorObtenerCantidadDineroTotal.ejecutar());
	}

}
