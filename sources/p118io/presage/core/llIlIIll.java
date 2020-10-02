package p118io.presage.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* renamed from: io.presage.core.llIlIIll */
public class llIlIIll extends IIlllIlI<Void, Void> {
    public File IIIIIIIl;
    public boolean IIIIIIlI;
    public FileOutputStream IIIIIIll;
    public IIIIIIII IIIIIlII;

    /* renamed from: io.presage.core.llIlIIll$IIIIIIII */
    public interface IIIIIIII {
        void IIIIIIII(FileOutputStream fileOutputStream);
    }

    public llIlIIll(File file, boolean z, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = file;
        this.IIIIIIlI = z;
        this.IIIIIlII = iiiiiiii;
    }

    public Object IIIIIIII(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        try {
            this.IIIIIIIl.getName();
            this.IIIIIIll = new FileOutputStream(this.IIIIIIIl, this.IIIIIIlI);
            return null;
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public void IIIIIIII(Object obj) {
        Void voidR = (Void) obj;
        IIIIIIII iiiiiiii = this.IIIIIlII;
        if (iiiiiiii != null) {
            iiiiiiii.IIIIIIII(this.IIIIIIll);
        }
    }
}
