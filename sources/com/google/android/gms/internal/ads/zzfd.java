package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzfd extends zzfz {
    public zzfd(zzeo zzeo, String str, String str2, zzbv.zza.C6825zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 5);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzaam.zzf(-1);
        this.zzaam.zzg(-1);
        int[] iArr = (int[]) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext()});
        synchronized (this.zzaam) {
            this.zzaam.zzf((long) iArr[0]);
            this.zzaam.zzg((long) iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.zzaam.zzaf((long) iArr[2]);
            }
        }
    }
}
