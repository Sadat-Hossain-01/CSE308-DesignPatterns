public class Toyota extends Car {

    @Override
    void setCarProperties() {
        this.color = "Red";
        this.company = "Toyota";
        this.engine = new HydrogenFuelCellEngine();
        this.driveTrain = new RearWheelDriveTrain();
    }
}
