package p118io.presage.core;

import android.content.Context;

/* renamed from: io.presage.core.h2 */
public class C6310h2 extends C6350r2 {
    public C6302f2 IIIIIIll;

    public C6310h2(Context context, boolean z, Object[] objArr) {
        super(context, z, objArr);
        Object[] objArr2 = this.IIIIIIlI;
        long j = 0;
        if (objArr2 != null && objArr2.length >= 1 && objArr2[0] != null && (objArr2[0] instanceof Number) && ((Long) objArr2[0]).longValue() >= 0 && ((Long) this.IIIIIIlI[0]).longValue() <= Long.MAX_VALUE) {
            j = ((Long) this.IIIIIIlI[0]).longValue();
        }
        int i = 10;
        Object[] objArr3 = this.IIIIIIlI;
        if (objArr3 != null && objArr3.length >= 2 && objArr3[1] != null && (objArr3[1] instanceof Number) && ((Integer) objArr3[1]).intValue() >= 0 && ((Integer) this.IIIIIIlI[1]).intValue() <= 50) {
            i = ((Integer) this.IIIIIIlI[1]).intValue();
        }
        if (C6302f2.IIIIlIlI == null) {
            C6302f2.IIIIlIlI = new C6302f2(context);
        }
        C6302f2 f2Var = C6302f2.IIIIlIlI;
        this.IIIIIIll = f2Var;
        f2Var.IIIIIIII(j * 1000, false);
        this.IIIIIIll.IIIIIIII(i, true);
    }

    public int IIIIIIII() {
        return 6;
    }

    public void IIIIIIIl() {
        this.IIIIIIll.IIIIIIII(false);
    }

    public void IIIIIIlI() {
        this.IIIIIIll.IIIIIIII(true);
    }
}
