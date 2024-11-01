package Lab2;

public class Cappucino extends Coffe {
    protected int mlOfMilk;
    public Cappucino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
        this.name = "Cappucino";
    }
    public int getMlOfMilk() {
        return mlOfMilk;
    }
    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public void printCoffe() {
        super.printCoffe();
        System.out.println("Milk: " + getMlOfMilk());
    }
    @Override
    protected void printCoffeProccess() {
        super.printCoffeProccess();
        System.out.println("Adding"+mlOfMilk+"Ml of milk" );
    }


    public Cappucino makeCappuccino() {
        System.out.println("Making Cappucino");
        printCoffeProccess();
        return this;
    }

}
