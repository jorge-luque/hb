package com.google.android.gms.games;

import android.annotation.SuppressLint;
import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.player.zza;
import com.google.android.gms.games.internal.player.zzb;
import com.google.android.gms.games.internal.player.zzd;

@SuppressLint({"ParcelCreator"})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class PlayerRef extends zzp implements Player {
    private final PlayerLevelInfo zzcc;
    private final zzd zzcz;
    private final zzb zzda;
    private final zzaq zzdb;

    public PlayerRef(DataHolder dataHolder, int i) {
        this(dataHolder, i, (String) null);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    public final /* synthetic */ Object freeze() {
        return new PlayerEntity(this);
    }

    public final Uri getBannerImageLandscapeUri() {
        return parseUri(this.zzcz.zznh);
    }

    public final String getBannerImageLandscapeUrl() {
        return getString(this.zzcz.zzni);
    }

    public final Uri getBannerImagePortraitUri() {
        return parseUri(this.zzcz.zznj);
    }

    public final String getBannerImagePortraitUrl() {
        return getString(this.zzcz.zznk);
    }

    public final String getDisplayName() {
        return getString(this.zzcz.zzmj);
    }

    public final Uri getHiResImageUri() {
        return parseUri(this.zzcz.zzmm);
    }

    public final String getHiResImageUrl() {
        return getString(this.zzcz.zzmn);
    }

    public final Uri getIconImageUri() {
        return parseUri(this.zzcz.zzmk);
    }

    public final String getIconImageUrl() {
        return getString(this.zzcz.zzml);
    }

    public final long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.zzcz.zzmq) || hasNull(this.zzcz.zzmq)) {
            return -1;
        }
        return getLong(this.zzcz.zzmq);
    }

    public final PlayerLevelInfo getLevelInfo() {
        return this.zzcc;
    }

    public final String getName() {
        return getString(this.zzcz.name);
    }

    public final String getPlayerId() {
        return getString(this.zzcz.zzmi);
    }

    public final long getRetrievedTimestamp() {
        return getLong(this.zzcz.zzmo);
    }

    public final String getTitle() {
        return getString(this.zzcz.zzca);
    }

    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public final int hashCode() {
        return PlayerEntity.zza((Player) this);
    }

    public final boolean isMuted() {
        return getBoolean(this.zzcz.zznn);
    }

    public final String toString() {
        return PlayerEntity.zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ((PlayerEntity) ((Player) freeze())).writeToParcel(parcel, i);
    }

    public final String zzh() {
        return getString(this.zzcz.zzcf);
    }

    public final boolean zzi() {
        return getBoolean(this.zzcz.zzng);
    }

    public final int zzj() {
        return getInteger(this.zzcz.zzmp);
    }

    public final boolean zzk() {
        return getBoolean(this.zzcz.zzmz);
    }

    public final zza zzl() {
        if (hasNull(this.zzcz.zzna)) {
            return null;
        }
        return this.zzda;
    }

    public final int zzm() {
        return getInteger(this.zzcz.zznl);
    }

    public final long zzn() {
        return getLong(this.zzcz.zznm);
    }

    public final long zzo() {
        String str = this.zzcz.zzno;
        if (!hasColumn(str) || hasNull(str)) {
            return -1;
        }
        return getLong(str);
    }

    public final zzap zzp() {
        if (this.zzdb.zzt()) {
            return this.zzdb;
        }
        return null;
    }

    private PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        zzd zzd = new zzd((String) null);
        this.zzcz = zzd;
        this.zzda = new zzb(dataHolder, i, zzd);
        this.zzdb = new zzaq(dataHolder, i, this.zzcz);
        if (!hasNull(this.zzcz.zzmr) && getLong(this.zzcz.zzmr) != -1) {
            int integer = getInteger(this.zzcz.zzms);
            int integer2 = getInteger(this.zzcz.zzmv);
            PlayerLevel playerLevel = new PlayerLevel(integer, getLong(this.zzcz.zzmt), getLong(this.zzcz.zzmu));
            this.zzcc = new PlayerLevelInfo(getLong(this.zzcz.zzmr), getLong(this.zzcz.zzmx), playerLevel, integer != integer2 ? new PlayerLevel(integer2, getLong(this.zzcz.zzmu), getLong(this.zzcz.zzmw)) : playerLevel);
            return;
        }
        this.zzcc = null;
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zzcz.zzmj, charArrayBuffer);
    }

    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zzcz.zzca, charArrayBuffer);
    }
}
