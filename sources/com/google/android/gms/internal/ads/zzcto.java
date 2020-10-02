package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcto implements AppEventListener {
    @GuardedBy("this")
    private zzwh zzgjs;

    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzgjs != null) {
            try {
                this.zzgjs.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAppEvent.", e);
            }
        }
    }

    public final synchronized zzwh zzapk() {
        return this.zzgjs;
    }

    public final synchronized void zzb(zzwh zzwh) {
        this.zzgjs = zzwh;
    }
}
