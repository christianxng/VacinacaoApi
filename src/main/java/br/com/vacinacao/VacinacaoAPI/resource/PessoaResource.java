package br.com.vacinacao.VacinacaoAPI.resource;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PessoaResource {

	@JsonProperty("nome")
	@NotBlank(message = "{name.not.blank}")
	private String nome;

	@JsonProperty("email")
	@NotBlank(message = "{email.not.blank}")
	@Email(message = "{email.not.valid}")
	private String email;

	@JsonProperty("cpf")
	@NotBlank(message = "{cpf.not.blank}")
	@CPF(message = "{cpf.not.valid}")
	private String cpf;

	@JsonProperty("data_nascimento")
	@NotBlank(message = "data.not.blank")
	private String dataNascimento;

	@JsonProperty("vacinas")
	private List<VacinaResource> vacinas;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<VacinaResource> getVacinas() {
		return vacinas;
	}

}
