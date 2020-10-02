package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.1.0 */
public final class zzzf extends zzxp {
    private final VideoController.VideoLifecycleCallbacks zzacx;

    public zzzf(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzacx = videoLifecycleCallbacks;
    }

    public final void onVideoEnd() {
        this.zzacx.onVideoEnd();
    }

    public final void onVideoMute(boolean z) {
        this.zzacx.onVideoMute(z);
    }

    public final void onVideoPause() {
        this.zzacx.onVideoPause();
    }

    public final void onVideoPlay() {
        this.zzacx.onVideoPlay();
    }

    public final void onVideoStart() {
        this.zzacx.onVideoStart();
    }
}
