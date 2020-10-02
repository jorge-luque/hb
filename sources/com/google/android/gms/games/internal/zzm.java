package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.snapshot.Snapshots;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzm extends zzg.zzan<Snapshots.CommitSnapshotResult> {
    zzm(BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
    }

    public final void zzah(DataHolder dataHolder) {
        setResult(new zzg.zzj(dataHolder));
    }
}
