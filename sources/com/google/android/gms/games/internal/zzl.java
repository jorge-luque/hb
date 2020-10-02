package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzl extends zzg.zzan<Snapshots.DeleteSnapshotResult> {
    zzl(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzd(int i, String str) {
        setResult(new zzg.zzi(i, str));
    }
}
