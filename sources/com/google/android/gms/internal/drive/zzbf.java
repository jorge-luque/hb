package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.OpenFileActivityOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbf extends TaskApiCall<zzaw, IntentSender> {
    private final /* synthetic */ OpenFileActivityOptions zzeq;

    zzbf(zzbb zzbb, OpenFileActivityOptions openFileActivityOptions) {
        this.zzeq = openFileActivityOptions;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        OpenFileActivityOptions openFileActivityOptions = this.zzeq;
        taskCompletionSource.setResult(((zzeo) ((zzaw) anyClient).getService()).zza(new zzgm(openFileActivityOptions.zzba, openFileActivityOptions.zzbb, openFileActivityOptions.zzbd, openFileActivityOptions.zzbe)));
    }
}
