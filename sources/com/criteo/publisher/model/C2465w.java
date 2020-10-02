package com.criteo.publisher.model;

import com.criteo.publisher.C2379c;
import com.criteo.publisher.model.p055z.C2488n;
import com.criteo.publisher.p054a0.C2346u;
import com.vungle.warren.model.ReportDBAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.criteo.publisher.model.w */
public class C2465w {

    /* renamed from: l */
    private static final String f7925l = "w";

    /* renamed from: a */
    private final String f7926a;

    /* renamed from: b */
    private String f7927b;

    /* renamed from: c */
    private String f7928c;

    /* renamed from: d */
    private int f7929d;

    /* renamed from: e */
    private int f7930e;

    /* renamed from: f */
    private String f7931f;

    /* renamed from: g */
    private String f7932g;

    /* renamed from: h */
    private int f7933h;

    /* renamed from: i */
    private long f7934i;

    /* renamed from: j */
    private double f7935j;

    /* renamed from: k */
    private C2488n f7936k;

    public C2465w(JSONObject jSONObject) {
        this.f7926a = jSONObject.optString("impId", (String) null);
        this.f7931f = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID, (String) null);
        if (jSONObject.has("cpm")) {
            try {
                this.f7927b = jSONObject.getString("cpm");
            } catch (JSONException e) {
                "Unable to parse CPM " + e.getMessage();
                this.f7927b = String.valueOf(jSONObject.optDouble("cpm", 0.0d));
            }
        } else {
            this.f7927b = "0.0";
        }
        this.f7928c = jSONObject.optString("currency", (String) null);
        this.f7929d = jSONObject.optInt("width", 0);
        this.f7930e = jSONObject.optInt("height", 0);
        this.f7932g = jSONObject.optString("displayUrl", (String) null);
        this.f7933h = jSONObject.optInt("ttl", 0);
        if (mo10405b() == null) {
            this.f7935j = 0.0d;
        }
        this.f7936k = null;
        if (jSONObject.has("native")) {
            try {
                this.f7936k = C2488n.m9386a(jSONObject.getJSONObject("native"));
            } catch (Exception e2) {
                "exception when parsing json" + e2.getLocalizedMessage();
            }
        }
    }

    /* renamed from: a */
    public String mo10401a() {
        return this.f7927b;
    }

    /* renamed from: b */
    public Double mo10405b() {
        try {
            double parseDouble = Double.parseDouble(mo10401a());
            this.f7935j = parseDouble;
            return Double.valueOf(parseDouble);
        } catch (Exception e) {
            "CPM is not a valid double " + e.getMessage();
            return null;
        }
    }

    /* renamed from: c */
    public String mo10406c() {
        return this.f7932g;
    }

    /* renamed from: d */
    public int mo10407d() {
        return this.f7930e;
    }

    /* renamed from: e */
    public String mo10408e() {
        return this.f7926a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2465w)) {
            return false;
        }
        C2465w wVar = (C2465w) obj;
        String str = this.f7931f;
        String str2 = wVar.f7931f;
        if (str != str2 && !str.equals(str2)) {
            return false;
        }
        String str3 = this.f7927b;
        String str4 = wVar.f7927b;
        if (str3 != str4 && !str3.equals(str4)) {
            return false;
        }
        String str5 = this.f7928c;
        String str6 = wVar.f7928c;
        if ((str5 != str6 && !str5.equals(str6)) || this.f7929d != wVar.f7929d || this.f7930e != wVar.f7930e || this.f7933h != wVar.f7933h) {
            return false;
        }
        String str7 = this.f7932g;
        String str8 = wVar.f7932g;
        if (str7 != str8 && !str7.equals(str8)) {
            return false;
        }
        C2488n nVar = this.f7936k;
        C2488n nVar2 = wVar.f7936k;
        if (nVar == nVar2 || nVar.equals(nVar2)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public C2488n mo10410f() {
        return this.f7936k;
    }

    /* renamed from: g */
    public String mo10411g() {
        return this.f7931f;
    }

    /* renamed from: h */
    public int mo10412h() {
        return this.f7933h;
    }

    /* renamed from: i */
    public int mo10413i() {
        return this.f7929d;
    }

    /* renamed from: j */
    public boolean mo10414j() {
        return this.f7936k != null;
    }

    /* renamed from: k */
    public boolean mo10415k() {
        Double b = mo10405b();
        if (b == null || b.doubleValue() < 0.0d) {
            return false;
        }
        if (mo10414j() || C2346u.m9009c(this.f7932g)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Slot{impressionId='" + this.f7926a + '\'' + ", cpm='" + this.f7927b + '\'' + ", currency='" + this.f7928c + '\'' + ", width=" + this.f7929d + ", height=" + this.f7930e + ", placementId='" + this.f7931f + '\'' + ", displayUrl='" + this.f7932g + '\'' + ", ttl=" + this.f7933h + ", timeOfDownload=" + this.f7934i + ", cpmValue=" + this.f7935j + ", nativeAssets=" + this.f7936k + '}';
    }

    /* renamed from: a */
    public void mo10402a(int i) {
        this.f7933h = i;
    }

    /* renamed from: a */
    public void mo10403a(long j) {
        this.f7934i = j;
    }

    /* renamed from: a */
    public boolean mo10404a(C2379c cVar) {
        return ((long) (this.f7933h * 1000)) + this.f7934i <= cVar.mo10237a();
    }
}
