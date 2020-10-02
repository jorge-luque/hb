package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "RemoveGeofencingRequestCreator")
@SafeParcelable.Reserved({1000})
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzam();
    @SafeParcelable.Field(defaultValue = "", getter = "getTag", mo15196id = 3)
    private final String tag;
    @SafeParcelable.Field(getter = "getGeofenceIds", mo15196id = 1)
    private final List<String> zzbu;
    @SafeParcelable.Field(getter = "getPendingIntent", mo15196id = 2)
    private final PendingIntent zzbv;

    @SafeParcelable.Constructor
    zzal(@SafeParcelable.Param(mo15199id = 1) List<String> list, @SafeParcelable.Param(mo15199id = 2) PendingIntent pendingIntent, @SafeParcelable.Param(mo15199id = 3) String str) {
        this.zzbu = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzbv = pendingIntent;
        this.tag = str;
    }

    public static zzal zza(PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent, "PendingIntent can not be null.");
        return new zzal((List<String>) null, pendingIntent, "");
    }

    public static zzal zza(List<String> list) {
        Preconditions.checkNotNull(list, "geofence can't be null.");
        Preconditions.checkArgument(!list.isEmpty(), "Geofences must contains at least one id.");
        return new zzal(list, (PendingIntent) null, "");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 1, this.zzbu, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzbv, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.tag, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
