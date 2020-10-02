package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzie extends Thread {
    private final /* synthetic */ AudioTrack zzait;
    private final /* synthetic */ zzif zzaiu;

    zzie(zzif zzif, AudioTrack audioTrack) {
        this.zzaiu = zzif;
        this.zzait = audioTrack;
    }

    public final void run() {
        try {
            this.zzait.flush();
            this.zzait.release();
        } finally {
            this.zzaiu.zzajc.open();
        }
    }
}
