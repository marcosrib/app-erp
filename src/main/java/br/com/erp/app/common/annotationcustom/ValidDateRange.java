package br.com.erp.app.common.annotationcustom;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@ReportAsSingleViolation
public @interface ValidDateRange {
    String message() default "A data inicial deve ser menor ou igual à data final";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String startDateField();
    String endDateField();
}