package com.prueba.zabud.alcancia.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author pedro
 */
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum TipoMoneda {

	CINCUENTA((short) 50),
	CIEN((short) 100),
	DOSCIENTOS((short) 200),
	QUINIENTOS((short) 500),
	MIL((short) 1000);

	private Short valor;

	TipoMoneda(Short valor) {
		this.valor = valor;
	}

	public Short getValor() {
		return valor;
	}

	@JsonValue
	public String getValue() {
		return name();
	}

	@JsonCreator
	public static TipoMoneda fromValue(String value) {
		if (value != null && !value.isEmpty()) {
			for (TipoMoneda p : values()) {
				if (p.name().equals(value)) {
					return p;
				}
			}
		}

		//throw new ResponseStatusException("estado", value);
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "TipoMoneda");
	}
}
