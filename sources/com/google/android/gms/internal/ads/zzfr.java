package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzfr extends zzfz {
    private final StackTraceElement[] zzaar;

    public zzfr(zzeo zzeo, String str, String str2, zzbv.zza.C6825zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzeo, str, str2, zza, i, 45);
        this.zzaar = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        zzcd zzcd;
        Object obj = this.zzaar;
        if (obj != null) {
            zzek zzek = new zzek((String) this.zzaaw.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zzaam) {
                this.zzaam.zzab(zzek.zzyb.longValue());
                if (zzek.zzyc.booleanValue()) {
                    zzbv.zza.C6825zza zza = this.zzaam;
                    if (zzek.zzyd.booleanValue()) {
                        zzcd = zzcd.ENUM_FALSE;
                    } else {
                        zzcd = zzcd.ENUM_TRUE;
                    }
                    zza.zzc(zzcd);
                } else {
                    this.zzaam.zzc(zzcd.ENUM_FAILURE);
                }
            }
        }
    }
}
