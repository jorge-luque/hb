package p118io.presage.core;

import p118io.presage.core.llIIIllI;

/* renamed from: io.presage.core.lIIIIIll */
public final class lIIIIIll implements Runnable {
    public final /* synthetic */ IIIIlllI IIIIIIII;

    /* renamed from: io.presage.core.lIIIIIll$IIIIIIII */
    public class IIIIIIII implements llIIIllI.IIIIIlIl {
        public IIIIIIII() {
        }

        public void IIIIIIII() {
            IIIIlllI iIIIlllI = lIIIIIll.this.IIIIIIII;
            if (iIIIlllI != null) {
                iIIIlllI.IIIIIIII();
            }
        }
    }

    public lIIIIIll(IIIIlllI iIIIlllI) {
        this.IIIIIIII = iIIIlllI;
    }

    public void run() {
        if (lIIIIlIl.IIIIIlII()) {
            lIIIIlIl liiiilil = lIIIIlIl.IIIIlIlI;
            IIIIIIII iiiiiiii = new IIIIIIII();
            if (liiiilil.IIIIIllI != 0) {
                liiiilil.IIIIIlll = iiiiiiii;
                liiiilil.IIIIIIII();
                return;
            }
            return;
        }
        IIIIlllI iIIIlllI = this.IIIIIIII;
        if (iIIIlllI != null) {
            iIIIlllI.IIIIIIII();
        }
    }
}
