package p118io.presage;

import android.content.Context;
import java.util.List;
import p118io.presage.common.PresageSdk;

/* renamed from: io.presage.AbbayedeTamie */
public final class AbbayedeTamie {

    /* renamed from: a */
    private C6556j f16325a;

    /* renamed from: b */
    private final Context f16326b;

    /* renamed from: c */
    private final C6574t f16327c;

    /* renamed from: d */
    private final C6579y f16328d;

    /* renamed from: e */
    private final SableduBoulonnais f16329e;

    /* renamed from: f */
    private final C6565k f16330f;

    /* renamed from: g */
    private final PresageSdk f16331g;

    /* renamed from: h */
    private final AffideliceauChablis f16332h;

    private AbbayedeTamie(Context context, C6574t tVar, C6579y yVar, SableduBoulonnais sableduBoulonnais, C6565k kVar, PresageSdk presageSdk, AffideliceauChablis affideliceauChablis) {
        this.f16326b = context;
        this.f16327c = tVar;
        this.f16328d = yVar;
        this.f16329e = sableduBoulonnais;
        this.f16330f = kVar;
        this.f16331g = presageSdk;
        this.f16332h = affideliceauChablis;
    }

    /* renamed from: b */
    private final boolean m20130b() {
        return this.f16325a == null;
    }

    /* renamed from: c */
    private final boolean m20131c() {
        if (m20130b()) {
            return true;
        }
        C6556j jVar = this.f16325a;
        return jVar != null && !jVar.mo35572b();
    }

    /* renamed from: d */
    private final boolean m20132d() {
        return C6574t.m21570a(this.f16326b);
    }

    /* renamed from: e */
    private final boolean m20133e() {
        return this.f16329e.mo34663a() && AffideliceauChablis.m20200b();
    }

    /* renamed from: f */
    private final boolean m20134f() {
        return this.f16329e.mo34664b() && AffideliceauChablis.m20198a();
    }

    /* renamed from: g */
    private final boolean m20135g() {
        return m20133e() || m20134f();
    }

    /* renamed from: h */
    private final boolean m20136h() {
        return !this.f16328d.mo35605a(this.f16326b);
    }

    /* renamed from: a */
    public final boolean mo34428a(EcirdelAubrac ecirdelAubrac, boolean z, List<PontlEveque> list) {
        if (m20128a()) {
            if (ecirdelAubrac != null) {
                ecirdelAubrac.mo34541a(5);
            }
            return false;
        }
        this.f16325a = C6565k.m21538a(this.f16326b);
        if (!z || list.isEmpty()) {
            if (ecirdelAubrac != null) {
                ecirdelAubrac.mo34544d();
            }
            return false;
        }
        for (Number intValue : C6447ez.m21320b(3, 2, 7, 8, 1)) {
            int intValue2 = intValue.intValue();
            if (m20129a(intValue2)) {
                if (ecirdelAubrac != null) {
                    ecirdelAubrac.mo34541a(intValue2);
                }
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ AbbayedeTamie(Context context, C6574t tVar, C6579y yVar, SableduBoulonnais sableduBoulonnais) {
        this(context, tVar, yVar, sableduBoulonnais, C6565k.f17116a, PresageSdk.f16922a, AffideliceauChablis.f16369a);
    }

    /* renamed from: a */
    private final boolean m20129a(int i) {
        if (i == 1) {
            return m20136h();
        }
        if (i == 2) {
            return m20131c();
        }
        if (i == 3) {
            return m20130b();
        }
        if (i == 7) {
            return m20132d();
        }
        if (i == 8) {
            return m20135g();
        }
        throw new IllegalArgumentException("Illegal argument ".concat(String.valueOf(i)));
    }

    /* renamed from: a */
    public static boolean m20128a() {
        return !PresageSdk.m21152b();
    }

    /* renamed from: a */
    public final boolean mo34427a(EcirdelAubrac ecirdelAubrac) {
        if (this.f16328d.mo35605a(this.f16326b)) {
            return false;
        }
        if (ecirdelAubrac != null) {
            ecirdelAubrac.mo34541a(1);
        }
        return true;
    }
}
