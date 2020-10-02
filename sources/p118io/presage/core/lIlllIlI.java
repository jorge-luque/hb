package p118io.presage.core;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.util.Set;

/* renamed from: io.presage.core.lIlllIlI */
public class lIlllIlI extends IIlllIlI<Void, Void> {
    public Context IIIIIIIl;
    public Set<lIlllIll> IIIIIIlI;
    public IIIIIIII IIIIIIll;

    /* renamed from: io.presage.core.lIlllIlI$IIIIIIII */
    public interface IIIIIIII {
        void IIIIIIII(Set<lIlllIll> set);
    }

    public lIlllIlI(Context context, Set<lIlllIll> set, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = context;
        this.IIIIIIlI = set;
        this.IIIIIIll = iiiiiiii;
    }

    public Object IIIIIIII(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        for (lIlllIll next : this.IIIIIIlI) {
            if (next.IIIIIIII() == 0) {
                new File(next.IIIIIIII).getName();
                C6313i1.IIIIIIII(new File(next.IIIIIIII));
            } else if (next.IIIIIIII() == 1) {
                String str = next.IIIIIIII;
                if (Build.VERSION.SDK_INT >= 24) {
                    this.IIIIIIIl.deleteSharedPreferences(str);
                } else {
                    this.IIIIIIIl.getSharedPreferences(str, 0).edit().clear().apply();
                }
            }
        }
        return null;
    }

    public void IIIIIIII(Object obj) {
        Void voidR = (Void) obj;
        Set<lIlllIll> set = this.IIIIIIlI;
        IIIIIIII iiiiiiii = this.IIIIIIll;
        if (iiiiiiii != null) {
            iiiiiiii.IIIIIIII(set);
        }
    }
}
