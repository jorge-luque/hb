package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvk;
import com.google.android.gms.internal.ads.zzdvo;
import com.google.android.gms.internal.ads.zzdwa;
import com.google.android.gms.internal.ads.zzdxa;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
final class zzdur implements zzdyv {
    private final String zzhkx;
    private final int zzhky;
    private zzdwa zzhkz;
    private zzdvk zzhla;
    private int zzhlb;

    zzdur(zzdxl zzdxl) throws GeneralSecurityException {
        String zzbad = zzdxl.zzbad();
        this.zzhkx = zzbad;
        if (zzbad.equals(zzdtd.zzhjy)) {
            try {
                zzdwb zzk = zzdwb.zzk(zzdxl.zzbae(), zzebq.zzbec());
                this.zzhkz = (zzdwa) zzdsx.zzb(zzdxl);
                this.zzhky = zzk.getKeySize();
            } catch (zzeco e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (this.zzhkx.equals(zzdtd.zzhjx)) {
            try {
                zzdvl zze = zzdvl.zze(zzdxl.zzbae(), zzebq.zzbec());
                this.zzhla = (zzdvk) zzdsx.zzb(zzdxl);
                this.zzhlb = zze.zzaxz().getKeySize();
                this.zzhky = this.zzhlb + zze.zzaya().getKeySize();
            } catch (zzeco e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else {
            String valueOf = String.valueOf(this.zzhkx);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    public final int zzaxm() {
        return this.zzhky;
    }

    public final zzdsb zzn(byte[] bArr) throws GeneralSecurityException {
        Class<zzdsb> cls = zzdsb.class;
        if (bArr.length != this.zzhky) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zzhkx.equals(zzdtd.zzhjy)) {
            return (zzdsb) zzdsx.zza(this.zzhkx, (zzedo) (zzdwa) ((zzecd) ((zzdwa.zza) zzdwa.zzayr().zza(this.zzhkz)).zzw(zzeaq.zzh(bArr, 0, this.zzhky)).zzbet()), cls);
        } else if (this.zzhkx.equals(zzdtd.zzhjx)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzhlb);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzhlb, this.zzhky);
            zzdvk.zza zzb = zzdvk.zzaxx().zzen(this.zzhla.getVersion()).zzb((zzdvo) ((zzecd) ((zzdvo.zza) zzdvo.zzayd().zza(this.zzhla.zzaxv())).zzu(zzeaq.zzu(copyOfRange)).zzbet()));
            return (zzdsb) zzdsx.zza(this.zzhkx, (zzedo) (zzdvk) ((zzecd) zzb.zzb((zzdxa) ((zzecd) ((zzdxa.zza) zzdxa.zzazv().zza(this.zzhla.zzaxw())).zzad(zzeaq.zzu(copyOfRange2)).zzbet())).zzbet()), cls);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
