package p118io.presage.core;

import android.content.Context;
import p118io.presage.core.IIIIIIll;

/* renamed from: io.presage.core.c2 */
public class C6290c2 extends IIlllIlI<Void, Boolean> {
    public Context IIIIIIIl;
    public IIIIIIII IIIIIIlI;

    /* renamed from: io.presage.core.c2$IIIIIIII */
    public interface IIIIIIII {
    }

    public C6290c2(Context context, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = context;
        this.IIIIIIlI = iiiiiiii;
    }

    public Object IIIIIIII(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        return Boolean.valueOf(C6286b2.IIIIIIII(this.IIIIIIIl).IIIIIIlI());
    }

    public void IIIIIIII(Object obj) {
        Boolean bool = (Boolean) obj;
        IIIIIIII iiiiiiii = this.IIIIIIlI;
        if (iiiiiiii != null) {
            IIIIIIll.IIIIIIII iiiiiiii2 = (IIIIIIll.IIIIIIII) iiiiiiii;
            if (!bool.booleanValue()) {
                IIIIIIll.this.IIIIIIIl(iiiiiiii2.IIIIIIII, iiiiiiii2.IIIIIIIl, iiiiiiii2.IIIIIIlI, iiiiiiii2.IIIIIIll);
            } else {
                IIIIIIll.this.IIIIIIII(iiiiiiii2.IIIIIIIl);
            }
        }
    }
}
