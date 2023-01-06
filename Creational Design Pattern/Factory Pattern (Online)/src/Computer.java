abstract class Computer {
    public String CPU = "Default CPU";
    public String MMU = "Default MMU";
    public long resA, resB;
    public String type;

    public void showComputerDetail() {
        System.out.println("Computer Name: " + type);
        System.out.println("Computer Resolution: " + resA + "X" + resB);
    }
}

class ComputerA extends Computer {
    public ComputerA() {
        this.type = "Computer A";
        this.resA = 200;
        this.resB = 200;
    }
}

class ComputerB extends Computer {
    public ComputerB() {
        this.type = "Computer B";
        this.resA = 350;
        this.resB = 250;
    }
}

class ComputerC extends Computer {
    public ComputerC() {
        this.type = "Computer C";
        this.resA = 550;
        this.resB = 430;
    }
}
