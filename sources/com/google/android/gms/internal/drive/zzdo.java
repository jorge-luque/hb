package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.events.OpenFileCallback;

final class zzdo implements ListenerHolder.Notifier<OpenFileCallback> {
    private final /* synthetic */ zzdg zzgp;

    zzdo(zzdk zzdk, zzdg zzdg) {
        this.zzgp = zzdg;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        this.zzgp.accept((OpenFileCallback) obj);
    }

    public final void onNotifyListenerFailed() {
    }
}
