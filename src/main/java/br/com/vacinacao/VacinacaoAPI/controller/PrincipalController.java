package br.com.vacinacao.VacinacaoAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vacinacao.VacinacaoAPI.exception.error.RotaResponse;

@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "*")
public class PrincipalController {
	@GetMapping
	public ResponseEntity<RotaResponse> save() {

		RotaResponse erro = new RotaResponse( 400, "Bad Request", "Rota inexistente. Para mais informações acesse: https://orange-zup.herokuapp.com/swagger-ui.html");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}