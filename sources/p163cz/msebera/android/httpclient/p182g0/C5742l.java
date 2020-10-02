package p163cz.msebera.android.httpclient.p182g0;

import java.util.List;
import java.util.NoSuchElementException;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5730g;
import p163cz.msebera.android.httpclient.p187k0.C5886a;
import p163cz.msebera.android.httpclient.p187k0.C5887b;

/* renamed from: cz.msebera.android.httpclient.g0.l */
/* compiled from: BasicListHeaderIterator */
public class C5742l implements C5730g {

    /* renamed from: a */
    protected final List<C5691d> f14828a;

    /* renamed from: b */
    protected int f14829b = mo33357b(-1);

    /* renamed from: c */
    protected int f14830c = -1;

    /* renamed from: d */
    protected String f14831d;

    public C5742l(List<C5691d> list, String str) {
        C5886a.m18894a(list, "Header list");
        this.f14828a = list;
        this.f14831d = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33356a(int i) {
        if (this.f14831d == null) {
            return true;
        }
        return this.f14831d.equalsIgnoreCase(this.f14828a.get(i).getName());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo33357b(int i) {
        if (i < -1) {
            return -1;
        }
        int size = this.f14828a.size() - 1;
        boolean z = false;
        while (!z && i < size) {
            i++;
            z = mo33356a(i);
        }
        if (z) {
            return i;
        }
        return -1;
    }

    public boolean hasNext() {
        return this.f14829b >= 0;
    }

    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    public C5691d nextHeader() throws NoSuchElementException {
        int i = this.f14829b;
        if (i >= 0) {
            this.f14830c = i;
            this.f14829b = mo33357b(i);
            return this.f14828a.get(i);
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    public void remove() throws UnsupportedOperationException {
        C5887b.m18902a(this.f14830c >= 0, "No header to remove");
        this.f14828a.remove(this.f14830c);
        this.f14830c = -1;
        this.f14829b--;
    }
}
