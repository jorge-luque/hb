package com.google.android.gms.games.internal;

import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final /* synthetic */ class zzr implements zzg.zzao {
    private final int zzhh;

    zzr(int i) {
        this.zzhh = i;
    }

    public final void accept(Object obj) {
        ((Videos.CaptureOverlayStateListener) obj).onCaptureOverlayStateChanged(this.zzhh);
    }
}
