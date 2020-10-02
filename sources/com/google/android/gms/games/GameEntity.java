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

@RetainForClient
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "GameEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 5)
    private final String description;
    @SafeParcelable.Field(getter = "getFeaturedImageUrl", mo15196id = 20)
    private final String zzaa;
    @SafeParcelable.Field(getter = "isMuted", mo15196id = 21)
    private final boolean zzab;
    @SafeParcelable.Field(getter = "isIdentitySharingConfirmed", mo15196id = 22)
    private final boolean zzac;
    @SafeParcelable.Field(getter = "areSnapshotsEnabled", mo15196id = 23)
    private final boolean zzad;
    @SafeParcelable.Field(getter = "getThemeColor", mo15196id = 24)
    private final String zzae;
    @SafeParcelable.Field(getter = "hasGamepadSupport", mo15196id = 25)
    private final boolean zzaf;
    @SafeParcelable.Field(getter = "getApplicationId", mo15196id = 1)
    private final String zzi;
    @SafeParcelable.Field(getter = "getDisplayName", mo15196id = 2)
    private final String zzj;
    @SafeParcelable.Field(getter = "getPrimaryCategory", mo15196id = 3)
    private final String zzk;
    @SafeParcelable.Field(getter = "getSecondaryCategory", mo15196id = 4)
    private final String zzl;
    @SafeParcelable.Field(getter = "getDeveloperName", mo15196id = 6)
    private final String zzm;
    @SafeParcelable.Field(getter = "getIconImageUri", mo15196id = 7)
    private final Uri zzn;
    @SafeParcelable.Field(getter = "getHiResImageUri", mo15196id = 8)
    private final Uri zzo;
    @SafeParcelable.Field(getter = "getFeaturedImageUri", mo15196id = 9)
    private final Uri zzp;
    @SafeParcelable.Field(getter = "isPlayEnabledGame", mo15196id = 10)
    private final boolean zzq;
    @SafeParcelable.Field(getter = "isInstanceInstalled", mo15196id = 11)
    private final boolean zzr;
    @SafeParcelable.Field(getter = "getInstancePackageName", mo15196id = 12)
    private final String zzs;
    @SafeParcelable.Field(getter = "getGameplayAclStatus", mo15196id = 13)
    private final int zzt;
    @SafeParcelable.Field(getter = "getAchievementTotalCount", mo15196id = 14)
    private final int zzu;
    @SafeParcelable.Field(getter = "getLeaderboardCount", mo15196id = 15)
    private final int zzv;
    @SafeParcelable.Field(getter = "isRealTimeMultiplayerEnabled", mo15196id = 16)
    private final boolean zzw;
    @SafeParcelable.Field(getter = "isTurnBasedMultiplayerEnabled", mo15196id = 17)
    private final boolean zzx;
    @SafeParcelable.Field(getter = "getIconImageUrl", mo15196id = 18)
    private final String zzy;
    @SafeParcelable.Field(getter = "getHiResImageUrl", mo15196id = 19)
    private final String zzz;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    static final class zza extends zzc {
        zza() {
        }

        /* renamed from: zzb */
        public final GameEntity createFromParcel(Parcel parcel) {
            Uri uri;
            Uri uri2;
            Uri uri3;
            if (GamesDowngradeableSafeParcel.zzb(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(GameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            if (readString7 == null) {
                uri = null;
            } else {
                uri = Uri.parse(readString7);
            }
            String readString8 = parcel.readString();
            if (readString8 == null) {
                uri2 = null;
            } else {
                uri2 = Uri.parse(readString8);
            }
            String readString9 = parcel.readString();
            if (readString9 == null) {
                uri3 = null;
            } else {
                uri3 = Uri.parse(readString9);
            }
            return new GameEntity(readString, readString2, readString3, readString4, readString5, readString6, uri, uri2, uri3, parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, (String) null, (String) null, (String) null, false, false, false, (String) null, false);
        }
    }

    public GameEntity(Game game) {
        this.zzi = game.getApplicationId();
        this.zzk = game.getPrimaryCategory();
        this.zzl = game.getSecondaryCategory();
        this.description = game.getDescription();
        this.zzm = game.getDeveloperName();
        this.zzj = game.getDisplayName();
        this.zzn = game.getIconImageUri();
        this.zzy = game.getIconImageUrl();
        this.zzo = game.getHiResImageUri();
        this.zzz = game.getHiResImageUrl();
        this.zzp = game.getFeaturedImageUri();
        this.zzaa = game.getFeaturedImageUrl();
        this.zzq = game.zzb();
        this.zzr = game.zzd();
        this.zzs = game.zze();
        this.zzt = 1;
        this.zzu = game.getAchievementTotalCount();
        this.zzv = game.getLeaderboardCount();
        this.zzw = game.isRealTimeMultiplayerEnabled();
        this.zzx = game.isTurnBasedMultiplayerEnabled();
        this.zzab = game.isMuted();
        this.zzac = game.zzc();
        this.zzad = game.areSnapshotsEnabled();
        this.zzae = game.getThemeColor();
        this.zzaf = game.hasGamepadSupport();
    }

    static int zza(Game game) {
        return Objects.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzb()), Boolean.valueOf(game.zzd()), game.zze(), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzc()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    public final boolean areSnapshotsEnabled() {
        return this.zzad;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final Game freeze() {
        return this;
    }

    public final int getAchievementTotalCount() {
        return this.zzu;
    }

    public final String getApplicationId() {
        return this.zzi;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDeveloperName() {
        return this.zzm;
    }

    public final String getDisplayName() {
        return this.zzj;
    }

    public final Uri getFeaturedImageUri() {
        return this.zzp;
    }

    public final String getFeaturedImageUrl() {
        return this.zzaa;
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

    public final int getLeaderboardCount() {
        return this.zzv;
    }

    public final String getPrimaryCategory() {
        return this.zzk;
    }

    public final String getSecondaryCategory() {
        return this.zzl;
    }

    public final String getThemeColor() {
        return this.zzae;
    }

    public final boolean hasGamepadSupport() {
        return this.zzaf;
    }

    public final int hashCode() {
        return zza((Game) this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isMuted() {
        return this.zzab;
    }

    public final boolean isRealTimeMultiplayerEnabled() {
        return this.zzw;
    }

    public final boolean isTurnBasedMultiplayerEnabled() {
        return this.zzx;
    }

    public final String toString() {
        return zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getApplicationId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeString(parcel, 3, getPrimaryCategory(), false);
            SafeParcelWriter.writeString(parcel, 4, getSecondaryCategory(), false);
            SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
            SafeParcelWriter.writeString(parcel, 6, getDeveloperName(), false);
            SafeParcelWriter.writeParcelable(parcel, 7, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 8, getHiResImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 9, getFeaturedImageUri(), i, false);
            SafeParcelWriter.writeBoolean(parcel, 10, this.zzq);
            SafeParcelWriter.writeBoolean(parcel, 11, this.zzr);
            SafeParcelWriter.writeString(parcel, 12, this.zzs, false);
            SafeParcelWriter.writeInt(parcel, 13, this.zzt);
            SafeParcelWriter.writeInt(parcel, 14, getAchievementTotalCount());
            SafeParcelWriter.writeInt(parcel, 15, getLeaderboardCount());
            SafeParcelWriter.writeBoolean(parcel, 16, isRealTimeMultiplayerEnabled());
            SafeParcelWriter.writeBoolean(parcel, 17, isTurnBasedMultiplayerEnabled());
            SafeParcelWriter.writeString(parcel, 18, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 19, getHiResImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 20, getFeaturedImageUrl(), false);
            SafeParcelWriter.writeBoolean(parcel, 21, this.zzab);
            SafeParcelWriter.writeBoolean(parcel, 22, this.zzac);
            SafeParcelWriter.writeBoolean(parcel, 23, areSnapshotsEnabled());
            SafeParcelWriter.writeString(parcel, 24, getThemeColor(), false);
            SafeParcelWriter.writeBoolean(parcel, 25, hasGamepadSupport());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzi);
        parcel.writeString(this.zzj);
        parcel.writeString(this.zzk);
        parcel.writeString(this.zzl);
        parcel.writeString(this.description);
        parcel.writeString(this.zzm);
        Uri uri = this.zzn;
        String str = null;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzo;
        parcel.writeString(uri2 == null ? null : uri2.toString());
        Uri uri3 = this.zzp;
        if (uri3 != null) {
            str = uri3.toString();
        }
        parcel.writeString(str);
        parcel.writeInt(this.zzq ? 1 : 0);
        parcel.writeInt(this.zzr ? 1 : 0);
        parcel.writeString(this.zzs);
        parcel.writeInt(this.zzt);
        parcel.writeInt(this.zzu);
        parcel.writeInt(this.zzv);
    }

    public final boolean zzb() {
        return this.zzq;
    }

    public final boolean zzc() {
        return this.zzac;
    }

    public final boolean zzd() {
        return this.zzr;
    }

    public final String zze() {
        return this.zzs;
    }

    static String zzb(Game game) {
        return Objects.toStringHelper(game).add("ApplicationId", game.getApplicationId()).add("DisplayName", game.getDisplayName()).add("PrimaryCategory", game.getPrimaryCategory()).add("SecondaryCategory", game.getSecondaryCategory()).add("Description", game.getDescription()).add("DeveloperName", game.getDeveloperName()).add("IconImageUri", game.getIconImageUri()).add("IconImageUrl", game.getIconImageUrl()).add("HiResImageUri", game.getHiResImageUri()).add("HiResImageUrl", game.getHiResImageUrl()).add("FeaturedImageUri", game.getFeaturedImageUri()).add("FeaturedImageUrl", game.getFeaturedImageUrl()).add("PlayEnabledGame", Boolean.valueOf(game.zzb())).add("InstanceInstalled", Boolean.valueOf(game.zzd())).add("InstancePackageName", game.zze()).add("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).add("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).add("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).add("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).add("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).add("ThemeColor", game.getThemeColor()).add("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    public final void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzm, charArrayBuffer);
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    static boolean zza(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        return Objects.equal(game2.getApplicationId(), game.getApplicationId()) && Objects.equal(game2.getDisplayName(), game.getDisplayName()) && Objects.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && Objects.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && Objects.equal(game2.getDescription(), game.getDescription()) && Objects.equal(game2.getDeveloperName(), game.getDeveloperName()) && Objects.equal(game2.getIconImageUri(), game.getIconImageUri()) && Objects.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && Objects.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && Objects.equal(Boolean.valueOf(game2.zzb()), Boolean.valueOf(game.zzb())) && Objects.equal(Boolean.valueOf(game2.zzd()), Boolean.valueOf(game.zzd())) && Objects.equal(game2.zze(), game.zze()) && Objects.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && Objects.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && Objects.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled())) && Objects.equal(Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())) && Objects.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && Objects.equal(Boolean.valueOf(game2.zzc()), Boolean.valueOf(game.zzc())) && Objects.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && Objects.equal(game2.getThemeColor(), game.getThemeColor()) && Objects.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()));
    }

    @SafeParcelable.Constructor
    GameEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2, @SafeParcelable.Param(mo15199id = 3) String str3, @SafeParcelable.Param(mo15199id = 4) String str4, @SafeParcelable.Param(mo15199id = 5) String str5, @SafeParcelable.Param(mo15199id = 6) String str6, @SafeParcelable.Param(mo15199id = 7) Uri uri, @SafeParcelable.Param(mo15199id = 8) Uri uri2, @SafeParcelable.Param(mo15199id = 9) Uri uri3, @SafeParcelable.Param(mo15199id = 10) boolean z, @SafeParcelable.Param(mo15199id = 11) boolean z2, @SafeParcelable.Param(mo15199id = 12) String str7, @SafeParcelable.Param(mo15199id = 13) int i, @SafeParcelable.Param(mo15199id = 14) int i2, @SafeParcelable.Param(mo15199id = 15) int i3, @SafeParcelable.Param(mo15199id = 16) boolean z3, @SafeParcelable.Param(mo15199id = 17) boolean z4, @SafeParcelable.Param(mo15199id = 18) String str8, @SafeParcelable.Param(mo15199id = 19) String str9, @SafeParcelable.Param(mo15199id = 20) String str10, @SafeParcelable.Param(mo15199id = 21) boolean z5, @SafeParcelable.Param(mo15199id = 22) boolean z6, @SafeParcelable.Param(mo15199id = 23) boolean z7, @SafeParcelable.Param(mo15199id = 24) String str11, @SafeParcelable.Param(mo15199id = 25) boolean z8) {
        this.zzi = str;
        this.zzj = str2;
        this.zzk = str3;
        this.zzl = str4;
        this.description = str5;
        this.zzm = str6;
        this.zzn = uri;
        this.zzy = str8;
        this.zzo = uri2;
        this.zzz = str9;
        this.zzp = uri3;
        this.zzaa = str10;
        this.zzq = z;
        this.zzr = z2;
        this.zzs = str7;
        this.zzt = i;
        this.zzu = i2;
        this.zzv = i3;
        this.zzw = z3;
        this.zzx = z4;
        this.zzab = z5;
        this.zzac = z6;
        this.zzad = z7;
        this.zzae = str11;
        this.zzaf = z8;
    }
}
