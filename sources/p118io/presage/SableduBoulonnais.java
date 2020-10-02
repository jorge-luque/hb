package p118io.presage;

import admost.sdk.AdMostInterstitial;

/* renamed from: io.presage.SableduBoulonnais */
public enum SableduBoulonnais {
    INTERSTITIAL(AdMostInterstitial.ZONE_TYPE_INTERSTITIAL),
    OPTIN_VIDEO("optin_video"),
    OVERLAY_THUMBNAIL("overlay_thumbnail");
    

    /* renamed from: e */
    private final String f16675e;

    private SableduBoulonnais(String str) {
        this.f16675e = str;
    }

    /* renamed from: a */
    public final boolean mo34663a() {
        return this == INTERSTITIAL || this == OPTIN_VIDEO;
    }

    /* renamed from: b */
    public final boolean mo34664b() {
        return this == OVERLAY_THUMBNAIL;
    }

    /* renamed from: c */
    public final String mo34665c() {
        return this.f16675e;
    }
}
