package p118io.fabric.sdk.android.p200m.p205e;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.C6072k;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p202b.C6096k;
import p118io.fabric.sdk.android.p200m.p202b.C6097l;
import p118io.fabric.sdk.android.p200m.p204d.C6132c;
import p118io.fabric.sdk.android.p200m.p204d.C6133d;

/* renamed from: io.fabric.sdk.android.m.e.j */
/* compiled from: DefaultSettingsController */
class C6143j implements C6154s {

    /* renamed from: a */
    private final C6158w f16141a;

    /* renamed from: b */
    private final C6157v f16142b;

    /* renamed from: c */
    private final C6096k f16143c;

    /* renamed from: d */
    private final C6140g f16144d;

    /* renamed from: e */
    private final C6159x f16145e;

    /* renamed from: f */
    private final C6069h f16146f;

    /* renamed from: g */
    private final C6132c f16147g;

    /* renamed from: h */
    private final C6097l f16148h;

    public C6143j(C6069h hVar, C6158w wVar, C6096k kVar, C6157v vVar, C6140g gVar, C6159x xVar, C6097l lVar) {
        this.f16146f = hVar;
        this.f16141a = wVar;
        this.f16143c = kVar;
        this.f16142b = vVar;
        this.f16144d = gVar;
        this.f16145e = xVar;
        this.f16148h = lVar;
        this.f16147g = new C6133d(hVar);
    }

    /* renamed from: b */
    private C6155t m19878b(C6153r rVar) {
        C6155t tVar = null;
        try {
            if (C6153r.SKIP_CACHE_LOOKUP.equals(rVar)) {
                return null;
            }
            JSONObject a = this.f16144d.mo34247a();
            if (a != null) {
                C6155t a2 = this.f16142b.mo34255a(this.f16143c, a);
                if (a2 != null) {
                    m19877a(a, "Loaded cached settings: ");
                    long a3 = this.f16143c.mo34175a();
                    if (!C6153r.IGNORE_CACHE_EXPIRATION.equals(rVar)) {
                        if (a2.mo34263a(a3)) {
                            C6059c.m19630f().mo34093d("Fabric", "Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        C6059c.m19630f().mo34093d("Fabric", "Returning cached settings.");
                        return a2;
                    } catch (Exception e) {
                        e = e;
                        tVar = a2;
                        C6059c.m19630f().mo34090b("Fabric", "Failed to get cached settings", e);
                        return tVar;
                    }
                } else {
                    C6059c.m19630f().mo34090b("Fabric", "Failed to transform cached settings data.", (Throwable) null);
                    return null;
                }
            } else {
                C6059c.m19630f().mo34093d("Fabric", "No cached settings data found.");
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            C6059c.m19630f().mo34090b("Fabric", "Failed to get cached settings", e);
            return tVar;
        }
    }

    /* renamed from: a */
    public C6155t mo34249a() {
        return mo34250a(C6153r.USE_CACHE);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo34253c() {
        return C6090i.m19729a(C6090i.m19759n(this.f16146f.getContext()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo34254d() {
        return this.f16147g.get().getString("existing_instance_identifier", "");
    }

    /* renamed from: a */
    public C6155t mo34250a(C6153r rVar) {
        JSONObject a;
        C6155t tVar = null;
        if (!this.f16148h.mo34177a()) {
            C6059c.m19630f().mo34093d("Fabric", "Not fetching settings, because data collection is disabled by Firebase.");
            return null;
        }
        try {
            if (!C6059c.m19632h() && !mo34252b()) {
                tVar = m19878b(rVar);
            }
            if (tVar == null && (a = this.f16145e.mo34256a(this.f16141a)) != null) {
                tVar = this.f16142b.mo34255a(this.f16143c, a);
                this.f16144d.mo34248a(tVar.f16179f, a);
                m19877a(a, "Loaded settings: ");
                mo34251a(mo34253c());
            }
            if (tVar == null) {
                return m19878b(C6153r.IGNORE_CACHE_EXPIRATION);
            }
            return tVar;
        } catch (Exception e) {
            C6059c.m19630f().mo34090b("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", e);
            return null;
        }
    }

    /* renamed from: a */
    private void m19877a(JSONObject jSONObject, String str) throws JSONException {
        C6072k f = C6059c.m19630f();
        f.mo34093d("Fabric", str + jSONObject.toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo34252b() {
        return !mo34254d().equals(mo34253c());
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public boolean mo34251a(String str) {
        SharedPreferences.Editor a = this.f16147g.mo34241a();
        a.putString("existing_instance_identifier", str);
        return this.f16147g.mo34242a(a);
    }
}
