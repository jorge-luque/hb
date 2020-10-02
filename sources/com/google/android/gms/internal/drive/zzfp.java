package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzb;
import com.google.android.gms.drive.events.zzo;
import com.google.android.gms.drive.events.zzr;
import com.google.android.gms.drive.events.zzv;

@SafeParcelable.Class(creator = "OnEventResponseCreator")
@SafeParcelable.Reserved({1, 4, 8})
public final class zzfp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfp> CREATOR = new zzfq();
    @SafeParcelable.Field(mo15196id = 2)
    private final int zzda;
    @SafeParcelable.Field(mo15196id = 3)
    private final ChangeEvent zzib;
    @SafeParcelable.Field(mo15196id = 5)
    private final CompletionEvent zzic;
    @SafeParcelable.Field(mo15196id = 6)
    private final zzo zzid;
    @SafeParcelable.Field(mo15196id = 7)
    private final zzb zzie;
    @SafeParcelable.Field(mo15196id = 9)
    private final zzv zzif;
    @SafeParcelable.Field(mo15196id = 10)
    private final zzr zzig;

    @SafeParcelable.Constructor
    zzfp(@SafeParcelable.Param(mo15199id = 2) int i, @SafeParcelable.Param(mo15199id = 3) ChangeEvent changeEvent, @SafeParcelable.Param(mo15199id = 5) CompletionEvent completionEvent, @SafeParcelable.Param(mo15199id = 6) zzo zzo, @SafeParcelable.Param(mo15199id = 7) zzb zzb, @SafeParcelable.Param(mo15199id = 9) zzv zzv, @SafeParcelable.Param(mo15199id = 10) zzr zzr) {
        this.zzda = i;
        this.zzib = changeEvent;
        this.zzic = completionEvent;
        this.zzid = zzo;
        this.zzie = zzb;
        this.zzif = zzv;
        this.zzig = zzr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzda);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzib, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzic, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzid, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzie, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzif, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzig, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final DriveEvent zzat() {
        int i = this.zzda;
        if (i == 1) {
            return this.zzib;
        }
        if (i == 2) {
            return this.zzic;
        }
        if (i == 3) {
            return this.zzid;
        }
        if (i == 4) {
            return this.zzie;
        }
        if (i == 7) {
            return this.zzif;
        }
        if (i == 8) {
            return this.zzig;
        }
        int i2 = this.zzda;
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unexpected event type ");
        sb.append(i2);
        throw new IllegalStateException(sb.toString());
    }
}
