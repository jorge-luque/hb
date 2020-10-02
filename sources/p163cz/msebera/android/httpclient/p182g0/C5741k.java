package p163cz.msebera.android.httpclient.p182g0;

import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5905t;
import p163cz.msebera.android.httpclient.C5907v;
import p163cz.msebera.android.httpclient.C5910y;
import p163cz.msebera.android.httpclient.ParseException;
import p163cz.msebera.android.httpclient.p186j0.C5874d;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.k */
/* compiled from: BasicLineParser */
public class C5741k implements C5751u {

    /* renamed from: b */
    public static final C5741k f14826b = new C5741k();

    /* renamed from: a */
    protected final C5907v f14827a;

    static {
        new C5741k();
    }

    public C5741k(C5907v vVar) {
        this.f14827a = vVar == null ? C5905t.f15130f : vVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5907v mo33350a(int i, int i2) {
        return this.f14827a.mo33695a(i, i2);
    }

    /* renamed from: b */
    public boolean mo33353b(C5889d dVar, C5752v vVar) {
        C5886a.m18894a(dVar, "Char array buffer");
        C5886a.m18894a(vVar, "Parser cursor");
        int b = vVar.mo33406b();
        String c = this.f14827a.mo33700c();
        int length = c.length();
        boolean z = false;
        if (dVar.length() < length + 4) {
            return false;
        }
        if (b < 0) {
            b = (dVar.length() - 4) - length;
        } else if (b == 0) {
            while (b < dVar.length() && C5874d.m18865a(dVar.charAt(b))) {
                b++;
            }
        }
        int i = b + length;
        if (i + 4 > dVar.length()) {
            return false;
        }
        boolean z2 = true;
        int i2 = 0;
        while (z2 && i2 < length) {
            z2 = dVar.charAt(b + i2) == c.charAt(i2);
            i2++;
        }
        if (!z2) {
            return z2;
        }
        if (dVar.charAt(i) == '/') {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public C5907v mo33354c(C5889d dVar, C5752v vVar) throws ParseException {
        C5886a.m18894a(dVar, "Char array buffer");
        C5886a.m18894a(vVar, "Parser cursor");
        String c = this.f14827a.mo33700c();
        int length = c.length();
        int b = vVar.mo33406b();
        int c2 = vVar.mo33407c();
        mo33355d(dVar, vVar);
        int b2 = vVar.mo33406b();
        int i = b2 + length;
        if (i + 4 <= c2) {
            boolean z = false;
            boolean z2 = true;
            int i2 = 0;
            while (z2 && i2 < length) {
                z2 = dVar.charAt(b2 + i2) == c.charAt(i2);
                i2++;
            }
            if (z2) {
                if (dVar.charAt(i) == '/') {
                    z = true;
                }
                z2 = z;
            }
            if (z2) {
                int i3 = b2 + length + 1;
                int a = dVar.mo33664a(46, i3, c2);
                if (a != -1) {
                    try {
                        int parseInt = Integer.parseInt(dVar.mo33675b(i3, a));
                        int i4 = a + 1;
                        int a2 = dVar.mo33664a(32, i4, c2);
                        if (a2 == -1) {
                            a2 = c2;
                        }
                        try {
                            int parseInt2 = Integer.parseInt(dVar.mo33675b(i4, a2));
                            vVar.mo33404a(a2);
                            return mo33350a(parseInt, parseInt2);
                        } catch (NumberFormatException unused) {
                            throw new ParseException("Invalid protocol minor version number: " + dVar.mo33665a(b, c2));
                        }
                    } catch (NumberFormatException unused2) {
                        throw new ParseException("Invalid protocol major version number: " + dVar.mo33665a(b, c2));
                    }
                } else {
                    throw new ParseException("Invalid protocol version number: " + dVar.mo33665a(b, c2));
                }
            } else {
                throw new ParseException("Not a valid protocol version: " + dVar.mo33665a(b, c2));
            }
        } else {
            throw new ParseException("Not a valid protocol version: " + dVar.mo33665a(b, c2));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo33355d(C5889d dVar, C5752v vVar) {
        int b = vVar.mo33406b();
        int c = vVar.mo33407c();
        while (b < c && C5874d.m18865a(dVar.charAt(b))) {
            b++;
        }
        vVar.mo33404a(b);
    }

    /* renamed from: a */
    public C5910y mo33351a(C5889d dVar, C5752v vVar) throws ParseException {
        C5886a.m18894a(dVar, "Char array buffer");
        C5886a.m18894a(vVar, "Parser cursor");
        int b = vVar.mo33406b();
        int c = vVar.mo33407c();
        try {
            C5907v c2 = mo33354c(dVar, vVar);
            mo33355d(dVar, vVar);
            int b2 = vVar.mo33406b();
            int a = dVar.mo33664a(32, b2, c);
            if (a < 0) {
                a = c;
            }
            String b3 = dVar.mo33675b(b2, a);
            int i = 0;
            while (i < b3.length()) {
                if (Character.isDigit(b3.charAt(i))) {
                    i++;
                } else {
                    throw new ParseException("Status line contains invalid status code: " + dVar.mo33665a(b, c));
                }
            }
            return mo33352a(c2, Integer.parseInt(b3), a < c ? dVar.mo33675b(a, c) : "");
        } catch (NumberFormatException unused) {
            throw new ParseException("Status line contains invalid status code: " + dVar.mo33665a(b, c));
        } catch (IndexOutOfBoundsException unused2) {
            throw new ParseException("Invalid status line: " + dVar.mo33665a(b, c));
        }
    }

    public C5741k() {
        this((C5907v) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C5910y mo33352a(C5907v vVar, int i, String str) {
        return new C5745o(vVar, i, str);
    }

    /* renamed from: a */
    public C5691d mo33349a(C5889d dVar) throws ParseException {
        return new C5747q(dVar);
    }
}
