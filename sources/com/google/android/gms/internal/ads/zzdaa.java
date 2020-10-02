package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdaa implements zzdak<zzdah<Bundle>> {
    private final boolean zzgog;

    zzdaa(zzdfa zzdfa) {
        if (zzdfa != null) {
            this.zzgog = true;
        } else {
            this.zzgog = false;
        }
    }

    public final zzdri<zzdah<Bundle>> zzaqa() {
        return zzdqw.zzag(this.zzgog ? zzczz.zzgof : null);
    }
}
