package com.tapjoy.internal;

import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.C3137gf;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tapjoy.internal.fq */
public abstract class C5093fq {

    /* renamed from: c */
    private static final String f13944c = "fq";

    /* renamed from: a */
    public final Map f13945a = new HashMap();

    /* renamed from: b */
    public final Map f13946b = new HashMap();

    protected C5093fq(String str, String str2, String str3) {
        this.f13945a.put("placement", str);
        this.f13945a.put("placement_type", str2);
        this.f13945a.put("content_type", str3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C3137gf.C3139a mo31257a(String str, Map map, Map map2) {
        C3137gf.C3139a b = C3137gf.m10291e(str).mo18521a().mo18525a(this.f13945a).mo18525a(map).mo18528b(map2);
        this.f13946b.put(str, b);
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final C3137gf.C3139a mo31260b(String str, Map map, Map map2) {
        C3137gf.C3139a aVar = !C4889al.m16672a(str) ? (C3137gf.C3139a) this.f13946b.remove(str) : null;
        if (aVar == null) {
            String str2 = f13944c;
            TapjoyLog.m16651e(str2, "Error when calling endTrackingEvent -- " + str + " tracking has not been started.");
        } else {
            aVar.mo18525a(this.f13945a).mo18525a(map).mo18528b(map2).mo18526b().mo18529c();
        }
        return aVar;
    }

    /* renamed from: a */
    public final void mo31258a(String str, Object obj) {
        this.f13945a.put(str, obj);
    }

    /* renamed from: a */
    public final C3137gf.C3139a mo31256a() {
        return mo31257a("Content.rendered", (Map) null, (Map) null);
    }

    /* renamed from: b */
    public final C3137gf.C3139a mo31259b() {
        return mo31260b("Content.rendered", (Map) null, (Map) null);
    }
}
