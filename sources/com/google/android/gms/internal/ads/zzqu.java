package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzqu implements ValueCallback<String> {
    private final /* synthetic */ zzqr zzbrg;

    zzqu(zzqr zzqr) {
        this.zzbrg = zzqr;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        zzqr zzqr = this.zzbrg;
        zzqr.zzbrc.zza(zzqr.zzbqz, zzqr.zzbra, (String) obj, zzqr.zzbrb);
    }
}
