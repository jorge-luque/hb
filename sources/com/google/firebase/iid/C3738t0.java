package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.firebase.iid.t0 */
/* compiled from: com.google.firebase:firebase-iid@@20.1.7 */
final class C3738t0 implements Parcelable.Creator<zzj> {
    C3738t0() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new zzj(readStrongBinder);
        }
        return null;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzj[i];
    }
}
