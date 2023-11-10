package unit_test.validate;

import static org.junit.Assert.*;
import org.junit.Test;

import validation.Validate;

public class ValidateTest {

    @Test
    public void testPositiveInteger() {
        assertEquals("", Validate.validateInteger("5", "TestParam"));
    }

    @Test
    public void testNegativeInteger() {
        assertEquals("TestParam must be a positive integer.", Validate.validateInteger("-5", "TestParam"));
    }

    @Test
    public void testZero() {
        assertEquals("TestParam must be a positive integer.", Validate.validateInteger("0", "TestParam"));
    }

    @Test
    public void testNonInteger() {
        assertEquals("TestParam must be an integer.", Validate.validateInteger("abc", "TestParam"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("TestParam must be an integer.", Validate.validateInteger("", "TestParam"));
    }

    @Test
    public void testLargeInteger() {
        assertEquals("", Validate.validateInteger("9999999", "TestParam"));
    }
}
