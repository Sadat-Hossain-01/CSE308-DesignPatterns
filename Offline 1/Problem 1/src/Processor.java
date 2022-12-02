abstract class Processor {
    protected String type;
    protected int price;

    abstract void setProcessorType();

    public Processor() {
        setProcessorType();
    }
}

class Processor5700 extends Processor {

    @Override
    void setProcessorType() {
        this.type = "AMD Ryzen 7 5700X";
        this.price = 28000;
    }
}

class Processor5 extends Processor {

    @Override
    void setProcessorType() {
        this.type = "11th generation Core i5";
        this.price = 20000;
    }
}

class Processor7 extends Processor {

    @Override
    void setProcessorType() {
        this.type = "11th generation Core i7";
        this.price = 37000;
    }
}

class Processor9 extends Processor {

    @Override
    void setProcessorType() {
        this.type = "11th generation Core i9";
        this.price = 65000;
    }
}