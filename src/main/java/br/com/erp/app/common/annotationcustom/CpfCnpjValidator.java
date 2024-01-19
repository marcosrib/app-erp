package br.com.erp.app.common.annotationcustom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {

    @Override
    public void initialize(CpfCnpj constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cpfCnpj, ConstraintValidatorContext context) {
           return cpfCnpj != null && (cpfCnpj.matches("\\d{11}") || cpfCnpj.matches("\\d{14}"));
    }
}
