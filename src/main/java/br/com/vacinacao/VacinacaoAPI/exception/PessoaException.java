package br.com.vacinacao.VacinacaoAPI.exception;

public class PessoaException extends Exception {

	private static final long serialVersionUID = -2583226183019562494L;

	public PessoaException() {
		super();
	}

	public PessoaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PessoaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PessoaException(String message) {
		super(message);
	}

	public PessoaException(Throwable cause) {
		super(cause);
	}

}
