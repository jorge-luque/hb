package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.mediation.C1733f;
import com.applovin.impl.mediation.p045b.C1697a;
import com.applovin.impl.mediation.p046c.C1710b;
import com.applovin.impl.mediation.p046c.C1715c;
import com.applovin.impl.mediation.p047d.C1729c;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1840b;
import com.applovin.impl.sdk.p052d.C1864a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* renamed from: com.applovin.impl.mediation.g */
public class C1736g {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1941j f5376a;

    /* renamed from: b */
    private final Map<String, C1740b> f5377b = new HashMap(4);

    /* renamed from: c */
    private final Object f5378c = new Object();

    /* renamed from: d */
    private final Map<String, C1697a> f5379d = new HashMap(4);

    /* renamed from: e */
    private final Object f5380e = new Object();

    /* renamed from: com.applovin.impl.mediation.g$a */
    private static class C1738a implements MaxAdListener {

        /* renamed from: a */
        private final C1941j f5387a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final Activity f5388b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final C1736g f5389c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final C1740b f5390d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final MaxAdFormat f5391e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public C1733f f5392f;

        private C1738a(C1733f fVar, C1740b bVar, MaxAdFormat maxAdFormat, C1736g gVar, C1941j jVar, Activity activity) {
            this.f5387a = jVar;
            this.f5388b = activity;
            this.f5389c = gVar;
            this.f5390d = bVar;
            this.f5391e = maxAdFormat;
            this.f5392f = fVar;
        }

        public void onAdClicked(MaxAd maxAd) {
        }

        public void onAdDisplayFailed(MaxAd maxAd, int i) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdHidden(MaxAd maxAd) {
        }

        public void onAdLoadFailed(final String str, int i) {
            if (this.f5390d.f5397b >= ((Integer) this.f5387a.mo8549a(C1840b.f5761N)).intValue()) {
                int unused = this.f5390d.f5397b = 0;
                this.f5390d.f5396a.set(false);
                if (this.f5390d.f5398c != null) {
                    this.f5390d.f5398c.onAdLoadFailed(str, i);
                    MaxAdListener unused2 = this.f5390d.f5398c = null;
                    return;
                }
                return;
            }
            C1740b.m6653d(this.f5390d);
            final int pow = (int) Math.pow(2.0d, (double) this.f5390d.f5397b);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    C1738a aVar = C1738a.this;
                    C1733f unused = aVar.f5392f = new C1733f.C1735a(aVar.f5392f).mo7882a("retry_delay_sec", String.valueOf(pow)).mo7882a("retry_attempt", String.valueOf(C1738a.this.f5390d.f5397b)).mo7883a();
                    C1738a.this.f5389c.m6639b(str, C1738a.this.f5391e, C1738a.this.f5392f, C1738a.this.f5388b, C1738a.this);
                }
            }, TimeUnit.SECONDS.toMillis((long) pow));
        }

        public void onAdLoaded(MaxAd maxAd) {
            C1697a aVar = (C1697a) maxAd;
            int unused = this.f5390d.f5397b = 0;
            if (this.f5390d.f5398c != null) {
                aVar.mo7767c().mo7903c().mo7610a(this.f5390d.f5398c);
                this.f5390d.f5398c.onAdLoaded(aVar);
                MaxAdListener unused2 = this.f5390d.f5398c = null;
                if (this.f5387a.mo8580c(C1840b.f5760M).contains(maxAd.getFormat())) {
                    this.f5389c.m6639b(maxAd.getAdUnitId(), maxAd.getFormat(), this.f5392f, this.f5388b, this);
                    return;
                }
            } else {
                this.f5389c.m6635a(aVar);
            }
            this.f5390d.f5396a.set(false);
        }
    }

    /* renamed from: com.applovin.impl.mediation.g$b */
    private static class C1740b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final AtomicBoolean f5396a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f5397b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public volatile MaxAdListener f5398c;

        private C1740b() {
            this.f5396a = new AtomicBoolean();
        }

        /* renamed from: d */
        static /* synthetic */ int m6653d(C1740b bVar) {
            int i = bVar.f5397b;
            bVar.f5397b = i + 1;
            return i;
        }
    }

    public C1736g(C1941j jVar) {
        this.f5376a = jVar;
    }

    /* renamed from: a */
    private C1697a m6633a(String str) {
        C1697a aVar;
        synchronized (this.f5380e) {
            aVar = this.f5379d.get(str);
            this.f5379d.remove(str);
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6635a(C1697a aVar) {
        synchronized (this.f5380e) {
            if (this.f5379d.containsKey(aVar.getAdUnitId())) {
                C1977q.m7751i("AppLovinSdk", "Ad in cache already: " + aVar.getAdUnitId());
            }
            this.f5379d.put(aVar.getAdUnitId(), aVar);
        }
    }

    /* renamed from: b */
    private C1740b m6638b(String str) {
        C1740b bVar;
        synchronized (this.f5378c) {
            bVar = this.f5377b.get(str);
            if (bVar == null) {
                bVar = new C1740b();
                this.f5377b.put(str, bVar);
            }
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6639b(String str, MaxAdFormat maxAdFormat, C1733f fVar, Activity activity, MaxAdListener maxAdListener) {
        final String str2 = str;
        final MaxAdFormat maxAdFormat2 = maxAdFormat;
        final C1733f fVar2 = fVar;
        final Activity activity2 = activity;
        final MaxAdListener maxAdListener2 = maxAdListener;
        this.f5376a.mo8533L().mo8475a((C1864a) new C1710b(maxAdFormat, activity, this.f5376a, new C1710b.C1714a() {
            /* renamed from: a */
            public void mo7858a(JSONArray jSONArray) {
                C1736g.this.f5376a.mo8533L().mo8474a((C1864a) new C1715c(str2, maxAdFormat2, fVar2, jSONArray, activity2, C1736g.this.f5376a, maxAdListener2));
            }
        }), C1729c.m6621a(maxAdFormat));
    }

    /* renamed from: a */
    public void mo7884a(String str, MaxAdFormat maxAdFormat, C1733f fVar, Activity activity, MaxAdListener maxAdListener) {
        MaxAdListener maxAdListener2 = maxAdListener;
        C1697a a = m6633a(str);
        if (a != null) {
            a.mo7767c().mo7903c().mo7610a(maxAdListener2);
            maxAdListener2.onAdLoaded(a);
        }
        C1740b b = m6638b(str);
        if (b.f5396a.compareAndSet(false, true)) {
            if (a == null) {
                MaxAdListener unused = b.f5398c = maxAdListener2;
            }
            m6639b(str, maxAdFormat, fVar, activity, new C1738a(fVar, b, maxAdFormat, this, this.f5376a, activity));
            return;
        }
        if (!(b.f5398c == null || b.f5398c == maxAdListener2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempting to load ad for same ad unit id (");
            String str2 = str;
            sb.append(str);
            sb.append(") while another ad load is already in progress!");
            C1977q.m7750h("MaxInterstitialAd", sb.toString());
        }
        MaxAdListener unused2 = b.f5398c = maxAdListener2;
    }
}
