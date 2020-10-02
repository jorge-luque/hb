package com.applovin.impl.sdk.p049ad;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.impl.sdk.p052d.C1903q;
import com.applovin.impl.sdk.p052d.C1907s;
import com.applovin.impl.sdk.utils.C1987d;
import com.applovin.impl.sdk.utils.C1993i;
import com.applovin.impl.sdk.utils.C2026p;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ad.f */
public class C1823f implements Runnable {

    /* renamed from: i */
    private static boolean f5682i;

    /* renamed from: a */
    private final C1941j f5683a;

    /* renamed from: b */
    private final MaxAdFormat f5684b;

    /* renamed from: c */
    private List<C1821d> f5685c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final List<JSONObject> f5686d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f5687e;

    /* renamed from: f */
    private C1821d f5688f;

    /* renamed from: g */
    private C1826b f5689g = C1826b.NONE;

    /* renamed from: h */
    private boolean f5690h;

    /* renamed from: com.applovin.impl.sdk.ad.f$a */
    public static class C1825a implements AppLovinAdLoadListener {

        /* renamed from: a */
        private final C1941j f5692a;

        /* renamed from: b */
        private final C1821d f5693b;

        /* renamed from: c */
        private final AppLovinAdLoadListener f5694c;

        /* renamed from: d */
        private boolean f5695d;

        public C1825a(C1821d dVar, AppLovinAdLoadListener appLovinAdLoadListener, C1941j jVar) {
            this.f5692a = jVar;
            this.f5693b = dVar;
            this.f5694c = appLovinAdLoadListener;
        }

        /* renamed from: a */
        public void mo8198a(boolean z) {
            this.f5695d = z;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            this.f5692a.mo8544W().mo8188a((AppLovinAdBase) (C1827g) appLovinAd, false, this.f5695d);
            this.f5694c.adReceived(appLovinAd);
        }

        public void failedToReceiveAd(int i) {
            this.f5692a.mo8544W().mo8189a(this.f5693b, this.f5695d, i);
            this.f5694c.failedToReceiveAd(i);
        }
    }

    /* renamed from: com.applovin.impl.sdk.ad.f$b */
    public enum C1826b {
        NONE(0, "none"),
        TIMER(1, "timer"),
        APP_PAUSED(2, "backgrounded"),
        IMPRESSION(3, "impression"),
        WATERFALL_RESTARTED(3, "waterfall_restarted"),
        UNKNOWN_ZONE(4, "unknown_zone"),
        SKIPPED_ZONE(5, "skipped_zone"),
        REPEATED_ZONE(6, "repeated_zone");
        

        /* renamed from: i */
        private final int f5705i;

        /* renamed from: j */
        private final String f5706j;

        private C1826b(int i, String str) {
            this.f5705i = i;
            this.f5706j = str;
        }

        /* renamed from: a */
        public int mo8199a() {
            return this.f5705i;
        }

        /* renamed from: b */
        public String mo8200b() {
            return this.f5706j;
        }
    }

    public C1823f(MaxAdFormat maxAdFormat, C1941j jVar) {
        this.f5683a = jVar;
        this.f5684b = maxAdFormat;
        this.f5686d = new ArrayList();
        this.f5687e = new Object();
    }

    /* renamed from: a */
    private static JSONObject m6892a(C1821d dVar, C1941j jVar) {
        JSONObject jSONObject = new JSONObject();
        C1993i.m7886a(jSONObject, "id", dVar.mo8174a(), jVar);
        C1993i.m7902b(jSONObject, "response_ts_s", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), jVar);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m6893a(C1821d dVar, int i, C1941j jVar) {
        if (!((Boolean) jVar.mo8549a(C1841c.f6075fn)).booleanValue()) {
            if (!f5682i) {
                C1977q.m7751i("AppLovinSdk", "Unknown zone in waterfall: " + dVar.mo8174a());
                f5682i = true;
            } else {
                return;
            }
        }
        JSONObject a = m6892a(dVar, jVar);
        C1993i.m7884a(a, NativeProtocol.BRIDGE_ARG_ERROR_CODE, i, jVar);
        m6897a(C1826b.UNKNOWN_ZONE, C1826b.NONE, C1993i.m7899b((Object) a), (MaxAdFormat) null, jVar);
    }

    /* renamed from: a */
    private void m6894a(C1821d dVar, JSONObject jSONObject) {
        C1826b bVar;
        C1993i.m7890a(jSONObject, m6892a(dVar, this.f5683a), this.f5683a);
        synchronized (this.f5687e) {
            if (m6900a(dVar)) {
                m6895a(C1826b.WATERFALL_RESTARTED);
            } else {
                if (m6903b(dVar)) {
                    m6899a(jSONObject, dVar);
                    bVar = C1826b.REPEATED_ZONE;
                } else if (m6905c(dVar)) {
                    m6899a(jSONObject, dVar);
                    bVar = C1826b.SKIPPED_ZONE;
                }
                m6896a(bVar, dVar);
            }
            m6899a(jSONObject, dVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6895a(C1826b bVar) {
        m6896a(bVar, (C1821d) null);
    }

    /* renamed from: a */
    private void m6896a(C1826b bVar, C1821d dVar) {
        if (!((Boolean) this.f5683a.mo8549a(C1841c.f6075fn)).booleanValue()) {
            if (!this.f5690h) {
                if (bVar == C1826b.SKIPPED_ZONE || bVar == C1826b.REPEATED_ZONE) {
                    C1977q.m7751i("AppLovinSdk", "Invalid zone in waterfall: " + dVar);
                    this.f5690h = true;
                }
            } else {
                return;
            }
        }
        synchronized (this.f5687e) {
            if (!this.f5686d.isEmpty()) {
                JSONArray jSONArray = new JSONArray(this.f5686d);
                this.f5686d.clear();
                C1826b bVar2 = this.f5689g;
                this.f5689g = bVar;
                m6897a(bVar, bVar2, jSONArray, this.f5684b, this.f5683a);
            }
        }
    }

    /* renamed from: a */
    private static void m6897a(C1826b bVar, C1826b bVar2, JSONArray jSONArray, MaxAdFormat maxAdFormat, C1941j jVar) {
        jVar.mo8533L().mo8475a((C1864a) new C1903q(bVar, bVar2, jSONArray, maxAdFormat, jVar), C1907s.C1909a.BACKGROUND);
    }

    /* renamed from: a */
    private void m6899a(JSONObject jSONObject, C1821d dVar) {
        synchronized (this.f5687e) {
            this.f5686d.add(jSONObject);
            this.f5688f = dVar;
        }
    }

    /* renamed from: a */
    private boolean m6900a(C1821d dVar) {
        if (this.f5688f != null) {
            int indexOf = this.f5685c.indexOf(dVar);
            return indexOf == 0 || indexOf < this.f5685c.indexOf(this.f5688f);
        }
    }

    /* renamed from: b */
    private void m6902b() {
        long c = m6904c();
        if (c <= 0) {
            return;
        }
        if (((Boolean) this.f5683a.mo8549a(C1841c.f6072fk)).booleanValue()) {
            C1987d.m7825a(c, this.f5683a, this);
        } else {
            C2026p.m7968a(c, this.f5683a, this);
        }
    }

    /* renamed from: b */
    private boolean m6903b(C1821d dVar) {
        return this.f5688f == dVar;
    }

    /* renamed from: c */
    private long m6904c() {
        return TimeUnit.SECONDS.toMillis(((Long) this.f5683a.mo8549a(C1841c.f6071fj)).longValue());
    }

    /* renamed from: c */
    private boolean m6905c(C1821d dVar) {
        int indexOf = this.f5685c.indexOf(dVar);
        C1821d dVar2 = this.f5688f;
        return indexOf != (dVar2 != null ? this.f5685c.indexOf(dVar2) + 1 : 0);
    }

    /* renamed from: a */
    public void mo8193a() {
        if (((Boolean) this.f5683a.mo8549a(C1841c.f6073fl)).booleanValue()) {
            m6895a(C1826b.IMPRESSION);
        }
    }

    /* renamed from: a */
    public void mo8194a(AppLovinAdBase appLovinAdBase, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        C1993i.m7902b(jSONObject, "ad_id", appLovinAdBase.getAdIdNumber(), this.f5683a);
        C1993i.m7902b(jSONObject, "ad_created_ts_s", TimeUnit.MILLISECONDS.toSeconds(appLovinAdBase.getCreatedAtMillis()), this.f5683a);
        C1993i.m7889a(jSONObject, "is_preloaded", z, this.f5683a);
        C1993i.m7889a(jSONObject, "for_bidding", z2, this.f5683a);
        m6894a(appLovinAdBase.getAdZone(), jSONObject);
    }

    /* renamed from: a */
    public void mo8195a(C1821d dVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        C1993i.m7884a(jSONObject, NativeProtocol.BRIDGE_ARG_ERROR_CODE, i, this.f5683a);
        C1993i.m7889a(jSONObject, "for_bidding", z, this.f5683a);
        m6894a(dVar, jSONObject);
    }

    /* renamed from: a */
    public void mo8196a(List<C1821d> list) {
        if (this.f5685c == null) {
            this.f5685c = list;
            m6902b();
            if (((Boolean) this.f5683a.mo8549a(C1841c.f6074fm)).booleanValue()) {
                this.f5683a.mo8570af().registerReceiver(new AppLovinBroadcastManager.Receiver() {
                    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
                        C1823f.this.m6895a(C1826b.APP_PAUSED);
                        synchronized (C1823f.this.f5687e) {
                            C1823f.this.f5686d.clear();
                        }
                    }
                }, new IntentFilter("com.applovin.application_paused"));
            }
        }
    }

    public void run() {
        m6895a(C1826b.TIMER);
        m6902b();
    }
}
