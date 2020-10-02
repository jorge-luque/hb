package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdrs<V> extends zzdqq<V> {
    /* access modifiers changed from: private */
    @NullableDecl
    public zzdri<V> zzhin;
    /* access modifiers changed from: private */
    @NullableDecl
    public ScheduledFuture<?> zzhio;

    private zzdrs(zzdri<V> zzdri) {
        this.zzhin = (zzdri) zzdoj.checkNotNull(zzdri);
    }

    static <V> zzdri<V> zzb(zzdri<V> zzdri, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzdrs zzdrs = new zzdrs(zzdri);
        zzdru zzdru = new zzdru(zzdrs);
        zzdrs.zzhio = scheduledExecutorService.schedule(zzdru, j, timeUnit);
        zzdri.addListener(zzdru, zzdqp.INSTANCE);
        return zzdrs;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhin);
        ScheduledFuture<?> scheduledFuture = this.zzhio;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzhin = null;
        this.zzhio = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdri<V> zzdri = this.zzhin;
        ScheduledFuture<?> scheduledFuture = this.zzhio;
        if (zzdri == null) {
            return null;
        }
        String valueOf = String.valueOf(zzdri);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("inputFuture=[");
        sb.append(valueOf);
        sb.append("]");
        String sb2 = sb.toString();
        if (scheduledFuture == null) {
            return sb2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb2;
        }
        String valueOf2 = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
        sb3.append(valueOf2);
        sb3.append(", remaining delay=[");
        sb3.append(delay);
        sb3.append(" ms]");
        return sb3.toString();
    }
}
