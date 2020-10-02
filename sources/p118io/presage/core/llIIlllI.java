package p118io.presage.core;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import p118io.presage.core.lIIIlIII;

/* renamed from: io.presage.core.llIIlllI */
public abstract class llIIlllI {
    public Context IIIIIIII;
    public lIlllIIl IIIIIIIl;
    public lIIlIlll IIIIIIlI;

    /* renamed from: io.presage.core.llIIlllI$IIIIIIlI */
    public interface IIIIIIlI {
        void IIIIIIII(byte[] bArr, boolean z, Exception exc, int i);
    }

    /* renamed from: io.presage.core.llIIlllI$IIIIIIll */
    public interface IIIIIIll {
    }

    public llIIlllI(Context context, lIlllIIl lillliil, lIIlIlll liililll) {
        if (lillliil == null) {
            throw new lIllllIl();
        } else if (lillliil.IIIIIIII != null) {
            this.IIIIIIII = context;
            this.IIIIIIIl = lillliil;
            this.IIIIIIlI = liililll;
        } else {
            throw new lIllllIl();
        }
    }

    public abstract lIIIllII IIIIIIII(Context context, lIlllIIl lillliil);

    public final void IIIIIIII() {
        lIIlIlll liililll = this.IIIIIIlI;
        if (liililll != null) {
            liililll.IIIIIIII();
        }
    }

    public final void IIIIIIII(IIIIIIlI iIIIIIlI, byte[] bArr, boolean z, Exception exc, int i) {
        if (iIIIIIlI != null) {
            iIIIIIlI.IIIIIIII(bArr, z, exc, i);
        }
    }

    public final void IIIIIIII(IIIIIIll iIIIIIll, lIllllII lillllii, Exception exc, int i) {
        if (iIIIIIll != null) {
            ((llIIIlll) iIIIIIll).IIIIIIII.IIIIIIII(lillllii, exc);
        }
    }

    public abstract boolean IIIIIIII(int i);

    public final void IIIIIIIl() {
        lIIlIlll liililll = this.IIIIIIlI;
        if (liililll != null) {
            liililll.IIIIIIll++;
            if (liililll.IIIIIIlI.IIIIIIIl() == 1 && liililll.IIIIIIll == 1) {
                Context context = liililll.IIIIIIII;
                lIIlIIll liiliill = liililll.IIIIIIlI;
                lIIlIlII.IIIIIIII(context, liiliill.IIIIIlII, liiliill.IIIIIIII(), false, new lIIlIllI(liililll));
            }
        }
    }

    public final void IIIIIIII(IIIIIIll iIIIIIll, lIllllII lillllii) {
        if (iIIIIIll != null) {
            ((llIIIlll) iIIIIIll).IIIIIIII.IIIIIIII(lillllii);
        }
    }

    /* renamed from: io.presage.core.llIIlllI$IIIIIIII */
    public class IIIIIIII implements lIIIlIII.IIIIIIII {
        public final /* synthetic */ IIIIIIll IIIIIIII;
        public final /* synthetic */ lIllllII IIIIIIIl;

        public IIIIIIII(IIIIIIll iIIIIIll, lIllllII lillllii) {
            this.IIIIIIII = iIIIIIll;
            this.IIIIIIIl = lillllii;
        }

        public void IIIIIIII(lIIIlllI liiillli, Exception exc, int i) {
            exc.getMessage();
            lIIlIlll liililll = llIIlllI.this.IIIIIIlI;
            if (liililll != null) {
                liililll.IIIIIIII();
            }
            llIIlllI.this.IIIIIIII(this.IIIIIIII, this.IIIIIIIl, exc, i);
        }

        public void IIIIIIII(lIIIlllI liiillli, lIIlIIII liiliiii) {
            int i = liiliiii.IIIIIIII;
            lIIlIlll liililll = llIIlllI.this.IIIIIIlI;
            if (liililll != null) {
                liililll.IIIIIIII();
            }
            if (llIIlllI.this.IIIIIIII(liiliiii.IIIIIIII)) {
                llIIlllI.this.IIIIIIII(this.IIIIIIII, this.IIIIIIIl);
            } else {
                llIIlllI.this.IIIIIIII(this.IIIIIIII, this.IIIIIIIl, new lIIIllIl(String.valueOf(liiliiii.IIIIIIII)), 0);
            }
        }
    }

    /* renamed from: io.presage.core.llIIlllI$IIIIIIIl */
    public class IIIIIIIl implements lIIIlIII.IIIIIIII {
        public final /* synthetic */ IIIIIIlI IIIIIIII;
        public final /* synthetic */ byte[] IIIIIIIl;

        public IIIIIIIl(IIIIIIlI iIIIIIlI, byte[] bArr) {
            this.IIIIIIII = iIIIIIlI;
            this.IIIIIIIl = bArr;
        }

        public void IIIIIIII(lIIIlllI liiillli, Exception exc, int i) {
            exc.getMessage();
            llIIlllI.this.IIIIIIII();
            llIIlllI.this.IIIIIIII(this.IIIIIIII, this.IIIIIIIl, false, exc, i);
        }

        public void IIIIIIII(lIIIlllI liiillli, lIIlIIII liiliiii) {
            int i = liiliiii.IIIIIIII;
            llIIlllI.this.IIIIIIII();
            if (llIIlllI.this.IIIIIIII(liiliiii.IIIIIIII)) {
                llIIlllI.this.IIIIIIII(this.IIIIIIII, this.IIIIIIIl, true, (Exception) null, 0);
            } else {
                llIIlllI.this.IIIIIIII(this.IIIIIIII, this.IIIIIIIl, false, new lIIIllIl(String.valueOf(liiliiii.IIIIIIII)), 0);
            }
        }
    }

    public void IIIIIIII(lIllllII lillllii, IIIIIIll iIIIIIll) {
        lillllii.IIIIIIII.getName();
        try {
            if (this.IIIIIIIl.IIIIIlII != null) {
                if (!this.IIIIIIIl.IIIIIlII.isEmpty()) {
                    if (!llllIlIl.IIIIIIlI(this.IIIIIIII)) {
                        IIIIIIII(iIIIIIll, lillllii, new lIIIllIl(), 0);
                        return;
                    }
                    IIIIIIIl();
                    lIIIlIII.IIIIIIII(this.IIIIIIIl.IIIIIIII, false, new lIIIlllI(this.IIIIIIIl.IIIIIlII, lIIIlllI.IIIIIlIl, IIIIIIII(this.IIIIIIII, this.IIIIIIIl), new FileInputStream(lillllii.IIIIIIII)), (lIIIlIII.IIIIIIII) new IIIIIIII(iIIIIIll, lillllii));
                    return;
                }
            }
            IIIIIIII(iIIIIIll, lillllii, new lIIIllIl(), 0);
        } catch (FileNotFoundException e) {
            lIIlIlll liililll = this.IIIIIIlI;
            if (liililll != null) {
                liililll.IIIIIIII();
            }
            e.getMessage();
            IIIIIIII(iIIIIIll, lillllii, e, 0);
        }
    }

    public void IIIIIIII(byte[] bArr, IIIIIIlI iIIIIIlI) {
        int length = bArr.length;
        String str = this.IIIIIIIl.IIIIIlII;
        if (str == null || str.isEmpty()) {
            lIIIllIl liiillil = new lIIIllIl();
            if (iIIIIIlI != null) {
                iIIIIIlI.IIIIIIII(bArr, false, liiillil, 0);
            }
        } else if (!llllIlIl.IIIIIIlI(this.IIIIIIII)) {
            lIIIllIl liiillil2 = new lIIIllIl();
            if (iIIIIIlI != null) {
                iIIIIIlI.IIIIIIII(bArr, false, liiillil2, 0);
            }
        } else {
            IIIIIIIl();
            lIlllIIl lillliil = this.IIIIIIIl;
            lIIIlIII.IIIIIIII(this.IIIIIIIl.IIIIIIII, false, new lIIIlllI(lillliil.IIIIIlII, lIIIlllI.IIIIIlIl, IIIIIIII(this.IIIIIIII, lillliil), new ByteArrayInputStream(bArr)), (lIIIlIII.IIIIIIII) new IIIIIIIl(iIIIIIlI, bArr));
        }
    }
}
