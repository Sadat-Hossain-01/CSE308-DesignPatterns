public abstract class Engine {
    protected String engineType;

    public String getEngineType() {
        return engineType;
    }

    abstract void setEngineType();

    @Override
    public String toString() {
        return "Engine Type: " + engineType;
    }
}
