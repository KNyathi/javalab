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
        try {
            if (!password.matches(".[A-Z].")) {
                throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
            }

            if (!password.matches(".\\d.")) {
                throw new IllegalArgumentException("Password must contain at least one digit.");
            }

            if (password.length() < 8 || password.length() > 16) {
                throw new IllegalArgumentException("Password length must be between 8 and 16 characters.");
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
