package com.jenkinsunittest;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hari Prasad on 3/17/17.
 */
@RunWith(JUnit4ClassRunner.class)
public class SignInActivityTest {
    private EmailValidator myEmailValidator;
    private PasswordValidator mypasswordValidator;

    @Before
    public void setUp() throws Exception {
        myEmailValidator = new EmailValidator();
        mypasswordValidator = new PasswordValidator();
    }

    //    email
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() throws Exception {
        assertTrue(myEmailValidator.isValidEmail("name@email.com"));
    }

    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() throws Exception {
        assertTrue(myEmailValidator.isValidEmail("name@email.co.uk"));
    }

    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() throws Exception {
        assertFalse(myEmailValidator.isValidEmail("name@email"));
    }

    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() throws Exception {
        assertFalse(myEmailValidator.isValidEmail("name@email..com"));
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() throws Exception {
        assertFalse(myEmailValidator.isValidEmail("@email.com"));
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() throws Exception {
        assertFalse(myEmailValidator.isValidEmail(""));
    }

    @Test
    public void emailValidator_NullEmail_ReturnsFalse() throws Exception {
        assertTrue(myEmailValidator.isValidEmail(null));
    }

    //     password
    @Test
    public void paaswordValidator_CorrectPasswordSimple_ReturnsTrue() throws Exception {
        assertTrue(mypasswordValidator.isValidPassword("Ramesh@123"));
    }

    @Test
    public void passwordValidator_CorrectPassword_ReturnsTrue() throws Exception {
        assertTrue(mypasswordValidator.isValidPassword("raMesh123@"));
    }

    @Test
    public void passwordValidator_EmptyString_ReturnsFalse() throws Exception {
        assertFalse(mypasswordValidator.isValidPassword(""));
    }

    @Test
    public void passwordValidator_NullPassword_ReturnsFalse() throws Exception {
        assertFalse(mypasswordValidator.isValidPassword(null));
    }

    @Test
    public void passwordValidator_InvalidPasswordNoCapital_ReturnsFalse() throws Exception {
        assertFalse(mypasswordValidator.isValidPassword("mkyong12@"));
    }

    @Test
    public void passwordValidator_InvalidPasswordNoSmall_ReturnsFalse() throws Exception {
        assertFalse(mypasswordValidator.isValidPassword("MKYONG12@"));
    }

    @Test
    public void passwordValidator_InvalidPasswordNotAllowSymbol_ReturnsFalse() throws Exception {
        assertFalse(mypasswordValidator.isValidPassword("mkyoNg12*"));
    }

    @Test
    public void passwordValidator_InvalidPasswordToShort_ReturnsFalse() throws Exception {
        assertFalse(mypasswordValidator.isValidPassword("mY1A@"));
    }

    @Test
    public void passwordValidator_InvalidPasswordNoSymbol_ReturnsFalse() throws Exception {
        assertFalse(mypasswordValidator.isValidPassword("MKYONgx12"));
    }

    @Test
    public void passwordValidator_InvalidPasswordDigitRequired_ReturnsFalse() throws Exception {
        assertTrue(mypasswordValidator.isValidPassword("mkyonG$$"));
    }
}