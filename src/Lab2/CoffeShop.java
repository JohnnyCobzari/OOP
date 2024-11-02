package Lab2;

import java.util.Scanner;

public class CoffeShop {

    public void startBrewingProcess() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display main menu options
            System.out.println("\nWelcome to the Coffee Shop! Please select an option:");
            System.out.println("1 - Coffee Recipes");
            System.out.println("2 - Brew a Coffee");
            System.out.println("3 - Leave");

            // Get the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Display available coffee recipes
                    showCoffeeRecipes(scanner);
                    break;

                case 2:
                    // Brew a selected coffee
                    brewCoffee(scanner);
                    break;

                case 3:
                    // Exit the coffee shop
                    System.out.println("Thank you for visiting! Goodbye.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            // After each operation, ask if they want to return to the main menu or leave
            if (running) {
                System.out.println("\nWould you like to do something else?");
                System.out.println("1 - Yes, go back to main menu");
                System.out.println("2 - No, leave");

                int continueChoice = scanner.nextInt();
                scanner.nextLine();
                if (continueChoice == 2) {
                    System.out.println("Thank you for visiting! Goodbye.");
                    running = false;
                }
            }
        }

        // Close the scanner after exiting the loop
        scanner.close();
    }

    // Method to display coffee recipes
    private void showCoffeeRecipes(Scanner scanner) {
        System.out.println("\nCoffee Recipes:");
        System.out.println("1 - Basic Coffee");
        System.out.println("2 - Americano");
        System.out.println("3 - Cappuccino");
        System.out.println("4 - Pumpkin Spice Latte.");
        System.out.println("5 - Syrup Cappuccino");
        int coffeeType = scanner.nextInt();
        scanner.nextLine();

        // Create a Barista with the selected coffee type command
        Barista barista = new Barista(coffeeType);

        // Brew the selected coffee type
        barista.showMenu();
    }

    // Method to brew coffee
    private void brewCoffee(Scanner scanner) {
        System.out.println("\nPlease select a coffee type to brew:");
        System.out.println("1 - Basic Coffee");
        System.out.println("2 - Americano");
        System.out.println("3 - Cappuccino");
        System.out.println("4 - Pumpkin Spice Latte");
        System.out.println("5 - Syrup Cappuccino");

        // Get the coffee type from the user
        int coffeeType = scanner.nextInt();
        scanner.nextLine();

        // Create a Barista with the selected coffee type command
        Barista barista = new Barista(coffeeType);

        // Brew the selected coffee type
        barista.brewCoffee(scanner);
    }

    public static void main(String[] args) {
        CoffeShop coffeeShop = new CoffeShop();
        coffeeShop.startBrewingProcess();
    }
}
