package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdz implements Videos.CaptureCapabilitiesResult {
    private final /* synthetic */ Status zzba;

    zzdz(zzea zzea, Status status) {
        this.zzba = status;
    }

    public final VideoCapabilities getCapabilities() {
        return null;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
