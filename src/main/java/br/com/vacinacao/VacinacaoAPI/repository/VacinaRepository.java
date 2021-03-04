package br.com.vacinacao.VacinacaoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vacinacao.VacinacaoAPI.model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {

}
