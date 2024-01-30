package iegcode.validation;

import iegcode.validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidatorTest{

    @Test
    void testComposition() {

        Payment payment = new Payment();
        payment.setOrderId("29852309850238529589akjkjdsak");

        validateWithGroups(payment, CreditCardPaymentGroup.class);

    }
}