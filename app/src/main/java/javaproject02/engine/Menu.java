package javaproject02.engine;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Menu instance;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        } 
        return instance;
    }

    public void displayOptions(String[] options) {
        System.out.println("Select an option: ");
        for(int i=0;i<options.length;++i) {
            System.out.println(i+1 + ". " + options[i]);
        }
    }

    public int getValidChoice(int max) {
        int choice = -1;
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > max) {
                    System.out.println("Invalid choice, please enter a number within the range");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice, please enter a number");
            }
        }

        return choice;
    }

    public int ask(String[] options) {
        displayOptions(options);
        return getValidChoice(options.length);
    }


}
