abstract class Car {
    protected String color;
    protected String company;
    protected String country;
    protected Engine engine;
    protected DriveTrain driveTrain;

    abstract void setCarProperties();

    void showDetails() {
        System.out.println("Color: " + color);
        System.out.println("Company: " + company);
        System.out.println("Manufacturing Country: " + country);
        System.out.println(engine);
        System.out.println(driveTrain);
    }
}

class BMW extends Car {

    @Override
    void setCarProperties() {
        this.color = "Black";
        this.company = "BMW";
        this.country = "Europe";
        this.engine = new ElectricEngine();
        this.driveTrain = new RearWheelDriveTrain();
    }
}

class Tesla extends Car {

    @Override
    void setCarProperties() {
        this.color = "White";
        this.company = "Tesla";
        this.country = "United States";
        this.engine = new ElectricEngine();
        this.driveTrain = new AllWheelDriveTrain();
    }
}

class Toyota extends Car {

    @Override
    void setCarProperties() {
        this.color = "Red";
        this.company = "Toyota";
        this.country = "Asia";
        this.engine = new HydrogenFuelCellEngine();
        this.driveTrain = new RearWheelDriveTrain();
    }
}
