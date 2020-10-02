package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzda implements PendingResultUtil.ResultConverter<Videos.CaptureAvailableResult, Boolean> {
    zzda() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Videos.CaptureAvailableResult captureAvailableResult = (Videos.CaptureAvailableResult) result;
        if (captureAvailableResult == null) {
            return false;
        }
        return Boolean.valueOf(captureAvailableResult.isAvailable());
    }
}
