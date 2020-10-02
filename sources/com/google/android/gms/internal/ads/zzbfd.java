package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzbfd implements Runnable {
    private final Map zzdzm;
    private final zzbfe zzeku;

    zzbfd(zzbfe zzbfe, Map map) {
        this.zzeku = zzbfe;
        this.zzdzm = map;
    }

    public final void run() {
        this.zzeku.zzk(this.zzdzm);
    }
}
