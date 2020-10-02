package p118io.branch.referral;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;

/* renamed from: io.branch.referral.y */
/* compiled from: ServerRequestLogout */
class C6051y extends C6036r {

    /* renamed from: j */
    private C3555b.C3567l f15946j;

    public C6051y(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        C3555b.C3567l lVar;
        try {
            this.f15652c.mo34002v(e0Var.mo33853c().getString(C6028l.SessionID.mo33920a()));
            this.f15652c.mo33990p(e0Var.mo33853c().getString(C6028l.IdentityID.mo33920a()));
            this.f15652c.mo34006x(e0Var.mo33853c().getString(C6028l.Link.mo33920a()));
            this.f15652c.mo33992q("bnc_no_value");
            this.f15652c.mo34004w("bnc_no_value");
            this.f15652c.mo33988o("bnc_no_value");
            this.f15652c.mo33961c();
            lVar = this.f15946j;
            if (lVar == null) {
                return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            lVar = this.f15946j;
            if (lVar == null) {
                return;
            }
        } catch (Throwable th) {
            C3555b.C3567l lVar2 = this.f15946j;
            if (lVar2 != null) {
                lVar2.mo19659a(true, (C5993d) null);
            }
            throw th;
        }
        lVar.mo19659a(true, (C5993d) null);
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

    /* renamed from: a */
    public void mo33817a(int i, String str) {
        C3555b.C3567l lVar = this.f15946j;
        if (lVar != null) {
            lVar.mo19659a(false, new C5993d("Logout error. " + str, i));
        }
    }

    /* renamed from: a */
    public void mo33816a() {
        this.f15946j = null;
    }
}
