package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzq extends zzg.zzan<Videos.CaptureAvailableResult> {
    zzq(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zza(int i, boolean z) {
        setResult(new zzg.zze(new Status(i), z));
    }
}
