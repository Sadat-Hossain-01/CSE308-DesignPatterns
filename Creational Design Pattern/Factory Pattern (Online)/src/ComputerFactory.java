public class ComputerFactory {
    public Computer produceComputer(String type) {
        Computer computer = null;

        if (type.equalsIgnoreCase("A")) {
            computer = new ComputerA();
        }
        else if (type.equalsIgnoreCase("B")) {
            computer = new ComputerB();
        }
        else if (type.equalsIgnoreCase("C")) {
            computer = new ComputerC();
        }

        return computer;
    }
}
