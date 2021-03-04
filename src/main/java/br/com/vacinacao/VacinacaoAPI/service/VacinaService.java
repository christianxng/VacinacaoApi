package br.com.vacinacao.VacinacaoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vacinacao.VacinacaoAPI.exception.VacinaException;
import br.com.vacinacao.VacinacaoAPI.model.Pessoa;
import br.com.vacinacao.VacinacaoAPI.model.Vacina;
import br.com.vacinacao.VacinacaoAPI.repository.VacinaRepository;
import br.com.vacinacao.VacinacaoAPI.resource.VacinaConversor;
import br.com.vacinacao.VacinacaoAPI.resource.VacinaResource;

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository repository;

	@Autowired
	private VacinaConversor conversor;

	@Autowired
	private PessoaService servicePessoa;

	public Vacina cadastro(Long id, VacinaResource vacinaResource) throws VacinaException {
		Optional<Pessoa> pessoa = Optional.ofNullable(servicePessoa.findById(id));
		Vacina vacina = conversor.conversor(vacinaResource);
		vacina.setPessoa(pessoa.get());
		return repository.saveAndFlush(vacina);

	}

	public List<Vacina> listar() {
		return repository.findAll();
	}
}
