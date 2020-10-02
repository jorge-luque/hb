package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "MediationConfigurationParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzahk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzahk> CREATOR = new zzahn();
    @SafeParcelable.Field(mo15196id = 2)
    public final Bundle extras;
    @SafeParcelable.Field(mo15196id = 1)
    public final String zzdbk;

    @SafeParcelable.Constructor
    public zzahk(@SafeParcelable.Param(mo15199id = 1) String str, @SafeParcelable.Param(mo15199id = 2) Bundle bundle) {
        this.zzdbk = str;
        this.extras = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdbk, false);
        SafeParcelWriter.writeBundle(parcel, 2, this.extras, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
