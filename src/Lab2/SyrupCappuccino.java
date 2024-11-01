package Lab2;

public class SyrupCappuccino extends Cappucino{
    private enum SyrupType{
        Macadamia,Vanilla,Coconut,Caramel,Chocolate,Popcorn
    }
    SyrupType syrup ;
    public SyrupCappuccino(Intensity intensity, int mlOfMilk,SyrupType syrup) {
        super(intensity, mlOfMilk);
        this.syrup = syrup;
        this.name ="SyrupCappuccino";
    }

    public SyrupType getSyrup() {
        return syrup;
    }
    public void setSyrup(SyrupType syrup) {
        this.syrup = syrup;
    }

    @Override
    public void printCoffe() {
        super.printCoffe();
        System.out.println("Syrup: " + syrup);
    }
    @Override
    protected void printCoffeProccess() {
        super.printCoffeProccess();
        System.out.println("Adding" +syrup+" Syrup ");
    }
    public SyrupCappuccino makeSyrupCappuccino(){
        System.out.println("Making SyrupCappuccino");
        printCoffeProccess();
        return this;
    }
}
