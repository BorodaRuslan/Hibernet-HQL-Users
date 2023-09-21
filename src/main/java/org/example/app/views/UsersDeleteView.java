package org.example.app.views;

import java.util.Scanner;

public class UsersDeleteView {
    public String [] getData(){
        Scanner scanner = new Scanner(System.in);
        String title = "Enter user ID: ";
        System.out.println(title);
        String id = scanner.nextLine().trim();

        return new String[]{id};
    }
    public void getOutput(String output) {
        System.out.println(output);
    }
}
