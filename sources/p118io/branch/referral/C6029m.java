package p118io.branch.referral;

/* renamed from: io.branch.referral.m */
/* compiled from: Defines */
public enum C6029m {
    Tags("tags"),
    Alias("alias"),
    Type("type"),
    Duration("duration"),
    Channel("channel"),
    Feature("feature"),
    Stage("stage"),
    Campaign("campaign"),
    Data("data"),
    URL("url");
    

    /* renamed from: a */
    private String f15600a;

    static {
        Tags = new C6029m("Tags", 0, "tags");
        Alias = new C6029m("Alias", 1, "alias");
        Type = new C6029m("Type", 2, "type");
        Duration = new C6029m("Duration", 3, "duration");
        Channel = new C6029m("Channel", 4, "channel");
        Feature = new C6029m("Feature", 5, "feature");
        Stage = new C6029m("Stage", 6, "stage");
        Campaign = new C6029m("Campaign", 7, "campaign");
        Data = new C6029m("Data", 8, "data");
        URL = new C6029m("URL", 9, "url");
    }

    private C6029m(String str) {
        this.f15600a = "";
        this.f15600a = str;
    }

    /* renamed from: a */
    public String mo33922a() {
        return this.f15600a;
    }

    public String toString() {
        return this.f15600a;
    }
}
