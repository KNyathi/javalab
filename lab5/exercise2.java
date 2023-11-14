import java.util.regex.*;

public class exercise2 {
    public static boolean isPasswordValid(String password) {
       // boolean lengthCondition = password.length() >= 8 && password.length() <= 16;
        //boolean uppercaseCondition = password.matches(".*[A-Z].*");
        //boolean digitCondition = password.matches(".*\\d.*");

//
	boolean regex = password.matches("^(?=.*[A-Z])(?=.*\\d).{8,16}$");
	
        try {
            if (!regex) {
                throw new Exception("Password must be between 8 and 16 characters long, contain at least one uppercase letter, and at least one digit.");
            }
           
            return true; // Password is valid
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false; // Password is invalid
        }
    }

    public static void main(String[] args) {
        String password = "Yourassword123";

        if (isPasswordValid(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}


