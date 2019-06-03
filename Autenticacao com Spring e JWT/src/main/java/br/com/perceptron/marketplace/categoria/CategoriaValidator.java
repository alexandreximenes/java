package br.com.perceptron.marketplace.categoria;

import br.com.perceptron.marketplace.response.ResponseErrorDetails;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static br.com.perceptron.marketplace.response.ResponseUtils.MSG_RETORNO;
import static br.com.perceptron.marketplace.response.ResponseUtils.NAO_PREENCHIDO;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Constraint(validatedBy = CategoriaVD.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoriaValidator {
    String message() default "Por favor preencha os campos ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class CategoriaVD implements ConstraintValidator<CategoriaValidator, CategoriaDTO> {

    @Override
    public boolean isValid(CategoriaDTO categoriaDTO, ConstraintValidatorContext context) {
        List<ResponseErrorDetails> responseErrorDetails = new ArrayList<>();

        if (nonNull(categoriaDTO)) {
            if (isNull(categoriaDTO.getId()) && isNull(categoriaDTO.getNome()))
                responseErrorDetails.add(new ResponseErrorDetails("nome", NAO_PREENCHIDO));
            if (nonNull(categoriaDTO.getNome()) && categoriaDTO.getNome().length() > 255)
                responseErrorDetails.add(new ResponseErrorDetails("nome", "Nome da categoria é muito grande, ultrapassou o limite de 255 caracteres" + MSG_RETORNO));
        }

        for (ResponseErrorDetails errorDetails : responseErrorDetails) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorDetails.getMessage())
                    .addPropertyNode(errorDetails.getField()).addConstraintViolation();
        }
        return responseErrorDetails.isEmpty();
    }
}
