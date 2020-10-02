package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzo extends zzg.zzan<Videos.CaptureCapabilitiesResult> {
    zzo(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zza(int i, VideoCapabilities videoCapabilities) {
        setResult(new zzg.zzh(new Status(i), videoCapabilities));
    }
}
