package ass6.q2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File logFile = new File("application.log"); int errorCount = 0, warningCount = 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile))) {
            writer.write("INFO Application started\nWARNING Low memory\nERROR Database unavailable\nERROR Retry failed\n");
        } catch (IOException exception) { System.out.println("Write error: " + exception.getMessage()); return; }
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line; while ((line = reader.readLine()) != null) { if (line.contains("ERROR")) errorCount++; if (line.contains("WARNING")) warningCount++; }
            System.out.println("ERROR count: " + errorCount); System.out.println("WARNING count: " + warningCount);
        } catch (IOException exception) { System.out.println("Read error: " + exception.getMessage()); }
    }
}
