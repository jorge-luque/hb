package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SearchAdRequestParcelCreator")
@SafeParcelable.Reserved({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzza> CREATOR = new zzzd();
    @SafeParcelable.Field(mo15196id = 15)
    public final String zzbmy;

    public zzza(SearchAdRequest searchAdRequest) {
        this.zzbmy = searchAdRequest.getQuery();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zzbmy, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzza(@SafeParcelable.Param(mo15199id = 15) String str) {
        this.zzbmy = str;
    }
}
