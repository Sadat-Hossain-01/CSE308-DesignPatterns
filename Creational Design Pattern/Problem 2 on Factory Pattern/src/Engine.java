abstract class Engine {
    protected String engineType;

    public String getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return "Engine Type: " + engineType;
    }
}

class ElectricEngine extends Engine {

    ElectricEngine() {
        this.engineType = "Electric";
    }
}

class HydrogenFuelCellEngine extends Engine {

    HydrogenFuelCellEngine() {
        this.engineType = "Hydrogen Fuel Cell";
    }
}

