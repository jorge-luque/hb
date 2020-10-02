package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;

final class zzbt extends zzby {
    private final /* synthetic */ MetadataChangeSet zzfd;
    private final /* synthetic */ int zzfe;
    private final /* synthetic */ int zzff;
    private final /* synthetic */ ExecutionOptions zzfg;
    private final /* synthetic */ zzbs zzfh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbt(zzbs zzbs, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        super(googleApiClient);
        this.zzfh = zzbs;
        this.zzfd = metadataChangeSet;
        this.zzfe = i;
        this.zzff = i2;
        this.zzfg = executionOptions;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzaw zzaw = (zzaw) anyClient;
        this.zzfd.zzq().zza(zzaw.getContext());
        ((zzeo) zzaw.getService()).zza(new zzw(this.zzfh.getDriveId(), this.zzfd.zzq(), this.zzfe, this.zzff, this.zzfg), (zzeq) new zzbv(this));
    }
}
