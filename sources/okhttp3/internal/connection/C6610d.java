package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import p113i.C3494c0;

/* renamed from: okhttp3.internal.connection.d */
/* compiled from: RouteDatabase */
public final class C6610d {

    /* renamed from: a */
    private final Set<C3494c0> f17288a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void mo35649a(C3494c0 c0Var) {
        this.f17288a.remove(c0Var);
    }

    /* renamed from: b */
    public synchronized void mo35650b(C3494c0 c0Var) {
        this.f17288a.add(c0Var);
    }

    /* renamed from: c */
    public synchronized boolean mo35651c(C3494c0 c0Var) {
        return this.f17288a.contains(c0Var);
    }
}
