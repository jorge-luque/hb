package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.tapjoy.TapjoyConstants;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzpg extends zzlb {
    private static final int[] zzbil = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int zzahj;
    private boolean zzaku;
    private final zzpk zzbim;
    private final zzpl zzbin;
    private final long zzbio;
    private final int zzbip;
    private final boolean zzbiq;
    private final long[] zzbir;
    private zzhf[] zzbis;
    private zzpi zzbit;
    private Surface zzbiu;
    private Surface zzbiv;
    private int zzbiw;
    private boolean zzbix;
    private long zzbiy;
    private long zzbiz;
    private int zzbja;
    private int zzbjb;
    private int zzbjc;
    private float zzbjd;
    private int zzbje;
    private int zzbjf;
    private int zzbjg;
    private float zzbjh;
    private int zzbji;
    private int zzbjj;
    private int zzbjk;
    private float zzbjl;
    zzph zzbjm;
    private long zzbjn;
    private int zzbjo;
    private final Context zzvf;

    public zzpg(Context context, zzld zzld, long j, zzdns zzdns, zzpm zzpm, int i) {
        this(context, zzld, 0, (zzjf<zzjh>) null, false, zzdns, zzpm, -1);
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzjk();
        zzow.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzow.endSection();
        this.zzazz.zzanh++;
        this.zzbjb = 0;
        zzji();
    }

    private static boolean zzem(long j) {
        return j < -30000;
    }

    private static int zzi(zzhf zzhf) {
        int i = zzhf.zzagj;
        if (i != -1) {
            return i;
        }
        return zza(zzhf.zzagi, zzhf.width, zzhf.height);
    }

    private static int zzj(zzhf zzhf) {
        int i = zzhf.zzagn;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    private final void zzjg() {
        this.zzbiy = this.zzbio > 0 ? SystemClock.elapsedRealtime() + this.zzbio : -9223372036854775807L;
    }

    private final void zzjh() {
        MediaCodec zzhc;
        this.zzbix = false;
        if (zzov.SDK_INT >= 23 && this.zzaku && (zzhc = zzhc()) != null) {
            this.zzbjm = new zzph(this, zzhc);
        }
    }

    private final void zzjj() {
        this.zzbji = -1;
        this.zzbjj = -1;
        this.zzbjl = -1.0f;
        this.zzbjk = -1;
    }

    private final void zzjk() {
        if (this.zzbji != this.zzbje || this.zzbjj != this.zzbjf || this.zzbjk != this.zzbjg || this.zzbjl != this.zzbjh) {
            this.zzbin.zza(this.zzbje, this.zzbjf, this.zzbjg, this.zzbjh);
            this.zzbji = this.zzbje;
            this.zzbjj = this.zzbjf;
            this.zzbjk = this.zzbjg;
            this.zzbjl = this.zzbjh;
        }
    }

    private final void zzjl() {
        if (this.zzbji != -1 || this.zzbjj != -1) {
            this.zzbin.zza(this.zzbje, this.zzbjf, this.zzbjg, this.zzbjh);
        }
    }

    private final void zzjm() {
        if (this.zzbja > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbin.zze(this.zzbja, elapsedRealtime - this.zzbiz);
            this.zzbja = 0;
            this.zzbiz = elapsedRealtime;
        }
    }

    private final boolean zzn(boolean z) {
        if (zzov.SDK_INT < 23 || this.zzaku) {
            return false;
        }
        return !z || zzpc.zzc(this.zzvf);
    }

    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzbix || (((surface = this.zzbiv) != null && this.zzbiu == surface) || zzhc() == null))) {
            this.zzbiy = -9223372036854775807L;
            return true;
        } else if (this.zzbiy == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzbiy) {
                return true;
            }
            this.zzbiy = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.zzbje = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.zzbjf = i2;
        this.zzbjh = this.zzbjd;
        if (zzov.SDK_INT >= 21) {
            int i3 = this.zzbjc;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzbje;
                this.zzbje = this.zzbjf;
                this.zzbjf = i4;
                this.zzbjh = 1.0f / this.zzbjh;
            }
        } else {
            this.zzbjg = this.zzbjc;
        }
        mediaCodec.setVideoScalingMode(this.zzbiw);
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzbja = 0;
        this.zzbiz = SystemClock.elapsedRealtime();
        this.zzbiy = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        zzjm();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzld zzld, zzhf zzhf) throws zzlj {
        boolean z;
        int i;
        int i2;
        String str = zzhf.zzagi;
        int i3 = 0;
        if (!zzoo.zzbe(str)) {
            return 0;
        }
        zzja zzja = zzhf.zzagl;
        if (zzja != null) {
            z = false;
            for (int i4 = 0; i4 < zzja.zzann; i4++) {
                z |= zzja.zzaa(i4).zzanq;
            }
        } else {
            z = false;
        }
        zzlc zzb = zzld.zzb(str, z);
        boolean z2 = true;
        if (zzb == null) {
            return 1;
        }
        boolean zzba = zzb.zzba(zzhf.zzagf);
        if (zzba && (i = zzhf.width) > 0 && (i2 = zzhf.height) > 0) {
            if (zzov.SDK_INT >= 21) {
                zzba = zzb.zza(i, i2, (double) zzhf.zzagm);
            } else {
                if (i * i2 > zzlf.zzhj()) {
                    z2 = false;
                }
                if (!z2) {
                    int i5 = zzhf.width;
                    int i6 = zzhf.height;
                    String str2 = zzov.zzbhv;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i5);
                    sb.append("x");
                    sb.append(i6);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    sb.toString();
                }
                zzba = z2;
            }
        }
        int i7 = zzb.zzbaa ? 8 : 4;
        if (zzb.zzaku) {
            i3 = 16;
        }
        return (zzba ? 3 : 2) | i7 | i3;
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.zzbin.zza(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzhf zzhf) throws zzgq {
        super.zzd(zzhf);
        this.zzbin.zzb(zzhf);
        float f = zzhf.zzago;
        if (f == -1.0f) {
            f = 1.0f;
        }
        this.zzbjd = f;
        this.zzbjc = zzj(zzhf);
    }

    /* access modifiers changed from: protected */
    public final void zze(boolean z) throws zzgq {
        super.zze(z);
        int i = zzeh().zzahj;
        this.zzahj = i;
        this.zzaku = i != 0;
        this.zzbin.zza(this.zzazz);
        this.zzbim.enable();
    }

    /* access modifiers changed from: protected */
    public final void zzeg() {
        this.zzbje = -1;
        this.zzbjf = -1;
        this.zzbjh = -1.0f;
        this.zzbjd = -1.0f;
        this.zzbjn = -9223372036854775807L;
        this.zzbjo = 0;
        zzjj();
        zzjh();
        this.zzbim.disable();
        this.zzbjm = null;
        this.zzaku = false;
        try {
            super.zzeg();
        } finally {
            this.zzazz.zzgm();
            this.zzbin.zzb(this.zzazz);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzhe() {
        try {
            super.zzhe();
        } finally {
            Surface surface = this.zzbiv;
            if (surface != null) {
                if (this.zzbiu == surface) {
                    this.zzbiu = null;
                }
                this.zzbiv.release();
                this.zzbiv = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzji() {
        if (!this.zzbix) {
            this.zzbix = true;
            this.zzbin.zza(this.zzbiu);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzpg(Context context, zzld zzld, long j, zzjf<zzjh> zzjf, boolean z, zzdns zzdns, zzpm zzpm, int i) {
        super(2, zzld, (zzjf<zzjh>) null, false);
        boolean z2 = false;
        this.zzbio = 0;
        this.zzbip = -1;
        this.zzvf = context.getApplicationContext();
        this.zzbim = new zzpk(context);
        this.zzbin = new zzpl(zzdns, zzpm);
        if (zzov.SDK_INT <= 22 && "foster".equals(zzov.DEVICE) && "NVIDIA".equals(zzov.MANUFACTURER)) {
            z2 = true;
        }
        this.zzbiq = z2;
        this.zzbir = new long[10];
        this.zzbjn = -9223372036854775807L;
        this.zzbiy = -9223372036854775807L;
        this.zzbje = -1;
        this.zzbjf = -1;
        this.zzbjh = -1.0f;
        this.zzbjd = -1.0f;
        this.zzbiw = 1;
        zzjj();
    }

    /* access modifiers changed from: protected */
    public final void zza(zzhf[] zzhfArr, long j) throws zzgq {
        this.zzbis = zzhfArr;
        if (this.zzbjn == -9223372036854775807L) {
            this.zzbjn = j;
        } else {
            int i = this.zzbjo;
            long[] jArr = this.zzbir;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbjo = i + 1;
            }
            this.zzbir[this.zzbjo - 1] = j;
        }
        super.zza(zzhfArr, j);
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) throws zzgq {
        super.zza(j, z);
        zzjh();
        this.zzbjb = 0;
        int i = this.zzbjo;
        if (i != 0) {
            this.zzbjn = this.zzbir[i - 1];
            this.zzbjo = 0;
        }
        if (z) {
            zzjg();
        } else {
            this.zzbiy = -9223372036854775807L;
        }
    }

    public final void zza(int i, Object obj) throws zzgq {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzbiv;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzlc zzhd = zzhd();
                    if (zzhd != null && zzn(zzhd.zzbab)) {
                        surface = zzpc.zzc(this.zzvf, zzhd.zzbab);
                        this.zzbiv = surface;
                    }
                }
            }
            if (this.zzbiu != surface) {
                this.zzbiu = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzhc = zzhc();
                    if (zzov.SDK_INT < 23 || zzhc == null || surface == null) {
                        zzhe();
                        zzhb();
                    } else {
                        zzhc.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzbiv) {
                    zzjj();
                    zzjh();
                    return;
                }
                zzjl();
                zzjh();
                if (state == 2) {
                    zzjg();
                }
            } else if (surface != null && surface != this.zzbiv) {
                zzjl();
                if (this.zzbix) {
                    this.zzbin.zza(this.zzbiu);
                }
            }
        } else if (i == 4) {
            this.zzbiw = ((Integer) obj).intValue();
            MediaCodec zzhc2 = zzhc();
            if (zzhc2 != null) {
                zzhc2.setVideoScalingMode(this.zzbiw);
            }
        } else {
            super.zza(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzlc zzlc) {
        return this.zzbiu != null || zzn(zzlc.zzbab);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzlc zzlc, MediaCodec mediaCodec, zzhf zzhf, MediaCrypto mediaCrypto) throws zzlj {
        zzpi zzpi;
        Point point;
        zzlc zzlc2 = zzlc;
        MediaCodec mediaCodec2 = mediaCodec;
        zzhf zzhf2 = zzhf;
        zzhf[] zzhfArr = this.zzbis;
        int i = zzhf2.width;
        int i2 = zzhf2.height;
        int zzi = zzi(zzhf);
        if (zzhfArr.length == 1) {
            zzpi = new zzpi(i, i2, zzi);
        } else {
            boolean z = false;
            for (zzhf zzhf3 : zzhfArr) {
                if (zza(zzlc2.zzbaa, zzhf2, zzhf3)) {
                    z |= zzhf3.width == -1 || zzhf3.height == -1;
                    i = Math.max(i, zzhf3.width);
                    i2 = Math.max(i2, zzhf3.height);
                    zzi = Math.max(zzi, zzi(zzhf3));
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzhf2.height > zzhf2.width;
                int i3 = z2 ? zzhf2.height : zzhf2.width;
                int i4 = z2 ? zzhf2.width : zzhf2.height;
                float f = ((float) i4) / ((float) i3);
                int[] iArr = zzbil;
                int length = iArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = length;
                    int i7 = iArr[i5];
                    int[] iArr2 = iArr;
                    int i8 = (int) (((float) i7) * f);
                    if (i7 <= i3 || i8 <= i4) {
                        break;
                    }
                    int i9 = i3;
                    int i10 = i4;
                    if (zzov.SDK_INT >= 21) {
                        int i11 = z2 ? i8 : i7;
                        if (!z2) {
                            i7 = i8;
                        }
                        Point zzd = zzlc2.zzd(i11, i7);
                        Point point2 = zzd;
                        if (zzlc2.zza(zzd.x, zzd.y, (double) zzhf2.zzagm)) {
                            point = point2;
                            break;
                        }
                    } else {
                        int zzf = zzov.zzf(i7, 16) << 4;
                        int zzf2 = zzov.zzf(i8, 16) << 4;
                        if (zzf * zzf2 <= zzlf.zzhj()) {
                            int i12 = z2 ? zzf2 : zzf;
                            if (!z2) {
                                zzf = zzf2;
                            }
                            point = new Point(i12, zzf);
                        }
                    }
                    i5++;
                    length = i6;
                    iArr = iArr2;
                    i3 = i9;
                    i4 = i10;
                }
                point = null;
                if (point != null) {
                    i = Math.max(i, point.x);
                    i2 = Math.max(i2, point.y);
                    zzi = Math.max(zzi, zza(zzhf2.zzagi, i, i2));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i);
                    sb2.append("x");
                    sb2.append(i2);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zzpi = new zzpi(i, i2, zzi);
        }
        this.zzbit = zzpi;
        boolean z3 = this.zzbiq;
        int i13 = this.zzahj;
        MediaFormat zzez = zzhf.zzez();
        zzez.setInteger("max-width", zzpi.width);
        zzez.setInteger("max-height", zzpi.height);
        int i14 = zzpi.zzbjq;
        if (i14 != -1) {
            zzez.setInteger("max-input-size", i14);
        }
        if (z3) {
            zzez.setInteger("auto-frc", 0);
        }
        if (i13 != 0) {
            zzez.setFeatureEnabled("tunneled-playback", true);
            zzez.setInteger("audio-session-id", i13);
        }
        if (this.zzbiu == null) {
            zzoh.checkState(zzn(zzlc2.zzbab));
            if (this.zzbiv == null) {
                this.zzbiv = zzpc.zzc(this.zzvf, zzlc2.zzbab);
            }
            this.zzbiu = this.zzbiv;
        }
        mediaCodec2.configure(zzez, this.zzbiu, (MediaCrypto) null, 0);
        if (zzov.SDK_INT >= 23 && this.zzaku) {
            this.zzbjm = new zzph(this, mediaCodec2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzjb zzjb) {
        if (zzov.SDK_INT < 23 && this.zzaku) {
            zzji();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzhf zzhf, zzhf zzhf2) {
        if (!zza(z, zzhf, zzhf2)) {
            return false;
        }
        int i = zzhf2.width;
        zzpi zzpi = this.zzbit;
        return i <= zzpi.width && zzhf2.height <= zzpi.height && zzhf2.zzagj <= zzpi.zzbjq;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.zzbjo;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.zzbir;
            if (j4 < jArr[0]) {
                break;
            }
            this.zzbjn = jArr[0];
            int i5 = i4 - 1;
            this.zzbjo = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j5 = j4 - this.zzbjn;
        if (z) {
            zza(mediaCodec2, i3, j5);
            return true;
        }
        long j6 = j4 - j;
        if (this.zzbiu == this.zzbiv) {
            if (!zzem(j6)) {
                return false;
            }
            zza(mediaCodec2, i3, j5);
            return true;
        } else if (!this.zzbix) {
            if (zzov.SDK_INT >= 21) {
                zza(mediaCodec, i, j5, System.nanoTime());
            } else {
                zzb(mediaCodec2, i3, j5);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzf = this.zzbim.zzf(j4, (elapsedRealtime * 1000) + nanoTime);
            long j7 = (zzf - nanoTime) / 1000;
            if (zzem(j7)) {
                zzow.beginSection("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzow.endSection();
                zziy zziy = this.zzazz;
                zziy.zzanj++;
                this.zzbja++;
                int i6 = this.zzbjb + 1;
                this.zzbjb = i6;
                zziy.zzank = Math.max(i6, zziy.zzank);
                if (this.zzbja == this.zzbip) {
                    zzjm();
                }
                return true;
            }
            if (zzov.SDK_INT >= 21) {
                if (j7 < 50000) {
                    zza(mediaCodec, i, j5, zzf);
                    return true;
                }
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - TapjoyConstants.TIMER_INCREMENT) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec2, i3, j5);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzow.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzow.endSection();
        this.zzazz.zzani++;
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzjk();
        zzow.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzow.endSection();
        this.zzazz.zzanh++;
        this.zzbjb = 0;
        zzji();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(java.lang.String r7, int r8, int r9) {
        /*
            r0 = -1
            if (r8 == r0) goto L_0x0086
            if (r9 != r0) goto L_0x0007
            goto L_0x0086
        L_0x0007:
            int r1 = r7.hashCode()
            r2 = 5
            r3 = 1
            r4 = 3
            r5 = 4
            r6 = 2
            switch(r1) {
                case -1664118616: goto L_0x0046;
                case -1662541442: goto L_0x003c;
                case 1187890754: goto L_0x0032;
                case 1331836730: goto L_0x0028;
                case 1599127256: goto L_0x001e;
                case 1599127257: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0050
        L_0x0014:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 5
            goto L_0x0051
        L_0x001e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 3
            goto L_0x0051
        L_0x0028:
            java.lang.String r1 = "video/avc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 2
            goto L_0x0051
        L_0x0032:
            java.lang.String r1 = "video/mp4v-es"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 1
            goto L_0x0051
        L_0x003c:
            java.lang.String r1 = "video/hevc"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 4
            goto L_0x0051
        L_0x0046:
            java.lang.String r1 = "video/3gpp"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x0050
            r7 = 0
            goto L_0x0051
        L_0x0050:
            r7 = -1
        L_0x0051:
            if (r7 == 0) goto L_0x007d
            if (r7 == r3) goto L_0x007d
            if (r7 == r6) goto L_0x0061
            if (r7 == r4) goto L_0x007d
            if (r7 == r5) goto L_0x005e
            if (r7 == r2) goto L_0x005e
            return r0
        L_0x005e:
            int r8 = r8 * r9
            goto L_0x0080
        L_0x0061:
            java.lang.String r7 = com.google.android.gms.internal.ads.zzov.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x006c
            return r0
        L_0x006c:
            r7 = 16
            int r8 = com.google.android.gms.internal.ads.zzov.zzf(r8, r7)
            int r7 = com.google.android.gms.internal.ads.zzov.zzf(r9, r7)
            int r8 = r8 * r7
            int r7 = r8 << 4
            int r8 = r7 << 4
            goto L_0x007f
        L_0x007d:
            int r8 = r8 * r9
        L_0x007f:
            r5 = 2
        L_0x0080:
            int r8 = r8 * 3
            int r5 = r5 * 2
            int r8 = r8 / r5
            return r8
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpg.zza(java.lang.String, int, int):int");
    }

    private static boolean zza(boolean z, zzhf zzhf, zzhf zzhf2) {
        if (!zzhf.zzagi.equals(zzhf2.zzagi) || zzj(zzhf) != zzj(zzhf2)) {
            return false;
        }
        if (!z) {
            return zzhf.width == zzhf2.width && zzhf.height == zzhf2.height;
        }
        return true;
    }
}
