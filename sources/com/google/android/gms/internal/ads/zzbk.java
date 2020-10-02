package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbk extends zzegk {
    private Date zzct;
    private Date zzcu;
    private long zzcv;
    private long zzcw;
    private double zzcx = 1.0d;
    private float zzcy = 1.0f;
    private zzegu zzcz = zzegu.zziix;
    private long zzda;
    private int zzdb;
    private int zzdc;
    private int zzdd;
    private int zzde;
    private int zzdf;
    private int zzdg;

    public zzbk() {
        super("mvhd");
    }

    public final long getDuration() {
        return this.zzcw;
    }

    public final String toString() {
        return "MovieHeaderBox[" + "creationTime=" + this.zzct + ";" + "modificationTime=" + this.zzcu + ";" + "timescale=" + this.zzcv + ";" + "duration=" + this.zzcw + ";" + "rate=" + this.zzcx + ";" + "volume=" + this.zzcy + ";" + "matrix=" + this.zzcz + ";" + "nextTrackId=" + this.zzda + "]";
    }

    public final void zzg(ByteBuffer byteBuffer) {
        zzm(byteBuffer);
        if (getVersion() == 1) {
            this.zzct = zzegn.zzfv(zzbg.zzc(byteBuffer));
            this.zzcu = zzegn.zzfv(zzbg.zzc(byteBuffer));
            this.zzcv = zzbg.zza(byteBuffer);
            this.zzcw = zzbg.zzc(byteBuffer);
        } else {
            this.zzct = zzegn.zzfv(zzbg.zza(byteBuffer));
            this.zzcu = zzegn.zzfv(zzbg.zza(byteBuffer));
            this.zzcv = zzbg.zza(byteBuffer);
            this.zzcw = zzbg.zza(byteBuffer);
        }
        this.zzcx = zzbg.zzd(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzcy = ((float) ((short) ((bArr[1] & 255) | ((short) (0 | ((bArr[0] << 8) & 65280)))))) / 256.0f;
        zzbg.zzb(byteBuffer);
        zzbg.zza(byteBuffer);
        zzbg.zza(byteBuffer);
        this.zzcz = zzegu.zzn(byteBuffer);
        this.zzdb = byteBuffer.getInt();
        this.zzdc = byteBuffer.getInt();
        this.zzdd = byteBuffer.getInt();
        this.zzde = byteBuffer.getInt();
        this.zzdf = byteBuffer.getInt();
        this.zzdg = byteBuffer.getInt();
        this.zzda = zzbg.zza(byteBuffer);
    }

    public final long zzs() {
        return this.zzcv;
    }
}
