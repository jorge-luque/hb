package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzse> CREATOR = new zzsd();
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getContentFileDescriptor", mo15196id = 2)
    private ParcelFileDescriptor zzbsl;

    public zzse() {
        this((ParcelFileDescriptor) null);
    }

    private final synchronized ParcelFileDescriptor zzmx() {
        return this.zzbsl;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzmx(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final synchronized boolean zzmv() {
        return this.zzbsl != null;
    }

    public final synchronized InputStream zzmw() {
        if (this.zzbsl == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbsl);
        this.zzbsl = null;
        return autoCloseInputStream;
    }

    @SafeParcelable.Constructor
    public zzse(@SafeParcelable.Param(mo15199id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbsl = parcelFileDescriptor;
    }
}
