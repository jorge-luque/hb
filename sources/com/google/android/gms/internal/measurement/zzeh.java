package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
final class zzeh {
    private final zzes zza;
    private final byte[] zzb;

    private zzeh(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzes.zza(bArr);
    }

    public final zzdz zza() {
        this.zza.zzb();
        return new zzej(this.zzb);
    }

    public final zzes zzb() {
        return this.zza;
    }

    /* synthetic */ zzeh(int i, zzec zzec) {
        this(i);
    }
}
