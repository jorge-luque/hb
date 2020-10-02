package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzeb implements Videos.CaptureStateResult {
    private final /* synthetic */ Status zzba;

    zzeb(zzec zzec, Status status) {
        this.zzba = status;
    }

    public final CaptureState getCaptureState() {
        return null;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
