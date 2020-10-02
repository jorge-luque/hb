package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbc extends TaskApiCall<zzaw, DriveId> {
    private final /* synthetic */ String zzdw;

    zzbc(zzbb zzbb, String str) {
        this.zzdw = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzek(DriveId.zza(this.zzdw), false), (zzeq) new zzhl(taskCompletionSource));
    }
}
