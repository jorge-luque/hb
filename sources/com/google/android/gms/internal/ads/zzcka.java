package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcka implements zzegz<String> {
    private final zzehm<Context> zzenp;

    private zzcka(zzehm<Context> zzehm) {
        this.zzenp = zzehm;
    }

    public static zzcka zzad(zzehm<Context> zzehm) {
        return new zzcka(zzehm);
    }

    public static String zzcd(Context context) {
        return (String) zzehf.zza(context.getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzcd(this.zzenp.get());
    }
}
