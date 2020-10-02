package p118io.presage.core;

import java.io.InputStream;

/* renamed from: io.presage.core.lIIIlllI */
public class lIIIlllI {
    public static final String IIIIIlII = C6324l0.IIIIIIlI;
    public static final String IIIIIlIl = C6324l0.IIIIIIII;
    public static final String IIIIIllI = C6324l0.IIIIIIIl;
    public static final String IIIIIlll = C6324l0.IIIIIIll;
    public String IIIIIIII;
    public String IIIIIIIl;
    public InputStream IIIIIIlI;
    public lIIIllII IIIIIIll;

    public lIIIlllI(String str, String str2, lIIIllII liiillii) {
        this.IIIIIIII = str;
        this.IIIIIIIl = str2;
        this.IIIIIIll = liiillii;
        this.IIIIIIlI = null;
    }

    public lIIIlllI(String str, String str2, lIIIllII liiillii, InputStream inputStream) {
        this.IIIIIIII = str;
        this.IIIIIIIl = str2;
        this.IIIIIIll = liiillii;
        this.IIIIIIlI = inputStream;
    }

    public String IIIIIIII() {
        if (this.IIIIIIII.startsWith(IIIIIlll)) {
            String str = this.IIIIIIII;
            str.substring(str.indexOf("://") + 3);
        }
        String str2 = this.IIIIIIII;
        return str2.substring(str2.indexOf("/"));
    }
}
