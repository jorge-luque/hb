package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzxb implements MuteThisAdReason {
    private final String description;
    private zzww zzcgk;

    public zzxb(zzww zzww) {
        String str;
        this.zzcgk = zzww;
        try {
            str = zzww.getDescription();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            str = null;
        }
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String toString() {
        return this.description;
    }

    public final zzww zzqf() {
        return this.zzcgk;
    }
}
