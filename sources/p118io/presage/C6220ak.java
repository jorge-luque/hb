package p118io.presage;

import com.loopj.android.http.C4250c;
import java.net.URLDecoder;

/* renamed from: io.presage.ak */
public final class C6220ak {
    /* renamed from: a */
    public static final String m20786a(String str) {
        try {
            String decode = URLDecoder.decode(str, C4250c.DEFAULT_CHARSET);
            C6514hl.m21414a((Object) decode, "URLDecoder.decode(this, \"UTF-8\")");
            return decode;
        } catch (Exception unused) {
            return "";
        }
    }
}
