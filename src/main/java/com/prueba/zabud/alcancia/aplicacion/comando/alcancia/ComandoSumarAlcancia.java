package com.prueba.zabud.alcancia.aplicacion.comando.alcancia;

import com.prueba.zabud.alcancia.dominio.TipoMoneda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author pedro
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ComandoSumarAlcancia {

	private TipoMoneda tipoMoneda;
	private Integer cantidadMonedas;

}
