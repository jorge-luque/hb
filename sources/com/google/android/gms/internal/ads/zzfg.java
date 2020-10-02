package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzfg extends zzfz {
    private static volatile Long zzaak;
    private static final Object zzaal = new Object();

    public zzfg(zzeo zzeo, String str, String str2, zzbv.zza.C6825zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (zzaak == null) {
            synchronized (zzaal) {
                if (zzaak == null) {
                    zzaak = (Long) this.zzaaw.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaam) {
            this.zzaam.zzaa(zzaak.longValue());
        }
    }
}
