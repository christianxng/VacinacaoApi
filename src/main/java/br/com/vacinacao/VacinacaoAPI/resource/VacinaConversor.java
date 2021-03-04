package br.com.vacinacao.VacinacaoAPI.resource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.com.vacinacao.VacinacaoAPI.exception.VacinaException;
import br.com.vacinacao.VacinacaoAPI.model.Vacina;

@Component
public class VacinaConversor {

	public Vacina conversor(VacinaResource vacinaResource) throws VacinaException {

		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			Vacina vacina = new Vacina();
			vacina.setNome(vacinaResource.getNome());
			vacina.setDataAplicacao(LocalDate.parse(vacinaResource.getDataAplicacao(), formatter));
			return vacina;

		} catch (Exception e) {

			throw new VacinaException("Falha ao converter o resouce Vacina para entidade: " + vacinaResource);
		}

	}

}
