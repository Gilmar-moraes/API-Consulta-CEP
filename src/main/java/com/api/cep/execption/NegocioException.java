package com.api.cep.execption;

/**
 * @since 30/03/2023
 * @author Gilmar Junior
 * @version 1.0
 *
 */

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String message) {
		super(message);
	}

}
