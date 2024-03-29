abstract class PCBuilder {
    protected PC pc;

    public PCBuilder() {
        pc = new PC();
    }

    protected final void addMotherboard() {
        pc.addComponent(new Motherboard());
    }

    protected final void addHardDisk() {
        pc.addComponent(new HardDisk());
    }

    protected abstract void addProcessor();

    protected abstract void addCooler();

    protected abstract void addDVDDrive();

    protected final void addRAM(int freq) {
        if (freq == 2666) {
            pc.addComponent(new RAM2666());
            System.out.println("8 GB DDR4 2666MHz RAM added.");
        } else if (freq == 3200) {
            pc.addComponent(new RAM3200());
            System.out.println("8 GB DDR4 3200MHz RAM added.");
        }
    }

    protected final void addGraphicsCard(int memory) {
        if (memory == 2) {
            pc.addComponent(new GCard2());
            System.out.println("2 GB Graphics Card added.");
        } else if (memory == 4) {
            pc.addComponent(new GCard4());
            System.out.println("4 GB Graphics Card added.");
        }
    }

    public PC getConstructedPC() {
        return pc;
    }
}

class i5Builder extends PCBuilder {

    @Override
    protected void addProcessor() {
        pc.addComponent(new Processor5());
    }

    @Override
    protected void addCooler() {
        pc.addComponent(new CPUCooler());
    }

    @Override
    protected void addDVDDrive() {
        // do nothing
    }
}

class i7Builder extends PCBuilder {

    @Override
    protected void addProcessor() {
        pc.addComponent(new Processor7());
    }

    @Override
    protected void addCooler() {
        pc.addComponent(new LiquidCooler());
    }

    @Override
    protected void addDVDDrive() {
        // do nothing
    }
}

class i9Builder extends PCBuilder {

    @Override
    protected void addProcessor() {
        pc.addComponent(new Processor9());
    }

    @Override
    protected void addCooler() {
        // do nothing
    }

    @Override
    protected void addDVDDrive() {
        pc.addComponent(new DVDDrive());
    }
}

class GamingPCBuilder extends PCBuilder {

    @Override
    protected void addProcessor() {
        pc.addComponent(new Processor5700());
    }

    @Override
    protected void addCooler() {
        // do nothing
    }

    @Override
    protected void addDVDDrive() {
        // do nothing
    }
}