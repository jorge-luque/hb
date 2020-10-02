package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.impl.mediation.p045b.C1698b;
import com.applovin.impl.sdk.utils.C1991g;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.x */
public class C2041x {

    /* renamed from: a */
    private final C1941j f6765a;

    /* renamed from: b */
    private final C1977q f6766b;

    /* renamed from: c */
    private final MaxAdView f6767c;

    public C2041x(MaxAdView maxAdView, C1941j jVar) {
        this.f6765a = jVar;
        this.f6766b = jVar.mo8602v();
        this.f6767c = maxAdView;
    }

    /* renamed from: a */
    public long mo8853a(C1698b bVar) {
        long j;
        this.f6766b.mo8742b("ViewabilityTracker", "Checking visibility...");
        if (!this.f6767c.isShown()) {
            this.f6766b.mo8746e("ViewabilityTracker", "View is hidden");
            j = 2;
        } else {
            j = 0;
        }
        if (this.f6767c.getAlpha() < bVar.mo7786r()) {
            this.f6766b.mo8746e("ViewabilityTracker", "View is transparent");
            j |= 4;
        }
        Animation animation = this.f6767c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            this.f6766b.mo8746e("ViewabilityTracker", "View is animating");
            j |= 8;
        }
        if (this.f6767c.getParent() == null) {
            this.f6766b.mo8746e("ViewabilityTracker", "No parent view found");
            j |= 16;
        }
        int pxToDp = AppLovinSdkUtils.pxToDp(this.f6767c.getContext(), this.f6767c.getWidth());
        if (pxToDp < bVar.mo7784p()) {
            C1977q qVar = this.f6766b;
            qVar.mo8746e("ViewabilityTracker", "View has width (" + pxToDp + ") below threshold");
            j |= 32;
        }
        int pxToDp2 = AppLovinSdkUtils.pxToDp(this.f6767c.getContext(), this.f6767c.getHeight());
        if (pxToDp2 < bVar.mo7785q()) {
            C1977q qVar2 = this.f6766b;
            qVar2.mo8746e("ViewabilityTracker", "View has height (" + pxToDp2 + ") below threshold");
            j |= 64;
        }
        Point a = C1991g.m7836a(this.f6767c.getContext());
        Rect rect = new Rect(0, 0, a.x, a.y);
        int[] iArr = {-1, -1};
        this.f6767c.getLocationOnScreen(iArr);
        Rect rect2 = new Rect(iArr[0], iArr[1], iArr[0] + this.f6767c.getWidth(), iArr[1] + this.f6767c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            C1977q qVar3 = this.f6766b;
            qVar3.mo8746e("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            j |= 128;
        }
        Activity a2 = this.f6765a.mo8565aa().mo8070a();
        if (a2 != null && !C2029r.m8017a((View) this.f6767c, a2)) {
            this.f6766b.mo8746e("ViewabilityTracker", "View is not in top activity's view hierarchy");
            j |= 256;
        }
        C1977q qVar4 = this.f6766b;
        qVar4.mo8742b("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j));
        return j;
    }
}
