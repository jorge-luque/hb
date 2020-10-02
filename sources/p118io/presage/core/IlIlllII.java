package p118io.presage.core;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* renamed from: io.presage.core.IlIlllII */
public class IlIlllII extends IIllllll {
    public static final String IIIIlllI = C6364v0.IIIIIIIl;
    public static final String IIIIllll = C6364v0.IIIIIIII;
    public static final String IIIlIIII = C6364v0.IIIIIIlI;
    public static final String IIIlIIIl = C6364v0.IIIIIIll;
    public static final String IIIlIIlI = C6364v0.IIIIIlII;

    public IlIlllII(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 22;
    }

    public Object IIIIIIll() {
        return IlIlllII.class;
    }

    public void IIIIIlIl() {
        if (this.IIIIIIlI.getPackageManager().checkPermission(IIIIllll, this.IIIIIIlI.getPackageName()) == 0) {
            try {
                Object invoke = this.IIIIIIlI.getClass().getMethod(IIIlIIII, new Class[]{String.class}).invoke(this.IIIIIIlI, new Object[]{IIIIlllI});
                if (invoke == null) {
                    IIIIIIII(0);
                    return;
                }
                String str = (String) invoke.getClass().getMethod(IIIlIIIl, new Class[0]).invoke(invoke, new Object[0]);
                if (str != null && !str.isEmpty()) {
                    IIIIIIII((IIIlIIlI) new IIllIIIl(C6325l1.IIIIIIII(), new C6377y1().IIIIIIII(1).IIIIIIII(IIIlIIlI.getBytes(), 0).IIIIIIII(str)));
                }
            } catch (IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            } catch (Exception e) {
                IIIIIIII(e, 1);
            }
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
    }
}
