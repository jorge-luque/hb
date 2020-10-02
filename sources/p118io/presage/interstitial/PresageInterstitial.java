package p118io.presage.interstitial;

import android.content.Context;
import p118io.presage.Appenzeller;
import p118io.presage.C6224ao;
import p118io.presage.C6227ar;
import p118io.presage.CantalEntreDeux;
import p118io.presage.EcirdelAubrac;
import p118io.presage.SableduBoulonnais;
import p118io.presage.common.AdConfig;

/* renamed from: io.presage.interstitial.PresageInterstitial */
public final class PresageInterstitial {

    /* renamed from: a */
    private final CantalEntreDeux f17066a;

    private PresageInterstitial(CantalEntreDeux cantalEntreDeux) {
        this.f17066a = cantalEntreDeux;
    }

    public final boolean isLoaded() {
        return this.f17066a.mo34508b();
    }

    public final void load() {
        this.f17066a.mo34503a();
    }

    public final void setInterstitialCallback(PresageInterstitialCallback presageInterstitialCallback) {
        this.f17066a.mo34505a((EcirdelAubrac) new C6224ao(presageInterstitialCallback));
    }

    public final void show() {
        this.f17066a.mo34504a((Appenzeller) C6227ar.f16764a);
    }

    public PresageInterstitial(Context context) {
        this(context, (AdConfig) null);
    }

    public PresageInterstitial(Context context, AdConfig adConfig) {
        this(new CantalEntreDeux(context, adConfig, SableduBoulonnais.INTERSTITIAL));
    }
}
