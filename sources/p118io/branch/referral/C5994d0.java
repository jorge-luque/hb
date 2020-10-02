package p118io.branch.referral;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;

/* renamed from: io.branch.referral.d0 */
/* compiled from: ServerRequestRegisterOpen */
class C5994d0 extends C6050x {

    /* renamed from: m */
    C3555b.C3562g f15333m;

    C5994d0(Context context, C3555b.C3562g gVar, C6005g0 g0Var) {
        super(context, C6030n.RegisterOpen.mo33924a(), g0Var);
        this.f15333m = gVar;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C6028l.DeviceFingerprintID.mo33920a(), this.f15652c.mo33975i());
            jSONObject.put(C6028l.IdentityID.mo33920a(), this.f15652c.mo33989p());
            mo34013a(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            this.f15658i = true;
        }
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        super.mo33818a(e0Var, bVar);
        try {
            if (e0Var.mo33853c().has(C6028l.LinkClickID.mo33920a())) {
                this.f15652c.mo33995s(e0Var.mo33853c().getString(C6028l.LinkClickID.mo33920a()));
            } else {
                this.f15652c.mo33995s("bnc_no_value");
            }
            if (e0Var.mo33853c().has(C6028l.Data.mo33920a())) {
                JSONObject jSONObject = new JSONObject(e0Var.mo33853c().getString(C6028l.Data.mo33920a()));
                if (jSONObject.has(C6028l.Clicked_Branch_Link.mo33920a()) && jSONObject.getBoolean(C6028l.Clicked_Branch_Link.mo33920a()) && this.f15652c.mo33993r().equals("bnc_no_value") && this.f15652c.mo33997t() == 1) {
                    this.f15652c.mo33992q(e0Var.mo33853c().getString(C6028l.Data.mo33920a()));
                }
            }
            if (e0Var.mo33853c().has(C6028l.Data.mo33920a())) {
                this.f15652c.mo34004w(e0Var.mo33853c().getString(C6028l.Data.mo33920a()));
            } else {
                this.f15652c.mo34004w("bnc_no_value");
            }
            if (this.f15333m != null && !bVar.f9995q) {
                this.f15333m.mo19656a(bVar.mo19637e(), (C5993d) null);
            }
            this.f15652c.mo33974h(this.f15945l.mo33869a());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mo34059b(e0Var, bVar);
    }

    /* renamed from: k */
    public boolean mo33819k() {
        return false;
    }

    /* renamed from: n */
    public void mo33823n() {
        super.mo33823n();
        if (C3555b.m12034k().f10002x) {
            this.f15333m.mo19656a(C3555b.m12034k().mo19637e(), (C5993d) null);
            C3555b.m12034k().mo19636d(C6028l.InstantDeepLinkSession.mo33920a(), "true");
            C3555b.m12034k().f10002x = false;
            C3555b.m12034k().f9995q = true;
        }
    }

    /* renamed from: u */
    public String mo33824u() {
        return "open";
    }

    /* renamed from: v */
    public boolean mo33825v() {
        return this.f15333m != null;
    }

    C5994d0(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo33828a(C3555b.C3562g gVar) {
        if (gVar != null) {
            this.f15333m = gVar;
        }
    }

    /* renamed from: a */
    public void mo33817a(int i, String str) {
        if (this.f15333m != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            C3555b.C3562g gVar = this.f15333m;
            gVar.mo19656a(jSONObject, new C5993d("Trouble initializing Branch. " + str, i));
        }
    }

    /* renamed from: a */
    public void mo33816a() {
        this.f15333m = null;
    }
}
