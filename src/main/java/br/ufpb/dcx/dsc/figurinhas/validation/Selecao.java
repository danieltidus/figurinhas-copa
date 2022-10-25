package br.ufpb.dcx.dsc.figurinhas.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SelecaoValidator.class)
@Documented
public @interface Selecao {
    String message() default "{Selecao.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}