package com.pogodin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReformatPhoneNumberTest {
    @Test
    public void testExample1() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("1-23-45 6");
        assertEquals("123-456", result);
    }

    @Test
    public void testExample2() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("123 4-567");
        assertEquals("123-45-67", result);
    }

    @Test
    public void testExample3() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("123 4-5678");
        assertEquals("123-456-78", result);
    }

    @Test
    public void testOnlyDigits() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("123456789");
        assertEquals("123-456-789", result);
    }

    @Test
    public void testWithMultipleSpaces() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("  12 345 678 9  ");
        assertEquals("123-456-789", result);
    }

    @Test
    public void testWithMultipleDashes() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("--123---456---78");
        assertEquals("123-456-78", result);
    }

    @Test
    public void testWithSpacesAndDashes() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("12-3 45- 67--89");
        assertEquals("123-456-789", result);
    }

    @Test
    public void testTwoDigits() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("12");
        assertEquals("12", result);
    }

    @Test
    public void testThreeDigits() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("123");
        assertEquals("123", result);
    }

    @Test
    public void testFourDigits() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("1234");
        assertEquals("12-34", result);
    }

    @Test
    public void testMaxLength() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String longNumber = "1234567890".repeat(10); // 100 digits
        String expected = "123-456-789-012-345-678-901-234-567-890-123-456-789-012-345-678-901-234-567-890-123-456-789-012-345-678-901-234-567-890-123-456-78-90";
        String result = rpn.reformatNumber(longNumber);
        assertEquals(expected, result);
    }

    @Test
    public void testMixedWithNonDigitCharacters() {
        ReformatPhoneNumber rpn = new ReformatPhoneNumber();
        String result = rpn.reformatNumber("-1-2 3 4---5--6");
        assertEquals("123-456", result);
    }
}