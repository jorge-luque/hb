package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.event.C3093Events;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzai extends zzaj {
    private final /* synthetic */ boolean zzkb;
    private final /* synthetic */ String[] zzkf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzai(zzaf zzaf, GoogleApiClient googleApiClient, boolean z, String[] strArr) {
        super(googleApiClient, (zzai) null);
        this.zzkb = z;
        this.zzkf = strArr;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<C3093Events.LoadEventsResult>) this, this.zzkb, this.zzkf);
    }
}
