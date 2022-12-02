abstract class Cooler {
    protected String type;
    protected int price;

    abstract void setCoolerType();

    public Cooler() {
        setCoolerType();
    }
}

class CPUCooler extends Cooler {

    @Override
    void setCoolerType() {
        this.type = "CPU Cooler";
        this.price = 36000;
    }
}

class LiquidCooler extends Cooler {

    @Override
    void setCoolerType() {
        this.type = "Liquid Cooler";
        this.price = 17000;
    }
}
