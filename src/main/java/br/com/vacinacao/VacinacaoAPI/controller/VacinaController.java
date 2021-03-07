package br.com.vacinacao.VacinacaoAPI.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vacinacao.VacinacaoAPI.exception.VacinaException;
import br.com.vacinacao.VacinacaoAPI.model.Vacina;
import br.com.vacinacao.VacinacaoAPI.resource.VacinaResource;
import br.com.vacinacao.VacinacaoAPI.service.VacinaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Vacinas")
@CrossOrigin(origins = "*")
public class VacinaController {

	@Autowired
	private VacinaService service;

	@PostMapping(value = "/vacina/pessoa/{id}")
	@ApiOperation(value="Realiza cadastro de uma vacina e realiza o vículo a  uma pessoa através do ID passado no path da requisição")
	public ResponseEntity<Vacina> save(@PathVariable("id") Long id, @RequestBody @Valid VacinaResource vacina)
			throws VacinaException {
		Vacina newObj = service.cadastro(id, vacina);
		return ResponseEntity.created(null).body(newObj);
	}

	@GetMapping(value = "/vacinas")
	@ApiOperation(value="Retorna lista de vacinas cadastradas")

	public ResponseEntity<List<Vacina>> findAll() {
		List<Vacina> list = service.listar();
		return ResponseEntity.ok().body(list);
	}

}
