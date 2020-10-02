package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zziz {
    private final MediaCodec.CryptoInfo zzanc;
    private final MediaCodec.CryptoInfo.Pattern zzanl;

    private zziz(MediaCodec.CryptoInfo cryptoInfo) {
        this.zzanc = cryptoInfo;
        this.zzanl = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* access modifiers changed from: private */
    public final void set(int i, int i2) {
        this.zzanl.set(i, i2);
        this.zzanc.setPattern(this.zzanl);
    }
}
