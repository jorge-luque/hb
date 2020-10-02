package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzaxb implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzaxa zzdwj;

    zzaxb(zzaxa zzaxa, Context context) {
        this.zzdwj = zzaxa;
        this.val$context = context;
    }

    public final void run() {
        synchronized (this.zzdwj.zzdwg) {
            String unused = this.zzdwj.zzbft = zzaxa.zzaq(this.val$context);
            this.zzdwj.zzdwg.notifyAll();
        }
    }
}
