package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
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
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.zzd;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;
import java.util.List;

@RetainForClient
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "RoomEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 5)
    private final String description;
    @SafeParcelable.Field(getter = "getCreationTimestamp", mo15196id = 3)
    private final long zzpa;
    @SafeParcelable.Field(getter = "getParticipants", mo15196id = 8)
    private final ArrayList<ParticipantEntity> zzpd;
    @SafeParcelable.Field(getter = "getVariant", mo15196id = 6)
    private final int zzpe;
    @SafeParcelable.Field(getter = "getAutoMatchCriteria", mo15196id = 7)
    private final Bundle zzqa;
    @SafeParcelable.Field(getter = "getRoomId", mo15196id = 1)
    private final String zzqd;
    @SafeParcelable.Field(getter = "getCreatorId", mo15196id = 2)
    private final String zzqe;
    @SafeParcelable.Field(getter = "getStatus", mo15196id = 4)
    private final int zzqf;
    @SafeParcelable.Field(getter = "getAutoMatchWaitEstimateSeconds", mo15196id = 9)
    private final int zzqg;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    static final class zza extends zzf {
        zza() {
        }

        /* renamed from: zzg */
        public final RoomEntity createFromParcel(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzb(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(RoomEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }
    }

    public RoomEntity(Room room) {
        this(room, ParticipantEntity.zza((List<Participant>) room.getParticipants()));
    }

    static int zza(Room room) {
        return Objects.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), Integer.valueOf(zzd.zza(room.getAutoMatchCriteria())), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static String zzb(Room room) {
        return Objects.toStringHelper(room).add("RoomId", room.getRoomId()).add("CreatorId", room.getCreatorId()).add("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).add("RoomStatus", Integer.valueOf(room.getStatus())).add("Description", room.getDescription()).add("Variant", Integer.valueOf(room.getVariant())).add("AutoMatchCriteria", room.getAutoMatchCriteria()).add("Participants", room.getParticipants()).add("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static ArrayList<String> zzc(Room room) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(participants.get(i).getParticipantId());
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        return zza((Room) this, obj);
    }

    public final Room freeze() {
        return this;
    }

    public final Bundle getAutoMatchCriteria() {
        return this.zzqa;
    }

    public final int getAutoMatchWaitEstimateSeconds() {
        return this.zzqg;
    }

    public final long getCreationTimestamp() {
        return this.zzpa;
    }

    public final String getCreatorId() {
        return this.zzqe;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Participant getParticipant(String str) {
        return zzc(this, str);
    }

    public final String getParticipantId(String str) {
        return zzb(this, str);
    }

    public final ArrayList<String> getParticipantIds() {
        return zzc(this);
    }

    public final int getParticipantStatus(String str) {
        return zza((Room) this, str);
    }

    public final ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzpd);
    }

    public final String getRoomId() {
        return this.zzqd;
    }

    public final int getStatus() {
        return this.zzqf;
    }

    public final int getVariant() {
        return this.zzpe;
    }

    public final int hashCode() {
        return zza((Room) this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        int size = this.zzpd.size();
        for (int i = 0; i < size; i++) {
            this.zzpd.get(i).setShouldDowngrade(z);
        }
    }

    public final String toString() {
        return zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!shouldDowngrade()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getRoomId(), false);
            SafeParcelWriter.writeString(parcel, 2, getCreatorId(), false);
            SafeParcelWriter.writeLong(parcel, 3, getCreationTimestamp());
            SafeParcelWriter.writeInt(parcel, 4, getStatus());
            SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
            SafeParcelWriter.writeInt(parcel, 6, getVariant());
            SafeParcelWriter.writeBundle(parcel, 7, getAutoMatchCriteria(), false);
            SafeParcelWriter.writeTypedList(parcel, 8, getParticipants(), false);
            SafeParcelWriter.writeInt(parcel, 9, getAutoMatchWaitEstimateSeconds());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeString(this.zzqd);
        parcel.writeString(this.zzqe);
        parcel.writeLong(this.zzpa);
        parcel.writeInt(this.zzqf);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzpe);
        parcel.writeBundle(this.zzqa);
        int size = this.zzpd.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.zzpd.get(i2).writeToParcel(parcel, i);
        }
    }

    private RoomEntity(Room room, ArrayList<ParticipantEntity> arrayList) {
        this.zzqd = room.getRoomId();
        this.zzqe = room.getCreatorId();
        this.zzpa = room.getCreationTimestamp();
        this.zzqf = room.getStatus();
        this.description = room.getDescription();
        this.zzpe = room.getVariant();
        this.zzqa = room.getAutoMatchCriteria();
        this.zzpd = arrayList;
        this.zzqg = room.getAutoMatchWaitEstimateSeconds();
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    static Participant zzc(Room room, String str) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        String roomId = room.getRoomId();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(roomId).length());
        sb.append("Participant ");
        sb.append(str);
        sb.append(" is not in match ");
        sb.append(roomId);
        throw new IllegalStateException(sb.toString());
    }

    static boolean zza(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return Objects.equal(room2.getRoomId(), room.getRoomId()) && Objects.equal(room2.getCreatorId(), room.getCreatorId()) && Objects.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && Objects.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && Objects.equal(room2.getDescription(), room.getDescription()) && Objects.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && zzd.zza(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && Objects.equal(room2.getParticipants(), room.getParticipants()) && Objects.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    @SafeParcelable.Constructor
    RoomEntity(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2, @SafeParcelable.Param(mo15199id = 3) long j, @SafeParcelable.Param(mo15199id = 4) int i, @SafeParcelable.Param(mo15199id = 5) String str3, @SafeParcelable.Param(mo15199id = 6) int i2, @SafeParcelable.Param(mo15199id = 7) Bundle bundle, @SafeParcelable.Param(mo15199id = 8) ArrayList<ParticipantEntity> arrayList, @SafeParcelable.Param(mo15199id = 9) int i3) {
        this.zzqd = str;
        this.zzqe = str2;
        this.zzpa = j;
        this.zzqf = i;
        this.description = str3;
        this.zzpe = i2;
        this.zzqa = bundle;
        this.zzpd = arrayList;
        this.zzqg = i3;
    }

    static String zzb(Room room, String str) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static int zza(Room room, String str) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        String roomId = room.getRoomId();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 28 + String.valueOf(roomId).length());
        sb.append("Participant ");
        sb.append(str);
        sb.append(" is not in room ");
        sb.append(roomId);
        throw new IllegalStateException(sb.toString());
    }
}
