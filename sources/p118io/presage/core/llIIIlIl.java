package p118io.presage.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: io.presage.core.llIIIlIl */
public class llIIIlIl extends IIlllIlI<Void, Void> {
    public File IIIIIIIl;
    public long IIIIIIlI;
    public String IIIIIIll;
    public lIllllII IIIIIlII;
    public LinkedHashSet<lIllllII> IIIIIlIl = new LinkedHashSet<>();
    public IIIIIIII IIIIIllI;

    /* renamed from: io.presage.core.llIIIlIl$IIIIIIII */
    public interface IIIIIIII {
    }

    public llIIIlIl(File file, long j, String str, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = file;
        this.IIIIIIlI = j;
        this.IIIIIIll = str;
        this.IIIIIllI = iiiiiiii;
    }

    public Object IIIIIIII(Object[] objArr) {
        List list;
        Void[] voidArr = (Void[]) objArr;
        if (!(this.IIIIIIIl.exists() ? true : this.IIIIIIIl.mkdirs())) {
            return null;
        }
        File[] listFiles = this.IIIIIIIl.listFiles(new llIIIlII(this, Pattern.compile(this.IIIIIIll)));
        if (listFiles == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(listFiles.length);
            for (File lillllii : listFiles) {
                arrayList.add(new lIllllII(lillllii));
            }
            Collections.sort(arrayList);
            list = arrayList;
        }
        list.size();
        if (list.isEmpty()) {
            return null;
        }
        int size = list.size();
        if (!(System.currentTimeMillis() - this.IIIIIIlI > 86400000)) {
            size = list.size() - 1;
            lIllllII lillllii2 = (lIllllII) list.get(size);
            this.IIIIIlII = lillllii2;
            String str = lillllii2.IIIIIIIl;
            long j = lillllii2.IIIIIIlI;
            long j2 = this.IIIIIlII.IIIIIIll;
        }
        for (int i = 0; i < size; i++) {
            lIllllII lillllii3 = (lIllllII) list.get(i);
            String str2 = lillllii3.IIIIIIIl;
            long j3 = lillllii3.IIIIIIlI;
            long j4 = lillllii3.IIIIIIll;
            this.IIIIIlIl.add(lillllii3);
        }
        return null;
    }

    public void IIIIIIII(Object obj) {
        Void voidR = (Void) obj;
        lIllllII lillllii = this.IIIIIlII;
        LinkedHashSet<lIllllII> linkedHashSet = this.IIIIIlIl;
        IIIIIIII iiiiiiii = this.IIIIIllI;
        if (iiiiiiii != null) {
            llIIIllI.this.IIIIIIII(lillllii, linkedHashSet);
        }
    }
}
