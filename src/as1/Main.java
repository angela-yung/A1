package as1;
/**
 * Launches program.
 */
public class Main {
    public static void main(String[] args) {
        MinionManager minionManager = new MinionManager();
        TextUI textUI = new TextUI(minionManager);
        textUI.start();
    }
}