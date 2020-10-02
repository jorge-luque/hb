package com.google.android.exoplayer2;

/* renamed from: com.google.android.exoplayer2.i */
/* compiled from: Timeline */
public abstract class C3042i {

    /* renamed from: com.google.android.exoplayer2.i$a */
    /* compiled from: Timeline */
    static class C3043a extends C3042i {
        C3043a() {
        }

        /* renamed from: a */
        public int mo13031a() {
            return 0;
        }

        /* renamed from: a */
        public C3045c mo13034a(int i, C3045c cVar, boolean z, long j) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* renamed from: com.google.android.exoplayer2.i$b */
    /* compiled from: Timeline */
    public static final class C3044b {
    }

    /* renamed from: com.google.android.exoplayer2.i$c */
    /* compiled from: Timeline */
    public static final class C3045c {
    }

    static {
        new C3043a();
    }

    /* renamed from: a */
    public abstract int mo13031a();

    /* renamed from: a */
    public final C3045c mo13032a(int i, C3045c cVar) {
        mo13033a(i, cVar, false);
        throw null;
    }

    /* renamed from: a */
    public abstract C3045c mo13034a(int i, C3045c cVar, boolean z, long j);

    /* renamed from: b */
    public final boolean mo13035b() {
        return mo13031a() == 0;
    }

    /* renamed from: a */
    public final C3045c mo13033a(int i, C3045c cVar, boolean z) {
        mo13034a(i, cVar, z, 0);
        throw null;
    }
}
