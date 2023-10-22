import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ExceptionLogger {
    private String logFileName;

    public ExceptionLogger(String logFileName) {
        this.logFileName = logFileName;
    }

    public void logException(Exception e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFileName, true))) {
            writer.write("Exception occurred at: " + LocalDateTime.now());
            writer.newLine();
            writer.write("Exception: " + e.toString());
            writer.newLine();
            writer.write("Stack Trace:");
            writer.newLine();
            for (StackTraceElement element : e.getStackTrace()) {
                writer.write(element.toString());
                writer.newLine();
            }
            writer.write("------------------------------");
            writer.newLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
