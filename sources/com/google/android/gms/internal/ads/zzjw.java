package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzjw {
    public final int zzaok = 1;
    public final byte[] zzaol;

    public zzjw(int i, byte[] bArr) {
        this.zzaol = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzjw.class == obj.getClass()) {
            zzjw zzjw = (zzjw) obj;
            return this.zzaok == zzjw.zzaok && Arrays.equals(this.zzaol, zzjw.zzaol);
        }
    }

    public final int hashCode() {
        return (this.zzaok * 31) + Arrays.hashCode(this.zzaol);
    }
}
