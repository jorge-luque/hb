package com.applovin.impl.adview.p034a.p036b;

import android.graphics.PointF;
import android.net.Uri;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1565i;
import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.p033a.C1483d;
import com.applovin.impl.p033a.C1487g;
import com.applovin.impl.p033a.C1488h;
import com.applovin.impl.p033a.C1489i;
import com.applovin.impl.p033a.C1490j;
import com.applovin.impl.p033a.C1493k;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.impl.sdk.p050b.C1841c;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.vungle.warren.analytics.AnalyticsEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.a.b.c */
public class C1535c extends C1537d {

    /* renamed from: v */
    private final C1476a f4827v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final Set<C1487g> f4828w = new HashSet();

    public C1535c(C1827g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1941j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(gVar, appLovinFullscreenActivity, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        C1476a aVar = (C1476a) gVar;
        this.f4827v = aVar;
        this.f4828w.addAll(aVar.mo7143a(C1476a.C1480c.VIDEO, C1488h.f4657a));
        m5925a(C1476a.C1480c.IMPRESSION);
        m5927a(C1476a.C1480c.VIDEO, "creativeView");
    }

    /* renamed from: a */
    private void m5925a(C1476a.C1480c cVar) {
        m5926a(cVar, C1483d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m5926a(C1476a.C1480c cVar, C1483d dVar) {
        m5928a(cVar, "", dVar);
    }

    /* renamed from: a */
    private void m5927a(C1476a.C1480c cVar, String str) {
        m5928a(cVar, str, C1483d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m5928a(C1476a.C1480c cVar, String str, C1483d dVar) {
        m5931a(this.f4827v.mo7142a(cVar, str), dVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5930a(Set<C1487g> set) {
        m5931a(set, C1483d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m5931a(Set<C1487g> set, C1483d dVar) {
        if (set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.f4840q.getCurrentPosition());
            C1493k l = this.f4827v.mo7166l();
            Uri a = l != null ? l.mo7228a() : null;
            C1977q qVar = this.f4784c;
            qVar.mo8742b("InterActivityV2", "Firing " + set.size() + " tracker(s): " + set);
            C1489i.m5787a(set, seconds, a, dVar, this.f4783b);
        }
    }

    /* renamed from: z */
    private void m5932z() {
        if (mo7353x() && !this.f4828w.isEmpty()) {
            C1977q qVar = this.f4784c;
            qVar.mo8745d("InterActivityV2", "Firing " + this.f4828w.size() + " un-fired video progress trackers when video was completed.");
            m5930a(this.f4828w);
        }
    }

    /* renamed from: a */
    public void mo7344a(PointF pointF) {
        m5925a(C1476a.C1480c.VIDEO_CLICK);
        super.mo7344a(pointF);
    }

    /* renamed from: c */
    public void mo7313c() {
        super.mo7313c();
        this.f4841r.mo7442a("PROGRESS_TRACKING", ((Long) this.f4783b.mo8549a(C1841c.f6013eD)).longValue(), (C1565i.C1567a) new C1565i.C1567a() {
            /* renamed from: a */
            public void mo7350a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(C1535c.this.f4843t - ((long) (C1535c.this.f4840q.getDuration() - C1535c.this.f4840q.getCurrentPosition())));
                HashSet hashSet = new HashSet();
                for (C1487g gVar : new HashSet(C1535c.this.f4828w)) {
                    if (gVar.mo7212a(seconds, C1535c.this.mo7354y())) {
                        hashSet.add(gVar);
                        C1535c.this.f4828w.remove(gVar);
                    }
                }
                C1535c.this.m5930a((Set<C1487g>) hashSet);
            }

            /* renamed from: b */
            public boolean mo7351b() {
                return !C1535c.this.f4844u;
            }
        });
    }

    /* renamed from: c */
    public void mo7345c(String str) {
        m5926a(C1476a.C1480c.ERROR, C1483d.MEDIA_FILE_ERROR);
        super.mo7345c(str);
    }

    /* renamed from: d */
    public void mo7315d() {
        super.mo7315d();
        m5927a(this.f4844u ? C1476a.C1480c.COMPANION : C1476a.C1480c.VIDEO, "resume");
    }

    /* renamed from: e */
    public void mo7316e() {
        super.mo7316e();
        m5927a(this.f4844u ? C1476a.C1480c.COMPANION : C1476a.C1480c.VIDEO, "pause");
    }

    /* renamed from: f */
    public void mo7317f() {
        m5927a(C1476a.C1480c.VIDEO, "close");
        m5927a(C1476a.C1480c.COMPANION, "close");
        super.mo7317f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo7328q() {
        long j;
        int r;
        long j2 = 0;
        if (this.f4827v.mo8259am() >= 0 || this.f4827v.mo8260an() >= 0) {
            int i = (this.f4827v.mo8259am() > 0 ? 1 : (this.f4827v.mo8259am() == 0 ? 0 : -1));
            C1476a aVar = this.f4827v;
            if (i >= 0) {
                j = aVar.mo8259am();
            } else {
                C1490j k = aVar.mo7165k();
                if (k == null || k.mo7219b() <= 0) {
                    long j3 = this.f4843t;
                    if (j3 > 0) {
                        j2 = 0 + j3;
                    }
                } else {
                    j2 = 0 + TimeUnit.SECONDS.toMillis((long) k.mo7219b());
                }
                if (aVar.mo8261ao() && (r = (int) aVar.mo8281r()) > 0) {
                    j2 += TimeUnit.SECONDS.toMillis((long) r);
                }
                double d = (double) j2;
                double an = (double) this.f4827v.mo8260an();
                Double.isNaN(an);
                Double.isNaN(d);
                j = (long) (d * (an / 100.0d));
            }
            mo7303a(j);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void mo7346s() {
        this.f4841r.mo7444c();
        super.mo7346s();
    }

    /* renamed from: t */
    public void mo7347t() {
        m5927a(C1476a.C1480c.VIDEO, "skip");
        super.mo7347t();
    }

    /* renamed from: u */
    public void mo7348u() {
        super.mo7348u();
        m5927a(C1476a.C1480c.VIDEO, this.f4842s ? AnalyticsEvent.C5464Ad.mute : AnalyticsEvent.C5464Ad.unmute);
    }

    /* renamed from: v */
    public void mo7349v() {
        m5932z();
        if (!C1489i.m5794c(this.f4827v)) {
            this.f4784c.mo8742b("InterActivityV2", "VAST ad does not have valid companion ad - dismissing...");
            mo7317f();
        } else if (!this.f4844u) {
            m5927a(C1476a.C1480c.COMPANION, "creativeView");
            super.mo7349v();
        }
    }
}
