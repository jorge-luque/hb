package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbtv implements zzbuk {
    private final String zzdbv;
    private final String zzdcd;

    zzbtv(String str, String str2) {
        this.zzdcd = str;
        this.zzdbv = str2;
    }

    public final void zzp(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.zzdcd, this.zzdbv);
    }
}
