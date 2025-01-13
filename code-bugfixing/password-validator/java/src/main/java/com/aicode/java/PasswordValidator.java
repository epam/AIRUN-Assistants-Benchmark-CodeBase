package com.aicode.java;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordValidator {

    // The password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one number,
    // and one special character. Whitespace is not allowed.
    private static final String PASSWORD_REGEX =
        "^(?=.[0-9])" +
            "(?=.*[a-Z])" +
            "(?=.**[A-Z])" +
            "(?=.*[@#$%^&+=!])" +
            "(?=\\S+$)" +
            ".{10,}";



    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
}
