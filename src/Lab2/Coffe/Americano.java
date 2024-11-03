package Lab2.Coffe;

public class Americano extends Coffe {
private int mlOfWater=100;
public Americano() {}
    public Americano(Intensity intensity) {
        super(intensity);

        this.name="Americano";
    }

    @Override
    public void printCoffe() {
        super.printCoffe();
        System.out.println("Ml of water: "+mlOfWater);
    }
    @Override
    protected void printCoffeProccess() {
        super.printCoffeProccess();
        System.out.println("Adding"+mlOfWater+"Ml of water" );
    }
    public Americano makeAmericano(){
        System.out.println("Making Americano");
        printCoffeProccess();
        return this;
    }
}
