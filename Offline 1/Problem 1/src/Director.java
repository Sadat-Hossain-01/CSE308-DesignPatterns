public class Director {
    private PCBuilder builder;

    public Director(PCBuilder builder) {
        this.builder = builder;
    }

    public void constructPC() {
        builder.addBaseComponents();
    }

    public void addRAM(int freq) {
        if (freq == 2666 || freq == 3200) builder.addRAM(freq);
    }

    public void addGraphicsCard(int memory) {
        if (memory == 2 || memory == 4) builder.addGraphicsCard(memory);
    }
}
