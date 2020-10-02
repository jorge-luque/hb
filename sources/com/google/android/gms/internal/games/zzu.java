package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzu extends zzac {
    private final /* synthetic */ String val$id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzu(zzq zzq, String str, GoogleApiClient googleApiClient, String str2) {
        super(str, googleApiClient);
        this.val$id = str2;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zza((BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult>) this, this.val$id);
    }
}
