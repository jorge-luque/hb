package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzaa extends Metadata {
    private final MetadataBundle zzdt;

    public zzaa(MetadataBundle metadataBundle) {
        this.zzdt = metadataBundle;
    }

    public final /* synthetic */ Object freeze() {
        return new zzaa(this.zzdt.zzbf());
    }

    public final boolean isDataValid() {
        return this.zzdt != null;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzdt);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17);
        sb.append("Metadata [mImpl=");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public final <T> T zza(MetadataField<T> metadataField) {
        return this.zzdt.zza(metadataField);
    }
}
