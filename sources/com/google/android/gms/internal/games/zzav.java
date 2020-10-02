package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.Invitations;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzav extends zzay {
    private final /* synthetic */ int zzkg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzav(zzaw zzaw, GoogleApiClient googleApiClient, int i) {
        super(googleApiClient, (zzav) null);
        this.zzkg = i;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<Invitations.LoadInvitationsResult>) this, this.zzkg);
    }
}
