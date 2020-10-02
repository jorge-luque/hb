package p118io.presage.core;

/* renamed from: io.presage.core.IIlIlllI */
public class IIlIlllI {
    public int IIIIIIII;
    public String IIIIIIIl;
    public int IIIIIIlI;
    public String IIIIIIll;
    public int IIIIIlII;
    public long IIIIIlIl;
    public long IIIIIllI;
    public long IIIIIlll;
    public long IIIIlIII;
    public long IIIIlIIl;
    public long IIIIlIlI;
    public long IIIIlIll;
    public long IIIIllII;

    public IIlIlllI(int i, String str, int i2, String str2, int i3, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.IIIIIIII = i;
        this.IIIIIIIl = str;
        this.IIIIIIlI = i2;
        this.IIIIIIll = str2;
        this.IIIIIlII = i3;
        this.IIIIIlIl = j;
        this.IIIIIllI = j2;
        this.IIIIIlll = j3;
        this.IIIIlIII = j4;
        this.IIIIlIIl = j5;
        this.IIIIlIlI = j6;
        this.IIIIlIll = j7;
        this.IIIIllII = j8;
    }

    public void IIIIIIII(IIlIlllI iIlIlllI) {
        if (iIlIlllI == null) {
            this.IIIIllII = 0;
        } else {
            this.IIIIllII = (((this.IIIIIlIl + this.IIIIIllI) + this.IIIIIlll) + this.IIIIlIII) - (((iIlIlllI.IIIIIlIl + iIlIlllI.IIIIIllI) + iIlIlllI.IIIIIlll) + iIlIlllI.IIIIlIII);
        }
    }
}
