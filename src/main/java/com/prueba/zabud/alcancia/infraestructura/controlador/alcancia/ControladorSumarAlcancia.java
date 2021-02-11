package com.prueba.zabud.alcancia.infraestructura.controlador.alcancia;

import com.prueba.zabud.alcancia.aplicacion.comando.alcancia.ComandoSumarAlcancia;
import com.prueba.zabud.alcancia.aplicacion.manejador.alcancia.ManejadorSumarAlcancia;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pedro
 */
@RestController
@RequestMapping("alcancias")
@RequiredArgsConstructor
public class ControladorSumarAlcancia {

	private final ManejadorSumarAlcancia manejadorSumarAlcancia;

	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROL_SUMAR_ALCANCIA')")
	public void sumarAlcancia(@RequestBody ComandoSumarAlcancia comandoSumarAlcancia) {
		manejadorSumarAlcancia.ejecutar(comandoSumarAlcancia);
	}

}
