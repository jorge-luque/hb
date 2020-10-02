package p163cz.msebera.android.httpclient.p182g0;

import p163cz.msebera.android.httpclient.C5567c;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.C5909x;
import p163cz.msebera.android.httpclient.C5910y;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.j */
/* compiled from: BasicLineFormatter */
public class C5740j implements C5750t {

    /* renamed from: a */
    public static final C5740j f14825a = new C5740j();

    static {
        new C5740j();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5889d mo33341a(C5889d dVar) {
        if (dVar == null) {
            return new C5889d(64);
        }
        dVar.mo33676b();
        return dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo33348b(C5889d dVar, C5909x xVar) {
        String method = xVar.getMethod();
        String uri = xVar.getUri();
        dVar.mo33667a(method.length() + 1 + uri.length() + 1 + mo33340a(xVar.getProtocolVersion()));
        dVar.mo33670a(method);
        dVar.mo33666a(' ');
        dVar.mo33670a(uri);
        dVar.mo33666a(' ');
        mo33343a(dVar, xVar.getProtocolVersion());
    }

    /* renamed from: a */
    public C5889d mo33343a(C5889d dVar, C5907v vVar) {
        C5886a.m18894a(vVar, "Protocol version");
        int a = mo33340a(vVar);
        if (dVar == null) {
            dVar = new C5889d(a);
        } else {
            dVar.mo33667a(a);
        }
        dVar.mo33670a(vVar.mo33700c());
        dVar.mo33666a('/');
        dVar.mo33670a(Integer.toString(vVar.mo33696a()));
        dVar.mo33666a('.');
        dVar.mo33670a(Integer.toString(vVar.mo33698b()));
        return dVar;
    }

    /* renamed from: b */
    public C5889d mo33346b(C5889d dVar, C5910y yVar) {
        C5886a.m18894a(yVar, "Status line");
        C5889d a = mo33341a(dVar);
        mo33345a(a, yVar);
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo33340a(C5907v vVar) {
        return vVar.mo33700c().length() + 4;
    }

    /* renamed from: a */
    public C5889d mo33344a(C5889d dVar, C5909x xVar) {
        C5886a.m18894a(xVar, "Request line");
        C5889d a = mo33341a(dVar);
        mo33348b(a, xVar);
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo33347b(C5889d dVar, C5691d dVar2) {
        String name = dVar2.getName();
        String value = dVar2.getValue();
        int length = name.length() + 2;
        if (value != null) {
            length += value.length();
        }
        dVar.mo33667a(length);
        dVar.mo33670a(name);
        dVar.mo33670a(": ");
        if (value != null) {
            dVar.mo33670a(value);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33345a(C5889d dVar, C5910y yVar) {
        int a = mo33340a(yVar.getProtocolVersion()) + 1 + 3 + 1;
        String b = yVar.mo33372b();
        if (b != null) {
            a += b.length();
        }
        dVar.mo33667a(a);
        mo33343a(dVar, yVar.getProtocolVersion());
        dVar.mo33666a(' ');
        dVar.mo33670a(Integer.toString(yVar.mo33371a()));
        dVar.mo33666a(' ');
        if (b != null) {
            dVar.mo33670a(b);
        }
    }

    /* renamed from: a */
    public C5889d mo33342a(C5889d dVar, C5691d dVar2) {
        C5886a.m18894a(dVar2, "Header");
        if (dVar2 instanceof C5567c) {
            return ((C5567c) dVar2).mo32887a();
        }
        C5889d a = mo33341a(dVar);
        mo33347b(a, dVar2);
        return a;
    }
}
