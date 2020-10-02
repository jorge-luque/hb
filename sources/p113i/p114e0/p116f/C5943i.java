package p113i.p114e0.p116f;

import java.net.Proxy;
import p113i.C3539s;
import p113i.C3548y;

/* renamed from: i.e0.f.i */
/* compiled from: RequestLine */
public final class C5943i {
    /* renamed from: a */
    public static String m19058a(C3548y yVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yVar.mo19605e());
        sb.append(' ');
        if (m19059b(yVar, type)) {
            sb.append(yVar.mo19607g());
        } else {
            sb.append(m19057a(yVar.mo19607g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m19059b(C3548y yVar, Proxy.Type type) {
        return !yVar.mo19604d() && type == Proxy.Type.HTTP;
    }

    /* renamed from: a */
    public static String m19057a(C3539s sVar) {
        String c = sVar.mo19520c();
        String e = sVar.mo19522e();
        if (e == null) {
            return c;
        }
        return c + '?' + e;
    }
}
