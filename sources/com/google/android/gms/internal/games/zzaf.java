package com.google.android.gms.internal.games;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.C3093Events;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzaf implements C3093Events {
    @SuppressLint({"MissingRemoteException"})
    public final void increment(GoogleApiClient googleApiClient, String str, int i) {
        zzg zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            if (zzb.isConnected()) {
                zzb.zza(str, i);
            } else {
                googleApiClient.execute(new zzak(this, googleApiClient, str, i));
            }
        }
    }

    public final PendingResult<C3093Events.LoadEventsResult> load(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.enqueue(new zzah(this, googleApiClient, z));
    }

    public final PendingResult<C3093Events.LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, boolean z, String... strArr) {
        return googleApiClient.enqueue(new zzai(this, googleApiClient, z, strArr));
    }
}
