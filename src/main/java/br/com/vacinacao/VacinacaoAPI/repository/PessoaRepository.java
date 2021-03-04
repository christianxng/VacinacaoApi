package br.com.vacinacao.VacinacaoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.vacinacao.VacinacaoAPI.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("select u from Pessoa u  where u.email like :email ")
	Pessoa findByEmail(String email);

	@Query("select u from Pessoa u  where u.cpf like :cpf ")
	Pessoa findByCPF(String cpf);

}
