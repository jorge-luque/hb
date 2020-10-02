package p118io.presage.core;

/* renamed from: io.presage.core.lIIIIIlI */
public final class lIIIIIlI implements Runnable {
    public final /* synthetic */ Exception IIIIIIII;

    public lIIIIIlI(Exception exc) {
        this.IIIIIIII = exc;
    }

    public void run() {
        Thread.currentThread().getId();
        Thread.currentThread().getName();
        if (lIIIIlIl.IIIIIlII()) {
            lIIIIlIl liiiilil = lIIIIlIl.IIIIlIlI;
            Exception exc = this.IIIIIIII;
            int i = liiiilil.IIIIIllI;
            if (i != 2 && i != 0) {
                liiiilil.IIIIIlIl++;
                try {
                    new lIIIIlll(liiiilil.IIIIIIII, liiiilil.IIIIIIlI, exc, new lIIIIlII(liiiilil)).IIIIIIII(liiiilil.IIIIIIIl, false, new Void[0]);
                } catch (IIlllIII e) {
                    lIIIIlIl.IIIIIIII(e, 0);
                }
            }
        }
    }
}
