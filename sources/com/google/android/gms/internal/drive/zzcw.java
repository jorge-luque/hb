package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcw extends TaskApiCall<zzaw, DriveContents> {
    private final /* synthetic */ int zzdv = DriveFile.MODE_WRITE_ONLY;

    zzcw(zzch zzch, int i) {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzr(this.zzdv), (zzeq) new zzhi(taskCompletionSource));
    }
}
