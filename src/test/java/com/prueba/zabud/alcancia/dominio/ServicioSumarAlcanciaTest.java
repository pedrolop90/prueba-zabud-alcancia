package com.prueba.zabud.alcancia.dominio;

import com.prueba.zabud.alcancia.dominio.repositorio.alcancia.RepositorioAlcancia;
import com.prueba.zabud.alcancia.dominio.servicio.alcancia.ServicioSumarAlcancia;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author pedro
 */
@RunWith(MockitoJUnitRunner.class)
public class ServicioSumarAlcanciaTest {

	@Mock
	private RepositorioAlcancia repositorioAlcancia;

	@InjectMocks
	private ServicioSumarAlcancia servicioSumarAlcancia;

	@Test
	public void SumarSiEstaPresente() {
		Alcancia alcanciaNueva = mock(Alcancia.class);
		Alcancia alcanciaVieja = mock(Alcancia.class);

		Integer viejaCantidadMonedas = 100;

		when(alcanciaVieja.obtenerCantidadMonedas()).thenReturn(viejaCantidadMonedas);

		when(repositorioAlcancia.obtenerAlcanciaPorTipoMoneda(any()))
				.thenReturn(Optional.of(alcanciaVieja));

		servicioSumarAlcancia.ejecutar(alcanciaNueva);
		verify(repositorioAlcancia, times(1)).obtenerAlcanciaPorTipoMoneda(any());
		verify(alcanciaNueva, times(1)).agregarMonedas(anyInt());
		verify(repositorioAlcancia, times(1)).guardarAlcancia(alcanciaNueva);
	}

	@Test
	public void SumarSiNoEstaPresente() {
		Alcancia alcanciaNueva = mock(Alcancia.class);
		Alcancia alcanciaVieja = null;

		when(repositorioAlcancia.obtenerAlcanciaPorTipoMoneda(any()))
				.thenReturn(Optional.empty());

		servicioSumarAlcancia.ejecutar(alcanciaNueva);
		verify(repositorioAlcancia, times(1)).obtenerAlcanciaPorTipoMoneda(any());
		verify(alcanciaNueva, never()).agregarMonedas(anyInt());
		verify(repositorioAlcancia, times(1)).guardarAlcancia(alcanciaNueva);
	}

}
