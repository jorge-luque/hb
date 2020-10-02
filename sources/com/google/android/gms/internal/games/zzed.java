package com.google.android.gms.internal.games;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games@@19.0.0 */
public abstract class zzed {
    private final Object zzle = new Object();
    private Handler zzlf;
    private boolean zzlg;
    private HashMap<String, AtomicInteger> zzlh;
    private int zzli;

    public zzed(Looper looper, int i) {
        this.zzlf = new zzeh(looper);
        this.zzlh = new HashMap<>();
        this.zzli = 1000;
    }

    /* access modifiers changed from: private */
    public final void zzcv() {
        synchronized (this.zzle) {
            this.zzlg = false;
            flush();
        }
    }

    public final void flush() {
        synchronized (this.zzle) {
            for (Map.Entry next : this.zzlh.entrySet()) {
                zzf((String) next.getKey(), ((AtomicInteger) next.getValue()).get());
            }
            this.zzlh.clear();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzf(String str, int i);

    public final void zzg(String str, int i) {
        synchronized (this.zzle) {
            if (!this.zzlg) {
                this.zzlg = true;
                this.zzlf.postDelayed(new zzeg(this), (long) this.zzli);
            }
            AtomicInteger atomicInteger = this.zzlh.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzlh.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
