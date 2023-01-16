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
                + "Welcome to the Evil Minion Tracker (tm)\nby Angela.\n"
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
            boolean enteringSelection = true;
            int minionNumber = 0;       // The number corresponding to the minion on menu

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
                    while (enteringSelection) {
                        minionNumber = scanner.nextInt();
                        if (minionNumber > 0 && minionNumber <= minionList.getListSize()) {
                            minionList.removeMinion(minionNumber);
                            enteringSelection = false;
                        } else if (minionNumber == 0) {
                            enteringSelection = false;
                        }
                        else {
                            int minMenuOption = 1;
                            int maxMenuOption = minionList.getListSize();
                            if (maxMenuOption == 0) {    // Menu only has option 0 to cancel
                                minMenuOption = 0;
                            }
                            System.out.println("Error: Please enter a selection between " + minMenuOption
                                    + " and " + maxMenuOption);
                        }
                    }
                    break;
                case 4: menuOption = 4;
                    minionList.printMinionList();
                    System.out.println("(Enter 0 to cancel)");
                    while (enteringSelection) {
                        minionNumber = scanner.nextInt();
                        if (minionNumber > 0 && minionNumber <= minionList.getListSize()) {
                            minionList.addEvilDeed(minionNumber);
                            enteringSelection = false;
                        } else if (minionNumber == 0) {
                            enteringSelection = false;
                        } else {
                            int minMenuOption = 1;
                            int maxMenuOption = minionList.getListSize();
                            if (maxMenuOption == 0) {    // Menu only has option 0 to cancel
                                minMenuOption = 0;
                            }
                            System.out.println("Error: Please enter a selection between " + minMenuOption
                                    + " and " + maxMenuOption);
                        }
                    }
                    break;
                case 5: menuOption = 5;
                    minionList.debug();
                    break;
                case 6: menuOption = 6;
                    openMenu = false;
                    break;
                default:
                    assert false;

            }
        }
    }

    private void displayMenu() {
        System.out.println("\n*************\n" + "* Main Menu *\n"
                + "*************\n" + "1. List minions\n" + "2. Add a new minion\n"
                + "3. Remove a minion\n" + "4. Attribute evil deed to a minion\n"
                + "5. DEBUG: Dump objects (toString)\n" + "6. Exit");
    }

    private int getMenuOption() {
        int menuOption = 0;
        Scanner scanner = new Scanner(System.in);
        boolean enteringOption = true;
        while (enteringOption) {
            menuOption = scanner.nextInt();
            if (menuOption > 0 && menuOption < 7) {
                enteringOption = false;
            } else {
                System.out.println("Error: Please enter a selection between 1 and 6");
            }
        }
        return menuOption;
    }

    private String getMinionName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minion's name:    ");
        String minionName;
        minionName = scanner.nextLine();
        boolean enteringName = true;
        while (enteringName) {
            if (minionName.length() < 1) {
                System.out.println("ERROR: Name must be at least 1 character long.\n");
                System.out.print("Enter minion's name:    ");
                minionName = scanner.nextLine();
            } else {
                enteringName = false;
            }
        }
        return minionName;
    }

    private double getMinionHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minion's height:  ");
        double minionHeight = 0;
        boolean enteringHeight = true;
        while (enteringHeight) {
            minionHeight = scanner.nextDouble();
            if (minionHeight < 0) {
                System.out.println("ERROR: Height must be >= 0.");
                System.out.print("Enter minion's height: ");
            } else {
                enteringHeight = false;
            }
        }
        return minionHeight;
    }

}
