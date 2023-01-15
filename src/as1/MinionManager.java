package as1;

import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * MinionManager class models information about a list of
 * minions. Data includes minion's name, height, and
 * number of evil deeds completed. It supports reading in
 * user input from the console.
 */
public class MinionManager {
    private ArrayList<Minion> minionList;

    public MinionManager() {
        minionList = new ArrayList<Minion>();
    }

    public void addNewMinion(String name, double height) {
        // Create new minion
        Minion minion = new Minion(name, height);

        // Add minion to minion list
        minionList.add(minion);
    }
    public void listMinions() {
        System.out.println("List of Minions:\n");
        System.out.println("****************\n");

        // Iterate over minion list and print each minion's attributes
        for (int i = 0; i < minionList.size(); i++) {
            // Get current minion
            Minion minion = minionList.get(i);
            System.out.println( (i + 1) + ". " + minion.getMinionName() +
            ", " + minion.getHeight() + "m, " + minion.getNumEvilDeeds() +
            " evil deed(s)\n");
        }
        System.out.println("\n");
    };

    // Increments the numEvilDeed count in a minion by one
    private static void addEvilDeed(int index) {
        // Get the correct minion
        minionList

    }

    // Removes a minion from the minion list
    private static void removeMinion(int index) {
        minionList.remove(index - 1);
    };
}
