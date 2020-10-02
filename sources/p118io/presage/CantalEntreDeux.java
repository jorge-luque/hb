package p118io.presage;

import android.content.Context;
import p118io.presage.common.AdConfig;
import p118io.presage.common.network.models.RewardItem;

/* renamed from: io.presage.CantalEntreDeux */
public final class CantalEntreDeux {

    /* renamed from: a */
    private AbbayedeTimadeuc f16432a;

    /* renamed from: b */
    private EcirdelAubrac f16433b;

    /* renamed from: c */
    private String f16434c;

    /* renamed from: d */
    private C6482gg<? super RewardItem, C6437ep> f16435d;

    /* renamed from: e */
    private final Context f16436e;

    /* renamed from: f */
    private final AdConfig f16437f;

    /* renamed from: g */
    private final SableduBoulonnais f16438g;

    /* renamed from: h */
    private final AbbayeduMontdesCats f16439h;

    private CantalEntreDeux(Context context, AdConfig adConfig, SableduBoulonnais sableduBoulonnais, AbbayeduMontdesCats abbayeduMontdesCats) {
        this.f16436e = context;
        this.f16437f = adConfig;
        this.f16438g = sableduBoulonnais;
        this.f16439h = abbayeduMontdesCats;
        this.f16434c = "";
    }

    /* renamed from: c */
    private final AbbayedeTimadeuc m20289c() {
        AbbayedeTimadeuc a = this.f16439h.mo34447a();
        a.mo34430a(this.f16433b);
        a.mo34433a(this.f16435d);
        a.mo34434a(this.f16434c);
        return a;
    }

    /* renamed from: a */
    public final void mo34506a(C6482gg<? super RewardItem, C6437ep> ggVar) {
        this.f16435d = ggVar;
    }

    /* renamed from: b */
    public final boolean mo34508b() {
        AbbayedeTimadeuc abbayedeTimadeuc = this.f16432a;
        if (abbayedeTimadeuc != null) {
            return abbayedeTimadeuc.mo34435a();
        }
        return false;
    }

    /* renamed from: a */
    public final void mo34503a() {
        AbbayedeTimadeuc abbayedeTimadeuc;
        AbbayedeTimadeuc abbayedeTimadeuc2 = this.f16432a;
        if (!(abbayedeTimadeuc2 == null || !abbayedeTimadeuc2.mo34438c() || (abbayedeTimadeuc = this.f16432a) == null)) {
            abbayedeTimadeuc.mo34440e();
        }
        AbbayedeTimadeuc c = m20289c();
        this.f16432a = c;
        if (c != null) {
            c.mo34439d();
        }
    }

    public /* synthetic */ CantalEntreDeux(Context context, AdConfig adConfig, SableduBoulonnais sableduBoulonnais) {
        this(context, adConfig, sableduBoulonnais, new AbbayeduMontdesCats(context, adConfig, sableduBoulonnais));
    }

    /* renamed from: a */
    public final void mo34505a(EcirdelAubrac ecirdelAubrac) {
        this.f16433b = ecirdelAubrac;
        AbbayedeTimadeuc abbayedeTimadeuc = this.f16432a;
        if (abbayedeTimadeuc != null) {
            abbayedeTimadeuc.mo34430a(ecirdelAubrac);
        }
    }

    /* renamed from: a */
    public final void mo34504a(Appenzeller appenzeller) {
        EcirdelAubrac ecirdelAubrac;
        if (this.f16432a == null && (ecirdelAubrac = this.f16433b) != null) {
            ecirdelAubrac.mo34544d();
        }
        AbbayedeTimadeuc abbayedeTimadeuc = this.f16432a;
        if (abbayedeTimadeuc != null) {
            abbayedeTimadeuc.mo34429a(appenzeller);
        }
    }

    /* renamed from: a */
    public final void mo34507a(String str) {
        this.f16434c = str;
    }
}
