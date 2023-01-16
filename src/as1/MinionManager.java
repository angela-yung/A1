package as1;

import java.util.ArrayList;

/**
 * MinionManager class models information about a list of
 * minions. Data includes minion's name, height, and
 * number of evil deeds completed.
 */
public class MinionManager {
    private ArrayList<Minion> minionList;

    public MinionManager() {
        minionList = new ArrayList<Minion>();
    }

    public void printMinionList() {
        System.out.println("List of Minions:");
        System.out.println("****************");

        if (minionList.size() == 0) {
            System.out.println("No minions found.");
        } else {
            for (int i = 0; i < minionList.size(); i++) {
                Minion minion = minionList.get(i);
                // Prints index (i + 1) because the list starts from 1, not 0
                System.out.println( (i + 1) + ". " + minion.getMinionName() + ", "
                        + minion.getHeight() + "m, "
                        + minion.getNumEvilDeeds() + " evil deed(s)");
            }
        }
    }

    public void addNewMinion(String name, double height) {
        Minion minion = new Minion(name, height);
        minionList.add(minion);
    }

    public void removeMinion(int index) {
        minionList.remove(index - 1);
    }

    public void addEvilDeed(int index) {
        Minion minion = minionList.get(index - 1);
        minion.addEvilDeed();
        System.out.println(minion.getMinionName() + " has now done "
                + minion.getNumEvilDeeds() + " evil deed(s)!");
    }

    public void debug() {
        System.out.println("All minion objects:");
        for (int i = 0; i < minionList.size(); i++) {
            System.out.println((i + 1) + ". " + minionList.get(i).toString());
        }
    }

    public int getListSize() {
        return minionList.size();
    }

}
