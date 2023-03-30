package com.api.cep.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cep.execption.NegocioException;
import com.api.cep.model.EnderecoModel;
import com.api.cep.model.dto.EnderecoViaCepDTO;
import com.api.cep.util.ViaCep;

/**
 * @since 30/03/2023
 * @author Gilmar Junior
 * @version 1.0.1
 *
 */

@Service
public class EnderecoService {

	@Autowired
	private ViaCep viaCep;

	/**
	 * 
	 * @param cep
	 * @return
	 */
	public EnderecoModel buscarCep(String cep) {
		if (cep.length() > 8 || cep.length() < 8) {

			throw new NegocioException("CEP não encontrado, CEP faltando numeros");

		} else if ((Objects.isNull(cep) || cep.isEmpty() || cep.isBlank())) {

			throw new NegocioException("O cep informado não pode ser nulo ou vazio");

		} else {
			EnderecoViaCepDTO cepRetorno = viaCep.getEndereco(cep);

			EnderecoModel enderecoConsModel = new EnderecoModel(cepRetorno.getCep(), cepRetorno.getLogradouro(),
					cepRetorno.getComplemento(), cepRetorno.getBairro(), cepRetorno.getLocalidade(),
					cepRetorno.getUf());

			enderecoConsModel.setFrete(calcularFrete(cepRetorno.getUf()));

			return enderecoConsModel;
		}
	}

	/**
	 * 
	 * @param UF
	 * @return o valor do frete
	 */

	private double calcularFrete(String uf) {
		switch (uf.toUpperCase()) {
		case "SP":
		case "RJ":
		case "MG":
		case "ES":
			return 7.85;
		case "DF":
		case "GO":
		case "MT":
		case "MS":
			return 12.50;
		case "AL":
		case "BA":
		case "CE":
		case "MA":
		case "PB":
		case "PE":
		case "PI":
		case "RN":
		case "SE":
			return 15.98;
		case "PR":
		case "RS":
		case "SC":
			return 17.30;
		case "AC":
		case "AM":
		case "AP":
		case "PA":
		case "RO":
		case "RR":
		case "TO":
			return 20.83;
		default:
			return 0;
		}
	}
}
