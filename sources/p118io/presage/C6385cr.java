package p118io.presage;

import android.content.Context;
import java.util.Map;
import p118io.presage.mraid.browser.ShortcutActivity;

/* renamed from: io.presage.cr */
public final class C6385cr extends C6278co {

    /* renamed from: b */
    private C6481gf<C6437ep> f16939b;

    /* renamed from: c */
    private ShortcutActivity.CamembertauCalvados f16940c;

    /* renamed from: d */
    private final Context f16941d;

    /* renamed from: e */
    private final C6233ax f16942e;

    /* renamed from: f */
    private final C6387ct f16943f;

    /* renamed from: g */
    private final C6232aw f16944g;

    /* renamed from: h */
    private final C6238bb f16945h;

    public /* synthetic */ C6385cr(Context context, C6233ax axVar, C6387ct ctVar) {
        this(context, axVar, ctVar, C6232aw.f16774a, C6238bb.f16782a);
    }

    /* renamed from: a */
    public final void mo35309a(C6481gf<C6437ep> gfVar) {
        this.f16939b = gfVar;
    }

    /* renamed from: b */
    public final void mo34885b(String str, String str2) {
        if (C6232aw.m20832b(this.f16941d, str)) {
            this.f16942e.mo34767b(str2, "{isStarted: true}");
            C6481gf<C6437ep> gfVar = this.f16939b;
            if (gfVar != null) {
                gfVar.mo34405a();
                return;
            }
            return;
        }
        this.f16942e.mo34767b(str2, "{isStarted: false}");
    }

    /* renamed from: c */
    public final void mo34886c() {
        this.f16943f.mo34402s();
    }

    /* renamed from: d */
    public final void mo34887d() {
        this.f16943f.mo34400q();
    }

    /* renamed from: e */
    public final void mo34888e() {
        this.f16943f.mo34404u();
    }

    /* renamed from: a */
    public final void mo34877a(boolean z) {
        if (z) {
            this.f16943f.mo34397n();
        } else {
            this.f16943f.mo34398o();
        }
    }

    private C6385cr(Context context, C6233ax axVar, C6387ct ctVar, C6232aw awVar, C6238bb bbVar) {
        super(axVar);
        this.f16941d = context;
        this.f16942e = axVar;
        this.f16943f = ctVar;
        this.f16944g = awVar;
        this.f16945h = bbVar;
        this.f16940c = ShortcutActivity.f17119a;
    }

    /* renamed from: a */
    public final void mo34876a() {
        this.f16943f.mo34403t();
    }

    /* renamed from: a */
    public final void mo34881a(String str) {
        C6232aw.m20830a(this.f16941d, str);
    }

    /* renamed from: b */
    public final void mo34884b(String str) {
        this.f16943f.mo34382a(str);
    }

    /* renamed from: a */
    public final void mo34882a(String str, String str2) {
        if (C6232aw.m20833c(this.f16941d, str)) {
            this.f16942e.mo34767b(str2, "{isResolved: true}");
        } else {
            this.f16942e.mo34767b(str2, "{isResolved: false}");
        }
    }

    /* renamed from: b */
    public final void mo34878b() {
        this.f16943f.mo34404u();
    }

    /* renamed from: a */
    public final void mo34883a(Map<String, String> map, String str) {
        boolean z = true;
        if (str.length() > 0) {
            CharSequence charSequence = map.get("name");
            if (!(charSequence == null || charSequence.length() == 0)) {
                CharSequence charSequence2 = map.get("icon");
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    ShortcutActivity.CamembertauCalvados.m21551a(this.f16941d, new C6386cs(String.valueOf(map.get("id")), String.valueOf(map.get("name")), String.valueOf(map.get("icon")), str));
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo34879a(SaintFelicien saintFelicien) {
        C6238bb.m20878a((C6237ba) new C6240bd(saintFelicien.mo34668b(), saintFelicien.mo34674e()));
    }

    /* renamed from: a */
    public final void mo34880a(C6388cu cuVar) {
        this.f16943f.mo34381a(cuVar);
    }
}
