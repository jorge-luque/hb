package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.internal.zzbi;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzaa implements zzbi {
    zzaa() {
    }

    public final boolean zzb(Status status) {
        return status.isSuccess() || status.getStatusCode() == 5;
    }
}
