package p163cz.msebera.android.httpclient.p182g0;

import java.util.NoSuchElementException;
import p163cz.msebera.android.httpclient.C5567c;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5696e;
import p163cz.msebera.android.httpclient.C5722f;
import p163cz.msebera.android.httpclient.C5730g;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.g0.d */
/* compiled from: BasicHeaderElementIterator */
public class C5734d implements C5722f {

    /* renamed from: a */
    private final C5730g f14802a;

    /* renamed from: b */
    private final C5749s f14803b;

    /* renamed from: c */
    private C5696e f14804c;

    /* renamed from: d */
    private C5889d f14805d;

    /* renamed from: e */
    private C5752v f14806e;

    public C5734d(C5730g gVar, C5749s sVar) {
        this.f14804c = null;
        this.f14805d = null;
        this.f14806e = null;
        C5886a.m18894a(gVar, "Header iterator");
        this.f14802a = gVar;
        C5886a.m18894a(sVar, "Parser");
        this.f14803b = sVar;
    }

    /* renamed from: a */
    private void m18236a() {
        this.f14806e = null;
        this.f14805d = null;
        while (this.f14802a.hasNext()) {
            C5691d nextHeader = this.f14802a.nextHeader();
            if (nextHeader instanceof C5567c) {
                C5567c cVar = (C5567c) nextHeader;
                C5889d a = cVar.mo32887a();
                this.f14805d = a;
                C5752v vVar = new C5752v(0, a.length());
                this.f14806e = vVar;
                vVar.mo33404a(cVar.mo32888c());
                return;
            }
            String value = nextHeader.getValue();
            if (value != null) {
                C5889d dVar = new C5889d(value.length());
                this.f14805d = dVar;
                dVar.mo33670a(value);
                this.f14806e = new C5752v(0, this.f14805d.length());
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m18237b() {
        /*
            r3 = this;
        L_0x0000:
            cz.msebera.android.httpclient.g r0 = r3.f14802a
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x000e
            cz.msebera.android.httpclient.g0.v r0 = r3.f14806e
            if (r0 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            return
        L_0x000e:
            cz.msebera.android.httpclient.g0.v r0 = r3.f14806e
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.mo33405a()
            if (r0 == 0) goto L_0x001b
        L_0x0018:
            r3.m18236a()
        L_0x001b:
            cz.msebera.android.httpclient.g0.v r0 = r3.f14806e
            if (r0 == 0) goto L_0x0000
        L_0x001f:
            cz.msebera.android.httpclient.g0.v r0 = r3.f14806e
            boolean r0 = r0.mo33405a()
            if (r0 != 0) goto L_0x0044
            cz.msebera.android.httpclient.g0.s r0 = r3.f14803b
            cz.msebera.android.httpclient.k0.d r1 = r3.f14805d
            cz.msebera.android.httpclient.g0.v r2 = r3.f14806e
            cz.msebera.android.httpclient.e r0 = r0.mo33331b(r1, r2)
            java.lang.String r1 = r0.getName()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0041
            java.lang.String r1 = r0.getValue()
            if (r1 == 0) goto L_0x001f
        L_0x0041:
            r3.f14804c = r0
            return
        L_0x0044:
            cz.msebera.android.httpclient.g0.v r0 = r3.f14806e
            boolean r0 = r0.mo33405a()
            if (r0 == 0) goto L_0x0000
            r0 = 0
            r3.f14806e = r0
            r3.f14805d = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: p163cz.msebera.android.httpclient.p182g0.C5734d.m18237b():void");
    }

    public boolean hasNext() {
        if (this.f14804c == null) {
            m18237b();
        }
        return this.f14804c != null;
    }

    public final Object next() throws NoSuchElementException {
        return nextElement();
    }

    public C5696e nextElement() throws NoSuchElementException {
        if (this.f14804c == null) {
            m18237b();
        }
        C5696e eVar = this.f14804c;
        if (eVar != null) {
            this.f14804c = null;
            return eVar;
        }
        throw new NoSuchElementException("No more header elements available");
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Remove not supported");
    }

    public C5734d(C5730g gVar) {
        this(gVar, C5737g.f14811b);
    }
}
