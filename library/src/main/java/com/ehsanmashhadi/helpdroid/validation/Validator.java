package com.ehsanmashhadi.helpdroid.validation;

import java.util.Objects;

import androidx.annotation.NonNull;

/**
 * Created by mysterious on 9/15/17.
 */

public class Validator {

    public static boolean isEmailValid(@NonNull String email) {

        Objects.requireNonNull(email);
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return email.matches(regex);
    }

    public static boolean isPasswordValid(@NonNull String password) {

        Objects.requireNonNull(password);
        String passwordExpression = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(passwordExpression);
    }
}