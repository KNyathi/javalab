import java.util.regex.*;

public class exercise2 {
    public static void main(String[] args) {
        String password = "YourPassword"; // Replace with the entered password

        try {
            validatePassword(password);
            System.out.println("Password is valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Password is invalid: " + e.getMessage());
        }
    }

    public static void validatePassword(String password) {
        // Check if the password has at least one uppercase letter
        if (!password.matches(".[A-Z].")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }

        // Check if the password has at least one digit
        if (!password.matches(".\\d.")) {
            throw new IllegalArgumentException("Password must contain at least one digit.");
        }

        // Check if the password length is between 8 and 16 characters
        if (password.length() < 8 || password.length() > 16) {
            throw new IllegalArgumentException("Password length must be between 8 and 16 characters.");
        }

        // Check if the password contains special characters
        if (password.matches(".[^A-Za-z\\d].")) {
            throw new IllegalArgumentException("Password cannot contain special characters.");
        }
    }
}
