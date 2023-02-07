public class ImposterAdapter implements Crewmate {
    private Imposter imposter;

    public ImposterAdapter(Imposter imposter) {
        this.imposter = imposter;
    }

    @Override
    public void studyObjects() {
        System.out.println("Studying interstellar objects");
        imposter.sabotage(); // sabotaging the voyage in reality
    }

    @Override
    public void doMaintenance() {
        System.out.println("Doing maintenance of the ship");
        imposter.damage(); // damaging the ship in reality
    }
}
