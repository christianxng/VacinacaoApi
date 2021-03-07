package br.com.vacinacao.VacinacaoAPI.exception.error;

public class RotaResponse {
	
	private  int code;
	private  String status;
	private  String message;
	
	public RotaResponse(int code, String status, String message) {
		super();		
		this.code = code;
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}	
	
	public String getStatus() {
		return status;
	}	
}

