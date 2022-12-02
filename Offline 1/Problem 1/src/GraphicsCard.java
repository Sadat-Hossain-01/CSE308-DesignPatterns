abstract class GraphicsCard {
    protected int memory;
    protected int price;

    abstract void setMemory();

    public GraphicsCard() {
        setMemory();
    }
}

class GCard2 extends GraphicsCard {

    @Override
    void setMemory() {
        this.memory = 2;
        this.price = 6500;
    }
}

class GCard4 extends GraphicsCard {

    @Override
    void setMemory() {
        this.memory = 4;
        this.price = 7600;
    }
}
