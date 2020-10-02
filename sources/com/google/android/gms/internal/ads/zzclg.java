package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzclg implements zzdqj {
    private final zzarj zzfnq;

    zzclg(zzarj zzarj) {
        this.zzfnq = zzarj;
    }

    public final zzdri zzf(Object obj) {
        zzarj zzarj = this.zzfnq;
        zzarj.zzdpi = new String(zzdpr.toByteArray((InputStream) obj), zzdnv.UTF_8);
        return zzdqw.zzag(zzarj);
    }
}
