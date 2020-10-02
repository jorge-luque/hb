package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class(creator = "AuthenticatorAnnotatedDataCreator")
public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaz;
    @SafeParcelable.Field(getter = "getPackageName", mo15196id = 4)
    private String mPackageName;
    @SafeParcelable.Indicator
    private final Set<Integer> zzba;
    @SafeParcelable.Field(getter = "getInfo", mo15196id = 2)
    private zzt zzbk;
    @SafeParcelable.Field(getter = "getSignature", mo15196id = 3)
    private String zzbl;
    @SafeParcelable.Field(getter = "getId", mo15196id = 5)
    private String zzbm;
    @SafeParcelable.VersionField(mo15202id = 1)
    private final int zzv;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        zzaz = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.forConcreteType("authenticatorInfo", 2, zzt.class));
        zzaz.put(InAppPurchaseMetaData.KEY_SIGNATURE, FastJsonResponse.Field.forString(InAppPurchaseMetaData.KEY_SIGNATURE, 3));
        zzaz.put("package", FastJsonResponse.Field.forString("package", 4));
    }

    public zzr() {
        this.zzba = new HashSet(3);
        this.zzv = 1;
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.zzbk = (zzt) t;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", new Object[]{Integer.valueOf(safeParcelableFieldId), t.getClass().getCanonicalName()}));
    }

    public /* synthetic */ Map getFieldMappings() {
        return zzaz;
    }

    /* access modifiers changed from: protected */
    public Object getFieldValue(FastJsonResponse.Field field) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 1) {
            return Integer.valueOf(this.zzv);
        }
        if (safeParcelableFieldId == 2) {
            return this.zzbk;
        }
        if (safeParcelableFieldId == 3) {
            return this.zzbl;
        }
        if (safeParcelableFieldId == 4) {
            return this.mPackageName;
        }
        int safeParcelableFieldId2 = field.getSafeParcelableFieldId();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(safeParcelableFieldId2);
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public boolean isFieldSet(FastJsonResponse.Field field) {
        return this.zzba.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    /* access modifiers changed from: protected */
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.zzbl = str2;
        } else if (safeParcelableFieldId == 4) {
            this.mPackageName = str2;
        } else {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
        }
        this.zzba.add(Integer.valueOf(safeParcelableFieldId));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zzba;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeParcelable(parcel, 2, this.zzbk, i, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeString(parcel, 3, this.zzbl, true);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeString(parcel, 4, this.mPackageName, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeString(parcel, 5, this.zzbm, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzr(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(mo15199id = 1) int i, @SafeParcelable.Param(mo15199id = 2) zzt zzt, @SafeParcelable.Param(mo15199id = 3) String str, @SafeParcelable.Param(mo15199id = 4) String str2, @SafeParcelable.Param(mo15199id = 5) String str3) {
        this.zzba = set;
        this.zzv = i;
        this.zzbk = zzt;
        this.zzbl = str;
        this.mPackageName = str2;
        this.zzbm = str3;
    }
}
