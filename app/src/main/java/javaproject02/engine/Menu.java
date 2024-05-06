package javaproject02.engine;

import java.util.Scanner;

/**
 * Singleton used to ask the user a question and return an answer
 */
public class Menu {
    private Scanner scanner;
    private static Menu instance;

    private Menu() {
        scanner = new Scanner(System.in);
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        } 
        return instance;
    }

    /**
     * Prints and indexed list of options to select from
     * @param options list of options to select from
     */
    public void displayOptions(String[] options) {
        System.out.println("Select an option: ");
        for(int i=0;i<options.length;++i) {
            System.out.println(i+1 + ". " + options[i]);
        }
    }

    /**
     * Gets a number from the user between 1 and max (inclusive)
     * @param max maximum number to accept
     * @return the user's choice
     */
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

    /**
     * Give the user a list of options and returns what they choose
     * @param options list of options
     * @return the index of the option they chose
     */
    public int ask(String[] options) {
        displayOptions(options);
        return getValidChoice(options.length)-1;
    }


}
