import as1.MinionManager;

import java.util.Scanner;

public class Menu {
    public void displayMenu() {
        System.out.println("\n*************\n" + "* Main Menu *\n"
                + "*************\n" + "1. List minions\n" + "2. Add a new minion\n"
                + "3. Remove a minion\n" + "4. Attribute evil deed to a minion\n"
                + "5. DEBUG: Dump objects (toString)\n" + "6. Exit");
    }

    public int getMenuOption() {
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

    public int selectMinion(MinionManager minionList, int menuOption) {
        minionList.printMinionList();
        System.out.println("(Enter 0 to cancel)");
        int minionNumber = 0;
        Scanner scanner = new Scanner(System.in);
        boolean enteringSelection = true;
        while (enteringSelection) {
            minionNumber = scanner.nextInt();
            if (minionNumber > 0 && minionNumber <= minionList.getListSize()) {
                if (menuOption == 3) {
                    minionList.removeMinion(minionNumber);
                } else if (menuOption == 4){
                    minionList.addEvilDeed(minionNumber);
                }
                enteringSelection = false;
            } else if (minionNumber == 0) {
                enteringSelection = false;
            }
            else {
                // Print error message and available menu options
                int minMenuOption = 1;
                int maxMenuOption = minionList.getListSize();
                if (maxMenuOption == 0) {
                    minMenuOption = 0;  // Only menu option available is 0
                }
                System.out.println("Error: Please enter a selection between " + minMenuOption
                        + " and " + maxMenuOption);
            }
        }
        return minionNumber;
    }
}
