package br.com.vacinacao.VacinacaoAPI.exception.error;

import java.util.List;

public class ErrorResponse {

	private  String message;
	private  int code;
	private  String status;
	private  List<ErrorObject> errors;

	public ErrorResponse(String message, int code, String status, List<ErrorObject> errors) {
		super();
		this.message = message;
		this.code = code;
		this.status = status;
		this.errors = errors;
	}
	
	public ErrorResponse(String message, int code, String status) {
		super();
		this.message = message;
		this.code = code;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public List<ErrorObject> getErrors() {
		return errors;
	}

}
