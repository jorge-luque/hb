package p118io.branch.referral;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;

/* renamed from: io.branch.referral.w */
/* compiled from: ServerRequestIdentifyUserRequest */
class C6049w extends C6036r {

    /* renamed from: j */
    C3555b.C3562g f15942j;

    public C6049w(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        try {
            if (mo34020f() != null && mo34020f().has(C6028l.Identity.mo33920a())) {
                this.f15652c.mo33988o(mo34020f().getString(C6028l.Identity.mo33920a()));
            }
            this.f15652c.mo33990p(e0Var.mo33853c().getString(C6028l.IdentityID.mo33920a()));
            this.f15652c.mo34006x(e0Var.mo33853c().getString(C6028l.Link.mo33920a()));
            if (e0Var.mo33853c().has(C6028l.ReferringData.mo33920a())) {
                this.f15652c.mo33992q(e0Var.mo33853c().getString(C6028l.ReferringData.mo33920a()));
            }
            if (this.f15942j != null) {
                this.f15942j.mo19656a(bVar.mo19635d(), (C5993d) null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    public boolean mo33819k() {
        return false;
    }

    /* renamed from: r */
    public boolean mo34029r() {
        return true;
    }

    /* renamed from: a */
    public void mo33817a(int i, String str) {
        if (this.f15942j != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            C3555b.C3562g gVar = this.f15942j;
            gVar.mo19656a(jSONObject, new C5993d("Trouble setting the user alias. " + str, i));
        }
    }

    /* renamed from: a */
    public void mo33816a() {
        this.f15942j = null;
    }
}
