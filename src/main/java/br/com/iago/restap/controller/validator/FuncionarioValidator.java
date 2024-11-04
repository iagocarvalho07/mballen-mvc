package br.com.iago.restap.controller.validator;

import java.time.LocalDate;

import br.com.iago.restap.domain.Funcionario;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Funcionario f = (Funcionario) object;
		
		LocalDate entrada = f.getDataEntrada();
		
		if (f.getDataSainda() != null) {
			if (f.getDataSainda().isBefore(entrada)) {
				errors.rejectValue("dataSainda", "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
	}

}
