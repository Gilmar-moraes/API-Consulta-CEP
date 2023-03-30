package com.api.cep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * @since 30/03/2023
 * @author Gilmar Junior
 * @version 1.0
 *
 */

@Configuration
public class SwaggerUIConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("API de Consulta de Endereço e Cálculo de Frete")
						.description("API para consultar endereços e calcular frete").version("1.0.0")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
