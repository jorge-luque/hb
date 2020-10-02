package p163cz.msebera.android.httpclient.p182g0;

import java.util.NoSuchElementException;
import p163cz.msebera.android.httpclient.C5691d;
import p163cz.msebera.android.httpclient.C5730g;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.g0.e */
/* compiled from: BasicHeaderIterator */
public class C5735e implements C5730g {

    /* renamed from: a */
    protected final C5691d[] f14807a;

    /* renamed from: b */
    protected int f14808b = mo33316b(-1);

    /* renamed from: c */
    protected String f14809c;

    public C5735e(C5691d[] dVarArr, String str) {
        C5886a.m18894a(dVarArr, "Header array");
        this.f14807a = dVarArr;
        this.f14809c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33315a(int i) {
        String str = this.f14809c;
        return str == null || str.equalsIgnoreCase(this.f14807a[i].getName());
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo33316b(int i) {
        if (i < -1) {
            return -1;
        }
        int length = this.f14807a.length - 1;
        boolean z = false;
        while (!z && i < length) {
            i++;
            z = mo33315a(i);
        }
        if (z) {
            return i;
        }
        return -1;
    }

    public boolean hasNext() {
        return this.f14808b >= 0;
    }

    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    public C5691d nextHeader() throws NoSuchElementException {
        int i = this.f14808b;
        if (i >= 0) {
            this.f14808b = mo33316b(i);
            return this.f14807a[i];
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing headers is not supported.");
    }
}
