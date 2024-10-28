package Lab1.Task1;

public class Main1 {

    public static void main(String[] args) {
        Display display1 = new Display(1920, 1080, 401.0f, "Model A");
        Display display2 = new Display(2560, 1440, 534.0f, "Model B");
        Display display3 = new Display(2280, 2720, 267.0f, "Model C");

        display1.compareSize(display2);
        display1.compareSize(display3);
        display2.compareSize(display3);
        display1.compareSharpness(display3);
        display1.compareSharpness(display2);
        display2.compareSharpness(display3);
        display1.compareMonitor(display3);
        display1.compareMonitor(display2);
        display2.compareMonitor(display3);
        display1.compareAllSize(display3, display2);
        display1.compareAllSharpness(display2, display3);

    }
}
