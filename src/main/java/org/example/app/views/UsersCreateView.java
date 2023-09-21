package org.example.app.views;

import java.util.Scanner;

public class UsersCreateView {
    Scanner scanner;

    public String [] getData(){
        scanner = new Scanner(System.in);

        String title = "Enter  user name: ";
        System.out.println(title);
        String userName = scanner.nextLine().trim();

        title = "Enter first name: ";
        System.out.println(title);
        String firstName = scanner.nextLine().trim();

        title = "Enter last name: ";
        System.out.println(title);
        String lastName = scanner.nextLine().trim();

        title = "Enter email in format example@mail.com: ";
        System.out.println(title);
        String email  = scanner.nextLine().trim();

        return new String[]{userName, firstName, lastName, email};

    }
    public void getOutput(String output) {
        System.out.println(output);
    }
}
