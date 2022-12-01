public abstract class DriveTrain {
    protected String driveTrainType;

    public String getDriveTrainType() {
        return driveTrainType;
    }

    abstract void setDriveTrainType();

    @Override
    public String toString() {
        return "Drive Train Type: " + driveTrainType;
    }
}
