package p118io.presage.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;
import p118io.presage.core.IIllllIl;
import p118io.presage.core.llIIIllI;

/* renamed from: io.presage.core.lIIIIlIl */
public class lIIIIlIl {
    public static final String IIIIlIII = lllIlIll.IIIIIIII;
    public static final String IIIIlIIl = lllIlIll.IIIIIIIl;
    public static lIIIIlIl IIIIlIlI;
    public static Handler IIIIlIll;
    public Context IIIIIIII;
    public IIllllII IIIIIIIl;
    public IIIIIlll IIIIIIlI;
    public llIIlllI IIIIIIll;
    public llIIIllI IIIIIlII;
    public int IIIIIlIl;
    public int IIIIIllI;
    public llIIIllI.IIIIIlIl IIIIIlll;

    /* renamed from: io.presage.core.lIIIIlIl$IIIIIIII */
    public class IIIIIIII implements llIIIllI.IIIIIlIl {
        public IIIIIIII() {
        }

        public void IIIIIIII() {
            lIIIIlIl liiiilil = lIIIIlIl.this;
            liiiilil.IIIIIllI = 0;
            llIIIllI.IIIIIlIl iIIIIlIl = liiiilil.IIIIIlll;
            if (iIIIIlIl != null) {
                iIIIIlIl.IIIIIIII();
            }
        }
    }

    public /* synthetic */ lIIIIlIl(Context context, IIllllII iIllllII, IIIIIlll iIIIIlll, lIIIIIII liiiiiii) {
        this.IIIIIIII = context;
        try {
            this.IIIIIIIl = iIllllII;
            this.IIIIIIlI = iIIIIlll;
            lIllllll lillllll = new lIllllll(IIllllIl.IIIIIIlI().IIIIIIII(), iIIIIlll.IIIIIIlI(), IIIIlIII, IIIIlIIl, 10, 0, false, true, true);
            this.IIIIIIll = new llIIllII(context, IIIIIIIl());
            this.IIIIIlII = new llIIIIIl(this.IIIIIIII, lillllll, this.IIIIIIll);
        } catch (Exception e) {
            throw new Illlllll(e);
        }
    }

    public static Handler IIIIIIll() {
        if (IIIIlIll == null) {
            IIIIlIll = new Handler(Looper.getMainLooper());
        }
        return IIIIlIll;
    }

    public static boolean IIIIIlII() {
        lIIIIlIl liiiilil = IIIIlIlI;
        if (liiiilil == null) {
            return false;
        }
        return liiiilil.IIIIIllI == 1;
    }

    public final void IIIIIIII() {
        if (!(this.IIIIIlIl > 0) || this.IIIIIllI == 2) {
            this.IIIIIlII.IIIIIIII(false, (llIIIllI.IIIIIlIl) new IIIIIIII());
        } else {
            this.IIIIIllI = 2;
        }
    }

    public final lIlllIIl IIIIIIIl() {
        IIllllIl IIIIIIlI2 = IIllllIl.IIIIIIlI();
        IIllllII iIllllII = IIIIIIlI2.IIIIIIIl;
        if (iIllllII == null || iIllllII.IIIIIIII.isTerminated()) {
            IIIIIIlI2.IIIIIIIl = new IIllllII(Executors.newFixedThreadPool(2, new IIllllIl.IIIIIIII(new ThreadGroup(IIllllIl.IIIIIIll), IIllllIl.IIIIIlIl)));
        }
        return new lIlllIIl(IIIIIIlI2.IIIIIIIl, this.IIIIIIlI.IIIIIIIl(), this.IIIIIIlI.IIIIIIII(), this.IIIIIIlI.IIIIllIl(), this.IIIIIIlI.IIIIIlll.IIIIIIll);
    }

    public void IIIIIIlI() {
        try {
            if (this.IIIIIllI == 0) {
                this.IIIIIllI = 1;
                this.IIIIIlIl = 0;
                this.IIIIIlII.IIIIIIIl();
            }
        } catch (Exception e) {
            this.IIIIIllI = 0;
            throw new Illlllll(e);
        }
    }

    public static void IIIIIIII(Exception exc, int i) {
        if (i == 1) {
            IIIIIIll().post(new lIIIIIlI(exc));
        }
    }
}
