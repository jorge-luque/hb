package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.drive.events.ListenerToken;
import com.google.android.gms.drive.events.OpenFileCallback;

final class zzdk extends zzl {
    private final /* synthetic */ zzch zzfw;
    private final ListenerToken zzgj;
    private final ListenerHolder<OpenFileCallback> zzgk;

    zzdk(zzch zzch, ListenerToken listenerToken, ListenerHolder<OpenFileCallback> listenerHolder) {
        this.zzfw = zzch;
        this.zzgj = listenerToken;
        this.zzgk = listenerHolder;
    }

    public final void zza(Status status) throws RemoteException {
        zza((zzdg<OpenFileCallback>) new zzdl(this, status));
    }

    public final void zza(zzfl zzfl) throws RemoteException {
        zza((zzdg<OpenFileCallback>) new zzdm(zzfl));
    }

    public final void zza(zzfh zzfh) throws RemoteException {
        zza((zzdg<OpenFileCallback>) new zzdn(this, zzfh));
    }

    private final void zza(zzdg<OpenFileCallback> zzdg) {
        this.zzgk.notifyListener(new zzdo(this, zzdg));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzfh zzfh, OpenFileCallback openFileCallback) {
        openFileCallback.onContents(new zzbi(zzfh.zzes));
        this.zzfw.cancelOpenFileCallback(this.zzgj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Status status, OpenFileCallback openFileCallback) {
        openFileCallback.onError(ApiExceptionUtil.fromStatus(status));
        this.zzfw.cancelOpenFileCallback(this.zzgj);
    }
}
