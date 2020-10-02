package p118io.presage.core;

import android.content.Context;

/* renamed from: io.presage.core.llIIllIl */
public class llIIllIl extends llIIlllI {
    public llIIllIl(Context context, lIlllIIl lillliil) {
        super(context, lillliil, (lIIlIlll) null);
    }

    public llIIllIl(Context context, lIlllIIl lillliil, lIIlIlll liililll) {
        super(context, lillliil, liililll);
    }

    public lIIIllII IIIIIIII(Context context, lIlllIIl lillliil) {
        return new lIIlIIIl(context, lillliil.IIIIIIIl, lillliil.IIIIIIlI, lillliil.IIIIIIll);
    }

    public boolean IIIIIIII(int i) {
        return i == 200;
    }
}
