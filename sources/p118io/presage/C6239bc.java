package p118io.presage;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.loopj.android.http.C4250c;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import p118io.presage.StRomans;

/* renamed from: io.presage.bc */
public final class C6239bc {

    /* renamed from: a */
    public static final C6239bc f16784a = new C6239bc();

    private C6239bc() {
    }

    /* renamed from: a */
    private static WebResourceResponse m20882a(String str, String str2) {
        String str3 = "javascript:" + str2 + str;
        Charset charset = C6548is.f17074a;
        if (str3 != null) {
            byte[] bytes = str3.getBytes(charset);
            C6514hl.m21414a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return new WebResourceResponse("text/javascript", C4250c.DEFAULT_CHARSET, new ByteArrayInputStream(bytes));
        }
        throw new C6434em("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    public static WebResourceResponse m20881a(Context context, SaintFelicien saintFelicien) {
        new C6235az();
        String a = C6235az.m20872a(saintFelicien);
        StRomans.CamembertauCalvados camembertauCalvados = StRomans.f16690a;
        String b = StRomans.CamembertauCalvados.m20680a(context).mo34690b();
        if (b.length() > 0) {
            return m20882a(b, a);
        }
        return null;
    }
}
