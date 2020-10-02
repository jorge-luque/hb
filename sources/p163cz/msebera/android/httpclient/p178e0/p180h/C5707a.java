package p163cz.msebera.android.httpclient.p178e0.p180h;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5898n;
import p163cz.msebera.android.httpclient.HttpException;
import p163cz.msebera.android.httpclient.MessageConstraintException;
import p163cz.msebera.android.httpclient.ParseException;
import p163cz.msebera.android.httpclient.ProtocolException;
import p163cz.msebera.android.httpclient.p165b0.C5565b;
import p163cz.msebera.android.httpclient.p181f0.C5725c;
import p163cz.msebera.android.httpclient.p181f0.C5728f;
import p163cz.msebera.android.httpclient.p182g0.C5741k;
import p163cz.msebera.android.httpclient.p182g0.C5751u;
import p163cz.msebera.android.httpclient.p183h0.C5758d;
import p163cz.msebera.android.httpclient.p183h0.C5759e;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5889d;

/* renamed from: cz.msebera.android.httpclient.e0.h.a */
/* compiled from: AbstractMessageParser */
public abstract class C5707a<T extends C5898n> implements C5725c<T> {

    /* renamed from: a */
    private final C5728f f14732a;

    /* renamed from: b */
    private final C5565b f14733b;

    /* renamed from: c */
    private final List<C5889d> f14734c;

    /* renamed from: d */
    protected final C5751u f14735d;

    /* renamed from: e */
    private int f14736e;

    /* renamed from: f */
    private T f14737f;

    @Deprecated
    public C5707a(C5728f fVar, C5751u uVar, C5759e eVar) {
        C5886a.m18894a(fVar, "Session input buffer");
        C5886a.m18894a(eVar, "HTTP parameters");
        this.f14732a = fVar;
        this.f14733b = C5758d.m18347a(eVar);
        this.f14735d = uVar == null ? C5741k.f14826b : uVar;
        this.f14734c = new ArrayList();
        this.f14736e = 0;
    }

    /* renamed from: a */
    public static C5691d[] m18178a(C5728f fVar, int i, int i2, C5751u uVar) throws HttpException, IOException {
        ArrayList arrayList = new ArrayList();
        if (uVar == null) {
            uVar = C5741k.f14826b;
        }
        return m18179a(fVar, i, i2, uVar, arrayList);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo33220a(C5728f fVar) throws IOException, HttpException, ParseException;

    /* renamed from: a */
    public static C5691d[] m18179a(C5728f fVar, int i, int i2, C5751u uVar, List<C5889d> list) throws HttpException, IOException {
        int i3;
        C5886a.m18894a(fVar, "Session input buffer");
        C5886a.m18894a(uVar, "Line parser");
        C5886a.m18894a(list, "Header line list");
        C5889d dVar = null;
        C5889d dVar2 = null;
        while (true) {
            if (dVar == null) {
                dVar = new C5889d(64);
            } else {
                dVar.mo33676b();
            }
            i3 = 0;
            if (fVar.mo33223a(dVar) == -1 || dVar.length() < 1) {
                C5691d[] dVarArr = new C5691d[list.size()];
            } else {
                if ((dVar.charAt(0) == ' ' || dVar.charAt(0) == 9) && dVar2 != null) {
                    while (i3 < dVar.length() && ((r3 = dVar.charAt(i3)) == ' ' || r3 == 9)) {
                        i3++;
                    }
                    if (i2 <= 0 || ((dVar2.length() + 1) + dVar.length()) - i3 <= i2) {
                        dVar2.mo33666a(' ');
                        dVar2.mo33669a(dVar, i3, dVar.length() - i3);
                    } else {
                        throw new MessageConstraintException("Maximum line length limit exceeded");
                    }
                } else {
                    list.add(dVar);
                    dVar2 = dVar;
                    dVar = null;
                }
                if (i > 0 && list.size() >= i) {
                    throw new MessageConstraintException("Maximum header count exceeded");
                }
            }
        }
        C5691d[] dVarArr2 = new C5691d[list.size()];
        while (i3 < list.size()) {
            try {
                dVarArr2[i3] = uVar.mo33349a(list.get(i3));
                i3++;
            } catch (ParseException e) {
                throw new ProtocolException(e.getMessage());
            }
        }
        return dVarArr2;
    }

    /* renamed from: a */
    public T mo33219a() throws IOException, HttpException {
        int i = this.f14736e;
        if (i == 0) {
            try {
                this.f14737f = mo33220a(this.f14732a);
                this.f14736e = 1;
            } catch (ParseException e) {
                throw new ProtocolException(e.getMessage(), e);
            }
        } else if (i != 1) {
            throw new IllegalStateException("Inconsistent parser state");
        }
        this.f14737f.mo33295a(m18179a(this.f14732a, this.f14733b.mo32880a(), this.f14733b.mo32881b(), this.f14735d, this.f14734c));
        T t = this.f14737f;
        this.f14737f = null;
        this.f14734c.clear();
        this.f14736e = 0;
        return t;
    }
}
