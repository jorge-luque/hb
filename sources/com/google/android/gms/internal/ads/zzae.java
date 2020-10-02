package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public class zzae extends Exception {
    private long zzad;
    private final zzo zzbk;

    public zzae() {
        this.zzbk = null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzad = j;
    }

    public zzae(zzo zzo) {
        this.zzbk = zzo;
    }

    public zzae(String str) {
        super(str);
        this.zzbk = null;
    }

    public zzae(Throwable th) {
        super(th);
        this.zzbk = null;
    }
}
