package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class zzaff implements Runnable {
    private final /* synthetic */ PublisherAdView zzczr;
    private final /* synthetic */ zzvz zzczs;
    private final /* synthetic */ zzafc zzczt;

    zzaff(zzafc zzafc, PublisherAdView publisherAdView, zzvz zzvz) {
        this.zzczt = zzafc;
        this.zzczr = publisherAdView;
        this.zzczs = zzvz;
    }

    public final void run() {
        if (this.zzczr.zza(this.zzczs)) {
            this.zzczt.zzczo.onPublisherAdViewLoaded(this.zzczr);
        } else {
            zzazw.zzfc("Could not bind.");
        }
    }
}
