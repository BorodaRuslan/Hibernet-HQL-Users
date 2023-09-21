package org.example.app.views;

import org.example.app.utils.Contstans;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {
    Scanner scanner;
    int option;

    public int chooseOption(){
       scanner = new Scanner(System.in);
       showMenu();
       try {
           option = scanner.nextInt();
       } catch (InputMismatchException ime){
           System.out.println(Contstans.INCORRECT_VALUE_MSG);

           // Тут должен быть "AppStarter" в который мы передаем "option"; -> С этого метода и будет запускаться программа
       }
       return option;
   }
   private void showMenu(){
        System.out.println("""
                 ______ MENU ___________
                1 - Create a user.
                2 - View users.
                3 - Update the user email number.
                4 - Delete user
                0 - Close the App.
                """);
    }

    public void getOutput(int choice, int output){
        if (choice == 0) System.out.println(output);
        scanner.close();
        System.exit(0);
    }



}
