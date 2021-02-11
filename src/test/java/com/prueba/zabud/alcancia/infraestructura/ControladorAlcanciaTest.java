package com.prueba.zabud.alcancia.infraestructura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.zabud.alcancia.aplicacion.comando.alcancia.ComandoSumarAlcancia;
import com.prueba.zabud.alcancia.dominio.TipoMoneda;
import com.prueba.zabud.alcancia.databuilder.AlcanciaTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author pedro
 */

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControladorAlcanciaTest {

	public static final String RUTA_CONTROLADOR = "/alcancias/";

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void sumarAlcancia() throws Exception {
		ComandoSumarAlcancia comandoLibro = new AlcanciaTestDataBuilder()
				.buildComando();

		UriComponents uriSumarAlcancia = UriComponentsBuilder
				.fromPath(RUTA_CONTROLADOR)
				.build();

		mvc.perform(MockMvcRequestBuilders
				.post(uriSumarAlcancia.toUriString())
				.content(objectMapper.writeValueAsString(comandoLibro))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		obtenerCantidadDineroPorTipo();
		obtenerCantidadMonedasPorTipo();
	}

	private void obtenerCantidadDineroPorTipo() throws Exception {
		UriComponents uriObtenerCantidadDineroPorTipo = UriComponentsBuilder
				.fromPath(RUTA_CONTROLADOR)
				.pathSegment("dinero-total", TipoMoneda.CIEN.name())
				.build();

		mvc.perform(MockMvcRequestBuilders
				.get(uriObtenerCantidadDineroPorTipo.toUriString())
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(
						MockMvcResultMatchers
								.jsonPath("$")
								.value(AlcanciaTestDataBuilder.CANTIDAD_DINERO)
				);

	}

	private void obtenerCantidadMonedasPorTipo() throws Exception {
		UriComponents uriObtenerCantidadMonedasPorTipo = UriComponentsBuilder
				.fromPath(RUTA_CONTROLADOR)
				.pathSegment("monedas-total", TipoMoneda.CIEN.name())
				.build();

		mvc.perform(MockMvcRequestBuilders
				.get(uriObtenerCantidadMonedasPorTipo.toUriString())
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(
						MockMvcResultMatchers
								.jsonPath("$")
								.value(AlcanciaTestDataBuilder.CANTIDAD_MONEDAS)
				);

	}
}
