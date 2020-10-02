package p118io.presage;

import android.content.Context;

/* renamed from: io.presage.OlivetCendre */
public final class OlivetCendre implements C6402dh {

    /* renamed from: a */
    public static final CamembertauCalvados f16596a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final C6565k f16597b;

    /* renamed from: c */
    private final Context f16598c;

    /* renamed from: d */
    private final int f16599d;

    /* renamed from: io.presage.OlivetCendre$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public OlivetCendre(C6565k kVar, Context context, int i) {
        this.f16597b = kVar;
        this.f16598c = context;
        this.f16599d = i;
    }

    /* renamed from: a */
    public final int mo34588a() {
        C6556j a = C6565k.m21538a(this.f16598c);
        return a != null ? a.mo35593n() : this.f16599d;
    }

    /* renamed from: b */
    public final int mo34589b() {
        return mo34588a() * 5;
    }
}
