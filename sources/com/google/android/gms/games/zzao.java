package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzc;

@SafeParcelable.Class(creator = "PlayerPlayTogetherInfoEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzao extends zzc implements zzap {
    public static final Parcelable.Creator<zzao> CREATOR = new zzar();
    @SafeParcelable.Field(getter = "getFriendStatus", mo15196id = 1)
    private final int zzcw;
    @SafeParcelable.Field(getter = "getNickname", mo15196id = 2)
    private final String zzcx;
    @SafeParcelable.Field(getter = "getInvitationNickname", mo15196id = 3)
    private final String zzcy;

    public zzao(zzap zzap) {
        this.zzcw = zzap.zzq();
        this.zzcx = zzap.zzr();
        this.zzcy = zzap.zzs();
    }

    static int zza(zzap zzap) {
        return Objects.hashCode(Integer.valueOf(zzap.zzq()), zzap.zzr(), zzap.zzs());
    }

    static String zzb(zzap zzap) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(zzap);
        char[] cArr = {133, 177, 168, 164, 173, 163, 146, 179, 160, 179, 180, 178};
        for (int i = 0; i < 12; i++) {
            cArr[i] = (char) (cArr[i] - '?');
        }
        Objects.ToStringHelper add = stringHelper.add(new String(cArr), Integer.valueOf(zzap.zzq()));
        char[] cArr2 = {141, 168, 162, 170, 173, 160, 172, 164};
        for (int i2 = 0; i2 < 8; i2++) {
            cArr2[i2] = (char) (cArr2[i2] - '?');
        }
        Objects.ToStringHelper add2 = add.add(new String(cArr2), zzap.zzr());
        char[] cArr3 = {136, 173, 181, 168, 179, 160, 179, 168, 174, 173, 141, 168, 162, 170, 173, 160, 172, 164};
        for (int i3 = 0; i3 < 18; i3++) {
            cArr3[i3] = (char) (cArr3[i3] - '?');
        }
        return add2.add(new String(cArr3), zzap.zzs()).toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return zza(this);
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzb(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzcw);
        SafeParcelWriter.writeString(parcel, 2, this.zzcx, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcy, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zzq() {
        return this.zzcw;
    }

    public final String zzr() {
        return this.zzcx;
    }

    public final String zzs() {
        return this.zzcy;
    }

    static boolean zza(zzap zzap, Object obj) {
        if (!(obj instanceof zzap)) {
            return false;
        }
        if (obj == zzap) {
            return true;
        }
        zzap zzap2 = (zzap) obj;
        return zzap2.zzq() == zzap.zzq() && Objects.equal(zzap2.zzr(), zzap.zzr()) && Objects.equal(zzap2.zzs(), zzap.zzs());
    }

    @SafeParcelable.Constructor
    public zzao(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) String str2) {
        this.zzcw = i;
        this.zzcx = str;
        this.zzcy = str2;
    }
}
