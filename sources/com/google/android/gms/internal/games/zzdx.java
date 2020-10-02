package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdx implements Videos.CaptureAvailableResult {
    private final /* synthetic */ Status zzba;

    zzdx(zzdy zzdy, Status status) {
        this.zzba = status;
    }

    public final Status getStatus() {
        return this.zzba;
    }

    public final boolean isAvailable() {
        return false;
    }
}
