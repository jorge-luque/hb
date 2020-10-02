package p118io.fabric.sdk.android.p200m.p205e;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import p118io.fabric.sdk.android.C6059c;
import p118io.fabric.sdk.android.C6069h;
import p118io.fabric.sdk.android.p200m.p202b.C6088g;
import p118io.fabric.sdk.android.p200m.p202b.C6090i;
import p118io.fabric.sdk.android.p200m.p202b.C6097l;
import p118io.fabric.sdk.android.p200m.p202b.C6098m;
import p118io.fabric.sdk.android.p200m.p202b.C6107s;
import p118io.fabric.sdk.android.p200m.p202b.C6117w;
import p118io.fabric.sdk.android.services.network.C6200d;

/* renamed from: io.fabric.sdk.android.m.e.q */
/* compiled from: Settings */
public class C6150q {

    /* renamed from: a */
    private final AtomicReference<C6155t> f16166a;

    /* renamed from: b */
    private final CountDownLatch f16167b;

    /* renamed from: c */
    private C6154s f16168c;

    /* renamed from: d */
    private boolean f16169d;

    /* renamed from: io.fabric.sdk.android.m.e.q$b */
    /* compiled from: Settings */
    static class C6152b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C6150q f16170a = new C6150q();
    }

    /* renamed from: d */
    public static C6150q m19903d() {
        return C6152b.f16170a;
    }

    /* renamed from: a */
    public synchronized C6150q mo34259a(C6069h hVar, C6107s sVar, C6200d dVar, String str, String str2, String str3, C6097l lVar) {
        C6069h hVar2 = hVar;
        synchronized (this) {
            if (this.f16169d) {
                return this;
            }
            if (this.f16168c == null) {
                Context context = hVar.getContext();
                String c = sVar.mo34191c();
                String d = new C6088g().mo34168d(context);
                String f = sVar.mo34194f();
                C6117w wVar = new C6117w();
                C6144k kVar = new C6144k();
                C6142i iVar = new C6142i(hVar2);
                String c2 = C6090i.m19744c(context);
                String str4 = str3;
                C6145l lVar2 = new C6145l(hVar2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c}), dVar);
                String g = sVar.mo34195g();
                String str5 = g;
                String str6 = str2;
                String str7 = str;
                C6069h hVar3 = hVar;
                this.f16168c = new C6143j(hVar3, new C6158w(d, str5, sVar.mo34196h(), sVar.mo34197i(), sVar.mo34192d(), C6090i.m19729a(C6090i.m19759n(context)), str6, str7, C6098m.m19770a(f).mo34179a(), c2), wVar, kVar, iVar, lVar2, lVar);
            }
            this.f16169d = true;
            return this;
        }
    }

    /* renamed from: b */
    public synchronized boolean mo34261b() {
        C6155t a;
        a = this.f16168c.mo34249a();
        m19902a(a);
        return a != null;
    }

    /* renamed from: c */
    public synchronized boolean mo34262c() {
        C6155t a;
        a = this.f16168c.mo34250a(C6153r.SKIP_CACHE_LOOKUP);
        m19902a(a);
        if (a == null) {
            C6059c.m19630f().mo34090b("Fabric", "Failed to force reload of settings from Crashlytics.", (Throwable) null);
        }
        return a != null;
    }

    private C6150q() {
        this.f16166a = new AtomicReference<>();
        this.f16167b = new CountDownLatch(1);
        this.f16169d = false;
    }

    /* renamed from: a */
    public C6155t mo34260a() {
        try {
            this.f16167b.await();
            return this.f16166a.get();
        } catch (InterruptedException unused) {
            C6059c.m19630f().mo34089b("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    /* renamed from: a */
    private void m19902a(C6155t tVar) {
        this.f16166a.set(tVar);
        this.f16167b.countDown();
    }
}
