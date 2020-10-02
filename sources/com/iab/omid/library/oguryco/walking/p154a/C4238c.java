package com.iab.omid.library.oguryco.walking.p154a;

import com.iab.omid.library.oguryco.walking.p154a.C4235b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.oguryco.walking.a.c */
public class C4238c implements C4235b.C4236a {

    /* renamed from: a */
    private final BlockingQueue<Runnable> f11371a = new LinkedBlockingQueue();

    /* renamed from: b */
    private final ThreadPoolExecutor f11372b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f11371a);

    /* renamed from: c */
    private final ArrayDeque<C4235b> f11373c = new ArrayDeque<>();

    /* renamed from: d */
    private C4235b f11374d = null;

    /* renamed from: a */
    private void m14315a() {
        C4235b poll = this.f11373c.poll();
        this.f11374d = poll;
        if (poll != null) {
            poll.mo28816a(this.f11372b);
        }
    }

    /* renamed from: a */
    public void mo28818a(C4235b bVar) {
        this.f11374d = null;
        m14315a();
    }

    /* renamed from: b */
    public void mo28821b(C4235b bVar) {
        bVar.mo28814a((C4235b.C4236a) this);
        this.f11373c.add(bVar);
        if (this.f11374d == null) {
            m14315a();
        }
    }
}
