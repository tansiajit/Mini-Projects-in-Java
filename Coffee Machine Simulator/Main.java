import java.util.Scanner;

// Class that represents each type of coffee (espresso, latte and cappuccino) with its ingredients and cost
class Coffee {
    int water; int milk; int coffeeBeans; int cost;

    public Coffee(int water, int milk, int coffeeBeans, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cost = cost;
    }

    public static Coffee espresso() {
        return new Coffee(250, 0, 16, 4);
    }

    public static Coffee latte() {
        return new Coffee(350, 75, 20, 7);
    }

    public static Coffee cappuccino() {
        return new Coffee(200, 100, 12, 6);
    }
}

// Class that represents the coffee machine along with the actions of buy, fill, take, clean, remainining and exit
class CoffeeMachine {
    private int water; private int milk; private int coffeeBeans;
    private int cups; private int money; private int cupsMadeSinceClean;
    private boolean needsCleaning;
    private final Scanner scanner = new Scanner(System.in);

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
        this.cupsMadeSinceClean = 0;
        this.needsCleaning = false;
    }

    public void start() {
        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.next();

            if (action.equals("exit")) {
                break;
            }

            handleAction(action);
        }
    }

    private void handleAction(String action) {
        switch (action) {
            case "buy":
                if (needsCleaning) {
                    System.out.println("I need cleaning!\n"); // Same message
                } else {
                    buy();
                }
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                printState();
                break;
            case "clean":
                clean();
                break;
            default:
                System.out.println("Unknown action.\n");
        }
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();

        Coffee coffee;
        switch (choice) {
            case "1":
                coffee = Coffee.espresso();
                break;
            case "2":
                coffee = Coffee.latte();
                break;
            case "3":
                coffee = Coffee.cappuccino();
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid selection.\n");
                return;
        }

        if (!hasEnoughResources(coffee)) {
            return;
        }

        makeCoffee(coffee);
    }

    private boolean hasEnoughResources(Coffee coffee) {
        if (water < coffee.water) {
            System.out.println("Sorry, not enough water!\n");
            return false;
        }
        if (milk < coffee.milk) {
            System.out.println("Sorry, not enough milk!\n");
            return false;
        }
        if (coffeeBeans < coffee.coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!\n");
            return false;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough cups!\n");
            return false;
        }
        return true;
    }

    private void makeCoffee(Coffee coffee) {
        water -= coffee.water;
        milk -= coffee.milk;
        coffeeBeans -= coffee.coffeeBeans;
        cups--;
        money += coffee.cost;
        cupsMadeSinceClean++;
    
        System.out.println("I have enough resources, making you a coffee!\n");
    
        if (cupsMadeSinceClean == 10) {
            needsCleaning = true;
            System.out.println("I need cleaning!\n"); // <- Exactly what the test expects
    }
}

    private void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();
        System.out.println();
    }

    private void take() {
        System.out.printf("I gave you $%d\n\n", money);
        money = 0;
    }

    private void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", coffeeBeans);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n\n", money);
    }

    private void clean() {
        if (needsCleaning) {
            needsCleaning = false;
            cupsMadeSinceClean = 0;
            System.out.println("I have been cleaned!\n");
        } else {
            System.out.println("Cleaning not required.\n");
        }
    }
}

// Class that essentially starts the coffee machine with the intial resources
class Main {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        machine.start();
    }
}
