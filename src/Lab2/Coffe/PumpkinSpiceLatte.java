package Lab2.Coffe;

public class PumpkinSpiceLatte extends Cappucino {

private int mgOfPumpkinSpice=20;
public PumpkinSpiceLatte() {}
    public PumpkinSpiceLatte(Intensity intensity) {
        super(intensity);
        this.name="PumpkinSpiceLatte";
    }
    @Override
    public void printCoffe() {
        super.printCoffe();
        System.out.println("Pumkin Spice: "+this.mgOfPumpkinSpice);
    }
    @Override
    protected void printCoffeProccess() {
        super.printCoffeProccess();
        System.out.println("Adding" +this.mgOfPumpkinSpice+" mg of pumkin Spice: ");
    }
    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        System.out.println("making PumpkinSpiceLatte");
        printCoffeProccess();
        return this;
    }


}
