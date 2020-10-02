package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbb;
import com.google.android.gms.games.internal.zzbg;
import com.google.android.gms.games.internal.zzbi;
import com.google.android.gms.games.internal.zzbj;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchUpdateCallback;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.internal.games.zzad;
import com.google.android.gms.tasks.Task;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class TurnBasedMultiplayerClient extends zzad {
    private static final zzbg<TurnBasedMatch> zzep = new zzct();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LoadMatchesResult, LoadMatchesResponse> zzeq = new zzce();
    private static final zzbj<TurnBasedMultiplayer.LoadMatchesResult> zzer = new zzcd();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LoadMatchResult, TurnBasedMatch> zzes = new zzcg();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.CancelMatchResult, String> zzet = new zzcf();
    private static final zzbi zzeu = new zzci();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LeaveMatchResult, Void> zzev = new zzch();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.LeaveMatchResult, TurnBasedMatch> zzew = new zzck();
    private static final zzbi zzex = new zzcj();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.UpdateMatchResult, TurnBasedMatch> zzey = new zzcm();
    private static final PendingResultUtil.ResultConverter<TurnBasedMultiplayer.InitiateMatchResult, TurnBasedMatch> zzez = new zzcl();

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public static class MatchOutOfDateApiException extends ApiException {
        protected final TurnBasedMatch match;

        MatchOutOfDateApiException(Status status, TurnBasedMatch turnBasedMatch) {
            super(status);
            this.match = turnBasedMatch;
        }

        public TurnBasedMatch getMatch() {
            return this.match;
        }
    }

    TurnBasedMultiplayerClient(Context context, Games.GamesOptions gamesOptions) {
        super(context, gamesOptions);
    }

    private static Task<Void> zzb(PendingResult<TurnBasedMultiplayer.LeaveMatchResult> pendingResult) {
        return zzbb.zza(pendingResult, zzeu, zzev, zzew, zzep);
    }

    private static Task<TurnBasedMatch> zzc(PendingResult<TurnBasedMultiplayer.UpdateMatchResult> pendingResult) {
        zzbi zzbi = zzex;
        PendingResultUtil.ResultConverter<TurnBasedMultiplayer.UpdateMatchResult, TurnBasedMatch> resultConverter = zzey;
        return zzbb.zza(pendingResult, zzbi, resultConverter, resultConverter, zzep);
    }

    public Task<TurnBasedMatch> acceptInvitation(String str) {
        return zzbb.toTask(Games.TurnBasedMultiplayer.acceptInvitation(asGoogleApiClient(), str), zzez);
    }

    public Task<String> cancelMatch(String str) {
        return zzbb.toTask(Games.TurnBasedMultiplayer.cancelMatch(asGoogleApiClient(), str), zzet);
    }

    public Task<TurnBasedMatch> createMatch(TurnBasedMatchConfig turnBasedMatchConfig) {
        return zzbb.toTask(Games.TurnBasedMultiplayer.createMatch(asGoogleApiClient(), turnBasedMatchConfig), zzez);
    }

    public Task<Void> declineInvitation(String str) {
        return doWrite(new zzcp(this, str));
    }

    public Task<Void> dismissInvitation(String str) {
        return doWrite(new zzcs(this, str));
    }

    public Task<Void> dismissMatch(String str) {
        return doWrite(new zzcu(this, str));
    }

    public Task<TurnBasedMatch> finishMatch(String str) {
        return zzc(Games.TurnBasedMultiplayer.finishMatch(asGoogleApiClient(), str));
    }

    public Task<Intent> getInboxIntent() {
        return doRead(new zzcc(this));
    }

    public Task<Integer> getMaxMatchDataSize() {
        return doRead(new zzcr(this));
    }

    public Task<Intent> getSelectOpponentsIntent(int i, int i2) {
        return getSelectOpponentsIntent(i, i2, true);
    }

    public Task<Void> leaveMatch(String str) {
        return zzb(Games.TurnBasedMultiplayer.leaveMatch(asGoogleApiClient(), str));
    }

    public Task<Void> leaveMatchDuringTurn(String str, String str2) {
        return zzb(Games.TurnBasedMultiplayer.leaveMatchDuringTurn(asGoogleApiClient(), str, str2));
    }

    public Task<AnnotatedData<TurnBasedMatch>> loadMatch(String str) {
        return zzbb.zza(Games.TurnBasedMultiplayer.loadMatch(asGoogleApiClient(), str), zzes);
    }

    public Task<AnnotatedData<LoadMatchesResponse>> loadMatchesByStatus(int[] iArr) {
        return zzbb.zza(Games.TurnBasedMultiplayer.loadMatchesByStatus(asGoogleApiClient(), iArr), zzeq, zzer);
    }

    public Task<Void> registerTurnBasedMatchUpdateCallback(TurnBasedMatchUpdateCallback turnBasedMatchUpdateCallback) {
        ListenerHolder registerListener = registerListener(turnBasedMatchUpdateCallback, TurnBasedMatchUpdateCallback.class.getSimpleName());
        return doRegisterEventListener(new zzco(this, registerListener, registerListener), new zzcn(this, registerListener.getListenerKey()));
    }

    public Task<TurnBasedMatch> rematch(String str) {
        return zzbb.toTask(Games.TurnBasedMultiplayer.rematch(asGoogleApiClient(), str), zzez);
    }

    public Task<TurnBasedMatch> takeTurn(String str, byte[] bArr, String str2) {
        return zzc(Games.TurnBasedMultiplayer.takeTurn(asGoogleApiClient(), str, bArr, str2));
    }

    public Task<Boolean> unregisterTurnBasedMatchUpdateCallback(TurnBasedMatchUpdateCallback turnBasedMatchUpdateCallback) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(turnBasedMatchUpdateCallback, TurnBasedMatchUpdateCallback.class.getSimpleName()));
    }

    TurnBasedMultiplayerClient(Activity activity, Games.GamesOptions gamesOptions) {
        super(activity, gamesOptions);
    }

    public Task<Intent> getSelectOpponentsIntent(int i, int i2, boolean z) {
        return doRead(new zzcq(this, i, i2, z));
    }

    public Task<TurnBasedMatch> finishMatch(String str, byte[] bArr, ParticipantResult... participantResultArr) {
        return zzc(Games.TurnBasedMultiplayer.finishMatch(asGoogleApiClient(), str, bArr, participantResultArr));
    }

    public Task<AnnotatedData<LoadMatchesResponse>> loadMatchesByStatus(int i, int[] iArr) {
        return zzbb.zza(Games.TurnBasedMultiplayer.loadMatchesByStatus(asGoogleApiClient(), i, iArr), zzeq, zzer);
    }

    public Task<TurnBasedMatch> takeTurn(String str, byte[] bArr, String str2, ParticipantResult... participantResultArr) {
        return zzc(Games.TurnBasedMultiplayer.takeTurn(asGoogleApiClient(), str, bArr, str2, participantResultArr));
    }

    public Task<TurnBasedMatch> finishMatch(String str, byte[] bArr, List<ParticipantResult> list) {
        return zzc(Games.TurnBasedMultiplayer.finishMatch(asGoogleApiClient(), str, bArr, list));
    }

    public Task<TurnBasedMatch> takeTurn(String str, byte[] bArr, String str2, List<ParticipantResult> list) {
        return zzc(Games.TurnBasedMultiplayer.takeTurn(asGoogleApiClient(), str, bArr, str2, list));
    }
}
