package p118io.presage.core;

import android.content.Context;
import java.io.File;
import p118io.presage.core.llIIIllI;

/* renamed from: io.presage.core.IlIIIlIl */
public class IlIIIlIl {
    public static final String IIIIIlll = lllIIlIl.IIIIIIII;
    public static final String IIIIlIII = lllIIlIl.IIIIIIIl;
    public Context IIIIIIII;
    public IlIIIIII IIIIIIIl;
    public int IIIIIIlI;
    public lIllIlll IIIIIIll;
    public llIIIIlI IIIIIlII;
    public lIIlIlll IIIIIlIl;
    public llIIlllI IIIIIllI;

    public IlIIIlIl(Context context, IlIIIIII ilIIIIII, lIllllll lillllll, lIlllIIl lillliil, lIIlIIll liiliill) {
        if (ilIIIIII == null) {
            throw new IlIIIllI();
        } else if (lillllll == null) {
            throw new IlIIIllI();
        } else if (lillliil == null) {
            throw new IlIIIllI();
        } else if (liiliill == null) {
            throw new IlIIIllI();
        } else if (ilIIIIII.IIIIIIII == null) {
            throw new IlIIIllI();
        } else if (ilIIIIII.IIIIIIIl == null) {
            throw new IlIIIllI();
        } else if (ilIIIIII.IIIIIIll == null) {
            throw new IlIIIllI();
        } else if (ilIIIIII.IIIIIIlI != null) {
            try {
                this.IIIIIIII = context;
                this.IIIIIIIl = ilIIIIII;
                File file = lillllll.IIIIIIIl;
                this.IIIIIIll = new lIllIlll(context, IIIIIlll, IIIIlIII, 0);
                lIIlIlll liililll = new lIIlIlll(context, liiliill);
                this.IIIIIlIl = liililll;
                this.IIIIIllI = new llIIllIl(context, lillliil, liililll);
                this.IIIIIlII = new llIIIIlI(context, lillllll, this.IIIIIIll, this.IIIIIllI);
                this.IIIIIIlI = 0;
            } catch (Exception e) {
                throw new IlIIIllI(e);
            }
        } else {
            throw new IlIIIllI();
        }
    }

    public final void IIIIIIII(IIIIlllI iIIIlllI) {
        if (iIIIlllI != null) {
            iIIIlllI.IIIIIIII();
        }
    }

    public final void IIIIIIII(Exception exc, int i) {
        lIIIIlIl.IIIIIIII(exc, i);
        if (exc instanceof lIlllIII) {
            llIlIlll.IIIIIIII(IIIIlIll.IIIIIIII(200));
        }
    }

    public boolean IIIIIIII() {
        return this.IIIIIIlI == 1;
    }

    public final boolean IIIIIIIl() {
        return this.IIIIIlII.IIIIlIII == 0;
    }

    public void IIIIIIlI() {
        this.IIIIIIIl.IIIIIIll.size();
        if (this.IIIIIIlI == 0 && !this.IIIIIIIl.IIIIIIll.isEmpty()) {
            try {
                this.IIIIIIlI = 1;
                this.IIIIIlII.IIIIIIIl();
                for (IIllllll IIIIIIII2 : this.IIIIIIIl.IIIIIIll) {
                    try {
                        IIIIIIII2.IIIIIIII(this.IIIIIIIl.IIIIIIII, this.IIIIIIIl.IIIIIIlI, new IlIIIIlI(this));
                    } catch (Exception e) {
                        lIIIIlIl.IIIIIIII(e, 1);
                    }
                }
            } catch (Exception e2) {
                this.IIIIIIlI = 0;
                throw new IlIIIllI(e2);
            }
        }
    }

    public void IIIIIIIl(IIIIlllI iIIIlllI) {
        if (IIIIIIII()) {
            this.IIIIIIlI = 3;
            for (IIllllll next : this.IIIIIIIl.IIIIIIll) {
                if (next.IIIIIlll) {
                    next.IIIIIlll();
                }
            }
            this.IIIIIlII.IIIIIIII(false, (llIIIllI.IIIIIlIl) new IlIIIIIl(this, iIIIlllI));
        }
    }
}
