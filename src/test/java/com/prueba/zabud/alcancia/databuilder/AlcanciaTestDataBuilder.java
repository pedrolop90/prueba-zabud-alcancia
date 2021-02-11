package com.prueba.zabud.alcancia.databuilder;

import com.prueba.zabud.alcancia.aplicacion.comando.alcancia.ComandoSumarAlcancia;
import com.prueba.zabud.alcancia.dominio.Alcancia;
import com.prueba.zabud.alcancia.dominio.TipoMoneda;

/**
 * @author pedro
 */
public class AlcanciaTestDataBuilder {

	public static final TipoMoneda TIPO_MONEDA = TipoMoneda.CIEN;
	public static final Integer CANTIDAD_MONEDAS = 100;
	public static final Integer CANTIDAD_DINERO = 10000;

	private TipoMoneda tipoMonedas;
	private Integer cantidadMonedas;
	private Integer cantidadDinero;

	public AlcanciaTestDataBuilder() {
		this.tipoMonedas = TIPO_MONEDA;
		this.cantidadMonedas = CANTIDAD_MONEDAS;
		this.cantidadDinero = CANTIDAD_DINERO;
	}

	public AlcanciaTestDataBuilder tipoMoneda(TipoMoneda tipoMoneda) {
		this.tipoMonedas = tipoMoneda;
		return this;
	}

	public AlcanciaTestDataBuilder cantidadMonedas(Integer cantidadMonedas) {
		this.cantidadMonedas = cantidadMonedas;
		return this;
	}

	public AlcanciaTestDataBuilder cantidadDinero(Integer cantidadDinero) {
		this.cantidadDinero = cantidadDinero;
		return this;
	}


	public Alcancia build() {
		return new Alcancia(this.tipoMonedas, this.cantidadMonedas, this.cantidadDinero);
	}

	public ComandoSumarAlcancia buildComando() {
		return new ComandoSumarAlcancia(this.tipoMonedas, this.cantidadMonedas);
	}
}
