package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzxg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class ResponseInfo {
    private final zzxg zzacv;

    private ResponseInfo(zzxg zzxg) {
        this.zzacv = zzxg;
    }

    public static ResponseInfo zza(zzxg zzxg) {
        if (zzxg != null) {
            return new ResponseInfo(zzxg);
        }
        return null;
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzacv.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzazw.zzc("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    public final String getResponseId() {
        try {
            return this.zzacv.getResponseId();
        } catch (RemoteException e) {
            zzazw.zzc("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }
}
