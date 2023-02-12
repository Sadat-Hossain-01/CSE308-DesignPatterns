public class Demo {
    public static void main(String[] args) {
        Crewmate crew = new Crewmate();
        crew.studyObjects();
        crew.doMaintenance();
        System.out.print("\n\n");

        Imposter imposter = new Imposter();
        imposter.sabotage();
        imposter.damage();

        ICrewmate adapter = new Adapter(imposter);
        adapter.studyObjects();
        adapter.doMaintenance();
    }
}
