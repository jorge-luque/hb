package p118io.branch.referral;

import android.content.Context;
import com.applovin.sdk.AppLovinErrorCodes;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.branch.referral.C3555b;

/* renamed from: io.branch.referral.t */
/* compiled from: ServerRequestCreateUrl */
class C6040t extends C6036r {

    /* renamed from: j */
    private C5995e f15667j;

    /* renamed from: k */
    private boolean f15668k = true;

    /* renamed from: l */
    private C3555b.C3559d f15669l;

    /* renamed from: m */
    private boolean f15670m;

    /* renamed from: n */
    private boolean f15671n = true;

    public C6040t(Context context, String str, int i, int i2, Collection<String> collection, String str2, String str3, String str4, String str5, JSONObject jSONObject, C3555b.C3559d dVar, boolean z, boolean z2) {
        super(context, C6030n.GetURL.mo33924a());
        this.f15669l = dVar;
        this.f15668k = z;
        this.f15671n = z2;
        C5995e eVar = new C5995e();
        this.f15667j = eVar;
        try {
            eVar.put(C6028l.IdentityID.mo33920a(), this.f15652c.mo33989p());
            this.f15667j.put(C6028l.DeviceFingerprintID.mo33920a(), this.f15652c.mo33975i());
            this.f15667j.put(C6028l.SessionID.mo33920a(), this.f15652c.mo33938B());
            if (!this.f15652c.mo34001v().equals("bnc_no_value")) {
                this.f15667j.put(C6028l.LinkClickID.mo33920a(), this.f15652c.mo34001v());
            }
            this.f15667j.mo33835b(i);
            this.f15667j.mo33830a(i2);
            this.f15667j.mo33832a(collection);
            this.f15667j.mo33831a(str);
            this.f15667j.mo33838c(str2);
            this.f15667j.mo33840d(str3);
            this.f15667j.mo33842e(str4);
            this.f15667j.mo33836b(str5);
            this.f15667j.mo33833a(jSONObject);
            mo34013a((JSONObject) this.f15667j);
        } catch (JSONException e) {
            e.printStackTrace();
            this.f15658i = true;
        }
    }

    /* renamed from: c */
    private void m19516c(String str) {
        JSONObject f = this.f15667j.mo33844f();
        if (mo34037z() && f != null) {
            new C6034p().mo33936a("Branch Share", f, this.f15652c.mo33989p());
        }
    }

    /* renamed from: a */
    public void mo33818a(C5996e0 e0Var, C3555b bVar) {
        try {
            String string = e0Var.mo33853c().getString("url");
            if (this.f15669l != null) {
                this.f15669l.mo19649a(string, (C5993d) null);
            }
            m19516c(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public boolean mo34033b(Context context) {
        if (super.mo34014a(context)) {
            return false;
        }
        C3555b.C3559d dVar = this.f15669l;
        if (dVar == null) {
            return true;
        }
        dVar.mo19649a((String) null, new C5993d("Trouble creating a URL.", AppLovinErrorCodes.FETCH_AD_TIMEOUT));
        return true;
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

    /* renamed from: u */
    public C5995e mo33824u() {
        return this.f15667j;
    }

    /* renamed from: v */
    public String mo33825v() {
        if (!this.f15652c.mo33941E().equals("bnc_no_value")) {
            return m19515b(this.f15652c.mo33941E());
        }
        return m19515b("https://bnc.lt/a/" + this.f15652c.mo33973h());
    }

    /* renamed from: w */
    public void mo34034w() {
        C3555b.C3559d dVar = this.f15669l;
        if (dVar != null) {
            dVar.mo19649a((String) null, new C5993d("Trouble creating a URL.", -105));
        }
    }

    /* renamed from: x */
    public boolean mo34035x() {
        return this.f15668k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public boolean mo34036y() {
        return this.f15671n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public boolean mo34037z() {
        return this.f15670m;
    }

    /* renamed from: b */
    private String m19515b(String str) {
        String str2;
        try {
            String str3 = "";
            if (C3555b.m12034k().mo19638f()) {
                if (!str.contains("https://bnc.lt/a/")) {
                    str = str.replace(new URL(str).getQuery(), str3);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.contains("?")) {
                str2 = str3;
            } else {
                str2 = "?";
            }
            sb.append(str2);
            str = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            if (!str.endsWith("?")) {
                str3 = "&";
            }
            sb2.append(str3);
            str = sb2.toString();
            Collection<String> i = this.f15667j.mo33848i();
            if (i != null) {
                for (String next : i) {
                    if (next != null && next.length() > 0) {
                        str = str + C6029m.Tags + "=" + URLEncoder.encode(next, "UTF8") + "&";
                    }
                }
            }
            String a = this.f15667j.mo33829a();
            if (a != null && a.length() > 0) {
                str = str + C6029m.Alias + "=" + URLEncoder.encode(a, "UTF8") + "&";
            }
            String c = this.f15667j.mo33837c();
            if (c != null && c.length() > 0) {
                str = str + C6029m.Channel + "=" + URLEncoder.encode(c, "UTF8") + "&";
            }
            String e = this.f15667j.mo33841e();
            if (e != null && e.length() > 0) {
                str = str + C6029m.Feature + "=" + URLEncoder.encode(e, "UTF8") + "&";
            }
            String h = this.f15667j.mo33846h();
            if (h != null && h.length() > 0) {
                str = str + C6029m.Stage + "=" + URLEncoder.encode(h, "UTF8") + "&";
            }
            String b = this.f15667j.mo33834b();
            if (b != null && b.length() > 0) {
                str = str + C6029m.Campaign + "=" + URLEncoder.encode(b, "UTF8") + "&";
            }
            String str4 = (str + C6029m.Type + "=" + ((long) this.f15667j.mo33849j()) + "&") + C6029m.Duration + "=" + ((long) this.f15667j.mo33839d());
            String jSONObject = this.f15667j.mo33845g().toString();
            if (jSONObject == null || jSONObject.length() <= 0) {
                return str4;
            }
            return str4 + "&source=android&data=" + URLEncoder.encode(C5985a.m19210c(jSONObject.getBytes(), 2), "UTF8");
        } catch (Exception unused) {
            this.f15669l.mo19649a((String) null, new C5993d("Trouble creating a URL.", -116));
            return str;
        }
    }

    /* renamed from: a */
    public void mo34032a(String str) {
        C3555b.C3559d dVar = this.f15669l;
        if (dVar != null) {
            dVar.mo19649a(str, (C5993d) null);
        }
        m19516c(str);
    }

    /* renamed from: a */
    public void mo33817a(int i, String str) {
        if (this.f15669l != null) {
            String str2 = null;
            if (this.f15671n) {
                str2 = mo33825v();
            }
            C3555b.C3559d dVar = this.f15669l;
            dVar.mo19649a(str2, new C5993d("Trouble creating a URL. " + str, i));
        }
    }

    /* renamed from: a */
    public void mo33816a() {
        this.f15669l = null;
    }

    public C6040t(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }
}
