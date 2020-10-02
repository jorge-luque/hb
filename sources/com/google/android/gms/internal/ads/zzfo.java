package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzfo extends zzfz {
    private static final Object zzaal = new Object();
    private static volatile String zzaap;

    public zzfo(zzeo zzeo, String str, String str2, zzbv.zza.C6825zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzaam.zzs("E");
        if (zzaap == null) {
            synchronized (zzaal) {
                if (zzaap == null) {
                    zzaap = (String) this.zzaaw.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaam) {
            this.zzaam.zzs(zzaap);
        }
    }
}
