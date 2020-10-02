package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdhp<T> {
    private final zzdrh zzfur;
    @GuardedBy("this")
    private final Deque<zzdri<T>> zzgvi = new LinkedBlockingDeque();
    private final Callable<T> zzgvj;

    public zzdhp(Callable<T> callable, zzdrh zzdrh) {
        this.zzgvj = callable;
        this.zzfur = zzdrh;
    }

    public final synchronized zzdri<T> zzasg() {
        zzdw(1);
        return this.zzgvi.poll();
    }

    public final synchronized void zzd(zzdri<T> zzdri) {
        this.zzgvi.addFirst(zzdri);
    }

    public final synchronized void zzdw(int i) {
        int size = i - this.zzgvi.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zzgvi.add(this.zzfur.zzd(this.zzgvj));
        }
    }
}
