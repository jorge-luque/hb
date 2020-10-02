package com.applovin.impl.adview.p034a.p036b;

import android.os.SystemClock;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.p034a.p035a.C1518b;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1817a;
import com.applovin.impl.sdk.p049ad.C1827g;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.a.b.b */
public class C1533b extends C1520a {

    /* renamed from: q */
    private final C1518b f4825q = new C1518b(this.f4782a, this.f4785d, this.f4783b);

    public C1533b(C1827g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1941j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(gVar, appLovinFullscreenActivity, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
    }

    /* renamed from: a */
    public void mo7341a() {
    }

    /* renamed from: b */
    public void mo7342b() {
    }

    /* renamed from: c */
    public void mo7313c() {
        this.f4825q.mo7298a(this.f4788g, this.f4787f);
        mo7309a(false);
        this.f4787f.renderAd(this.f4782a);
        mo7308a("javascript:al_onPoststitialShow();", (long) this.f4782a.mo8226Z());
        if (this.f4788g != null) {
            if (this.f4782a.mo8281r() >= 0) {
                mo7305a(this.f4788g, this.f4782a.mo8281r(), new Runnable() {
                    public void run() {
                        C1533b.this.f4790i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                this.f4788g.setVisibility(0);
            }
        }
        mo7328q();
        super.mo7312b(mo7329r());
    }

    /* renamed from: f */
    public void mo7317f() {
        mo7323l();
        super.mo7317f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo7323l() {
        super.mo7302a(100, false, true, -2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo7327p() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void mo7328q() {
        long j;
        long millis;
        long j2 = 0;
        if (this.f4782a.mo8259am() >= 0 || this.f4782a.mo8260an() >= 0) {
            int i = (this.f4782a.mo8259am() > 0 ? 1 : (this.f4782a.mo8259am() == 0 ? 0 : -1));
            C1827g gVar = this.f4782a;
            if (i >= 0) {
                j = gVar.mo8259am();
            } else {
                if (gVar.mo8261ao()) {
                    int j3 = (int) ((C1817a) this.f4782a).mo8162j();
                    if (j3 > 0) {
                        millis = TimeUnit.SECONDS.toMillis((long) j3);
                    } else {
                        int r = (int) this.f4782a.mo8281r();
                        if (r > 0) {
                            millis = TimeUnit.SECONDS.toMillis((long) r);
                        }
                    }
                    j2 = 0 + millis;
                }
                double d = (double) j2;
                double an = (double) this.f4782a.mo8260an();
                Double.isNaN(an);
                Double.isNaN(d);
                j = (long) (d * (an / 100.0d));
            }
            mo7303a(j);
        }
    }
}
