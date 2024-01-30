package iegcode.validation;

import org.junit.jupiter.api.Test;

public class ClassLevelValidationTest extends  AbstractValidatorTest{

    @Test
    void testClassLevel() {

        Register register = new Register();
        register.setUsername("Gibran");
        register.setPassword("rahasia"); // kalo password sama tidak terjadi error
        register.setRetypePassword("rahasia123");

        validate(register);
    }
}
