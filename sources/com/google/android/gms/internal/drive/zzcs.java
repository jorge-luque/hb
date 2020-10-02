package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcs extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource zzfq;

    zzcs(zzch zzch, DriveResource driveResource) {
        this.zzfq = driveResource;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgs(this.zzfq.getDriveId(), 1), (zzes) null, (String) null, (zzeq) new zzhr(taskCompletionSource));
    }
}
