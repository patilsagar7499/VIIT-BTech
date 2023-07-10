import java.io.*;

public class Assignment7 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";
        
        while (!choice.equals("3")) {
            System.out.println("Choose an option:");
            System.out.println("1. Add student");
            System.out.println("2. Display students");
            System.out.println("3. Quit");
            try {
                choice = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error reading input.");
                continue;
            }
            
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    displayStudents();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
    
    private static void addStudent() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rollNumber = "";
        String name = "";
        String gradeNumber = "";
        String className = "";
        
        try {
            System.out.print("Enter roll number: ");
            rollNumber = reader.readLine();
            System.out.print("Enter name: ");
            name = reader.readLine();
            System.out.print("Enter grade number: ");
            gradeNumber = reader.readLine();
            System.out.print("Enter class name: ");
            className = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading input.");
            return;
        }
        
        String studentString = rollNumber + "," + name + "," + gradeNumber + "," + className;
        BufferedWriter writer = null;
        
        try {
            writer = new BufferedWriter(new FileWriter("students.txt", true));
            writer.write(studentString);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
        
        System.out.println("Student added.");
    }
    
    private static void displayStudents() {
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader("students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentArray = line.split(",");
                System.out.println("Roll Number: " + studentArray[0]);
                System.out.println("Name: " + studentArray[1]);
                System.out.println("Grade Number: " + studentArray[2]);
                System.out.println("Class: " + studentArray[3]);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
    
}
