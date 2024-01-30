package iegcode.validation;

import iegcode.validation.service.UserService;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidatorTest extends AbstractValidatorTest{

    @Test
    void testCrossParameter() throws NoSuchMethodException {

        UserService userService = new UserService();

        Method method = userService.getClass().getMethod("register", String.class, String.class, String.class);
        String username = "gibran";
        String password = "rahasia";
        String retypePassword = "rahasia";

        Set<ConstraintViolation<UserService>> violations = executableValidator
                .validateParameters(userService, method, new Object[]{
                        username, password, retypePassword
                });

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=======");
        }
    }
}
