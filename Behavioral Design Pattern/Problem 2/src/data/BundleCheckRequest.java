package data;

public class BundleCheckRequest extends CheckRequest {
    private ScriptBundle scriptBundle;
    private int examinerID; // although examinerID is contained in the bundle scripts

    public BundleCheckRequest(ScriptBundle scriptBundle, int examinerID) {
        this.scriptBundle = scriptBundle;
        this.examinerID = examinerID;
    }
}
