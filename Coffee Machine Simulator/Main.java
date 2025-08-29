import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int water = 400;
        int milk = 540;
        int coffee = 120;
        int cups = 9;
        int money = 550;


        while (true){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();
            if (action.equals("exit")) {
                break; // exit the loop
        }
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String options = scanner.next();
                if (options.equals("back")) {
                    break;
                }
                else {
                    int option = Integer.parseInt(options);
                    switch (option) {
                        case 1:
                            if (water>= 250) {
                                if (coffee >= 16) {
                                    if (cups >= 1) {
                                        water -= 250;
                                        coffee -= 16;
                                        cups --;
                                        money += 4;
                                        System.out.println("I have enough resources, making you a coffee!");
                                    } else { System.out.println("Sorry, not enough cups!"); }
                                } else { System.out.println("Sorry, not enough coffee!"); }
                            } else { System.out.println("Sorry, not enough water!"); }

                            break;
                        
                        case 2:
                            if (water >= 350) {
                                if(milk >=75) {
                                    if (coffee >=20) {
                                        if(cups >= 1) {
                                            water -= 350;
                                            milk -= 75;
                                            coffee -= 20;
                                            cups --;
                                            money += 7;
                                            System.out.println("I have enough resources, making you a coffee!");
                                        } else { System.out.println("Sorry, not enough cups!"); }
                                    } else { System.out.println("Sorry, not enough coffee!"); }
                                } else { System.out.println("Sorry, not enough milk!"); }
                            } else { System.out.println("Sorry, not enough water!"); }

                            break;

                        case 3:
                            if (water >= 200) {
                                if (milk >= 100) {
                                    if (coffee >= 12) {
                                        if (cups >= 1) {
                                            water -= 200;
                                            milk -= 100;
                                            coffee -= 12;
                                            cups --;
                                            money += 6;
                                            System.out.println("I have enough resources, making you a coffee!");
                                        } else { System.out.println("Sorry, not enough cups!"); }
                                    } else { System.out.println("Sorry, not enough coffee!"); }
                                } else { System.out.println("Sorry, not enough milk!"); }
                            } else { System.out.println("Sorry, not enough water!"); }

                            break;
                    }
                    break;
                }

            case "fill":
                System.out.println("Write how many ml of water you want to add: ");
                int addWater = scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                int addMilk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add: ");
                int addCoffee = scanner.nextInt();
                System.out.println("Write how many disposable cups you want to add: ");
                int addCups = scanner.nextInt();

                water += addWater;
                milk += addMilk;
                coffee += addCoffee;
                cups += addCups;

                break;

            case "take":
                System.out.printf("I gave you $%d\n", money);
                money -= money;
                break;

            case "remaining":
                printState(water, milk, coffee, cups, money);
                break;

            }
        }
    }

    // Method used to print the current state of the machine
    public static void printState(int water, int milk, int coffee, int cups, int money) {
        System.out.printf("The coffee machine has:\n%d ml of water\n%d ml of milk\n%d g of coffee beans\n%d disposable cups\n$%d of money\n\n", water, milk, coffee, cups, money);
    }
    // Method used to estimate the servings it can provide using the counting cups method
    public static void estimateIngredients() {
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
