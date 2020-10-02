package p118io.presage.core;

import android.content.Context;
import com.adcolony.adcolonysdk.BuildConfig;
import org.json.JSONObject;

/* renamed from: io.presage.core.lIIllIIl */
public class lIIllIIl extends IIlllIlI<Void, byte[]> {
    public static final String IIIIIlll = C6347r.IIIIIIll;
    public Context IIIIIIIl;
    public lIIllIll IIIIIIlI;
    public String IIIIIIll;
    public IIIIIIII IIIIIlII;
    public boolean IIIIIlIl = true;
    public Exception IIIIIllI;

    /* renamed from: io.presage.core.lIIllIIl$IIIIIIII */
    public interface IIIIIIII {
    }

    public lIIllIIl(Context context, lIIllIll liillill, String str, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = context;
        this.IIIIIIlI = liillill;
        this.IIIIIIll = str;
        this.IIIIIlII = iiiiiiii;
    }

    public Object IIIIIIII(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        try {
            return IIIIIIII(this.IIIIIIlI);
        } catch (Exception e) {
            this.IIIIIlIl = false;
            this.IIIIIllI = e;
            return null;
        }
    }

    public final byte[] IIIIIIII(lIIllIll liillill) {
        JSONObject IIIIIIII2 = new lIIllIII(this.IIIIIIIl).IIIIIIII(liillill);
        return BuildConfig.FLAVOR.equals(IIIIIlll) ? IIIIIIII2.toString().getBytes() : new C6353s1().IIIIIIII(0).IIIIIIlI(new C6377y1().IIIIIIII(1).IIIIIIII(this.IIIIIIll).getBytes()).IIIIIIII(2).IIIIIIIl(IIIIIIII2.toString().getBytes());
    }

    public void IIIIIIII(Object obj) {
        byte[] bArr = (byte[]) obj;
        IIIIIIII iiiiiiii = this.IIIIIlII;
        if (iiiiiiii != null) {
            ((IIIIlIIl) iiiiiiii).IIIIIIII(this.IIIIIIlI, this.IIIIIlIl, bArr, this.IIIIIllI);
        }
    }
}
