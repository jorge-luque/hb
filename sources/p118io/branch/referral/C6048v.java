package p118io.branch.referral;

import android.content.Context;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;

/* renamed from: io.branch.referral.v */
/* compiled from: ServerRequestGetRewards */
class C6048v extends C6036r {

    /* renamed from: j */
    C3555b.C3563h f15941j;

    public C6048v(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        Iterator<String> keys = e0Var.mo33853c().keys();
        boolean z = false;
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                int i = e0Var.mo33853c().getInt(next);
                if (i != this.f15652c.mo33960c(next)) {
                    z = true;
                }
                this.f15652c.mo33965d(next, i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        C3555b.C3563h hVar = this.f15941j;
        if (hVar != null) {
            hVar.mo19657a(z, (C5993d) null);
        }
    }

    /* renamed from: i */
    public String mo34023i() {
        return super.mo34023i() + this.f15652c.mo33989p();
    }

    /* renamed from: k */
    public boolean mo33819k() {
        return true;
    }

    /* renamed from: a */
    public void mo33817a(int i, String str) {
        C3555b.C3563h hVar = this.f15941j;
        if (hVar != null) {
            hVar.mo19657a(false, new C5993d("Trouble retrieving user credits. " + str, i));
        }
    }

    /* renamed from: a */
    public void mo33816a() {
        this.f15941j = null;
    }
}
