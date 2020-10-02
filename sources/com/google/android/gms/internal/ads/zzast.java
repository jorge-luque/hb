package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzast extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzast> CREATOR = new zzasw();
    @SafeParcelable.Field(mo15196id = 3)
    public final String zzbsc;
    @SafeParcelable.Field(mo15196id = 2)
    public final zzuj zzdlx;

    @SafeParcelable.Constructor
    public zzast(@SafeParcelable.Param(mo15199id = 2) zzuj zzuj, @SafeParcelable.Param(mo15199id = 3) String str) {
        this.zzdlx = zzuj;
        this.zzbsc = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdlx, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbsc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
