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
}
