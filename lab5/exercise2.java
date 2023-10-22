import java.util.regex.*;

public class exercise2 {
    public static boolean isPasswordValid(String password) {
        boolean lengthCondition = password.length() >= 8 && password.length() <= 16;
        boolean uppercaseCondition = password.matches(".*[A-Z].*");
        boolean digitCondition = password.matches(".*\\d.*");

        try {
            if (!lengthCondition) {
                throw new Exception("Password must be between 8 and 16 characters long.");
            }
            if (!uppercaseCondition) {
                throw new Exception("Password must contain at least one uppercase letter.");
            }
            if (!digitCondition) {
                throw new Exception("Password must contain at least one digit.");
            }

            return true; // Password is valid
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false; // Password is invalid
        }
    }

    public static void main(String[] args) {
        String password = "YourPassword123HHHHHH";

        if (isPasswordValid(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}
