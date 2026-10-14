public class Student extends Person {

    private int id;
    private String course;
    private double marks;

    // Constructor
    public Student(int id, String name, int age, String course, double marks) {
        super(name, age);
        this.id = id;
        this.course = course;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Display student details
    public void displayStudent() {
        System.out.println("--------------------------------");
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + getName());
        System.out.println("Age     : " + getAge());
        System.out.println("Course  : " + course);
        System.out.println("Marks   : " + marks);
        System.out.println("--------------------------------");
    }
}