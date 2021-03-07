package br.com.vacinacao.VacinacaoAPI.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vacinacao.VacinacaoAPI.exception.PessoaException;
import br.com.vacinacao.VacinacaoAPI.model.Pessoa;
import br.com.vacinacao.VacinacaoAPI.resource.PessoaResource;
import br.com.vacinacao.VacinacaoAPI.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Pessoas")
@CrossOrigin(origins = "*")

public class PessoaController {

	@Autowired
	private PessoaService service;

	@PostMapping(value = "/pessoa")
	@ApiOperation(value="Realiza cadastro de uma pessoa")
	public ResponseEntity<Pessoa> save(@RequestBody @Valid PessoaResource pessoa) throws PessoaException {
		Pessoa newObj = service.cadastro(pessoa);
		return ResponseEntity.created(null).body(newObj);
	}

	@GetMapping(value = "/pessoas")
	@ApiOperation(value="Retorna lista de todas as pessoas cadastradas")
	public ResponseEntity<List<Pessoa>> findAll() {
		List<Pessoa> list = service.listar();
		return ResponseEntity.ok().body(list);
	}

}
