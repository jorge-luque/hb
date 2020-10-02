package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;
import org.json.JSONException;

@SafeParcelable.Class(creator = "RewardItemParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzatc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatc> CREATOR = new zzatb();
    @SafeParcelable.Field(mo15196id = 2)
    public final String type;
    @SafeParcelable.Field(mo15196id = 3)
    public final int zzdqy;

    public zzatc(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    public static zzatc zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzatc(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzatc)) {
            zzatc zzatc = (zzatc) obj;
            if (!Objects.equal(this.type, zzatc.type) || !Objects.equal(Integer.valueOf(this.zzdqy), Integer.valueOf(zzatc.zzdqy))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.type, Integer.valueOf(this.zzdqy));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.type, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdqy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzatc(@SafeParcelable.Param(mo15199id = 2) String str, @SafeParcelable.Param(mo15199id = 3) int i) {
        this.type = str;
        this.zzdqy = i;
    }
}
