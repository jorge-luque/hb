package admost.adserver.videocache.p001q;

import java.io.File;

/* renamed from: admost.adserver.videocache.q.g */
/* compiled from: TotalSizeLruDiskUsage */
public class C0094g extends C0091e {

    /* renamed from: b */
    private final long f241b;

    public C0094g(long j) {
        if (j > 0) {
            this.f241b = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo153a(File file, long j, int i) {
        return j <= this.f241b;
    }
}
