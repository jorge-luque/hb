package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zza();
    private IBinder zzdk;

    public BinderWrapper() {
        this.zzdk = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzdk);
    }

    @KeepForSdk
    public BinderWrapper(IBinder iBinder) {
        this.zzdk = null;
        this.zzdk = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzdk = null;
        this.zzdk = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, zza zza) {
        this(parcel);
    }
}
