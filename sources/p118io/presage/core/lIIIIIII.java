package p118io.presage.core;

import android.content.Context;

/* renamed from: io.presage.core.lIIIIIII */
public final class lIIIIIII implements Runnable {
    public final /* synthetic */ Context IIIIIIII;
    public final /* synthetic */ IIIIIlll IIIIIIIl;

    public lIIIIIII(Context context, IIIIIlll iIIIIlll) {
        this.IIIIIIII = context;
        this.IIIIIIIl = iIIIIlll;
    }

    public void run() {
        if (!lIIIIlIl.IIIIIlII()) {
            try {
                Thread.currentThread().getId();
                Thread.currentThread().getName();
                lIIIIlIl liiiilil = new lIIIIlIl(this.IIIIIIII, IIllllIl.IIIIIIlI().IIIIIIIl(), this.IIIIIIIl, (lIIIIIII) null);
                lIIIIlIl.IIIIlIlI = liiiilil;
                liiiilil.IIIIIIlI();
            } catch (Illlllll unused) {
            }
        }
    }
}
