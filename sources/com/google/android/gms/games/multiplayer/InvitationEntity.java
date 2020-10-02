package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import java.util.List;

@RetainForClient
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "InvitationEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getGame", mo15196id = 1)
    private final GameEntity zzlm;
    @SafeParcelable.Field(getter = "getInvitationId", mo15196id = 2)
    private final String zzoz;
    @SafeParcelable.Field(getter = "getCreationTimestamp", mo15196id = 3)
    private final long zzpa;
    @SafeParcelable.Field(getter = "getInvitationType", mo15196id = 4)
    private final int zzpb;
    @SafeParcelable.Field(getter = "getInviter", mo15196id = 5)
    private final ParticipantEntity zzpc;
    @SafeParcelable.Field(getter = "getParticipants", mo15196id = 6)
    private final ArrayList<ParticipantEntity> zzpd;
    @SafeParcelable.Field(getter = "getVariant", mo15196id = 7)
    private final int zzpe;
    @SafeParcelable.Field(getter = "getAvailableAutoMatchSlots", mo15196id = 8)
    private final int zzpf;

    /* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
    static final class zza extends zza {
        zza() {
        }

        /* renamed from: zze */
        public final InvitationEntity createFromParcel(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzb(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity createFromParcel = GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity createFromParcel2 = ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(createFromParcel, readString, readLong, readInt, createFromParcel2, arrayList, -1, 0);
        }
    }

    InvitationEntity(Invitation invitation) {
        this(invitation, ParticipantEntity.zza((List<Participant>) invitation.getParticipants()));
    }

    static int zza(Invitation invitation) {
        return Objects.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String zzb(Invitation invitation) {
        return Objects.toStringHelper(invitation).add("Game", invitation.getGame()).add("InvitationId", invitation.getInvitationId()).add("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).add("InvitationType", Integer.valueOf(invitation.getInvitationType())).add("Inviter", invitation.getInviter()).add("Participants", invitation.getParticipants()).add("Variant", Integer.valueOf(invitation.getVariant())).add("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final Invitation freeze() {
        return this;
    }

    public final int getAvailableAutoMatchSlots() {
        return this.zzpf;
    }

    public final long getCreationTimestamp() {
        return this.zzpa;
    }

    public final Game getGame() {
        return this.zzlm;
    }

    public final String getInvitationId() {
        return this.zzoz;
    }

    public final int getInvitationType() {
        return this.zzpb;
    }

    public final Participant getInviter() {
        return this.zzpc;
    }

    public final ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzpd);
    }

    public final int getVariant() {
        return this.zzpe;
    }

    public final int hashCode() {
        return zza((Invitation) this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final void setShouldDowngrade(boolean z) {
        super.setShouldDowngrade(z);
        this.zzlm.setShouldDowngrade(z);
        this.zzpc.setShouldDowngrade(z);
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
            SafeParcelWriter.writeParcelable(parcel, 1, getGame(), i, false);
            SafeParcelWriter.writeString(parcel, 2, getInvitationId(), false);
            SafeParcelWriter.writeLong(parcel, 3, getCreationTimestamp());
            SafeParcelWriter.writeInt(parcel, 4, getInvitationType());
            SafeParcelWriter.writeParcelable(parcel, 5, getInviter(), i, false);
            SafeParcelWriter.writeTypedList(parcel, 6, getParticipants(), false);
            SafeParcelWriter.writeInt(parcel, 7, getVariant());
            SafeParcelWriter.writeInt(parcel, 8, getAvailableAutoMatchSlots());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        this.zzlm.writeToParcel(parcel, i);
        parcel.writeString(this.zzoz);
        parcel.writeLong(this.zzpa);
        parcel.writeInt(this.zzpb);
        this.zzpc.writeToParcel(parcel, i);
        int size = this.zzpd.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.zzpd.get(i2).writeToParcel(parcel, i);
        }
    }

    private InvitationEntity(Invitation invitation, ArrayList<ParticipantEntity> arrayList) {
        ParticipantEntity participantEntity;
        this.zzlm = new GameEntity(invitation.getGame());
        this.zzoz = invitation.getInvitationId();
        this.zzpa = invitation.getCreationTimestamp();
        this.zzpb = invitation.getInvitationType();
        this.zzpe = invitation.getVariant();
        this.zzpf = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        this.zzpd = arrayList;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                participantEntity = null;
                break;
            }
            ParticipantEntity participantEntity2 = arrayList.get(i);
            i++;
            participantEntity = participantEntity2;
            if (participantEntity.getParticipantId().equals(participantId)) {
                break;
            }
        }
        Preconditions.checkNotNull(participantEntity, "Must have a valid inviter!");
        this.zzpc = participantEntity;
    }

    static boolean zza(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return Objects.equal(invitation2.getGame(), invitation.getGame()) && Objects.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && Objects.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && Objects.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && Objects.equal(invitation2.getInviter(), invitation.getInviter()) && Objects.equal(invitation2.getParticipants(), invitation.getParticipants()) && Objects.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && Objects.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    @SafeParcelable.Constructor
    InvitationEntity(@SafeParcelable.Param(mo15199id = 1) GameEntity gameEntity, @SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) long j, @SafeParcelable.Param(mo15199id = 4) int i, @SafeParcelable.Param(mo15199id = 5) ParticipantEntity participantEntity, @SafeParcelable.Param(mo15199id = 6) ArrayList<ParticipantEntity> arrayList, @SafeParcelable.Param(mo15199id = 7) int i2, @SafeParcelable.Param(mo15199id = 8) int i3) {
        this.zzlm = gameEntity;
        this.zzoz = str;
        this.zzpa = j;
        this.zzpb = i;
        this.zzpc = participantEntity;
        this.zzpd = arrayList;
        this.zzpe = i2;
        this.zzpf = i3;
    }
}
