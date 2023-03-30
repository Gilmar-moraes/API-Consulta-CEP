package com.api.cep.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cep.execption.NegocioException;
import com.api.cep.model.EnderecoModel;
import com.api.cep.model.dto.EnderecoViaCepDTO;
import com.api.cep.util.ViaCep;

/**
 * @since 29/03/2023
 * @author Gilmar Junior
 * @version 1.0
 *
 */

@Service
public class EnderecoService {

	@Autowired
	private ViaCep viaCep;

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

	public double calcularFrete(String UF) {
		if ((UF.equals("BA")) || (UF.equals("SE")) || (UF.equals("AL")) || (UF.equals("PB")) || (UF.equals("PE"))
				|| (UF.equals("RN")) || (UF.equals("MA")) || (UF.equals("CE")) || (UF.equals("PI"))) {
			return 15.98;
		} else if ((UF.equals("PA")) || (UF.equals("AP")) || (UF.equals("AM")) || (UF.equals("RR")) || (UF.equals("AC"))
				|| (UF.equals("RO")) || (UF.equals("TO"))) {
			return 20.83;
		} else if ((UF.equals("DF")) || (UF.equals("GO")) || (UF.equals("MT")) || (UF.equals("MS"))) {
			return 12.50;
		} else if ((UF.equals("ES")) || (UF.equals("SP")) || (UF.equals("RJ")) || (UF.equals("MG"))) {
			return 7.85;
		} else if ((UF.equals("PR")) || (UF.equals("SC")) || (UF.equals("RS"))) {
			return 17.30;
		} else {
			return -1;
		}
	}
}
