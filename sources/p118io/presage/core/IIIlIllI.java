package p118io.presage.core;

/* renamed from: io.presage.core.IIIlIllI */
public class IIIlIllI {
    public int IIIIIIII;
    public String IIIIIIIl;
    public long IIIIIIlI;
    public long IIIIIIll;
    public long IIIIIlII;
    public long IIIIIlIl;

    public IIIlIllI(int i, String str, long j, long j2, long j3, long j4) {
        this.IIIIIIII = i;
        this.IIIIIIIl = str;
        this.IIIIIIlI = j;
        this.IIIIIIll = j2;
        this.IIIIIlII = j3;
        this.IIIIIlIl = j4;
    }

    public boolean equals(Object obj) {
        IIIlIllI iIIlIllI = (IIIlIllI) obj;
        return iIIlIllI.IIIIIIII == this.IIIIIIII && iIIlIllI.IIIIIIIl.equals(this.IIIIIIIl) && iIIlIllI.IIIIIIlI == this.IIIIIIlI && iIIlIllI.IIIIIIll == this.IIIIIIll && iIIlIllI.IIIIIlII == this.IIIIIlII && iIIlIllI.IIIIIlIl == this.IIIIIlIl;
    }
}
