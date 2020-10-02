package p093e.p094a.p095a;

import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* renamed from: e.a.a.u */
/* compiled from: EventResponseData */
public class C3348u extends C3346t0 {

    /* renamed from: i */
    private String f9400i;

    /* renamed from: j */
    private String f9401j;

    /* renamed from: k */
    private String f9402k;

    public C3348u(C3276c cVar) {
        this.f9400i = cVar.mo18973i().get("event_token");
        this.f9401j = cVar.mo18973i().get("event_callback_id");
        this.f9402k = C3268a1.m10853b(cVar.mo18967e());
    }

    /* renamed from: a */
    public C3305i mo19095a() {
        if (this.f9391a) {
            return null;
        }
        C3305i iVar = new C3305i();
        if (TapjoyConstants.TJC_PLUGIN_UNITY.equals(this.f9402k)) {
            String str = this.f9400i;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            iVar.f9234e = str;
            String str3 = this.f9394d;
            if (str3 == null) {
                str3 = str2;
            }
            iVar.f9232c = str3;
            String str4 = this.f9395e;
            if (str4 == null) {
                str4 = str2;
            }
            iVar.f9233d = str4;
            String str5 = this.f9393c;
            if (str5 == null) {
                str5 = str2;
            }
            iVar.f9231b = str5;
            String str6 = this.f9401j;
            if (str6 != null) {
                str2 = str6;
            }
            iVar.f9235f = str2;
            iVar.f9230a = this.f9392b;
            JSONObject jSONObject = this.f9396f;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            iVar.f9236g = jSONObject;
        } else {
            iVar.f9234e = this.f9400i;
            iVar.f9232c = this.f9394d;
            iVar.f9233d = this.f9395e;
            iVar.f9231b = this.f9393c;
            iVar.f9235f = this.f9401j;
            iVar.f9230a = this.f9392b;
            iVar.f9236g = this.f9396f;
        }
        return iVar;
    }

    /* renamed from: b */
    public C3307j mo19096b() {
        if (!this.f9391a) {
            return null;
        }
        C3307j jVar = new C3307j();
        if (TapjoyConstants.TJC_PLUGIN_UNITY.equals(this.f9402k)) {
            String str = this.f9400i;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            jVar.f9240d = str;
            String str3 = this.f9394d;
            if (str3 == null) {
                str3 = str2;
            }
            jVar.f9238b = str3;
            String str4 = this.f9395e;
            if (str4 == null) {
                str4 = str2;
            }
            jVar.f9239c = str4;
            String str5 = this.f9393c;
            if (str5 == null) {
                str5 = str2;
            }
            jVar.f9237a = str5;
            String str6 = this.f9401j;
            if (str6 != null) {
                str2 = str6;
            }
            jVar.f9241e = str2;
            JSONObject jSONObject = this.f9396f;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jVar.f9242f = jSONObject;
        } else {
            jVar.f9240d = this.f9400i;
            jVar.f9238b = this.f9394d;
            jVar.f9239c = this.f9395e;
            jVar.f9237a = this.f9393c;
            jVar.f9241e = this.f9401j;
            jVar.f9242f = this.f9396f;
        }
        return jVar;
    }
}
