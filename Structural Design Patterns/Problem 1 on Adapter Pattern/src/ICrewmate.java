public interface ICrewmate {
    void studyObjects();

    void doMaintenance();
}

class Crewmate implements ICrewmate {
    @Override
    public void studyObjects() {
        System.out.println("Studying interstellar objects");
    }

    @Override
    public void doMaintenance() {
        System.out.println("Doing maintenance of the ship");
    }
}