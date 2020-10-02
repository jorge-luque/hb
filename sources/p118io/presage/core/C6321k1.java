package p118io.presage.core;

/* renamed from: io.presage.core.k1 */
public class C6321k1 extends IIlllIlI<Void, Boolean> {
    public C6317j1 IIIIIIIl;
    public Exception IIIIIIlI;

    public C6321k1(C6317j1 j1Var) {
        this.IIIIIIIl = j1Var;
    }

    public Object IIIIIIII(Object[] objArr) {
        boolean z;
        Void[] voidArr = (Void[]) objArr;
        this.IIIIIIlI = null;
        System.currentTimeMillis();
        try {
            IIIIlIll.IIIIIIII();
            IIIIlIll.IIIIIIIl();
            z = true;
        } catch (Exception e) {
            this.IIIIIIlI = e;
            z = false;
        }
        System.currentTimeMillis();
        return Boolean.valueOf(z);
    }

    public void IIIIIIII(Object obj) {
        Boolean bool = (Boolean) obj;
        C6317j1 j1Var = this.IIIIIIIl;
        if (j1Var != null) {
            j1Var.IIIIIIII(bool.booleanValue(), this.IIIIIIlI);
        }
    }
}
