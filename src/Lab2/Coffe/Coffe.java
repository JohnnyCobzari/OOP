package Lab2.Coffe;


public class Coffe {
    public enum Intensity {
        LIGHT, NORMAL, STRONG
    }
    private Intensity intensity;
    protected String name = "Coffe";
    public Coffe() {}
    public Coffe(Intensity intensity) {
        this.intensity = intensity;
    }

    public void printCoffe(){
      System.out.println("Intensity:Light/Normal/Strong");
    }
    protected void printCoffeProccess(){
        System.out.println("The barista started to brew coffe");
        System.out.println("Setted instensity to:"+this.intensity);
    }

    public final Coffe makeCoffe(){
        System.out.println("Making Coffe");
        printCoffeProccess();
        return this;
    }

}
