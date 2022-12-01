public class Tesla extends Car {

    @Override
    void setCarProperties() {
        this.color = "White";
        this.company = "Tesla";
        this.engine = new ElectricEngine();
        this.driveTrain = new AllWheelDriveTrain();
    }
}
