package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.event.C3093Events;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzah extends zzaj {
    private final /* synthetic */ boolean zzkb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzah(zzaf zzaf, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, (zzai) null);
        this.zzkb = z;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zzd((BaseImplementation.ResultHolder<C3093Events.LoadEventsResult>) this, this.zzkb);
    }
}
