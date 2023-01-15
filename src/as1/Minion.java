package as1;

/**
 * Minion class models information about a minion. Data
 * includes minion's name, height, and number of evil
 * deeds completed. It supports reading in user input
 * from the console.
 */
public class Minion {
    private String minionName;
    private double height;
    private int numEvilDeeds;

    public Minion(String minionName, double height) {
        this.minionName = minionName;
        this.height = height;
        numEvilDeeds = 0;
    }
    public void addEvilDeed() {
        numEvilDeeds++;
    }

    public String getMinionName() {
        return minionName;
    }

    public double getHeight() {
        return height;
    }

    public int getNumEvilDeeds() {
        return numEvilDeeds;
    }

}
