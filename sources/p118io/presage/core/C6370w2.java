package p118io.presage.core;

import android.graphics.Bitmap;
import p118io.presage.core.llIllllI;

/* renamed from: io.presage.core.w2 */
public class C6370w2 implements llIllllI.IIIIIIIl {
    public final /* synthetic */ llIllllI.IIIIIIIl IIIIIIII;
    public final /* synthetic */ C6378y2 IIIIIIIl;

    public C6370w2(C6378y2 y2Var, llIllllI.IIIIIIIl iIIIIIIl) {
        this.IIIIIIIl = y2Var;
        this.IIIIIIII = iIIIIIIl;
    }

    public void IIIIIIII(Bitmap bitmap) {
        this.IIIIIIIl.IIIIIIlI = bitmap;
        llIllllI.IIIIIIIl iIIIIIIl = this.IIIIIIII;
        if (iIIIIIIl != null) {
            iIIIIIIl.IIIIIIII(bitmap);
        }
    }

    public void IIIIIIII(Exception exc) {
        llIllllI.IIIIIIIl iIIIIIIl = this.IIIIIIII;
        if (iIIIIIIl != null) {
            iIIIIIIl.IIIIIIII(exc);
        }
    }
}
