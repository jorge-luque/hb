package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzcv implements TurnBasedMultiplayer {
    public final PendingResult<TurnBasedMultiplayer.InitiateMatchResult> acceptInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzcz(this, googleApiClient, str));
    }

    public final PendingResult<TurnBasedMultiplayer.CancelMatchResult> cancelMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzdg(this, str, googleApiClient, str));
    }

    public final PendingResult<TurnBasedMultiplayer.InitiateMatchResult> createMatch(GoogleApiClient googleApiClient, TurnBasedMatchConfig turnBasedMatchConfig) {
        return googleApiClient.execute(new zzcy(this, googleApiClient, turnBasedMatchConfig));
    }

    public final void declineInvitation(GoogleApiClient googleApiClient, String str) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zze(str, 1);
        }
    }

    public final void dismissInvitation(GoogleApiClient googleApiClient, String str) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzc(str, 1);
        }
    }

    public final void dismissMatch(GoogleApiClient googleApiClient, String str) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzd(str);
        }
    }

    public final PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str) {
        return finishMatch(googleApiClient, str, (byte[]) null, (ParticipantResult[]) null);
    }

    public final Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbl();
    }

    public final int getMaxMatchDataSize(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzca();
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2) {
        return Games.zza(googleApiClient).zzb(i, i2, true);
    }

    public final PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzde(this, googleApiClient, str));
    }

    public final PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.execute(new zzdd(this, googleApiClient, str, str2));
    }

    public final PendingResult<TurnBasedMultiplayer.LoadMatchResult> loadMatch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new zzcx(this, googleApiClient, str));
    }

    public final PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, int[] iArr) {
        return loadMatchesByStatus(googleApiClient, 0, iArr);
    }

    public final void registerMatchUpdateListener(GoogleApiClient googleApiClient, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzd((ListenerHolder<OnTurnBasedMatchUpdateReceivedListener>) googleApiClient.registerListener(onTurnBasedMatchUpdateReceivedListener));
        }
    }

    public final PendingResult<TurnBasedMultiplayer.InitiateMatchResult> rematch(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzda(this, googleApiClient, str));
    }

    public final PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2) {
        return takeTurn(googleApiClient, str, bArr, str2, (ParticipantResult[]) null);
    }

    public final void unregisterMatchUpdateListener(GoogleApiClient googleApiClient) {
        zzg zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzbq();
        }
    }

    public final PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, ParticipantResult... participantResultArr) {
        return googleApiClient.execute(new zzdb(this, googleApiClient, str, bArr, participantResultArr));
    }

    public final PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, int i, int[] iArr) {
        return googleApiClient.enqueue(new zzdf(this, googleApiClient, i, iArr));
    }

    public final PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult... participantResultArr) {
        return googleApiClient.execute(new zzdc(this, googleApiClient, str, bArr, str2, participantResultArr));
    }

    public final PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, List<ParticipantResult> list) {
        return finishMatch(googleApiClient, str, bArr, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    public final Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z) {
        return Games.zza(googleApiClient).zzb(i, i2, z);
    }

    public final PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, List<ParticipantResult> list) {
        return takeTurn(googleApiClient, str, bArr, str2, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }
}
