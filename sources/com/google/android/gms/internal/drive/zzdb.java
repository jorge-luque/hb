package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdb extends TaskApiCall<zzaw, DriveFolder> {
    private final /* synthetic */ MetadataChangeSet zzfd;
    private final /* synthetic */ DriveFolder zzfz;

    zzdb(zzch zzch, MetadataChangeSet metadataChangeSet, DriveFolder driveFolder) {
        this.zzfd = metadataChangeSet;
        this.zzfz = driveFolder;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzfd.zzq().zza(zzaw.getContext());
        ((zzeo) zzaw.getService()).zza(new zzy(this.zzfz.getDriveId(), this.zzfd.zzq()), (zzeq) new zzhk(taskCompletionSource));
    }
}
