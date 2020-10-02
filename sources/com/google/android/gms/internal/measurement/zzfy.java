package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
public class zzfy {
    private static final zzev zza = zzev.zza();
    private zzdz zzb;
    private volatile zzgt zzc;
    private volatile zzdz zzd;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzgt zzb(com.google.android.gms.internal.measurement.zzgt r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzgt r0 = r1.zzc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzgt r0 = r1.zzc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzft -> 0x0012 }
            com.google.android.gms.internal.measurement.zzdz r0 = com.google.android.gms.internal.measurement.zzdz.zza     // Catch:{ zzft -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzft -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzdz r2 = com.google.android.gms.internal.measurement.zzdz.zza     // Catch:{ all -> 0x001a }
            r1.zzd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.zzgt r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfy.zzb(com.google.android.gms.internal.measurement.zzgt):com.google.android.gms.internal.measurement.zzgt");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfy = (zzfy) obj;
        zzgt zzgt = this.zzc;
        zzgt zzgt2 = zzfy.zzc;
        if (zzgt == null && zzgt2 == null) {
            return zzc().equals(zzfy.zzc());
        }
        if (zzgt != null && zzgt2 != null) {
            return zzgt.equals(zzgt2);
        }
        if (zzgt != null) {
            return zzgt.equals(zzfy.zzb(zzgt.zzbt()));
        }
        return zzb(zzgt2.zzbt()).equals(zzgt2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzgt zza(zzgt zzgt) {
        zzgt zzgt2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzgt;
        return zzgt2;
    }

    public final zzdz zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzdz zzdz = this.zzd;
                return zzdz;
            }
            if (this.zzc == null) {
                this.zzd = zzdz.zza;
            } else {
                this.zzd = this.zzc.zzbh();
            }
            zzdz zzdz2 = this.zzd;
            return zzdz2;
        }
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbn();
        }
        return 0;
    }
}
