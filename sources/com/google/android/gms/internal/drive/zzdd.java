package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdd extends TaskApiCall<zzaw, Metadata> {
    private final /* synthetic */ MetadataChangeSet zzfd;
    private final /* synthetic */ DriveResource zzfq;

    zzdd(zzch zzch, MetadataChangeSet metadataChangeSet, DriveResource driveResource) {
        this.zzfd = metadataChangeSet;
        this.zzfq = driveResource;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzfd.zzq().zza(zzaw.getContext());
        ((zzeo) zzaw.getService()).zza(new zzhf(this.zzfq.getDriveId(), this.zzfd.zzq()), (zzeq) new zzhp(taskCompletionSource));
    }
}
