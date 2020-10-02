package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcit implements zzegz<Set<zzbvt<AppEventListener>>> {
    private final zzehm<Executor> zzenm;
    private final zzehm<zzcix> zzfyg;
    private final zzcin zzfzt;

    private zzcit(zzcin zzcin, zzehm<zzcix> zzehm, zzehm<Executor> zzehm2) {
        this.zzfzt = zzcin;
        this.zzfyg = zzehm;
        this.zzenm = zzehm2;
    }

    public static zzcit zzf(zzcin zzcin, zzehm<zzcix> zzehm, zzehm<Executor> zzehm2) {
        return new zzcit(zzcin, zzehm, zzehm2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzehf.zza(zzcin.zzb(this.zzfyg.get(), this.zzenm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
