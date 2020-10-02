package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbah implements zzdqx<Object> {
    private final /* synthetic */ String zzeaa;

    zzbah(String str) {
        this.zzeaa = str;
    }

    public final void onSuccess(Object obj) {
    }

    public final void zzb(Throwable th) {
        zzq.zzla().zzb(th, this.zzeaa);
    }
}
