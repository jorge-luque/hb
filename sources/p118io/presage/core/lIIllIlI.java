package p118io.presage.core;

import android.content.Context;
import com.adcolony.adcolonysdk.BuildConfig;
import org.json.JSONObject;
import p118io.presage.core.IIIIIlll;

/* renamed from: io.presage.core.lIIllIlI */
public class lIIllIlI extends IIlllIlI<Void, lIIllIll> {
    public static final String IIIIIlll = C6347r.IIIIIIll;
    public Context IIIIIIIl;
    public byte[] IIIIIIlI;
    public String IIIIIIll;
    public IIIIIIII IIIIIlII;
    public boolean IIIIIlIl = true;
    public Exception IIIIIllI;

    /* renamed from: io.presage.core.lIIllIlI$IIIIIIII */
    public interface IIIIIIII {
    }

    public lIIllIlI(Context context, byte[] bArr, String str, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = context;
        this.IIIIIIlI = bArr;
        this.IIIIIIll = str;
        this.IIIIIlII = iiiiiiii;
    }

    public final lIIllIll IIIIIIII(byte[] bArr) {
        JSONObject jSONObject = BuildConfig.FLAVOR.equals(IIIIIlll) ? new JSONObject(new String(bArr)) : new JSONObject(new String(new C6353s1().IIIIIIII(2).IIIIIIII(0).IIIIIIlI(new C6377y1().IIIIIIII(1).IIIIIIII(this.IIIIIIll).getBytes()).IIIIIIII(bArr)));
        jSONObject.toString(3);
        return new lIIllIII(this.IIIIIIIl).IIIIIIII(jSONObject);
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

    public void IIIIIIII(Object obj) {
        lIIllIll liillill = (lIIllIll) obj;
        IIIIIIII iiiiiiii = this.IIIIIlII;
        if (iiiiiiii != null) {
            ((IIIIIlll.IIIIIIIl) iiiiiiii).IIIIIIII(this.IIIIIIlI, this.IIIIIlIl, liillill, this.IIIIIllI);
        }
    }
}
