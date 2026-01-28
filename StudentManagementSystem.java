import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String id;
    int age;
    int marks;

    static {
        System.out.println("Welcome to Student Management System");
    }

    Student(String name, String id, int age, int marks) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.marks = marks;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                // ADD STUDENT
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Student Marks: ");
                    int marks = Integer.parseInt(sc.nextLine());

                    students.add(new Student(name, id, age, marks));
                    System.out.println("Student added successfully!");
                    break;

                // DISPLAY STUDENTS
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            s.displayDetails();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                // UPDATE STUDENT MARKS
                case 3:
                    System.out.print("Enter Student ID to update marks: ");
                    String searchId = sc.nextLine();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.id.equals(searchId)) {
                            System.out.print("Enter new marks: ");
                            s.marks = Integer.parseInt(sc.nextLine());
                            System.out.println("Marks updated successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student ID not found.");
                    }
                    break;

                // EXIT
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
