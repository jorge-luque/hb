package p118io.presage;

import android.app.Application;
import android.content.Context;
import java.util.List;
import p118io.presage.interstitial.p207ui.InterstitialActivity;

/* renamed from: io.presage.as */
public final class C6228as implements Bofavre {

    /* renamed from: a */
    private final InterstitialActivity.CamembertauCalvados f16766a;

    public /* synthetic */ C6228as() {
        this(InterstitialActivity.f17069a);
    }

    /* renamed from: a */
    public final void mo34457a(Application application, List<PontlEveque> list, String str) {
        PontlEveque a = FourmedAmbertBio.m20382a(list, str);
        if (a != null) {
            this.f16766a.mo34455a((Context) application, a, list);
        }
    }

    private C6228as(InterstitialActivity.CamembertauCalvados camembertauCalvados) {
        this.f16766a = camembertauCalvados;
    }
}
