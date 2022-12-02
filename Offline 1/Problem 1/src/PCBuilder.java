import java.util.ArrayList;

abstract class PCBuilder {
    protected int totalPrice;
    protected Processor processor;
    protected Cooler cooler;
    protected String drive;
    protected String hardDisk;
    protected String motherboard;
    protected ArrayList<RAM> ramList;
    protected ArrayList<GraphicsCard> gCardList;

    void addRAM(int frequency) {
        RAM r = null;

        if (frequency == 2666) {
            r = new RAM2666();
        } else if (frequency == 3200) {
            r = new RAM3200();
        }

        if (r != null) {
            ramList.add(r);
            totalPrice += r.price;
        }
    }

    void addGraphicsCard(int memory) {
        GraphicsCard g = null;

        if (memory == 2) {
            g = new GCard2();
        } else if (memory == 4) {
            g = new GCard4();
        }

        if (g != null) {
            gCardList.add(g);
            totalPrice += g.price;
        }
    }

    void setBaseComponents() {
        this.motherboard = "Default Motherboard";
        this.hardDisk = "1 TB HDD";
        this.totalPrice += 70000;
    }

    abstract void addProcessor();

    abstract void addCooler();

    abstract void addDrive();
}

class PC1 extends PCBuilder {

    @Override
    void addProcessor() {
        this.processor = new Processor5();
        this.totalPrice += this.processor.price;
    }

    @Override
    void addCooler() {
        this.cooler = new CPUCooler();
        this.totalPrice += this.cooler.price;
    }

    @Override
    void addDrive() {
    }

}

class PC2 extends PCBuilder {

    @Override
    void addProcessor() {
        this.processor = new Processor7();
        this.totalPrice += this.processor.price;
    }

    @Override
    void addCooler() {
        this.cooler = new CPUCooler();
        this.totalPrice += this.cooler.price;
    }

    @Override
    void addDrive() {
    }

}

class PC3 extends PCBuilder {

    @Override
    void addProcessor() {
        this.processor = new Processor9();
        this.totalPrice += this.processor.price;
    }

    @Override
    void addCooler() {
    }

    @Override
    void addDrive() {
        this.drive = "DVD Drive";
        this.totalPrice += 6000;
    }

}

class PC4 extends PCBuilder {
    //the gaming PC

    @Override
    void addProcessor() {
        this.processor = new Processor5700();
        this.totalPrice += this.processor.price;
    }

    @Override
    void addCooler() {
    }

    @Override
    void addDrive() {
    }

}

