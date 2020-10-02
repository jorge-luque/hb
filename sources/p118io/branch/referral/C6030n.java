package p118io.branch.referral;

/* renamed from: io.branch.referral.n */
/* compiled from: Defines */
public enum C6030n {
    RedeemRewards("v1/redeem"),
    GetURL("v1/url"),
    GetApp("v1/app-link-settings"),
    RegisterInstall("v1/install"),
    RegisterClose("v1/close"),
    RegisterOpen("v1/open"),
    RegisterView("v1/register-view"),
    GetCredits("v1/credits/"),
    GetCreditHistory("v1/credithistory"),
    CompletedAction("v1/event"),
    IdentifyUser("v1/profile"),
    Logout("v1/logout"),
    GetReferralCode("v1/referralcode"),
    ValidateReferralCode("v1/referralcode/"),
    ApplyReferralCode("v1/applycode/"),
    DebugConnect("v1/debug/connect"),
    ContentEvent("v1/content-events"),
    TrackStandardEvent("v2/event/standard"),
    TrackCustomEvent("v2/event/custom");
    

    /* renamed from: a */
    private String f15620a;

    static {
        RedeemRewards = new C6030n("RedeemRewards", 0, "v1/redeem");
        GetURL = new C6030n("GetURL", 1, "v1/url");
        GetApp = new C6030n("GetApp", 2, "v1/app-link-settings");
        RegisterInstall = new C6030n("RegisterInstall", 3, "v1/install");
        RegisterClose = new C6030n("RegisterClose", 4, "v1/close");
        RegisterOpen = new C6030n("RegisterOpen", 5, "v1/open");
        RegisterView = new C6030n("RegisterView", 6, "v1/register-view");
        GetCredits = new C6030n("GetCredits", 7, "v1/credits/");
        GetCreditHistory = new C6030n("GetCreditHistory", 8, "v1/credithistory");
        CompletedAction = new C6030n("CompletedAction", 9, "v1/event");
        IdentifyUser = new C6030n("IdentifyUser", 10, "v1/profile");
        Logout = new C6030n("Logout", 11, "v1/logout");
        GetReferralCode = new C6030n("GetReferralCode", 12, "v1/referralcode");
        ValidateReferralCode = new C6030n("ValidateReferralCode", 13, "v1/referralcode/");
        ApplyReferralCode = new C6030n("ApplyReferralCode", 14, "v1/applycode/");
        DebugConnect = new C6030n("DebugConnect", 15, "v1/debug/connect");
        ContentEvent = new C6030n("ContentEvent", 16, "v1/content-events");
        TrackStandardEvent = new C6030n("TrackStandardEvent", 17, "v2/event/standard");
        TrackCustomEvent = new C6030n("TrackCustomEvent", 18, "v2/event/custom");
    }

    private C6030n(String str) {
        this.f15620a = "";
        this.f15620a = str;
    }

    /* renamed from: a */
    public String mo33924a() {
        return this.f15620a;
    }

    public String toString() {
        return this.f15620a;
    }
}
