package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbai implements zzdqx<Object> {
    private final /* synthetic */ String zzeaa;

    zzbai(String str) {
        this.zzeaa = str;
    }

    public final void onSuccess(Object obj) {
    }

    public final void zzb(Throwable th) {
        zzq.zzla().zza(th, this.zzeaa);
    }
}
