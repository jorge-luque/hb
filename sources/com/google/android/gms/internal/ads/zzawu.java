package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzawu extends zzdns {
    public zzawu(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzq.zzla().zza(e, "AdMobHandler.handleMessage");
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb(Message message) {
        try {
            super.zzb(message);
        } catch (Throwable th) {
            zzq.zzkw();
            zzaxa.zza(zzq.zzla().getApplicationContext(), th);
            throw th;
        }
    }
}
