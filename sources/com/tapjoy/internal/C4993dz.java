package com.tapjoy.internal;

import com.tapjoy.internal.C4990dy;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tapjoy.internal.dz */
public final class C4993dz implements C4990dy.C4991a {

    /* renamed from: a */
    private final BlockingQueue f13553a = new LinkedBlockingQueue();

    /* renamed from: b */
    private final ThreadPoolExecutor f13554b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f13553a);

    /* renamed from: c */
    private final ArrayDeque f13555c = new ArrayDeque();

    /* renamed from: d */
    private C4990dy f13556d = null;

    /* renamed from: b */
    private void m16886b() {
        C4990dy dyVar = (C4990dy) this.f13555c.poll();
        this.f13556d = dyVar;
        if (dyVar != null) {
            dyVar.executeOnExecutor(this.f13554b, new Object[0]);
        }
    }

    /* renamed from: a */
    public final void mo31084a() {
        this.f13556d = null;
        m16886b();
    }

    /* renamed from: a */
    public final void mo31087a(C4990dy dyVar) {
        dyVar.f13551d = this;
        this.f13555c.add(dyVar);
        if (this.f13556d == null) {
            m16886b();
        }
    }
}
