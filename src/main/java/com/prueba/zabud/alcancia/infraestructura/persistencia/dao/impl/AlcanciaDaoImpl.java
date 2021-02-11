package com.prueba.zabud.alcancia.infraestructura.persistencia.dao.impl;

import com.prueba.zabud.alcancia.infraestructura.persistencia.dao.AlcanciaCustomDao;
import com.prueba.zabud.alcancia.infraestructura.persistencia.entidad.AlcanciaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import java.util.Optional;

/**
 * @author pedro
 */
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AlcanciaDaoImpl implements AlcanciaCustomDao {

	private final EntityManager entityManager;

	@Override
	public Optional<Integer> sumaCantidadDineroTotal() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();

		From alcanceFrom = criteriaQuery.from(AlcanciaEntity.class);

		TypedQuery<Integer> resultQuery = entityManager.createQuery(
				criteriaQuery
						.select(
								criteriaBuilder
										.sum(
												alcanceFrom.get(AlcanciaEntity.Atributos.CANTIDAD_DINERO)
										)
						)
		);
		Integer result = resultQuery.getSingleResult();
		if (result == null) {
			result = 0;
		}
		return Optional
				.of(result);
	}
}
