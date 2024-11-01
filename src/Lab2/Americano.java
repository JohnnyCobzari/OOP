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
}
