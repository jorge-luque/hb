package p118io.presage.core;

import java.io.FileOutputStream;
import java.io.IOException;
import p118io.presage.core.llIlIIll;

/* renamed from: io.presage.core.llIIllll */
public class llIIllll extends llIlIlII {
    public FileOutputStream IIIIIlll;

    /* renamed from: io.presage.core.llIIllll$IIIIIIII */
    public class IIIIIIII implements llIlIIll.IIIIIIII {
        public final /* synthetic */ llIlIIll.IIIIIIII IIIIIIII;

        public IIIIIIII(llIlIIll.IIIIIIII iiiiiiii) {
            this.IIIIIIII = iiiiiiii;
        }

        public void IIIIIIII(FileOutputStream fileOutputStream) {
            llIIllll lliillll = llIIllll.this;
            lliillll.IIIIIlll = fileOutputStream;
            lliillll.IIIIIIII(this.IIIIIIII);
        }
    }

    public llIIllll(lIllllll lillllll) {
        super(lillllll);
    }

    public void IIIIIIII() {
        FileOutputStream fileOutputStream = this.IIIIIlll;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
            this.IIIIIlll = null;
        }
    }

    public void IIIIIIII(IIllllII iIllllII, boolean z, llIlIIll.IIIIIIII iiiiiiii) {
        lIllllII lillllii = new lIllllII(IIIIIIlI(), 0, System.currentTimeMillis());
        this.IIIIIIIl = lillllii;
        new llIlIIll(lillllii.IIIIIIII, false, new IIIIIIII(iiiiiiii)).IIIIIIII(iIllllII, z, new Void[0]);
    }

    public final void IIIIIIII(llIlIIll.IIIIIIII iiiiiiii) {
        if (iiiiiiii != null) {
            iiiiiiii.IIIIIIII(this.IIIIIlll);
        }
    }

    public void IIIIIIII(boolean z, long j, Exception exc) {
        IIIIIIII();
        if (z) {
            IIIIIIII(this.IIIIIIIl);
        }
    }

    public long IIIIIIIl() {
        return 0;
    }
}
