package iegcode.validation.constraint;

import iegcode.validation.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTamplate;
    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTamplate = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if (value.getPassword() == null || value.getRetypePassword() == null){
            return true;
        }

        boolean isValid = value.getPassword().equals(value.getRetypePassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTamplate)
                    .addPropertyNode("password")
                    .addConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTamplate)
                    .addPropertyNode("retypePassword")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
