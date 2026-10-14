import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static StudentManager manager = new StudentManager();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    manager.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-6.");
            }

        } while (choice != 6);

        scanner.close();
    }

    // Add student
    public static void addStudent() {

        System.out.println("\n--- Add Student ---");

        int id = readPositiveInt("Enter Student ID: ");

        if (manager.findStudent(id) != null) {
            System.out.println("Student with this ID already exists.");
            return;
        }

        String name = readName("Enter Student Name: ");

        int age = readAge();

        String course = readText("Enter Course: ");

        double marks = readMarks();

        Student student = new Student(
                id,
                name,
                age,
                course,
                marks
        );

        if (manager.addStudent(student)) {
            System.out.println("Student added successfully.");
        }
    }

    // Update student
    public static void updateStudent() {

        System.out.println("\n--- Update Student ---");

        int id = readPositiveInt("Enter Student ID: ");

        Student student = manager.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String course = readText("Enter New Course: ");

        double marks = readMarks();

        manager.updateStudent(id, course, marks);

        System.out.println("Student updated successfully.");
    }

    // Delete student
    public static void deleteStudent() {

        System.out.println("\n--- Delete Student ---");

        int id = readPositiveInt("Enter Student ID: ");

        if (manager.deleteStudent(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search student
    public static void searchStudent() {

        System.out.println("\n--- Search Student ---");

        int id = readPositiveInt("Enter Student ID: ");

        Student student = manager.searchStudent(id);

        if (student != null) {
            System.out.println("Student found:");
            student.displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }

    // Read integer safely
    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Positive integer
    public static int readPositiveInt(String message) {

        while (true) {

            int number = readInt(message);

            if (number > 0) {
                return number;
            }

            System.out.println("Number must be greater than 0.");
        }
    }

    // Read age
    public static int readAge() {

        while (true) {

            int age = readPositiveInt("Enter Age: ");

            if (age >= 16 && age <= 100) {
                return age;
            }

            System.out.println("Age must be between 16 and 100.");
        }
    }

    // Read marks
    public static double readMarks() {

        while (true) {

            try {

                System.out.print("Enter Marks (0-100): ");
                double marks = Double.parseDouble(scanner.nextLine());

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println("Marks must be between 0 and 100.");

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Read name
    public static String readName(String message) {

        while (true) {

            System.out.print(message);
            String name = scanner.nextLine().trim();

            if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                return name;
            }

            System.out.println("Please enter a valid name.");
        }
    }

    // Read normal text
    public static String readText(String message) {

        while (true) {

            System.out.print(message);
            String text = scanner.nextLine().trim();

            if (!text.isEmpty()) {
                return text;
            }

            System.out.println("This field cannot be empty.");
        }
    }
}