package com.prueba.zabud.alcancia.infraestructura.persistencia.entidad;

import com.prueba.zabud.alcancia.dominio.TipoMoneda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pedro
 */
@Entity
@Table(name = "ALCANCIAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlcanciaEntity {

	public interface Atributos {
		String CANTIDAD_DINERO = "cantidadDinero";
	}

	@Id
	@Enumerated(value = EnumType.STRING)
	private TipoMoneda tipoMoneda;

	private Integer cantidadMonedas;
	private Integer cantidadDinero;

}
