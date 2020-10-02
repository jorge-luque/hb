package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzaia {
    private final zzuk zzaca;
    private final zzvr zzacb;
    private final Context zzvf;

    zzaia(Context context, zzvr zzvr) {
        this(context, zzvr, zzuk.zzcev);
    }

    private final void zza(zzxt zzxt) {
        try {
            this.zzacb.zzb(zzuk.zza(this.zzvf, zzxt));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdq());
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdq());
    }

    private zzaia(Context context, zzvr zzvr, zzuk zzuk) {
        this.zzvf = context;
        this.zzacb = zzvr;
        this.zzaca = zzuk;
    }
}
