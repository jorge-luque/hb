package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzasb extends zzasg {
    private final String type;
    private final int zzdqy;

    public zzasb(String str, int i) {
        this.type = str;
        this.zzdqy = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzasb)) {
            zzasb zzasb = (zzasb) obj;
            if (!Objects.equal(this.type, zzasb.type) || !Objects.equal(Integer.valueOf(this.zzdqy), Integer.valueOf(zzasb.zzdqy))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int getAmount() {
        return this.zzdqy;
    }

    public final String getType() {
        return this.type;
    }
}
