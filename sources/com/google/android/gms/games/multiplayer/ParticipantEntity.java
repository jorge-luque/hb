package com.google.android.gms.games.multiplayer;

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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import java.util.List;

@RetainForClient
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "ParticipantEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getStatus", mo15196id = 5)
    private final int status;
    @SafeParcelable.Field(getter = "getPlayer", mo15196id = 8)
    private final PlayerEntity zzfl;
    @SafeParcelable.Field(getter = "getDisplayName", mo15196id = 2)
    private final String zzj;
    @SafeParcelable.Field(getter = "getIconImageUri", mo15196id = 3)
    private final Uri zzn;
    @SafeParcelable.Field(getter = "getHiResImageUri", mo15196id = 4)
    private final Uri zzo;
    @SafeParcelable.Field(getter = "getParticipantId", mo15196id = 1)
    private final String zzph;
    @SafeParcelable.Field(getter = "getClientAddress", mo15196id = 6)
    private final String zzpi;
    @SafeParcelable.Field(getter = "isConnectedToRoom", mo15196id = 7)
    private final boolean zzpj;
    @SafeParcelable.Field(getter = "getCapabilities", mo15196id = 9)
    private final int zzpk;
    @SafeParcelable.Field(getter = "getResult", mo15196id = 10)
    private final ParticipantResult zzpl;
    @SafeParcelable.Field(getter = "getIconImageUrl", mo15196id = 11)
    private final String zzy;
    @SafeParcelable.Field(getter = "getHiResImageUrl", mo15196id = 12)
    private final String zzz;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    static final class zza extends zzc {
        zza() {
        }

        /* renamed from: zzf */
        public final ParticipantEntity createFromParcel(Parcel parcel) {
            Uri uri;
            Uri uri2;
            if (GamesDowngradeableSafeParcel.zzb(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(ParticipantEntity.class.getCanonicalName())) {
                Parcel parcel2 = parcel;
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                z = false;
            }
            PlayerEntity createFromParcel = z ? PlayerEntity.CREATOR.createFromParcel(parcel) : null;
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
            return new ParticipantEntity(readString, readString2, uri, uri2, readInt, readString5, z2, createFromParcel, 7, (ParticipantResult) null, (String) null, (String) null);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ParticipantEntity(com.google.android.gms.games.multiplayer.Participant r3) {
        /*
            r2 = this;
            com.google.android.gms.games.Player r0 = r3.getPlayer()
            if (r0 != 0) goto L_0x0008
            r0 = 0
            goto L_0x000e
        L_0x0008:
            com.google.android.gms.games.PlayerEntity r1 = new com.google.android.gms.games.PlayerEntity
            r1.<init>(r0)
            r0 = r1
        L_0x000e:
            r2.<init>(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.multiplayer.ParticipantEntity.<init>(com.google.android.gms.games.multiplayer.Participant):void");
    }

    public static ArrayList<ParticipantEntity> zza(List<Participant> list) {
        ParticipantEntity participantEntity;
        ArrayList<ParticipantEntity> arrayList = new ArrayList<>(list.size());
        for (Participant next : list) {
            if (next instanceof ParticipantEntity) {
                participantEntity = (ParticipantEntity) next;
            } else {
                participantEntity = new ParticipantEntity(next);
            }
            arrayList.add(participantEntity);
        }
        return arrayList;
    }

    static String zzb(Participant participant) {
        return Objects.toStringHelper(participant).add("ParticipantId", participant.getParticipantId()).add("Player", participant.getPlayer()).add("Status", Integer.valueOf(participant.getStatus())).add("ClientAddress", participant.zzdo()).add("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).add("DisplayName", participant.getDisplayName()).add("IconImage", participant.getIconImageUri()).add("IconImageUrl", participant.getIconImageUrl()).add("HiResImage", participant.getHiResImageUri()).add("HiResImageUrl", participant.getHiResImageUrl()).add("Capabilities", Integer.valueOf(participant.getCapabilities())).add("Result", participant.getResult()).toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final Participant freeze() {
        return this;
    }

    public final int getCapabilities() {
        return this.zzpk;
    }

    public final String getDisplayName() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzj;
        }
        return playerEntity.getDisplayName();
    }

    public final Uri getHiResImageUri() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzo;
        }
        return playerEntity.getHiResImageUri();
    }

    public final String getHiResImageUrl() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzz;
        }
        return playerEntity.getHiResImageUrl();
    }

    public final Uri getIconImageUri() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzn;
        }
        return playerEntity.getIconImageUri();
    }

    public final String getIconImageUrl() {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            return this.zzy;
        }
        return playerEntity.getIconImageUrl();
    }

    public final String getParticipantId() {
        return this.zzph;
    }

    public final Player getPlayer() {
        return this.zzfl;
    }

    public final ParticipantResult getResult() {
        return this.zzpl;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int hashCode() {
        return zza((Participant) this);
    }

    public final boolean isConnectedToRoom() {
        return this.zzpj;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity != null) {
            playerEntity.setShouldDowngrade(z);
        }
    }

    public final String toString() {
        return zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getParticipantId(), false);
            SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
            SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
            SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
            SafeParcelWriter.writeInt(parcel, 5, getStatus());
            SafeParcelWriter.writeString(parcel, 6, this.zzpi, false);
            SafeParcelWriter.writeBoolean(parcel, 7, isConnectedToRoom());
            SafeParcelWriter.writeParcelable(parcel, 8, getPlayer(), i, false);
            SafeParcelWriter.writeInt(parcel, 9, this.zzpk);
            SafeParcelWriter.writeParcelable(parcel, 10, getResult(), i, false);
            SafeParcelWriter.writeString(parcel, 11, getIconImageUrl(), false);
            SafeParcelWriter.writeString(parcel, 12, getHiResImageUrl(), false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzph);
        parcel.writeString(this.zzj);
        Uri uri = this.zzn;
        String str = null;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.zzo;
        if (uri2 != null) {
            str = uri2.toString();
        }
        parcel.writeString(str);
        parcel.writeInt(this.status);
        parcel.writeString(this.zzpi);
        parcel.writeInt(this.zzpj ? 1 : 0);
        if (this.zzfl == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        this.zzfl.writeToParcel(parcel, i);
    }

    public final String zzdo() {
        return this.zzpi;
    }

    private ParticipantEntity(Participant participant, PlayerEntity playerEntity) {
        this.zzph = participant.getParticipantId();
        this.zzj = participant.getDisplayName();
        this.zzn = participant.getIconImageUri();
        this.zzo = participant.getHiResImageUri();
        this.status = participant.getStatus();
        this.zzpi = participant.zzdo();
        this.zzpj = participant.isConnectedToRoom();
        this.zzfl = playerEntity;
        this.zzpk = participant.getCapabilities();
        this.zzpl = participant.getResult();
        this.zzy = participant.getIconImageUrl();
        this.zzz = participant.getHiResImageUrl();
    }

    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.zzfl;
        if (playerEntity == null) {
            String str = this.zzj;
            if (str == null) {
                charArrayBuffer.sizeCopied = 0;
            } else {
                DataUtils.copyStringToBuffer(str, charArrayBuffer);
            }
        } else {
            playerEntity.getDisplayName(charArrayBuffer);
        }
    }

    static int zza(Participant participant) {
        return Objects.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzdo(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    @SafeParcelable.Constructor
    ParticipantEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2, @SafeParcelable.Param(mo15199id = 3) Uri uri, @SafeParcelable.Param(mo15199id = 4) Uri uri2, @SafeParcelable.Param(mo15199id = 5) int i, @SafeParcelable.Param(mo15199id = 6) String str3, @SafeParcelable.Param(mo15199id = 7) boolean z, @SafeParcelable.Param(mo15199id = 8) PlayerEntity playerEntity, @SafeParcelable.Param(mo15199id = 9) int i2, @SafeParcelable.Param(mo15199id = 10) ParticipantResult participantResult, @SafeParcelable.Param(mo15199id = 11) String str4, @SafeParcelable.Param(mo15199id = 12) String str5) {
        this.zzph = str;
        this.zzj = str2;
        this.zzn = uri;
        this.zzo = uri2;
        this.status = i;
        this.zzpi = str3;
        this.zzpj = z;
        this.zzfl = playerEntity;
        this.zzpk = i2;
        this.zzpl = participantResult;
        this.zzy = str4;
        this.zzz = str5;
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return Objects.equal(participant2.getPlayer(), participant.getPlayer()) && Objects.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && Objects.equal(participant2.zzdo(), participant.zzdo()) && Objects.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && Objects.equal(participant2.getDisplayName(), participant.getDisplayName()) && Objects.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && Objects.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && Objects.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && Objects.equal(participant2.getResult(), participant.getResult()) && Objects.equal(participant2.getParticipantId(), participant.getParticipantId());
    }
}
