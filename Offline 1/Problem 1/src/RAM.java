abstract class RAM {
    protected int frequency;
    protected int price;

    abstract void setRAMFrequency();

    public RAM() {
        setRAMFrequency();
    }
}

class RAM2666 extends RAM {

    @Override
    void setRAMFrequency() {
        this.frequency = 2666;
        this.price = 2620;
    }
}

class RAM3200 extends RAM {

    @Override
    void setRAMFrequency() {
        this.frequency = 3200;
        this.price = 2950;
    }
}
