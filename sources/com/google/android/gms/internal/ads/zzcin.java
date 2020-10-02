package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcin {
    public static Set<zzbvt<zzbrs>> zza(zzcix zzcix, Executor executor) {
        return zzc(zzcix, executor);
    }

    public static Set<zzbvt<AppEventListener>> zzb(zzcix zzcix, Executor executor) {
        return zzc(zzcix, executor);
    }

    public static Set<zzbvt<zzbsm>> zzc(zzcix zzcix, Executor executor) {
        return zzc(zzcix, executor);
    }

    public static Set<zzbvt<zzbrc>> zzd(zzcix zzcix, Executor executor) {
        return zzc(zzcix, executor);
    }

    public static Set<zzbvt<zzbqx>> zze(zzcix zzcix, Executor executor) {
        return zzc(zzcix, executor);
    }

    public static Set<zzbvt<zzbrp>> zzf(zzcix zzcix, Executor executor) {
        return zzc(zzcix, executor);
    }

    public static Set<zzbvt<zzub>> zzg(zzcix zzcix, Executor executor) {
        return zzc(zzcix, executor);
    }

    public static Set<zzbvt<zzdla>> zzh(zzcix zzcix, Executor executor) {
        return zzc(zzcix, executor);
    }

    public static Set<zzbvt<zzbtm>> zzi(zzcix zzcix, Executor executor) {
        return zzc(zzcix, executor);
    }

    private static <T> Set<zzbvt<T>> zzc(T t, Executor executor) {
        if (zzabn.zzcxb.get().booleanValue()) {
            return Collections.singleton(new zzbvt(t, executor));
        }
        return Collections.emptySet();
    }
}
