public class Director {
    private PCBuilder builder;

    public Director(PCBuilder builder) {
        this.builder = builder;
    }

    public void constructPC() {
        builder.setBaseComponents();
        builder.addProcessor();
        builder.addCooler();
        builder.addDrive();
    }

}
