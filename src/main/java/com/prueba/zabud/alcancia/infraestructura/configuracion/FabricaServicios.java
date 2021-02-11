package com.prueba.zabud.alcancia.infraestructura.configuracion;

import com.prueba.zabud.alcancia.dominio.repositorio.alcancia.RepositorioAlcancia;
import com.prueba.zabud.alcancia.dominio.servicio.alcancia.ServicioObtenerCantidadDineroPorTipo;
import com.prueba.zabud.alcancia.dominio.servicio.alcancia.ServicioObtenerCantidadDineroTotal;
import com.prueba.zabud.alcancia.dominio.servicio.alcancia.ServicioObtenerCantidadMonedasPorTipo;
import com.prueba.zabud.alcancia.dominio.servicio.alcancia.ServicioSumarAlcancia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pedro
 */
@Configuration
public class FabricaServicios {

	@Bean
	public ServicioSumarAlcancia servicioSumarAlcancia(RepositorioAlcancia repositorioAlcancia) {
		return new ServicioSumarAlcancia(repositorioAlcancia);
	}

	@Bean
	public ServicioObtenerCantidadDineroTotal servicioObtenerCantidadDineroTotal(RepositorioAlcancia repositorioAlcancia) {
		return new ServicioObtenerCantidadDineroTotal(repositorioAlcancia);
	}

	@Bean
	public ServicioObtenerCantidadMonedasPorTipo servicioObtenerCantidadMonedasPorTipo(RepositorioAlcancia repositorioAlcancia) {
		return new ServicioObtenerCantidadMonedasPorTipo(repositorioAlcancia);
	}

	@Bean
	public ServicioObtenerCantidadDineroPorTipo servicioObtenerCantidadDineroPorTipo(RepositorioAlcancia repositorioAlcancia) {
		return new ServicioObtenerCantidadDineroPorTipo(repositorioAlcancia);
	}
}
