package p118io.presage.core;

import android.content.Context;
import java.io.ByteArrayInputStream;
import p118io.presage.core.lIIIlIII;

/* renamed from: io.presage.core.lIlIIlII */
public class lIlIIlII extends lIIlllll {
    public IIIIIlll IIIIIIll;
    public int IIIIIlII;

    public lIlIIlII(Context context, IIIIIlll iIIIIlll) {
        super(context);
        this.IIIIIIll = iIIIIlll;
    }

    public void IIIIIIII(IIllllII iIllllII, lIIlllII liilllii) {
        if (!this.IIIIIIlI) {
            this.IIIIIlII = 0;
        }
        if (!this.IIIIIIlI) {
            this.IIIIIIlI = true;
            this.IIIIIIII = liilllii;
            this.IIIIIlII++;
            this.IIIIIIll.IIIIllII();
            try {
                lIIIlIII.IIIIIIII(iIllllII, false, new lIIIlllI(this.IIIIIIll.IIIIllII(), lIIIlllI.IIIIIlIl, new lIlIIIlI(this.IIIIIIIl, this.IIIIIIll.IIIIIIIl(), this.IIIIIIll.IIIIIIII(), this.IIIIIIll.IIIIllIl()), new ByteArrayInputStream(lIlIIIII.IIIIIIII(this.IIIIIIIl, this.IIIIIIll).getBytes())), (lIIIlIII.IIIIIIII) new lIlIIIll(this));
            } catch (lIIlllIl e) {
                this.IIIIIIlI = false;
                lIIlllII liilllii2 = this.IIIIIIII;
                if (liilllii2 != null) {
                    ((IIIlIIIl) liilllii2).IIIIIIII(this, e, 1);
                }
            }
        }
    }
}
