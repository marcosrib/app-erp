package br.com.erp.app.common.annotationcustom;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidator implements ConstraintValidator<IsEnum, String> {
    private Class<? extends Enum<?>> enumClass;
    private String excludeValue;

    @Override
    public void initialize(IsEnum annotation) {
        excludeValue = annotation.excludeValue();
        enumClass = annotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ("".equals(value) || value == null) {
            return true;
        }
        for (Enum<?> enumValue : enumClass.getEnumConstants()) {
            if (enumValue.name().equals(excludeValue)) continue;
            if (enumValue.name().equals(value)) {
                return true;
            }
        }

        return false;
    }

}
