package com.api.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cep.model.EnderecoModel;
import com.api.cep.service.EnderecoService;

/**
 * @since 29/03/2023
 * @author Gilmar Junior
 * @version 1.0
 *
 */

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	    @Autowired
	    private EnderecoService enderecoService;

	    @GetMapping("/{cep}")
	    public EnderecoModel getEndereco(@PathVariable String cep) {
	        return enderecoService.buscarCep(cep);
	    }
}
