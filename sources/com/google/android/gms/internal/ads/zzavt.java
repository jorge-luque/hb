package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzavt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzavt> CREATOR = new zzavw();
    @SafeParcelable.Field(mo15196id = 2)
    public final String zzbna;
    @SafeParcelable.Field(mo15196id = 1)
    @Deprecated
    public final String zzbsc;
    @SafeParcelable.Field(mo15196id = 3)
    @Deprecated
    public final zzum zzdtf;
    @SafeParcelable.Field(mo15196id = 4)
    public final zzuj zzdtg;

    @SafeParcelable.Constructor
    public zzavt(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) String str2, @SafeParcelable.Param(mo15199id = 3) zzum zzum, @SafeParcelable.Param(mo15199id = 4) zzuj zzuj) {
        this.zzbsc = str;
        this.zzbna = str2;
        this.zzdtf = zzum;
        this.zzdtg = zzuj;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbsc, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbna, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdtf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdtg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
