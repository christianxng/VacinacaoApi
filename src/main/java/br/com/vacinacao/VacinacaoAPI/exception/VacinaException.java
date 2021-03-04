package br.com.vacinacao.VacinacaoAPI.exception;

public class VacinaException extends Exception {

	private static final long serialVersionUID = -2583226183019562494L;

	public VacinaException() {
		super();
	}

	public VacinaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VacinaException(String message, Throwable cause) {
		super(message, cause);
	}

	public VacinaException(String message) {
		super(message);
	}

	public VacinaException(Throwable cause) {
		super(cause);
	}

}
