package p118io.branch.referral;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;

/* renamed from: io.branch.referral.a0 */
/* compiled from: ServerRequestRedeemRewards */
class C5989a0 extends C6036r {

    /* renamed from: j */
    C3555b.C3563h f15330j;

    public C5989a0(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        C5993d dVar;
        JSONObject f = mo34020f();
        boolean z = false;
        if (f != null && f.has(C6028l.Bucket.mo33920a()) && f.has(C6028l.Amount.mo33920a())) {
            try {
                int i = f.getInt(C6028l.Amount.mo33920a());
                String string = f.getString(C6028l.Bucket.mo33920a());
                if (i > 0) {
                    z = true;
                }
                this.f15652c.mo33965d(string, this.f15652c.mo33960c(string) - i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.f15330j != null) {
            if (z) {
                dVar = null;
            } else {
                dVar = new C5993d("Trouble redeeming rewards.", -107);
            }
            this.f15330j.mo19657a(z, dVar);
        }
    }

    /* renamed from: k */
    public boolean mo33819k() {
        return false;
    }

    /* renamed from: a */
    public void mo33817a(int i, String str) {
        C3555b.C3563h hVar = this.f15330j;
        if (hVar != null) {
            hVar.mo19657a(false, new C5993d("Trouble redeeming rewards. " + str, i));
        }
    }

    /* renamed from: a */
    public void mo33816a() {
        this.f15330j = null;
    }
}
