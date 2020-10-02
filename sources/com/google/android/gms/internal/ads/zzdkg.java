package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public abstract class zzdkg<E> {
    /* access modifiers changed from: private */
    public static final zzdri<?> zzgzc = zzdqw.zzag(null);
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzfif;
    /* access modifiers changed from: private */
    public final zzdrh zzfur;
    /* access modifiers changed from: private */
    public final zzdks<E> zzgzd;

    public zzdkg(zzdrh zzdrh, ScheduledExecutorService scheduledExecutorService, zzdks<E> zzdks) {
        this.zzfur = zzdrh;
        this.zzfif = scheduledExecutorService;
        this.zzgzd = zzdks;
    }

    public final <I> zzdkm<I> zza(E e, zzdri<I> zzdri) {
        return new zzdkm(this, e, (String) null, zzdri, Collections.singletonList(zzdri), zzdri, (zzdkf) null);
    }

    public final zzdkk zzu(E e) {
        return new zzdkk(this, e);
    }

    /* access modifiers changed from: protected */
    public abstract String zzv(E e);

    public final zzdki zza(E e, zzdri<?>... zzdriArr) {
        return new zzdki(this, e, Arrays.asList(zzdriArr));
    }
}
