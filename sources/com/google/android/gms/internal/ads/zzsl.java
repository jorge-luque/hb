package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzsl {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public zzsg zzbsg;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean zzbst;
    private final Context zzvf;

    zzsl(Context context) {
        this.zzvf = context;
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbsg != null) {
                this.zzbsg.disconnect();
                this.zzbsg = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Future<InputStream> zzb(zzsf zzsf) {
        zzso zzso = new zzso(this);
        zzsn zzsn = new zzsn(this, zzsf, zzso);
        zzsr zzsr = new zzsr(this, zzso);
        synchronized (this.lock) {
            zzsg zzsg = new zzsg(this.zzvf, zzq.zzlk().zzxx(), zzsn, zzsr);
            this.zzbsg = zzsg;
            zzsg.checkAvailabilityAndConnect();
        }
        return zzso;
    }
}
