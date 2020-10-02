package com.iab.omid.library.adcolony.walking.p148a;

import com.iab.omid.library.adcolony.walking.p148a.C4184b;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iab.omid.library.adcolony.walking.a.c */
public class C4187c implements C4184b.C4185a {

    /* renamed from: a */
    private final BlockingQueue<Runnable> f11250a = new LinkedBlockingQueue();

    /* renamed from: b */
    private final ThreadPoolExecutor f11251b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.f11250a);

    /* renamed from: c */
    private final ArrayDeque<C4184b> f11252c = new ArrayDeque<>();

    /* renamed from: d */
    private C4184b f11253d = null;

    /* renamed from: a */
    private void m14086a() {
        C4184b poll = this.f11252c.poll();
        this.f11253d = poll;
        if (poll != null) {
            poll.mo28602a(this.f11251b);
        }
    }

    /* renamed from: a */
    public void mo28604a(C4184b bVar) {
        this.f11253d = null;
        m14086a();
    }

    /* renamed from: b */
    public void mo28607b(C4184b bVar) {
        bVar.mo28600a((C4184b.C4185a) this);
        this.f11252c.add(bVar);
        if (this.f11253d == null) {
            m14086a();
        }
    }
}
