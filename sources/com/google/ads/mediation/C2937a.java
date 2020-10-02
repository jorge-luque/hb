package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* renamed from: com.google.ads.mediation.a */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
final class C2937a extends AdMetadataListener {

    /* renamed from: a */
    private final /* synthetic */ AbstractAdViewAdapter f8205a;

    C2937a(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f8205a = abstractAdViewAdapter;
    }

    public final void onAdMetadataChanged() {
        if (this.f8205a.zzma != null && this.f8205a.zzmb != null) {
            this.f8205a.zzmb.zzb(this.f8205a.zzma.getAdMetadata());
        }
    }
}
