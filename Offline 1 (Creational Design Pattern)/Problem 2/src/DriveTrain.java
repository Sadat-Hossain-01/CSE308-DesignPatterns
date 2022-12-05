abstract class DriveTrain {
    protected String driveTrainType;

    public String getDriveTrainType() {
        return driveTrainType;
    }

    @Override
    public String toString() {
        return "Drive Train Type: " + driveTrainType;
    }
}

class RearWheelDriveTrain extends DriveTrain {

    RearWheelDriveTrain() {
        this.driveTrainType = "Rear Wheel";
    }
}

class AllWheelDriveTrain extends DriveTrain {

    AllWheelDriveTrain() {
        this.driveTrainType = "All Wheels";
    }
}

