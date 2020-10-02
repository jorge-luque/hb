package p118io.presage.core;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: io.presage.core.lIlIlIII */
public class lIlIlIII {
    public static final String IIIIIIlI = C6280a0.IIIIIIII;
    public static final String IIIIIIll = C6280a0.IIIIIIIl;
    public Context IIIIIIII;
    public Set<Integer> IIIIIIIl;

    public lIlIlIII(Context context, Set<Integer> set) {
        this.IIIIIIII = context;
        this.IIIIIIIl = set;
    }

    public lIlIIlll IIIIIIII(lIIIlllI liiillli, OutputStream outputStream, File file) {
        Thread.currentThread().getName();
        if (liiillli != null) {
            String str = liiillli.IIIIIIII;
            liiillli.IIIIIIII();
            String str2 = liiillli.IIIIIIIl;
            if (this.IIIIIIIl.contains(1) && liiillli.IIIIIIIl.equals(lIIIlllI.IIIIIlIl)) {
                return new lIllIlIl(this.IIIIIIII, liiillli, outputStream, file);
            }
            if (this.IIIIIIIl.contains(2) && liiillli.IIIIIIIl.equals(lIIIlllI.IIIIIllI) && liiillli.IIIIIIII().equals(IIIIIIlI)) {
                return new lIlIllII(this.IIIIIIII, liiillli, outputStream, file);
            }
            if (this.IIIIIIIl.contains(3) && liiillli.IIIIIIIl.equals(lIIIlllI.IIIIIllI) && liiillli.IIIIIIII().equals(IIIIIIll)) {
                return new lIlIllIl(this.IIIIIIII, liiillli, outputStream, file);
            }
            if (liiillli.IIIIIIIl.equals(lIIIlllI.IIIIIlII)) {
                return new lIlIlIll(this.IIIIIIII, liiillli, outputStream, file);
            }
        }
        return new lIlIlIlI(this.IIIIIIII, liiillli, outputStream, file);
    }

    public ArrayList<lIlIlIIl> IIIIIIII(File file) {
        Thread.currentThread().getName();
        ArrayList<lIlIlIIl> arrayList = new ArrayList<>();
        File file2 = new File(file, String.valueOf(1));
        Thread.currentThread().getName();
        ArrayList arrayList2 = new ArrayList();
        if (file2.exists()) {
            for (File file3 : file2.listFiles()) {
                file3.getAbsolutePath();
                try {
                    lIlIlllI IIIIIIII2 = lIllIIII.IIIIIIII(new FileInputStream(file3), true);
                    if (IIIIIIII2 != null) {
                        arrayList2.add(new lIllIllI(this.IIIIIIII, file3, IIIIIIII2));
                    } else {
                        C6313i1.IIIIIIII(file3);
                    }
                } catch (Exception unused) {
                    C6313i1.IIIIIIII(file3);
                }
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }
}
