package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzp extends zzaa {
    private final /* synthetic */ boolean zzkb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzp(zzq zzq, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient, (zzp) null);
        this.zzkb = z;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zzc((BaseImplementation.ResultHolder<Achievements.LoadAchievementsResult>) this, this.zzkb);
    }
}
