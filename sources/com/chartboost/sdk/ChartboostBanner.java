package com.chartboost.sdk;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Banner.BannerSize;
import com.chartboost.sdk.Banner.C2063c;
import com.chartboost.sdk.Banner.C2067f;
import com.chartboost.sdk.C2239j;
import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.impl.C2126c;
import com.chartboost.sdk.impl.C2198q;

public class ChartboostBanner extends RelativeLayout implements C2067f, C2114g, C2126c {

    /* renamed from: b */
    private static final String f6839b = ChartboostBanner.class.getSimpleName();

    /* renamed from: a */
    private C2063c f6840a;

    public ChartboostBanner(Context context) {
        super(context);
        C2063c cVar = new C2063c();
        this.f6840a = cVar;
        cVar.mo9007a(this, "", BannerSize.STANDARD, (ChartboostBannerListener) null, new C2198q());
    }

    public C2239j.C2241b attachBannerToSDKCommand(C2239j.C2241b bVar) {
        bVar.f7599e = this;
        return bVar;
    }

    public void cache() {
        this.f6840a.mo9013c();
    }

    public void detachBanner() {
        this.f6840a.mo9014d();
    }

    public void didCacheBanner(String str, ChartboostCacheError chartboostCacheError) {
        this.f6840a.didCacheBanner(str, chartboostCacheError);
    }

    public void didClickBanner(String str, ChartboostClickError chartboostClickError) {
        this.f6840a.didClickBanner(str, chartboostClickError);
    }

    public void didShowBanner(String str, ChartboostShowError chartboostShowError) {
        this.f6840a.didShowBanner(str, chartboostShowError);
    }

    public int getBannerHeight() {
        return BannerSize.getHeight(this.f6840a.f6819b);
    }

    public int getBannerWidth() {
        return BannerSize.getWidth(this.f6840a.f6819b);
    }

    public DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public String getLocation() {
        return this.f6840a.mo9018e();
    }

    public C2239j.C2241b getSdkCommand() {
        C2239j n = C2239j.m8897n();
        if (n == null) {
            return null;
        }
        n.getClass();
        return new C2239j.C2241b(6);
    }

    public ViewGroup.LayoutParams getViewLayoutParams() {
        return getLayoutParams();
    }

    public boolean isBelowLollipop() {
        return Build.VERSION.SDK_INT < 21;
    }

    public Boolean isCached() {
        return this.f6840a.mo9019f();
    }

    public void onBannerCacheFail(String str, ChartboostCacheError chartboostCacheError) {
        this.f6840a.onBannerCacheFail(str, chartboostCacheError);
    }

    public void onBannerClickFail(String str, ChartboostClickError chartboostClickError) {
        this.f6840a.mo9010a(str, chartboostClickError);
    }

    public void onBannerShowFail(String str, ChartboostShowError chartboostShowError) {
        this.f6840a.onBannerShowFail(str, chartboostShowError);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.f6840a.mo9022i();
            this.f6840a.mo9023j();
            return;
        }
        this.f6840a.mo9020g();
        this.f6840a.mo9021h();
    }

    public void setAutomaticallyRefreshesContent(boolean z) {
        this.f6840a.mo9011a(z);
    }

    public void setListener(ChartboostBannerListener chartboostBannerListener) {
        this.f6840a.mo9008a(chartboostBannerListener);
    }

    public void setViewLayoutParams(ViewGroup.LayoutParams layoutParams) {
        setLayoutParams(layoutParams);
    }

    public void show() {
        this.f6840a.mo9024k();
    }

    public void cache(String str) {
        this.f6840a.mo9009a(str);
    }

    public ChartboostBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        String str;
        BannerSize bannerSize;
        C2063c cVar = new C2063c();
        this.f6840a = cVar;
        C2063c.C2064a a = cVar.mo9005a(context.getTheme(), attributeSet);
        if (a == null || (str = a.f6825a) == null || (bannerSize = a.f6826b) == null) {
            CBLogging.m8154b(f6839b, "Error creating ChartboostBanner, make sure the attributes declared in the XML are correct");
            return;
        }
        this.f6840a.mo9007a(this, str, bannerSize, (ChartboostBannerListener) null, new C2198q());
    }

    public ChartboostBanner(Context context, String str, BannerSize bannerSize, ChartboostBannerListener chartboostBannerListener) {
        super(context);
        C2063c cVar = new C2063c();
        this.f6840a = cVar;
        cVar.mo9007a(this, str, bannerSize, chartboostBannerListener, new C2198q());
    }

    public ChartboostBanner(Context context, C2067f fVar, String str, BannerSize bannerSize, ChartboostBannerListener chartboostBannerListener) {
        super(context);
        C2063c cVar = new C2063c();
        this.f6840a = cVar;
        cVar.mo9007a(fVar, str, bannerSize, chartboostBannerListener, new C2198q());
    }
}
