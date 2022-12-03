public class PCDirector {
    private PCBuilder builder;

    public PCDirector(PCBuilder builder) {
        this.builder = builder;
    }

    public void constructPC() {
        builder.addMotherboard();
        builder.addHardDisk();
        builder.addProcessor();
        builder.addCooler();
        builder.addDVDDrive();
    }

    public void addRAM(int freq) {
        if (freq == 2666 || freq == 3200) builder.addRAM(freq);
    }

    public void addGraphicsCard(int memory) {
        if (memory == 2 || memory == 4) builder.addGraphicsCard(memory);
    }
}
