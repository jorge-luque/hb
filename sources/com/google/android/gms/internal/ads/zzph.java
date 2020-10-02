package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(23)
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzph implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzpg zzbjp;

    private zzph(zzpg zzpg, MediaCodec mediaCodec) {
        this.zzbjp = zzpg;
        mediaCodec.setOnFrameRenderedListener(this, new zzdns());
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        zzpg zzpg = this.zzbjp;
        if (this == zzpg.zzbjm) {
            zzpg.zzji();
        }
    }
}
