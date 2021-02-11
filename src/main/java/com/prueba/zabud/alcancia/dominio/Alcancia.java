package com.prueba.zabud.alcancia.dominio;

/**
 * @author pedro
 */
public class Alcancia {

	private final TipoMoneda tipoMoneda;
	private Integer cantidadMonedas;
	private Integer cantidadDinero;

	public Alcancia(TipoMoneda tipoMoneda, Integer cantidadMonedas, Integer cantidadDinero) {
		this.tipoMoneda = tipoMoneda;
		this.cantidadMonedas = cantidadMonedas;
		this.cantidadDinero = cantidadDinero;
	}

	public Alcancia(TipoMoneda tipoMoneda, Integer cantidadMonedas) {
		this.tipoMoneda = tipoMoneda;
		this.cantidadMonedas = cantidadMonedas;
		calcularDinero();
	}

	public void agregarMonedas(Integer cantidadMonedasNuevas) {
		this.cantidadMonedas += cantidadMonedasNuevas;
		calcularDinero();
	}

	private void calcularDinero() {
		this.cantidadDinero = this.cantidadMonedas * this.tipoMoneda.getValor();
	}

	public TipoMoneda obtenerTipoMoneda() {
		return this.tipoMoneda;
	}

	public Integer obtenerCantidadMonedas() {
		return Integer.valueOf(this.cantidadMonedas);
	}

	public Integer obtenerCantidadDinero() {
		return Integer.valueOf(this.cantidadDinero);
	}
}
