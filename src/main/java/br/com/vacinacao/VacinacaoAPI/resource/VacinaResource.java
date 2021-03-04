package br.com.vacinacao.VacinacaoAPI.resource;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VacinaResource {

	@JsonProperty("nome_vacina")

	@NotBlank(message = "{name_vacina.not.blank}")
	private String nome;

	@JsonProperty("data_aplicacao")
	@NotBlank(message = "{data_vacina.not.blank}")
	private String dataAplicacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(String dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

}
