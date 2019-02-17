package com.ehsanmashhadi.helpdroid;

import com.ehsanmashhadi.helpdroid.validation.Validator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mysterious on 9/16/17.
 */

public class ValidatorTest {

    @Test
    public void testIsEmailValid_correctEmail() {

        Assert.assertTrue(Validator.isEmailValid("test@test.com"));
        Assert.assertTrue(Validator.isEmailValid("test1@test.com"));
    }

    @Test
    public void testIsEmailValid_wrongEmail() {

        Assert.assertFalse(Validator.isEmailValid("test@"));
        Assert.assertFalse(Validator.isEmailValid("test@test"));
        Assert.assertFalse(Validator.isEmailValid("test.com"));
        Assert.assertFalse(Validator.isEmailValid(".com"));
        Assert.assertFalse(Validator.isEmailValid("@.com"));
    }

    @Test
    public void testIsPasswordValid_correctPassword() {

        Assert.assertTrue(Validator.isPasswordValid("Password123@"));
    }

    @Test
    public void testIsPasswordValid_wrongPassword() {

        Assert.assertFalse(Validator.isPasswordValid("123456"));
        Assert.assertFalse(Validator.isPasswordValid("Ehsan123"));
        Assert.assertFalse(Validator.isPasswordValid("ehsan123@"));
    }
}
