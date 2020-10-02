package p118io.presage.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: io.presage.core.llIIIIII */
public class llIIIIII extends IIlllIlI<Void, Void> {
    public File IIIIIIIl;
    public InputStream IIIIIIlI;
    public boolean IIIIIIll = true;
    public IIIIIIII IIIIIlII;
    public boolean IIIIIlIl;
    public byte[] IIIIIllI;
    public Exception IIIIIlll;

    /* renamed from: io.presage.core.llIIIIII$IIIIIIII */
    public interface IIIIIIII {
    }

    public llIIIIII(File file, IIIIIIII iiiiiiii) {
        this.IIIIIlII = iiiiiiii;
        this.IIIIIIIl = file;
    }

    public Object IIIIIIII(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        try {
            if (this.IIIIIIIl != null) {
                this.IIIIIIlI = new FileInputStream(this.IIIIIIIl);
            }
            this.IIIIIllI = IIIIlIll.IIIIIIII(this.IIIIIIlI, this.IIIIIIll);
            this.IIIIIlIl = true;
        } catch (IOException e) {
            this.IIIIIlIl = false;
            this.IIIIIllI = null;
            this.IIIIIlll = e;
        }
        return null;
    }

    public void IIIIIIII(Object obj) {
        Void voidR = (Void) obj;
        boolean z = this.IIIIIlIl;
        byte[] bArr = this.IIIIIllI;
        IIIIIIII iiiiiiii = this.IIIIIlII;
        if (iiiiiiii != null) {
            IIIIlIII iIIIlIII = (IIIIlIII) iiiiiiii;
            if (!z || bArr == null) {
                IIIIIlll iIIIIlll = iIIIlIII.IIIIIIII;
                IIIIIlll.IIIIIIII(iIIIIlll, iIIIIlll.IIIIIlll);
                return;
            }
            iIIIlIII.IIIIIIII.IIIIIIII(bArr);
        }
    }
}
