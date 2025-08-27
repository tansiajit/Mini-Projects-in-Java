import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int portion = countingCups(water, milk, coffee); // Calling the method to calculate the cups it can make
        
        if (portion == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        }
        else if (portion > cups) {
            int remainingPortion = portion - cups;
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", remainingPortion);
        }
        else { System.out.printf("No, I can make only %d cup(s) of coffee\n", portion);}

    }
    // Method used to count the total number of cups the machine can make using the portions provided
    public static int countingCups(int water, int milk, int coffee) {
        final int WATER = 200;
        final int MILK = 50;
        final int COFFEE = 15;
        int cup = 0;
        while (water>=WATER && milk>=MILK && coffee>=COFFEE) {
            water -= WATER;
            milk -= MILK;
            coffee -= COFFEE;
            cup ++;
        }
        return cup;
    }
}
