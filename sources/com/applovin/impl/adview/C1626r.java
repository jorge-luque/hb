package com.applovin.impl.adview;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.impl.adview.C1565i;
import com.applovin.impl.p033a.C1476a;
import com.applovin.impl.p033a.C1483d;
import com.applovin.impl.p033a.C1487g;
import com.applovin.impl.p033a.C1488h;
import com.applovin.impl.p033a.C1489i;
import com.applovin.impl.p033a.C1493k;
import com.applovin.impl.sdk.C1977q;
import com.applovin.impl.sdk.p050b.C1841c;
import com.vungle.warren.analytics.AnalyticsEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.r */
public class C1626r extends C1580n {

    /* renamed from: a */
    private final Set<C1487g> f5064a = new HashSet();

    /* renamed from: a */
    private void m6188a() {
        if (isFullyWatched() && !this.f5064a.isEmpty()) {
            C1977q qVar = this.logger;
            qVar.mo8745d("InterstitialActivity", "Firing " + this.f5064a.size() + " un-fired video progress trackers when video was completed.");
            m6193a(this.f5064a);
        }
    }

    /* renamed from: a */
    private void m6189a(C1476a.C1480c cVar) {
        m6190a(cVar, C1483d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m6190a(C1476a.C1480c cVar, C1483d dVar) {
        m6192a(cVar, "", dVar);
    }

    /* renamed from: a */
    private void m6191a(C1476a.C1480c cVar, String str) {
        m6192a(cVar, str, C1483d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m6192a(C1476a.C1480c cVar, String str, C1483d dVar) {
        if (isVastAd()) {
            m6194a(((C1476a) this.currentAd).mo7142a(cVar, str), dVar);
        }
    }

    /* renamed from: a */
    private void m6193a(Set<C1487g> set) {
        m6194a(set, C1483d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m6194a(Set<C1487g> set, C1483d dVar) {
        if (isVastAd() && set != null && !set.isEmpty()) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds((long) this.videoView.getCurrentPosition());
            C1493k l = m6195b().mo7166l();
            Uri a = l != null ? l.mo7228a() : null;
            C1977q qVar = this.logger;
            qVar.mo8742b("InterstitialActivity", "Firing " + set.size() + " tracker(s): " + set);
            C1489i.m5787a(set, seconds, a, dVar, this.sdk);
        }
    }

    /* renamed from: b */
    private C1476a m6195b() {
        if (this.currentAd instanceof C1476a) {
            return (C1476a) this.currentAd;
        }
        return null;
    }

    public void clickThroughFromVideo(PointF pointF) {
        super.clickThroughFromVideo(pointF);
        m6189a(C1476a.C1480c.VIDEO_CLICK);
    }

    public void dismiss() {
        if (isVastAd()) {
            m6191a(C1476a.C1480c.VIDEO, "close");
            m6191a(C1476a.C1480c.COMPANION, "close");
        }
        super.dismiss();
    }

    public void handleCountdownStep() {
        if (isVastAd()) {
            long seconds = ((long) this.computedLengthSeconds) - TimeUnit.MILLISECONDS.toSeconds((long) (this.videoView.getDuration() - this.videoView.getCurrentPosition()));
            HashSet hashSet = new HashSet();
            for (C1487g gVar : new HashSet(this.f5064a)) {
                if (gVar.mo7212a(seconds, getVideoPercentViewed())) {
                    hashSet.add(gVar);
                    this.f5064a.remove(gVar);
                }
            }
            m6193a((Set<C1487g>) hashSet);
        }
    }

    public void handleMediaError(String str) {
        m6190a(C1476a.C1480c.ERROR, C1483d.MEDIA_FILE_ERROR);
        super.handleMediaError(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isVastAd()) {
            this.f5064a.addAll(m6195b().mo7143a(C1476a.C1480c.VIDEO, C1488h.f4657a));
            m6189a(C1476a.C1480c.IMPRESSION);
            m6191a(C1476a.C1480c.VIDEO, "creativeView");
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        m6191a(this.postitialWasDisplayed ? C1476a.C1480c.COMPANION : C1476a.C1480c.VIDEO, "pause");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m6191a(this.postitialWasDisplayed ? C1476a.C1480c.COMPANION : C1476a.C1480c.VIDEO, "resume");
    }

    public void playVideo() {
        this.countdownManager.mo7442a("PROGRESS_TRACKING", ((Long) this.sdk.mo8549a(C1841c.f6013eD)).longValue(), (C1565i.C1567a) new C1565i.C1567a() {
            /* renamed from: a */
            public void mo7350a() {
                C1626r.this.handleCountdownStep();
            }

            /* renamed from: b */
            public boolean mo7351b() {
                return C1626r.this.shouldContinueFullLengthVideoCountdown();
            }
        });
        super.playVideo();
    }

    public void showPostitial() {
        if (isVastAd()) {
            m6188a();
            if (!C1489i.m5794c(m6195b())) {
                dismiss();
                return;
            } else if (!this.postitialWasDisplayed) {
                m6191a(C1476a.C1480c.COMPANION, "creativeView");
            } else {
                return;
            }
        }
        super.showPostitial();
    }

    public void skipVideo() {
        m6191a(C1476a.C1480c.VIDEO, "skip");
        super.skipVideo();
    }

    public void toggleMute() {
        super.toggleMute();
        m6191a(C1476a.C1480c.VIDEO, this.videoMuted ? AnalyticsEvent.C5464Ad.mute : AnalyticsEvent.C5464Ad.unmute);
    }
}
