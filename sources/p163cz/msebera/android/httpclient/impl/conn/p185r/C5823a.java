package p163cz.msebera.android.httpclient.impl.conn.p185r;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p163cz.msebera.android.httpclient.impl.conn.C5816k;
import p163cz.msebera.android.httpclient.p177d0.C5695b;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.r.a */
/* compiled from: AbstractConnPool */
public abstract class C5823a {

    /* renamed from: a */
    protected final Lock f15027a;

    /* renamed from: b */
    protected Set<C5824b> f15028b = new HashSet();

    protected C5823a() {
        new C5695b(getClass());
        new C5816k();
        this.f15027a = new ReentrantLock();
    }
}
