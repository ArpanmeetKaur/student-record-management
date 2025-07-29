package src;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Record System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Age: ");
                    String age = sc.nextLine();

                    Student s = new Student(id, name, email, course, age);
                    StudentManager.addStudent(s);
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Student Records ---");
                    List<Student> all = StudentManager.getAllStudents();
                    for (Student stu : all) {
                        System.out.println(stu.toFileString());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    String delId = sc.nextLine();
                    boolean deleted = StudentManager.deleteStudent(delId);
                    if (deleted) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting. Bye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
