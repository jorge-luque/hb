package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.zzc;
import com.google.android.gms.games.internal.zzd;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;
import java.util.List;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "TurnBasedMatchEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class TurnBasedMatchEntity extends zzc implements TurnBasedMatch {
    public static final Parcelable.Creator<TurnBasedMatchEntity> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getData", mo15196id = 12)
    private final byte[] data;
    @SafeParcelable.Field(getter = "getDescription", mo15196id = 20)
    private final String description;
    @SafeParcelable.Field(getter = "getVersion", mo15196id = 11)
    private final int version;
    @SafeParcelable.Field(getter = "getLastUpdatedTimestamp", mo15196id = 6)
    private final long zzfo;
    @SafeParcelable.Field(getter = "getGame", mo15196id = 1)
    private final GameEntity zzlm;
    @SafeParcelable.Field(getter = "getCreationTimestamp", mo15196id = 4)
    private final long zzpa;
    @SafeParcelable.Field(getter = "getParticipants", mo15196id = 13)
    private final ArrayList<ParticipantEntity> zzpd;
    @SafeParcelable.Field(getter = "getVariant", mo15196id = 10)
    private final int zzpe;
    @SafeParcelable.Field(getter = "getAutoMatchCriteria", mo15196id = 17)
    private final Bundle zzqa;
    @SafeParcelable.Field(getter = "getCreatorId", mo15196id = 3)
    private final String zzqe;
    @SafeParcelable.Field(getter = "getMatchId", mo15196id = 2)
    private final String zzqn;
    @SafeParcelable.Field(getter = "getLastUpdaterId", mo15196id = 5)
    private final String zzqo;
    @SafeParcelable.Field(getter = "getPendingParticipantId", mo15196id = 7)
    private final String zzqp;
    @SafeParcelable.Field(getter = "getStatus", mo15196id = 8)
    private final int zzqq;
    @SafeParcelable.Field(getter = "getRematchId", mo15196id = 14)
    private final String zzqr;
    @SafeParcelable.Field(getter = "getPreviousMatchData", mo15196id = 15)
    private final byte[] zzqs;
    @SafeParcelable.Field(getter = "getMatchNumber", mo15196id = 16)
    private final int zzqt;
    @SafeParcelable.Field(getter = "getTurnStatus", mo15196id = 18)
    private final int zzqu;
    @SafeParcelable.Field(getter = "isLocallyModified", mo15196id = 19)
    private final boolean zzqv;
    @SafeParcelable.Field(getter = "getDescriptionParticipantId", mo15196id = 21)
    private final String zzqw;

    public TurnBasedMatchEntity(TurnBasedMatch turnBasedMatch) {
        this(turnBasedMatch, ParticipantEntity.zza((List<Participant>) turnBasedMatch.getParticipants()));
    }

    static int zza(TurnBasedMatch turnBasedMatch) {
        return Objects.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), Integer.valueOf(zzd.zza(turnBasedMatch.getAutoMatchCriteria())), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String zzb(TurnBasedMatch turnBasedMatch) {
        return Objects.toStringHelper(turnBasedMatch).add("Game", turnBasedMatch.getGame()).add("MatchId", turnBasedMatch.getMatchId()).add("CreatorId", turnBasedMatch.getCreatorId()).add("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).add("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).add("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).add("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).add("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).add("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).add("Description", turnBasedMatch.getDescription()).add("Variant", Integer.valueOf(turnBasedMatch.getVariant())).add("Data", turnBasedMatch.getData()).add("Version", Integer.valueOf(turnBasedMatch.getVersion())).add("Participants", turnBasedMatch.getParticipants()).add("RematchId", turnBasedMatch.getRematchId()).add("PreviousData", turnBasedMatch.getPreviousMatchData()).add("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).add("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).add("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).add("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).add("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static ArrayList<String> zzc(TurnBasedMatch turnBasedMatch) {
        ArrayList<Participant> participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(participants.get(i).getParticipantId());
        }
        return arrayList;
    }

    public final boolean canRematch() {
        return this.zzqq == 2 && this.zzqr == null;
    }

    public final boolean equals(Object obj) {
        return zza((TurnBasedMatch) this, obj);
    }

    public final TurnBasedMatch freeze() {
        return this;
    }

    public final Bundle getAutoMatchCriteria() {
        return this.zzqa;
    }

    public final int getAvailableAutoMatchSlots() {
        Bundle bundle = this.zzqa;
        if (bundle == null) {
            return 0;
        }
        return bundle.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public final long getCreationTimestamp() {
        return this.zzpa;
    }

    public final String getCreatorId() {
        return this.zzqe;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        if (descriptionParticipantId == null) {
            return null;
        }
        return getParticipant(descriptionParticipantId);
    }

    public final String getDescriptionParticipantId() {
        return this.zzqw;
    }

    public final Game getGame() {
        return this.zzlm;
    }

    public final long getLastUpdatedTimestamp() {
        return this.zzfo;
    }

    public final String getLastUpdaterId() {
        return this.zzqo;
    }

    public final String getMatchId() {
        return this.zzqn;
    }

    public final int getMatchNumber() {
        return this.zzqt;
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
        return zza((TurnBasedMatch) this, str);
    }

    public final ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzpd);
    }

    public final String getPendingParticipantId() {
        return this.zzqp;
    }

    public final byte[] getPreviousMatchData() {
        return this.zzqs;
    }

    public final String getRematchId() {
        return this.zzqr;
    }

    public final int getStatus() {
        return this.zzqq;
    }

    public final int getTurnStatus() {
        return this.zzqu;
    }

    public final int getVariant() {
        return this.zzpe;
    }

    public final int getVersion() {
        return this.version;
    }

    public final int hashCode() {
        return zza(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final boolean isLocallyModified() {
        return this.zzqv;
    }

    public final String toString() {
        return zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
        SafeParcelWriter.writeString(parcel, 2, getMatchId(), false);
        SafeParcelWriter.writeString(parcel, 3, getCreatorId(), false);
        SafeParcelWriter.writeLong(parcel, 4, getCreationTimestamp());
        SafeParcelWriter.writeString(parcel, 5, getLastUpdaterId(), false);
        SafeParcelWriter.writeLong(parcel, 6, getLastUpdatedTimestamp());
        SafeParcelWriter.writeString(parcel, 7, getPendingParticipantId(), false);
        SafeParcelWriter.writeInt(parcel, 8, getStatus());
        SafeParcelWriter.writeInt(parcel, 10, getVariant());
        SafeParcelWriter.writeInt(parcel, 11, getVersion());
        SafeParcelWriter.writeByteArray(parcel, 12, getData(), false);
        SafeParcelWriter.writeTypedList(parcel, 13, getParticipants(), false);
        SafeParcelWriter.writeString(parcel, 14, getRematchId(), false);
        SafeParcelWriter.writeByteArray(parcel, 15, getPreviousMatchData(), false);
        SafeParcelWriter.writeInt(parcel, 16, getMatchNumber());
        SafeParcelWriter.writeBundle(parcel, 17, getAutoMatchCriteria(), false);
        SafeParcelWriter.writeInt(parcel, 18, getTurnStatus());
        SafeParcelWriter.writeBoolean(parcel, 19, isLocallyModified());
        SafeParcelWriter.writeString(parcel, 20, getDescription(), false);
        SafeParcelWriter.writeString(parcel, 21, getDescriptionParticipantId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private TurnBasedMatchEntity(TurnBasedMatch turnBasedMatch, ArrayList<ParticipantEntity> arrayList) {
        this.zzlm = new GameEntity(turnBasedMatch.getGame());
        this.zzqn = turnBasedMatch.getMatchId();
        this.zzqe = turnBasedMatch.getCreatorId();
        this.zzpa = turnBasedMatch.getCreationTimestamp();
        this.zzqo = turnBasedMatch.getLastUpdaterId();
        this.zzfo = turnBasedMatch.getLastUpdatedTimestamp();
        this.zzqp = turnBasedMatch.getPendingParticipantId();
        this.zzqq = turnBasedMatch.getStatus();
        this.zzqu = turnBasedMatch.getTurnStatus();
        this.zzpe = turnBasedMatch.getVariant();
        this.version = turnBasedMatch.getVersion();
        this.zzqr = turnBasedMatch.getRematchId();
        this.zzqt = turnBasedMatch.getMatchNumber();
        this.zzqa = turnBasedMatch.getAutoMatchCriteria();
        this.zzqv = turnBasedMatch.isLocallyModified();
        this.description = turnBasedMatch.getDescription();
        this.zzqw = turnBasedMatch.getDescriptionParticipantId();
        byte[] data2 = turnBasedMatch.getData();
        if (data2 == null) {
            this.data = null;
        } else {
            byte[] bArr = new byte[data2.length];
            this.data = bArr;
            System.arraycopy(data2, 0, bArr, 0, data2.length);
        }
        byte[] previousMatchData = turnBasedMatch.getPreviousMatchData();
        if (previousMatchData == null) {
            this.zzqs = null;
        } else {
            byte[] bArr2 = new byte[previousMatchData.length];
            this.zzqs = bArr2;
            System.arraycopy(previousMatchData, 0, bArr2, 0, previousMatchData.length);
        }
        this.zzpd = arrayList;
    }

    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.description, charArrayBuffer);
    }

    static Participant zzc(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList<Participant> participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        String matchId = turnBasedMatch.getMatchId();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(matchId).length());
        sb.append("Participant ");
        sb.append(str);
        sb.append(" is not in match ");
        sb.append(matchId);
        throw new IllegalStateException(sb.toString());
    }

    static boolean zza(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return Objects.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && Objects.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && Objects.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && Objects.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && Objects.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && Objects.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && Objects.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && Objects.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && Objects.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && Objects.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && Objects.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && Objects.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && Objects.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && Objects.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && Objects.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && zzd.zza(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && Objects.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && Objects.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String zzb(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList<Participant> participants = turnBasedMatch.getParticipants();
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

    @SafeParcelable.Constructor
    TurnBasedMatchEntity(@SafeParcelable.Param(mo15199id = 1) GameEntity gameEntity, @SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) String str2, @SafeParcelable.Param(mo15199id = 4) long j, @SafeParcelable.Param(mo15199id = 5) String str3, @SafeParcelable.Param(mo15199id = 6) long j2, @SafeParcelable.Param(mo15199id = 7) String str4, @SafeParcelable.Param(mo15199id = 8) int i, @SafeParcelable.Param(mo15199id = 10) int i2, @SafeParcelable.Param(mo15199id = 11) int i3, @SafeParcelable.Param(mo15199id = 12) byte[] bArr, @SafeParcelable.Param(mo15199id = 13) ArrayList<ParticipantEntity> arrayList, @SafeParcelable.Param(mo15199id = 14) String str5, @SafeParcelable.Param(mo15199id = 15) byte[] bArr2, @SafeParcelable.Param(mo15199id = 16) int i4, @SafeParcelable.Param(mo15199id = 17) Bundle bundle, @SafeParcelable.Param(mo15199id = 18) int i5, @SafeParcelable.Param(mo15199id = 19) boolean z, @SafeParcelable.Param(mo15199id = 20) String str6, @SafeParcelable.Param(mo15199id = 21) String str7) {
        this.zzlm = gameEntity;
        this.zzqn = str;
        this.zzqe = str2;
        this.zzpa = j;
        this.zzqo = str3;
        this.zzfo = j2;
        this.zzqp = str4;
        this.zzqq = i;
        this.zzqu = i5;
        this.zzpe = i2;
        this.version = i3;
        this.data = bArr;
        this.zzpd = arrayList;
        this.zzqr = str5;
        this.zzqs = bArr2;
        this.zzqt = i4;
        this.zzqa = bundle;
        this.zzqv = z;
        this.description = str6;
        this.zzqw = str7;
    }

    static int zza(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList<Participant> participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        String matchId = turnBasedMatch.getMatchId();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(matchId).length());
        sb.append("Participant ");
        sb.append(str);
        sb.append(" is not in match ");
        sb.append(matchId);
        throw new IllegalStateException(sb.toString());
    }
}
