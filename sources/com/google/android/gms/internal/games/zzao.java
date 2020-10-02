package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzao implements Result {
    private final /* synthetic */ Status zzba;

    zzao(zzal zzal, Status status) {
        this.zzba = status;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
