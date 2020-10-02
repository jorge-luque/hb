package com.google.android.gms.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzdb implements PendingResultUtil.ResultConverter<Videos.CaptureCapabilitiesResult, VideoCapabilities> {
    zzdb() {
    }

    public final /* synthetic */ Object convert(Result result) {
        Videos.CaptureCapabilitiesResult captureCapabilitiesResult = (Videos.CaptureCapabilitiesResult) result;
        if (captureCapabilitiesResult == null) {
            return null;
        }
        return captureCapabilitiesResult.getCapabilities();
    }
}
