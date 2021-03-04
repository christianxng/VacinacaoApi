package br.com.vacinacao.VacinacaoAPI.exception.response;

public class EmailExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailExistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailExistenteException(String message) {
		super(message);
	}

}