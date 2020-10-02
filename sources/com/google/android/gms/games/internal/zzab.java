package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzab implements BaseImplementation.ResultHolder<Status> {
    private final /* synthetic */ BaseGmsClient.SignOutCallbacks zzho;

    zzab(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        this.zzho = signOutCallbacks;
    }

    public final void setFailedResult(Status status) {
        this.zzho.onSignOutComplete();
    }

    public final /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        this.zzho.onSignOutComplete();
    }
}
