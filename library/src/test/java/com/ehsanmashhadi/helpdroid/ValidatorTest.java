package com.ehsanmashhadi.helpdroid;

import org.junit.Assert;
import org.junit.Test;

import com.ehsanmashhadi.helpdroid.validation.Validator;

/**
 * Created by mysterious on 9/16/17.
 */

public class ValidatorTest {

    @Test
    public void phoneRight() {

        Assert.assertTrue(Validator.isPhoneValid("9377426996"));
    }

    @Test
    public void phoneWrong() {

        Assert.assertFalse(Validator.isPhoneValid("09377426996"));
    }

    @Test
    public void emailRight() {

        Assert.assertTrue(Validator.isEmailValid("test@carrene.com"));
    }

    @Test
    public void emailWrong() {

        Assert.assertFalse(Validator.isEmailValid("test@"));
    }

    @Test
    public void passwordRight() {

        Assert.assertTrue(Validator.isPasswordValid("Password123@"));
    }

    @Test
    public void passwordWrong() {

        Assert.assertFalse(Validator.isPasswordValid("123456"));
    }

    @Test
    public void passwordWrong1() {

        Assert.assertFalse(Validator.isPasswordValid("Ehsan123"));
    }

    @Test
    public void passwordWrong2() {

        Assert.assertFalse(Validator.isPasswordValid("ehsan123@"));
    }

}
