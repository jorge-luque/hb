package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zza;
import com.google.android.gms.drive.zzu;
import java.util.List;

@SafeParcelable.Class(creator = "OnChangesResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzff extends zzu {
    public static final Parcelable.Creator<zzff> CREATOR = new zzfg();
    @SafeParcelable.Field(mo15196id = 2)
    private final DataHolder zzhr;
    @SafeParcelable.Field(mo15196id = 3)
    private final List<DriveId> zzhs;
    @SafeParcelable.Field(mo15196id = 4)
    private final zza zzht;
    @SafeParcelable.Field(mo15196id = 5)
    private final boolean zzhu;

    @SafeParcelable.Constructor
    public zzff(@SafeParcelable.Param(mo15199id = 2) DataHolder dataHolder, @SafeParcelable.Param(mo15199id = 3) List<DriveId> list, @SafeParcelable.Param(mo15199id = 4) zza zza, @SafeParcelable.Param(mo15199id = 5) boolean z) {
        this.zzhr = dataHolder;
        this.zzhs = list;
        this.zzht = zza;
        this.zzhu = z;
    }

    /* access modifiers changed from: protected */
    public final void zza(Parcel parcel, int i) {
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhr, i2, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzhs, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzht, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzhu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
