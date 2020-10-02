package p163cz.msebera.android.httpclient.p186j0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p163cz.msebera.android.httpclient.C5899o;
import p163cz.msebera.android.httpclient.C5900p;
import p163cz.msebera.android.httpclient.C5901q;
import p163cz.msebera.android.httpclient.C5903s;
import p163cz.msebera.android.httpclient.HttpException;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.j0.b */
/* compiled from: BasicHttpProcessor */
public final class C5872b implements C5877g, Cloneable {

    /* renamed from: a */
    protected final List<C5900p> f15101a = new ArrayList();

    /* renamed from: b */
    protected final List<C5903s> f15102b = new ArrayList();

    /* renamed from: a */
    public final void mo33631a(C5900p pVar) {
        mo33636b(pVar);
    }

    /* renamed from: b */
    public void mo33636b(C5900p pVar) {
        if (pVar != null) {
            this.f15101a.add(pVar);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        C5872b bVar = (C5872b) super.clone();
        mo33630a(bVar);
        return bVar;
    }

    /* renamed from: a */
    public final void mo33632a(C5900p pVar, int i) {
        mo33637b(pVar, i);
    }

    /* renamed from: b */
    public void mo33637b(C5900p pVar, int i) {
        if (pVar != null) {
            this.f15101a.add(i, pVar);
        }
    }

    /* renamed from: a */
    public int mo33628a() {
        return this.f15101a.size();
    }

    /* renamed from: b */
    public void mo33638b(C5903s sVar) {
        if (sVar != null) {
            this.f15102b.add(sVar);
        }
    }

    /* renamed from: a */
    public C5900p mo33629a(int i) {
        if (i < 0 || i >= this.f15101a.size()) {
            return null;
        }
        return this.f15101a.get(i);
    }

    /* renamed from: b */
    public int mo33634b() {
        return this.f15102b.size();
    }

    /* renamed from: b */
    public C5903s mo33635b(int i) {
        if (i < 0 || i >= this.f15102b.size()) {
            return null;
        }
        return this.f15102b.get(i);
    }

    /* renamed from: a */
    public final void mo33633a(C5903s sVar) {
        mo33638b(sVar);
    }

    /* renamed from: a */
    public void mo28845a(C5899o oVar, C5875e eVar) throws IOException, HttpException {
        for (C5900p a : this.f15101a) {
            a.mo28845a(oVar, eVar);
        }
    }

    /* renamed from: a */
    public void mo28846a(C5901q qVar, C5875e eVar) throws IOException, HttpException {
        for (C5903s a : this.f15102b) {
            a.mo28846a(qVar, eVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo33630a(C5872b bVar) {
        bVar.f15101a.clear();
        bVar.f15101a.addAll(this.f15101a);
        bVar.f15102b.clear();
        bVar.f15102b.addAll(this.f15102b);
    }
}
