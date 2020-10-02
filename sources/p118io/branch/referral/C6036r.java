package p118io.branch.referral;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Log;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.branch.referral.r */
/* compiled from: ServerRequest */
public abstract class C6036r {

    /* renamed from: a */
    private JSONObject f15650a;

    /* renamed from: b */
    protected String f15651b;

    /* renamed from: c */
    protected final C6035q f15652c;

    /* renamed from: d */
    private final C6005g0 f15653d;

    /* renamed from: e */
    long f15654e = 0;

    /* renamed from: f */
    private boolean f15655f;

    /* renamed from: g */
    private final Context f15656g;

    /* renamed from: h */
    final Set<C6038b> f15657h;

    /* renamed from: i */
    public boolean f15658i = false;

    /* renamed from: io.branch.referral.r$a */
    /* compiled from: ServerRequest */
    public enum C6037a {
        V1,
        V2;

        static {
            V1 = new C6037a("V1", 0);
            V2 = new C6037a("V2", 1);
        }
    }

    /* renamed from: io.branch.referral.r$b */
    /* compiled from: ServerRequest */
    enum C6038b {
        FB_APP_LINK_WAIT_LOCK,
        GAID_FETCH_WAIT_LOCK,
        INTENT_PENDING_WAIT_LOCK,
        STRONG_MATCH_PENDING_WAIT_LOCK,
        INSTALL_REFERRER_FETCH_WAIT_LOCK;

        static {
            FB_APP_LINK_WAIT_LOCK = new C6038b("FB_APP_LINK_WAIT_LOCK", 0);
            GAID_FETCH_WAIT_LOCK = new C6038b("GAID_FETCH_WAIT_LOCK", 1);
            INTENT_PENDING_WAIT_LOCK = new C6038b("INTENT_PENDING_WAIT_LOCK", 2);
            STRONG_MATCH_PENDING_WAIT_LOCK = new C6038b("STRONG_MATCH_PENDING_WAIT_LOCK", 3);
            INSTALL_REFERRER_FETCH_WAIT_LOCK = new C6038b("INSTALL_REFERRER_FETCH_WAIT_LOCK", 4);
        }
    }

    public C6036r(Context context, String str) {
        this.f15656g = context;
        this.f15651b = str;
        this.f15652c = C6035q.m19395a(context);
        this.f15653d = new C6005g0(context);
        this.f15650a = new JSONObject();
        this.f15655f = C3555b.m12043o();
        this.f15657h = new HashSet();
    }

    /* renamed from: u */
    private void mo33824u() {
        JSONObject optJSONObject;
        if (mo34018d() == C6037a.V2 && (optJSONObject = this.f15650a.optJSONObject(C6028l.UserData.mo33920a())) != null) {
            try {
                optJSONObject.put(C6028l.DeveloperIdentity.mo33920a(), this.f15652c.mo33987o());
                optJSONObject.put(C6028l.DeviceFingerprintID.mo33920a(), this.f15652c.mo33975i());
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: v */
    private void mo33825v() {
        C6037a d = mo34018d();
        if (!TextUtils.isEmpty(C6005g0.f15367d)) {
            try {
                if (d == C6037a.V2) {
                    JSONObject optJSONObject = this.f15650a.optJSONObject(C6028l.UserData.mo33920a());
                    if (optJSONObject != null) {
                        optJSONObject.put(C6028l.AAID.mo33920a(), C6005g0.f15367d);
                        optJSONObject.put(C6028l.LimitedAdTracking.mo33920a(), this.f15653d.f15368a);
                        optJSONObject.remove(C6028l.UnidentifiedDevice.mo33920a());
                        return;
                    }
                    return;
                }
                this.f15650a.put(C6028l.GoogleAdvertisingID.mo33920a(), C6005g0.f15367d);
                this.f15650a.put(C6028l.LATVal.mo33920a(), this.f15653d.f15368a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            C6037a aVar = C6037a.V2;
            if (d == aVar && d == aVar) {
                try {
                    JSONObject optJSONObject2 = this.f15650a.optJSONObject(C6028l.UserData.mo33920a());
                    if (optJSONObject2 != null && !optJSONObject2.has(C6028l.AndroidID.mo33920a())) {
                        optJSONObject2.put(C6028l.UnidentifiedDevice.mo33920a(), true);
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* renamed from: w */
    private void mo34034w() {
        boolean F;
        JSONObject optJSONObject = mo34018d() == C6037a.V1 ? this.f15650a : this.f15650a.optJSONObject(C6028l.UserData.mo33920a());
        if (optJSONObject != null && (F = this.f15652c.mo33942F())) {
            try {
                optJSONObject.putOpt(C6028l.limitFacebookTracking.mo33920a(), Boolean.valueOf(F));
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: x */
    private void mo34035x() {
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<String> keys = this.f15652c.mo34007y().keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, this.f15652c.mo34007y().get(next));
            }
            JSONObject optJSONObject = this.f15650a.optJSONObject(C6028l.Metadata.mo33920a());
            if (optJSONObject != null) {
                Iterator<String> keys2 = optJSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    jSONObject.put(next2, optJSONObject.get(next2));
                }
            }
            if ((this instanceof C5992c0) && this.f15652c.mo33991q().length() > 0) {
                this.f15650a.putOpt(C6028l.InstallMetadata.mo33920a(), this.f15652c.mo33991q());
            }
            this.f15650a.put(C6028l.Metadata.mo33920a(), jSONObject);
        } catch (JSONException unused) {
            Log.e("BranchSDK", "Could not merge metadata, ignoring user metadata.");
        }
    }

    /* renamed from: a */
    public abstract void mo33816a();

    /* renamed from: a */
    public abstract void mo33817a(int i, String str);

    /* renamed from: a */
    public abstract void mo33818a(C5996e0 e0Var, C3555b bVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34013a(JSONObject jSONObject) throws JSONException {
        this.f15650a = jSONObject;
        if (mo34018d() == C6037a.V2) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                this.f15650a.put(C6028l.UserData.mo33920a(), jSONObject2);
                C6033o.m19379a(this.f15652c.mo33978j(), this.f15653d, this.f15655f).mo33931a(this.f15656g, this.f15652c, jSONObject2);
            } catch (JSONException unused) {
            }
        } else {
            C6033o.m19379a(this.f15652c.mo33978j(), this.f15653d, this.f15655f).mo33932a(this.f15650a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo34015b() {
        if (this instanceof C6050x) {
            ((C6050x) this).mo34034w();
        }
        mo33824u();
        if (mo34024j() && !C6010i.m19310a(this.f15656g)) {
            mo33825v();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo34017c() {
        mo34035x();
        if (mo34030s()) {
            mo34034w();
        }
    }

    /* renamed from: d */
    public C6037a mo34018d() {
        return C6037a.V1;
    }

    /* renamed from: e */
    public JSONObject mo34019e() {
        return this.f15650a;
    }

    /* renamed from: f */
    public JSONObject mo34020f() {
        return this.f15650a;
    }

    /* renamed from: g */
    public long mo34021g() {
        if (this.f15654e > 0) {
            return System.currentTimeMillis() - this.f15654e;
        }
        return 0;
    }

    /* renamed from: h */
    public final String mo34022h() {
        return this.f15651b;
    }

    /* renamed from: i */
    public String mo34023i() {
        return this.f15652c.mo33964d() + this.f15651b;
    }

    /* renamed from: j */
    public boolean mo34024j() {
        return false;
    }

    /* renamed from: k */
    public abstract boolean mo33819k();

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo33820l() {
        return true;
    }

    /* renamed from: m */
    public boolean mo34025m() {
        return this.f15657h.size() > 0;
    }

    /* renamed from: n */
    public void mo33823n() {
    }

    /* renamed from: o */
    public void mo34026o() {
        this.f15654e = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo34027p() {
        return false;
    }

    /* renamed from: q */
    public void mo34028q() {
        C6035q.m19397b("BranchSDK", "Requested operation cannot be completed since tracking is disabled [" + this.f15651b + "]");
        mo33817a(-117, "");
    }

    /* renamed from: r */
    public boolean mo34029r() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public boolean mo34030s() {
        return false;
    }

    /* renamed from: t */
    public JSONObject mo34031t() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("REQ_POST", this.f15650a);
            jSONObject.put("REQ_POST_PATH", this.f15651b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public void mo34016b(C6038b bVar) {
        this.f15657h.remove(bVar);
    }

    /* renamed from: b */
    private static boolean mo34033b(Context context) {
        List<ResolveInfo> queryIntentActivities;
        PackageManager packageManager = context.getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null || (queryIntentActivities = packageManager.queryIntentActivities(launchIntentForPackage, 65536)) == null || queryIntentActivities.size() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public JSONObject mo34010a(ConcurrentHashMap<String, String> concurrentHashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f15650a != null) {
                JSONObject jSONObject2 = new JSONObject(this.f15650a.toString());
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
            if (concurrentHashMap.size() <= 0) {
                return jSONObject;
            }
            JSONObject jSONObject3 = new JSONObject();
            for (String next2 : concurrentHashMap.keySet()) {
                jSONObject3.put(next2, concurrentHashMap.get(next2));
                concurrentHashMap.remove(next2);
            }
            jSONObject.put(C6028l.Branch_Instrumentation.mo33920a(), jSONObject3);
            return jSONObject;
        } catch (JSONException unused) {
            return jSONObject;
        } catch (ConcurrentModificationException unused2) {
            return this.f15650a;
        }
    }

    protected C6036r(String str, JSONObject jSONObject, Context context) {
        this.f15656g = context;
        this.f15651b = str;
        this.f15650a = jSONObject;
        this.f15652c = C6035q.m19395a(context);
        this.f15653d = new C6005g0(context);
        this.f15655f = C3555b.m12043o();
        this.f15657h = new HashSet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[Catch:{ JSONException -> 0x001f }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static p118io.branch.referral.C6036r m19475a(org.json.JSONObject r5, android.content.Context r6) {
        /*
            java.lang.String r0 = "REQ_POST_PATH"
            java.lang.String r1 = "REQ_POST"
            java.lang.String r2 = ""
            r3 = 0
            boolean r4 = r5.has(r1)     // Catch:{ JSONException -> 0x0012 }
            if (r4 == 0) goto L_0x0012
            org.json.JSONObject r1 = r5.getJSONObject(r1)     // Catch:{ JSONException -> 0x0012 }
            goto L_0x0013
        L_0x0012:
            r1 = r3
        L_0x0013:
            boolean r4 = r5.has(r0)     // Catch:{ JSONException -> 0x001f }
            if (r4 == 0) goto L_0x0020
            java.lang.String r5 = r5.getString(r0)     // Catch:{ JSONException -> 0x001f }
            r2 = r5
            goto L_0x0020
        L_0x001f:
        L_0x0020:
            if (r2 == 0) goto L_0x002d
            int r5 = r2.length()
            if (r5 <= 0) goto L_0x002d
            io.branch.referral.r r5 = m19474a(r2, r1, r6)
            return r5
        L_0x002d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C6036r.m19475a(org.json.JSONObject, android.content.Context):io.branch.referral.r");
    }

    /* renamed from: a */
    private static C6036r m19474a(String str, JSONObject jSONObject, Context context) {
        if (str.equalsIgnoreCase(C6030n.CompletedAction.mo33924a())) {
            return new C6039s(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(C6030n.GetURL.mo33924a())) {
            return new C6040t(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(C6030n.GetCreditHistory.mo33924a())) {
            return new C6041u(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(C6030n.GetCredits.mo33924a())) {
            return new C6048v(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(C6030n.IdentifyUser.mo33924a())) {
            return new C6049w(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(C6030n.Logout.mo33924a())) {
            return new C6051y(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(C6030n.RedeemRewards.mo33924a())) {
            return new C5989a0(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(C6030n.RegisterClose.mo33924a())) {
            return new C5990b0(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(C6030n.RegisterInstall.mo33924a())) {
            return new C5992c0(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(C6030n.RegisterOpen.mo33924a())) {
            return new C5994d0(str, jSONObject, context);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo34014a(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    /* renamed from: a */
    public void mo34012a(C6038b bVar) {
        if (bVar != null) {
            this.f15657h.add(bVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34011a(Context context, JSONObject jSONObject) {
        try {
            String a = (mo34033b(context) ? C6028l.NativeApp : C6028l.InstantApp).mo33920a();
            if (mo34018d() == C6037a.V2) {
                JSONObject optJSONObject = jSONObject.optJSONObject(C6028l.UserData.mo33920a());
                if (optJSONObject != null) {
                    optJSONObject.put(C6028l.Environment.mo33920a(), a);
                    return;
                }
                return;
            }
            jSONObject.put(C6028l.Environment.mo33920a(), a);
        } catch (Exception unused) {
        }
    }
}
