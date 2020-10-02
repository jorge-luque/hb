package p118io.branch.referral;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.indexing.C5975a;

/* renamed from: io.branch.referral.b0 */
/* compiled from: ServerRequestRegisterClose */
class C5990b0 extends C6036r {
    public C5990b0(Context context) {
        super(context, C6030n.RegisterClose.mo33924a());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C6028l.DeviceFingerprintID.mo33920a(), this.f15652c.mo33975i());
            jSONObject.put(C6028l.IdentityID.mo33920a(), this.f15652c.mo33989p());
            jSONObject.put(C6028l.SessionID.mo33920a(), this.f15652c.mo33938B());
            if (!this.f15652c.mo34001v().equals("bnc_no_value")) {
                jSONObject.put(C6028l.LinkClickID.mo33920a(), this.f15652c.mo34001v());
            }
            JSONObject a = C5975a.m19150a().mo33792a(context);
            if (a != null) {
                jSONObject.put(C6028l.ContentDiscovery.mo33920a(), a);
            }
            if (C6033o.m19381e() != null) {
                jSONObject.put(C6028l.AppVersion.mo33920a(), C6033o.m19381e().mo33930a());
            }
            mo34013a(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            this.f15658i = true;
        }
    }

    /* renamed from: a */
    public void mo33816a() {
    }

    /* renamed from: a */
    public void mo33817a(int i, String str) {
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        this.f15652c.mo34004w("bnc_no_value");
    }

    /* renamed from: k */
    public boolean mo33819k() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo33820l() {
        return false;
    }

    public C5990b0(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }
}
