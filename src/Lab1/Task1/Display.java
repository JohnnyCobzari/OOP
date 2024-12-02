package Lab1.Task1;

public class Display {
    int width;
    int height;
    float ppi;
    String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    private int getWidth() {
        return width;
    }

    private int getHeight() {
        return height;
    }
    private float getPpi() {
        return ppi;
    }
    public String getModel() {
        return model;
    }
    public void compareSize(Display m) {


        int thisArea = this.width * this.height;
        int otherArea = m.getWidth() * m.getHeight();

        if (thisArea > otherArea) {
            System.out.println("This display (" + this.model + ") is bigger than the " + m.getModel() +
                    " display with an area of " + thisArea + " vs " + otherArea + " square units.");
        } else if (thisArea < otherArea) {
            System.out.println("The " + m.getModel() + " display is bigger than this display (" + this.model + ")" +
                    " with an area of " + otherArea + " vs " + thisArea + " square units.");
        } else {
            System.out.println("Both displays (" + this.model + " and " + m.getModel() + ") have the same size with an area of " +
                    thisArea + " square units.");
        }


    }
   public void compareSharpness(Display m) {


        if (this.ppi > m.getPpi()) {
            System.out.println("The " + this.model + " has better sharpness  (" + m.getModel());
        } else if (this.ppi < m.getPpi()) {
            System.out.println("The " + m.getModel() + " has better sharpness  (" + this.model);
        } else {
            System.out.println("The " + m.getModel() + " has same sharpeness  (" + this.model);
        }
    }

    public void compareMonitor(Display m) {
        int thisArea = this.width * this.height;
        int otherArea = m.getHeight() * m.getWidth();
        if (this.ppi > m.getPpi() && thisArea > otherArea) {
            System.out.println("The " + this.model + "is better because  has better size and sharpeness than" + m.getModel());
        }
        else if(this.ppi > m.getPpi() && thisArea < otherArea) {
            System.out.println("The " + this.model + "is better in sharpeness but smaller than" + m.getModel());
        }
        else if(this.ppi< m.getPpi() && thisArea > otherArea) {
            System.out.println("The " + this.model + "has lower sharpeness but is bigger than" + m.getModel());
        }
        else if(this.ppi < m.getPpi() && thisArea < otherArea) {
            System.out.println("The " + m.getModel()+ "is better because  has better size and sharpeness than" + this.model);
        }
        else if(this.ppi == m.getPpi() && thisArea == otherArea) {
            System.out.println("The " + this.model + "has same stats as " + m.getModel());
        }
        else if(this.ppi == m.getPpi() && thisArea < otherArea) {
            System.out.println("The " + m.getModel() + "has same shrapness but is bigger" + this.model);
        }
        else if(this.ppi == m.getPpi() && thisArea > otherArea) {
            System.out.println("The " + this.model + "has same shrapness but is bigger" + m.getModel());
        }
        else if(this.ppi > m.getPpi() && thisArea == otherArea) {
            System.out.println("The " + this.model + "has same sizes but has higher sharpness" + m.getModel());
        }
        else if(this.ppi < m.getPpi() && thisArea == otherArea) {
            System.out.println("The " + m.getModel() + "has same sizes but has higher sharpness" + this.model);
        }

    }


    public void compareAllSize(Display... displays) {
        if (displays == null || displays.length == 0) {
            System.out.println("No displays to compare.");
            return;
        }

        Display biggest = this;
        int maxArea = biggest.getWidth() * biggest.getHeight();

        for (int i = 0; i < displays.length; i++) {
            Display display = displays[i];
            int area = display.getWidth() * display.getHeight();
            if (area > maxArea) {
                maxArea = area;
                biggest = display;
            }
        }

        System.out.println("The biggest screen has the model " + biggest.getModel() +
                " and has a surface of " + maxArea + " square units.");
    }
    public void compareAllSharpness(Display... displays) {
        if (displays == null || displays.length == 0) {
            System.out.println("No displays to compare.");
            return;
        }

        Display biggest = this;

        for (int i = 0; i < displays.length; i++) {
            Display display = displays[i];

            if (biggest.getPpi() > display.getPpi()) {
                biggest = display;
            }
        }

        System.out.println("The shrapness model is " + biggest.getModel() +" it has "+ biggest.getPpi() + " ppi.");
    }







}
