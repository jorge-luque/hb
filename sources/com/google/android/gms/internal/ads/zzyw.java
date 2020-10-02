package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzyw extends zzxd {
    private final OnAdMetadataChangedListener zzcia;

    public zzyw(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzcia = onAdMetadataChangedListener;
    }

    public final void onAdMetadataChanged() throws RemoteException {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.zzcia;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
