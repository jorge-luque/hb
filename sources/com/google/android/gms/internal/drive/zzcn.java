package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcn extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource zzfq;

    zzcn(zzch zzch, DriveResource driveResource) {
        this.zzfq = driveResource;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzhd(this.zzfq.getDriveId()), (zzeq) new zzhr(taskCompletionSource));
    }
}
