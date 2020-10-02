package p118io.presage.core;

/* renamed from: io.presage.core.lIlIlllI */
public class lIlIlllI {
    public long IIIIIIII;
    public String IIIIIIIl;
    public long IIIIIIlI;
    public long IIIIIIll;
    public String IIIIIlII;
    public String IIIIIlIl;
    public long IIIIIllI;

    public lIlIlllI(String str, long j, long j2, String str2, long j3, String str3, long j4) {
        if (str == null || str.isEmpty()) {
            throw new lIlIllll();
        } else if (j < 0) {
            throw new lIlIllll();
        } else if (j4 >= 0) {
            this.IIIIIIIl = str;
            this.IIIIIIlI = j;
            this.IIIIIIll = j2;
            this.IIIIIlII = str2;
            this.IIIIIllI = j3;
            this.IIIIIlIl = str3;
            this.IIIIIIII = j4;
        } else {
            throw new lIlIllll();
        }
    }
}
