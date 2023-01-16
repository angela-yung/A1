package as1;

import java.util.Scanner;

/**
 * TextUI class models a text user interface. Data includes
 * a menu of options with which a user can interact. It
 * supports reading in user input from the console.
 */
public class TextUI {
    private MinionManager minionList;

    public TextUI(MinionManager minionList) {
        this.minionList = minionList;
    }
    public void start() {
        System.out.println("***************************************\n"
                + "Welcome to the Evil Minion Tracker (tm)\nby Angela.\n +"
                + "***************************************");

        menu();
    }

    private void menu() {
        boolean openMenu = true;
        while (openMenu) {
            displayMenu();
            int menuOption = 0;
            menuOption = getMenuOption();
            Scanner scanner = new Scanner(System.in);
            boolean continueLooping = true;

            switch (menuOption) {
                case 1: menuOption = 1;
                    minionList.printMinionList();
                    break;
                case 2: menuOption = 2;
                    String minionName = getMinionName();
                    double minionHeight = getMinionHeight();
                    minionList.addNewMinion(minionName, minionHeight);
                    break;
                case 3 : menuOption = 3;
                    minionList.printMinionList();
                    System.out.println("(Enter 0 to cancel)");
                    int minionToDelete = 0;

                    while (continueLooping) {
                        minionToDelete = scanner.nextInt();
                        if (minionToDelete < 0 || minionToDelete > minionList.getListSize()) {
                            System.out.println("Error: Please enter a selection between 1 and "
                                + minionList.getListSize());
                        } else {
                            continueLooping = false;
                        }
                    }
                    minionList.removeMinion(minionToDelete);
                    break;
                case 4: menuOption = 4;
                    minionList.printMinionList();
                    System.out.println("(Enter 0 to cancel)");
                    int minionChosenForEvilDeed = 0;

                    while (continueLooping) {
                        minionChosenForEvilDeed = scanner.nextInt();
                        if (minionChosenForEvilDeed < 0 || minionChosenForEvilDeed > minionList.getListSize()) {
                            System.out.println("Error: Please enter a selection between 1 and "
                                    + minionList.getListSize());
                        } else {
                            continueLooping = false;
                        }
                    }
                    minionList.addEvilDeed(minionChosenForEvilDeed);
                    break;
                case 5: menuOption = 5;
                    minionList.debug();
                case 6: menuOption = 6;
                    openMenu = false;
                    break;
                default:
                    System.out.println("Error: Please enter a selection between 1 and 6");

            }
        }
    }

    private void displayMenu() {
        System.out.println("*************\n" + "* Main Menu *\n"
                + "*************" + "1. List minions\n" + "2. Add a new minion\n"
                + "3. Remove a minion\n" + "4. Attribute evil deed to a minion\n"
                + "5. DEBUG: Dump objects (toString)\n" + "6. Exit");
    }

    private int getMenuOption() {
        int menuOption = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 6: ");
        menuOption = scanner.nextInt();
        return menuOption;
    }

    private String getMinionName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minion's name:    ");
        String minionName;
        minionName = scanner.nextLine();
        boolean looping = true;

        while (looping) {
            if (minionName.length() < 1) {
                System.out.println("ERROR: Name must be at least 1 character long.\n");
                System.out.println("Enter minion's name:    ");
                minionName = scanner.nextLine();
            } else {
                looping = false;
            }
        }
        return minionName;
    }

    private double getMinionHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter minion's height: ");
        double minionHeight = 0;
        minionHeight = scanner.nextInt();
        boolean looping = true;

        while (looping) {
            if (minionHeight < 0) {
                System.out.println("ERROR: Height must be >= 0.");
                System.out.println("Enter minion's height: ");
                minionHeight = scanner.nextInt();
            } else {
                looping = false;
            }
        }
        return minionHeight;
    }

}
