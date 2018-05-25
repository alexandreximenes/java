package br.alexandre.livraria.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.alexandre.livraria.models.Produto;

public class ProdutoValidation implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

//		Produto produto = (Produto) produto;
//		if (produto.getPaginas() <= 0) {
//			errors.rejectValue("paginas", "field.required");
//		}

	}
}
