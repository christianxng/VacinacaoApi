package br.com.vacinacao.VacinacaoAPI.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.com.vacinacao.VacinacaoAPI.exception.PessoaException;
import br.com.vacinacao.VacinacaoAPI.model.Pessoa;

@Component
public class PessoaConversor {

	public Pessoa conversor(PessoaResource pessoaResource) throws PessoaException {

		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(pessoaResource.getNome());
			pessoa.setEmail(pessoaResource.getEmail());
			pessoa.setCpf(pessoaResource.getCpf());
			pessoa.setDataNascimento(LocalDate.parse(pessoaResource.getDataNascimento(), formatter));

			return pessoa;

		} catch (Exception e) {

			throw new PessoaException("Falha ao converter o resouce pessoa para entidade: " + pessoaResource);
		}

	}
}
