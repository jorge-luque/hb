package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzs extends zzg.zzu<Videos.CaptureOverlayStateListener> {
    zzs(ListenerHolder listenerHolder) {
        super(listenerHolder);
    }

    public final void onCaptureOverlayStateChanged(int i) {
        zzc(new zzr(i));
    }
}
