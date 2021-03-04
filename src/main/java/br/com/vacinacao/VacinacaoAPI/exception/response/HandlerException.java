package br.com.vacinacao.VacinacaoAPI.exception.response;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.vacinacao.VacinacaoAPI.exception.error.ErrorObject;
import br.com.vacinacao.VacinacaoAPI.exception.error.ErrorResponse;
import br.com.vacinacao.VacinacaoAPI.exception.error.StandardError;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(EmailExistenteException.class)
	public ResponseEntity<StandardError> EmailExistenteException(EmailExistenteException e,
			HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(CpfExistenteException.class)
	public ResponseEntity<StandardError> CpfExistenteException(CpfExistenteException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorObject> errors = getErrors(ex);
		ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
		return new ResponseEntity<>(errorResponse, status);
	}

	private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status,
			List<ErrorObject> errors) {
		return new ErrorResponse("Requisição possui campos inválidos", status.value(), status.getReasonPhrase(),
				errors);
	}

	private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
		return ex.getBindingResult().getFieldErrors().stream()
				.map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
				.collect(Collectors.toList());
	}

}
