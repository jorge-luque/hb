package p093e.p094a.p095a;

import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* renamed from: e.a.a.x0 */
/* compiled from: SessionResponseData */
public class C3363x0 extends C3346t0 {

    /* renamed from: i */
    private String f9427i;

    public C3363x0(C3276c cVar) {
        this.f9427i = C3268a1.m10853b(cVar.mo18967e());
    }

    /* renamed from: a */
    public C3318n mo19112a() {
        if (this.f9391a) {
            return null;
        }
        C3318n nVar = new C3318n();
        if (TapjoyConstants.TJC_PLUGIN_UNITY.equals(this.f9427i)) {
            String str = this.f9394d;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            nVar.f9276c = str;
            String str3 = this.f9395e;
            if (str3 == null) {
                str3 = str2;
            }
            nVar.f9277d = str3;
            String str4 = this.f9393c;
            if (str4 != null) {
                str2 = str4;
            }
            nVar.f9275b = str2;
            nVar.f9274a = this.f9392b;
            JSONObject jSONObject = this.f9396f;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            nVar.f9278e = jSONObject;
        } else {
            nVar.f9276c = this.f9394d;
            nVar.f9277d = this.f9395e;
            nVar.f9275b = this.f9393c;
            nVar.f9274a = this.f9392b;
            nVar.f9278e = this.f9396f;
        }
        return nVar;
    }

    /* renamed from: b */
    public C3320o mo19113b() {
        if (!this.f9391a) {
            return null;
        }
        C3320o oVar = new C3320o();
        if (TapjoyConstants.TJC_PLUGIN_UNITY.equals(this.f9427i)) {
            String str = this.f9394d;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            oVar.f9280b = str;
            String str3 = this.f9395e;
            if (str3 == null) {
                str3 = str2;
            }
            oVar.f9281c = str3;
            String str4 = this.f9393c;
            if (str4 != null) {
                str2 = str4;
            }
            oVar.f9279a = str2;
            JSONObject jSONObject = this.f9396f;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            oVar.f9282d = jSONObject;
        } else {
            oVar.f9280b = this.f9394d;
            oVar.f9281c = this.f9395e;
            oVar.f9279a = this.f9393c;
            oVar.f9282d = this.f9396f;
        }
        return oVar;
    }
}
