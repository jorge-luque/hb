package p118io.branch.referral;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;

/* renamed from: io.branch.referral.u */
/* compiled from: ServerRequestGetRewardHistory */
class C6041u extends C6036r {

    /* renamed from: j */
    C3555b.C3560e f15672j;

    public C6041u(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        C3555b.C3560e eVar = this.f15672j;
        if (eVar != null) {
            eVar.mo19650a(e0Var.mo33850a(), (C5993d) null);
        }
    }

    /* renamed from: k */
    public boolean mo33819k() {
        return false;
    }

    /* renamed from: a */
    public void mo33817a(int i, String str) {
        C3555b.C3560e eVar = this.f15672j;
        if (eVar != null) {
            eVar.mo19650a((JSONArray) null, new C5993d("Trouble retrieving user credit history. " + str, i));
        }
    }

    /* renamed from: a */
    public void mo33816a() {
        this.f15672j = null;
    }
}
