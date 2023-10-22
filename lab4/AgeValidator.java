public class AgeValidator {
    public static void main(String[] args) {
        ExceptionLogger logger = new ExceptionLogger("age_validation_exceptions.txt");

        try {
            int age = 20; // Replace with the age you want to check

            // Validate the age using CustomAgeException
            validateAge(age);

            System.out.println("Age is valid: " + age);
        } catch (CustomAgeException e) {
            logger.logException(e);
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void validateAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Age is invalid. Please enter an age between 0 and 120.");
        }
    }
}
