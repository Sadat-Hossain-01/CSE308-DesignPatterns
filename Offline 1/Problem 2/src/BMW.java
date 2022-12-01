public class BMW extends Car {

    @Override
    void setCarProperties() {
        this.color = "Black";
        this.company = "BMW";
        this.engine = new ElectricEngine();
        this.driveTrain = new RearWheelDriveTrain();
    }
}
