package com.google.android.gms.internal.ads;

import com.android.volley.DefaultRetryPolicy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzg implements zzad {
    private int zzr;
    private int zzs;
    private final int zzt;
    private final float zzu;

    public zzg() {
        this(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    public final void zza(zzae zzae) throws zzae {
        boolean z = true;
        int i = this.zzs + 1;
        this.zzs = i;
        int i2 = this.zzr;
        this.zzr = i2 + ((int) (((float) i2) * this.zzu));
        if (i > this.zzt) {
            z = false;
        }
        if (!z) {
            throw zzae;
        }
    }

    public final int zzb() {
        return this.zzr;
    }

    public final int zzc() {
        return this.zzs;
    }

    private zzg(int i, int i2, float f) {
        this.zzr = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
        this.zzt = 1;
        this.zzu = 1.0f;
    }
}
