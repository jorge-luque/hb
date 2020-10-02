package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zze;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcsr implements zze {
    @GuardedBy("this")
    private zze zzgin;

    public final synchronized void zza(zze zze) {
        this.zzgin = zze;
    }

    public final synchronized void zzh(View view) {
        if (this.zzgin != null) {
            this.zzgin.zzh(view);
        }
    }

    public final synchronized void zzjy() {
        if (this.zzgin != null) {
            this.zzgin.zzjy();
        }
    }

    public final synchronized void zzjz() {
        if (this.zzgin != null) {
            this.zzgin.zzjz();
        }
    }
}
