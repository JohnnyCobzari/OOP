package Lab2;


public class Coffe {
    protected enum Intensity {
        LIGHT, NORMAL, STRONG
    }
    private Intensity intensity;
    protected String name = "Coffe";
    public Coffe(Intensity intensity) {
        this.intensity = intensity;
    }
    public Intensity getIntensity() {
        return intensity;
    }
    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }
    public void printCoffe(){
      System.out.println("Intensity:"+this.intensity);
    }
    protected void printCoffeProccess(){
        System.out.println("The barista started to brew coffe");
        System.out.println("Setted instensity to:"+this.intensity);
    }

    public Coffe makeCoffe(){
        System.out.println("Making Coffe");
        printCoffeProccess();
        return this;
    }

}
