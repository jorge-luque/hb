package p118io.presage.core;

/* renamed from: io.presage.core.llIIIIll */
public class llIIIIll extends IIlllIlI<Void, Void> {
    public lIllllII IIIIIIIl;
    public IIIIIIII IIIIIIlI;

    /* renamed from: io.presage.core.llIIIIll$IIIIIIII */
    public interface IIIIIIII {
    }

    public llIIIIll(lIllllII lillllii, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = lillllii;
        this.IIIIIIlI = iiiiiiii;
    }

    public Object IIIIIIII(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        C6313i1.IIIIIIII(this.IIIIIIIl.IIIIIIII);
        return null;
    }

    public void IIIIIIII(Object obj) {
        Void voidR = (Void) obj;
        lIllllII lillllii = this.IIIIIIIl;
        IIIIIIII iiiiiiii = this.IIIIIIlI;
        if (iiiiiiii != null) {
            llIIlIII lliiliii = (llIIlIII) iiiiiiii;
            lliiliii.IIIIIIII.IIIIIlll.remove(lillllii);
            lliiliii.IIIIIIII.IIIIIIlI();
        }
    }
}
