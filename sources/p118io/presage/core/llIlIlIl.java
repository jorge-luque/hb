package p118io.presage.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: io.presage.core.llIlIlIl */
public class llIlIlIl extends IIlllIlI<byte[], Void> {
    public File IIIIIIIl;
    public OutputStream IIIIIIlI;
    public boolean IIIIIIll;
    public IIIIIIII IIIIIlII;
    public boolean IIIIIlIl;
    public long IIIIIllI;
    public Exception IIIIIlll;

    /* renamed from: io.presage.core.llIlIlIl$IIIIIIII */
    public interface IIIIIIII {
        void IIIIIIII(boolean z, long j, Exception exc);
    }

    public llIlIlIl(File file, IIIIIIII iiiiiiii) {
        this.IIIIIIll = true;
        this.IIIIIlII = iiiiiiii;
        this.IIIIIIIl = file;
    }

    public Object IIIIIIII(Object[] objArr) {
        byte[][] bArr = (byte[][]) objArr;
        OutputStream outputStream = this.IIIIIIlI;
        if (bArr == null || bArr[0] == null) {
            this.IIIIIlIl = true;
            this.IIIIIllI = 0;
            return null;
        }
        File file = this.IIIIIIIl;
        if (file != null) {
            try {
                this.IIIIIIlI = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e = e;
            }
        }
        OutputStream outputStream2 = this.IIIIIIlI;
        if (outputStream2 == null) {
            this.IIIIIlIl = false;
            this.IIIIIllI = 0;
            e = new NullPointerException();
            this.IIIIIlll = e;
            return null;
        }
        try {
            IIIIlIll.IIIIIIII(bArr[0], outputStream2, this.IIIIIIll);
            this.IIIIIllI = (long) bArr[0].length;
            this.IIIIIlIl = true;
            return null;
        } catch (IOException e2) {
            e = e2;
        }
        this.IIIIIlIl = false;
        this.IIIIIllI = 0;
        this.IIIIIlll = e;
        return null;
    }

    public void IIIIIIII(Object obj) {
        Void voidR = (Void) obj;
        boolean z = this.IIIIIlIl;
        Exception exc = this.IIIIIlll;
        IIIIIIII iiiiiiii = this.IIIIIlII;
        if (iiiiiiii != null) {
            iiiiiiii.IIIIIIII(z, this.IIIIIllI, exc);
        }
    }

    public llIlIlIl(OutputStream outputStream, boolean z, IIIIIIII iiiiiiii) {
        this.IIIIIIll = z;
        this.IIIIIlII = iiiiiiii;
        this.IIIIIIlI = outputStream;
    }
}
