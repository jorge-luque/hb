package com.chartboost.sdk.Banner;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import com.chartboost.sdk.C2095R;
import com.chartboost.sdk.C2100b;
import com.chartboost.sdk.C2114g;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.ChartboostBannerListener;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostCacheEvent;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostClickEvent;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Events.ChartboostShowEvent;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C2126c;
import com.chartboost.sdk.impl.C2198q;
import com.chartboost.sdk.impl.C2202r;
import com.chartboost.sdk.impl.C2211t;

/* renamed from: com.chartboost.sdk.Banner.c */
public class C2063c implements C2114g, C2126c, C2202r, C2211t {

    /* renamed from: a */
    public String f6818a;

    /* renamed from: b */
    public BannerSize f6819b;

    /* renamed from: c */
    private ChartboostBannerListener f6820c;

    /* renamed from: d */
    private C2067f f6821d;

    /* renamed from: e */
    private C2065d f6822e;

    /* renamed from: f */
    private C2100b f6823f;

    /* renamed from: g */
    private C2198q f6824g;

    /* renamed from: com.chartboost.sdk.Banner.c$a */
    public class C2064a {

        /* renamed from: a */
        public String f6825a;

        /* renamed from: b */
        public BannerSize f6826b;

        public C2064a(C2063c cVar) {
        }
    }

    /* renamed from: b */
    private void m8119b(String str) {
        if (str != null) {
            this.f6823f.mo9181a(mo9018e(), str);
        } else {
            this.f6823f.mo9184c(mo9018e());
        }
    }

    /* renamed from: l */
    private void m8122l() {
        m8124n();
        this.f6822e.mo9027a(this.f6821d, this.f6819b);
        this.f6823f.mo9186e(mo9018e());
    }

    /* renamed from: m */
    private void m8123m() {
        if (this.f6824g != null) {
            CBLogging.m8152a("BannerPresenter", "Register refresh for location: " + mo9018e() + " at intervals of " + this.f6824g.mo9483b() + " sec");
            this.f6824g.mo9480a((C2202r) this);
            this.f6824g.mo9488f();
        }
    }

    /* renamed from: n */
    private void m8124n() {
        if (this.f6824g != null) {
            CBLogging.m8152a("BannerPresenter", "Register timeout for location: " + mo9018e() + " at intervals of " + this.f6824g.mo9485c() + " sec");
            this.f6824g.mo9481a((C2211t) this);
            this.f6824g.mo9489g();
        }
    }

    /* renamed from: o */
    private void m8125o() {
        C2239j n = C2239j.m8897n();
        C2067f fVar = this.f6821d;
        if (fVar == null || n == null) {
            Log.e("ChartboostBanner", "Please start with Chartboost SDK before creating any ChartboostBanner objects");
            return;
        }
        C2239j.C2241b sdkCommand = fVar.getSdkCommand();
        if (sdkCommand != null) {
            C2239j.m8896b((Runnable) this.f6821d.attachBannerToSDKCommand(sdkCommand));
        }
    }

    /* renamed from: p */
    private void m8126p() {
        if (this.f6824g != null) {
            CBLogging.m8152a("BannerPresenter", "Unregister refresh for location: " + mo9018e());
            this.f6824g.mo9492j();
        }
    }

    /* renamed from: q */
    private void m8127q() {
        if (this.f6824g != null) {
            CBLogging.m8152a("BannerPresenter", "Un-register timeout for location: " + mo9018e());
            this.f6824g.mo9493k();
        }
    }

    /* renamed from: a */
    public C2064a mo9005a(Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, C2095R.styleable.ChartboostBanner, 0, 0);
        String string = obtainStyledAttributes.getString(C2095R.styleable.ChartboostBanner_location);
        BannerSize fromInteger = BannerSize.fromInteger(obtainStyledAttributes.getInt(C2095R.styleable.ChartboostBanner_size, 0));
        obtainStyledAttributes.recycle();
        C2064a aVar = new C2064a(this);
        aVar.f6825a = string;
        aVar.f6826b = fromInteger;
        return aVar;
    }

    /* renamed from: c */
    public void mo9013c() {
        m8120c((String) null);
    }

    /* renamed from: d */
    public void mo9014d() {
        if (this.f6824g != null) {
            CBLogging.m8152a("BannerPresenter", "Unregister refresh and timeout for location: " + mo9018e());
            this.f6824g.mo9493k();
            this.f6824g.mo9492j();
            this.f6824g.mo9479a();
            this.f6824g = null;
        }
        this.f6821d = null;
        this.f6818a = null;
        this.f6820c = null;
        this.f6822e = null;
        this.f6823f = null;
    }

    public void didCacheBanner(String str, ChartboostCacheError chartboostCacheError) {
        ChartboostBannerListener chartboostBannerListener = this.f6820c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdCached(new ChartboostCacheEvent(), chartboostCacheError);
        }
    }

    public void didClickBanner(String str, ChartboostClickError chartboostClickError) {
        mo9024k();
        ChartboostBannerListener chartboostBannerListener = this.f6820c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdClicked(new ChartboostClickEvent(), chartboostClickError);
        }
    }

    public void didShowBanner(String str, ChartboostShowError chartboostShowError) {
        m8127q();
        ChartboostShowEvent chartboostShowEvent = new ChartboostShowEvent();
        chartboostShowEvent.location = str;
        ChartboostBannerListener chartboostBannerListener = this.f6820c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdShown(chartboostShowEvent, chartboostShowError);
            mo9013c();
            m8123m();
        }
    }

    /* renamed from: e */
    public String mo9018e() {
        return this.f6818a;
    }

    /* renamed from: f */
    public Boolean mo9019f() {
        C2100b bVar = this.f6823f;
        if (bVar != null) {
            return Boolean.valueOf(bVar.mo9183b(mo9018e()));
        }
        ChartboostBannerListener chartboostBannerListener = this.f6820c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdCached(new ChartboostCacheEvent(), new ChartboostCacheError(0));
        }
        return false;
    }

    /* renamed from: g */
    public void mo9020g() {
        if (this.f6824g != null) {
            CBLogging.m8152a("BannerPresenter", "Pause refresh for location: " + mo9018e());
            this.f6824g.mo9486d();
        }
    }

    /* renamed from: h */
    public void mo9021h() {
        if (this.f6824g != null) {
            CBLogging.m8152a("BannerPresenter", "Pause timeout for location: " + mo9018e());
            this.f6824g.mo9487e();
        }
    }

    /* renamed from: i */
    public void mo9022i() {
        if (this.f6824g != null) {
            CBLogging.m8152a("BannerPresenter", "Restart refresh if was paused for location: " + mo9018e());
            this.f6824g.mo9490h();
        }
    }

    /* renamed from: j */
    public void mo9023j() {
        if (this.f6824g != null) {
            CBLogging.m8152a("BannerPresenter", "Resume timeout if was paused for location: " + mo9018e());
            this.f6824g.mo9491i();
        }
    }

    /* renamed from: k */
    public void mo9024k() {
        if (this.f6821d.isBelowLollipop()) {
            CBLogging.m8154b("BannerPresenter", "Banner is not supported for this Android version");
            ChartboostBannerListener chartboostBannerListener = this.f6820c;
            if (chartboostBannerListener != null) {
                chartboostBannerListener.onAdShown(new ChartboostShowEvent(), new ChartboostShowError(34, false));
            }
        } else if (m8121c(2)) {
            m8127q();
            m8126p();
            m8122l();
        }
    }

    public void onBannerCacheFail(String str, ChartboostCacheError chartboostCacheError) {
        CBLogging.m8152a("BannerPresenter", "onBannerCacheFail: " + chartboostCacheError.toString());
        m8123m();
        didCacheBanner(str, chartboostCacheError);
    }

    public void onBannerShowFail(String str, ChartboostShowError chartboostShowError) {
        CBLogging.m8152a("BannerPresenter", "onBannerShowFail: " + chartboostShowError.toString());
        m8123m();
        didShowBanner(str, chartboostShowError);
        if (chartboostShowError.shouldRetry) {
            Log.e("test", "show on retry");
            mo9024k();
        }
    }

    /* renamed from: c */
    private void m8120c(String str) {
        if (this.f6821d.isBelowLollipop()) {
            CBLogging.m8154b("BannerPresenter", "Banner is not supported for this Android version");
            ChartboostBannerListener chartboostBannerListener = this.f6820c;
            if (chartboostBannerListener != null) {
                chartboostBannerListener.onAdCached(new ChartboostCacheEvent(), new ChartboostCacheError(6));
            }
        } else if (m8121c(1)) {
            m8119b(str);
        } else {
            CBLogging.m8152a("BannerPresenter", "Banner is currently processing action cache");
        }
    }

    /* renamed from: b */
    private void m8118b(int i) {
        ChartboostBannerListener chartboostBannerListener = this.f6820c;
        if (chartboostBannerListener == null) {
            return;
        }
        if (i == 1) {
            chartboostBannerListener.onAdCached(new ChartboostCacheEvent(), new ChartboostCacheError(0));
        } else if (i == 2) {
            chartboostBannerListener.onAdShown(new ChartboostShowEvent(), new ChartboostShowError(0, false));
        }
    }

    /* renamed from: b */
    public void mo9012b() {
        CBLogging.m8152a("BannerPresenter", "Notify timeout finished for location: " + mo9018e());
        m8127q();
        m8123m();
        ChartboostBannerListener chartboostBannerListener = this.f6820c;
        if (chartboostBannerListener != null) {
            chartboostBannerListener.onAdShown(new ChartboostShowEvent(), new ChartboostShowError(0, false));
            C2239j n = C2239j.m8897n();
            if (n != null) {
                n.mo9615m();
            }
        }
    }

    /* renamed from: a */
    public void mo9007a(C2067f fVar, String str, BannerSize bannerSize, ChartboostBannerListener chartboostBannerListener, C2198q qVar) {
        this.f6821d = fVar;
        this.f6818a = str;
        this.f6819b = bannerSize;
        this.f6820c = chartboostBannerListener;
        if (qVar != null) {
            this.f6824g = qVar;
            qVar.mo9480a((C2202r) this);
            this.f6824g.mo9481a((C2211t) this);
        }
        this.f6822e = new C2065d();
        this.f6823f = C2239j.m8898o();
        m8125o();
    }

    /* renamed from: c */
    private boolean m8121c(int i) {
        C2100b bVar = this.f6823f;
        if (bVar == null) {
            m8118b(i);
            return false;
        } else if (bVar.mo9182a()) {
            return true;
        } else {
            m8117a(i);
            return false;
        }
    }

    /* renamed from: a */
    public void mo9008a(ChartboostBannerListener chartboostBannerListener) {
        this.f6820c = chartboostBannerListener;
    }

    /* renamed from: a */
    public void mo9011a(boolean z) {
        C2198q qVar = this.f6824g;
        if (qVar != null) {
            qVar.mo9482a(z);
        }
    }

    /* renamed from: a */
    public void mo9009a(String str) {
        m8120c(str);
    }

    /* renamed from: a */
    private void m8117a(int i) {
        ChartboostBannerListener chartboostBannerListener = this.f6820c;
        if (chartboostBannerListener == null) {
            return;
        }
        if (i == 1) {
            chartboostBannerListener.onAdCached(new ChartboostCacheEvent(), new ChartboostCacheError(36));
        } else if (i == 2) {
            chartboostBannerListener.onAdShown(new ChartboostShowEvent(), new ChartboostShowError(36, false));
        }
    }

    /* renamed from: a */
    public void mo9010a(String str, ChartboostClickError chartboostClickError) {
        CBLogging.m8152a("BannerPresenter", "onBannerClickFail: " + chartboostClickError.toString());
        m8123m();
        didClickBanner(str, chartboostClickError);
    }

    /* renamed from: a */
    public void mo9006a() {
        CBLogging.m8152a("BannerPresenter", "Notify refresh finished for location: " + mo9018e());
        mo9024k();
    }
}
