package com.google.android.gms.internal.ads;

import android.provider.Settings;
import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzez extends zzfz {
    public zzez(zzeo zzeo, String str, String str2, zzbv.zza.C6825zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzaam.zzb(zzcd.ENUM_FAILURE);
        try {
            this.zzaam.zzb(((Boolean) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext()})).booleanValue() ? zzcd.ENUM_TRUE : zzcd.ENUM_FALSE);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
