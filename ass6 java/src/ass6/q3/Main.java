package ass6.q3;

import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int employeeId; private final String name, department;
    Employee(int employeeId, String name, String department) { this.employeeId = employeeId; this.name = name; this.department = department; }
    public String toString() { return employeeId + " | " + name + " | " + department; }
}

public class Main {
    public static void main(String[] args) {
        File file = new File("employees.ser");
        Employee[] employees = {new Employee(101, "Asha", "Engineering"), new Employee(102, "Ravi", "Finance")};
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) { output.writeObject(employees); }
        catch (IOException exception) { System.out.println("Serialization error: " + exception.getMessage()); return; }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            Employee[] restored = (Employee[]) input.readObject(); for (Employee employee : restored) System.out.println(employee);
        } catch (IOException | ClassNotFoundException exception) { System.out.println("Deserialization error: " + exception.getMessage()); }
    }
}
