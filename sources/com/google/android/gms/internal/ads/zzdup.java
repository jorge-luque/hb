package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdup {
    public static void zza(zzdwo zzdwo) throws GeneralSecurityException {
        zzdzb.zza(zza(zzdwo.zzazc().zzazp()));
        zza(zzdwo.zzazc().zzazq());
        if (zzdwo.zzaze() != zzdwi.UNKNOWN_FORMAT) {
            zzdsx.zza(zzdwo.zzazd().zzayx());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zza(zzdwy zzdwy) throws NoSuchAlgorithmException {
        int i = zzdus.zzhlc[zzdwy.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzdwy);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static zzdzd zza(zzdww zzdww) throws GeneralSecurityException {
        int i = zzdus.zzhld[zzdww.ordinal()];
        if (i == 1) {
            return zzdzd.NIST_P256;
        }
        if (i == 2) {
            return zzdzd.NIST_P384;
        }
        if (i == 3) {
            return zzdzd.NIST_P521;
        }
        String valueOf = String.valueOf(zzdww);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
        sb.append("unknown curve type: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static zzdzg zza(zzdwi zzdwi) throws GeneralSecurityException {
        int i = zzdus.zzhle[zzdwi.ordinal()];
        if (i == 1) {
            return zzdzg.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzdzg.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzdzg.COMPRESSED;
        }
        String valueOf = String.valueOf(zzdwi);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("unknown point format: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }
}
