package br.com.vacinacao.VacinacaoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vacinacao.VacinacaoAPI.exception.PessoaException;
import br.com.vacinacao.VacinacaoAPI.exception.response.CpfExistenteException;
import br.com.vacinacao.VacinacaoAPI.exception.response.EmailExistenteException;
import br.com.vacinacao.VacinacaoAPI.exception.response.ObjectNotFoundException;
import br.com.vacinacao.VacinacaoAPI.model.Pessoa;
import br.com.vacinacao.VacinacaoAPI.repository.PessoaRepository;
import br.com.vacinacao.VacinacaoAPI.resource.PessoaConversor;
import br.com.vacinacao.VacinacaoAPI.resource.PessoaResource;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private PessoaConversor pessoaConversor;

	public Pessoa cadastro(PessoaResource pessoaResource) throws PessoaException {

		Pessoa pessoa = pessoaConversor.conversor(pessoaResource);
		if (this.ExisteEmail(pessoa.getEmail())) {
			System.out.println(this.ExisteEmail(pessoa.getEmail()));
			throw new EmailExistenteException("Email já utilizado, por favor escolha outro");
		} else if (this.ExisteCPF(pessoa.getCpf())) {
			throw new CpfExistenteException("Falha ao cadastrar, CPF existente.");
		}
		return repository.saveAndFlush(pessoa);
	}

	public List<Pessoa> listar() {
		return repository.findAll();
	}

	public Pessoa findById(long id) {
		Optional<Pessoa> pessoOp = repository.findById(id);
		return pessoOp.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada com o ID: " + id));
	}

	public Boolean ExisteEmail(String email) {
		Pessoa pessoOp = repository.findByEmail(email);
		if (pessoOp == null) {
			return false;
		}
		return true;
	}

	public Boolean ExisteCPF(String CPF) {
		Pessoa pessoOp = repository.findByCPF(CPF);
		if (pessoOp == null) {
			return false;
		}
		return true;
	}
}
