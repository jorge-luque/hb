package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdrj implements Executor {
    boolean zzhie = true;
    private final /* synthetic */ Executor zzhif;
    private final /* synthetic */ zzdpw zzhig;

    zzdrj(Executor executor, zzdpw zzdpw) {
        this.zzhif = executor;
        this.zzhig = zzdpw;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zzhif.execute(new zzdrm(this, runnable));
        } catch (RejectedExecutionException e) {
            if (this.zzhie) {
                this.zzhig.setException(e);
            }
        }
    }
}
