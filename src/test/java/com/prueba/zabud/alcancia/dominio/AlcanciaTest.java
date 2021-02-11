package com.prueba.zabud.alcancia.dominio;

import com.prueba.zabud.alcancia.databuilder.AlcanciaTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author pedro
 */
public class AlcanciaTest {

	private static final TipoMoneda TIPO_MONEDA = TipoMoneda.CIEN;
	private static final Integer CANTIDAD_MONEDAS = 100;
	private static final Integer CANTIDAD_DINERO = 10000;
	private static final Integer CANTIDAD_MONEDAS_AGREGADAS = 10;


	private static final Integer CANTIDAD_MONEDAS_FINAL = 110;
	private static final Integer CANTIDAD_DINERO_FINAL = 11000;


	@Test
	public void sumarAlcanciaTest() {
		AlcanciaTestDataBuilder alcanciaTestDataBuilder = new AlcanciaTestDataBuilder()
				.tipoMoneda(TipoMoneda.CIEN)
				.cantidadMonedas(CANTIDAD_MONEDAS)
				.cantidadDinero(CANTIDAD_DINERO);

		Alcancia alcancia = alcanciaTestDataBuilder.build();
		alcancia.agregarMonedas(CANTIDAD_MONEDAS_AGREGADAS);

		assertEquals(TIPO_MONEDA, alcancia.obtenerTipoMoneda());
		assertEquals(CANTIDAD_MONEDAS_FINAL, alcancia.obtenerCantidadMonedas());
		assertEquals(CANTIDAD_DINERO_FINAL, alcancia.obtenerCantidadDinero());
	}
}
