package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbk;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
final class zzcx extends zzbk<Videos.CaptureOverlayStateListener> {
    zzcx(VideosClient videosClient, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzg zzg, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException, SecurityException {
        zzg.zzcj();
        taskCompletionSource.setResult(true);
    }
}
