package com.google.android.gms.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.zzm;
import com.google.android.gms.games.event.C3093Events;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzae;
import com.google.android.gms.internal.games.zzaf;
import com.google.android.gms.internal.games.zzan;
import com.google.android.gms.internal.games.zzaw;
import com.google.android.gms.internal.games.zzba;
import com.google.android.gms.internal.games.zzbp;
import com.google.android.gms.internal.games.zzbq;
import com.google.android.gms.internal.games.zzbs;
import com.google.android.gms.internal.games.zzbu;
import com.google.android.gms.internal.games.zzcd;
import com.google.android.gms.internal.games.zzce;
import com.google.android.gms.internal.games.zzcr;
import com.google.android.gms.internal.games.zzcv;
import com.google.android.gms.internal.games.zzdu;
import com.google.android.gms.internal.games.zze;
import com.google.android.gms.internal.games.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class Games {
    @Deprecated
    public static final Api<GamesOptions> API = new Api<>("Games.API", zzag, CLIENT_KEY);
    @Deprecated
    public static final Achievements Achievements = new zzq();
    static final Api.ClientKey<zzg> CLIENT_KEY = new Api.ClientKey<>();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    @Deprecated
    public static final C3093Events Events = new zzaf();
    @Deprecated
    public static final GamesMetadata GamesMetadata = new zzan();
    @Deprecated
    public static final Invitations Invitations = new zzaw();
    @Deprecated
    public static final Leaderboards Leaderboards = new zzba();
    @Deprecated
    public static final Notifications Notifications = new zzbp();
    @Deprecated
    public static final Players Players = new zzbu();
    @Deprecated
    public static final RealTimeMultiplayer RealTimeMultiplayer = new zzce();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Scope SCOPE_GAMES_LITE = new Scope(Scopes.GAMES_LITE);
    public static final Scope SCOPE_GAMES_SNAPSHOTS = new Scope(Scopes.DRIVE_APPFOLDER);
    @Deprecated
    public static final Snapshots Snapshots = new zzcd();
    @Deprecated
    public static final Stats Stats = new zzcr();
    @Deprecated
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new zzcv();
    @Deprecated
    public static final Videos Videos = new zzdu();
    private static final Api.AbstractClientBuilder<zzg, GamesOptions> zzag = new zze();
    private static final Api.AbstractClientBuilder<zzg, GamesOptions> zzah = new zzd();
    @ShowFirstParty
    public static final Scope zzai = new Scope(FirstPartyScopes.GAMES_1P);
    @ShowFirstParty
    private static final Api<GamesOptions> zzaj = new Api<>("Games.API_1P", zzah, CLIENT_KEY);
    private static final zzm zzak = new zzae();
    private static final Multiplayer zzal = new zzbq();

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public static final class GamesOptions implements GoogleSignInOptionsExtension, Api.ApiOptions.HasGoogleSignInAccountOptions, Api.ApiOptions.Optional {
        public final boolean zzan;
        public final boolean zzao;
        public final int zzap;
        public final boolean zzaq;
        public final int zzar;
        public final String zzas;
        public final ArrayList<String> zzat;
        public final boolean zzau;
        public final boolean zzav;
        public final GoogleSignInAccount zzaw;
        public final String zzax;
        /* access modifiers changed from: private */
        public final int zzay;

        private GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList<String> arrayList, boolean z4, boolean z5, GoogleSignInAccount googleSignInAccount, String str2, int i3) {
            this.zzan = z;
            this.zzao = z2;
            this.zzap = i;
            this.zzaq = z3;
            this.zzar = i2;
            this.zzas = str;
            this.zzat = arrayList;
            this.zzau = z4;
            this.zzav = z5;
            this.zzaw = googleSignInAccount;
            this.zzax = str2;
            this.zzay = i3;
        }

        public static Builder builder() {
            return new Builder((zze) null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
            r1 = r4.zzas;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
            r1 = r4.zzaw;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                if (r5 != r4) goto L_0x0004
                return r0
            L_0x0004:
                boolean r1 = r5 instanceof com.google.android.gms.games.Games.GamesOptions
                r2 = 0
                if (r1 != 0) goto L_0x000a
                return r2
            L_0x000a:
                com.google.android.gms.games.Games$GamesOptions r5 = (com.google.android.gms.games.Games.GamesOptions) r5
                boolean r1 = r4.zzan
                boolean r3 = r5.zzan
                if (r1 != r3) goto L_0x0073
                boolean r1 = r4.zzao
                boolean r3 = r5.zzao
                if (r1 != r3) goto L_0x0073
                int r1 = r4.zzap
                int r3 = r5.zzap
                if (r1 != r3) goto L_0x0073
                boolean r1 = r4.zzaq
                boolean r3 = r5.zzaq
                if (r1 != r3) goto L_0x0073
                int r1 = r4.zzar
                int r3 = r5.zzar
                if (r1 != r3) goto L_0x0073
                java.lang.String r1 = r4.zzas
                if (r1 != 0) goto L_0x0033
                java.lang.String r1 = r5.zzas
                if (r1 != 0) goto L_0x0073
                goto L_0x003b
            L_0x0033:
                java.lang.String r3 = r5.zzas
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x0073
            L_0x003b:
                java.util.ArrayList<java.lang.String> r1 = r4.zzat
                java.util.ArrayList<java.lang.String> r3 = r5.zzat
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x0073
                boolean r1 = r4.zzau
                boolean r3 = r5.zzau
                if (r1 != r3) goto L_0x0073
                boolean r1 = r4.zzav
                boolean r3 = r5.zzav
                if (r1 != r3) goto L_0x0073
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r4.zzaw
                if (r1 != 0) goto L_0x005a
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r5.zzaw
                if (r1 != 0) goto L_0x0073
                goto L_0x0062
            L_0x005a:
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r3 = r5.zzaw
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x0073
            L_0x0062:
                java.lang.String r1 = r4.zzax
                java.lang.String r3 = r5.zzax
                boolean r1 = android.text.TextUtils.equals(r1, r3)
                if (r1 == 0) goto L_0x0073
                int r1 = r4.zzay
                int r5 = r5.zzay
                if (r1 != r5) goto L_0x0073
                return r0
            L_0x0073:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.Games.GamesOptions.equals(java.lang.Object):boolean");
        }

        public final int getExtensionType() {
            return 1;
        }

        public final GoogleSignInAccount getGoogleSignInAccount() {
            return this.zzaw;
        }

        public final List<Scope> getImpliedScopes() {
            return Collections.singletonList(Games.SCOPE_GAMES_LITE);
        }

        public final int hashCode() {
            int i = ((((((((((this.zzan ? 1 : 0) + true) * 31) + (this.zzao ? 1 : 0)) * 31) + this.zzap) * 31) + (this.zzaq ? 1 : 0)) * 31) + this.zzar) * 31;
            String str = this.zzas;
            int i2 = 0;
            int hashCode = (((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.zzat.hashCode()) * 31) + (this.zzau ? 1 : 0)) * 31) + (this.zzav ? 1 : 0)) * 31;
            GoogleSignInAccount googleSignInAccount = this.zzaw;
            int hashCode2 = (hashCode + (googleSignInAccount == null ? 0 : googleSignInAccount.hashCode())) * 31;
            String str2 = this.zzax;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return ((hashCode2 + i2) * 31) + this.zzay;
        }

        public final Bundle toBundle() {
            return zzg();
        }

        public final Bundle zzg() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzan);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzao);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzap);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzaq);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzar);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzas);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzat);
            bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", this.zzau);
            bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", this.zzav);
            bundle.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzaw);
            bundle.putString("com.google.android.gms.games.key.realClientPackageName", this.zzax);
            return bundle;
        }

        /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
        public static final class Builder {
            private static final AtomicInteger zzaz = new AtomicInteger(0);
            private boolean zzan;
            private boolean zzao;
            private int zzap;
            private boolean zzaq;
            private int zzar;
            private String zzas;
            private ArrayList<String> zzat;
            private boolean zzau;
            private boolean zzav;
            GoogleSignInAccount zzaw;
            private String zzax;
            private int zzay;

            private Builder() {
                this.zzan = false;
                this.zzao = true;
                this.zzap = 17;
                this.zzaq = false;
                this.zzar = 4368;
                this.zzas = null;
                this.zzat = new ArrayList<>();
                this.zzau = false;
                this.zzav = false;
                this.zzaw = null;
                this.zzax = null;
                this.zzay = 0;
            }

            public final GamesOptions build() {
                return new GamesOptions(this.zzan, this.zzao, this.zzap, this.zzaq, this.zzar, this.zzas, this.zzat, this.zzau, this.zzav, this.zzaw, this.zzax, this.zzay, (zze) null);
            }

            public final Builder setSdkVariant(int i) {
                this.zzar = i;
                return this;
            }

            public final Builder setShowConnectingPopup(boolean z) {
                this.zzao = z;
                this.zzap = 17;
                return this;
            }

            public final Builder setShowConnectingPopup(boolean z, int i) {
                this.zzao = z;
                this.zzap = i;
                return this;
            }

            private Builder(GamesOptions gamesOptions) {
                this.zzan = false;
                this.zzao = true;
                this.zzap = 17;
                this.zzaq = false;
                this.zzar = 4368;
                this.zzas = null;
                this.zzat = new ArrayList<>();
                this.zzau = false;
                this.zzav = false;
                this.zzaw = null;
                this.zzax = null;
                this.zzay = 0;
                if (gamesOptions != null) {
                    this.zzan = gamesOptions.zzan;
                    this.zzao = gamesOptions.zzao;
                    this.zzap = gamesOptions.zzap;
                    this.zzaq = gamesOptions.zzaq;
                    this.zzar = gamesOptions.zzar;
                    this.zzas = gamesOptions.zzas;
                    this.zzat = gamesOptions.zzat;
                    this.zzau = gamesOptions.zzau;
                    this.zzav = gamesOptions.zzav;
                    this.zzaw = gamesOptions.zzaw;
                    this.zzax = gamesOptions.zzax;
                    this.zzay = gamesOptions.zzay;
                }
            }

            /* synthetic */ Builder(zze zze) {
                this();
            }

            /* synthetic */ Builder(GamesOptions gamesOptions, zze zze) {
                this(gamesOptions);
            }
        }

        /* synthetic */ GamesOptions(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList arrayList, boolean z4, boolean z5, GoogleSignInAccount googleSignInAccount, String str2, int i3, zze zze) {
            this(z, z2, i, z3, i2, str, arrayList, z4, z5, googleSignInAccount, str2, i3);
        }
    }

    @KeepForSdk
    @Deprecated
    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public interface GetServerAuthCodeResult extends Result {
        @KeepForSdk
        String getCode();
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static abstract class zza extends Api.AbstractClientBuilder<zzg, GamesOptions> {
        private zza() {
        }

        public /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            GamesOptions gamesOptions = (GamesOptions) obj;
            if (gamesOptions == null) {
                gamesOptions = new GamesOptions.Builder((zze) null).build();
            }
            return new zzg(context, looper, clientSettings, gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return 1;
        }

        /* synthetic */ zza(zze zze) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    public static abstract class zzb<T extends Result> extends BaseImplementation.ApiMethodImpl<T, zzg> {
        public zzb(GoogleApiClient googleApiClient) {
            super(Games.CLIENT_KEY, googleApiClient);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static abstract class zzc extends zzb<GetServerAuthCodeResult> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return new zzh(this, status);
        }

        /* synthetic */ zzc(GoogleApiClient googleApiClient, zze zze) {
            this(googleApiClient);
        }
    }

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    private static abstract class zzd extends zzb<Status> {
        private zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result createFailedResult(Status status) {
            return status;
        }

        /* synthetic */ zzd(GoogleApiClient googleApiClient, zze zze) {
            this(googleApiClient);
        }
    }

    private Games() {
    }

    public static AchievementsClient getAchievementsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zze(activity, zza(googleSignInAccount));
    }

    @Deprecated
    public static String getAppId(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzby();
    }

    @Deprecated
    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbd();
    }

    public static EventsClient getEventsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(activity, zza(googleSignInAccount));
    }

    public static GamesClient getGamesClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(activity, zza(googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(activity, zza(googleSignInAccount));
    }

    @KeepForSdk
    @Deprecated
    public static PendingResult<GetServerAuthCodeResult> getGamesServerAuthCode(GoogleApiClient googleApiClient, String str) {
        Preconditions.checkNotEmpty(str, "Please provide a valid serverClientId");
        return googleApiClient.execute(new zzg(googleApiClient, str));
    }

    public static InvitationsClient getInvitationsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(activity, zza(googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new LeaderboardsClient(activity, zza(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(activity, zza(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbs(activity, zza(googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayersClient(activity, zza(googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(activity, zza(googleSignInAccount));
    }

    @Deprecated
    public static int getSdkVariant(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbw();
    }

    @Deprecated
    public static Intent getSettingsIntent(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true).zzbu();
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(activity, zza(googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(activity, zza(googleSignInAccount));
    }

    public static VideosClient getVideosClient(Activity activity, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(activity, zza(googleSignInAccount));
    }

    @Deprecated
    public static void setGravityForPopups(GoogleApiClient googleApiClient, int i) {
        zzg zza2 = zza(googleApiClient, false);
        if (zza2 != null) {
            zza2.zzm(i);
        }
    }

    @Deprecated
    public static void setViewForPopups(GoogleApiClient googleApiClient, View view) {
        Preconditions.checkNotNull(view);
        zzg zza2 = zza(googleApiClient, false);
        if (zza2 != null) {
            zza2.zza(view);
        }
    }

    @Deprecated
    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzf(googleApiClient));
    }

    public static zzg zza(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, true);
    }

    public static zzg zzb(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkState(googleApiClient.hasApi(API), "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        } else if (hasConnectedApi) {
            return (zzg) googleApiClient.getClient(CLIENT_KEY);
        } else {
            return null;
        }
    }

    public static zzg zza(GoogleApiClient googleApiClient, boolean z) {
        Preconditions.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        Preconditions.checkState(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zzb(googleApiClient, z);
    }

    public static AchievementsClient getAchievementsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zze(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static EventsClient getEventsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static GamesClient getGamesClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static LeaderboardsClient getLeaderboardsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new LeaderboardsClient(context, zza(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbs(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static PlayersClient getPlayersClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new PlayersClient(context, zza(googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static VideosClient getVideosClient(Activity activity, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(activity, zza(gamesOptions, googleSignInAccount));
    }

    public static AchievementsClient getAchievementsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zze(context, zza(googleSignInAccount));
    }

    public static EventsClient getEventsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(context, zza(googleSignInAccount));
    }

    public static GamesClient getGamesClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(context, zza(googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(context, zza(googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(context, zza(googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(context, zza(googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbs(context, zza(googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(context, zza(googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(context, zza(googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(context, zza(googleSignInAccount));
    }

    public static VideosClient getVideosClient(Context context, GoogleSignInAccount googleSignInAccount) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(context, zza(googleSignInAccount));
    }

    private static GamesOptions zza(GoogleSignInAccount googleSignInAccount) {
        GamesOptions.Builder builder = new GamesOptions.Builder((GamesOptions) null, (zze) null);
        builder.zzaw = googleSignInAccount;
        return builder.setSdkVariant(1052947).build();
    }

    public static AchievementsClient getAchievementsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zze(context, zza(gamesOptions, googleSignInAccount));
    }

    public static EventsClient getEventsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new EventsClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static GamesClient getGamesClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static GamesMetadataClient getGamesMetadataClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new GamesMetadataClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static InvitationsClient getInvitationsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new InvitationsClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static NotificationsClient getNotificationsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new NotificationsClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static PlayerStatsClient getPlayerStatsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new zzbs(context, zza(gamesOptions, googleSignInAccount));
    }

    public static RealTimeMultiplayerClient getRealTimeMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new RealTimeMultiplayerClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static SnapshotsClient getSnapshotsClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new SnapshotsClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static TurnBasedMultiplayerClient getTurnBasedMultiplayerClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new TurnBasedMultiplayerClient(context, zza(gamesOptions, googleSignInAccount));
    }

    public static VideosClient getVideosClient(Context context, GoogleSignInAccount googleSignInAccount, GamesOptions gamesOptions) {
        Preconditions.checkNotNull(googleSignInAccount, "GoogleSignInAccount must not be null");
        return new VideosClient(context, zza(gamesOptions, googleSignInAccount));
    }

    private static GamesOptions zza(GamesOptions gamesOptions, GoogleSignInAccount googleSignInAccount) {
        GamesOptions.Builder builder = new GamesOptions.Builder(gamesOptions, (zze) null);
        builder.zzaw = googleSignInAccount;
        return builder.setSdkVariant(1052947).build();
    }
}
