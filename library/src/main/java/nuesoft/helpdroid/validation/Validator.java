package nuesoft.helpdroid.validation;

/**
 * Created by mysterious on 9/15/17.
 */

public class Validator {

    public static boolean isEmailValid(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        return email.matches(regex);
    }

    public static boolean isPhoneValid(String phone) {
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        return phone.matches(regex);
    }

    public static boolean isPasswordValid(String password) {
        String passwordExpression = "((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{8,})";
        return password.matches(passwordExpression);
    }
}