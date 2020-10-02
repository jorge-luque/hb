package p118io.presage.core;

import p118io.presage.core.IIllllll;
import p118io.presage.core.IllllllI;
import p118io.presage.core.llIIlllI;

/* renamed from: io.presage.core.IlIIIIlI */
public class IlIIIIlI implements IIllllll.IIIIIlII {
    public final /* synthetic */ IlIIIlIl IIIIIIII;

    /* renamed from: io.presage.core.IlIIIIlI$IIIIIIII */
    public class IIIIIIII implements IllllllI.IIIIIIII {
        public final /* synthetic */ IIllllll IIIIIIII;

        public IIIIIIII(IIllllll iIllllll) {
            this.IIIIIIII = iIllllll;
        }

        public void IIIIIIII(IIIlIIlI iIIlIIlI, byte[] bArr) {
            if (bArr == null) {
                lIIIIlIl.IIIIIIII(new IllIIIIl(), 0);
                return;
            }
            int i = this.IIIIIIII.IIIIlIII;
            if (i == 0) {
                IlIIIlIl ilIIIlIl = IlIIIIlI.this.IIIIIIII;
                ilIIIlIl.IIIIIlII.IIIIIIII(bArr, (llIIlIll) new IlIIIIll(ilIIIlIl));
            } else if (i == 1) {
                IlIIIlIl ilIIIlIl2 = IlIIIIlI.this.IIIIIIII;
                ilIIIlIl2.IIIIIllI.IIIIIIII(bArr, (llIIlllI.IIIIIIlI) new IlIIIlII(ilIIIlIl2));
            }
        }
    }

    public IlIIIIlI(IlIIIlIl ilIIIlIl) {
        this.IIIIIIII = ilIIIlIl;
    }

    public void IIIIIIII(IIllllll iIllllll, IIIlIIlI iIIlIIlI) {
        if (iIIlIIlI != null) {
            try {
                new IllllllI(this.IIIIIIII.IIIIIIII, iIIlIIlI, new IIIIIIII(iIllllll)).IIIIIIII(this.IIIIIIII.IIIIIIIl.IIIIIIIl, false, new Void[0]);
            } catch (IIlllIII e) {
                lIIIIlIl.IIIIIIII(e, 0);
            }
        }
    }
}
