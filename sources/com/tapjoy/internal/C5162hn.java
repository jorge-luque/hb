package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tapjoy.internal.hn */
public final class C5162hn {

    /* renamed from: a */
    public static final ScheduledExecutorService f14145a = Executors.newScheduledThreadPool(1);

    /* renamed from: b */
    public static final CountDownLatch f14146b = new CountDownLatch(1);

    /* renamed from: c */
    public static final CountDownLatch f14147c = new CountDownLatch(1);

    /* renamed from: d */
    private static final Runnable f14148d = new Runnable() {
        public final void run() {
            if (C5271v.m17677c()) {
                C5162hn.f14146b.countDown();
            } else if (C5271v.m17675a()) {
                C5162hn.f14146b.countDown();
            } else {
                C5162hn.f14145a.schedule(this, 300, TimeUnit.SECONDS);
            }
        }
    };

    /* renamed from: e */
    private static String f14149e;

    /* renamed from: f */
    private static boolean f14150f;

    /* renamed from: a */
    public static void m17385a() {
        f14145a.execute(f14148d);
    }

    /* renamed from: b */
    public static String m17387b() {
        return f14149e;
    }

    /* renamed from: c */
    public static boolean m17388c() {
        return f14150f;
    }

    /* renamed from: a */
    public static void m17386a(String str, boolean z) {
        f14149e = str;
        f14150f = z;
        f14147c.countDown();
    }
}
