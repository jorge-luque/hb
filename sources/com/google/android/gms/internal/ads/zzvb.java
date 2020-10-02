package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzvb extends zzvg<zzvz> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcfo;
    private final /* synthetic */ zzuu zzcfq;
    private final /* synthetic */ zzum zzcfr;

    zzvb(zzuu zzuu, Context context, zzum zzum, String str) {
        this.zzcfq = zzuu;
        this.val$context = context;
        this.zzcfr = zzum;
        this.zzcfo = str;
    }

    public final /* synthetic */ Object zza(zzwi zzwi) throws RemoteException {
        return zzwi.zza(ObjectWrapper.wrap(this.val$context), this.zzcfr, this.zzcfo, 201004000);
    }

    public final /* synthetic */ Object zzpm() {
        zzuu.zza(this.val$context, AppLovinEventTypes.USER_EXECUTED_SEARCH);
        return new zzym();
    }

    public final /* synthetic */ Object zzpn() throws RemoteException {
        return this.zzcfq.zzcff.zza(this.val$context, this.zzcfr, this.zzcfo, (zzalp) null, 3);
    }
}
