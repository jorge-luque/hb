package p118io.presage;

import com.loopj.android.http.C4250c;
import java.nio.charset.Charset;

/* renamed from: io.presage.is */
public final class C6548is {

    /* renamed from: a */
    public static final Charset f17074a;

    /* renamed from: b */
    public static final Charset f17075b;

    /* renamed from: c */
    public static final Charset f17076c;

    /* renamed from: d */
    public static final Charset f17077d;

    /* renamed from: e */
    public static final Charset f17078e;

    /* renamed from: f */
    public static final Charset f17079f;

    /* renamed from: g */
    public static final C6548is f17080g = new C6548is();

    static {
        Charset forName = Charset.forName(C4250c.DEFAULT_CHARSET);
        C6514hl.m21414a((Object) forName, "Charset.forName(\"UTF-8\")");
        f17074a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        C6514hl.m21414a((Object) forName2, "Charset.forName(\"UTF-16\")");
        f17075b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        C6514hl.m21414a((Object) forName3, "Charset.forName(\"UTF-16BE\")");
        f17076c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        C6514hl.m21414a((Object) forName4, "Charset.forName(\"UTF-16LE\")");
        f17077d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        C6514hl.m21414a((Object) forName5, "Charset.forName(\"US-ASCII\")");
        f17078e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        C6514hl.m21414a((Object) forName6, "Charset.forName(\"ISO-8859-1\")");
        f17079f = forName6;
    }

    private C6548is() {
    }
}
