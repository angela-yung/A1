package as1;

import java.util.Scanner;

/**
 * TextUI class models a text user interface. Data includes
 * a menu of options with which a user can interact. It
 * supports reading in user input from the console.
 */
public class TextUI {
    private boolean terminate;
    private int userChoice;

    public TextUI() {
        terminate = false;
        userChoice = 0;
    }
    public void start() {
        System.out.println("***************************************\n"
                + "Welcome to the Evil Minion Tracker (tm)\nby Angela.\n +"
                + "***************************************\n");

        menu();
    }

    private void menu() {
        while (terminate == false) {
            System.out.println("*************\n" + "* Main Menu *\n"
                + "*************" + "1. List minions\n" + "2. Add a new minion\n"
                + "3. Remove a minion\n" + "4. Attribute evil deed to a minion\n"
                + "5. DEBUG: Dump objects (toString)\n" + "6. Exit\n");

            userChoice = getUserChoice();

        }
    }

    private int getUserChoice() {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 6: ");
        while (loop) {
            userChoice = scanner.nextInt();
            if (userChoice < 0 || userChoice > 6) {
                System.out.println("Error: Please enter a selection between 1 and 6");
            } else {
                loop = false;
            }
        }
        return userChoice;
    }
}
