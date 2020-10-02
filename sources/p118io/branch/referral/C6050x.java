package p118io.branch.referral;

import android.app.Activity;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.indexing.C5975a;
import p118io.branch.indexing.C5980b;
import p118io.branch.referral.C3555b;
import p118io.branch.referral.C6014j;
import p118io.branch.referral.p199j0.C6019a;

/* renamed from: io.branch.referral.x */
/* compiled from: ServerRequestInitSession */
abstract class C6050x extends C6036r {

    /* renamed from: j */
    private final Context f15943j;

    /* renamed from: k */
    private final C5980b f15944k;

    /* renamed from: l */
    final C6005g0 f15945l;

    C6050x(Context context, String str, C6005g0 g0Var) {
        super(context, str);
        this.f15943j = context;
        this.f15945l = g0Var;
        this.f15944k = C5980b.m19178a(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo34013a(JSONObject jSONObject) throws JSONException {
        super.mo34013a(jSONObject);
        if (!this.f15945l.mo33869a().equals("bnc_no_value")) {
            jSONObject.put(C6028l.AppVersion.mo33920a(), this.f15945l.mo33869a());
        }
        jSONObject.put(C6028l.FaceBookAppLinkChecked.mo33920a(), this.f15652c.mo33996s());
        jSONObject.put(C6028l.IsReferrable.mo33920a(), this.f15652c.mo33997t());
        jSONObject.put(C6028l.Debug.mo33920a(), this.f15652c.mo33978j());
        m19564b(jSONObject);
        mo34011a(this.f15943j, jSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo34059b(C5996e0 e0Var, C3555b bVar) {
        C5980b bVar2 = this.f15944k;
        if (bVar2 != null) {
            bVar2.mo33802a(e0Var.mo33853c());
            if (bVar.f9994p != null) {
                try {
                    C5975a.m19150a().mo33795b((Activity) bVar.f9994p.get(), bVar.f9998t);
                } catch (Exception unused) {
                }
            }
        }
        C6019a.m19353a(bVar.f9994p);
        bVar.mo19639g();
    }

    /* renamed from: j */
    public boolean mo34024j() {
        return true;
    }

    /* renamed from: n */
    public void mo33823n() {
        JSONObject f = mo34020f();
        try {
            if (!this.f15652c.mo33967e().equals("bnc_no_value")) {
                f.put(C6028l.AndroidAppLinkURL.mo33920a(), this.f15652c.mo33967e());
            }
            if (!this.f15652c.mo34005x().equals("bnc_no_value")) {
                f.put(C6028l.AndroidPushIdentifier.mo33920a(), this.f15652c.mo34005x());
            }
            if (!this.f15652c.mo33981l().equals("bnc_no_value")) {
                f.put(C6028l.External_Intent_URI.mo33920a(), this.f15652c.mo33981l());
            }
            if (!this.f15652c.mo33979k().equals("bnc_no_value")) {
                f.put(C6028l.External_Intent_Extra.mo33920a(), this.f15652c.mo33979k());
            }
            if (this.f15944k != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mv", this.f15944k.mo33801a());
                jSONObject.put("pn", this.f15943j.getPackageName());
                f.put("cd", jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo34027p() {
        JSONObject f = mo34020f();
        if (!f.has(C6028l.AndroidAppLinkURL.mo33920a()) && !f.has(C6028l.AndroidPushIdentifier.mo33920a()) && !f.has(C6028l.LinkIdentifier.mo33920a())) {
            return super.mo34027p();
        }
        f.remove(C6028l.DeviceFingerprintID.mo33920a());
        f.remove(C6028l.IdentityID.mo33920a());
        f.remove(C6028l.FaceBookAppLinkChecked.mo33920a());
        f.remove(C6028l.External_Intent_Extra.mo33920a());
        f.remove(C6028l.External_Intent_URI.mo33920a());
        f.remove(C6028l.FirstInstallTime.mo33920a());
        f.remove(C6028l.LastUpdateTime.mo33920a());
        f.remove(C6028l.OriginalInstallTime.mo33920a());
        f.remove(C6028l.PreviousUpdateTime.mo33920a());
        f.remove(C6028l.InstallBeginTimeStamp.mo33920a());
        f.remove(C6028l.ClickedReferrerTimeStamp.mo33920a());
        f.remove(C6028l.HardwareID.mo33920a());
        f.remove(C6028l.IsHardwareIDReal.mo33920a());
        f.remove(C6028l.LocalIP.mo33920a());
        try {
            f.put(C6028l.TrackingDisabled.mo33920a(), true);
        } catch (JSONException unused) {
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public boolean mo34030s() {
        return true;
    }

    /* renamed from: u */
    public abstract String mo33824u();

    /* renamed from: v */
    public abstract boolean mo33825v();

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public void mo34034w() {
        String w = this.f15652c.mo34003w();
        if (!w.equals("bnc_no_value")) {
            try {
                mo34020f().put(C6028l.LinkIdentifier.mo33920a(), w);
                mo34020f().put(C6028l.FaceBookAppLinkChecked.mo33920a(), this.f15652c.mo33996s());
            } catch (JSONException unused) {
            }
        }
        String n = this.f15652c.mo33985n();
        if (!n.equals("bnc_no_value")) {
            try {
                mo34020f().put(C6028l.GoogleSearchInstallReferrer.mo33920a(), n);
            } catch (JSONException unused2) {
            }
        }
        String m = this.f15652c.mo33983m();
        if (!m.equals("bnc_no_value")) {
            try {
                mo34020f().put(C6028l.GooglePlayInstallReferrer.mo33920a(), m);
            } catch (JSONException unused3) {
            }
        }
        if (this.f15652c.mo33943G()) {
            try {
                mo34020f().put(C6028l.AndroidAppLinkURL.mo33920a(), this.f15652c.mo33967e());
                mo34020f().put(C6028l.IsFullAppConv.mo33920a(), true);
            } catch (JSONException unused4) {
            }
        }
    }

    C6050x(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.f15943j = context;
        this.f15945l = new C6005g0(context);
        this.f15944k = C5980b.m19178a(this.f15943j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        if ((r2.lastUpdateTime - r2.firstInstallTime) >= 86400000) goto L_0x0043;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m19564b(org.json.JSONObject r10) throws org.json.JSONException {
        /*
            r9 = this;
            io.branch.referral.g0 r0 = r9.f15945l
            java.lang.String r0 = r0.mo33869a()
            r1 = 0
            android.content.Context r2 = r9.f15943j     // Catch:{ NameNotFoundException -> 0x0018 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0018 }
            android.content.Context r3 = r9.f15943j     // Catch:{ NameNotFoundException -> 0x0018 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0018 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            io.branch.referral.q r3 = r9.f15652c
            java.lang.String r3 = r3.mo33969f()
            java.lang.String r4 = "bnc_no_value"
            boolean r3 = r4.equals(r3)
            r4 = 2
            if (r3 == 0) goto L_0x0037
            if (r2 == 0) goto L_0x0046
            long r5 = r2.lastUpdateTime
            long r7 = r2.firstInstallTime
            long r5 = r5 - r7
            r7 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x0046
            goto L_0x0043
        L_0x0037:
            io.branch.referral.q r1 = r9.f15652c
            java.lang.String r1 = r1.mo33969f()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0045
        L_0x0043:
            r1 = 2
            goto L_0x0046
        L_0x0045:
            r1 = 1
        L_0x0046:
            io.branch.referral.l r0 = p118io.branch.referral.C6028l.Update
            java.lang.String r0 = r0.mo33920a()
            r10.put(r0, r1)
            if (r2 == 0) goto L_0x00b0
            io.branch.referral.l r0 = p118io.branch.referral.C6028l.FirstInstallTime
            java.lang.String r0 = r0.mo33920a()
            long r3 = r2.firstInstallTime
            r10.put(r0, r3)
            io.branch.referral.l r0 = p118io.branch.referral.C6028l.LastUpdateTime
            java.lang.String r0 = r0.mo33920a()
            long r3 = r2.lastUpdateTime
            r10.put(r0, r3)
            io.branch.referral.q r0 = r9.f15652c
            java.lang.String r1 = "bnc_original_install_time"
            long r3 = r0.mo33966e(r1)
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x007c
            long r3 = r2.firstInstallTime
            io.branch.referral.q r0 = r9.f15652c
            r0.mo33951a((java.lang.String) r1, (long) r3)
        L_0x007c:
            io.branch.referral.l r0 = p118io.branch.referral.C6028l.OriginalInstallTime
            java.lang.String r0 = r0.mo33920a()
            r10.put(r0, r3)
            io.branch.referral.q r0 = r9.f15652c
            java.lang.String r1 = "bnc_last_known_update_time"
            long r3 = r0.mo33966e(r1)
            long r5 = r2.lastUpdateTime
            java.lang.String r0 = "bnc_previous_update_time"
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a1
            io.branch.referral.q r5 = r9.f15652c
            r5.mo33951a((java.lang.String) r0, (long) r3)
            io.branch.referral.q r3 = r9.f15652c
            long r4 = r2.lastUpdateTime
            r3.mo33951a((java.lang.String) r1, (long) r4)
        L_0x00a1:
            io.branch.referral.l r1 = p118io.branch.referral.C6028l.PreviousUpdateTime
            java.lang.String r1 = r1.mo33920a()
            io.branch.referral.q r2 = r9.f15652c
            long r2 = r2.mo33966e(r0)
            r10.put(r1, r2)
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p118io.branch.referral.C6050x.m19564b(org.json.JSONObject):void");
    }

    /* renamed from: a */
    static boolean m19563a(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("open") || str.equalsIgnoreCase("install");
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo34058a(C5996e0 e0Var) {
        if (!(e0Var == null || e0Var.mo33853c() == null || !e0Var.mo33853c().has(C6028l.BranchViewData.mo33920a()))) {
            try {
                JSONObject jSONObject = e0Var.mo33853c().getJSONObject(C6028l.BranchViewData.mo33920a());
                String u = mo33824u();
                if (C3555b.m12034k().f9994p == null || C3555b.m12034k().f9994p.get() == null) {
                    return C6014j.m19321a().mo33901a(jSONObject, u);
                }
                Activity activity = (Activity) C3555b.m12034k().f9994p.get();
                boolean z = true;
                if (activity instanceof C3555b.C3565j) {
                    z = true ^ ((C3555b.C3565j) activity).mo19658a();
                }
                if (z) {
                    return C6014j.m19321a().mo33902a(jSONObject, u, (Context) activity, (C6014j.C3571d) C3555b.m12034k());
                }
                return C6014j.m19321a().mo33901a(jSONObject, u);
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        try {
            this.f15652c.mo33998t("bnc_no_value");
            this.f15652c.mo33986n("bnc_no_value");
            this.f15652c.mo33984m("bnc_no_value");
            this.f15652c.mo33982l("bnc_no_value");
            this.f15652c.mo33980k("bnc_no_value");
            this.f15652c.mo33972g("bnc_no_value");
            this.f15652c.mo34000u("bnc_no_value");
            this.f15652c.mo33950a((Boolean) false);
            this.f15652c.mo33994r("bnc_no_value");
            this.f15652c.mo33959b(false);
            if (e0Var.mo33853c() != null && e0Var.mo33853c().has(C6028l.Data.mo33920a())) {
                JSONObject jSONObject = new JSONObject(e0Var.mo33853c().getString(C6028l.Data.mo33920a()));
                if (jSONObject.optBoolean(C6028l.Clicked_Branch_Link.mo33920a())) {
                    new C6034p().mo33936a(this instanceof C5992c0 ? "Branch Install" : "Branch Open", jSONObject, this.f15652c.mo33989p());
                }
            }
        } catch (JSONException unused) {
        }
        if (this.f15652c.mo33966e("bnc_previous_update_time") == 0) {
            C6035q qVar = this.f15652c;
            qVar.mo33951a("bnc_previous_update_time", qVar.mo33966e("bnc_last_known_update_time"));
        }
    }
}
