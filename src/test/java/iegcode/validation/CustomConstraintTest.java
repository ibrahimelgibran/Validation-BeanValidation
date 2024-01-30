package iegcode.validation;

import iegcode.validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class CustomConstraintTest  extends  AbstractValidatorTest{

    @Test
    void testCustomConstraint() {

        Payment payment = new Payment();
        payment.setOrderId("GIBRAN");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
