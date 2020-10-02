package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzbdf extends zzbc {
    static final zzbdf zzegk = new zzbdf();

    zzbdf() {
    }

    public final zzbf zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbh();
        }
        if ("mvhd".equals(str)) {
            return new zzbk();
        }
        return new zzbj(str);
    }
}
