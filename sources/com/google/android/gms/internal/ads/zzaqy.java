package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzaqy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqy> CREATOR = new zzaqx();
    @SafeParcelable.Field(mo15196id = 2)
    public final boolean zzdox;
    @SafeParcelable.Field(mo15196id = 3)
    public final List<String> zzdoy;

    public zzaqy() {
        this(false, Collections.emptyList());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdox);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzdoy, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzaqy(@SafeParcelable.Param(mo15199id = 2) boolean z, @SafeParcelable.Param(mo15199id = 3) List<String> list) {
        this.zzdox = z;
        this.zzdoy = list;
    }
}
