import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        final int WATER = 200;
        final int MILK = 50;
        final int COFFEE = 15;

        System.out.printf(
            "For %d cups of coffee you will need:\n%d ml of water\n%d ml of milk\n%d g of coffee beans\n",
            cups, WATER * cups, MILK * cups, COFFEE * cups
        );
    }
}
