import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // Add student
    public boolean addStudent(Student student) {

        if (findStudent(student.getId()) != null) {
            return false;
        }

        students.add(student);
        return true;
    }

    // Find student by ID
    public Student findStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Update student
    public boolean updateStudent(int id, String course, double marks) {

        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        student.setCourse(course);
        student.setMarks(marks);

        return true;
    }

    // Delete student
    public boolean deleteStudent(int id) {

        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

    // Search student
    public Student searchStudent(int id) {
        return findStudent(id);
    }

    // Display all students
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }
}