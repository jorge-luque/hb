package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcq extends UnregisterListenerMethod<zzaw, zzdi> {
    private final /* synthetic */ DriveResource zzfq;
    private final /* synthetic */ zzdi zzfr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcq(zzch zzch, ListenerHolder.ListenerKey listenerKey, DriveResource driveResource, zzdi zzdi) {
        super(listenerKey);
        this.zzfq = driveResource;
        this.zzfr = zzdi;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void unregisterListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgs(this.zzfq.getDriveId(), 1), (zzes) this.zzfr.zzgh, (String) null, (zzeq) new zzhq(taskCompletionSource));
    }
}
