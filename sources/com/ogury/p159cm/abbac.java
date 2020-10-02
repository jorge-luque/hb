package com.ogury.p159cm;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;

/* renamed from: com.ogury.cm.abbac */
public final class abbac {

    /* renamed from: a */
    private String f12075a = "";

    /* renamed from: b */
    private String f12076b = "";

    /* renamed from: c */
    private String f12077c = "";

    /* renamed from: d */
    private aacbc f12078d;

    /* renamed from: e */
    private ArrayList<acbaa<String, String>> f12079e;

    /* renamed from: f */
    private final String f12080f = "v1/";

    /* renamed from: g */
    private final String f12081g = "v2/";

    /* renamed from: a */
    public final abbac mo29468a(aacbc aacbc) {
        this.f12078d = aacbc;
        return this;
    }

    /* renamed from: a */
    public final abbac mo29469a(String str) {
        accbb.m15218b(str, "requestMethod");
        this.f12075a = str;
        return this;
    }

    /* renamed from: a */
    public final abbac mo29470a(String str, String str2) {
        accbb.m15218b(str, "key");
        accbb.m15218b(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (this.f12079e == null) {
            this.f12079e = new ArrayList<>();
        }
        acbaa acbaa = new acbaa(str, str2);
        ArrayList<acbaa<String, String>> arrayList = this.f12079e;
        if (arrayList != null) {
            arrayList.add(acbaa);
        }
        return this;
    }

    /* renamed from: a */
    public final String mo29471a() {
        return this.f12075a;
    }

    /* renamed from: b */
    public final abbac mo29472b(String str) {
        accbb.m15218b(str, "requestBody");
        this.f12076b = str;
        return this;
    }

    /* renamed from: b */
    public final String mo29473b() {
        return this.f12076b;
    }

    /* renamed from: c */
    public final abbac mo29474c(String str) {
        accbb.m15218b(str, "requestType");
        StringBuilder sb = new StringBuilder("https://consent-manager-events.ogury.io/");
        aacca aacca = aacca.f12035a;
        int a = aacca.m15027a();
        sb.append((a == 1 || a != 2) ? this.f12080f : this.f12081g);
        sb.append(str);
        this.f12077c = sb.toString();
        return this;
    }

    /* renamed from: c */
    public final String mo29475c() {
        return this.f12077c;
    }

    /* renamed from: d */
    public final aacbc mo29476d() {
        return this.f12078d;
    }

    /* renamed from: e */
    public final ArrayList<acbaa<String, String>> mo29477e() {
        return this.f12079e;
    }

    /* renamed from: f */
    public final abbaa mo29478f() {
        return new abbaa(this);
    }
}
