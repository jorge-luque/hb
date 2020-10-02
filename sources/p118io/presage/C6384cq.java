package p118io.presage;

import android.content.Context;

/* renamed from: io.presage.cq */
public final class C6384cq {

    /* renamed from: a */
    private final Context f16936a;

    /* renamed from: b */
    private final C6387ct f16937b;

    /* renamed from: c */
    private final C6481gf<C6437ep> f16938c;

    public C6384cq(Context context, C6387ct ctVar, C6481gf<C6437ep> gfVar) {
        this.f16936a = context;
        this.f16937b = ctVar;
        this.f16938c = gfVar;
    }

    /* renamed from: a */
    public final C6385cr mo35308a(C6396db dbVar) {
        C6385cr crVar = new C6385cr(this.f16936a, dbVar.getMraidCommandExecutor(), this.f16937b);
        crVar.mo35309a(this.f16938c);
        return crVar;
    }
}
