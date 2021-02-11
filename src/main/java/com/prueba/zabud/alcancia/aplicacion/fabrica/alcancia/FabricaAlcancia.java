package com.prueba.zabud.alcancia.aplicacion.fabrica.alcancia;

import com.prueba.zabud.alcancia.aplicacion.comando.alcancia.ComandoSumarAlcancia;
import com.prueba.zabud.alcancia.dominio.Alcancia;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 */
@Component
public class FabricaAlcancia {

	public Alcancia crearAlcancia(ComandoSumarAlcancia comandoSumarAlcancia){
		return new Alcancia(comandoSumarAlcancia.getTipoMoneda(), comandoSumarAlcancia.getCantidadMonedas());
	}

}
