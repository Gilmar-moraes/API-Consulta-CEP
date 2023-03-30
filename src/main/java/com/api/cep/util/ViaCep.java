package com.api.cep.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.api.cep.model.dto.EnderecoViaCepDTO;

/**
 * @since 29/03/2023
 * @author Gilmar Junior
 * @version 1.0
 *
 */

@Component
public class ViaCep {

	@Value("https://viacep.com.br/ws/")
	private String url;

    public EnderecoViaCepDTO getEndereco(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = url + cep + "/json";
        EnderecoViaCepDTO endereco = restTemplate.getForObject(endpoint, EnderecoViaCepDTO.class);
        return endereco;
    }
}
