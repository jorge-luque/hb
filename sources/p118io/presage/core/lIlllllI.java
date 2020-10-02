package p118io.presage.core;

/* renamed from: io.presage.core.lIlllllI */
public class lIlllllI {
    public int IIIIIIII = 1;
    public int IIIIIIIl = 0;

    public boolean IIIIIIII() {
        return this.IIIIIIII == 1;
    }

    public void IIIIIIIl() {
        this.IIIIIIII = 2;
    }

    public boolean IIIIIIlI() {
        int i = this.IIIIIIIl;
        if (i != 1 && i != 3) {
            return false;
        }
        this.IIIIIIIl = 0;
        return true;
    }
}
