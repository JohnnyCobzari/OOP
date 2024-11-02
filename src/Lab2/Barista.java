package Lab2;

import java.util.Scanner;
import Lab2.Coffe.*;
public class Barista {
    private int command;


    public Barista(int i) {
        this.command = i;
    }
    public void brewCoffee(Scanner scanner) {


        switch (command) {
            case 1: // Basic Coffee
                System.out.println("Choose intensity (LIGHT, NORMAL, STRONG):");
                String intensityInput = scanner.next().toUpperCase();
                scanner.nextLine();
                Coffe.Intensity intensity = Coffe.Intensity.valueOf(intensityInput);
                Coffe coffee = new Coffe(intensity);
                coffee.makeCoffe();
                break;

            case 2: // Americano
                System.out.println("Choose intensity (LIGHT, NORMAL, STRONG):");
                intensityInput = scanner.next().toUpperCase();
                scanner.nextLine();
                intensity = Coffe.Intensity.valueOf(intensityInput);
                Americano americano = new Americano(intensity);
                americano.makeAmericano();
                break;

            case 3: // Cappuccino
                System.out.println("Choose intensity (LIGHT, NORMAL, STRONG):");
                intensityInput = scanner.next().toUpperCase();
                scanner.nextLine();
                intensity = Coffe.Intensity.valueOf(intensityInput);
                Cappucino cappuccino = new Cappucino(intensity);
                cappuccino.makeCappuccino();
                break;

            case 4: // Pumpkin Spice Latte
                System.out.println("Choose intensity (LIGHT, NORMAL, STRONG):");
                intensityInput = scanner.next().toUpperCase();
                scanner.nextLine();
                intensity = Coffe.Intensity.valueOf(intensityInput);
                PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity);
                pumpkinSpiceLatte.makePumpkinSpiceLatte();
                break;

            case 5: // Syrup Cappuccino
                System.out.println("Choose intensity (LIGHT, NORMAL, STRONG):");
                intensityInput = scanner.next().toUpperCase();
                scanner.nextLine();
                intensity = Coffe.Intensity.valueOf(intensityInput);
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

    public void showMenu() {


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



