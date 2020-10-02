package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqh;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzdem<RequestComponentT extends zzbqh<AdT>, AdT> implements zzdeu<RequestComponentT, AdT> {
    @GuardedBy("this")
    private RequestComponentT zzgrq;

    /* access modifiers changed from: private */
    /* renamed from: zzark */
    public final synchronized RequestComponentT zzarj() {
        return this.zzgrq;
    }

    public final synchronized zzdri<AdT> zza(zzdev zzdev, zzdew<RequestComponentT> zzdew) {
        RequestComponentT requestcomponentt;
        requestcomponentt = (zzbqh) zzdew.zzc(zzdev.zzgsi).zzaeg();
        this.zzgrq = requestcomponentt;
        return requestcomponentt.zzaed().zzaii();
    }
}
