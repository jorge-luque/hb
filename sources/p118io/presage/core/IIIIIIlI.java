package p118io.presage.core;

import android.content.Context;
import java.io.File;

/* renamed from: io.presage.core.IIIIIIlI */
public class IIIIIIlI extends IIlllIlI<IIIIIIIl, Void> {
    public IIIIIIII IIIIIIIl;

    /* renamed from: io.presage.core.IIIIIIlI$IIIIIIII */
    public interface IIIIIIII {
    }

    /* renamed from: io.presage.core.IIIIIIlI$IIIIIIIl */
    public static class IIIIIIIl {
        public File IIIIIIII;
        public File IIIIIIIl;

        public IIIIIIIl(File file, File file2) {
            this.IIIIIIII = file;
            this.IIIIIIIl = file2;
        }

        public File IIIIIIII() {
            return this.IIIIIIIl;
        }
    }

    public IIIIIIlI(Context context, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = iiiiiiii;
    }

    public Object IIIIIIII(Object[] objArr) {
        IIIIIIIl[] iIIIIIIlArr = (IIIIIIIl[]) objArr;
        if (iIIIIIIlArr == null) {
            return null;
        }
        for (IIIIIIIl iIIIIIIl : iIIIIIIlArr) {
            if (iIIIIIIl.IIIIIIII == null || iIIIIIIl.IIIIIIII() == null) {
                return null;
            }
            try {
                C6313i1.IIIIIIII(iIIIIIIl.IIIIIIII, iIIIIIIl.IIIIIIII());
            } catch (Exception unused) {
            }
            C6313i1.IIIIIIII(iIIIIIIl.IIIIIIII);
        }
        return null;
    }

    public void IIIIIIII(Object obj) {
        Void voidR = (Void) obj;
        IIIIIIII iiiiiiii = this.IIIIIIIl;
        if (iiiiiiii != null) {
            IIIIllll.this.IIIIIlII();
        }
    }
}
