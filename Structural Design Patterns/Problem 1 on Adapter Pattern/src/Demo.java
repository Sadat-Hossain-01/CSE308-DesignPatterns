public class Demo {
    public static void main(String[] args) {
        Crew crew = new Crew();
        crew.studyObjects();
        crew.doMaintenance();
        System.out.println("\n");

        Imposter imposter = new Imposter();
        imposter.sabotage();
        imposter.damage();

        Crewmate imposterAdapter = new ImposterAdapter(imposter);
        imposterAdapter.studyObjects();
        imposterAdapter.doMaintenance();
    }
}
