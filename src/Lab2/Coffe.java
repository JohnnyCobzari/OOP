package Lab2;


public class Coffe {
    protected enum Intensity {
        LIGHT, NORMAL, STRONG
    }
    private Intensity intensity;
    protected String name = "Coffe";
    public Coffe(Intensity intensity) {
        this.intensity = intensity;
    }
    public Intensity getIntensity() {
        return intensity;
    }
    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

}
