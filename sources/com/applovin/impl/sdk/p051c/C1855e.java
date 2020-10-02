package com.applovin.impl.sdk.p051c;

/* renamed from: com.applovin.impl.sdk.c.e */
public final class C1855e {

    /* renamed from: a */
    private long f6173a;

    /* renamed from: b */
    private long f6174b;

    /* renamed from: c */
    private boolean f6175c;

    /* renamed from: d */
    private long f6176d;

    /* renamed from: e */
    private long f6177e;

    /* renamed from: a */
    public void mo8370a() {
        this.f6175c = true;
    }

    /* renamed from: a */
    public void mo8371a(long j) {
        this.f6173a += j;
    }

    /* renamed from: b */
    public void mo8372b(long j) {
        this.f6174b += j;
    }

    /* renamed from: b */
    public boolean mo8373b() {
        return this.f6175c;
    }

    /* renamed from: c */
    public long mo8374c() {
        return this.f6173a;
    }

    /* renamed from: d */
    public long mo8375d() {
        return this.f6174b;
    }

    /* renamed from: e */
    public void mo8376e() {
        this.f6176d++;
    }

    /* renamed from: f */
    public void mo8377f() {
        this.f6177e++;
    }

    /* renamed from: g */
    public long mo8378g() {
        return this.f6176d;
    }

    /* renamed from: h */
    public long mo8379h() {
        return this.f6177e;
    }

    public String toString() {
        return "CacheStatsTracker{totalDownloadedBytes=" + this.f6173a + ", totalCachedBytes=" + this.f6174b + ", isHTMLCachingCancelled=" + this.f6175c + ", htmlResourceCacheSuccessCount=" + this.f6176d + ", htmlResourceCacheFailureCount=" + this.f6177e + '}';
    }
}
