import java.util.Scanner;

public class Test {
    public static void testing() {

        int userChoice = 0;
        boolean loop = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 6: ");
        userChoice = scanner.nextInt();

        switch(userChoice) {
            case 1: userChoice = 1;


        }


        System.out.println("You chose " + userChoice + "\n");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.testing();
    }
}
