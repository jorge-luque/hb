package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzfv extends zzfz {
    public zzfv(zzeo zzeo, String str, String str2, zzbv.zza.C6825zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzaam.zza(zzcd.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext()})).booleanValue();
        synchronized (this.zzaam) {
            if (booleanValue) {
                this.zzaam.zza(zzcd.ENUM_TRUE);
            } else {
                this.zzaam.zza(zzcd.ENUM_FALSE);
            }
        }
    }
}
