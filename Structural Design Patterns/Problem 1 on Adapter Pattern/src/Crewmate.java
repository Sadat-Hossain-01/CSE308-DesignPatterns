public interface Crewmate {
    void studyObjects();
    void doMaintenance();
}

class Crew implements Crewmate {
    @Override
    public void studyObjects() {
        System.out.println("Studying interstellar objects");
    }

    @Override
    public void doMaintenance() {
        System.out.println("Doing maintenance of the ship");
    }
}