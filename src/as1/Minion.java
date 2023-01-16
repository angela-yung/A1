package as1;

/**
 * Minion class models information about a minion. Data
 * includes minion's name, height, and number of evil
 * deeds completed.
 */
public class Minion {
    private String name;
    private double height;
    private int numEvilDeeds;

    public Minion(String name, double height) {
        this.name = name;
        this.height = height;
        numEvilDeeds = 0;
    }

    public void addEvilDeed() {
        numEvilDeeds++;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getNumEvilDeeds() {
        return numEvilDeeds;
    }

    @Override
    public String toString() {
        return "Minion[" +
                "Name: " + name +
                ", Height: " + height +
                ", EvilDeeds: " + numEvilDeeds +
                ']';
    }
}
