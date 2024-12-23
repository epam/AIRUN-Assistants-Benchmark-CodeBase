package com.aicode.java;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordValidator {

    // Regular expression for a strong password
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
