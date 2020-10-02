package com.tapjoy.internal;

/* renamed from: com.tapjoy.internal.gi */
public final class C5122gi {

    /* renamed from: a */
    public static final C5122gi f14022a = new C5122gi(0, 0, 0, 0.0d);

    /* renamed from: b */
    public final long f14023b;

    /* renamed from: c */
    public final long f14024c;

    /* renamed from: d */
    public final double f14025d;

    /* renamed from: e */
    public long f14026e;

    /* renamed from: f */
    private final long f14027f;

    public C5122gi(long j, long j2, long j3, double d) {
        this.f14027f = j;
        this.f14023b = j2;
        this.f14024c = j3;
        this.f14025d = d;
        this.f14026e = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C5122gi.class == obj.getClass()) {
            C5122gi giVar = (C5122gi) obj;
            return this.f14027f == giVar.f14027f && this.f14023b == giVar.f14023b && this.f14024c == giVar.f14024c && this.f14025d == giVar.f14025d && this.f14026e == giVar.f14026e;
        }
    }
}
