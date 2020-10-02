package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzh implements Games.GetServerAuthCodeResult {
    private final /* synthetic */ Status zzba;

    zzh(Games.zzc zzc, Status status) {
        this.zzba = status;
    }

    public final String getCode() {
        return null;
    }

    public final Status getStatus() {
        return this.zzba;
    }
}
