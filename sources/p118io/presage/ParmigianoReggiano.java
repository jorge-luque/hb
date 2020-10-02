package p118io.presage;

import android.content.Context;

/* renamed from: io.presage.ParmigianoReggiano */
public final class ParmigianoReggiano {

    /* renamed from: a */
    public static final CamembertauCalvados f16605a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private final PaletdeBourgogne f16606b;

    /* renamed from: c */
    private final Piastrellou f16607c;

    /* renamed from: d */
    private final Murol f16608d;

    /* renamed from: io.presage.ParmigianoReggiano$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        /* renamed from: a */
        public static ParmigianoReggiano m20529a(Context context) {
            Context applicationContext = context.getApplicationContext();
            C6514hl.m21414a((Object) applicationContext, "context.applicationContext");
            return new ParmigianoReggiano(applicationContext);
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public ParmigianoReggiano(Context context) {
        this.f16606b = new PaletdeBourgogne(context);
        this.f16607c = new Piastrellou(context);
        this.f16608d = new Murol(context);
    }

    /* renamed from: a */
    public final C6405dk mo34591a() {
        return this.f16606b;
    }

    /* renamed from: b */
    public final C6405dk mo34592b() {
        return this.f16607c;
    }

    /* renamed from: c */
    public final C6405dk mo34593c() {
        return this.f16608d;
    }
}
