package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.0 */
final class zza implements Parcelable.Creator<BinderWrapper> {
    zza() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (zza) null);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
