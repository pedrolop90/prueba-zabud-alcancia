package com.prueba.zabud.alcancia.aplicacion.manejador.alcancia;

import com.prueba.zabud.alcancia.aplicacion.comando.alcancia.ComandoSumarAlcancia;
import com.prueba.zabud.alcancia.aplicacion.fabrica.alcancia.FabricaAlcancia;
import com.prueba.zabud.alcancia.dominio.Alcancia;
import com.prueba.zabud.alcancia.dominio.servicio.alcancia.ServicioSumarAlcancia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author pedro
 */
@Component
@RequiredArgsConstructor
public class ManejadorSumarAlcancia {

	private final ServicioSumarAlcancia servicioSumarAlcancia;
	private final FabricaAlcancia fabricaAlcancia;

	@Transactional
	public void ejecutar(ComandoSumarAlcancia comandoSumarAlcancia) {
		Alcancia alcancia = fabricaAlcancia.crearAlcancia(comandoSumarAlcancia);
		servicioSumarAlcancia.ejecutar(alcancia);
	}

}
