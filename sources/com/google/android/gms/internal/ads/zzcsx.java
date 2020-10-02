package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcsx {
    private final zzcfz zzgac;
    private final ConcurrentHashMap<String, zzanv> zzgiq = new ConcurrentHashMap<>();

    public zzcsx(zzcfz zzcfz) {
        this.zzgac = zzcfz;
    }

    public final void zzgm(String str) {
        try {
            this.zzgiq.put(str, this.zzgac.zzdk(str));
        } catch (RemoteException e) {
            zzazw.zzc("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzanv zzgn(String str) {
        if (this.zzgiq.containsKey(str)) {
            return this.zzgiq.get(str);
        }
        return null;
    }
}
