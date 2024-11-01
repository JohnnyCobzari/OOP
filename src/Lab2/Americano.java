package Lab2;

public class Americano extends Coffe {
protected int mlOfWater;
    public Americano(Intensity intensity,int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
        this.name="Americano";
    }
    public int getMlOfWater() {
        return mlOfWater;
    }
    public void setMlOfWater(int mlOfWater) {
        this.mlOfWater = mlOfWater;
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
