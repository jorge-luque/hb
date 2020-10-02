package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "ServerSideVerificationOptionsParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzaua extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaua> CREATOR = new zzatz();
    @SafeParcelable.Field(mo15196id = 1)
    public final String zzdrf;
    @SafeParcelable.Field(mo15196id = 2)
    public final String zzdrg;

    public zzaua(ServerSideVerificationOptions serverSideVerificationOptions) {
        this(serverSideVerificationOptions.getUserId(), serverSideVerificationOptions.getCustomData());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdrf, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdrg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzaua(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2) {
        this.zzdrf = str;
        this.zzdrg = str2;
    }
}
