package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcz implements PendingResultUtil.ResultConverter<Videos.CaptureStateResult, CaptureState> {
    zzcz() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Videos.CaptureStateResult captureStateResult = (Videos.CaptureStateResult) result;
        if (captureStateResult == null) {
            return null;
        }
        return captureStateResult.getCaptureState();
    }
}
