package p118io.presage.interstitial.optinvideo;

import android.content.Context;
import p118io.presage.Appenzeller;
import p118io.presage.C6224ao;
import p118io.presage.C6227ar;
import p118io.presage.C6437ep;
import p118io.presage.C6482gg;
import p118io.presage.C6515hm;
import p118io.presage.CantalEntreDeux;
import p118io.presage.EcirdelAubrac;
import p118io.presage.SableduBoulonnais;
import p118io.presage.common.AdConfig;
import p118io.presage.common.network.models.RewardItem;

/* renamed from: io.presage.interstitial.optinvideo.PresageOptinVideo */
public final class PresageOptinVideo {

    /* renamed from: a */
    private final CantalEntreDeux f17067a;

    /* renamed from: io.presage.interstitial.optinvideo.PresageOptinVideo$CamembertauCalvados */
    static final class CamembertauCalvados extends C6515hm implements C6482gg<RewardItem, C6437ep> {

        /* renamed from: a */
        final /* synthetic */ PresageOptinVideoCallback f17068a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        CamembertauCalvados(PresageOptinVideoCallback presageOptinVideoCallback) {
            super(1);
            this.f17068a = presageOptinVideoCallback;
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ Object mo34409a(Object obj) {
            m21450a((RewardItem) obj);
            return C6437ep.f17017a;
        }

        /* renamed from: a */
        private void m21450a(RewardItem rewardItem) {
            this.f17068a.onAdRewarded(rewardItem);
        }
    }

    private PresageOptinVideo(CantalEntreDeux cantalEntreDeux) {
        this.f17067a = cantalEntreDeux;
    }

    public final boolean isLoaded() {
        return this.f17067a.mo34508b();
    }

    public final void load() {
        this.f17067a.mo34503a();
    }

    public final void setOptinVideoCallback(PresageOptinVideoCallback presageOptinVideoCallback) {
        this.f17067a.mo34505a((EcirdelAubrac) new C6224ao(presageOptinVideoCallback));
        this.f17067a.mo34506a((C6482gg<? super RewardItem, C6437ep>) new CamembertauCalvados(presageOptinVideoCallback));
    }

    public final void setUserId(String str) {
        this.f17067a.mo34507a(str);
    }

    public final void show() {
        this.f17067a.mo34504a((Appenzeller) C6227ar.f16764a);
    }

    public PresageOptinVideo(Context context, AdConfig adConfig) {
        this(new CantalEntreDeux(context, adConfig, SableduBoulonnais.OPTIN_VIDEO));
    }
}
