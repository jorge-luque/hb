package p118io.presage;

import android.content.Context;

/* renamed from: io.presage.cx */
public final class C6391cx {

    /* renamed from: a */
    public static final CamembertauCalvados f16959a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final C6392cy f16960b;

    /* renamed from: c */
    private final C6392cy f16961c;

    /* renamed from: d */
    private final C6392cy f16962d;

    /* renamed from: e */
    private final C6392cy f16963e;

    /* renamed from: io.presage.cx$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static C6391cx m21217a(Context context, PontlEveque pontlEveque) {
            Taleggio taleggio = new Taleggio(context);
            C6395da daVar = new C6395da(taleggio);
            C6393cz czVar = new C6393cz(taleggio, RaclettedeSavoiefumee.m20624a(pontlEveque));
            return new C6391cx(daVar, new C6390cw(taleggio, czVar, pontlEveque), new C6389cv(), czVar, (byte) 0);
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    private C6391cx(C6392cy cyVar, C6392cy cyVar2, C6392cy cyVar3, C6392cy cyVar4) {
        this.f16960b = cyVar;
        this.f16961c = cyVar2;
        this.f16962d = cyVar3;
        this.f16963e = cyVar4;
    }

    /* renamed from: a */
    public final void mo35330a(C6396db dbVar) {
        this.f16960b.mo35329a(dbVar.getMraidCommandExecutor());
    }

    /* renamed from: b */
    public final void mo35331b(C6396db dbVar) {
        this.f16961c.mo35329a(dbVar.getMraidCommandExecutor());
    }

    /* renamed from: c */
    public final void mo35332c(C6396db dbVar) {
        this.f16962d.mo35329a(dbVar.getMraidCommandExecutor());
    }

    /* renamed from: d */
    public final void mo35333d(C6396db dbVar) {
        this.f16963e.mo35329a(dbVar.getMraidCommandExecutor());
    }

    public /* synthetic */ C6391cx(C6392cy cyVar, C6392cy cyVar2, C6392cy cyVar3, C6392cy cyVar4, byte b) {
        this(cyVar, cyVar2, cyVar3, cyVar4);
    }
}
