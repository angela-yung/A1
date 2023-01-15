import java.util.Scanner;

public class Test {
    public static void testing() {

        int userChoice = 0;
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

        System.out.println("You chose " + userChoice + "\n");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.testing();
    }
}
