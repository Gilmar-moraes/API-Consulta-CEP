package com.api.cep.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @since 30/03/2023
 * @author Gilmar Junior
 * @version 1.0.1
 *
 */

@NoArgsConstructor
@Getter
@Setter
public class EnderecoModel {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private double frete;

	public EnderecoModel(String cep, String logradouro, String complemento, String bairro, String localidade,
			String uf) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}
}// fim da classe
