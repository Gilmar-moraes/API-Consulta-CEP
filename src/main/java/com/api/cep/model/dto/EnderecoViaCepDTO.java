package com.api.cep.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @since 07/04/2023
 * @author Gilmar Junior
 * @version 1.0.2
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EnderecoViaCepDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;

}// fim da classe
