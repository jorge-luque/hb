package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AppOpenAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzut extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzut> CREATOR = new zzus();
    @SafeParcelable.Field(mo15196id = 2)
    @AppOpenAd.AppOpenAdOrientation
    public final int orientation;

    @SafeParcelable.Constructor
    public zzut(@SafeParcelable.Param(mo15199id = 2) @AppOpenAd.AppOpenAdOrientation int i) {
        this.orientation = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.orientation);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
