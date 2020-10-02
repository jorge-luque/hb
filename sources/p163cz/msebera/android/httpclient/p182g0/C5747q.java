package p163cz.msebera.android.httpclient.p182g0;

import java.io.Serializable;
import p163cz.msebera.android.httpclient.C5567c;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.ParseException;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.q */
/* compiled from: BufferedHeader */
public class C5747q implements C5567c, Cloneable, Serializable {
    private static final long serialVersionUID = -2768352615787625448L;

    /* renamed from: a */
    private final String f14844a;

    /* renamed from: b */
    private final C5889d f14845b;

    /* renamed from: c */
    private final int f14846c;

    public C5747q(C5889d dVar) throws ParseException {
        C5886a.m18894a(dVar, "Char array buffer");
        int b = dVar.mo33674b(58);
        if (b != -1) {
            String b2 = dVar.mo33675b(0, b);
            if (b2.length() != 0) {
                this.f14845b = dVar;
                this.f14844a = b2;
                this.f14846c = b + 1;
                return;
            }
            throw new ParseException("Invalid header: " + dVar.toString());
        }
        throw new ParseException("Invalid header: " + dVar.toString());
    }

    /* renamed from: a */
    public C5889d mo32887a() {
        return this.f14845b;
    }

    /* renamed from: b */
    public C5696e[] mo33162b() throws ParseException {
        C5752v vVar = new C5752v(0, this.f14845b.length());
        vVar.mo33404a(this.f14846c);
        return C5737g.f14811b.mo33330a(this.f14845b, vVar);
    }

    /* renamed from: c */
    public int mo32888c() {
        return this.f14846c;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return this.f14844a;
    }

    public String getValue() {
        C5889d dVar = this.f14845b;
        return dVar.mo33675b(this.f14846c, dVar.length());
    }

    public String toString() {
        return this.f14845b.toString();
    }
}
