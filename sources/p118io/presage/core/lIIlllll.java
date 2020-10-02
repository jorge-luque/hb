package p118io.presage.core;

import android.content.Context;
import android.os.Build;

/* renamed from: io.presage.core.lIIlllll */
public abstract class lIIlllll {
    public lIIlllII IIIIIIII;
    public Context IIIIIIIl;
    public boolean IIIIIIlI = false;

    public lIIlllll(Context context) {
        this.IIIIIIIl = context;
    }

    public void IIIIIIII(lIIlllll liilllll, lIIllIll liillill) {
        int i = 0;
        this.IIIIIIlI = false;
        lIIlllII liilllii = this.IIIIIIII;
        if (liilllii != null) {
            IIIlIIIl iIIlIIIl = (IIIlIIIl) liilllii;
            IIIIIlll iIIIIlll = iIIlIIIl.IIIIIIII.IIIIIlll;
            int i2 = iIIIIlll.IIIIlllI().getInt(IIIIIlll.IIIlIIll, 0);
            int floor = (int) Math.floor((double) (((float) System.currentTimeMillis()) / 8.64E7f));
            if (i2 == floor) {
                i = iIIIIlll.IIIIlllI().getInt(IIIIIlll.IIIlIlII, 0);
            } else {
                iIIIIlll.IIIIlIII().putInt(IIIIIlll.IIIlIIll, floor);
            }
            iIIIIlll.IIIIlIII().putInt(IIIIIlll.IIIlIlII, i + 1);
            iIIIIlll.IIIIlIII().apply();
            iIIlIIIl.IIIIIIII.IIIIIlll.IIIIIIIl(liillill);
            Context context = iIIlIIIl.IIIIIIII.IIIIIIIl;
            IIIIllII iIIIllII = liillill.IIIlIlll;
            if (Build.VERSION.SDK_INT >= 26) {
                IIIIllIl IIIIIIII2 = IIIIllIl.IIIIIIII(context);
                if (IIIIIIII2.IIIIIIII(iIIIllII)) {
                    IIIIlIll.IIIIIIII(context, IIIIIIII2.IIIIIIII(), true);
                }
            }
            lIIIIlIl.IIIIIIll().post(new lIIIIIIl());
            iIIlIIIl.IIIIIIII.IIIIIllI();
        }
    }

    public void IIIIIIII(lIIlllll liilllll, Exception exc, int i) {
        this.IIIIIIlI = false;
        lIIlllII liilllii = this.IIIIIIII;
        if (liilllii != null) {
            ((IIIlIIIl) liilllii).IIIIIIII(liilllll, exc, i);
        }
    }
}
