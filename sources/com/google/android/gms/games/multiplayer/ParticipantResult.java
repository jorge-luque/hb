package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@SafeParcelable.Class(creator = "ParticipantResultCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class ParticipantResult extends zzc {
    public static final Parcelable.Creator<ParticipantResult> CREATOR = new zzd();
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    @SafeParcelable.Field(getter = "getParticipantId", mo15196id = 1)
    private final String zzph;
    @SafeParcelable.Field(getter = "getResult", mo15196id = 2)
    private final int zzpn;
    @SafeParcelable.Field(getter = "getPlacing", mo15196id = 3)
    private final int zzpo;

    @SafeParcelable.Constructor
    public ParticipantResult(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) int i, @SafeParcelable.Param(mo15199id = 3) int i2) {
        this.zzph = (String) Preconditions.checkNotNull(str);
        boolean z = true;
        if (!(i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5)) {
            z = false;
        }
        Preconditions.checkState(z);
        this.zzpn = i;
        this.zzpo = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParticipantResult)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ParticipantResult participantResult = (ParticipantResult) obj;
        return participantResult.getPlacing() == getPlacing() && participantResult.getResult() == getResult() && Objects.equal(participantResult.getParticipantId(), getParticipantId());
    }

    public final String getParticipantId() {
        return this.zzph;
    }

    public final int getPlacing() {
        return this.zzpo;
    }

    public final int getResult() {
        return this.zzpn;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(getPlacing()), Integer.valueOf(getResult()), getParticipantId());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getParticipantId(), false);
        SafeParcelWriter.writeInt(parcel, 2, getResult());
        SafeParcelWriter.writeInt(parcel, 3, getPlacing());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
