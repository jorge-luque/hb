package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PopupLocationInfoParcelableCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public final class zzbt extends zzc {
    public static final Parcelable.Creator<zzbt> CREATOR = new zzbs();
    @SafeParcelable.Field(getter = "getInfoBundle", mo15196id = 1)
    private final Bundle zzjt;
    @SafeParcelable.Field(getter = "getWindowToken", mo15196id = 2)
    private final IBinder zzju;

    public zzbt(zzbw zzbw) {
        this.zzjt = zzbw.zzcu();
        this.zzju = zzbw.zzju;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzjt, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzju, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzbt(@SafeParcelable.Param(mo15199id = 1) Bundle bundle, @SafeParcelable.Param(mo15199id = 2) IBinder iBinder) {
        this.zzjt = bundle;
        this.zzju = iBinder;
    }
}
