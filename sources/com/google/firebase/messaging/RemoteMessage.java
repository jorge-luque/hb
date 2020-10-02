package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new C3824x();
    @SafeParcelable.Field(mo15196id = 2)

    /* renamed from: a */
    Bundle f10502a;

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(mo15199id = 2) Bundle bundle) {
        this.f10502a = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.f10502a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
