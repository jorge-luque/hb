package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.DriveFile;

final class zzbq implements ListenerHolder.Notifier<DriveFile.DownloadProgressListener> {
    private final /* synthetic */ long zzfb;
    private final /* synthetic */ long zzfc;

    zzbq(zzbp zzbp, long j, long j2) {
        this.zzfb = j;
        this.zzfc = j2;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((DriveFile.DownloadProgressListener) obj).onProgress(this.zzfb, this.zzfc);
    }

    public final void onNotifyListenerFailed() {
    }
}
