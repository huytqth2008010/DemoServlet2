package com.example.DemoServlet2.demoAuthentication;

import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
        AuthenticationService authenticationService;

        int choice = 0;

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Chọn phương thức login: ");
            System.out.println("1. Sử dụng username, password.");
            System.out.println("2. Sử dụng google.");
            System.out.println("3. Sử dụng facebook.");
            System.out.println("Vui lòng nhập lựa chọn.");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    authenticationService = new DatabaseAuthenticationService();
                    break;
                case 2:
                    authenticationService = new GoogleAuthenticationService();
                    break;
                case 3:
                    authenticationService = new FacebookAuthenticationService();
                    break;
                default:
                    authenticationService = new DatabaseAuthenticationService();
                    break;
            }
            authenticationService.register(null);
        }

    }
}
