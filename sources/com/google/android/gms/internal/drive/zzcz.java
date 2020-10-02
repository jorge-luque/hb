package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcz extends TaskApiCall<zzaw, MetadataBuffer> {
    private final /* synthetic */ Query zzdu;

    zzcz(zzch zzch, Query query) {
        this.zzdu = query;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgq(this.zzdu), (zzeq) new zzhn(taskCompletionSource));
    }
}
