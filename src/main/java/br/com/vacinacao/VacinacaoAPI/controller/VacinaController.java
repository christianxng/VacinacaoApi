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

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class VacinaController {

	@Autowired
	private VacinaService service;

	@PostMapping(value = "/vacina/pessoa/{id}")
	public ResponseEntity<Vacina> save(@PathVariable("id") Long id, @RequestBody @Valid VacinaResource vacina)
			throws VacinaException {
		Vacina newObj = service.cadastro(id, vacina);
		return ResponseEntity.created(null).body(newObj);
	}

	@GetMapping(value = "/vacinas")
	public ResponseEntity<List<Vacina>> findAll() {
		List<Vacina> list = service.listar();
		return ResponseEntity.ok().body(list);
	}

}
