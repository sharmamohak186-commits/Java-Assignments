package ass6.q1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File source = new File("source.txt"); File destination = new File("destination.txt");
        try (FileOutputStream output = new FileOutputStream(source); FileInputStream input = new FileInputStream(source); FileOutputStream copy = new FileOutputStream(destination)) {
            output.write("Java file handling demonstration.".getBytes()); output.flush();
            int value; while ((value = input.read()) != -1) copy.write(value);
            System.out.println("Copied " + source.getName() + " to " + destination.getName());
        } catch (IOException exception) { System.out.println("File error: " + exception.getMessage()); }
    }
}
