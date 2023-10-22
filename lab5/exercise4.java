import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class exercise4 {
    public static void main(String[] args) {
        String ipAddress = "f.168.1.1"; // Replace this string with user input

        String result = validateIP(ipAddress);
        System.out.println(ipAddress + " is " + result);
    }

    public static String validateIP(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) {
            return "an Invalid IP address: IP must consist of exactly four parts.";
        }

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return "an Invalid IP address: Each part must be in the range 0-255.";
                }
            } catch (NumberFormatException e) {
                return "an Invalid IP address: Non-integer part detected.";
            }
        }

        String ipPattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ipAddress);

        if (!matcher.matches()) {
            return "an Invalid IP address: IP does not match the required pattern.";
        }

        return "a Valid IP address";
    }
}
