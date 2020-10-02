package com.adcolony.sdk;

public abstract class AdColonyAdViewListener {

    /* renamed from: a */
    String f3286a = "";

    /* renamed from: b */
    AdColonyAdSize f3287b;

    /* renamed from: c */
    C1218c0 f3288c;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdColonyAdSize mo6260a() {
        return this.f3287b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1218c0 mo6264b() {
        return this.f3288c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo6265c() {
        return this.f3286a;
    }

    public void onClicked(AdColonyAdView adColonyAdView) {
    }

    public void onClosed(AdColonyAdView adColonyAdView) {
    }

    public void onLeftApplication(AdColonyAdView adColonyAdView) {
    }

    public void onOpened(AdColonyAdView adColonyAdView) {
    }

    public abstract void onRequestFilled(AdColonyAdView adColonyAdView);

    public void onRequestNotFilled(AdColonyZone adColonyZone) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6262a(C1218c0 c0Var) {
        this.f3288c = c0Var;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6263a(String str) {
        this.f3286a = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6261a(AdColonyAdSize adColonyAdSize) {
        this.f3287b = adColonyAdSize;
    }
}
