package p113i.p114e0.p116f;

import javax.annotation.Nullable;
import p113i.C3484b0;
import p113i.C3541u;
import p119j.C3580e;

/* renamed from: i.e0.f.h */
/* compiled from: RealResponseBody */
public final class C3512h extends C3484b0 {
    @Nullable

    /* renamed from: a */
    private final String f9774a;

    /* renamed from: b */
    private final long f9775b;

    /* renamed from: c */
    private final C3580e f9776c;

    public C3512h(@Nullable String str, long j, C3580e eVar) {
        this.f9774a = str;
        this.f9775b = j;
        this.f9776c = eVar;
    }

    public long contentLength() {
        return this.f9775b;
    }

    public C3541u contentType() {
        String str = this.f9774a;
        if (str != null) {
            return C3541u.m11900b(str);
        }
        return null;
    }

    public C3580e source() {
        return this.f9776c;
    }
}
