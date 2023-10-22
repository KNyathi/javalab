import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // Define the names of the source and target files
        String sourceFileName = "source.txt"; // Name of the source file
        String targetFileName = "target.txt"; // Name of the target file
        
        FileInputStream fis = null;
	FileOutputStream fos = null;

        try {
            // Open the source file for reading and the target file for writing
            fis = new FileInputStream(sourceFileName);
            fos = new FileOutputStream(targetFileName);

            // Create a buffer to read and write data
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read from the source file and write to the target file using the buffer
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            // Inform the user that the file has been copied successfully
            System.out.println("File copied successfully!");
        } catch (FileNotFoundException e) {
            // Handle the case where the source file is not found
            System.err.println("Error: File not found");
        } catch (IOException e) {
            // Handle other I/O errors that may occur during the process
            System.err.println("Error: An I/O error occurred");
        } finally {
            try {
                // Close the input and output streams in a finally block to ensure resources are released
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                // Handle any errors that occur during closing the streams
                System.err.println("Error: An I/O error occurred while closing the streams");
            }
        }
    }
}
