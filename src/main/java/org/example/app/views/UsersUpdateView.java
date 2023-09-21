package org.example.app.views;

import java.util.Scanner;

public class UsersUpdateView {

    public String[] getData(){
        Scanner scanner = new Scanner(System.in);

        String title = "Enter user ID: ";
        System.out.println(title);
        String userID = scanner.nextLine().trim();

        title = "Enter your new email in format example@mail.com: ";
        System.out.println(title);
        String newEmail = scanner.nextLine().trim();

        return new String[]{userID, newEmail};

    }
    public void getOutput(String output){
        System.out.println(output);
    }
}
