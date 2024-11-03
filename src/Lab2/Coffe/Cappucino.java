package Lab2.Coffe;

public class Cappucino extends Coffe {
    protected int mlOfMilk=75;
    public Cappucino() {}
    public Cappucino(Intensity intensity) {
        super(intensity);
        this.name = "Cappucino";
    }


    @Override
    public void printCoffe() {
        super.printCoffe();
        System.out.println("Milk: " + this.mlOfMilk);
    }
    @Override
    protected void printCoffeProccess() {
        super.printCoffeProccess();
        System.out.println("Adding"+this.mlOfMilk+"Ml of milk" );
    }


    public Cappucino makeCappuccino() {
        System.out.println("Making Cappucino");
        printCoffeProccess();
        return this;
    }

}
