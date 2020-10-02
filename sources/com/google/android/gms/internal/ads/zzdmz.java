package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.1.0 */
public final class zzdmz {
    private final zzgh zzhcq;
    private final File zzhcr;
    private final File zzhcs;
    private final File zzhct;
    private byte[] zzhcu;

    public zzdmz(zzgh zzgh, File file, File file2, File file3) {
        this.zzhcq = zzgh;
        this.zzhcr = file;
        this.zzhcs = file3;
        this.zzhct = file2;
    }

    public final boolean zza() {
        return System.currentTimeMillis() / 1000 > this.zzhcq.zzdj();
    }

    public final zzgh zzava() {
        return this.zzhcq;
    }

    public final File zzavb() {
        return this.zzhcr;
    }

    public final File zzavc() {
        return this.zzhcs;
    }

    public final byte[] zzavd() {
        if (this.zzhcu == null) {
            this.zzhcu = zzdnb.zze(this.zzhct);
        }
        byte[] bArr = this.zzhcu;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final boolean zzfg(long j) {
        return this.zzhcq.zzdj() - (System.currentTimeMillis() / 1000) < 3600;
    }
}
