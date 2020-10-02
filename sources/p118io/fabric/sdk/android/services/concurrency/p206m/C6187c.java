package p118io.fabric.sdk.android.services.concurrency.p206m;

/* renamed from: io.fabric.sdk.android.services.concurrency.m.c */
/* compiled from: ExponentialBackoff */
public class C6187c implements C6185a {

    /* renamed from: a */
    private final long f16234a;

    /* renamed from: b */
    private final int f16235b;

    public C6187c(long j, int i) {
        this.f16234a = j;
        this.f16235b = i;
    }

    public long getDelayMillis(int i) {
        double d = (double) this.f16234a;
        double pow = Math.pow((double) this.f16235b, (double) i);
        Double.isNaN(d);
        return (long) (d * pow);
    }
}
