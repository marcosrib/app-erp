package br.com.erp.app.common.annotationcustom;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfCnpjValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {

    String message() default "CPF ou CNPJ è inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}