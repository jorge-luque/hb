package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdv extends zzdy {
    private final /* synthetic */ int zzld;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdv(zzdu zzdu, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient, (zzdt) null);
        this.zzld = i;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zzb((BaseImplementation.ResultHolder<Videos.CaptureAvailableResult>) this, this.zzld);
    }
}
