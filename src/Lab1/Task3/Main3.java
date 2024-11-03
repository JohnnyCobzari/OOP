package Lab1.Task3;

import Lab1.Task1.Display;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        // Create an empty list of Display objects
        List<Display> displayList = new ArrayList<>();

        // Create an instance of Assistant with an empty list
        Assistant assistant = new Assistant("Alex", displayList);

        // Create a few Display instances with the new constructor parameters
        Display display1 = new Display(1920, 1080, 401.5f, "Model A");
        Display display2 = new Display(2560, 1440, 534.0f, "Model B");
        Display display3 = new Display(1920, 1080, 401.5f, "Model C");
        Display display4 = new Display(3840, 2160, 806.5f, "Model D");

        // Assign displays to the assistant
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);
        assistant.assignDisplay(display4);

        // Test assist method: Compare each display with the others
        System.out.println("Comparing assigned displays:");
        assistant.assist();

        // Test buyDisplay method: Removing display1 from assigned displays
        System.out.println("\nBuying display1 (removing it from assigned displays):");
        assistant.buyDisplay(display1);

        // Verify that display1 has been removed
        System.out.println("Remaining displays after buying display1:");
        for (Display display : assistant.getAssignedDisplays()) {
            System.out.println("left the model "+ display.getModel());
        }
    }
}
