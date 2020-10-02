package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzfs extends zzfz {
    private final boolean zzaas;

    public zzfs(zzeo zzeo, String str, String str2, zzbv.zza.C6825zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 61);
        this.zzaas = zzeo.zzcg();
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext(), Boolean.valueOf(this.zzaas)})).longValue();
        synchronized (this.zzaam) {
            this.zzaam.zzah(longValue);
        }
    }
}
