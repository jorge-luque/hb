package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzaah {
    public static boolean zza(zzaam zzaam, zzaak zzaak, String... strArr) {
        if (zzaam == null || zzaak == null || !zzaam.zzcuv || zzaak == null) {
            return false;
        }
        return zzaam.zza(zzaak, zzq.zzld().elapsedRealtime(), strArr);
    }

    public static zzaak zzb(zzaam zzaam) {
        if (zzaam == null) {
            return null;
        }
        return zzaam.zzex(zzq.zzld().elapsedRealtime());
    }
}
