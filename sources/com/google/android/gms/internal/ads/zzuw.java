package com.google.android.gms.internal.ads;

import admost.sdk.AdMostInterstitial;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzuw extends zzvg<zzatf> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcfo;
    private final /* synthetic */ zzalp zzcfp;
    private final /* synthetic */ zzuu zzcfq;

    zzuw(zzuu zzuu, Context context, String str, zzalp zzalp) {
        this.zzcfq = zzuu;
        this.val$context = context;
        this.zzcfo = str;
        this.zzcfp = zzalp;
    }

    public final /* synthetic */ Object zza(zzwi zzwi) throws RemoteException {
        return zzwi.zzb(ObjectWrapper.wrap(this.val$context), this.zzcfo, this.zzcfp, 201004000);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpm() {
        zzuu.zza(this.val$context, AdMostInterstitial.ZONE_TYPE_REWARDED);
        return new zzys();
    }

    public final /* synthetic */ Object zzpn() throws RemoteException {
        return zzatv.zzd(this.val$context, this.zzcfo, this.zzcfp);
    }
}
