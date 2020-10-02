package com.chartboost.sdk.impl;

import com.chartboost.sdk.Events.ChartboostCacheError;
import com.chartboost.sdk.Events.ChartboostClickError;
import com.chartboost.sdk.Events.ChartboostShowError;
import com.chartboost.sdk.Model.CBError;

/* renamed from: com.chartboost.sdk.impl.d */
public class C2131d extends C2117a {

    /* renamed from: i */
    private C2126c f7134i;

    private C2131d(C2126c cVar, C2122b bVar) {
        super(3, bVar.mo9317a(), bVar.mo9320d(), bVar.mo9318b(), bVar.mo9321e(), bVar.mo9319c(), bVar.mo9323g(), bVar.mo9322f());
        this.f7134i = cVar;
    }

    /* renamed from: a */
    public static C2131d m8467a(C2126c cVar) {
        return new C2131d(cVar, new C2122b());
    }

    /* renamed from: a */
    public void mo9271a(String str, CBError.CBImpressionError cBImpressionError) {
    }

    /* renamed from: b */
    public void mo9272b(String str) {
        this.f7134i.didClickBanner(str, (ChartboostClickError) null);
    }

    /* renamed from: e */
    public void mo9275e(String str) {
        this.f7134i.didShowBanner(str, (ChartboostShowError) null);
    }

    /* renamed from: a */
    public void mo9268a(String str) {
        this.f7134i.didCacheBanner(str, (ChartboostCacheError) null);
    }

    /* renamed from: a */
    public void mo9269a(String str, ChartboostCacheError chartboostCacheError) {
        this.f7134i.onBannerCacheFail(str, chartboostCacheError);
    }

    /* renamed from: a */
    public void mo9270a(String str, ChartboostShowError chartboostShowError) {
        this.f7134i.onBannerShowFail(str, chartboostShowError);
    }
}
