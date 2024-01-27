package iegcode.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;

import java.util.Set;

public class ConstraintViolationTest {

    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testValidationFieldNotBlank() {

        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean()); // objectnya apa sih?
            System.out.println("Annotation : " + violation.getConstraintDescriptor().getAnnotation()); // mendapatkan annotation descripnya apa
            System.out.println("Invalid Value : " + violation.getInvalidValue()); // invalid valeunya apa
            System.out.println("Path : " + violation.getPropertyPath()); // pathnya apa
        }
    }

    @Test
    void testValidationFieldSize() {

        Person person = new Person();
        person.setFirstName("Ibarhimmmmmmmmmmmmmmm");
        person.setLastName("Gibrannnnnnnnnnnnnnnnnn");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean()); // objectnya apa sih?
            System.out.println("Annotation : " + violation.getConstraintDescriptor().getAnnotation()); // mendapatkan annotation descripnya apa
            System.out.println("Invalid Value : " + violation.getInvalidValue()); // invalid valeunya apa
            System.out.println("Path : " + violation.getPropertyPath()); // pathnya apa
        }
    }

    @Test
    void testValidationFieldSuccess() {

        Person person = new Person();
        person.setFirstName("Ibrahim");
        person.setLastName("Gibran");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(0, violations.size());
    }
}
