package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzyz extends zzxe {
    private final OnPaidEventListener zzcic;

    public zzyz(OnPaidEventListener onPaidEventListener) {
        this.zzcic = onPaidEventListener;
    }

    public final void zza(zzuo zzuo) {
        if (this.zzcic != null) {
            this.zzcic.onPaidEvent(AdValue.zza(zzuo.zzacj, zzuo.zzack, zzuo.zzacl));
        }
    }
}
