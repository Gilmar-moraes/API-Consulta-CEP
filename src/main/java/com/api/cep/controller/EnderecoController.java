package com.api.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cep.model.EnderecoModel;
import com.api.cep.service.EnderecoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @since 30/03/2023
 * @author Gilmar Junior
 * @version 1.0.1
 *
 */

@RestController
@RequestMapping("/endereco")
@Tag(name = "Endereço")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@Operation(summary = "Consulta de endereço", description = "Consulta o endereço a parti do CEP pelo consumo da API ViaCep e é calculado o valor do frete para região do CEP fornecido")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoModel.class)) }),
			@ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
			@ApiResponse(responseCode = "404", description = "Endereço não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno", content = @Content) })
	@GetMapping("/{cep}")
	public EnderecoModel getEndereco(@PathVariable String cep) {
		return enderecoService.buscarCep(cep);
	}
}
