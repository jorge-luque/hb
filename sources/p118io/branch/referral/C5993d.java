package p118io.branch.referral;

/* renamed from: io.branch.referral.d */
/* compiled from: BranchError */
public class C5993d {

    /* renamed from: a */
    String f15332a = "";

    public C5993d(String str, int i) {
        this.f15332a = str + m19231a(i);
    }

    /* renamed from: a */
    private String m19231a(int i) {
        return i == -113 ? " Branch API Error: poor network connectivity. Please try again later." : i == -114 ? " Branch API Error: Please enter your branch_key in your project's manifest file first." : i == -104 ? " Did you forget to call init? Make sure you init the session before making Branch calls." : i == -101 ? " Unable to initialize Branch. Check network connectivity or that your branch key is valid." : i == -102 ? " Please add 'android.permission.INTERNET' in your applications manifest file." : i == -105 ? " Unable to create a URL with that alias. If you want to reuse the alias, make sure to submit the same properties for all arguments and that the user is the same owner." : i == -106 ? " That Branch referral code is already in use." : i == -107 ? " Unable to redeem rewards. Please make sure you have credits available to redeem." : i == -108 ? "BranchApp class can be used only with API level 14 or above. Please make sure your minimum API level supported is 14. If you wish to use API level below 14 consider calling getInstance(Context) instead." : i == -109 ? "Branch instance is not created. Make  sure your Application class is an instance of BranchLikedApp." : i == -110 ? " Unable create share options. Couldn't find applications on device to share the link." : i == -111 ? " Request to Branch server timed out. Please check your internet connectivity" : i == -117 ? " Tracking is disabled. Requested operation cannot be completed when tracking is disabled" : (i >= 500 || i == -112) ? " Unable to reach the Branch servers, please try again shortly." : (i == 409 || i == -115) ? " A resource with this identifier already exists." : (i >= 400 || i == -116) ? " The request was invalid." : " Check network connectivity and that you properly initialized.";
    }

    /* renamed from: a */
    public String mo33826a() {
        return this.f15332a;
    }

    public String toString() {
        return mo33826a();
    }
}
