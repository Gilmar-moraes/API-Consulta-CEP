package com.api.cep.model.dto;

import lombok.Data;

/**
 * @since 30/03/2023
 * @author Gilmar Junior
 * @version 1.0.1
 *
 */
@Data
public class EnderecoViaCepDTO {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;

}// fim da classe
