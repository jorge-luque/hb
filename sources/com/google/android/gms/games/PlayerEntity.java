package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

@RetainForClient
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "PlayerEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getName", mo15196id = 21)
    private final String name;
    @SafeParcelable.Field(getter = "getPlayerId", mo15196id = 1)
    private String zzbw;
    @SafeParcelable.Field(getter = "getRetrievedTimestamp", mo15196id = 5)
    private final long zzbx;
    @SafeParcelable.Field(getter = "isInCircles", mo15196id = 6)
    private final int zzby;
    @SafeParcelable.Field(getter = "getLastPlayedWithTimestamp", mo15196id = 7)
    private final long zzbz;
    @SafeParcelable.Field(getter = "getTitle", mo15196id = 14)
    private final String zzca;
    @SafeParcelable.Field(getter = "getMostRecentGameInfo", mo15196id = 15)
    private final MostRecentGameInfoEntity zzcb;
    @SafeParcelable.Field(getter = "getLevelInfo", mo15196id = 16)
    private final PlayerLevelInfo zzcc;
    @SafeParcelable.Field(getter = "isProfileVisible", mo15196id = 18)
    private final boolean zzcd;
    @SafeParcelable.Field(getter = "hasDebugAccess", mo15196id = 19)
    private final boolean zzce;
    @SafeParcelable.Field(getter = "getGamerTag", mo15196id = 20)
    private final String zzcf;
    @SafeParcelable.Field(getter = "getBannerImageLandscapeUri", mo15196id = 22)
    private final Uri zzcg;
    @SafeParcelable.Field(getter = "getBannerImageLandscapeUrl", mo15196id = 23)
    private final String zzch;
    @SafeParcelable.Field(getter = "getBannerImagePortraitUri", mo15196id = 24)
    private final Uri zzci;
    @SafeParcelable.Field(getter = "getBannerImagePortraitUrl", mo15196id = 25)
    private final String zzcj;
    @SafeParcelable.Field(getter = "getGamerFriendStatus", mo15196id = 26)
    private final int zzck;
    @SafeParcelable.Field(getter = "getGamerFriendUpdateTimestamp", mo15196id = 27)
    private final long zzcl;
    @SafeParcelable.Field(getter = "isMuted", mo15196id = 28)
    private final boolean zzcm;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getTotalUnlockedAchievement", mo15196id = 29)
    private final long zzcn;
    @SafeParcelable.Field(getter = "getPlayerPlayTogetherInfo", mo15196id = 33)
    private final zzao zzco;
    @SafeParcelable.Field(getter = "getDisplayName", mo15196id = 2)
    private String zzj;
    @SafeParcelable.Field(getter = "getIconImageUri", mo15196id = 3)
    private final Uri zzn;
    @SafeParcelable.Field(getter = "getHiResImageUri", mo15196id = 4)
    private final Uri zzo;
    @SafeParcelable.Field(getter = "getIconImageUrl", mo15196id = 8)
    private final String zzy;
    @SafeParcelable.Field(getter = "getHiResImageUrl", mo15196id = 9)
    private final String zzz;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    static final class zza extends zzal {
        zza() {
        }

        /* renamed from: zzc */
        public final PlayerEntity createFromParcel(Parcel parcel) {
            Uri uri;
            Uri uri2;
            if (GamesDowngradeableSafeParcel.zzb(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            long readLong = parcel.readLong();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            if (readString3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(readString3);
            }
            if (readString4 == null) {
                uri2 = null;
            } else {
                uri2 = Uri.parse(readString4);
            }
            return new PlayerEntity(readString, readString2, uri, uri2, readLong, -1, -1, (String) null, (String) null, (String) null, (MostRecentGameInfoEntity) null, (PlayerLevelInfo) null, true, false, readString5, readString6, (Uri) null, (String) null, (Uri) null, (String) null, -1, -1, false, -1, (zzao) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.google.android.gms.games.zzao} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PlayerEntity(com.google.android.gms.games.Player r5) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.String r0 = r5.getPlayerId()
            r4.zzbw = r0
            java.lang.String r0 = r5.getDisplayName()
            r4.zzj = r0
            android.net.Uri r0 = r5.getIconImageUri()
            r4.zzn = r0
            java.lang.String r0 = r5.getIconImageUrl()
            r4.zzy = r0
            android.net.Uri r0 = r5.getHiResImageUri()
            r4.zzo = r0
            java.lang.String r0 = r5.getHiResImageUrl()
            r4.zzz = r0
            long r0 = r5.getRetrievedTimestamp()
            r4.zzbx = r0
            int r0 = r5.zzj()
            r4.zzby = r0
            long r0 = r5.getLastPlayedWithTimestamp()
            r4.zzbz = r0
            java.lang.String r0 = r5.getTitle()
            r4.zzca = r0
            boolean r0 = r5.zzk()
            r4.zzcd = r0
            com.google.android.gms.games.internal.player.zza r0 = r5.zzl()
            r1 = 0
            if (r0 != 0) goto L_0x004e
            r2 = r1
            goto L_0x0053
        L_0x004e:
            com.google.android.gms.games.internal.player.MostRecentGameInfoEntity r2 = new com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
            r2.<init>(r0)
        L_0x0053:
            r4.zzcb = r2
            com.google.android.gms.games.PlayerLevelInfo r0 = r5.getLevelInfo()
            r4.zzcc = r0
            boolean r0 = r5.zzi()
            r4.zzce = r0
            java.lang.String r0 = r5.zzh()
            r4.zzcf = r0
            java.lang.String r0 = r5.getName()
            r4.name = r0
            android.net.Uri r0 = r5.getBannerImageLandscapeUri()
            r4.zzcg = r0
            java.lang.String r0 = r5.getBannerImageLandscapeUrl()
            r4.zzch = r0
            android.net.Uri r0 = r5.getBannerImagePortraitUri()
            r4.zzci = r0
            java.lang.String r0 = r5.getBannerImagePortraitUrl()
            r4.zzcj = r0
            int r0 = r5.zzm()
            r4.zzck = r0
            long r2 = r5.zzn()
            r4.zzcl = r2
            boolean r0 = r5.isMuted()
            r4.zzcm = r0
            long r2 = r5.zzo()
            r4.zzcn = r2
            com.google.android.gms.games.zzap r5 = r5.zzp()
            if (r5 != 0) goto L_0x00a4
            goto L_0x00ab
        L_0x00a4:
            java.lang.Object r5 = r5.freeze()
            r1 = r5
            com.google.android.gms.games.zzao r1 = (com.google.android.gms.games.zzao) r1
        L_0x00ab:
            r4.zzco = r1
            java.lang.String r5 = r4.zzbw
            com.google.android.gms.common.internal.Asserts.checkNotNull(r5)
            java.lang.String r5 = r4.zzj
            com.google.android.gms.common.internal.Asserts.checkNotNull(r5)
            long r0 = r4.zzbx
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x00c1
            r5 = 1
            goto L_0x00c2
        L_0x00c1:
            r5 = 0
        L_0x00c2:
            com.google.android.gms.common.internal.Asserts.checkState(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.PlayerEntity.<init>(com.google.android.gms.games.Player):void");
    }

    static int zza(Player player) {
        return Objects.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzi()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzh(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Integer.valueOf(player.zzm()), Long.valueOf(player.zzn()), Boolean.valueOf(player.isMuted()), Long.valueOf(player.zzo()), player.zzp());
    }

    static String zzb(Player player) {
        Objects.ToStringHelper add = Objects.toStringHelper(player).add("PlayerId", player.getPlayerId()).add("DisplayName", player.getDisplayName()).add("HasDebugAccess", Boolean.valueOf(player.zzi())).add("IconImageUri", player.getIconImageUri()).add("IconImageUrl", player.getIconImageUrl()).add("HiResImageUri", player.getHiResImageUri()).add("HiResImageUrl", player.getHiResImageUrl()).add("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).add("Title", player.getTitle()).add("LevelInfo", player.getLevelInfo()).add("GamerTag", player.zzh()).add("Name", player.getName()).add("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).add("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).add("BannerImagePortraitUri", player.getBannerImagePortraitUri()).add("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).add("GamerFriendStatus", Integer.valueOf(player.zzm())).add("GamerFriendUpdateTimestamp", Long.valueOf(player.zzn())).add("IsMuted", Boolean.valueOf(player.isMuted())).add("totalUnlockedAchievement", Long.valueOf(player.zzo()));
        char[] cArr = {143, 171, 160, 184, 147, 174, 166, 164, 179, 167, 164, 177, 136, 173, 165, 174};
        for (int i = 0; i < 16; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        return add.add(new String(cArr), player.zzp()).toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final Player freeze() {
        return this;
    }

    public final Uri getBannerImageLandscapeUri() {
        return this.zzcg;
    }

    public final String getBannerImageLandscapeUrl() {
        return this.zzch;
    }

    public final Uri getBannerImagePortraitUri() {
        return this.zzci;
    }

    public final String getBannerImagePortraitUrl() {
        return this.zzcj;
    }

    public final String getDisplayName() {
        return this.zzj;
    }

    public final Uri getHiResImageUri() {
        return this.zzo;
    }

    public final String getHiResImageUrl() {
        return this.zzz;
    }

    public final Uri getIconImageUri() {
        return this.zzn;
    }

    public final String getIconImageUrl() {
        return this.zzy;
    }

    public final long getLastPlayedWithTimestamp() {
        return this.zzbz;
    }

    public final PlayerLevelInfo getLevelInfo() {
        return this.zzcc;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlayerId() {
        return this.zzbw;
    }

    public final long getRetrievedTimestamp() {
        return this.zzbx;
    }

    public final String getTitle() {
        return this.zzca;
    }

    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public final int hashCode() {
        return zza((Player) this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isMuted() {
        return this.zzcm;
    }

    public final String toString() {
        return zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getPlayerId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
            SafeParcelWriter.writeLong(parcel, 5, getRetrievedTimestamp());
            SafeParcelWriter.writeInt(parcel, 6, this.zzby);
            SafeParcelWriter.writeLong(parcel, 7, getLastPlayedWithTimestamp());
            SafeParcelWriter.writeString(parcel, 8, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 9, getHiResImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 14, getTitle(), false);
            SafeParcelWriter.writeParcelable(parcel, 15, this.zzcb, i, false);
            SafeParcelWriter.writeParcelable(parcel, 16, getLevelInfo(), i, false);
            SafeParcelWriter.writeBoolean(parcel, 18, this.zzcd);
            SafeParcelWriter.writeBoolean(parcel, 19, this.zzce);
            SafeParcelWriter.writeString(parcel, 20, this.zzcf, false);
            SafeParcelWriter.writeString(parcel, 21, this.name, false);
            SafeParcelWriter.writeParcelable(parcel, 22, getBannerImageLandscapeUri(), i, false);
            SafeParcelWriter.writeString(parcel, 23, getBannerImageLandscapeUrl(), false);
            SafeParcelWriter.writeParcelable(parcel, 24, getBannerImagePortraitUri(), i, false);
            SafeParcelWriter.writeString(parcel, 25, getBannerImagePortraitUrl(), false);
            SafeParcelWriter.writeInt(parcel, 26, this.zzck);
            SafeParcelWriter.writeLong(parcel, 27, this.zzcl);
            SafeParcelWriter.writeBoolean(parcel, 28, this.zzcm);
            SafeParcelWriter.writeLong(parcel, 29, this.zzcn);
            SafeParcelWriter.writeParcelable(parcel, 33, this.zzco, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzbw);
        parcel.writeString(this.zzj);
        Uri uri = this.zzn;
        String str = null;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzo;
        if (uri2 != null) {
            str = uri2.toString();
        }
        parcel.writeString(str);
        parcel.writeLong(this.zzbx);
    }

    public final String zzh() {
        return this.zzcf;
    }

    public final boolean zzi() {
        return this.zzce;
    }

    public final int zzj() {
        return this.zzby;
    }

    public final boolean zzk() {
        return this.zzcd;
    }

    public final com.google.android.gms.games.internal.player.zza zzl() {
        return this.zzcb;
    }

    public final int zzm() {
        return this.zzck;
    }

    public final long zzn() {
        return this.zzcl;
    }

    public final long zzo() {
        return this.zzcn;
    }

    public final zzap zzp() {
        return this.zzco;
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzca, charArrayBuffer);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return Objects.equal(player2.getPlayerId(), player.getPlayerId()) && Objects.equal(player2.getDisplayName(), player.getDisplayName()) && Objects.equal(Boolean.valueOf(player2.zzi()), Boolean.valueOf(player.zzi())) && Objects.equal(player2.getIconImageUri(), player.getIconImageUri()) && Objects.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && Objects.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && Objects.equal(player2.getTitle(), player.getTitle()) && Objects.equal(player2.getLevelInfo(), player.getLevelInfo()) && Objects.equal(player2.zzh(), player.zzh()) && Objects.equal(player2.getName(), player.getName()) && Objects.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && Objects.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && Objects.equal(Integer.valueOf(player2.zzm()), Integer.valueOf(player.zzm())) && Objects.equal(Long.valueOf(player2.zzn()), Long.valueOf(player.zzn())) && Objects.equal(Boolean.valueOf(player2.isMuted()), Boolean.valueOf(player.isMuted())) && Objects.equal(Long.valueOf(player2.zzo()), Long.valueOf(player.zzo())) && Objects.equal(player2.zzp(), player.zzp());
    }

    @SafeParcelable.Constructor
    PlayerEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2, @SafeParcelable.Param(mo15199id = 3) Uri uri, @SafeParcelable.Param(mo15199id = 4) Uri uri2, @SafeParcelable.Param(mo15199id = 5) long j, @SafeParcelable.Param(mo15199id = 6) int i, @SafeParcelable.Param(mo15199id = 7) long j2, @SafeParcelable.Param(mo15199id = 8) String str3, @SafeParcelable.Param(mo15199id = 9) String str4, @SafeParcelable.Param(mo15199id = 14) String str5, @SafeParcelable.Param(mo15199id = 15) MostRecentGameInfoEntity mostRecentGameInfoEntity, @SafeParcelable.Param(mo15199id = 16) PlayerLevelInfo playerLevelInfo, @SafeParcelable.Param(mo15199id = 18) boolean z, @SafeParcelable.Param(mo15199id = 19) boolean z2, @SafeParcelable.Param(mo15199id = 20) String str6, @SafeParcelable.Param(mo15199id = 21) String str7, @SafeParcelable.Param(mo15199id = 22) Uri uri3, @SafeParcelable.Param(mo15199id = 23) String str8, @SafeParcelable.Param(mo15199id = 24) Uri uri4, @SafeParcelable.Param(mo15199id = 25) String str9, @SafeParcelable.Param(mo15199id = 26) int i2, @SafeParcelable.Param(mo15199id = 27) long j3, @SafeParcelable.Param(mo15199id = 28) boolean z3, @SafeParcelable.Param(mo15199id = 29) long j4, @SafeParcelable.Param(mo15199id = 33) zzao zzao) {
        this.zzbw = str;
        this.zzj = str2;
        this.zzn = uri;
        this.zzy = str3;
        this.zzo = uri2;
        this.zzz = str4;
        this.zzbx = j;
        this.zzby = i;
        this.zzbz = j2;
        this.zzca = str5;
        this.zzcd = z;
        this.zzcb = mostRecentGameInfoEntity;
        this.zzcc = playerLevelInfo;
        this.zzce = z2;
        this.zzcf = str6;
        this.name = str7;
        this.zzcg = uri3;
        this.zzch = str8;
        this.zzci = uri4;
        this.zzcj = str9;
        this.zzck = i2;
        this.zzcl = j3;
        this.zzcm = z3;
        this.zzcn = j4;
        this.zzco = zzao;
    }
}
