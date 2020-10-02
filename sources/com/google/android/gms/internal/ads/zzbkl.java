package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbkl implements zzaga<Object> {
    final /* synthetic */ zzbkg zzfgz;

    zzbkl(zzbkg zzbkg) {
        this.zzfgz = zzbkg;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzfgz.zzm(map)) {
            this.zzfgz.executor.execute(new zzbkk(this));
        }
    }
}
