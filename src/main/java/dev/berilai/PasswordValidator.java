package dev.berilai;

import dev.berilai.exceptions.InvalidPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {

        try {

            if (password.length() < 8 || password.length() > 16) {
                throw new InvalidPasswordException("Password length must be between 8 and 16 characters.");
            }

            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9]{8,16}$");
            Matcher matcher = pattern.matcher(password);

            if (!matcher.matches()) {
                throw new InvalidPasswordException("Password must contain only letters and numbers, at least one uppercase letter, and at least one digit.");
            }

            return true;
        } catch (InvalidPasswordException e) {
            System.err.println("Password validation failed: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {

        String password = "password123";

        if (isValidPassword(password)) {
            System.out.println(password + " - Valid");
        }
    }
}
