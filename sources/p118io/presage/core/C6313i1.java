package p118io.presage.core;

import android.os.StatFs;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import p118io.presage.core.IIIIIlll;
import p118io.presage.core.llIlIlII;

/* renamed from: io.presage.core.i1 */
public class C6313i1 {

    /* renamed from: io.presage.core.i1$IIIIIIII */
    public interface IIIIIIII {
    }

    /* renamed from: io.presage.core.i1$IIIIIIlI */
    public static class IIIIIIlI extends IIlllIlI<Void, Void> {
        public File IIIIIIIl;
        public long IIIIIIlI = 0;
        public IIIIIIll IIIIIIll;

        public IIIIIIlI(File file, IIIIIIll iIIIIIll) {
            this.IIIIIIIl = file;
            this.IIIIIIll = iIIIIIll;
        }

        public Object IIIIIIII(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            this.IIIIIIlI = C6313i1.IIIIIIIl(this.IIIIIIIl);
            return null;
        }

        public void IIIIIIII(Object obj) {
            Void voidR = (Void) obj;
            long j = this.IIIIIIlI;
            IIIIIIll iIIIIIll = this.IIIIIIll;
            if (iIIIIIll != null) {
                llIlIlII.IIIIIIII iiiiiiii = (llIlIlII.IIIIIIII) iIIIIIll;
                if (!llIlIlII.this.IIIIIIII(j)) {
                    llIlIlII.this.IIIIIIIl(iiiiiiii.IIIIIIII);
                } else {
                    llIlIlII.this.IIIIIIII(iiiiiiii.IIIIIIII, false, new lIlllIII(), 0);
                }
            }
        }
    }

    /* renamed from: io.presage.core.i1$IIIIIIll */
    public interface IIIIIIll {
    }

    public static void IIIIIIII(IIllllII iIllllII, boolean z, File file, IIIIIIII iiiiiiii) {
        new IIIIIIIl(file, false, iiiiiiii).IIIIIIII(iIllllII, z, new Void[0]);
    }

    public static void IIIIIIII(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File IIIIIIII2 : listFiles) {
                    IIIIIIII(IIIIIIII2);
                }
            }
            file.delete();
        }
    }

    public static void IIIIIIII(File file, File file2) {
        if (file != null && file.exists() && file2 != null) {
            if (!file.isDirectory()) {
                IIIIlIll.IIIIIIII(new FileInputStream(file), new FileOutputStream(file2), true, true);
            } else if (file2.exists() || file2.mkdirs()) {
                for (String str : file.list()) {
                    IIIIIIII(new File(file, str), new File(file2, str));
                }
            }
        }
    }

    public static long IIIIIIIl(File file) {
        if (file == null || !file.exists()) {
            return -1;
        }
        StatFs statFs = new StatFs(file.getAbsolutePath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static void IIIIIIlI(File file) {
        if (file == null) {
            throw new FileNotFoundException();
        } else if (!file.exists() && !file.mkdirs()) {
            throw new FileNotFoundException();
        }
    }

    /* renamed from: io.presage.core.i1$IIIIIIIl */
    public static class IIIIIIIl extends IIlllIlI<Void, Void> {
        public File IIIIIIIl;
        public IIIIIIII IIIIIIlI;
        public boolean IIIIIIll;

        public IIIIIIIl(File file, boolean z, IIIIIIII iiiiiiii) {
            this.IIIIIIIl = file;
            this.IIIIIIlI = iiiiiiii;
            this.IIIIIIll = z;
        }

        public Object IIIIIIII(Object[] objArr) {
            File[] listFiles;
            Void[] voidArr = (Void[]) objArr;
            if (this.IIIIIIll) {
                File file = this.IIIIIIIl;
                if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return null;
                }
                for (File IIIIIIII : listFiles) {
                    C6313i1.IIIIIIII(IIIIIIII);
                }
                return null;
            }
            C6313i1.IIIIIIII(this.IIIIIIIl);
            return null;
        }

        public void IIIIIIII(Object obj) {
            IIIIIlll.IIIIIlII iIIIIlII;
            Void voidR = (Void) obj;
            IIIIIIII iiiiiiii = this.IIIIIIlI;
            if (iiiiiiii != null && (iIIIIlII = ((IIIIIlll.IIIIIIII) iiiiiiii).IIIIIIII) != null) {
                ((IIIlIIII) iIIIIlII).IIIIIIII();
            }
        }
    }
}
