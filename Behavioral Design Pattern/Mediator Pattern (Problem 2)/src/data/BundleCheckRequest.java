package data;

public class BundleCheckRequest extends CheckRequest {
    private ScriptBundle scriptBundle;
    private int examinerID; // although examinerID is contained in the bundle scripts

    public ScriptBundle getScriptBundle() {
        return scriptBundle;
    }

    public BundleCheckRequest(ScriptBundle scriptBundle, int examinerID) {
        this.scriptBundle = scriptBundle;
        this.examinerID = examinerID;
    }
}
