package Lab2.Coffe;

public class SyrupCappuccino extends Cappucino{
    public enum SyrupType {
        MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
    }
    SyrupType syrup ;
    public SyrupCappuccino(Intensity intensity, SyrupType syrup) {
        super(intensity);
        this.syrup = syrup;
        this.name ="SyrupCappuccino";
    }
    public SyrupCappuccino() {}

    public SyrupType getSyrup() {
        return syrup;
    }
    public void setSyrup(SyrupType syrup) {
        this.syrup = syrup;
    }

    @Override
    public void printCoffe() {
        super.printCoffe();
        System.out.println("Syrup: MACADAMIA/VANILLA/COCONUT/CARAMEL/CHOCOLATE/POPCORN " );
    }
    @Override
    protected void printCoffeProccess() {
        super.printCoffeProccess();
        System.out.println("Adding" +this.syrup+" Syrup ");
    }
    public final SyrupCappuccino makeSyrupCappuccino(){
        System.out.println("Making SyrupCappuccino");
        printCoffeProccess();
        return this;
    }
}
