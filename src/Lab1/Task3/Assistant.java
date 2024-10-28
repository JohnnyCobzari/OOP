package Lab1.Task3;

import Lab1.Task1.Display;

import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName, List<Display> assignedDisplays) {
        this.assignedDisplays = assignedDisplays;
        this.assistantName = assistantName;
    }
    public void assignDisplay(Display display) {
        assignedDisplays.add(display);
    }
    public void assist() {
        for (int i = 0; i < assignedDisplays.size(); i++) {
            Display currentDisplay = assignedDisplays.get(i);

            // Start the inner loop from the next element to avoid redundant comparisons
            for (int j = i + 1; j < assignedDisplays.size(); j++) {
                Display comparisonDisplay = assignedDisplays.get(j);

                // Call the comparison logic here
                currentDisplay.compareMonitor(comparisonDisplay);
            }
        }
    }
    public Display buyDisplay(Display display) {
        for (int i = 0; i < assignedDisplays.size(); i++) {
            if (assignedDisplays.get(i).equals(display)) {
                assignedDisplays.remove(i);

            }
        }
        return display;
    }
    public List<Display> getAssignedDisplays() {
        return assignedDisplays;
    }
    }


