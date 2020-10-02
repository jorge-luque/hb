package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzaw implements Invitations {
    public final Intent getInvitationInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbm();
    }

    public final PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient) {
        return loadInvitations(googleApiClient, 0);
    }

    public final void registerInvitationListener(GoogleApiClient googleApiClient, OnInvitationReceivedListener onInvitationReceivedListener) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzb((ListenerHolder<OnInvitationReceivedListener>) googleApiClient.registerListener(onInvitationReceivedListener));
        }
    }

    public final void unregisterInvitationListener(GoogleApiClient googleApiClient) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzbo();
        }
    }

    public final PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.enqueue(new zzav(this, googleApiClient, i));
    }
}
