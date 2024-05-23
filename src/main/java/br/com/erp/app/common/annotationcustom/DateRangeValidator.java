package br.com.erp.app.common.annotationcustom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Method;
import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, Object> {

    private String startDateField;
    private String endDateField;

    @Override
    public void initialize(ValidDateRange constraintAnnotation) {
        startDateField = constraintAnnotation.startDateField();
        endDateField = constraintAnnotation.endDateField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {

        String startDate = getValueOfDateMethod(object, this.startDateField);
        String endDate = getValueOfDateMethod(object, this.endDateField);

        if (startDate == null || endDate == null) {
            return true;
        }

        return !LocalDate.parse(startDate).isAfter(LocalDate.parse(endDate));
    }

    private String getValueOfDateMethod(Object object, String methodName) {
        try {
            Method method = object.getClass().getMethod(methodName);
            var date = method.invoke(object);
            return date.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
