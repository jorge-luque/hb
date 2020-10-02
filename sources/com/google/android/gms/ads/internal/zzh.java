package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzazz;
import com.google.android.gms.internal.ads.zzbab;
import com.google.android.gms.internal.ads.zzcm;
import com.google.android.gms.internal.ads.zzdf;
import com.google.android.gms.internal.ads.zzdj;
import com.google.android.gms.internal.ads.zzdu;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzzz;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzh implements zzdj, Runnable {
    private final List<Object[]> zzbmi = new Vector();
    private final AtomicReference<zzdj> zzbmj = new AtomicReference<>();
    private final AtomicReference<zzdj> zzbmk = new AtomicReference<>();
    private zzazz zzbml;
    private CountDownLatch zzbmm = new CountDownLatch(1);
    private Context zzvf;
    private final int zzwg;

    public zzh(Context context, zzazz zzazz) {
        this.zzvf = context;
        this.zzbml = zzazz;
        int intValue = ((Integer) zzvj.zzpv().zzd(zzzz.zzcnm)).intValue();
        if (intValue == 1) {
            this.zzwg = zzcm.zzmy;
        } else if (intValue != 2) {
            this.zzwg = zzcm.zzmx;
        } else {
            this.zzwg = zzcm.zzmz;
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcod)).booleanValue()) {
            zzbab.zzdzr.execute(this);
            return;
        }
        zzvj.zzpr();
        if (zzazm.zzye()) {
            zzbab.zzdzr.execute(this);
        } else {
            run();
        }
    }

    private final zzdj zzcb() {
        if (this.zzwg == zzcm.zzmy) {
            return this.zzbmk.get();
        }
        return this.zzbmj.get();
    }

    private static Context zze(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final boolean zzka() {
        try {
            this.zzbmm.await();
            return true;
        } catch (InterruptedException e) {
            zzazw.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzkb() {
        zzdj zzcb = zzcb();
        if (!this.zzbmi.isEmpty() && zzcb != null) {
            for (Object[] next : this.zzbmi) {
                if (next.length == 1) {
                    zzcb.zza((MotionEvent) next[0]);
                } else if (next.length == 3) {
                    zzcb.zza(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzbmi.clear();
        }
    }

    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzbml.zzdzp;
            if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcls)).booleanValue() && z2) {
                z = true;
            }
            if (this.zzwg != zzcm.zzmy) {
                this.zzbmj.set(zzdu.zzb(this.zzbml.zzbnd, zze(this.zzvf), z, this.zzwg));
            }
            if (this.zzwg != zzcm.zzmx) {
                this.zzbmk.set(zzdf.zza(this.zzbml.zzbnd, zze(this.zzvf), z));
            }
        } finally {
            this.zzbmm.countDown();
            this.zzvf = null;
            this.zzbml = null;
        }
    }

    public final String zza(Context context, View view, Activity activity) {
        zzdj zzcb = zzcb();
        return zzcb != null ? zzcb.zza(context, view, activity) : "";
    }

    public final String zzb(Context context) {
        zzdj zzdj;
        if (!zzka()) {
            return "";
        }
        int i = this.zzwg;
        if (i == zzcm.zzmy || i == zzcm.zzmz) {
            zzdj = this.zzbmk.get();
        } else {
            zzdj = this.zzbmj.get();
        }
        if (zzdj == null) {
            return "";
        }
        zzkb();
        return zzdj.zzb(zze(context));
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        zzdj zzcb;
        if (!zzka() || (zzcb = zzcb()) == null) {
            return "";
        }
        zzkb();
        return zzcb.zza(zze(context), str, view, activity);
    }

    public final void zzb(View view) {
        zzdj zzcb = zzcb();
        if (zzcb != null) {
            zzcb.zzb(view);
        }
    }

    public final void zza(MotionEvent motionEvent) {
        zzdj zzcb = zzcb();
        if (zzcb != null) {
            zzkb();
            zzcb.zza(motionEvent);
            return;
        }
        this.zzbmi.add(new Object[]{motionEvent});
    }

    public final void zza(int i, int i2, int i3) {
        zzdj zzcb = zzcb();
        if (zzcb != null) {
            zzkb();
            zzcb.zza(i, i2, i3);
            return;
        }
        this.zzbmi.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }
}
