package Lab2;

import java.util.Scanner;
import Lab2.Coffe.*;
public class Barista {

public Barista() {

}

    public void brewCoffee(Scanner scanner, int command) {
        Coffe.Intensity intensity = getCoffeeIntensity(scanner);

        switch (command) {
            case 1: // Basic Coffee
                Coffe coffee = new Coffe(intensity);
                coffee.makeCoffe();
                break;

            case 2: // Americano
                Americano americano = new Americano(intensity);
                americano.makeAmericano();
                break;

            case 3: // Cappuccino
                Cappucino cappuccino = new Cappucino(intensity);
                cappuccino.makeCappuccino();
                break;

            case 4: // Pumpkin Spice Latte
                PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity);
                pumpkinSpiceLatte.makePumpkinSpiceLatte();
                break;

            case 5: // Syrup Cappuccino
                System.out.println("Choose syrup (Macadamia, Vanilla, Coconut, Caramel, Chocolate, Popcorn):");
                String syrupInput = scanner.next().toUpperCase();
                scanner.nextLine();
                SyrupCappuccino.SyrupType syrup = SyrupCappuccino.SyrupType.valueOf(syrupInput);
                SyrupCappuccino syrupCappuccino = new SyrupCappuccino(intensity, syrup);
                syrupCappuccino.makeSyrupCappuccino();
                break;

            default:
                System.out.println("Unknown command: " + command);
                break;
        }
    }
    private Coffe.Intensity getCoffeeIntensity(Scanner scanner) {
        System.out.println("Choose intensity (LIGHT, NORMAL, STRONG):");
        while (true) {
            try {
                String intensityInput = scanner.nextLine().toUpperCase();
                return Coffe.Intensity.valueOf(intensityInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid intensity. Please enter LIGHT, NORMAL, or STRONG:");
            }
        }
    }

    public void showMenu(int command) {


        switch (command) {
            case 1: // Basic Coffee
                Coffe coffe = new Coffe();
                coffe.printCoffe();
                break;

            case 2: // Americano
               Americano americano = new Americano();
               americano.printCoffe();
                break;

            case 3: // Cappuccino
                Cappucino cappuccino = new Cappucino();
                cappuccino.printCoffe();
                break;

            case 4: // Pumpkin Spice Latte
               PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte();
               pumpkinSpiceLatte.printCoffe();
                break;

            case 5: // Syrup Cappuccino
                SyrupCappuccino syrupCappuccino = new SyrupCappuccino();
                syrupCappuccino.printCoffe();
                break;

            default:
                System.out.println("Unknown command: " + command);
                break;
        }


    }
    }



