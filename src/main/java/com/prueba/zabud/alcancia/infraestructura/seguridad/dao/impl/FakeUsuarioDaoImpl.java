package com.prueba.zabud.alcancia.infraestructura.seguridad.dao.impl;

import com.prueba.zabud.alcancia.infraestructura.seguridad.dao.UsuarioDao;
import com.prueba.zabud.alcancia.infraestructura.seguridad.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author pedro
 */
@Repository("fake")
@RequiredArgsConstructor
public class FakeUsuarioDaoImpl implements UsuarioDao {

	private final PasswordEncoder passwordEncoder;

	@Override
	public Optional<UsuarioEntity> findByUsername(String username) {
		return llenar()
				.stream()
				.filter(usuarioEntity -> usuarioEntity.getUsername().equals(username))
				.findFirst();
	}

	private List<UsuarioEntity> llenar() {
		List<UsuarioEntity> userEntities = Arrays.asList(
				new UsuarioEntity(
						"pedro",
						passwordEncoder.encode("123456"),
						Arrays.asList(
								new SimpleGrantedAuthority("ROLE_ADMIN")
						)
				),
				new UsuarioEntity(
						"andres",
						passwordEncoder.encode("123456"),
						Arrays.asList(
								new SimpleGrantedAuthority("ROL_SUMAR_ALCANCIA")
						)
				),
				new UsuarioEntity(
						"julian",
						passwordEncoder.encode("123456"),
						Arrays.asList(
								new SimpleGrantedAuthority("ROL_VER_ALCANCIA")
						)
				)
		);
		return userEntities;
	}

}
