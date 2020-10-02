package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.DataHolderResult;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.C3093Events;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzed;
import com.google.android.gms.internal.games.zzef;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public class zzg extends GmsClient<zzbr> {
    private final zzef zzgv = new zzf(this);
    private final String zzgw;
    private PlayerEntity zzgx;
    private GameEntity zzgy;
    private final zzbv zzgz;
    private boolean zzha = false;
    private final Binder zzhb;
    private final long zzhc;
    private boolean zzhd = false;
    private final Games.GamesOptions zzhe;
    private Bundle zzhf;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zza extends zzb {
        private final TaskCompletionSource<Boolean> zzhp;

        zza(TaskCompletionSource<Boolean> taskCompletionSource) {
            this.zzhp = taskCompletionSource;
        }

        public final void zzb(int i, String str) {
            if (i == 0 || i == 3003) {
                this.zzhp.setResult(Boolean.valueOf(i == 3003));
            } else {
                zzg.zza(this.zzhp, i);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzaa extends zzaz implements TurnBasedMultiplayer.LoadMatchResult {
        zzaa(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzab extends zzn implements Invitations.LoadInvitationsResult {
        private final InvitationBuffer zzif;

        zzab(DataHolder dataHolder) {
            super(dataHolder);
            this.zzif = new InvitationBuffer(dataHolder);
        }

        public final InvitationBuffer getInvitations() {
            return this.zzif;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzac extends zzn implements Leaderboards.LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzig;

        zzac(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzig = (LeaderboardScoreEntity) ((LeaderboardScore) leaderboardScoreBuffer.get(0)).freeze();
                } else {
                    this.zzig = null;
                }
            } finally {
                leaderboardScoreBuffer.release();
            }
        }

        public final LeaderboardScore getScore() {
            return this.zzig;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzad implements TurnBasedMultiplayer.LoadMatchesResult {
        private final Status zzhq;
        private final LoadMatchesResponse zzih;

        zzad(Status status, Bundle bundle) {
            this.zzhq = status;
            this.zzih = new LoadMatchesResponse(bundle);
        }

        public final LoadMatchesResponse getMatches() {
            return this.zzih;
        }

        public final Status getStatus() {
            return this.zzhq;
        }

        public final void release() {
            this.zzih.release();
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzae extends zzn implements Players.LoadPlayersResult {
        private final PlayerBuffer zzii;

        zzae(DataHolder dataHolder) {
            super(dataHolder);
            this.zzii = new PlayerBuffer(dataHolder);
        }

        public final PlayerBuffer getPlayers() {
            return this.zzii;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzaf extends zzn implements Stats.LoadPlayerStatsResult {
        private final PlayerStats zzij;

        zzaf(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzij = new PlayerStatsEntity((PlayerStats) playerStatsBuffer.get(0));
                } else {
                    this.zzij = null;
                }
            } finally {
                playerStatsBuffer.release();
            }
        }

        public final PlayerStats getPlayerStats() {
            return this.zzij;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzag extends zzn implements Snapshots.LoadSnapshotsResult {
        zzag(DataHolder dataHolder) {
            super(dataHolder);
        }

        public final SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.mDataHolder);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzah extends zzn implements Leaderboards.LoadScoresResult {
        private final LeaderboardEntity zzik;
        private final LeaderboardScoreBuffer zzil;

        /* JADX INFO: finally extract failed */
        zzah(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzik = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzik = null;
                }
                leaderboardBuffer.release();
                this.zzil = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
                throw th;
            }
        }

        public final Leaderboard getLeaderboard() {
            return this.zzik;
        }

        public final LeaderboardScoreBuffer getScores() {
            return this.zzil;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzai extends zzu<OnTurnBasedMatchUpdateReceivedListener> {
        zzai(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        public final void onTurnBasedMatchRemoved(String str) {
            zzc(new zzag(str));
        }

        public final void zzr(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                TurnBasedMatch turnBasedMatch = turnBasedMatchBuffer.getCount() > 0 ? (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze() : null;
                if (turnBasedMatch != null) {
                    zzc(new zzaf(turnBasedMatch));
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzaj extends zzn implements Snapshots.OpenSnapshotResult {
        private final String zzem;
        private final Snapshot zzin;
        private final Snapshot zzio;
        private final SnapshotContents zzip;

        zzaj(DataHolder dataHolder, Contents contents) {
            this(dataHolder, (String) null, contents, (Contents) null, (Contents) null);
        }

        public final String getConflictId() {
            return this.zzem;
        }

        public final Snapshot getConflictingSnapshot() {
            return this.zzio;
        }

        public final SnapshotContents getResolutionSnapshotContents() {
            return this.zzip;
        }

        public final Snapshot getSnapshot() {
            return this.zzin;
        }

        /* JADX INFO: finally extract failed */
        zzaj(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzin = null;
                    this.zzio = null;
                } else {
                    boolean z = true;
                    if (snapshotMetadataBuffer.getCount() == 1) {
                        if (dataHolder.getStatusCode() == 4004) {
                            z = false;
                        }
                        Asserts.checkState(z);
                        this.zzin = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                        this.zzio = null;
                    } else {
                        this.zzin = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                        this.zzio = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                    }
                }
                snapshotMetadataBuffer.release();
                this.zzem = str;
                this.zzip = new SnapshotContentsEntity(contents3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
                throw th;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzak extends zzan<Players.LoadPlayersResult> {
        zzak(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder) {
            super(resultHolder);
        }

        public final void zze(DataHolder dataHolder) {
            setResult(new zzae(dataHolder));
        }

        public final void zzf(DataHolder dataHolder) {
            setResult(new zzae(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzal extends zzb {
        private final TaskCompletionSource<AnnotatedData<PlayerStats>> zzhp;

        zzal(TaskCompletionSource<AnnotatedData<PlayerStats>> taskCompletionSource) {
            this.zzhp = taskCompletionSource;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.google.android.gms.games.stats.PlayerStats} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void zzao(com.google.android.gms.common.data.DataHolder r6) {
            /*
                r5 = this;
                int r0 = r6.getStatusCode()
                r1 = 3
                if (r0 == 0) goto L_0x000f
                if (r0 == r1) goto L_0x000f
                com.google.android.gms.tasks.TaskCompletionSource<com.google.android.gms.games.AnnotatedData<com.google.android.gms.games.stats.PlayerStats>> r6 = r5.zzhp
                com.google.android.gms.games.internal.zzg.zza(r6, (int) r0)
                return
            L_0x000f:
                r2 = 0
                com.google.android.gms.games.stats.PlayerStatsBuffer r3 = new com.google.android.gms.games.stats.PlayerStatsBuffer
                r3.<init>(r6)
                int r6 = r3.getCount()     // Catch:{ all -> 0x003a }
                r4 = 0
                if (r6 <= 0) goto L_0x0029
                java.lang.Object r6 = r3.get(r4)     // Catch:{ all -> 0x003a }
                com.google.android.gms.games.stats.PlayerStats r6 = (com.google.android.gms.games.stats.PlayerStats) r6     // Catch:{ all -> 0x003a }
                java.lang.Object r6 = r6.freeze()     // Catch:{ all -> 0x003a }
                r2 = r6
                com.google.android.gms.games.stats.PlayerStats r2 = (com.google.android.gms.games.stats.PlayerStats) r2     // Catch:{ all -> 0x003a }
            L_0x0029:
                r3.close()
                if (r0 != r1) goto L_0x002f
                r4 = 1
            L_0x002f:
                com.google.android.gms.tasks.TaskCompletionSource<com.google.android.gms.games.AnnotatedData<com.google.android.gms.games.stats.PlayerStats>> r6 = r5.zzhp
                com.google.android.gms.games.AnnotatedData r0 = new com.google.android.gms.games.AnnotatedData
                r0.<init>(r2, r4)
                r6.setResult(r0)
                return
            L_0x003a:
                r6 = move-exception
                r3.close()     // Catch:{ all -> 0x003f }
                goto L_0x0043
            L_0x003f:
                r0 = move-exception
                com.google.android.gms.internal.games.zzei.zza(r6, r0)
            L_0x0043:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.zzg.zzal.zzao(com.google.android.gms.common.data.DataHolder):void");
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzam extends zzb {
        private final ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> zzis;

        zzam(ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder) {
            this.zzis = listenerHolder;
        }

        public final void zza(int i, int i2, String str) {
            ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder = this.zzis;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(new zzah(i, i2, str)));
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static abstract class zzan<T> extends zzb {
        private final BaseImplementation.ResultHolder<T> zzit;

        zzan(BaseImplementation.ResultHolder<T> resultHolder) {
            this.zzit = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder, "Holder must not be null");
        }

        /* access modifiers changed from: package-private */
        public final void setResult(T t) {
            this.zzit.setResult(t);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private interface zzao<T> {
        void accept(T t);
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzap extends zzb {
        private final ListenerHolder<? extends RoomUpdateListener> zziv;
        private final ListenerHolder<? extends RoomStatusUpdateListener> zziw;
        private final ListenerHolder<? extends RealTimeMessageReceivedListener> zzix;

        zzap(ListenerHolder<? extends RoomUpdateListener> listenerHolder) {
            this(listenerHolder, (ListenerHolder<? extends RoomStatusUpdateListener>) null, (ListenerHolder<? extends RealTimeMessageReceivedListener>) null);
        }

        public final void onLeftRoom(int i, String str) {
            this.zziv.notifyListener(zzg.zza(new zzas(i, str)));
        }

        public final void onP2PConnected(String str) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(new zzan(str)));
            }
        }

        public final void onP2PDisconnected(String str) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(new zzaq(str)));
            }
        }

        public final void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder = this.zzix;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(new zzap(realTimeMessage)));
            }
        }

        public final void zza(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, zzaj.zziy));
            }
        }

        public final void zzb(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, zzam.zziy));
            }
        }

        public final void zzc(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, zzal.zziy));
            }
        }

        public final void zzd(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, zzao.zziy));
            }
        }

        public final void zze(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, zzay.zziy));
            }
        }

        public final void zzf(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, strArr, zzax.zziy));
            }
        }

        public final void zzs(DataHolder dataHolder) {
            this.zziv.notifyListener(zzg.zza(dataHolder, zzai.zziu));
        }

        public final void zzt(DataHolder dataHolder) {
            this.zziv.notifyListener(zzg.zza(dataHolder, zzak.zziu));
        }

        public final void zzu(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, zzau.zzjb));
            }
        }

        public final void zzv(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, zzat.zzjb));
            }
        }

        public final void zzw(DataHolder dataHolder) {
            this.zziv.notifyListener(zzg.zza(dataHolder, zzar.zziu));
        }

        public final void zzx(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, zzaw.zzjb));
            }
        }

        public final void zzy(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.zziw;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zzg.zza(dataHolder, zzav.zzjb));
            }
        }

        zzap(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3) {
            this.zziv = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callbacks must not be null");
            this.zziw = listenerHolder2;
            this.zzix = listenerHolder3;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private interface zzaq<T> {
        void zza(T t, Room room);
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private interface zzar<T> {
        void zza(T t, Room room, ArrayList<String> arrayList);
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzas extends zzan<Snapshots.LoadSnapshotsResult> {
        zzas(BaseImplementation.ResultHolder<Snapshots.LoadSnapshotsResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzag(DataHolder dataHolder) {
            setResult(new zzag(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzat extends zzan<Snapshots.OpenSnapshotResult> {
        zzat(BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult> resultHolder) {
            super(resultHolder);
        }

        public final void zza(DataHolder dataHolder, Contents contents) {
            setResult(new zzaj(dataHolder, contents));
        }

        public final void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            setResult(new zzaj(dataHolder, str, contents, contents2, contents3));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzau extends zzn implements Leaderboards.SubmitScoreResult {
        private final ScoreSubmissionData zzjc;

        zzau(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzjc = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public final ScoreSubmissionData getScoreData() {
            return this.zzjc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private interface zzav<T> {
        void zza(T t, int i, Room room);
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzaw extends zzan<TurnBasedMultiplayer.LeaveMatchResult> {
        zzaw(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzq(DataHolder dataHolder) {
            setResult(new zzv(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzax extends zzan<TurnBasedMultiplayer.InitiateMatchResult> {
        zzax(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzo(DataHolder dataHolder) {
            setResult(new zzp(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzay extends zzan<TurnBasedMultiplayer.UpdateMatchResult> {
        zzay(BaseImplementation.ResultHolder<TurnBasedMultiplayer.UpdateMatchResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzp(DataHolder dataHolder) {
            setResult(new zzbc(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static abstract class zzaz extends zzn {
        private final TurnBasedMatch match;

        zzaz(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.match = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.match = null;
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.match;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzb extends zzan<Achievements.UpdateAchievementResult> {
        zzb(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzb(int i, String str) {
            setResult(new zzba(i, str));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzba implements Achievements.UpdateAchievementResult {
        private final String zzfe;
        private final Status zzhq;

        zzba(int i, String str) {
            this.zzhq = GamesStatusCodes.zza(i);
            this.zzfe = str;
        }

        public final String getAchievementId() {
            return this.zzfe;
        }

        public final Status getStatus() {
            return this.zzhq;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzbb extends zzan<TurnBasedMultiplayer.LoadMatchesResult> {
        zzbb(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchesResult> resultHolder) {
            super(resultHolder);
        }

        public final void zza(int i, Bundle bundle) {
            bundle.setClassLoader(zzbb.class.getClassLoader());
            setResult(new zzad(GamesStatusCodes.zza(i), bundle));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzbc extends zzaz implements TurnBasedMultiplayer.UpdateMatchResult {
        zzbc(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzc extends zzb {
        private final TaskCompletionSource<AnnotatedData<AchievementBuffer>> zzhp;

        zzc(TaskCompletionSource<AnnotatedData<AchievementBuffer>> taskCompletionSource) {
            this.zzhp = taskCompletionSource;
        }

        public final void zza(DataHolder dataHolder) {
            int statusCode = dataHolder.getStatusCode();
            if (statusCode == 0 || statusCode == 3) {
                this.zzhp.setResult(new AnnotatedData(new AchievementBuffer(dataHolder), statusCode == 3));
            } else {
                zzg.zza(this.zzhp, statusCode);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzd extends zzb {
        private final TaskCompletionSource<Void> zzhp;

        zzd(TaskCompletionSource<Void> taskCompletionSource) {
            this.zzhp = taskCompletionSource;
        }

        public final void zzb(int i, String str) {
            if (i == 0 || i == 3003) {
                this.zzhp.setResult(null);
            } else {
                zzg.zza(this.zzhp, i);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zze implements Videos.CaptureAvailableResult {
        private final Status zzhq;
        private final boolean zzhr;

        zze(Status status, boolean z) {
            this.zzhq = status;
            this.zzhr = z;
        }

        public final Status getStatus() {
            return this.zzhq;
        }

        public final boolean isAvailable() {
            return this.zzhr;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzf implements TurnBasedMultiplayer.CancelMatchResult {
        private final Status zzhq;
        private final String zzhs;

        zzf(Status status, String str) {
            this.zzhq = status;
            this.zzhs = str;
        }

        public final String getMatchId() {
            return this.zzhs;
        }

        public final Status getStatus() {
            return this.zzhq;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.zzg$zzg  reason: collision with other inner class name */
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class C6821zzg implements Videos.CaptureStateResult {
        private final Status zzhq;
        private final CaptureState zzht;

        C6821zzg(Status status, CaptureState captureState) {
            this.zzhq = status;
            this.zzht = captureState;
        }

        public final CaptureState getCaptureState() {
            return this.zzht;
        }

        public final Status getStatus() {
            return this.zzhq;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzh implements Videos.CaptureCapabilitiesResult {
        private final Status zzhq;
        private final VideoCapabilities zzhu;

        zzh(Status status, VideoCapabilities videoCapabilities) {
            this.zzhq = status;
            this.zzhu = videoCapabilities;
        }

        public final VideoCapabilities getCapabilities() {
            return this.zzhu;
        }

        public final Status getStatus() {
            return this.zzhq;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzi implements Snapshots.DeleteSnapshotResult {
        private final Status zzhq;
        private final String zzhv;

        zzi(int i, String str) {
            this.zzhq = GamesStatusCodes.zza(i);
            this.zzhv = str;
        }

        public final String getSnapshotId() {
            return this.zzhv;
        }

        public final Status getStatus() {
            return this.zzhq;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzj extends zzn implements Snapshots.CommitSnapshotResult {
        private final SnapshotMetadata zzhw;

        zzj(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzhw = new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0));
                } else {
                    this.zzhw = null;
                }
            } finally {
                snapshotMetadataBuffer.release();
            }
        }

        public final SnapshotMetadata getSnapshotMetadata() {
            return this.zzhw;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private class zzk extends zzed {
        zzk() {
            super(zzg.this.getContext().getMainLooper(), 1000);
        }

        /* access modifiers changed from: protected */
        public final void zzf(String str, int i) {
            try {
                if (zzg.this.isConnected()) {
                    ((zzbr) zzg.this.getService()).zza(str, i);
                    return;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 89);
                sb.append("Unable to increment event ");
                sb.append(str);
                sb.append(" by ");
                sb.append(i);
                sb.append(" because the games client is no longer connected");
                zzaz.m10156e("GamesGmsClientImpl", sb.toString());
            } catch (RemoteException e) {
                zzg.zza(e);
            } catch (SecurityException e2) {
                zzg.zza(e2);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzl extends zzan<C3093Events.LoadEventsResult> {
        zzl(BaseImplementation.ResultHolder<C3093Events.LoadEventsResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzb(DataHolder dataHolder) {
            setResult(new zzz(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzm implements Games.GetServerAuthCodeResult {
        private final Status zzhq;
        private final String zzhx;

        zzm(Status status, String str) {
            this.zzhq = status;
            this.zzhx = str;
        }

        public final String getCode() {
            return this.zzhx;
        }

        public final Status getStatus() {
            return this.zzhq;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static abstract class zzn extends DataHolderResult {
        zzn(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zza(dataHolder.getStatusCode()));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzo extends zzu<OnInvitationReceivedListener> {
        zzo(ListenerHolder<OnInvitationReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        public final void onInvitationRemoved(String str) {
            zzc(new zzad(str));
        }

        public final void zzl(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            try {
                Invitation invitation = invitationBuffer.getCount() > 0 ? (Invitation) ((Invitation) invitationBuffer.get(0)).freeze() : null;
                if (invitation != null) {
                    zzc(new zzae(invitation));
                }
            } finally {
                invitationBuffer.release();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzp extends zzaz implements TurnBasedMultiplayer.InitiateMatchResult {
        zzp(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzq extends zzn implements Leaderboards.LeaderboardMetadataResult {
        private final LeaderboardBuffer zzia;

        zzq(DataHolder dataHolder) {
            super(dataHolder);
            this.zzia = new LeaderboardBuffer(dataHolder);
        }

        public final LeaderboardBuffer getLeaderboards() {
            return this.zzia;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzr extends zzan<Invitations.LoadInvitationsResult> {
        zzr(BaseImplementation.ResultHolder<Invitations.LoadInvitationsResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzk(DataHolder dataHolder) {
            setResult(new zzab(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzs extends zzan<Leaderboards.LeaderboardMetadataResult> {
        zzs(BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult> resultHolder) {
            super(resultHolder);
        }

        public final void zzc(DataHolder dataHolder) {
            setResult(new zzq(dataHolder));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzt extends zzan<Leaderboards.LoadScoresResult> {
        zzt(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder) {
            super(resultHolder);
        }

        public final void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            setResult(new zzah(dataHolder, dataHolder2));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static abstract class zzu<T> extends zzb {
        private final ListenerHolder<T> zzib;

        zzu(ListenerHolder<T> listenerHolder) {
            this.zzib = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callback must not be null");
        }

        /* access modifiers changed from: package-private */
        public final void zzc(zzao<T> zzao) {
            this.zzib.notifyListener(zzg.zza(zzao));
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzv extends zzaz implements TurnBasedMultiplayer.LeaveMatchResult {
        zzv(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzw extends zzn implements Achievements.LoadAchievementsResult {
        private final AchievementBuffer zzic;

        zzw(DataHolder dataHolder) {
            super(dataHolder);
            this.zzic = new AchievementBuffer(dataHolder);
        }

        public final AchievementBuffer getAchievements() {
            return this.zzic;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static abstract class zzx<T> implements ListenerHolder.Notifier<T> {
        private zzx() {
        }

        public void onNotifyListenerFailed() {
        }

        /* synthetic */ zzx(zzf zzf) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzy extends zzn implements GamesMetadata.LoadGamesResult {
        private final GameBuffer zzid;

        zzy(DataHolder dataHolder) {
            super(dataHolder);
            this.zzid = new GameBuffer(dataHolder);
        }

        public final GameBuffer getGames() {
            return this.zzid;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static final class zzz extends zzn implements C3093Events.LoadEventsResult {
        private final EventBuffer zzie;

        zzz(DataHolder dataHolder) {
            super(dataHolder);
            this.zzie = new EventBuffer(dataHolder);
        }

        public final EventBuffer getEvents() {
            return this.zzie;
        }
    }

    public zzg(Context context, Looper looper, ClientSettings clientSettings, Games.GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzgw = clientSettings.getRealClientPackageName();
        this.zzhb = new Binder();
        this.zzgz = zzbv.zza(this, clientSettings.getGravityForPopups());
        this.zzhc = (long) hashCode();
        this.zzhe = gamesOptions;
        if (gamesOptions.zzau) {
            return;
        }
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            zza(clientSettings.getViewForPopups());
        }
    }

    /* access modifiers changed from: private */
    public static Room zzay(DataHolder dataHolder) {
        com.google.android.gms.games.multiplayer.realtime.zzb zzb2 = new com.google.android.gms.games.multiplayer.realtime.zzb(dataHolder);
        try {
            return zzb2.getCount() > 0 ? (Room) ((Room) zzb2.get(0)).freeze() : null;
        } finally {
            zzb2.release();
        }
    }

    public void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzgx = null;
        this.zzgy = null;
        super.connect(connectionProgressReportCallbacks);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        if (queryLocalInterface instanceof zzbr) {
            return (zzbr) queryLocalInterface;
        }
        return new zzbq(iBinder);
    }

    public void disconnect() {
        this.zzha = false;
        if (isConnected()) {
            try {
                zzbr zzbr = (zzbr) getService();
                zzbr.zzcl();
                this.zzgv.flush();
                zzbr.zza(this.zzhc);
            } catch (RemoteException unused) {
                zzaz.m10159w("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public Bundle getConnectionHint() {
        try {
            Bundle connectionHint = ((zzbr) getService()).getConnectionHint();
            if (connectionHint != null) {
                connectionHint.setClassLoader(zzg.class.getClassLoader());
                this.zzhf = connectionHint;
            }
            return connectionHint;
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Bundle getGetServiceRequestExtraArgs() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzg = this.zzhe.zzg();
        zzg.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, this.zzgw);
        zzg.putString(ServiceSpecificExtraArgs.GamesExtraArgs.DESIRED_LOCALE, locale);
        zzg.putParcelable(ServiceSpecificExtraArgs.GamesExtraArgs.WINDOW_TOKEN, new BinderWrapper(this.zzgz.zzcr()));
        zzg.putInt("com.google.android.gms.games.key.API_VERSION", 6);
        zzg.putBundle(ServiceSpecificExtraArgs.GamesExtraArgs.SIGNIN_OPTIONS, SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return zzg;
    }

    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return getScopes();
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    public /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        zzbr zzbr = (zzbr) iInterface;
        super.onConnectedLocked(zzbr);
        if (this.zzha) {
            this.zzgz.zzct();
            this.zzha = false;
        }
        Games.GamesOptions gamesOptions = this.zzhe;
        if (!gamesOptions.zzan && !gamesOptions.zzau) {
            try {
                zzbr.zza((zzbp) new zzp(new zzbt(this.zzgz.zzcs())), this.zzhc);
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzha = false;
    }

    /* access modifiers changed from: protected */
    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(zzg.class.getClassLoader());
            boolean z = bundle.getBoolean("show_welcome_popup");
            this.zzha = z;
            this.zzhd = z;
            this.zzgx = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzgy = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.onPostInitHandler(i, iBinder, bundle, i2);
    }

    public void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzb((BaseImplementation.ResultHolder<Status>) new zzab(signOutCallbacks));
        } catch (RemoteException unused) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    public boolean requiresAccount() {
        return true;
    }

    public boolean requiresSignIn() {
        return this.zzhe.zzax == null;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> validateScopes(Set<Scope> set) {
        HashSet hashSet = new HashSet(set);
        boolean contains = set.contains(Games.SCOPE_GAMES);
        boolean contains2 = set.contains(Games.SCOPE_GAMES_LITE);
        if (set.contains(Games.zzai)) {
            Preconditions.checkState(!contains, "Cannot have both %s and %s!", Scopes.GAMES, FirstPartyScopes.GAMES_1P);
        } else {
            Preconditions.checkState(contains || contains2, "Games APIs requires %s function.", Scopes.GAMES_LITE);
            if (contains2 && contains) {
                hashSet.remove(Games.SCOPE_GAMES_LITE);
            }
        }
        return hashSet;
    }

    public final void zza(View view) {
        this.zzgz.zzb(view);
    }

    public final String zzb(boolean z) {
        try {
            return zza(true);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Bundle zzbb() {
        Bundle connectionHint = getConnectionHint();
        if (connectionHint == null) {
            connectionHint = this.zzhf;
        }
        this.zzhf = null;
        return connectionHint;
    }

    public final String zzbc() throws RemoteException {
        return ((zzbr) getService()).zzbc();
    }

    public final String zzbd() {
        try {
            return zzbc();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final Player zzbe() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzgx == null) {
                PlayerBuffer playerBuffer = new PlayerBuffer(((zzbr) getService()).zzcn());
                try {
                    if (playerBuffer.getCount() > 0) {
                        this.zzgx = (PlayerEntity) ((Player) playerBuffer.get(0)).freeze();
                    }
                    playerBuffer.release();
                } catch (Throwable th) {
                    playerBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzgx;
    }

    public final Player zzbf() {
        try {
            return zzbe();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final Game zzbg() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzgy == null) {
                GameBuffer gameBuffer = new GameBuffer(((zzbr) getService()).zzco());
                try {
                    if (gameBuffer.getCount() > 0) {
                        this.zzgy = (GameEntity) ((Game) gameBuffer.get(0)).freeze();
                    }
                    gameBuffer.release();
                } catch (Throwable th) {
                    gameBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzgy;
    }

    public final Game zzbh() {
        try {
            return zzbg();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbi() throws RemoteException {
        return ((zzbr) getService()).zzbi();
    }

    public final Intent zzbj() {
        try {
            return zzbi();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbk() {
        try {
            return ((zzbr) getService()).zzbk();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbl() {
        try {
            return ((zzbr) getService()).zzbl();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbm() {
        try {
            return ((zzbr) getService()).zzbm();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzbn() throws RemoteException {
        ((zzbr) getService()).zzb(this.zzhc);
    }

    public final void zzbo() {
        try {
            zzbn();
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzbp() throws RemoteException {
        ((zzbr) getService()).zzc(this.zzhc);
    }

    public final void zzbq() {
        try {
            zzbp();
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final Intent zzbr() throws RemoteException {
        return ((zzbr) getService()).zzbr();
    }

    public final Intent zzbs() {
        try {
            return zzbr();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final Intent zzbt() throws RemoteException {
        return ((zzbr) getService()).zzbt();
    }

    public final Intent zzbu() {
        try {
            return zzbt();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final int zzbv() throws RemoteException {
        return ((zzbr) getService()).zzbv();
    }

    public final int zzbw() {
        try {
            return zzbv();
        } catch (RemoteException e) {
            zza(e);
            return 4368;
        }
    }

    public final String zzbx() throws RemoteException {
        return ((zzbr) getService()).zzbx();
    }

    public final String zzby() {
        try {
            return zzbx();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final int zzbz() throws RemoteException {
        return ((zzbr) getService()).zzbz();
    }

    public final void zzc(BaseImplementation.ResultHolder<Achievements.LoadAchievementsResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzz(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final int zzca() {
        try {
            return zzbz();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zzcb() throws RemoteException {
        return ((zzbr) getService()).zzcb();
    }

    public final int zzcc() {
        try {
            return zzcb();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zzcd() throws RemoteException {
        return ((zzbr) getService()).zzcd();
    }

    public final int zzce() {
        try {
            return zzcd();
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final Intent zzcf() throws RemoteException {
        return ((zzbr) getService()).zzcp();
    }

    public final Intent zzcg() {
        try {
            return zzcf();
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final boolean zzch() throws RemoteException {
        return ((zzbr) getService()).zzch();
    }

    public final boolean zzci() {
        try {
            return zzch();
        } catch (RemoteException e) {
            zza(e);
            return false;
        }
    }

    public final void zzcj() throws RemoteException {
        ((zzbr) getService()).zzd(this.zzhc);
    }

    public final void zzck() {
        try {
            zzcj();
        } catch (RemoteException e) {
            zza(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzcl() {
        if (isConnected()) {
            try {
                ((zzbr) getService()).zzcl();
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    public final void zzd(BaseImplementation.ResultHolder<C3093Events.LoadEventsResult> resultHolder, boolean z) throws RemoteException {
        this.zzgv.flush();
        try {
            ((zzbr) getService()).zze((zzbn) new zzl(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zze(String str, int i) {
        try {
            zzd(str, i);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzf(BaseImplementation.ResultHolder<TurnBasedMultiplayer.CancelMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzd((zzbn) new zzh(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzg(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzf((zzbn) new zzk(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzh(BaseImplementation.ResultHolder<Snapshots.DeleteSnapshotResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzg(new zzl(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzm(int i) {
        this.zzgz.setGravity(i);
    }

    public final void zzn(int i) throws RemoteException {
        ((zzbr) getService()).zzn(i);
    }

    public final void zzo(int i) {
        try {
            zzn(i);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zza(String str, BaseImplementation.ResultHolder<Games.GetServerAuthCodeResult> resultHolder) throws RemoteException {
        Preconditions.checkNotEmpty(str, "Please provide a valid serverClientId");
        try {
            ((zzbr) getService()).zza(str, (zzbn) new zzy(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzb((zzbn) new zzs(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zze(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zze((zzbn) new zzaw(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzd(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) {
        try {
            zzc(listenerHolder);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzc(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) throws RemoteException {
        ((zzbr) getService()).zzb((zzbn) new zzai(listenerHolder), this.zzhc);
    }

    public final void zzf(BaseImplementation.ResultHolder<Snapshots.LoadSnapshotsResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzd((zzbn) new zzas(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult> resultHolder, String str, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzs(resultHolder), str, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzd(String str, int i) throws RemoteException {
        ((zzbr) getService()).zzd(str, i);
    }

    public final void zze(BaseImplementation.ResultHolder<Stats.LoadPlayerStatsResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzf((zzbn) new zzj(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final String zza(boolean z) throws RemoteException {
        PlayerEntity playerEntity = this.zzgx;
        if (playerEntity != null) {
            return playerEntity.getPlayerId();
        }
        return ((zzbr) getService()).zzcm();
    }

    public final void zzc(String str, int i) {
        try {
            zzb(str, i);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzd(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzc((zzbn) new zzax(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzf(ListenerHolder<Videos.CaptureOverlayStateListener> listenerHolder) {
        try {
            zze(listenerHolder);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(new zzt(resultHolder), str, i, i2, i3, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzc(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzb((zzbn) new zzax(resultHolder), str);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, String str, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzb((zzbn) new zzak(resultHolder), str, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzd(String str) {
        try {
            zzc(str);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zze(ListenerHolder<Videos.CaptureOverlayStateListener> listenerHolder) throws RemoteException {
        ((zzbr) getService()).zzc((zzbn) new zzs(listenerHolder), this.zzhc);
    }

    public final void zzb(TaskCompletionSource<Void> taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(taskCompletionSource == null ? null : new zzd(taskCompletionSource), str, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zzc(String str) throws RemoteException {
        ((zzbr) getService()).zze(str);
    }

    public final Intent zzd(int i, int i2, boolean z) {
        try {
            return zzc(i, i2, z);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, int i, boolean z, boolean z2) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzak(resultHolder), i, z, z2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzc(int i, int i2, boolean z) throws RemoteException {
        return ((zzbr) getService()).zzc(i, i2, z);
    }

    public final void zzc(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) throws RemoteException {
        ((zzbr) getService()).zza((zzbn) new zzap(listenerHolder, listenerHolder2, listenerHolder3), (IBinder) this.zzhb, roomConfig.getInvitationId(), false, this.zzhc);
    }

    public final void zzd(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) {
        try {
            zzc(listenerHolder, listenerHolder2, listenerHolder3, roomConfig);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, String str, int i, boolean z, boolean z2) throws RemoteException {
        if (str.equals("played_with") || str.equals(PlayersClient.zzdc)) {
            try {
                ((zzbr) getService()).zza((zzbn) new zzak(resultHolder), str, i, z, z2);
            } catch (SecurityException e) {
                zza(resultHolder, e);
            }
        } else {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid player collection: ".concat(valueOf) : new String("Invalid player collection: "));
        }
    }

    public final void zzd(BaseImplementation.ResultHolder<Videos.CaptureStateResult> resultHolder) throws RemoteException {
        try {
            ((zzbr) getService()).zzd((zzbn) new zzn(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(resultHolder == null ? null : new zzb(resultHolder), str, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzc(BaseImplementation.ResultHolder<Videos.CaptureCapabilitiesResult> resultHolder) throws RemoteException {
        try {
            ((zzbr) getService()).zzc((zzbn) new zzo(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzc((zzbn) new zzak(resultHolder), z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(TaskCompletionSource<Boolean> taskCompletionSource, String str, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(taskCompletionSource == null ? null : new zza(taskCompletionSource), str, i, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final Intent zza(String str, int i, int i2) {
        try {
            return ((zzbr) getService()).zzb(str, i, i2);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.LoadPlayerScoreResult> resultHolder, String str, String str2, int i, int i2) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzx(resultHolder), (String) null, str2, i, i2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zzb(resultHolder == null ? null : new zzb(resultHolder), str, i, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zza(new zzt(resultHolder), str, i, i2, i3, z);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzt(resultHolder), leaderboardScoreBuffer.zzdk().zzdj(), i, i2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ListenerHolder<OnInvitationReceivedListener> listenerHolder) {
        try {
            zza(listenerHolder);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final Intent zzb(PlayerEntity playerEntity) {
        try {
            return zza(playerEntity);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.SubmitScoreResult> resultHolder, String str, long j, String str2) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) resultHolder == null ? null : new zzaa(resultHolder), str, j, str2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zzb(Room room, int i) {
        try {
            return zza(room, i);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(TaskCompletionSource<AnnotatedData<AchievementBuffer>> taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzc(taskCompletionSource), z);
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Status> resultHolder) throws RemoteException {
        this.zzgv.flush();
        try {
            ((zzbr) getService()).zza((zzbn) new zzi(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(TaskCompletionSource<Void> taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) taskCompletionSource == null ? null : new zzd(taskCompletionSource), str, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zzb(String str, int i) throws RemoteException {
        ((zzbr) getService()).zzb(str, i);
    }

    public final Intent zzb(int i, int i2, boolean z) {
        try {
            return zza(i, i2, z);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) resultHolder == null ? null : new zzb(resultHolder), str, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) {
        try {
            zza(listenerHolder, listenerHolder2, listenerHolder3, roomConfig);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final int zzb(ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder, byte[] bArr, String str, String str2) {
        try {
            return zza(listenerHolder, bArr, str, str2);
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zzb(byte[] bArr, String str) {
        try {
            return zza(bArr, str);
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final void zza(TaskCompletionSource<Boolean> taskCompletionSource, String str, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) taskCompletionSource == null ? null : new zza(taskCompletionSource), str, i, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final void zzb(TaskCompletionSource<AnnotatedData<PlayerStats>> taskCompletionSource, boolean z) throws RemoteException {
        try {
            ((zzbr) getService()).zzf((zzbn) new zzal(taskCompletionSource), z);
        } catch (SecurityException e) {
            zza(taskCompletionSource, e);
        }
    }

    public final Intent zzb(String str, boolean z, boolean z2, int i) {
        try {
            return zza(str, z, z2, i);
        } catch (RemoteException e) {
            zza(e);
            return null;
        }
    }

    public final void zzb(Snapshot snapshot) {
        try {
            zza(snapshot);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) resultHolder == null ? null : new zzb(resultHolder), str, i, this.zzgz.zzcr(), this.zzgz.zzcq());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Videos.CaptureAvailableResult> resultHolder, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zzb((zzbn) new zzq(resultHolder), i);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<C3093Events.LoadEventsResult> resultHolder, boolean z, String... strArr) throws RemoteException {
        this.zzgv.flush();
        try {
            ((zzbr) getService()).zza((zzbn) new zzl(resultHolder), z, strArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(String str, int i) {
        this.zzgv.zza(str, i);
    }

    public final void zza(ListenerHolder<OnInvitationReceivedListener> listenerHolder) throws RemoteException {
        ((zzbr) getService()).zza((zzbn) new zzo(listenerHolder), this.zzhc);
    }

    public final Intent zza(PlayerEntity playerEntity) throws RemoteException {
        return ((zzbr) getService()).zza(playerEntity);
    }

    public final Intent zza(Room room, int i) throws RemoteException {
        return ((zzbr) getService()).zza((RoomEntity) room.freeze(), i);
    }

    public final void zza(BaseImplementation.ResultHolder<GamesMetadata.LoadGamesResult> resultHolder) throws RemoteException {
        try {
            ((zzbr) getService()).zzb((zzbn) new zzac(resultHolder));
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Invitations.LoadInvitationsResult> resultHolder, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzr(resultHolder), i);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final Intent zza(int i, int i2, boolean z) throws RemoteException {
        return ((zzbr) getService()).zza(i, i2, z);
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzax(resultHolder), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzdq(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.UpdateMatchResult> resultHolder, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzay(resultHolder), str, bArr, str2, participantResultArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.UpdateMatchResult> resultHolder, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzay(resultHolder), str, bArr, participantResultArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult> resultHolder, String str, String str2) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzaw(resultHolder), str, str2);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchesResult> resultHolder, int i, int[] iArr) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzbb(resultHolder), i, iArr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) throws RemoteException {
        ((zzbr) getService()).zza(new zzap(listenerHolder, listenerHolder2, listenerHolder3), this.zzhb, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzhc);
    }

    public final void zza(ListenerHolder<? extends RoomUpdateListener> listenerHolder, String str) {
        try {
            ((zzbr) getService()).zza((zzbn) new zzap(listenerHolder), str);
        } catch (RemoteException e) {
            zza(e);
        }
    }

    public final int zza(ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder, byte[] bArr, String str, String str2) throws RemoteException {
        return ((zzbr) getService()).zza((zzbn) new zzam(listenerHolder), bArr, str, str2);
    }

    public final int zza(byte[] bArr, String str, String[] strArr) {
        Preconditions.checkNotNull(strArr, "Participant IDs must not be null");
        try {
            Preconditions.checkNotNull(strArr, "Participant IDs must not be null");
            return ((zzbr) getService()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zza(e);
            return -1;
        }
    }

    public final int zza(byte[] bArr, String str) throws RemoteException {
        return ((zzbr) getService()).zzb(bArr, str, (String[]) null);
    }

    public final Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException {
        return ((zzbr) getService()).zza(str, z, z2, i);
    }

    public final void zza(BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult> resultHolder, String str, boolean z, int i) throws RemoteException {
        try {
            ((zzbr) getService()).zza((zzbn) new zzat(resultHolder), str, z, i);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Snapshots.CommitSnapshotResult> resultHolder, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zzds = snapshotMetadataChange.zzds();
        if (zzds != null) {
            zzds.setTempDir(getContext().getCacheDir());
        }
        Contents zzdr = snapshotContents.zzdr();
        snapshotContents.close();
        try {
            ((zzbr) getService()).zza((zzbn) new zzm(resultHolder), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzdr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    public final void zza(Snapshot snapshot) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents zzdr = snapshotContents.zzdr();
        snapshotContents.close();
        ((zzbr) getService()).zza(zzdr);
    }

    public final void zza(BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult> resultHolder, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter zzds = snapshotMetadataChange.zzds();
        if (zzds != null) {
            zzds.setTempDir(getContext().getCacheDir());
        }
        Contents zzdr = snapshotContents.zzdr();
        snapshotContents.close();
        try {
            ((zzbr) getService()).zza((zzbn) new zzat(resultHolder), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzdr);
        } catch (SecurityException e) {
            zza(resultHolder, e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((zzbr) getService()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zza(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void zza(RemoteException remoteException) {
        zzaz.m10160w("GamesGmsClientImpl", "service died", remoteException);
    }

    /* access modifiers changed from: private */
    public static void zza(SecurityException securityException) {
        zzaz.m10157e("GamesGmsClientImpl", "Is player signed out?", securityException);
    }

    private static <R> void zza(BaseImplementation.ResultHolder<R> resultHolder, SecurityException securityException) {
        if (resultHolder != null) {
            resultHolder.setFailedResult(GamesClientStatusCodes.zza(4));
        }
    }

    private static <R> void zza(TaskCompletionSource<R> taskCompletionSource, SecurityException securityException) {
        if (taskCompletionSource != null) {
            taskCompletionSource.setException(new ApiException(GamesClientStatusCodes.zza(4)));
        }
    }

    /* access modifiers changed from: private */
    public static <R> void zza(TaskCompletionSource<R> taskCompletionSource, int i) {
        taskCompletionSource.setException(ApiExceptionUtil.fromStatus(GamesClientStatusCodes.zza(GamesStatusCodes.zza(i))));
    }

    /* access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> zza(zzao<T> zzao2) {
        return new zzu(zzao2);
    }

    /* access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> zza(DataHolder dataHolder, zzaq<T> zzaq2) {
        return new zzt(zzaq2, dataHolder);
    }

    /* access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> zza(DataHolder dataHolder, String[] strArr, zzar<T> zzar2) {
        return new zzw(zzar2, dataHolder, new ArrayList(Arrays.asList(strArr)));
    }

    /* access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> zza(DataHolder dataHolder, zzav<T> zzav2) {
        return new zzv(zzav2, dataHolder);
    }
}
