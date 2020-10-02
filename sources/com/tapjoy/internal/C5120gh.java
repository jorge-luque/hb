package com.tapjoy.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tapjoy.internal.gh */
public final class C5120gh extends C3140gg {

    /* renamed from: b */
    private final ThreadPoolExecutor f14015b = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: com.tapjoy.internal.gh$a */
    class C5121a implements Runnable {

        /* renamed from: b */
        private int f14017b;

        /* renamed from: c */
        private long f14018c;

        /* renamed from: d */
        private String f14019d;

        /* renamed from: e */
        private String f14020e;

        /* renamed from: f */
        private Map f14021f;

        C5121a(int i, long j, String str, String str2, Map map) {
            this.f14017b = i;
            this.f14018c = j;
            this.f14019d = str;
            this.f14020e = str2;
            this.f14021f = map;
        }

        public final void run() {
            try {
                int i = this.f14017b;
                if (i == 1) {
                    C5120gh.super.mo18518a(this.f14018c);
                } else if (i == 2) {
                    C5120gh.super.mo18517a();
                } else if (i == 3) {
                    C5120gh.super.mo18519a(this.f14018c, this.f14019d, this.f14020e, this.f14021f);
                }
            } catch (Throwable unused) {
                C5120gh.super.mo18517a();
            }
        }
    }

    public C5120gh(File file, C3144gy gyVar) {
        super(file, gyVar);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        try {
            this.f14015b.shutdown();
            this.f14015b.awaitTermination(1, TimeUnit.SECONDS);
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18518a(long j) {
        try {
            this.f14015b.execute(new C5121a(1, j, (String) null, (String) null, (Map) null));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18517a() {
        try {
            this.f14015b.execute(new C5121a(2, 0, (String) null, (String) null, (Map) null));
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18519a(long j, String str, String str2, Map map) {
        try {
            this.f14015b.execute(new C5121a(3, j, str, str2, map != null ? new HashMap(map) : null));
        } catch (Throwable unused) {
        }
    }
}
