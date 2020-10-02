package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final /* synthetic */ class zzaka implements Runnable {
    private final zzakb zzddl;
    private final zzais zzddm;

    zzaka(zzakb zzakb, zzais zzais) {
        this.zzddl = zzakb;
        this.zzddm = zzais;
    }

    public final void run() {
        zzakb zzakb = this.zzddl;
        zzais zzais = this.zzddm;
        zzakb.zzddn.zzdcr.zzh(zzais);
        zzais.destroy();
    }
}
