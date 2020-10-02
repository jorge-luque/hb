package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.Videos;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzn extends zzg.zzan<Videos.CaptureStateResult> {
    zzn(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zze(int i, Bundle bundle) {
        setResult(new zzg.C6821zzg(new Status(i), CaptureState.zzb(bundle)));
    }
}
