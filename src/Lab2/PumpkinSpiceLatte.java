package Lab2;

public class PumpkinSpiceLatte extends Cappucino {
private int mgOfPumpkinSpice;
    public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk,int mgOfPumpkinSpice) {
        super(intensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        this.name="PumpkinSpiceLatte";
    }
    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }
    public void setMgOfPumpkinSpice(int mlOfMilk) {
        this.mgOfPumpkinSpice = mlOfMilk;
    }

    @Override
    public void printCoffe() {
        super.printCoffe();
        System.out.println("Pumkin Spice: "+mgOfPumpkinSpice);
    }
    @Override
    protected void printCoffeProccess() {
        super.printCoffeProccess();
        System.out.println("Adding" +mgOfPumpkinSpice+" mg of pumkin Spice: ");
    }
    public PumpkinSpiceLatte makePumpkinSpiceLatte() {
        System.out.println("making PumpkinSpiceLatte");
        printCoffeProccess();
        return this;
    }


}
