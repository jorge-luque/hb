package com.applovin.impl.adview.p034a.p035a;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1578l;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p049ad.C1827g;

/* renamed from: com.applovin.impl.adview.a.a.a */
abstract class C1517a {

    /* renamed from: a */
    final C1941j f4777a;

    /* renamed from: b */
    final AppLovinFullscreenActivity f4778b;

    /* renamed from: c */
    final C1827g f4779c;

    /* renamed from: d */
    final ViewGroup f4780d;

    /* renamed from: e */
    final FrameLayout.LayoutParams f4781e = new FrameLayout.LayoutParams(-1, -1, 17);

    C1517a(C1827g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1941j jVar) {
        this.f4779c = gVar;
        this.f4777a = jVar;
        this.f4778b = appLovinFullscreenActivity;
        FrameLayout frameLayout = new FrameLayout(appLovinFullscreenActivity);
        this.f4780d = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.f4780d.setLayoutParams(this.f4781e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7297a(C1827g.C1831c cVar, int i, C1578l lVar) {
        lVar.mo7462a(cVar.f5725a, cVar.f5729e, cVar.f5728d, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(lVar.getLayoutParams());
        int i2 = cVar.f5727c;
        layoutParams.setMargins(i2, cVar.f5726b, i2, 0);
        layoutParams.gravity = i;
        this.f4780d.addView(lVar, layoutParams);
    }
}
