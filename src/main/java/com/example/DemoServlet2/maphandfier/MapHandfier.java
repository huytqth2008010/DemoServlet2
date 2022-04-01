package com.example.DemoServlet2.maphandfier;

import java.util.HashMap;
import java.util.Scanner;

public class MapHandfier {
    static HashMap<String, Student> data = new HashMap<>();

    public static void main(String[] args) {
        generateMenu();
    }

    private static void generateMenu() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Student Manager");
            System.out.println("------------------");
            System.out.println("1. Add new student.");
            System.out.println("2. Find student by rollNumber.");
            System.out.println("3. Exit");
            System.out.println("------------------");
            System.out.println("Please enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    findStudentByRollNumber();
                    break;
                case 3:
                    System.out.println("bye ");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Enter to continue.");
            sc.nextLine();
            if (choice == 3){
                System.exit(1);
            }
        }

    }

    private static void findStudentByRollNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rollNumber to find: ");
        String rollNumber = scanner.nextLine();
        if (!data.containsKey(rollNumber)){
                System.err.printf("Not found student with rollNumber %s\n", rollNumber);
                return;
        }
        Student found = data.get(rollNumber);
        System.out.println("Found student with below information : ");
        System.out.println(found.toString());

    }
    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter student rollNumber: ");
        String rollNumber = scanner.nextLine();
        System.out.println("Please enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter student email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter student phone: ");
        String phone = scanner.nextLine();
        int status = 1;
        Student student = new Student(rollNumber, name, email, phone);
        data.put(rollNumber, student);
        System.out.println("Action success !");
    }
}
