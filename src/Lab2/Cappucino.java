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
}
