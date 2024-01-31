package iegcode.validation;

import iegcode.validation.extractor.DataIntegerValueExecutor;
import iegcode.validation.extractor.DataValueExtractor;
import iegcode.validation.extractor.EntryValueExtractorKey;
import iegcode.validation.extractor.EntryValueExtractorValue;
import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;
    protected Validator validator;

    protected ExecutableValidator executableValidator;

    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
       // validatorFactory = Validation.buildDefaultValidatorFactory();
        // registerasikan value extractornya
        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExecutor())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
        executableValidator = validator.forExecutables();
        messageInterpolator = validatorFactory.getMessageInterpolator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void validate(Object o){
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=======");
        }
    }
    void validateException(Object o){
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        if (!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    void validateWithGroups(Object o, Class<?>... groups){
        Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=======");
        }
    }
}
