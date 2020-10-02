package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.C3069a;

/* renamed from: com.google.android.exoplayer2.f */
/* compiled from: PlaybackParameters */
public final class C3038f {

    /* renamed from: a */
    public final float f8433a;

    /* renamed from: b */
    public final float f8434b;

    /* renamed from: c */
    public final boolean f8435c;

    static {
        new C3038f(1.0f);
    }

    public C3038f(float f) {
        this(f, 1.0f, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3038f.class != obj.getClass()) {
            return false;
        }
        C3038f fVar = (C3038f) obj;
        if (this.f8433a == fVar.f8433a && this.f8434b == fVar.f8434b && this.f8435c == fVar.f8435c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + Float.floatToRawIntBits(this.f8433a)) * 31) + Float.floatToRawIntBits(this.f8434b)) * 31) + (this.f8435c ? 1 : 0);
    }

    public C3038f(float f, float f2, boolean z) {
        boolean z2 = true;
        C3069a.m10121a(f > 0.0f);
        C3069a.m10121a(f2 <= 0.0f ? false : z2);
        this.f8433a = f;
        this.f8434b = f2;
        this.f8435c = z;
        Math.round(f * 1000.0f);
    }
}
