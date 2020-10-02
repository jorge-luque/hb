package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new zza();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzpp;
    private final byte[] zzpq;
    private final int zzpr;

    private RealTimeMessage(String str, byte[] bArr, int i) {
        this.zzpp = (String) Preconditions.checkNotNull(str);
        this.zzpq = (byte[]) ((byte[]) Preconditions.checkNotNull(bArr)).clone();
        this.zzpr = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final byte[] getMessageData() {
        return this.zzpq;
    }

    public final String getSenderParticipantId() {
        return this.zzpp;
    }

    public final boolean isReliable() {
        return this.zzpr == 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzpp);
        parcel.writeByteArray(this.zzpq);
        parcel.writeInt(this.zzpr);
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    /* synthetic */ RealTimeMessage(Parcel parcel, zza zza) {
        this(parcel);
    }
}
