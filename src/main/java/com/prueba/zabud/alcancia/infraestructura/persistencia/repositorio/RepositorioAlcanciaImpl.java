package com.prueba.zabud.alcancia.infraestructura.persistencia.repositorio;

import com.prueba.zabud.alcancia.dominio.Alcancia;
import com.prueba.zabud.alcancia.dominio.TipoMoneda;
import com.prueba.zabud.alcancia.dominio.repositorio.alcancia.RepositorioAlcancia;
import com.prueba.zabud.alcancia.infraestructura.persistencia.builder.AlcanciaBuilder;
import com.prueba.zabud.alcancia.infraestructura.persistencia.dao.AlcanciaDao;
import com.prueba.zabud.alcancia.infraestructura.persistencia.entidad.AlcanciaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author pedro
 */
@Repository
@RequiredArgsConstructor
public class RepositorioAlcanciaImpl implements RepositorioAlcancia {

	private final AlcanciaDao alcanciaDao;

	@Override
	public void guardarAlcancia(Alcancia alcancia) {
		AlcanciaEntity alcanciaEntity = AlcanciaBuilder.convertirAEntidad(alcancia);
		alcanciaDao.save(alcanciaEntity);
	}

	@Override
	public Optional<Alcancia> obtenerAlcanciaPorTipoMoneda(TipoMoneda tipoMoneda) {
		return alcanciaDao
				.findById(tipoMoneda)
				.map(AlcanciaBuilder::convertirADominio);
	}

	@Override
	public Optional<Integer> obtenerCantidadDineroTotal() {
		return alcanciaDao
				.sumaCantidadDineroTotal();
	}
}
