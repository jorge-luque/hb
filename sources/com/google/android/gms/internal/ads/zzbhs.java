package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbhs implements zzegz<zzarx> {
    private final zzehm<Context> zzenp;

    public zzbhs(zzehm<Context> zzehm) {
        this.zzenp = zzehm;
    }

    public final /* synthetic */ Object get() {
        Context context = this.zzenp.get();
        return (zzarx) zzehf.zza(new zzarv(context, new zzasc(context).zzuu()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
