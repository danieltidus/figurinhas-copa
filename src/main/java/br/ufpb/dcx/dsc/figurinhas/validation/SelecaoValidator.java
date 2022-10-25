package br.ufpb.dcx.dsc.figurinhas.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SelecaoValidator implements ConstraintValidator<Selecao, String>{

    private List<String> selecoes = Arrays.asList("Brasil", "França");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (String selecao: selecoes
             ) {
            if(selecao.compareTo(s) == 0)
                return true;
        }
        return false;
    }
}
