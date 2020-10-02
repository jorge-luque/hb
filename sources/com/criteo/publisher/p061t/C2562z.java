package com.criteo.publisher.p061t;

import com.criteo.publisher.p054a0.C2341p;
import com.squareup.tape.C4805a;
import com.squareup.tape.C4809c;
import com.squareup.tape.C4811d;
import com.squareup.tape.FileException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.criteo.publisher.t.z */
class C2562z extends C2554u {

    /* renamed from: a */
    private final Object f8107a = new Object();

    /* renamed from: b */
    private C4809c<C2540m> f8108b;

    /* renamed from: c */
    private Method f8109c;

    /* renamed from: d */
    private C4811d f8110d;

    /* renamed from: e */
    private final C2545p f8111e;

    C2562z(C2545p pVar) {
        this.f8111e = pVar;
        this.f8109c = null;
        this.f8110d = null;
    }

    /* renamed from: b */
    private void m9618b() {
        if (this.f8108b == null) {
            this.f8108b = this.f8111e.mo10587a();
        }
    }

    /* renamed from: c */
    private Method m9619c() throws ReflectiveOperationException {
        if (this.f8109c == null) {
            Method declaredMethod = C4811d.class.getDeclaredMethod("g", new Class[0]);
            this.f8109c = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return this.f8109c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10579a(C2540m mVar) {
        synchronized (this.f8107a) {
            m9618b();
            try {
                this.f8108b.add(mVar);
            } catch (FileException e) {
                C2341p.m8996a((Throwable) e);
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C2540m> mo10578a(int i) {
        ArrayList arrayList;
        synchronized (this.f8107a) {
            m9618b();
            arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                try {
                    C2540m peek = this.f8108b.peek();
                    if (peek == null) {
                        break;
                    }
                    arrayList.add(peek);
                    this.f8108b.remove();
                    i2++;
                } catch (FileException e) {
                    C2341p.m8996a((Throwable) e);
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo10577a() {
        synchronized (this.f8107a) {
            m9618b();
            if (!(this.f8108b instanceof C4805a)) {
                return 0;
            }
            try {
                int intValue = ((Integer) m9619c().invoke(m9617a((C4805a) this.f8108b), new Object[0])).intValue();
                return intValue;
            } catch (Exception e) {
                C2341p.m8996a((Throwable) e);
                return 0;
            }
        }
    }

    /* renamed from: a */
    private C4811d m9617a(C4805a aVar) throws ReflectiveOperationException, ClassCastException {
        if (this.f8110d == null) {
            Field declaredField = C4805a.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            this.f8110d = (C4811d) declaredField.get(aVar);
        }
        return this.f8110d;
    }
}
