import java.util.*;

class Student {
    String name;
    int rollNo;
    double marks;

    // Constructor
    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Getters
    public String getName() { return name; }
    public int getRollNo() { return rollNo; }
    public double getMarks() { return marks; }

    // Display student
    public void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo + ", Marks: " + marks);
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Delete Student\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: deleteStudent(); break;
                case 4: System.out.println("Exiting..."); System.exit(0);
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter roll no: ");
        int roll = sc.nextInt();
        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(name, roll, marks);
        studentList.add(s);
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if(studentList.isEmpty()) {
            System.out.println("No students.");
            return;
        }
        for(Student s : studentList) {
            s.display();
        }
    }

    static void deleteStudent() {
        System.out.print("Enter roll no to delete: ");
        int roll = sc.nextInt();

        boolean found = false;
        Iterator<Student> it = studentList.iterator();
        while(it.hasNext()) {
            Student s = it.next();
            if(s.getRollNo() == roll) {
                it.remove();
                found = true;
                System.out.println("Student deleted.");
                break;
            }
        }
        if(!found) System.out.println("Student not found.");
    }
}
