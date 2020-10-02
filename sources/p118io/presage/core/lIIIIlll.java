package p118io.presage.core;

import android.content.Context;
import android.os.Build;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.presage.core.lIIIIlll */
public class lIIIIlll extends IIlllIlI<Void, byte[]> {
    public static final String IIIIIlIl = C6336o0.IIIIIIII;
    public static final String IIIIIllI = C6336o0.IIIIIIIl;
    public static final String IIIIIlll = C6336o0.IIIIIIlI;
    public static final String IIIIlIII = C6336o0.IIIIIIll;
    public static final String IIIIlIIl = C6336o0.IIIIIlII;
    public static final String IIIIlIlI = C6336o0.IIIIIlIl;
    public static final String IIIIlIll = C6336o0.IIIIIllI;
    public static final String IIIIllII = C6336o0.IIIIIlll;
    public static final String IIIIllIl = C6336o0.IIIIlIII;
    public static final String IIIIlllI = C6336o0.IIIIlIIl;
    public static final String IIIIllll = C6336o0.IIIIlIlI;
    public Context IIIIIIIl;
    public Exception IIIIIIlI;
    public IIIIIlll IIIIIIll;
    public IIIIIIII IIIIIlII;

    /* renamed from: io.presage.core.lIIIIlll$IIIIIIII */
    public interface IIIIIIII {
    }

    public lIIIIlll(Context context, IIIIIlll iIIIIlll, Exception exc, IIIIIIII iiiiiiii) {
        this.IIIIIIIl = context;
        this.IIIIIIll = iIIIIlll;
        this.IIIIIIlI = exc;
        this.IIIIIlII = iiiiiiii;
    }

    public Object IIIIIIII(Object[] objArr) {
        Void[] voidArr = (Void[]) objArr;
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IIIIIlIl, System.currentTimeMillis());
            String str = IIIIIllI;
            IIIIIlll.IIIlIIlI();
            jSONObject.put(str, "4.3.12");
            jSONObject.put(IIIIIlll, this.IIIIIIll.IIIIIIIl());
            jSONObject.put(IIIIlIII, this.IIIIIIll.IIIIIIII());
            jSONObject.put(IIIIlIIl, this.IIIIIIIl.getPackageName());
            jSONObject.put(IIIIlIlI, IIIIlIll.IIIIIllI(this.IIIIIIIl));
            jSONObject.put(IIIIlIll, llllIIll.IIIIIIII(this.IIIIIIIl).IIIIIIlI);
            jSONObject.put(IIIIllII, Build.VERSION.RELEASE);
            jSONObject.put(IIIIllIl, this.IIIIIIlI.getClass().getName());
            String str2 = IIIIlllI;
            jSONObject.put(str2, this.IIIIIIlI.getClass().getName() + " : " + this.IIIIIIlI.getMessage());
            StringWriter stringWriter = new StringWriter();
            this.IIIIIIlI.printStackTrace(new PrintWriter(stringWriter));
            jSONObject.put(IIIIllll, stringWriter.getBuffer().toString());
            jSONArray.put(jSONObject);
            return jSONArray.toString().getBytes();
        } catch (JSONException unused) {
            return null;
        }
    }

    public void IIIIIIII(Object obj) {
        byte[] bArr = (byte[]) obj;
        IIIIIIII iiiiiiii = this.IIIIIlII;
        if (iiiiiiii != null) {
            lIIIIlIl liiiilil = ((lIIIIlII) iiiiiiii).IIIIIIII;
            liiiilil.IIIIIlII.IIIIIIII(bArr, (llIIlIll) new lIIIIllI(liiiilil));
        }
    }
}
