package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AdValueParcelCreator")
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzuo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzuo> CREATOR = new zzur();
    @SafeParcelable.Field(mo15196id = 1)
    public final int type;
    @SafeParcelable.Field(mo15196id = 2)
    public final int zzacj;
    @SafeParcelable.Field(mo15196id = 3)
    public final String zzack;
    @SafeParcelable.Field(mo15196id = 4)
    public final long zzacl;

    @SafeParcelable.Constructor
    public zzuo(@SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) int i2, @SafeParcelable.Param(mo15199id = 3) String str, @SafeParcelable.Param(mo15199id = 4) long j) {
        this.type = i;
        this.zzacj = i2;
        this.zzack = str;
        this.zzacl = j;
    }

    public static zzuo zza(JSONObject jSONObject) throws JSONException {
        return new zzuo(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString("currency"), jSONObject.getLong(AppMeasurementSdk.ConditionalUserProperty.VALUE));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.type);
        SafeParcelWriter.writeInt(parcel, 2, this.zzacj);
        SafeParcelWriter.writeString(parcel, 3, this.zzack, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzacl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
