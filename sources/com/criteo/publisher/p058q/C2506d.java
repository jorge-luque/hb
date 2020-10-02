package com.criteo.publisher.p058q;

import com.criteo.publisher.C2379c;
import java.util.UUID;

/* renamed from: com.criteo.publisher.q.d */
public class C2506d {

    /* renamed from: a */
    private final C2379c f7998a;

    public C2506d(C2379c cVar) {
        this.f7998a = cVar;
    }

    /* renamed from: a */
    private byte m9452a(long j, int i) {
        int i2 = (64 - (i + 1)) << 2;
        return (byte) ((int) (((j & (15 << i2)) >> i2) & 15));
    }

    /* renamed from: a */
    private long m9453a(long j, int i, byte b) {
        int i2 = (64 - (i + 1)) << 2;
        return (j & ((15 << i2) ^ -1)) | (((long) b) << i2);
    }

    /* renamed from: a */
    public String mo10515a() {
        return mo10516a(UUID.randomUUID(), this.f7998a.mo10237a() / 1000);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo10516a(UUID uuid, long j) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long a = m9453a(mostSignificantBits, 12, m9452a(mostSignificantBits, 0));
        long j2 = (j << 32) | (a & 4294967295L);
        return String.format("%016x%016x", new Object[]{Long.valueOf(j2), Long.valueOf(m9453a(leastSignificantBits, 0, m9452a(a, 1)))});
    }
}
