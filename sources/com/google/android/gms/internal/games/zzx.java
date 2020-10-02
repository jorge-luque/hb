package com.google.android.gms.internal.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.zzg;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzx extends zzac {
    private final /* synthetic */ String val$id;
    private final /* synthetic */ int zzkc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzx(zzq zzq, String str, GoogleApiClient googleApiClient, String str2, int i) {
        super(str, googleApiClient);
        this.val$id = str2;
        this.zzkc = i;
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzg) anyClient).zzb((BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult>) null, this.val$id, this.zzkc);
    }
}
