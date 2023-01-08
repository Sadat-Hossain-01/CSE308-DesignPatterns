package data;

public class BundleCheckRequest extends CheckRequest {
    private ScriptBundle scriptBundle;
    private int examinerID;
    public ScriptBundle getScriptBundle() {
        return scriptBundle;
    }

    public BundleCheckRequest(ScriptBundle scriptBundle, int examinerID) {
        this.scriptBundle = scriptBundle;
        this.examinerID = examinerID;
    }
}
