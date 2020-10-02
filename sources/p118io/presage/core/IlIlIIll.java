package p118io.presage.core;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;

/* renamed from: io.presage.core.IlIlIIll */
public class IlIlIIll extends IIllllll {
    public static final String IIIIlllI = C6335o.IIIIIIII;
    public static final String IIIIllll = C6335o.IIIIIIIl;
    public static final String IIIlIIII = C6335o.IIIIIIlI;
    public static final String IIIlIIIl = C6335o.IIIIIIll;

    public IlIlIIll(Context context, int i, long j, long j2) {
        super(context, i, j, j2);
    }

    public int IIIIIIII() {
        return 23;
    }

    public Object IIIIIIll() {
        return IlIlIIll.class;
    }

    public void IIIIIlIl() {
        try {
            Object invoke = Class.forName(IIIIlllI).getDeclaredMethod(IIIIllll, new Class[0]).invoke((Object) null, new Object[0]);
            if (invoke != null) {
                IIIIIIII((IIIlIIlI) new IIlIIIll(C6325l1.IIIIIIII(), new C6377y1().IIIIIIII(1).IIIIIIII(IIIlIIIl.getBytes(), 0).IIIIIIII((String) invoke.getClass().getDeclaredMethod(IIIlIIII, new Class[0]).invoke(invoke, new Object[0]))));
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        } catch (Exception e) {
            IIIIIIII(e, 1);
        }
        IIIIIIII(0);
    }

    public void IIIIIllI() {
    }
}
