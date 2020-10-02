package p118io.branch.referral;

import android.app.Activity;
import android.content.Context;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C6014j;

/* renamed from: io.branch.referral.s */
/* compiled from: ServerRequestActionCompleted */
class C6039s extends C6036r {

    /* renamed from: j */
    private final C6014j.C3571d f15666j = null;

    public C6039s(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    /* renamed from: a */
    public void mo33816a() {
    }

    /* renamed from: a */
    public void mo33817a(int i, String str) {
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        if (e0Var.mo33853c() != null && e0Var.mo33853c().has(C6028l.BranchViewData.mo33920a()) && C3555b.m12034k().f9994p != null && C3555b.m12034k().f9994p.get() != null) {
            String str = "";
            try {
                JSONObject f = mo34020f();
                if (f != null && f.has(C6028l.Event.mo33920a())) {
                    str = f.getString(C6028l.Event.mo33920a());
                }
                if (C3555b.m12034k().f9994p != null) {
                    JSONObject jSONObject = e0Var.mo33853c().getJSONObject(C6028l.BranchViewData.mo33920a());
                    C6014j.m19321a().mo33902a(jSONObject, str, (Context) (Activity) C3555b.m12034k().f9994p.get(), this.f15666j);
                }
            } catch (JSONException unused) {
                C6014j.C3571d dVar = this.f15666j;
                if (dVar != null) {
                    dVar.mo19625a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES, "Unable to show branch view. Branch view received is invalid ", str);
                }
            }
        }
    }

    /* renamed from: j */
    public boolean mo34024j() {
        return true;
    }

    /* renamed from: k */
    public boolean mo33819k() {
        return false;
    }

    /* renamed from: r */
    public boolean mo34029r() {
        return true;
    }
}
