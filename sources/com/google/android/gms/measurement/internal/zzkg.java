package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzkr;
import com.google.android.gms.internal.measurement.zzle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p075d.p080b.C3191a;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public class zzkg implements zzgu {
    private static volatile zzkg zza;
    private zzfr zzb;
    private zzfa zzc;
    private zzab zzd;
    private zzfd zze;
    private zzkc zzf;
    private zzq zzg;
    private final zzkk zzh;
    private zzig zzi;
    private final zzfx zzj;
    private boolean zzk;
    private boolean zzl;
    @VisibleForTesting
    private long zzm;
    private List<Runnable> zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private FileLock zzt;
    private FileChannel zzu;
    private List<Long> zzv;
    private List<Long> zzw;
    private long zzx;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    class zza implements zzad {
        zzbw.zzg zza;
        List<Long> zzb;
        List<zzbw.zzc> zzc;
        private long zzd;

        private zza() {
        }

        public final void zza(zzbw.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        /* synthetic */ zza(zzkg zzkg, zzkf zzkf) {
            this();
        }

        public final boolean zza(long j, zzbw.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbn = this.zzd + ((long) zzc2.zzbn());
            if (zzbn >= ((long) Math.max(0, zzas.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbn;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzas.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzbw.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }
    }

    private zzkg(zzkl zzkl) {
        this(zzkl, (zzfx) null);
    }

    public static zzkg zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkg.class) {
                if (zza == null) {
                    zza = new zzkg(new zzkl(context));
                }
            }
        }
        return zza;
    }

    private final void zzaa() {
        zzw();
        if (this.zzq || this.zzr || this.zzs) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzn;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzn.clear();
        }
    }

    @VisibleForTesting
    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (!this.zzj.zzb().zza(zzas.zzbm) || (fileLock = this.zzt) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzu = channel;
                FileLock tryLock = channel.tryLock();
                this.zzt = tryLock;
                if (tryLock != null) {
                    this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final zzfd zzt() {
        zzfd zzfd = this.zze;
        if (zzfd != null) {
            return zzfd;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkc zzv() {
        zzb((zzkd) this.zzf);
        return this.zzf;
    }

    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzff zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().mo26275d_());
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzz() {
        /*
            r21 = this;
            r0 = r21
            r21.zzw()
            r21.zzk()
            long r1 = r0.zzm
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzm
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzfd r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkc r1 = r21.zzv()
            r1.zzf()
            return
        L_0x004b:
            r0.zzm = r3
        L_0x004d:
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            boolean r1 = r1.zzag()
            if (r1 == 0) goto L_0x0255
            boolean r1 = r21.zzy()
            if (r1 != 0) goto L_0x005d
            goto L_0x0255
        L_0x005d:
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzas.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzab r5 = r21.zze()
            boolean r5 = r5.zzz()
            if (r5 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzab r5 = r21.zze()
            boolean r5 = r5.zzk()
            if (r5 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r5 = 0
            goto L_0x0090
        L_0x008f:
            r5 = 1
        L_0x0090:
            if (r5 == 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzfx r10 = r0.zzj
            com.google.android.gms.measurement.internal.zzaa r10 = r10.zzb()
            java.lang.String r10 = r10.zzw()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00bb
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00bb
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzas.zzu
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzas.zzt
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00cc:
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzas.zzs
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzfx r12 = r0.zzj
            com.google.android.gms.measurement.internal.zzff r12 = r12.zzc()
            com.google.android.gms.measurement.internal.zzfj r12 = r12.zzc
            long r12 = r12.zza()
            com.google.android.gms.measurement.internal.zzfx r14 = r0.zzj
            com.google.android.gms.measurement.internal.zzff r14 = r14.zzc()
            com.google.android.gms.measurement.internal.zzfj r14 = r14.zzd
            long r14 = r14.zza()
            com.google.android.gms.measurement.internal.zzab r16 = r21.zze()
            r17 = r10
            long r9 = r16.zzw()
            com.google.android.gms.measurement.internal.zzab r11 = r21.zze()
            r19 = r7
            long r6 = r11.zzx()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0113
        L_0x0110:
            r10 = r3
            goto L_0x0188
        L_0x0113:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x0139
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0139
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x0139:
            com.google.android.gms.measurement.internal.zzkk r5 = r21.zzh()
            r12 = r17
            boolean r5 = r5.zza((long) r8, (long) r12)
            if (r5 != 0) goto L_0x0147
            long r10 = r8 + r12
        L_0x0147:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0188
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0188
            r5 = 0
        L_0x0150:
            r6 = 20
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzas.zzab
            r8 = 0
            java.lang.Object r7 = r7.zza(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r9 = 0
            int r7 = java.lang.Math.max(r9, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0110
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzas.zzaa
            java.lang.Object r12 = r12.zza(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r10 = r10 + r12
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0185
            goto L_0x0188
        L_0x0185:
            int r5 = r5 + 1
            goto L_0x0150
        L_0x0188:
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01aa
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzx()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfd r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkc r1 = r21.zzv()
            r1.zzf()
            return
        L_0x01aa:
            com.google.android.gms.measurement.internal.zzfa r1 = r21.zzd()
            boolean r1 = r1.zzf()
            if (r1 != 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzx()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfd r1 = r21.zzt()
            r1.zza()
            com.google.android.gms.measurement.internal.zzkc r1 = r21.zzv()
            r1.zzf()
            return
        L_0x01d2:
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzff r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zze
            long r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzas.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkk r7 = r21.zzh()
            boolean r7 = r7.zza((long) r1, (long) r5)
            if (r7 != 0) goto L_0x01fe
            long r1 = r1 + r5
            long r10 = java.lang.Math.max(r10, r1)
        L_0x01fe:
            com.google.android.gms.measurement.internal.zzfd r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            long r10 = r10 - r1
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x023a
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzas.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r10 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzff r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzc
            com.google.android.gms.measurement.internal.zzfx r2 = r0.zzj
            com.google.android.gms.common.util.Clock r2 = r2.zzm()
            long r2 = r2.currentTimeMillis()
            r1.zza(r2)
        L_0x023a:
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzkc r1 = r21.zzv()
            r1.zza(r10)
            return
        L_0x0255:
            com.google.android.gms.measurement.internal.zzfx r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzx()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfd r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkc r1 = r21.zzv()
            r1.zzf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zzz():void");
    }

    public final zzaa zzb() {
        return this.zzj.zzb();
    }

    public final zzfr zzc() {
        zzb((zzkd) this.zzb);
        return this.zzb;
    }

    public final zzfa zzd() {
        zzb((zzkd) this.zzc);
        return this.zzc;
    }

    public final zzab zze() {
        zzb((zzkd) this.zzd);
        return this.zzd;
    }

    public final zzq zzf() {
        zzb((zzkd) this.zzg);
        return this.zzg;
    }

    public final zzig zzg() {
        zzb((zzkd) this.zzi);
        return this.zzi;
    }

    public final zzkk zzh() {
        zzb((zzkd) this.zzh);
        return this.zzh;
    }

    public final zzer zzi() {
        return this.zzj.zzj();
    }

    public final zzko zzj() {
        return this.zzj.zzi();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:94|95) */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r1.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzet.zza(r5), r9);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x02ce */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r17 = this;
            r1 = r17
            r17.zzw()
            r17.zzk()
            r0 = 1
            r1.zzs = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x030a }
            r3.zzu()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzin r3 = r3.zzw()     // Catch:{ all -> 0x030a }
            java.lang.Boolean r3 = r3.zzag()     // Catch:{ all -> 0x030a }
            if (r3 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzr()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzi()     // Catch:{ all -> 0x030a }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
            r0.zza(r3)     // Catch:{ all -> 0x030a }
            r1.zzs = r2
            r17.zzaa()
            return
        L_0x0032:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x030a }
            if (r3 == 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzr()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()     // Catch:{ all -> 0x030a }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            r0.zza(r3)     // Catch:{ all -> 0x030a }
            r1.zzs = r2
            r17.zzaa()
            return
        L_0x004d:
            long r3 = r1.zzm     // Catch:{ all -> 0x030a }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x005e
            r17.zzz()     // Catch:{ all -> 0x030a }
            r1.zzs = r2
            r17.zzaa()
            return
        L_0x005e:
            r17.zzw()     // Catch:{ all -> 0x030a }
            java.util.List<java.lang.Long> r3 = r1.zzv     // Catch:{ all -> 0x030a }
            if (r3 == 0) goto L_0x0067
            r3 = 1
            goto L_0x0068
        L_0x0067:
            r3 = 0
        L_0x0068:
            if (r3 == 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzr()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzx()     // Catch:{ all -> 0x030a }
            java.lang.String r3 = "Uploading requested multiple times"
            r0.zza(r3)     // Catch:{ all -> 0x030a }
            r1.zzs = r2
            r17.zzaa()
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzfa r3 = r17.zzd()     // Catch:{ all -> 0x030a }
            boolean r3 = r3.zzf()     // Catch:{ all -> 0x030a }
            if (r3 != 0) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzr()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzx()     // Catch:{ all -> 0x030a }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zza(r3)     // Catch:{ all -> 0x030a }
            r17.zzz()     // Catch:{ all -> 0x030a }
            r1.zzs = r2
            r17.zzaa()
            return
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.common.util.Clock r3 = r3.zzm()     // Catch:{ all -> 0x030a }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzas.zzap     // Catch:{ all -> 0x030a }
            r9 = 0
            int r7 = r7.zzb(r9, r8)     // Catch:{ all -> 0x030a }
            long r10 = com.google.android.gms.measurement.internal.zzaa.zzv()     // Catch:{ all -> 0x030a }
            long r10 = r3 - r10
            r8 = 0
        L_0x00bf:
            if (r8 >= r7) goto L_0x00ca
            boolean r12 = r1.zza((java.lang.String) r9, (long) r10)     // Catch:{ all -> 0x030a }
            if (r12 == 0) goto L_0x00ca
            int r8 = r8 + 1
            goto L_0x00bf
        L_0x00ca:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzff r7 = r7.zzc()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzfj r7 = r7.zzc     // Catch:{ all -> 0x030a }
            long r7 = r7.zza()     // Catch:{ all -> 0x030a }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzr()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzev r5 = r5.zzw()     // Catch:{ all -> 0x030a }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x030a }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x030a }
            r5.zza(r6, r7)     // Catch:{ all -> 0x030a }
        L_0x00f3:
            com.google.android.gms.measurement.internal.zzab r5 = r17.zze()     // Catch:{ all -> 0x030a }
            java.lang.String r5 = r5.mo26275d_()     // Catch:{ all -> 0x030a }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x030a }
            r7 = -1
            if (r6 != 0) goto L_0x02e2
            long r10 = r1.zzx     // Catch:{ all -> 0x030a }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x0113
            com.google.android.gms.measurement.internal.zzab r6 = r17.zze()     // Catch:{ all -> 0x030a }
            long r6 = r6.zzaa()     // Catch:{ all -> 0x030a }
            r1.zzx = r6     // Catch:{ all -> 0x030a }
        L_0x0113:
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzaa r6 = r6.zzb()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzas.zzf     // Catch:{ all -> 0x030a }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzas.zzg     // Catch:{ all -> 0x030a }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x030a }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzab r8 = r17.zze()     // Catch:{ all -> 0x030a }
            java.util.List r6 = r8.zza((java.lang.String) r5, (int) r6, (int) r7)     // Catch:{ all -> 0x030a }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x030a }
            if (r7 != 0) goto L_0x0304
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x030a }
        L_0x0141:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x030a }
            if (r8 == 0) goto L_0x0160
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x030a }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x030a }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzbw$zzg r8 = (com.google.android.gms.internal.measurement.zzbw.zzg) r8     // Catch:{ all -> 0x030a }
            java.lang.String r10 = r8.zzad()     // Catch:{ all -> 0x030a }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x030a }
            if (r10 != 0) goto L_0x0141
            java.lang.String r7 = r8.zzad()     // Catch:{ all -> 0x030a }
            goto L_0x0161
        L_0x0160:
            r7 = r9
        L_0x0161:
            if (r7 == 0) goto L_0x0190
            r8 = 0
        L_0x0164:
            int r10 = r6.size()     // Catch:{ all -> 0x030a }
            if (r8 >= r10) goto L_0x0190
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x030a }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x030a }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzbw$zzg r10 = (com.google.android.gms.internal.measurement.zzbw.zzg) r10     // Catch:{ all -> 0x030a }
            java.lang.String r11 = r10.zzad()     // Catch:{ all -> 0x030a }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x030a }
            if (r11 != 0) goto L_0x018d
            java.lang.String r10 = r10.zzad()     // Catch:{ all -> 0x030a }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x030a }
            if (r10 != 0) goto L_0x018d
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x030a }
            goto L_0x0190
        L_0x018d:
            int r8 = r8 + 1
            goto L_0x0164
        L_0x0190:
            com.google.android.gms.internal.measurement.zzbw$zzf$zza r7 = com.google.android.gms.internal.measurement.zzbw.zzf.zzb()     // Catch:{ all -> 0x030a }
            int r8 = r6.size()     // Catch:{ all -> 0x030a }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x030a }
            int r11 = r6.size()     // Catch:{ all -> 0x030a }
            r10.<init>(r11)     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzfx r11 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzaa r11 = r11.zzb()     // Catch:{ all -> 0x030a }
            boolean r11 = r11.zzf(r5)     // Catch:{ all -> 0x030a }
            r12 = 0
        L_0x01ac:
            if (r12 >= r8) goto L_0x0215
            java.lang.Object r13 = r6.get(r12)     // Catch:{ all -> 0x030a }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x030a }
            java.lang.Object r13 = r13.first     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzbw$zzg r13 = (com.google.android.gms.internal.measurement.zzbw.zzg) r13     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzfi$zzb r13 = r13.zzbm()     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r13 = (com.google.android.gms.internal.measurement.zzbw.zzg.zza) r13     // Catch:{ all -> 0x030a }
            java.lang.Object r14 = r6.get(r12)     // Catch:{ all -> 0x030a }
            android.util.Pair r14 = (android.util.Pair) r14     // Catch:{ all -> 0x030a }
            java.lang.Object r14 = r14.second     // Catch:{ all -> 0x030a }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ all -> 0x030a }
            r10.add(r14)     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzfx r14 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzaa r14 = r14.zzb()     // Catch:{ all -> 0x030a }
            long r14 = r14.zzf()     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r14 = r13.zzg((long) r14)     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r14 = r14.zza((long) r3)     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzfx r15 = r1.zzj     // Catch:{ all -> 0x030a }
            r15.zzu()     // Catch:{ all -> 0x030a }
            r14.zzb((boolean) r2)     // Catch:{ all -> 0x030a }
            if (r11 != 0) goto L_0x01ea
            r13.zzn()     // Catch:{ all -> 0x030a }
        L_0x01ea:
            com.google.android.gms.measurement.internal.zzfx r14 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzaa r14 = r14.zzb()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzas.zzay     // Catch:{ all -> 0x030a }
            boolean r14 = r14.zze(r5, r15)     // Catch:{ all -> 0x030a }
            if (r14 == 0) goto L_0x020f
            com.google.android.gms.internal.measurement.zzgt r14 = r13.zzu()     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzfi r14 = (com.google.android.gms.internal.measurement.zzfi) r14     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzbw$zzg r14 = (com.google.android.gms.internal.measurement.zzbw.zzg) r14     // Catch:{ all -> 0x030a }
            byte[] r14 = r14.zzbi()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzkk r15 = r17.zzh()     // Catch:{ all -> 0x030a }
            long r14 = r15.zza((byte[]) r14)     // Catch:{ all -> 0x030a }
            r13.zzl((long) r14)     // Catch:{ all -> 0x030a }
        L_0x020f:
            r7.zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r13)     // Catch:{ all -> 0x030a }
            int r12 = r12 + 1
            goto L_0x01ac
        L_0x0215:
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzr()     // Catch:{ all -> 0x030a }
            r11 = 2
            boolean r6 = r6.zza((int) r11)     // Catch:{ all -> 0x030a }
            if (r6 == 0) goto L_0x0233
            com.google.android.gms.measurement.internal.zzkk r6 = r17.zzh()     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzgt r11 = r7.zzu()     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzfi r11 = (com.google.android.gms.internal.measurement.zzfi) r11     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzbw$zzf r11 = (com.google.android.gms.internal.measurement.zzbw.zzf) r11     // Catch:{ all -> 0x030a }
            java.lang.String r6 = r6.zza((com.google.android.gms.internal.measurement.zzbw.zzf) r11)     // Catch:{ all -> 0x030a }
            goto L_0x0234
        L_0x0233:
            r6 = r9
        L_0x0234:
            r17.zzh()     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzgt r11 = r7.zzu()     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzfi r11 = (com.google.android.gms.internal.measurement.zzfi) r11     // Catch:{ all -> 0x030a }
            com.google.android.gms.internal.measurement.zzbw$zzf r11 = (com.google.android.gms.internal.measurement.zzbw.zzf) r11     // Catch:{ all -> 0x030a }
            byte[] r14 = r11.zzbi()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzem<java.lang.String> r11 = com.google.android.gms.measurement.internal.zzas.zzp     // Catch:{ all -> 0x030a }
            java.lang.Object r9 = r11.zza(r9)     // Catch:{ all -> 0x030a }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x030a }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x02ce }
            r13.<init>(r9)     // Catch:{ MalformedURLException -> 0x02ce }
            boolean r11 = r10.isEmpty()     // Catch:{ MalformedURLException -> 0x02ce }
            if (r11 != 0) goto L_0x0258
            r11 = 1
            goto L_0x0259
        L_0x0258:
            r11 = 0
        L_0x0259:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r11)     // Catch:{ MalformedURLException -> 0x02ce }
            java.util.List<java.lang.Long> r11 = r1.zzv     // Catch:{ MalformedURLException -> 0x02ce }
            if (r11 == 0) goto L_0x0270
            com.google.android.gms.measurement.internal.zzfx r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzr()     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzf()     // Catch:{ MalformedURLException -> 0x02ce }
            java.lang.String r11 = "Set uploading progress before finishing the previous upload"
            r10.zza(r11)     // Catch:{ MalformedURLException -> 0x02ce }
            goto L_0x0277
        L_0x0270:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x02ce }
            r11.<init>(r10)     // Catch:{ MalformedURLException -> 0x02ce }
            r1.zzv = r11     // Catch:{ MalformedURLException -> 0x02ce }
        L_0x0277:
            com.google.android.gms.measurement.internal.zzfx r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzff r10 = r10.zzc()     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzfj r10 = r10.zzd     // Catch:{ MalformedURLException -> 0x02ce }
            r10.zza(r3)     // Catch:{ MalformedURLException -> 0x02ce }
            java.lang.String r3 = "?"
            if (r8 <= 0) goto L_0x028e
            com.google.android.gms.internal.measurement.zzbw$zzg r3 = r7.zza((int) r2)     // Catch:{ MalformedURLException -> 0x02ce }
            java.lang.String r3 = r3.zzx()     // Catch:{ MalformedURLException -> 0x02ce }
        L_0x028e:
            com.google.android.gms.measurement.internal.zzfx r4 = r1.zzj     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzr()     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzx()     // Catch:{ MalformedURLException -> 0x02ce }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r14.length     // Catch:{ MalformedURLException -> 0x02ce }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x02ce }
            r4.zza(r7, r3, r8, r6)     // Catch:{ MalformedURLException -> 0x02ce }
            r1.zzr = r0     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzfa r11 = r17.zzd()     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzki r0 = new com.google.android.gms.measurement.internal.zzki     // Catch:{ MalformedURLException -> 0x02ce }
            r0.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x02ce }
            r11.zzd()     // Catch:{ MalformedURLException -> 0x02ce }
            r11.zzak()     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzfu r3 = r11.zzq()     // Catch:{ MalformedURLException -> 0x02ce }
            com.google.android.gms.measurement.internal.zzfe r4 = new com.google.android.gms.measurement.internal.zzfe     // Catch:{ MalformedURLException -> 0x02ce }
            r15 = 0
            r10 = r4
            r12 = r5
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x02ce }
            r3.zzb((java.lang.Runnable) r4)     // Catch:{ MalformedURLException -> 0x02ce }
            goto L_0x0304
        L_0x02ce:
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzr()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()     // Catch:{ all -> 0x030a }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x030a }
            r0.zza(r3, r4, r9)     // Catch:{ all -> 0x030a }
            goto L_0x0304
        L_0x02e2:
            r1.zzx = r7     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzab r0 = r17.zze()     // Catch:{ all -> 0x030a }
            long r5 = com.google.android.gms.measurement.internal.zzaa.zzv()     // Catch:{ all -> 0x030a }
            long r3 = r3 - r5
            java.lang.String r0 = r0.zza((long) r3)     // Catch:{ all -> 0x030a }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x030a }
            if (r3 != 0) goto L_0x0304
            com.google.android.gms.measurement.internal.zzab r3 = r17.zze()     // Catch:{ all -> 0x030a }
            com.google.android.gms.measurement.internal.zzg r0 = r3.zzb(r0)     // Catch:{ all -> 0x030a }
            if (r0 == 0) goto L_0x0304
            r1.zza((com.google.android.gms.measurement.internal.zzg) r0)     // Catch:{ all -> 0x030a }
        L_0x0304:
            r1.zzs = r2
            r17.zzaa()
            return
        L_0x030a:
            r0 = move-exception
            r1.zzs = r2
            r17.zzaa()
            goto L_0x0312
        L_0x0311:
            throw r0
        L_0x0312:
            goto L_0x0311
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zzl():void");
    }

    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final Context zzn() {
        return this.zzj.zzn();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzo() {
        zzw();
        zzk();
        if (!this.zzl) {
            this.zzl = true;
            if (zzab()) {
                int zza2 = zza(this.zzu);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                } else if (zza2 >= zzaf) {
                } else {
                    if (zza(zzaf, this.zzu)) {
                        this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    } else {
                        this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        this.zzp++;
    }

    public final zzfu zzq() {
        return this.zzj.zzq();
    }

    public final zzet zzr() {
        return this.zzj.zzr();
    }

    /* access modifiers changed from: package-private */
    public final zzfx zzs() {
        return this.zzj;
    }

    public final zzv zzu() {
        return this.zzj.zzu();
    }

    private zzkg(zzkl zzkl, zzfx zzfx) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkl);
        this.zzj = zzfx.zza(zzkl.zza, (zzaa) null, (Long) null);
        this.zzx = -1;
        zzkk zzkk = new zzkk(this);
        zzkk.zzal();
        this.zzh = zzkk;
        zzfa zzfa = new zzfa(this);
        zzfa.zzal();
        this.zzc = zzfa;
        zzfr zzfr = new zzfr(this);
        zzfr.zzal();
        this.zzb = zzfr;
        this.zzj.zzq().zza((Runnable) new zzkf(this, zzkl));
    }

    private static void zzb(zzkd zzkd) {
        if (zzkd == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkd.zzaj()) {
            String valueOf = String.valueOf(zzkd.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final boolean zze(zzm zzm2) {
        return (!zzle.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzas.zzbo)) ? !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzr) : !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzv) || !TextUtils.isEmpty(zzm2.zzr);
    }

    /* access modifiers changed from: package-private */
    public final zzg zzc(zzm zzm2) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm2.zza);
        zzg zzb2 = zze().zzb(zzm2.zza);
        String zzb3 = this.zzj.zzc().zzb(zzm2.zza);
        if (!zzkr.zzb() || !this.zzj.zzb().zza(zzas.zzbu)) {
            return zza(zzm2, zzb2, zzb3);
        }
        if (zzb2 == null) {
            zzb2 = new zzg(this.zzj, zzm2.zza);
            zzb2.zza(this.zzj.zzi().zzk());
            zzb2.zze(zzb3);
        } else if (!zzb3.equals(zzb2.zzh())) {
            zzb2.zze(zzb3);
            zzb2.zza(this.zzj.zzi().zzk());
        }
        zzb2.zzb(zzm2.zzb);
        zzb2.zzc(zzm2.zzr);
        if (zzle.zzb() && this.zzj.zzb().zze(zzb2.zzc(), zzas.zzbo)) {
            zzb2.zzd(zzm2.zzv);
        }
        if (!TextUtils.isEmpty(zzm2.zzk)) {
            zzb2.zzf(zzm2.zzk);
        }
        long j = zzm2.zze;
        if (j != 0) {
            zzb2.zzd(j);
        }
        if (!TextUtils.isEmpty(zzm2.zzc)) {
            zzb2.zzg(zzm2.zzc);
        }
        zzb2.zzc(zzm2.zzj);
        String str = zzm2.zzd;
        if (str != null) {
            zzb2.zzh(str);
        }
        zzb2.zze(zzm2.zzf);
        zzb2.zza(zzm2.zzh);
        if (!TextUtils.isEmpty(zzm2.zzg)) {
            zzb2.zzi(zzm2.zzg);
        }
        if (!this.zzj.zzb().zza(zzas.zzcm)) {
            zzb2.zzp(zzm2.zzl);
        }
        zzb2.zzb(zzm2.zzo);
        zzb2.zzc(zzm2.zzp);
        zzb2.zza(zzm2.zzs);
        zzb2.zzf(zzm2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzm zzm2) {
        try {
            return (String) this.zzj.zzq().zza(new zzkj(this, zzm2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzet.zza(zzm2.zza), e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0968, code lost:
        r11 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0396 A[Catch:{ SQLiteException -> 0x035e, all -> 0x09f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03cd A[Catch:{ SQLiteException -> 0x035e, all -> 0x09f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0403 A[Catch:{ SQLiteException -> 0x035e, all -> 0x09f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0412 A[Catch:{ SQLiteException -> 0x035e, all -> 0x09f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0446 A[Catch:{ SQLiteException -> 0x035e, all -> 0x09f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x022f A[Catch:{ SQLiteException -> 0x035e, all -> 0x09f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0237 A[Catch:{ SQLiteException -> 0x035e, all -> 0x09f9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(com.google.android.gms.measurement.internal.zzaq r30, com.google.android.gms.measurement.internal.zzm r31) {
        /*
            r29 = this;
            r1 = r29
            r2 = r30
            r3 = r31
            java.lang.String r4 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r31)
            java.lang.String r5 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r29.zzw()
            r29.zzk()
            java.lang.String r15 = r3.zza
            r29.zzh()
            boolean r7 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.measurement.internal.zzaq) r30, (com.google.android.gms.measurement.internal.zzm) r31)
            if (r7 != 0) goto L_0x0026
            return
        L_0x0026:
            boolean r7 = r3.zzh
            if (r7 != 0) goto L_0x002e
            r1.zzc(r3)
            return
        L_0x002e:
            com.google.android.gms.measurement.internal.zzfr r7 = r29.zzc()
            java.lang.String r8 = r2.zza
            boolean r7 = r7.zzb(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            if (r7 == 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzi()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzer r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfr r3 = r29.zzc()
            boolean r3 = r3.zzg(r15)
            if (r3 != 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzfr r3 = r29.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r3 = 0
            goto L_0x0074
        L_0x0073:
            r3 = 1
        L_0x0074:
            if (r3 != 0) goto L_0x008f
            java.lang.String r4 = r2.zza
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzfx r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzko r7 = r4.zzi()
            r9 = 11
            java.lang.String r11 = r2.zza
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)
        L_0x008f:
            if (r3 == 0) goto L_0x00d8
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzb(r15)
            if (r2 == 0) goto L_0x00d8
            long r3 = r2.zzu()
            long r5 = r2.zzt()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzm()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzem<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzas.zzy
            java.lang.Object r5 = r5.zza(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d8
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzw()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zza((com.google.android.gms.measurement.internal.zzg) r2)
        L_0x00d8:
            return
        L_0x00d9:
            boolean r7 = com.google.android.gms.internal.measurement.zzjn.zzb()
            if (r7 == 0) goto L_0x01ba
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzck
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r8)
            if (r7 == 0) goto L_0x01ba
            com.google.android.gms.measurement.internal.zzex r7 = new com.google.android.gms.measurement.internal.zzex
            java.lang.String r8 = r2.zza
            java.lang.String r9 = r2.zzc
            com.google.android.gms.measurement.internal.zzal r10 = r2.zzb
            android.os.Bundle r19 = r10.zzb()
            long r11 = r2.zzd
            r16 = r7
            r17 = r8
            r18 = r9
            r20 = r11
            r16.<init>(r17, r18, r19, r20)
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzko r2 = r2.zzi()
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzaa r8 = r8.zzb()
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.zzas.zzah
            r10 = 25
            r11 = 100
            int r8 = r8.zza(r15, r9, r10, r11)
            java.util.TreeSet r9 = new java.util.TreeSet
            android.os.Bundle r10 = r7.zzd
            java.util.Set r10 = r10.keySet()
            r9.<init>(r10)
            java.util.Iterator r9 = r9.iterator()
            r10 = 0
        L_0x012c:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0199
            java.lang.Object r11 = r9.next()
            java.lang.String r11 = (java.lang.String) r11
            boolean r12 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r11)
            if (r12 == 0) goto L_0x018b
            int r10 = r10 + 1
            if (r10 <= r8) goto L_0x018b
            r12 = 48
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r12)
            java.lang.String r12 = "Event can't contain more than "
            r13.append(r12)
            r13.append(r8)
            java.lang.String r12 = " params"
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            com.google.android.gms.measurement.internal.zzet r13 = r2.zzr()
            com.google.android.gms.measurement.internal.zzev r13 = r13.zzh()
            r30 = r8
            com.google.android.gms.measurement.internal.zzer r8 = r2.zzo()
            r17 = r9
            java.lang.String r9 = r7.zza
            java.lang.String r8 = r8.zza((java.lang.String) r9)
            com.google.android.gms.measurement.internal.zzer r9 = r2.zzo()
            r18 = r2
            android.os.Bundle r2 = r7.zzd
            java.lang.String r2 = r9.zza((android.os.Bundle) r2)
            r13.zza(r12, r8, r2)
            android.os.Bundle r2 = r7.zzd
            r8 = 5
            com.google.android.gms.measurement.internal.zzko.zzb((android.os.Bundle) r2, (int) r8)
            android.os.Bundle r2 = r7.zzd
            r2.remove(r11)
            goto L_0x0191
        L_0x018b:
            r18 = r2
            r30 = r8
            r17 = r9
        L_0x0191:
            r8 = r30
            r9 = r17
            r2 = r18
            r13 = 0
            goto L_0x012c
        L_0x0199:
            com.google.android.gms.measurement.internal.zzaq r2 = new com.google.android.gms.measurement.internal.zzaq
            java.lang.String r8 = r7.zza
            com.google.android.gms.measurement.internal.zzal r9 = new com.google.android.gms.measurement.internal.zzal
            android.os.Bundle r10 = new android.os.Bundle
            android.os.Bundle r11 = r7.zzd
            r10.<init>(r11)
            r9.<init>(r10)
            java.lang.String r10 = r7.zzb
            long r11 = r7.zzc
            r22 = r2
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r22.<init>(r23, r24, r25, r26)
        L_0x01ba:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()
            r8 = 2
            boolean r7 = r7.zza((int) r8)
            if (r7 == 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzfx r9 = r1.zzj
            com.google.android.gms.measurement.internal.zzer r9 = r9.zzj()
            java.lang.String r9 = r9.zza((com.google.android.gms.measurement.internal.zzaq) r2)
            java.lang.String r10 = "Logging event"
            r7.zza(r10, r9)
        L_0x01e0:
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()
            r7.zzf()
            r1.zzc(r3)     // Catch:{ all -> 0x09f9 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjt.zzb()     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x0200
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzas.zzcj     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r9)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x0200
            r7 = 1
            goto L_0x0201
        L_0x0200:
            r7 = 0
        L_0x0201:
            java.lang.String r9 = "ecommerce_purchase"
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x09f9 }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x09f9 }
            java.lang.String r10 = "refund"
            if (r9 != 0) goto L_0x0224
            if (r7 == 0) goto L_0x0222
            java.lang.String r7 = "purchase"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x0224
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09f9 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x0222
            goto L_0x0224
        L_0x0222:
            r7 = 0
            goto L_0x0225
        L_0x0224:
            r7 = 1
        L_0x0225:
            java.lang.String r9 = "_iap"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x09f9 }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x09f9 }
            if (r9 != 0) goto L_0x0234
            if (r7 == 0) goto L_0x0232
            goto L_0x0234
        L_0x0232:
            r9 = 0
            goto L_0x0235
        L_0x0234:
            r9 = 1
        L_0x0235:
            if (r9 == 0) goto L_0x03dc
            com.google.android.gms.measurement.internal.zzal r9 = r2.zzb     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = "currency"
            java.lang.String r9 = r9.zzd(r11)     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = "value"
            if (r7 == 0) goto L_0x02b5
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x09f9 }
            java.lang.Double r7 = r7.zzc(r11)     // Catch:{ all -> 0x09f9 }
            double r12 = r7.doubleValue()     // Catch:{ all -> 0x09f9 }
            r17 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r12 = r12 * r17
            r19 = 0
            int r7 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r7 != 0) goto L_0x026a
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x09f9 }
            java.lang.Long r7 = r7.zzb(r11)     // Catch:{ all -> 0x09f9 }
            long r11 = r7.longValue()     // Catch:{ all -> 0x09f9 }
            double r11 = (double) r11
            java.lang.Double.isNaN(r11)
            double r12 = r11 * r17
        L_0x026a:
            r17 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r7 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r7 > 0) goto L_0x0298
            r17 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r7 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r7 < 0) goto L_0x0298
            long r11 = java.lang.Math.round(r12)     // Catch:{ all -> 0x09f9 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjt.zzb()     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x02bf
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzas.zzcj     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r13)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x02bf
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09f9 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x02bf
            long r11 = -r11
            goto L_0x02bf
        L_0x0298:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzi()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)     // Catch:{ all -> 0x09f9 }
            java.lang.Double r10 = java.lang.Double.valueOf(r12)     // Catch:{ all -> 0x09f9 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x09f9 }
            r22 = r5
            r5 = 0
            r11 = 0
            goto L_0x03cb
        L_0x02b5:
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x09f9 }
            java.lang.Long r7 = r7.zzb(r11)     // Catch:{ all -> 0x09f9 }
            long r11 = r7.longValue()     // Catch:{ all -> 0x09f9 }
        L_0x02bf:
            boolean r7 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x03c7
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ all -> 0x09f9 }
            java.lang.String r7 = r9.toUpperCase(r7)     // Catch:{ all -> 0x09f9 }
            java.lang.String r9 = "[A-Z]{3}"
            boolean r9 = r7.matches(r9)     // Catch:{ all -> 0x09f9 }
            if (r9 == 0) goto L_0x03c7
            java.lang.String r9 = "_ltv_"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x09f9 }
            int r10 = r7.length()     // Catch:{ all -> 0x09f9 }
            if (r10 == 0) goto L_0x02e4
            java.lang.String r7 = r9.concat(r7)     // Catch:{ all -> 0x09f9 }
            goto L_0x02e9
        L_0x02e4:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x09f9 }
            r7.<init>(r9)     // Catch:{ all -> 0x09f9 }
        L_0x02e9:
            r10 = r7
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzkp r7 = r7.zzc(r15, r10)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x0325
            java.lang.Object r9 = r7.zze     // Catch:{ all -> 0x09f9 }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x09f9 }
            if (r9 != 0) goto L_0x02fb
            goto L_0x0325
        L_0x02fb:
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x09f9 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x09f9 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzkp r17 = new com.google.android.gms.measurement.internal.zzkp     // Catch:{ all -> 0x09f9 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r13 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.common.util.Clock r13 = r13.zzm()     // Catch:{ all -> 0x09f9 }
            long r18 = r13.currentTimeMillis()     // Catch:{ all -> 0x09f9 }
            long r7 = r7 + r11
            java.lang.Long r13 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09f9 }
            r7 = r17
            r8 = r15
            r22 = r5
            r5 = 0
            r6 = 1
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09f9 }
        L_0x0322:
            r6 = r17
            goto L_0x038c
        L_0x0325:
            r22 = r5
            r5 = 0
            r6 = 1
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r9 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r9 = r9.zzb()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzas.zzad     // Catch:{ all -> 0x09f9 }
            int r9 = r9.zzb(r15, r13)     // Catch:{ all -> 0x09f9 }
            int r9 = r9 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x09f9 }
            r7.zzd()     // Catch:{ all -> 0x09f9 }
            r7.zzak()     // Catch:{ all -> 0x09f9 }
            android.database.sqlite.SQLiteDatabase r13 = r7.mo26274c_()     // Catch:{ SQLiteException -> 0x035e }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x035e }
            r6[r5] = r15     // Catch:{ SQLiteException -> 0x035e }
            r16 = 1
            r6[r16] = r15     // Catch:{ SQLiteException -> 0x035e }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x035e }
            r16 = 2
            r6[r16] = r9     // Catch:{ SQLiteException -> 0x035e }
            r13.execSQL(r8, r6)     // Catch:{ SQLiteException -> 0x035e }
            goto L_0x0371
        L_0x035e:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzf()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)     // Catch:{ all -> 0x09f9 }
            r7.zza(r8, r9, r6)     // Catch:{ all -> 0x09f9 }
        L_0x0371:
            com.google.android.gms.measurement.internal.zzkp r17 = new com.google.android.gms.measurement.internal.zzkp     // Catch:{ all -> 0x09f9 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.common.util.Clock r6 = r6.zzm()     // Catch:{ all -> 0x09f9 }
            long r18 = r6.currentTimeMillis()     // Catch:{ all -> 0x09f9 }
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x09f9 }
            r7 = r17
            r8 = r15
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09f9 }
            goto L_0x0322
        L_0x038c:
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzkp) r6)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x03ca
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzf()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r10 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzer r10 = r10.zzj()     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = r6.zzc     // Catch:{ all -> 0x09f9 }
            java.lang.String r10 = r10.zzc(r11)     // Catch:{ all -> 0x09f9 }
            java.lang.Object r6 = r6.zze     // Catch:{ all -> 0x09f9 }
            r7.zza(r8, r9, r10, r6)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzko r7 = r6.zzi()     // Catch:{ all -> 0x09f9 }
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x09f9 }
            goto L_0x03ca
        L_0x03c7:
            r22 = r5
            r5 = 0
        L_0x03ca:
            r11 = 1
        L_0x03cb:
            if (r11 != 0) goto L_0x03df
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()     // Catch:{ all -> 0x09f9 }
            r2.mo26273b_()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()
            r2.zzh()
            return
        L_0x03dc:
            r22 = r5
            r5 = 0
        L_0x03df:
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x09f9 }
            boolean r6 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r6)     // Catch:{ all -> 0x09f9 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09f9 }
            boolean r18 = r14.equals(r7)     // Catch:{ all -> 0x09f9 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjt.zzb()     // Catch:{ all -> 0x09f9 }
            r19 = 1
            if (r7 == 0) goto L_0x0412
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzas.zzcf     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x0412
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            r7.zzi()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x09f9 }
            long r7 = com.google.android.gms.measurement.internal.zzko.zza((com.google.android.gms.measurement.internal.zzal) r7)     // Catch:{ all -> 0x09f9 }
            long r7 = r7 + r19
            r11 = r7
            goto L_0x0414
        L_0x0412:
            r11 = r19
        L_0x0414:
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            long r8 = r29.zzx()     // Catch:{ all -> 0x09f9 }
            r13 = 1
            r16 = 0
            r17 = 0
            r10 = r15
            r14 = r6
            r30 = r15
            r15 = r16
            r16 = r18
            com.google.android.gms.measurement.internal.zzae r7 = r7.zza(r8, r10, r11, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x09f9 }
            long r8 = r7.zzb     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzas.zzj     // Catch:{ all -> 0x09f9 }
            r14 = 0
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x09f9 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x09f9 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x09f9 }
            long r10 = (long) r10     // Catch:{ all -> 0x09f9 }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            int r15 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x0473
            long r8 = r8 % r10
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0464
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x09f9 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r30)     // Catch:{ all -> 0x09f9 }
            long r5 = r7.zzb     // Catch:{ all -> 0x09f9 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09f9 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x09f9 }
        L_0x0464:
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()     // Catch:{ all -> 0x09f9 }
            r2.mo26273b_()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()
            r2.zzh()
            return
        L_0x0473:
            if (r6 == 0) goto L_0x04c8
            long r8 = r7.zza     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzas.zzl     // Catch:{ all -> 0x09f9 }
            java.lang.Object r15 = r15.zza(r14)     // Catch:{ all -> 0x09f9 }
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ all -> 0x09f9 }
            int r15 = r15.intValue()     // Catch:{ all -> 0x09f9 }
            long r14 = (long) r15     // Catch:{ all -> 0x09f9 }
            long r8 = r8 - r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x04c8
            long r8 = r8 % r10
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x04a7
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x09f9 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r30)     // Catch:{ all -> 0x09f9 }
            long r6 = r7.zza     // Catch:{ all -> 0x09f9 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x09f9 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x09f9 }
        L_0x04a7:
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzko r7 = r3.zzi()     // Catch:{ all -> 0x09f9 }
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x09f9 }
            r12 = 0
            r8 = r30
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()     // Catch:{ all -> 0x09f9 }
            r2.mo26273b_()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()
            r2.zzh()
            return
        L_0x04c8:
            if (r18 == 0) goto L_0x0517
            long r8 = r7.zzd     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r10 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r10 = r10.zzb()     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzas.zzk     // Catch:{ all -> 0x09f9 }
            int r10 = r10.zzb(r11, r14)     // Catch:{ all -> 0x09f9 }
            r11 = 1000000(0xf4240, float:1.401298E-39)
            int r10 = java.lang.Math.min(r11, r10)     // Catch:{ all -> 0x09f9 }
            int r10 = java.lang.Math.max(r5, r10)     // Catch:{ all -> 0x09f9 }
            long r10 = (long) r10     // Catch:{ all -> 0x09f9 }
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0517
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0508
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x09f9 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r30)     // Catch:{ all -> 0x09f9 }
            long r5 = r7.zzd     // Catch:{ all -> 0x09f9 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09f9 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x09f9 }
        L_0x0508:
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()     // Catch:{ all -> 0x09f9 }
            r2.mo26273b_()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()
            r2.zzh()
            return
        L_0x0517:
            com.google.android.gms.measurement.internal.zzal r7 = r2.zzb     // Catch:{ all -> 0x09f9 }
            android.os.Bundle r14 = r7.zzb()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzko r7 = r7.zzi()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09f9 }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzko r7 = r7.zzi()     // Catch:{ all -> 0x09f9 }
            r15 = r30
            boolean r7 = r7.zzf(r15)     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x0556
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzko r7 = r7.zzi()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = "_dbg"
            java.lang.Long r9 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x09f9 }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzko r7 = r7.zzi()     // Catch:{ all -> 0x09f9 }
            java.lang.Long r8 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x09f9 }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r11, (java.lang.Object) r8)     // Catch:{ all -> 0x09f9 }
        L_0x0556:
            java.lang.String r7 = "_s"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x057d
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzkp r7 = r7.zzc(r8, r4)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x057d
            java.lang.Object r8 = r7.zze     // Catch:{ all -> 0x09f9 }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x09f9 }
            if (r8 == 0) goto L_0x057d
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzko r8 = r8.zzi()     // Catch:{ all -> 0x09f9 }
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x09f9 }
            r8.zza((android.os.Bundle) r14, (java.lang.String) r4, (java.lang.Object) r7)     // Catch:{ all -> 0x09f9 }
        L_0x057d:
            com.google.android.gms.measurement.internal.zzab r4 = r29.zze()     // Catch:{ all -> 0x09f9 }
            long r7 = r4.zzc(r15)     // Catch:{ all -> 0x09f9 }
            int r4 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x05a0
            com.google.android.gms.measurement.internal.zzfx r4 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzi()     // Catch:{ all -> 0x09f9 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)     // Catch:{ all -> 0x09f9 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09f9 }
            r4.zza(r9, r10, r7)     // Catch:{ all -> 0x09f9 }
        L_0x05a0:
            com.google.android.gms.measurement.internal.zzaj r4 = new com.google.android.gms.measurement.internal.zzaj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09f9 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x09f9 }
            long r12 = r2.zzd     // Catch:{ all -> 0x09f9 }
            r18 = 0
            r7 = r4
            r2 = r10
            r10 = r15
            r5 = r11
            r11 = r2
            r16 = r14
            r2 = r15
            r28 = 0
            r14 = r18
            r7.<init>((com.google.android.gms.measurement.internal.zzfx) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r4.zzb     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzam r7 = r7.zza((java.lang.String) r2, (java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x063e
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            long r7 = r7.zzh(r2)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r9 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r9 = r9.zzb()     // Catch:{ all -> 0x09f9 }
            int r9 = r9.zza((java.lang.String) r2)     // Catch:{ all -> 0x09f9 }
            long r9 = (long) r9     // Catch:{ all -> 0x09f9 }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0624
            if (r6 == 0) goto L_0x0624
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x09f9 }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r2)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzj()     // Catch:{ all -> 0x09f9 }
            java.lang.String r4 = r4.zzb     // Catch:{ all -> 0x09f9 }
            java.lang.String r4 = r7.zza((java.lang.String) r4)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x09f9 }
            int r7 = r7.zza((java.lang.String) r2)     // Catch:{ all -> 0x09f9 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x09f9 }
            r3.zza(r5, r6, r4, r7)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzko r7 = r3.zzi()     // Catch:{ all -> 0x09f9 }
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r2
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()
            r2.zzh()
            return
        L_0x0624:
            com.google.android.gms.measurement.internal.zzam r6 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x09f9 }
            java.lang.String r9 = r4.zzb     // Catch:{ all -> 0x09f9 }
            r10 = 0
            r12 = 0
            long r14 = r4.zzc     // Catch:{ all -> 0x09f9 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r6
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x09f9 }
            goto L_0x064c
        L_0x063e:
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x09f9 }
            long r8 = r7.zzf     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaj r4 = r4.zza(r2, r8)     // Catch:{ all -> 0x09f9 }
            long r8 = r4.zzc     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzam r6 = r7.zza(r8)     // Catch:{ all -> 0x09f9 }
        L_0x064c:
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()     // Catch:{ all -> 0x09f9 }
            r2.zza((com.google.android.gms.measurement.internal.zzam) r6)     // Catch:{ all -> 0x09f9 }
            r29.zzw()     // Catch:{ all -> 0x09f9 }
            r29.zzk()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r31)     // Catch:{ all -> 0x09f9 }
            java.lang.String r2 = r4.zza     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x09f9 }
            java.lang.String r2 = r4.zza     // Catch:{ all -> 0x09f9 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x09f9 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r2 = com.google.android.gms.internal.measurement.zzbw.zzg.zzbf()     // Catch:{ all -> 0x09f9 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r2 = r2.zza((int) r6)     // Catch:{ all -> 0x09f9 }
            java.lang.String r7 = "android"
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r2 = r2.zza((java.lang.String) r7)     // Catch:{ all -> 0x09f9 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x068b
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09f9 }
            r2.zzf((java.lang.String) r7)     // Catch:{ all -> 0x09f9 }
        L_0x068b:
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x0698
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x09f9 }
            r2.zze((java.lang.String) r7)     // Catch:{ all -> 0x09f9 }
        L_0x0698:
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x06a5
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x09f9 }
            r2.zzg((java.lang.String) r7)     // Catch:{ all -> 0x09f9 }
        L_0x06a5:
            long r7 = r3.zzj     // Catch:{ all -> 0x09f9 }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x06b4
            long r7 = r3.zzj     // Catch:{ all -> 0x09f9 }
            int r8 = (int) r7     // Catch:{ all -> 0x09f9 }
            r2.zzh((int) r8)     // Catch:{ all -> 0x09f9 }
        L_0x06b4:
            long r7 = r3.zze     // Catch:{ all -> 0x09f9 }
            r2.zzf((long) r7)     // Catch:{ all -> 0x09f9 }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x06c6
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x09f9 }
            r2.zzk((java.lang.String) r7)     // Catch:{ all -> 0x09f9 }
        L_0x06c6:
            boolean r7 = com.google.android.gms.internal.measurement.zzle.zzb()     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x0715
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzas.zzbo     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x0715
            java.lang.String r7 = r2.zzl()     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x06f3
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x06f3
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x09f9 }
            r2.zzp(r7)     // Catch:{ all -> 0x09f9 }
        L_0x06f3:
            java.lang.String r7 = r2.zzl()     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x072c
            java.lang.String r7 = r2.zzo()     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x072c
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x072c
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09f9 }
            r2.zzo(r7)     // Catch:{ all -> 0x09f9 }
            goto L_0x072c
        L_0x0715:
            java.lang.String r7 = r2.zzl()     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x072c
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x072c
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09f9 }
            r2.zzo(r7)     // Catch:{ all -> 0x09f9 }
        L_0x072c:
            long r7 = r3.zzf     // Catch:{ all -> 0x09f9 }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0739
            long r7 = r3.zzf     // Catch:{ all -> 0x09f9 }
            r2.zzh((long) r7)     // Catch:{ all -> 0x09f9 }
        L_0x0739:
            long r7 = r3.zzt     // Catch:{ all -> 0x09f9 }
            r2.zzk((long) r7)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzas.zzaw     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.zze(r8, r11)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x075b
            com.google.android.gms.measurement.internal.zzkk r7 = r29.zzh()     // Catch:{ all -> 0x09f9 }
            java.util.List r7 = r7.zzf()     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x075b
            r2.zzd((java.lang.Iterable<? extends java.lang.Integer>) r7)     // Catch:{ all -> 0x09f9 }
        L_0x075b:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzff r7 = r7.zzc()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09f9 }
            android.util.Pair r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x078e
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x09f9 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ all -> 0x09f9 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x09f9 }
            if (r8 != 0) goto L_0x078e
            boolean r8 = r3.zzo     // Catch:{ all -> 0x09f9 }
            if (r8 == 0) goto L_0x07f0
            java.lang.Object r8 = r7.first     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x09f9 }
            r2.zzh((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            java.lang.Object r8 = r7.second     // Catch:{ all -> 0x09f9 }
            if (r8 == 0) goto L_0x07f0
            java.lang.Object r7 = r7.second     // Catch:{ all -> 0x09f9 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x09f9 }
            r2.zza((boolean) r7)     // Catch:{ all -> 0x09f9 }
            goto L_0x07f0
        L_0x078e:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzak r7 = r7.zzx()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            android.content.Context r8 = r8.zzn()     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.zza(r8)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x07f0
            boolean r7 = r3.zzp     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x07f0
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            android.content.Context r7 = r7.zzn()     // Catch:{ all -> 0x09f9 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r8)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x07d0
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzi()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = "null secure ID. appId"
            java.lang.String r11 = r2.zzj()     // Catch:{ all -> 0x09f9 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r11)     // Catch:{ all -> 0x09f9 }
            r7.zza(r8, r11)     // Catch:{ all -> 0x09f9 }
            java.lang.String r7 = "null"
            goto L_0x07ed
        L_0x07d0:
            boolean r8 = r7.isEmpty()     // Catch:{ all -> 0x09f9 }
            if (r8 == 0) goto L_0x07ed
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzi()     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = "empty secure ID. appId"
            java.lang.String r12 = r2.zzj()     // Catch:{ all -> 0x09f9 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r12)     // Catch:{ all -> 0x09f9 }
            r8.zza(r11, r12)     // Catch:{ all -> 0x09f9 }
        L_0x07ed:
            r2.zzm(r7)     // Catch:{ all -> 0x09f9 }
        L_0x07f0:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzak r7 = r7.zzx()     // Catch:{ all -> 0x09f9 }
            r7.zzaa()     // Catch:{ all -> 0x09f9 }
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r7 = r2.zzc((java.lang.String) r7)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzak r8 = r8.zzx()     // Catch:{ all -> 0x09f9 }
            r8.zzaa()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r7 = r7.zzb((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzak r8 = r8.zzx()     // Catch:{ all -> 0x09f9 }
            long r11 = r8.zzf()     // Catch:{ all -> 0x09f9 }
            int r8 = (int) r11     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r7 = r7.zzf((int) r8)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzak r8 = r8.zzx()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x09f9 }
            r7.zzd((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzcm     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r8)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x083d
            long r7 = r3.zzl     // Catch:{ all -> 0x09f9 }
            r2.zzj((long) r7)     // Catch:{ all -> 0x09f9 }
        L_0x083d:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x09f9 }
            boolean r7 = r7.zzab()     // Catch:{ all -> 0x09f9 }
            if (r7 == 0) goto L_0x0853
            r2.zzj()     // Catch:{ all -> 0x09f9 }
            boolean r7 = android.text.TextUtils.isEmpty(r28)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x0853
            r7 = r28
            r2.zzn(r7)     // Catch:{ all -> 0x09f9 }
        L_0x0853:
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzb(r8)     // Catch:{ all -> 0x09f9 }
            if (r7 != 0) goto L_0x08d4
            com.google.android.gms.measurement.internal.zzg r7 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09f9 }
            r7.<init>(r8, r11)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzko r8 = r8.zzi()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r8.zzk()     // Catch:{ all -> 0x09f9 }
            r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zzk     // Catch:{ all -> 0x09f9 }
            r7.zzf((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x09f9 }
            r7.zzb((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzff r8 = r8.zzc()     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r8.zzb((java.lang.String) r11)     // Catch:{ all -> 0x09f9 }
            r7.zze((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            r7.zzg((long) r9)     // Catch:{ all -> 0x09f9 }
            r7.zza((long) r9)     // Catch:{ all -> 0x09f9 }
            r7.zzb((long) r9)     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x09f9 }
            r7.zzg((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            long r11 = r3.zzj     // Catch:{ all -> 0x09f9 }
            r7.zzc((long) r11)     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x09f9 }
            r7.zzh((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            long r11 = r3.zze     // Catch:{ all -> 0x09f9 }
            r7.zzd((long) r11)     // Catch:{ all -> 0x09f9 }
            long r11 = r3.zzf     // Catch:{ all -> 0x09f9 }
            r7.zze((long) r11)     // Catch:{ all -> 0x09f9 }
            boolean r8 = r3.zzh     // Catch:{ all -> 0x09f9 }
            r7.zza((boolean) r8)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r8 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r8 = r8.zzb()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzas.zzcm     // Catch:{ all -> 0x09f9 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r11)     // Catch:{ all -> 0x09f9 }
            if (r8 != 0) goto L_0x08c8
            long r11 = r3.zzl     // Catch:{ all -> 0x09f9 }
            r7.zzp(r11)     // Catch:{ all -> 0x09f9 }
        L_0x08c8:
            long r11 = r3.zzt     // Catch:{ all -> 0x09f9 }
            r7.zzf((long) r11)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r8 = r29.zze()     // Catch:{ all -> 0x09f9 }
            r8.zza((com.google.android.gms.measurement.internal.zzg) r7)     // Catch:{ all -> 0x09f9 }
        L_0x08d4:
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x09f9 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x09f9 }
            if (r8 != 0) goto L_0x08e5
            java.lang.String r8 = r7.zzd()     // Catch:{ all -> 0x09f9 }
            r2.zzi((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
        L_0x08e5:
            java.lang.String r8 = r7.zzi()     // Catch:{ all -> 0x09f9 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x09f9 }
            if (r8 != 0) goto L_0x08f6
            java.lang.String r7 = r7.zzi()     // Catch:{ all -> 0x09f9 }
            r2.zzl((java.lang.String) r7)     // Catch:{ all -> 0x09f9 }
        L_0x08f6:
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x09f9 }
            java.util.List r3 = r7.zza((java.lang.String) r3)     // Catch:{ all -> 0x09f9 }
            r11 = 0
        L_0x0901:
            int r7 = r3.size()     // Catch:{ all -> 0x09f9 }
            if (r11 >= r7) goto L_0x0938
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r7 = com.google.android.gms.internal.measurement.zzbw.zzk.zzj()     // Catch:{ all -> 0x09f9 }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzkp r8 = (com.google.android.gms.measurement.internal.zzkp) r8     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r8.zzc     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x09f9 }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzkp r8 = (com.google.android.gms.measurement.internal.zzkp) r8     // Catch:{ all -> 0x09f9 }
            long r12 = r8.zzd     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r7 = r7.zza((long) r12)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzkk r8 = r29.zzh()     // Catch:{ all -> 0x09f9 }
            java.lang.Object r12 = r3.get(r11)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzkp r12 = (com.google.android.gms.measurement.internal.zzkp) r12     // Catch:{ all -> 0x09f9 }
            java.lang.Object r12 = r12.zze     // Catch:{ all -> 0x09f9 }
            r8.zza((com.google.android.gms.internal.measurement.zzbw.zzk.zza) r7, (java.lang.Object) r12)     // Catch:{ all -> 0x09f9 }
            r2.zza((com.google.android.gms.internal.measurement.zzbw.zzk.zza) r7)     // Catch:{ all -> 0x09f9 }
            int r11 = r11 + 1
            goto L_0x0901
        L_0x0938:
            com.google.android.gms.measurement.internal.zzab r3 = r29.zze()     // Catch:{ IOException -> 0x09ad }
            com.google.android.gms.internal.measurement.zzgt r7 = r2.zzu()     // Catch:{ IOException -> 0x09ad }
            com.google.android.gms.internal.measurement.zzfi r7 = (com.google.android.gms.internal.measurement.zzfi) r7     // Catch:{ IOException -> 0x09ad }
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = (com.google.android.gms.internal.measurement.zzbw.zzg) r7     // Catch:{ IOException -> 0x09ad }
            long r2 = r3.zza((com.google.android.gms.internal.measurement.zzbw.zzg) r7)     // Catch:{ IOException -> 0x09ad }
            com.google.android.gms.measurement.internal.zzab r7 = r29.zze()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzal r8 = r4.zze     // Catch:{ all -> 0x09f9 }
            if (r8 == 0) goto L_0x09a3
            com.google.android.gms.measurement.internal.zzal r8 = r4.zze     // Catch:{ all -> 0x09f9 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x09f9 }
        L_0x0956:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x09f9 }
            if (r11 == 0) goto L_0x096a
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x09f9 }
            boolean r11 = r5.equals(r11)     // Catch:{ all -> 0x09f9 }
            if (r11 == 0) goto L_0x0956
        L_0x0968:
            r11 = 1
            goto L_0x09a4
        L_0x096a:
            com.google.android.gms.measurement.internal.zzfr r5 = r29.zzc()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r4.zza     // Catch:{ all -> 0x09f9 }
            java.lang.String r11 = r4.zzb     // Catch:{ all -> 0x09f9 }
            boolean r5 = r5.zzc(r8, r11)     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r11 = r29.zze()     // Catch:{ all -> 0x09f9 }
            long r12 = r29.zzx()     // Catch:{ all -> 0x09f9 }
            java.lang.String r14 = r4.zza     // Catch:{ all -> 0x09f9 }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            com.google.android.gms.measurement.internal.zzae r8 = r11.zza(r12, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x09f9 }
            if (r5 == 0) goto L_0x09a3
            long r11 = r8.zze     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzaa r5 = r5.zzb()     // Catch:{ all -> 0x09f9 }
            java.lang.String r8 = r4.zza     // Catch:{ all -> 0x09f9 }
            int r5 = r5.zzb(r8)     // Catch:{ all -> 0x09f9 }
            long r13 = (long) r5     // Catch:{ all -> 0x09f9 }
            int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x09a3
            goto L_0x0968
        L_0x09a3:
            r11 = 0
        L_0x09a4:
            boolean r2 = r7.zza((com.google.android.gms.measurement.internal.zzaj) r4, (long) r2, (boolean) r11)     // Catch:{ all -> 0x09f9 }
            if (r2 == 0) goto L_0x09c6
            r1.zzm = r9     // Catch:{ all -> 0x09f9 }
            goto L_0x09c6
        L_0x09ad:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfx r4 = r1.zzj     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzet r4 = r4.zzr()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()     // Catch:{ all -> 0x09f9 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzj()     // Catch:{ all -> 0x09f9 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r2)     // Catch:{ all -> 0x09f9 }
            r4.zza(r5, r2, r3)     // Catch:{ all -> 0x09f9 }
        L_0x09c6:
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()     // Catch:{ all -> 0x09f9 }
            r2.mo26273b_()     // Catch:{ all -> 0x09f9 }
            com.google.android.gms.measurement.internal.zzab r2 = r29.zze()
            r2.zzh()
            r29.zzz()
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzx()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r22
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x09f9:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzab r3 = r29.zze()
            r3.zzh()
            goto L_0x0a04
        L_0x0a03:
            throw r2
        L_0x0a04:
            goto L_0x0a03
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zzb(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzm):void");
    }

    /* access modifiers changed from: private */
    public final void zza(zzkl zzkl) {
        this.zzj.zzq().zzd();
        zzab zzab = new zzab(this);
        zzab.zzal();
        this.zzd = zzab;
        this.zzj.zzb().zza((zzac) this.zzb);
        zzq zzq2 = new zzq(this);
        zzq2.zzal();
        this.zzg = zzq2;
        zzig zzig = new zzig(this);
        zzig.zzal();
        this.zzi = zzig;
        zzkc zzkc = new zzkc(this);
        zzkc.zzal();
        this.zzf = zzkc;
        this.zze = new zzfd(this);
        if (this.zzo != this.zzp) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzo), Integer.valueOf(this.zzp));
        }
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaq zzaq, String str) {
        zzaq zzaq2 = zzaq;
        zzg zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzaq2.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzet.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzet.zza(str));
            return;
        }
        zzm zzm2 = r2;
        zzm zzm3 = new zzm(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzle.zzb() || !this.zzj.zzb().zze(zzb2.zzc(), zzas.zzbo)) ? null : zzb2.zzg());
        zza(zzaq2, zzm2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaq zzaq, zzm zzm2) {
        List<zzy> list;
        List<zzy> list2;
        List<zzy> list3;
        List<String> list4;
        zzaq zzaq2 = zzaq;
        zzm zzm3 = zzm2;
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm3.zza);
        zzw();
        zzk();
        String str = zzm3.zza;
        long j = zzaq2.zzd;
        zzh();
        if (zzkk.zza(zzaq, zzm2)) {
            if (!zzm3.zzh) {
                zzc(zzm3);
                return;
            }
            if (this.zzj.zzb().zze(str, zzas.zzbc) && (list4 = zzm3.zzu) != null) {
                if (list4.contains(zzaq2.zza)) {
                    Bundle zzb2 = zzaq2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzaq2 = new zzaq(zzaq2.zza, new zzal(zzb2), zzaq2.zzc, zzaq2.zzd);
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str, zzaq2.zza, zzaq2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzab zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzd();
                zze2.zzak();
                if (j < 0) {
                    zze2.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzet.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzy next : list) {
                    if (next != null) {
                        this.zzj.zzr().zzx().zza("User property timed out", next.zza, this.zzj.zzj().zzc(next.zzc.zza), next.zzc.zza());
                        if (next.zzg != null) {
                            zzb(new zzaq(next.zzg, j), zzm3);
                        }
                        zze().zze(str, next.zzc.zza);
                    }
                }
                zzab zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzd();
                zze3.zzak();
                if (j < 0) {
                    zze3.zzr().zzi().zza("Invalid time querying expired conditional properties", zzet.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzy next2 : list2) {
                    if (next2 != null) {
                        this.zzj.zzr().zzx().zza("User property expired", next2.zza, this.zzj.zzj().zzc(next2.zzc.zza), next2.zzc.zza());
                        zze().zzb(str, next2.zzc.zza);
                        if (next2.zzk != null) {
                            arrayList.add(next2.zzk);
                        }
                        zze().zze(str, next2.zzc.zza);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zzb(new zzaq((zzaq) obj, j), zzm3);
                }
                zzab zze4 = zze();
                String str2 = zzaq2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzd();
                zze4.zzak();
                if (j < 0) {
                    zze4.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzet.zza(str), zze4.zzo().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzy next3 : list3) {
                    if (next3 != null) {
                        zzkn zzkn = next3.zzc;
                        zzkp zzkp = r4;
                        zzkp zzkp2 = new zzkp(next3.zza, next3.zzb, zzkn.zza, j, zzkn.zza());
                        if (zze().zza(zzkp)) {
                            this.zzj.zzr().zzx().zza("User property triggered", next3.zza, this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                        } else {
                            this.zzj.zzr().zzf().zza("Too many active user properties, ignoring", zzet.zza(next3.zza), this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                        }
                        if (next3.zzi != null) {
                            arrayList2.add(next3.zzi);
                        }
                        next3.zzc = new zzkn(zzkp);
                        next3.zze = true;
                        zze().zza(next3);
                    }
                }
                zzb(zzaq2, zzm3);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    zzb(new zzaq((zzaq) obj2, j), zzm3);
                }
                zze().mo26273b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x0265 A[SYNTHETIC, Splitter:B:118:0x0265] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x026c A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x027a A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03bd A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03bf A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x03c2 A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03c3 A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x05b9 A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0690 A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x082b A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0847 A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0861 A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x0ba2 A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x0bb5 A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x0bb8 A[Catch:{ IOException -> 0x0229, all -> 0x0f65 }] */
    /* JADX WARNING: Removed duplicated region for block: B:452:0x0bdf A[SYNTHETIC, Splitter:B:452:0x0bdf] */
    /* JADX WARNING: Removed duplicated region for block: B:566:0x0f48  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0f5f A[SYNTHETIC, Splitter:B:574:0x0f5f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r44, long r45) {
        /*
            r43 = this;
            r1 = r43
            java.lang.String r2 = "_npa"
            java.lang.String r3 = ""
            com.google.android.gms.measurement.internal.zzab r4 = r43.zze()
            r4.zzf()
            com.google.android.gms.measurement.internal.zzkg$zza r4 = new com.google.android.gms.measurement.internal.zzkg$zza     // Catch:{ all -> 0x0f65 }
            r5 = 0
            r4.<init>(r1, r5)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzab r6 = r43.zze()     // Catch:{ all -> 0x0f65 }
            long r7 = r1.zzx     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0f65 }
            r6.zzd()     // Catch:{ all -> 0x0f65 }
            r6.zzak()     // Catch:{ all -> 0x0f65 }
            r10 = -1
            r12 = 2
            r13 = 0
            r14 = 1
            android.database.sqlite.SQLiteDatabase r15 = r6.mo26274c_()     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            boolean r16 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            if (r16 == 0) goto L_0x0097
            int r16 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r16 == 0) goto L_0x0049
            java.lang.String[] r9 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r16 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0044 }
            r9[r13] = r16     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r16 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x0044 }
            r9[r14] = r16     // Catch:{ SQLiteException -> 0x0044 }
            goto L_0x0051
        L_0x0044:
            r0 = move-exception
            r7 = r0
            r9 = r5
            goto L_0x0252
        L_0x0049:
            java.lang.String[] r9 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            java.lang.String r16 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            r9[r13] = r16     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
        L_0x0051:
            int r16 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r16 == 0) goto L_0x005a
            java.lang.String r16 = "rowid <= ? and "
            r45 = r16
            goto L_0x005c
        L_0x005a:
            r45 = r3
        L_0x005c:
            int r5 = r45.length()     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            int r5 = r5 + 148
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            r12.<init>(r5)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            java.lang.String r5 = "select app_id, metadata_fingerprint from raw_events where "
            r12.append(r5)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            r5 = r45
            r12.append(r5)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r12.append(r5)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            java.lang.String r5 = r12.toString()     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            android.database.Cursor r5 = r15.rawQuery(r5, r9)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            boolean r9 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0245 }
            if (r9 != 0) goto L_0x008b
            if (r5 == 0) goto L_0x0268
            r5.close()     // Catch:{ all -> 0x0f65 }
            goto L_0x0268
        L_0x008b:
            java.lang.String r9 = r5.getString(r13)     // Catch:{ SQLiteException -> 0x0245 }
            java.lang.String r12 = r5.getString(r14)     // Catch:{ SQLiteException -> 0x0242 }
            r5.close()     // Catch:{ SQLiteException -> 0x0242 }
            goto L_0x00ea
        L_0x0097:
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x00a8
            r5 = 2
            java.lang.String[] r9 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            r5 = 0
            r9[r13] = r5     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            java.lang.String r5 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            r9[r14] = r5     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            goto L_0x00ad
        L_0x00a8:
            java.lang.String[] r9 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            r5 = 0
            r9[r13] = r5     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
        L_0x00ad:
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x00b4
            java.lang.String r5 = " and rowid <= ?"
            goto L_0x00b5
        L_0x00b4:
            r5 = r3
        L_0x00b5:
            int r12 = r5.length()     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            int r12 = r12 + 84
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            r10.<init>(r12)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            java.lang.String r11 = "select metadata_fingerprint from raw_events where app_id = ?"
            r10.append(r11)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            r10.append(r5)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            java.lang.String r5 = " order by rowid limit 1;"
            r10.append(r5)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            java.lang.String r5 = r10.toString()     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            android.database.Cursor r5 = r15.rawQuery(r5, r9)     // Catch:{ SQLiteException -> 0x024e, all -> 0x0248 }
            boolean r9 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0245 }
            if (r9 != 0) goto L_0x00e2
            if (r5 == 0) goto L_0x0268
            r5.close()     // Catch:{ all -> 0x0f65 }
            goto L_0x0268
        L_0x00e2:
            java.lang.String r12 = r5.getString(r13)     // Catch:{ SQLiteException -> 0x0245 }
            r5.close()     // Catch:{ SQLiteException -> 0x0245 }
            r9 = 0
        L_0x00ea:
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String[] r10 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r11 = "metadata"
            r10[r13] = r11     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            r11 = 2
            java.lang.String[] r14 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0242 }
            r14[r13] = r9     // Catch:{ SQLiteException -> 0x0242 }
            r11 = 1
            r14[r11] = r12     // Catch:{ SQLiteException -> 0x0242 }
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            java.lang.String r23 = "2"
            r11 = r15
            r15 = r11
            r17 = r10
            r19 = r14
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0242 }
            boolean r10 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0242 }
            if (r10 != 0) goto L_0x012c
            com.google.android.gms.measurement.internal.zzet r7 = r6.zzr()     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzf()     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r8 = "Raw event metadata record is missing. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0242 }
            r7.zza(r8, r10)     // Catch:{ SQLiteException -> 0x0242 }
            if (r5 == 0) goto L_0x0268
            r5.close()     // Catch:{ all -> 0x0f65 }
            goto L_0x0268
        L_0x012c:
            byte[] r10 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r14 = com.google.android.gms.internal.measurement.zzbw.zzg.zzbf()     // Catch:{ IOException -> 0x0229 }
            com.google.android.gms.internal.measurement.zzgs r10 = com.google.android.gms.measurement.internal.zzkk.zza(r14, (byte[]) r10)     // Catch:{ IOException -> 0x0229 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r10 = (com.google.android.gms.internal.measurement.zzbw.zzg.zza) r10     // Catch:{ IOException -> 0x0229 }
            com.google.android.gms.internal.measurement.zzgt r10 = r10.zzu()     // Catch:{ IOException -> 0x0229 }
            com.google.android.gms.internal.measurement.zzfi r10 = (com.google.android.gms.internal.measurement.zzfi) r10     // Catch:{ IOException -> 0x0229 }
            com.google.android.gms.internal.measurement.zzbw$zzg r10 = (com.google.android.gms.internal.measurement.zzbw.zzg) r10     // Catch:{ IOException -> 0x0229 }
            boolean r14 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0242 }
            if (r14 == 0) goto L_0x0159
            com.google.android.gms.measurement.internal.zzet r14 = r6.zzr()     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.measurement.internal.zzev r14 = r14.zzi()     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r15 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0242 }
            r14.zza(r15, r13)     // Catch:{ SQLiteException -> 0x0242 }
        L_0x0159:
            r5.close()     // Catch:{ SQLiteException -> 0x0242 }
            r4.zza(r10)     // Catch:{ SQLiteException -> 0x0242 }
            r13 = -1
            int r10 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x017c
            java.lang.String r10 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0242 }
            r13 = 0
            r14[r13] = r9     // Catch:{ SQLiteException -> 0x0242 }
            r13 = 1
            r14[r13] = r12     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0242 }
            r8 = 2
            r14[r8] = r7     // Catch:{ SQLiteException -> 0x0242 }
            r18 = r10
            r19 = r14
            goto L_0x018b
        L_0x017c:
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            r8 = 2
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0242 }
            r8 = 0
            r10[r8] = r9     // Catch:{ SQLiteException -> 0x0242 }
            r8 = 1
            r10[r8] = r12     // Catch:{ SQLiteException -> 0x0242 }
            r18 = r7
            r19 = r10
        L_0x018b:
            java.lang.String r16 = "raw_events"
            r7 = 4
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r8 = "rowid"
            r10 = 0
            r7[r10] = r8     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r8 = "name"
            r10 = 1
            r7[r10] = r8     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r8 = "timestamp"
            r10 = 2
            r7[r10] = r8     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r8 = "data"
            r10 = 3
            r7[r10] = r8     // Catch:{ SQLiteException -> 0x0242 }
            r20 = 0
            r21 = 0
            java.lang.String r22 = "rowid"
            r23 = 0
            r15 = r11
            r17 = r7
            android.database.Cursor r5 = r15.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0242 }
            boolean r7 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0242 }
            if (r7 != 0) goto L_0x01d1
            com.google.android.gms.measurement.internal.zzet r7 = r6.zzr()     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzi()     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r8 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0242 }
            r7.zza(r8, r10)     // Catch:{ SQLiteException -> 0x0242 }
            if (r5 == 0) goto L_0x0268
            r5.close()     // Catch:{ all -> 0x0f65 }
            goto L_0x0268
        L_0x01d1:
            r7 = 0
            long r10 = r5.getLong(r7)     // Catch:{ SQLiteException -> 0x0242 }
            r7 = 3
            byte[] r8 = r5.getBlob(r7)     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r7 = com.google.android.gms.internal.measurement.zzbw.zzc.zzj()     // Catch:{ IOException -> 0x020a }
            com.google.android.gms.internal.measurement.zzgs r7 = com.google.android.gms.measurement.internal.zzkk.zza(r7, (byte[]) r8)     // Catch:{ IOException -> 0x020a }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r7     // Catch:{ IOException -> 0x020a }
            r8 = 1
            java.lang.String r12 = r5.getString(r8)     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r8 = r7.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0242 }
            r12 = 2
            long r13 = r5.getLong(r12)     // Catch:{ SQLiteException -> 0x0242 }
            r8.zza((long) r13)     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.internal.measurement.zzgt r7 = r7.zzu()     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.internal.measurement.zzfi r7 = (com.google.android.gms.internal.measurement.zzfi) r7     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.internal.measurement.zzbw$zzc r7 = (com.google.android.gms.internal.measurement.zzbw.zzc) r7     // Catch:{ SQLiteException -> 0x0242 }
            boolean r7 = r4.zza(r10, r7)     // Catch:{ SQLiteException -> 0x0242 }
            if (r7 != 0) goto L_0x021d
            if (r5 == 0) goto L_0x0268
            r5.close()     // Catch:{ all -> 0x0f65 }
            goto L_0x0268
        L_0x020a:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzet r8 = r6.zzr()     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzf()     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r10 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0242 }
            r8.zza(r10, r11, r7)     // Catch:{ SQLiteException -> 0x0242 }
        L_0x021d:
            boolean r7 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0242 }
            if (r7 != 0) goto L_0x01d1
            if (r5 == 0) goto L_0x0268
            r5.close()     // Catch:{ all -> 0x0f65 }
            goto L_0x0268
        L_0x0229:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzet r8 = r6.zzr()     // Catch:{ SQLiteException -> 0x0242 }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzf()     // Catch:{ SQLiteException -> 0x0242 }
            java.lang.String r10 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0242 }
            r8.zza(r10, r11, r7)     // Catch:{ SQLiteException -> 0x0242 }
            if (r5 == 0) goto L_0x0268
            r5.close()     // Catch:{ all -> 0x0f65 }
            goto L_0x0268
        L_0x0242:
            r0 = move-exception
            r7 = r0
            goto L_0x0252
        L_0x0245:
            r0 = move-exception
            r7 = r0
            goto L_0x0251
        L_0x0248:
            r0 = move-exception
            r2 = r1
            r5 = 0
        L_0x024b:
            r1 = r0
            goto L_0x0f5d
        L_0x024e:
            r0 = move-exception
            r7 = r0
            r5 = 0
        L_0x0251:
            r9 = 0
        L_0x0252:
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzr()     // Catch:{ all -> 0x0f59 }
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzf()     // Catch:{ all -> 0x0f59 }
            java.lang.String r8 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ all -> 0x0f59 }
            r6.zza(r8, r9, r7)     // Catch:{ all -> 0x0f59 }
            if (r5 == 0) goto L_0x0268
            r5.close()     // Catch:{ all -> 0x0f65 }
        L_0x0268:
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r5 = r4.zzc     // Catch:{ all -> 0x0f65 }
            if (r5 == 0) goto L_0x0277
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r5 = r4.zzc     // Catch:{ all -> 0x0f65 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0f65 }
            if (r5 == 0) goto L_0x0275
            goto L_0x0277
        L_0x0275:
            r5 = 0
            goto L_0x0278
        L_0x0277:
            r5 = 1
        L_0x0278:
            if (r5 != 0) goto L_0x0f48
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi$zzb r5 = r5.zzbm()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r5 = (com.google.android.gms.internal.measurement.zzbw.zzg.zza) r5     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r5 = r5.zzc()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzfx r6 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzaa r6 = r6.zzb()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzau     // Catch:{ all -> 0x0f65 }
            boolean r6 = r6.zze(r7, r8)     // Catch:{ all -> 0x0f65 }
            r7 = -1
            r8 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x02a1:
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r9 = r4.zzc     // Catch:{ all -> 0x0f65 }
            int r9 = r9.size()     // Catch:{ all -> 0x0f65 }
            r18 = r3
            java.lang.String r3 = "_fr"
            r19 = r13
            java.lang.String r13 = "_et"
            r20 = r2
            java.lang.String r2 = "_e"
            r21 = r14
            r22 = r15
            if (r12 >= r9) goto L_0x08bd
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r9 = r4.zzc     // Catch:{ all -> 0x0f65 }
            java.lang.Object r9 = r9.get(r12)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r9 = (com.google.android.gms.internal.measurement.zzbw.zzc) r9     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi$zzb r9 = r9.zzbm()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r9 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzfr r14 = r43.zzc()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r15 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0f65 }
            r16 = r12
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            boolean r12 = r14.zzb(r15, r12)     // Catch:{ all -> 0x0f65 }
            java.lang.String r14 = "_err"
            if (r12 == 0) goto L_0x035c
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzi()     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r12 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r12)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzfx r13 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzj()     // Catch:{ all -> 0x0f65 }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            java.lang.String r13 = r13.zza((java.lang.String) r15)     // Catch:{ all -> 0x0f65 }
            r2.zza(r3, r12, r13)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzfr r2 = r43.zzc()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r3 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0f65 }
            boolean r2 = r2.zzg(r3)     // Catch:{ all -> 0x0f65 }
            if (r2 != 0) goto L_0x0329
            com.google.android.gms.measurement.internal.zzfr r2 = r43.zzc()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r3 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0f65 }
            boolean r2 = r2.zzh(r3)     // Catch:{ all -> 0x0f65 }
            if (r2 == 0) goto L_0x0327
            goto L_0x0329
        L_0x0327:
            r2 = 0
            goto L_0x032a
        L_0x0329:
            r2 = 1
        L_0x032a:
            if (r2 != 0) goto L_0x034f
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            boolean r2 = r14.equals(r2)     // Catch:{ all -> 0x0f65 }
            if (r2 != 0) goto L_0x034f
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzko r24 = r2.zzi()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r2 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r25 = r2.zzx()     // Catch:{ all -> 0x0f65 }
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            r29 = 0
            r24.zza((java.lang.String) r25, (int) r26, (java.lang.String) r27, (java.lang.String) r28, (int) r29)     // Catch:{ all -> 0x0f65 }
        L_0x034f:
            r26 = r6
            r12 = r16
            r13 = r19
            r14 = r21
            r15 = r22
            r6 = r5
            goto L_0x08b2
        L_0x035c:
            com.google.android.gms.measurement.internal.zzfr r12 = r43.zzc()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r15 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0f65 }
            r26 = r6
            java.lang.String r6 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            boolean r6 = r12.zzc(r15, r6)     // Catch:{ all -> 0x0f65 }
            java.lang.String r12 = "_c"
            if (r6 != 0) goto L_0x03ce
            r43.zzh()     // Catch:{ all -> 0x0f65 }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0f65 }
            r27 = r7
            int r7 = r15.hashCode()     // Catch:{ all -> 0x0f65 }
            r28 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r7 == r10) goto L_0x03aa
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r7 == r10) goto L_0x03a0
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r7 == r10) goto L_0x0396
            goto L_0x03b4
        L_0x0396:
            java.lang.String r7 = "_ui"
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0f65 }
            if (r7 == 0) goto L_0x03b4
            r7 = 1
            goto L_0x03b5
        L_0x03a0:
            java.lang.String r7 = "_ug"
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0f65 }
            if (r7 == 0) goto L_0x03b4
            r7 = 2
            goto L_0x03b5
        L_0x03aa:
            java.lang.String r7 = "_in"
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x0f65 }
            if (r7 == 0) goto L_0x03b4
            r7 = 0
            goto L_0x03b5
        L_0x03b4:
            r7 = -1
        L_0x03b5:
            if (r7 == 0) goto L_0x03bf
            r10 = 1
            if (r7 == r10) goto L_0x03bf
            r10 = 2
            if (r7 == r10) goto L_0x03bf
            r7 = 0
            goto L_0x03c0
        L_0x03bf:
            r7 = 1
        L_0x03c0:
            if (r7 == 0) goto L_0x03c3
            goto L_0x03d2
        L_0x03c3:
            r30 = r5
            r31 = r8
            r10 = r11
            r29 = r13
            r13 = r2
            r11 = r3
            goto L_0x05b7
        L_0x03ce:
            r27 = r7
            r28 = r10
        L_0x03d2:
            r29 = r13
            r7 = 0
            r10 = 0
            r15 = 0
        L_0x03d7:
            int r13 = r9.zzb()     // Catch:{ all -> 0x0f65 }
            r30 = r5
            java.lang.String r5 = "_r"
            if (r15 >= r13) goto L_0x0443
            com.google.android.gms.internal.measurement.zzbw$zze r13 = r9.zza((int) r15)     // Catch:{ all -> 0x0f65 }
            java.lang.String r13 = r13.zzb()     // Catch:{ all -> 0x0f65 }
            boolean r13 = r12.equals(r13)     // Catch:{ all -> 0x0f65 }
            if (r13 == 0) goto L_0x040e
            com.google.android.gms.internal.measurement.zzbw$zze r5 = r9.zza((int) r15)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi$zzb r5 = r5.zzbm()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r5 = (com.google.android.gms.internal.measurement.zzbw.zze.zza) r5     // Catch:{ all -> 0x0f65 }
            r13 = r8
            r7 = 1
            com.google.android.gms.internal.measurement.zzbw$zze$zza r5 = r5.zza((long) r7)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r5 = r5.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r5 = (com.google.android.gms.internal.measurement.zzfi) r5     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r5 = (com.google.android.gms.internal.measurement.zzbw.zze) r5     // Catch:{ all -> 0x0f65 }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzbw.zze) r5)     // Catch:{ all -> 0x0f65 }
            r8 = r11
            r7 = 1
            goto L_0x043c
        L_0x040e:
            r13 = r8
            com.google.android.gms.internal.measurement.zzbw$zze r8 = r9.zza((int) r15)     // Catch:{ all -> 0x0f65 }
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0f65 }
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0f65 }
            if (r5 == 0) goto L_0x043b
            com.google.android.gms.internal.measurement.zzbw$zze r5 = r9.zza((int) r15)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi$zzb r5 = r5.zzbm()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r5 = (com.google.android.gms.internal.measurement.zzbw.zze.zza) r5     // Catch:{ all -> 0x0f65 }
            r8 = r11
            r10 = 1
            com.google.android.gms.internal.measurement.zzbw$zze$zza r5 = r5.zza((long) r10)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r5 = r5.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r5 = (com.google.android.gms.internal.measurement.zzfi) r5     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r5 = (com.google.android.gms.internal.measurement.zzbw.zze) r5     // Catch:{ all -> 0x0f65 }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzbw.zze) r5)     // Catch:{ all -> 0x0f65 }
            r10 = 1
            goto L_0x043c
        L_0x043b:
            r8 = r11
        L_0x043c:
            int r15 = r15 + 1
            r11 = r8
            r8 = r13
            r5 = r30
            goto L_0x03d7
        L_0x0443:
            r13 = r8
            r8 = r11
            if (r7 != 0) goto L_0x047c
            if (r6 == 0) goto L_0x047c
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.String r11 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfx r15 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzer r15 = r15.zzj()     // Catch:{ all -> 0x0f65 }
            r31 = r13
            java.lang.String r13 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            java.lang.String r13 = r15.zza((java.lang.String) r13)     // Catch:{ all -> 0x0f65 }
            r7.zza(r11, r13)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r7 = com.google.android.gms.internal.measurement.zzbw.zze.zzk()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r7 = r7.zza((java.lang.String) r12)     // Catch:{ all -> 0x0f65 }
            r13 = r2
            r11 = r3
            r2 = 1
            com.google.android.gms.internal.measurement.zzbw$zze$zza r7 = r7.zza((long) r2)     // Catch:{ all -> 0x0f65 }
            r9.zza((com.google.android.gms.internal.measurement.zzbw.zze.zza) r7)     // Catch:{ all -> 0x0f65 }
            goto L_0x0480
        L_0x047c:
            r11 = r3
            r31 = r13
            r13 = r2
        L_0x0480:
            if (r10 != 0) goto L_0x04b2
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzj()     // Catch:{ all -> 0x0f65 }
            java.lang.String r10 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            java.lang.String r7 = r7.zza((java.lang.String) r10)     // Catch:{ all -> 0x0f65 }
            r2.zza(r3, r7)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r2 = com.google.android.gms.internal.measurement.zzbw.zze.zzk()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r2 = r2.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f65 }
            r3 = r8
            r7 = 1
            com.google.android.gms.internal.measurement.zzbw$zze$zza r2 = r2.zza((long) r7)     // Catch:{ all -> 0x0f65 }
            r9.zza((com.google.android.gms.internal.measurement.zzbw.zze.zza) r2)     // Catch:{ all -> 0x0f65 }
            goto L_0x04b3
        L_0x04b2:
            r3 = r8
        L_0x04b3:
            com.google.android.gms.measurement.internal.zzab r32 = r43.zze()     // Catch:{ all -> 0x0f65 }
            long r33 = r43.zzx()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r2 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r35 = r2.zzx()     // Catch:{ all -> 0x0f65 }
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 1
            com.google.android.gms.measurement.internal.zzae r2 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0f65 }
            long r7 = r2.zze     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r10 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x0f65 }
            int r2 = r2.zzb(r10)     // Catch:{ all -> 0x0f65 }
            r10 = r3
            long r2 = (long) r2     // Catch:{ all -> 0x0f65 }
            int r15 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r15 <= 0) goto L_0x04eb
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r5)     // Catch:{ all -> 0x0f65 }
            goto L_0x04ed
        L_0x04eb:
            r19 = 1
        L_0x04ed:
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            boolean r2 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r2)     // Catch:{ all -> 0x0f65 }
            if (r2 == 0) goto L_0x05b7
            if (r6 == 0) goto L_0x05b7
            com.google.android.gms.measurement.internal.zzab r32 = r43.zze()     // Catch:{ all -> 0x0f65 }
            long r33 = r43.zzx()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r2 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r35 = r2.zzx()     // Catch:{ all -> 0x0f65 }
            r36 = 0
            r37 = 0
            r38 = 1
            r39 = 0
            r40 = 0
            com.google.android.gms.measurement.internal.zzae r2 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0f65 }
            long r2 = r2.zzc     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzaa r5 = r5.zzb()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzas.zzm     // Catch:{ all -> 0x0f65 }
            int r5 = r5.zzb(r7, r8)     // Catch:{ all -> 0x0f65 }
            long r7 = (long) r5     // Catch:{ all -> 0x0f65 }
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x05b7
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzi()     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f65 }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0f65 }
            r2 = -1
            r3 = 0
            r5 = 0
            r7 = 0
        L_0x054b:
            int r8 = r9.zzb()     // Catch:{ all -> 0x0f65 }
            if (r7 >= r8) goto L_0x0576
            com.google.android.gms.internal.measurement.zzbw$zze r8 = r9.zza((int) r7)     // Catch:{ all -> 0x0f65 }
            java.lang.String r15 = r8.zzb()     // Catch:{ all -> 0x0f65 }
            boolean r15 = r12.equals(r15)     // Catch:{ all -> 0x0f65 }
            if (r15 == 0) goto L_0x0568
            com.google.android.gms.internal.measurement.zzfi$zzb r2 = r8.zzbm()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zze.zza) r2     // Catch:{ all -> 0x0f65 }
            r3 = r2
            r2 = r7
            goto L_0x0573
        L_0x0568:
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0f65 }
            boolean r8 = r14.equals(r8)     // Catch:{ all -> 0x0f65 }
            if (r8 == 0) goto L_0x0573
            r5 = 1
        L_0x0573:
            int r7 = r7 + 1
            goto L_0x054b
        L_0x0576:
            if (r5 == 0) goto L_0x057e
            if (r3 == 0) goto L_0x057e
            r9.zzb((int) r2)     // Catch:{ all -> 0x0f65 }
            goto L_0x05b7
        L_0x057e:
            if (r3 == 0) goto L_0x059e
            java.lang.Object r3 = r3.clone()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi$zzb r3 = (com.google.android.gms.internal.measurement.zzfi.zzb) r3     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r3 = (com.google.android.gms.internal.measurement.zzbw.zze.zza) r3     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze$zza r3 = r3.zza((java.lang.String) r14)     // Catch:{ all -> 0x0f65 }
            r7 = 10
            com.google.android.gms.internal.measurement.zzbw$zze$zza r3 = r3.zza((long) r7)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r3 = r3.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r3 = (com.google.android.gms.internal.measurement.zzfi) r3     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r3 = (com.google.android.gms.internal.measurement.zzbw.zze) r3     // Catch:{ all -> 0x0f65 }
            r9.zza((int) r2, (com.google.android.gms.internal.measurement.zzbw.zze) r3)     // Catch:{ all -> 0x0f65 }
            goto L_0x05b7
        L_0x059e:
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f65 }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0f65 }
        L_0x05b7:
            if (r6 == 0) goto L_0x067a
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0f65 }
            java.util.List r3 = r9.zza()     // Catch:{ all -> 0x0f65 }
            r2.<init>(r3)     // Catch:{ all -> 0x0f65 }
            r3 = 0
            r5 = -1
            r6 = -1
        L_0x05c5:
            int r7 = r2.size()     // Catch:{ all -> 0x0f65 }
            java.lang.String r8 = "currency"
            java.lang.String r14 = "value"
            if (r3 >= r7) goto L_0x05f5
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r7 = (com.google.android.gms.internal.measurement.zzbw.zze) r7     // Catch:{ all -> 0x0f65 }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x0f65 }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x0f65 }
            if (r7 == 0) goto L_0x05e1
            r5 = r3
            goto L_0x05f2
        L_0x05e1:
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r7 = (com.google.android.gms.internal.measurement.zzbw.zze) r7     // Catch:{ all -> 0x0f65 }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x0f65 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0f65 }
            if (r7 == 0) goto L_0x05f2
            r6 = r3
        L_0x05f2:
            int r3 = r3 + 1
            goto L_0x05c5
        L_0x05f5:
            r3 = -1
            if (r5 == r3) goto L_0x067b
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r3 = (com.google.android.gms.internal.measurement.zzbw.zze) r3     // Catch:{ all -> 0x0f65 }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x0f65 }
            if (r3 != 0) goto L_0x062b
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r3 = (com.google.android.gms.internal.measurement.zzbw.zze) r3     // Catch:{ all -> 0x0f65 }
            boolean r3 = r3.zzg()     // Catch:{ all -> 0x0f65 }
            if (r3 != 0) goto L_0x062b
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzk()     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)     // Catch:{ all -> 0x0f65 }
            r9.zzb((int) r5)     // Catch:{ all -> 0x0f65 }
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r12)     // Catch:{ all -> 0x0f65 }
            r2 = 18
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (int) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0f65 }
            goto L_0x067a
        L_0x062b:
            r3 = -1
            if (r6 != r3) goto L_0x0631
            r2 = 1
            r7 = 3
            goto L_0x065d
        L_0x0631:
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r2 = (com.google.android.gms.internal.measurement.zzbw.zze) r2     // Catch:{ all -> 0x0f65 }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x0f65 }
            int r6 = r2.length()     // Catch:{ all -> 0x0f65 }
            r7 = 3
            if (r6 == r7) goto L_0x0644
        L_0x0642:
            r2 = 1
            goto L_0x065d
        L_0x0644:
            r6 = 0
        L_0x0645:
            int r14 = r2.length()     // Catch:{ all -> 0x0f65 }
            if (r6 >= r14) goto L_0x065c
            int r14 = r2.codePointAt(r6)     // Catch:{ all -> 0x0f65 }
            boolean r15 = java.lang.Character.isLetter(r14)     // Catch:{ all -> 0x0f65 }
            if (r15 != 0) goto L_0x0656
            goto L_0x0642
        L_0x0656:
            int r14 = java.lang.Character.charCount(r14)     // Catch:{ all -> 0x0f65 }
            int r6 = r6 + r14
            goto L_0x0645
        L_0x065c:
            r2 = 0
        L_0x065d:
            if (r2 == 0) goto L_0x067c
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzk()     // Catch:{ all -> 0x0f65 }
            java.lang.String r6 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r6)     // Catch:{ all -> 0x0f65 }
            r9.zzb((int) r5)     // Catch:{ all -> 0x0f65 }
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r12)     // Catch:{ all -> 0x0f65 }
            r2 = 19
            zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (int) r2, (java.lang.String) r8)     // Catch:{ all -> 0x0f65 }
            goto L_0x067c
        L_0x067a:
            r3 = -1
        L_0x067b:
            r7 = 3
        L_0x067c:
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x0f65 }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x0f65 }
            if (r2 == 0) goto L_0x082b
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            r5 = r13
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0f65 }
            r12 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x06f6
            r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r2 = r9.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r2 = (com.google.android.gms.internal.measurement.zzbw.zzc) r2     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r2 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r2, (java.lang.String) r11)     // Catch:{ all -> 0x0f65 }
            if (r2 != 0) goto L_0x06ec
            if (r10 == 0) goto L_0x06e0
            long r14 = r10.zzf()     // Catch:{ all -> 0x0f65 }
            long r24 = r9.zzf()     // Catch:{ all -> 0x0f65 }
            long r14 = r14 - r24
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x0f65 }
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x06e0
            java.lang.Object r2 = r10.clone()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi$zzb r2 = (com.google.android.gms.internal.measurement.zzfi.zzb) r2     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2     // Catch:{ all -> 0x0f65 }
            boolean r6 = r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2)     // Catch:{ all -> 0x0f65 }
            if (r6 == 0) goto L_0x06e0
            r6 = r30
            r8 = r31
            r6.zza((int) r8, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2)     // Catch:{ all -> 0x0f65 }
            r7 = r27
            r14 = r29
        L_0x06db:
            r10 = 0
        L_0x06dc:
            r28 = 0
            goto L_0x0835
        L_0x06e0:
            r6 = r30
            r8 = r31
            r28 = r9
            r7 = r21
            r14 = r29
            goto L_0x0835
        L_0x06ec:
            r6 = r30
            r8 = r31
            r11 = r27
            r14 = r29
            goto L_0x0834
        L_0x06f6:
            r6 = r30
            r8 = r31
            java.lang.String r2 = "_vs"
            java.lang.String r11 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x0f65 }
            if (r2 == 0) goto L_0x074e
            r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r2 = r9.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r2 = (com.google.android.gms.internal.measurement.zzbw.zzc) r2     // Catch:{ all -> 0x0f65 }
            r14 = r29
            com.google.android.gms.internal.measurement.zzbw$zze r2 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0f65 }
            if (r2 != 0) goto L_0x074a
            if (r28 == 0) goto L_0x0742
            long r10 = r28.zzf()     // Catch:{ all -> 0x0f65 }
            long r24 = r9.zzf()     // Catch:{ all -> 0x0f65 }
            long r10 = r10 - r24
            long r10 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0f65 }
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x0742
            java.lang.Object r2 = r28.clone()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi$zzb r2 = (com.google.android.gms.internal.measurement.zzfi.zzb) r2     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2     // Catch:{ all -> 0x0f65 }
            boolean r10 = r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9)     // Catch:{ all -> 0x0f65 }
            if (r10 == 0) goto L_0x0742
            r11 = r27
            r6.zza((int) r11, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2)     // Catch:{ all -> 0x0f65 }
            r7 = r11
            goto L_0x06db
        L_0x0742:
            r11 = r27
            r10 = r9
            r7 = r11
            r8 = r21
            goto L_0x0835
        L_0x074a:
            r11 = r27
            goto L_0x0834
        L_0x074e:
            r11 = r27
            r14 = r29
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r12 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzas.zzbs     // Catch:{ all -> 0x0f65 }
            boolean r2 = r2.zze(r12, r13)     // Catch:{ all -> 0x0f65 }
            if (r2 == 0) goto L_0x0834
            java.lang.String r2 = "_ab"
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x0f65 }
            if (r2 == 0) goto L_0x0834
            r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r2 = r9.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r2 = (com.google.android.gms.internal.measurement.zzbw.zzc) r2     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r2 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0f65 }
            if (r2 != 0) goto L_0x0834
            if (r28 == 0) goto L_0x0834
            long r12 = r28.zzf()     // Catch:{ all -> 0x0f65 }
            long r24 = r9.zzf()     // Catch:{ all -> 0x0f65 }
            long r12 = r12 - r24
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0f65 }
            r24 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r12 > r24 ? 1 : (r12 == r24 ? 0 : -1))
            if (r2 > 0) goto L_0x0834
            java.lang.Object r2 = r28.clone()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi$zzb r2 = (com.google.android.gms.internal.measurement.zzfi.zzb) r2     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2     // Catch:{ all -> 0x0f65 }
            r1.zzb((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9)     // Catch:{ all -> 0x0f65 }
            java.lang.String r12 = r2.zzd()     // Catch:{ all -> 0x0f65 }
            boolean r12 = r5.equals(r12)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r12)     // Catch:{ all -> 0x0f65 }
            r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r12 = r2.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r12 = (com.google.android.gms.internal.measurement.zzfi) r12     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r12 = (com.google.android.gms.internal.measurement.zzbw.zzc) r12     // Catch:{ all -> 0x0f65 }
            java.lang.String r13 = "_sn"
            com.google.android.gms.internal.measurement.zzbw$zze r12 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r12, (java.lang.String) r13)     // Catch:{ all -> 0x0f65 }
            r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r13 = r2.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r13 = (com.google.android.gms.internal.measurement.zzfi) r13     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r13 = (com.google.android.gms.internal.measurement.zzbw.zzc) r13     // Catch:{ all -> 0x0f65 }
            java.lang.String r15 = "_sc"
            com.google.android.gms.internal.measurement.zzbw$zze r13 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r13, (java.lang.String) r15)     // Catch:{ all -> 0x0f65 }
            r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r15 = r2.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r15 = (com.google.android.gms.internal.measurement.zzfi) r15     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r15 = (com.google.android.gms.internal.measurement.zzbw.zzc) r15     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = "_si"
            com.google.android.gms.internal.measurement.zzbw$zze r3 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r15, (java.lang.String) r3)     // Catch:{ all -> 0x0f65 }
            if (r12 == 0) goto L_0x07e9
            java.lang.String r12 = r12.zzd()     // Catch:{ all -> 0x0f65 }
            goto L_0x07eb
        L_0x07e9:
            r12 = r18
        L_0x07eb:
            boolean r15 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0f65 }
            if (r15 != 0) goto L_0x07fa
            com.google.android.gms.measurement.internal.zzkk r15 = r43.zzh()     // Catch:{ all -> 0x0f65 }
            java.lang.String r7 = "_sn"
            r15.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r7, (java.lang.Object) r12)     // Catch:{ all -> 0x0f65 }
        L_0x07fa:
            if (r13 == 0) goto L_0x0801
            java.lang.String r7 = r13.zzd()     // Catch:{ all -> 0x0f65 }
            goto L_0x0803
        L_0x0801:
            r7 = r18
        L_0x0803:
            boolean r12 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0f65 }
            if (r12 != 0) goto L_0x0812
            com.google.android.gms.measurement.internal.zzkk r12 = r43.zzh()     // Catch:{ all -> 0x0f65 }
            java.lang.String r13 = "_sc"
            r12.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r13, (java.lang.Object) r7)     // Catch:{ all -> 0x0f65 }
        L_0x0812:
            if (r3 == 0) goto L_0x0825
            com.google.android.gms.measurement.internal.zzkk r7 = r43.zzh()     // Catch:{ all -> 0x0f65 }
            java.lang.String r12 = "_si"
            long r24 = r3.zzf()     // Catch:{ all -> 0x0f65 }
            java.lang.Long r3 = java.lang.Long.valueOf(r24)     // Catch:{ all -> 0x0f65 }
            r7.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9, (java.lang.String) r12, (java.lang.Object) r3)     // Catch:{ all -> 0x0f65 }
        L_0x0825:
            r6.zza((int) r11, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2)     // Catch:{ all -> 0x0f65 }
            r7 = r11
            goto L_0x06dc
        L_0x082b:
            r5 = r13
            r11 = r27
            r14 = r29
            r6 = r30
            r8 = r31
        L_0x0834:
            r7 = r11
        L_0x0835:
            if (r26 != 0) goto L_0x0896
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x0f65 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0f65 }
            if (r2 == 0) goto L_0x0896
            int r2 = r9.zzb()     // Catch:{ all -> 0x0f65 }
            if (r2 != 0) goto L_0x0861
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzi()     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f65 }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0f65 }
            goto L_0x0896
        L_0x0861:
            com.google.android.gms.measurement.internal.zzkk r2 = r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r3 = r9.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r3 = (com.google.android.gms.internal.measurement.zzfi) r3     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r3 = (com.google.android.gms.internal.measurement.zzbw.zzc) r3     // Catch:{ all -> 0x0f65 }
            java.lang.Object r2 = r2.zzb(r3, r14)     // Catch:{ all -> 0x0f65 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0f65 }
            if (r2 != 0) goto L_0x088f
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzi()     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f65 }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0f65 }
            goto L_0x0896
        L_0x088f:
            long r2 = r2.longValue()     // Catch:{ all -> 0x0f65 }
            long r2 = r22 + r2
            goto L_0x0898
        L_0x0896:
            r2 = r22
        L_0x0898:
            java.util.List<com.google.android.gms.internal.measurement.zzbw$zzc> r5 = r4.zzc     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r11 = r9.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r11 = (com.google.android.gms.internal.measurement.zzfi) r11     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r11 = (com.google.android.gms.internal.measurement.zzbw.zzc) r11     // Catch:{ all -> 0x0f65 }
            r12 = r16
            r5.set(r12, r11)     // Catch:{ all -> 0x0f65 }
            int r14 = r21 + 1
            r6.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r9)     // Catch:{ all -> 0x0f65 }
            r15 = r2
            r11 = r10
            r13 = r19
            r10 = r28
        L_0x08b2:
            int r12 = r12 + 1
            r5 = r6
            r3 = r18
            r2 = r20
            r6 = r26
            goto L_0x02a1
        L_0x08bd:
            r11 = r3
            r26 = r6
            r14 = r13
            r6 = r5
            r5 = r2
            if (r26 == 0) goto L_0x091a
            r2 = r21
            r15 = r22
            r3 = 0
        L_0x08ca:
            if (r3 >= r2) goto L_0x0918
            com.google.android.gms.internal.measurement.zzbw$zzc r7 = r6.zzb((int) r3)     // Catch:{ all -> 0x0f65 }
            java.lang.String r8 = r7.zzc()     // Catch:{ all -> 0x0f65 }
            boolean r8 = r5.equals(r8)     // Catch:{ all -> 0x0f65 }
            if (r8 == 0) goto L_0x08eb
            r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r8 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r7, (java.lang.String) r11)     // Catch:{ all -> 0x0f65 }
            if (r8 == 0) goto L_0x08eb
            r6.zzc((int) r3)     // Catch:{ all -> 0x0f65 }
            int r2 = r2 + -1
            int r3 = r3 + -1
            goto L_0x0915
        L_0x08eb:
            r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r7 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzc) r7, (java.lang.String) r14)     // Catch:{ all -> 0x0f65 }
            if (r7 == 0) goto L_0x0915
            boolean r8 = r7.zze()     // Catch:{ all -> 0x0f65 }
            if (r8 == 0) goto L_0x0903
            long r7 = r7.zzf()     // Catch:{ all -> 0x0f65 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0f65 }
            goto L_0x0904
        L_0x0903:
            r7 = 0
        L_0x0904:
            if (r7 == 0) goto L_0x0915
            long r8 = r7.longValue()     // Catch:{ all -> 0x0f65 }
            r12 = 0
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0915
            long r7 = r7.longValue()     // Catch:{ all -> 0x0f65 }
            long r15 = r15 + r7
        L_0x0915:
            r7 = 1
            int r3 = r3 + r7
            goto L_0x08ca
        L_0x0918:
            r2 = r15
            goto L_0x091c
        L_0x091a:
            r2 = r22
        L_0x091c:
            r5 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6, (long) r2, (boolean) r5)     // Catch:{ all -> 0x0f65 }
            java.util.List r5 = r6.zza()     // Catch:{ all -> 0x0f65 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0f65 }
        L_0x0928:
            boolean r7 = r5.hasNext()     // Catch:{ all -> 0x0f65 }
            if (r7 == 0) goto L_0x0942
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r7 = (com.google.android.gms.internal.measurement.zzbw.zzc) r7     // Catch:{ all -> 0x0f65 }
            java.lang.String r8 = "_s"
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x0f65 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0f65 }
            if (r7 == 0) goto L_0x0928
            r5 = 1
            goto L_0x0943
        L_0x0942:
            r5 = 0
        L_0x0943:
            java.lang.String r7 = "_se"
            if (r5 == 0) goto L_0x0952
            com.google.android.gms.measurement.internal.zzab r5 = r43.zze()     // Catch:{ all -> 0x0f65 }
            java.lang.String r8 = r6.zzj()     // Catch:{ all -> 0x0f65 }
            r5.zzb((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ all -> 0x0f65 }
        L_0x0952:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6, (java.lang.String) r5)     // Catch:{ all -> 0x0f65 }
            if (r5 < 0) goto L_0x095c
            r5 = 1
            goto L_0x095d
        L_0x095c:
            r5 = 0
        L_0x095d:
            if (r5 == 0) goto L_0x0964
            r5 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6, (long) r2, (boolean) r5)     // Catch:{ all -> 0x0f65 }
            goto L_0x0986
        L_0x0964:
            int r2 = com.google.android.gms.measurement.internal.zzkk.zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0f65 }
            if (r2 < 0) goto L_0x0986
            r6.zze((int) r2)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f65 }
            r2.zza(r3, r5)     // Catch:{ all -> 0x0f65 }
        L_0x0986:
            com.google.android.gms.measurement.internal.zzkk r2 = r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r3 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r3.zza(r5)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzfr r3 = r2.zzj()     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = r6.zzj()     // Catch:{ all -> 0x0f65 }
            boolean r3 = r3.zze(r5)     // Catch:{ all -> 0x0f65 }
            if (r3 == 0) goto L_0x0a17
            com.google.android.gms.measurement.internal.zzab r3 = r2.zzi()     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = r6.zzj()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzg r3 = r3.zzb(r5)     // Catch:{ all -> 0x0f65 }
            if (r3 == 0) goto L_0x0a17
            boolean r3 = r3.zzaf()     // Catch:{ all -> 0x0f65 }
            if (r3 == 0) goto L_0x0a17
            com.google.android.gms.measurement.internal.zzak r3 = r2.zzl()     // Catch:{ all -> 0x0f65 }
            boolean r3 = r3.zzj()     // Catch:{ all -> 0x0f65 }
            if (r3 == 0) goto L_0x0a17
            com.google.android.gms.measurement.internal.zzet r3 = r2.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzw()     // Catch:{ all -> 0x0f65 }
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r3.zza(r5)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r3 = com.google.android.gms.internal.measurement.zzbw.zzk.zzj()     // Catch:{ all -> 0x0f65 }
            r5 = r20
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r3 = r3.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzak r2 = r2.zzl()     // Catch:{ all -> 0x0f65 }
            long r7 = r2.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r2 = r3.zza((long) r7)     // Catch:{ all -> 0x0f65 }
            r7 = 1
            com.google.android.gms.internal.measurement.zzbw$zzk$zza r2 = r2.zzb((long) r7)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r2 = r2.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzk r2 = (com.google.android.gms.internal.measurement.zzbw.zzk) r2     // Catch:{ all -> 0x0f65 }
            r3 = 0
        L_0x09f5:
            int r7 = r6.zze()     // Catch:{ all -> 0x0f65 }
            if (r3 >= r7) goto L_0x0a11
            com.google.android.gms.internal.measurement.zzbw$zzk r7 = r6.zzd((int) r3)     // Catch:{ all -> 0x0f65 }
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x0f65 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x0f65 }
            if (r7 == 0) goto L_0x0a0e
            r6.zza((int) r3, (com.google.android.gms.internal.measurement.zzbw.zzk) r2)     // Catch:{ all -> 0x0f65 }
            r3 = 1
            goto L_0x0a12
        L_0x0a0e:
            int r3 = r3 + 1
            goto L_0x09f5
        L_0x0a11:
            r3 = 0
        L_0x0a12:
            if (r3 != 0) goto L_0x0a17
            r6.zza((com.google.android.gms.internal.measurement.zzbw.zzk) r2)     // Catch:{ all -> 0x0f65 }
        L_0x0a17:
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = r6.zzj()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzas.zzbn     // Catch:{ all -> 0x0f65 }
            boolean r2 = r2.zze(r3, r5)     // Catch:{ all -> 0x0f65 }
            if (r2 == 0) goto L_0x0a2c
            zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r6)     // Catch:{ all -> 0x0f65 }
        L_0x0a2c:
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r2 = r6.zzm()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzq r7 = r43.zzf()     // Catch:{ all -> 0x0f65 }
            java.lang.String r8 = r6.zzj()     // Catch:{ all -> 0x0f65 }
            java.util.List r9 = r6.zza()     // Catch:{ all -> 0x0f65 }
            java.util.List r10 = r6.zzd()     // Catch:{ all -> 0x0f65 }
            long r11 = r6.zzf()     // Catch:{ all -> 0x0f65 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f65 }
            long r12 = r6.zzg()     // Catch:{ all -> 0x0f65 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0f65 }
            java.util.List r3 = r7.zza(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0f65 }
            r2.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzbw.zza>) r3)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzfx r2 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzaa r2 = r2.zzb()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r3 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0f65 }
            boolean r2 = r2.zzg(r3)     // Catch:{ all -> 0x0f65 }
            if (r2 == 0) goto L_0x0da0
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0d9b }
            r2.<init>()     // Catch:{ all -> 0x0d9b }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0d9b }
            r3.<init>()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzfx r5 = r1.zzj     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzko r5 = r5.zzi()     // Catch:{ all -> 0x0d9b }
            java.security.SecureRandom r5 = r5.zzh()     // Catch:{ all -> 0x0d9b }
            r7 = 0
        L_0x0a7e:
            int r8 = r6.zzb()     // Catch:{ all -> 0x0d9b }
            if (r7 >= r8) goto L_0x0d65
            com.google.android.gms.internal.measurement.zzbw$zzc r8 = r6.zzb((int) r7)     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzfi$zzb r8 = r8.zzbm()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8     // Catch:{ all -> 0x0d9b }
            java.lang.String r9 = r8.zzd()     // Catch:{ all -> 0x0d9b }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0d9b }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0b12
            com.google.android.gms.measurement.internal.zzkk r9 = r43.zzh()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r11 = r8.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r11 = (com.google.android.gms.internal.measurement.zzfi) r11     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r11 = (com.google.android.gms.internal.measurement.zzbw.zzc) r11     // Catch:{ all -> 0x0f65 }
            java.lang.String r12 = "_en"
            java.lang.Object r9 = r9.zzb(r11, r12)     // Catch:{ all -> 0x0f65 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0f65 }
            java.lang.Object r11 = r2.get(r9)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzam r11 = (com.google.android.gms.measurement.internal.zzam) r11     // Catch:{ all -> 0x0f65 }
            if (r11 != 0) goto L_0x0ac9
            com.google.android.gms.measurement.internal.zzab r11 = r43.zze()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r12 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza((java.lang.String) r12, (java.lang.String) r9)     // Catch:{ all -> 0x0f65 }
            r2.put(r9, r11)     // Catch:{ all -> 0x0f65 }
        L_0x0ac9:
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x0f65 }
            if (r9 != 0) goto L_0x0b08
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0f65 }
            long r12 = r9.longValue()     // Catch:{ all -> 0x0f65 }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0ae2
            com.google.android.gms.measurement.internal.zzkk r9 = r43.zzh()     // Catch:{ all -> 0x0f65 }
            java.lang.Long r12 = r11.zzj     // Catch:{ all -> 0x0f65 }
            r9.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r12)     // Catch:{ all -> 0x0f65 }
        L_0x0ae2:
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0f65 }
            if (r9 == 0) goto L_0x0afd
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0f65 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0f65 }
            if (r9 == 0) goto L_0x0afd
            com.google.android.gms.measurement.internal.zzkk r9 = r43.zzh()     // Catch:{ all -> 0x0f65 }
            java.lang.String r10 = "_efs"
            r11 = 1
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f65 }
            r9.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r13)     // Catch:{ all -> 0x0f65 }
        L_0x0afd:
            com.google.android.gms.internal.measurement.zzgt r9 = r8.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r9 = (com.google.android.gms.internal.measurement.zzfi) r9     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r9 = (com.google.android.gms.internal.measurement.zzbw.zzc) r9     // Catch:{ all -> 0x0f65 }
            r3.add(r9)     // Catch:{ all -> 0x0f65 }
        L_0x0b08:
            r6.zza((int) r7, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8)     // Catch:{ all -> 0x0f65 }
        L_0x0b0b:
            r44 = r4
            r15 = r5
            r1 = r6
            r4 = r7
            goto L_0x0d5b
        L_0x0b12:
            com.google.android.gms.measurement.internal.zzfr r9 = r43.zzc()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzbw$zzg r11 = r4.zza     // Catch:{ all -> 0x0d9b }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0d9b }
            long r11 = r9.zzf(r11)     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzfx r9 = r1.zzj     // Catch:{ all -> 0x0d9b }
            r9.zzi()     // Catch:{ all -> 0x0d9b }
            long r13 = r8.zzf()     // Catch:{ all -> 0x0d9b }
            long r13 = com.google.android.gms.measurement.internal.zzko.zza((long) r13, (long) r11)     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzgt r9 = r8.zzu()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzfi r9 = (com.google.android.gms.internal.measurement.zzfi) r9     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzbw$zzc r9 = (com.google.android.gms.internal.measurement.zzbw.zzc) r9     // Catch:{ all -> 0x0d9b }
            java.lang.String r15 = "_dbg"
            r20 = r11
            r16 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0d9b }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0d9b }
            if (r12 != 0) goto L_0x0b9f
            if (r11 != 0) goto L_0x0b48
            goto L_0x0b9f
        L_0x0b48:
            java.util.List r9 = r9.zza()     // Catch:{ all -> 0x0f65 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0f65 }
        L_0x0b50:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x0f65 }
            if (r12 == 0) goto L_0x0b9f
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zze r12 = (com.google.android.gms.internal.measurement.zzbw.zze) r12     // Catch:{ all -> 0x0f65 }
            r44 = r9
            java.lang.String r9 = r12.zzb()     // Catch:{ all -> 0x0f65 }
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0f65 }
            if (r9 == 0) goto L_0x0b9c
            boolean r9 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0f65 }
            if (r9 == 0) goto L_0x0b7a
            long r15 = r12.zzf()     // Catch:{ all -> 0x0f65 }
            java.lang.Long r9 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0f65 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f65 }
            if (r9 != 0) goto L_0x0b9a
        L_0x0b7a:
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0f65 }
            if (r9 == 0) goto L_0x0b88
            java.lang.String r9 = r12.zzd()     // Catch:{ all -> 0x0f65 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f65 }
            if (r9 != 0) goto L_0x0b9a
        L_0x0b88:
            boolean r9 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x0f65 }
            if (r9 == 0) goto L_0x0b9f
            double r15 = r12.zzh()     // Catch:{ all -> 0x0f65 }
            java.lang.Double r9 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x0f65 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f65 }
            if (r9 == 0) goto L_0x0b9f
        L_0x0b9a:
            r9 = 1
            goto L_0x0ba0
        L_0x0b9c:
            r9 = r44
            goto L_0x0b50
        L_0x0b9f:
            r9 = 0
        L_0x0ba0:
            if (r9 != 0) goto L_0x0bb5
            com.google.android.gms.measurement.internal.zzfr r9 = r43.zzc()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzg r11 = r4.zza     // Catch:{ all -> 0x0f65 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f65 }
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x0f65 }
            int r9 = r9.zzd(r11, r12)     // Catch:{ all -> 0x0f65 }
            goto L_0x0bb6
        L_0x0bb5:
            r9 = 1
        L_0x0bb6:
            if (r9 > 0) goto L_0x0bdf
            com.google.android.gms.measurement.internal.zzfx r10 = r1.zzj     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzr()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzi()     // Catch:{ all -> 0x0f65 }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x0f65 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0f65 }
            r10.zza(r11, r12, r9)     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzgt r9 = r8.zzu()     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzfi r9 = (com.google.android.gms.internal.measurement.zzfi) r9     // Catch:{ all -> 0x0f65 }
            com.google.android.gms.internal.measurement.zzbw$zzc r9 = (com.google.android.gms.internal.measurement.zzbw.zzc) r9     // Catch:{ all -> 0x0f65 }
            r3.add(r9)     // Catch:{ all -> 0x0f65 }
            r6.zza((int) r7, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8)     // Catch:{ all -> 0x0f65 }
            goto L_0x0b0b
        L_0x0bdf:
            java.lang.String r11 = r8.zzd()     // Catch:{ all -> 0x0d9b }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzam r11 = (com.google.android.gms.measurement.internal.zzam) r11     // Catch:{ all -> 0x0d9b }
            if (r11 != 0) goto L_0x0c3d
            com.google.android.gms.measurement.internal.zzab r11 = r43.zze()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzbw$zzg r12 = r4.zza     // Catch:{ all -> 0x0d9b }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0d9b }
            java.lang.String r15 = r8.zzd()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza((java.lang.String) r12, (java.lang.String) r15)     // Catch:{ all -> 0x0d9b }
            if (r11 != 0) goto L_0x0c3d
            com.google.android.gms.measurement.internal.zzfx r11 = r1.zzj     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzet r11 = r11.zzr()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzev r11 = r11.zzi()     // Catch:{ all -> 0x0d9b }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzbw$zzg r15 = r4.zza     // Catch:{ all -> 0x0d9b }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0d9b }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0d9b }
            r11.zza(r12, r15, r1)     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzam r11 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzbw$zzg r1 = r4.zza     // Catch:{ all -> 0x0d9b }
            java.lang.String r27 = r1.zzx()     // Catch:{ all -> 0x0d9b }
            java.lang.String r28 = r8.zzd()     // Catch:{ all -> 0x0d9b }
            r29 = 1
            r31 = 1
            r33 = 1
            long r35 = r8.zzf()     // Catch:{ all -> 0x0d9b }
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r26 = r11
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)     // Catch:{ all -> 0x0d9b }
        L_0x0c3d:
            com.google.android.gms.measurement.internal.zzkk r1 = r43.zzh()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzgt r12 = r8.zzu()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzfi r12 = (com.google.android.gms.internal.measurement.zzfi) r12     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzbw$zzc r12 = (com.google.android.gms.internal.measurement.zzbw.zzc) r12     // Catch:{ all -> 0x0d9b }
            java.lang.String r15 = "_eid"
            java.lang.Object r1 = r1.zzb(r12, r15)     // Catch:{ all -> 0x0d9b }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0d9b }
            if (r1 == 0) goto L_0x0c55
            r12 = 1
            goto L_0x0c56
        L_0x0c55:
            r12 = 0
        L_0x0c56:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0d9b }
            r15 = 1
            if (r9 != r15) goto L_0x0c8b
            com.google.android.gms.internal.measurement.zzgt r1 = r8.zzu()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzbw$zzc r1 = (com.google.android.gms.internal.measurement.zzbw.zzc) r1     // Catch:{ all -> 0x0d9b }
            r3.add(r1)     // Catch:{ all -> 0x0d9b }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0d9b }
            if (r1 == 0) goto L_0x0c86
            java.lang.Long r1 = r11.zzi     // Catch:{ all -> 0x0d9b }
            if (r1 != 0) goto L_0x0c7a
            java.lang.Long r1 = r11.zzj     // Catch:{ all -> 0x0d9b }
            if (r1 != 0) goto L_0x0c7a
            java.lang.Boolean r1 = r11.zzk     // Catch:{ all -> 0x0d9b }
            if (r1 == 0) goto L_0x0c86
        L_0x0c7a:
            r1 = 0
            com.google.android.gms.measurement.internal.zzam r9 = r11.zza(r1, r1, r1)     // Catch:{ all -> 0x0d9b }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0d9b }
            r2.put(r1, r9)     // Catch:{ all -> 0x0d9b }
        L_0x0c86:
            r6.zza((int) r7, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8)     // Catch:{ all -> 0x0d9b }
            goto L_0x0b0b
        L_0x0c8b:
            int r15 = r5.nextInt(r9)     // Catch:{ all -> 0x0d9b }
            if (r15 != 0) goto L_0x0ccd
            com.google.android.gms.measurement.internal.zzkk r1 = r43.zzh()     // Catch:{ all -> 0x0d9b }
            r44 = r4
            r15 = r5
            long r4 = (long) r9     // Catch:{ all -> 0x0d9b }
            java.lang.Long r9 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0d9b }
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzgt r1 = r8.zzu()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzbw$zzc r1 = (com.google.android.gms.internal.measurement.zzbw.zzc) r1     // Catch:{ all -> 0x0d9b }
            r3.add(r1)     // Catch:{ all -> 0x0d9b }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0d9b }
            if (r1 == 0) goto L_0x0cba
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0d9b }
            r4 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza(r4, r1, r4)     // Catch:{ all -> 0x0d9b }
        L_0x0cba:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0d9b }
            long r4 = r8.zzf()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzam r4 = r11.zza(r4, r13)     // Catch:{ all -> 0x0d9b }
            r2.put(r1, r4)     // Catch:{ all -> 0x0d9b }
            r1 = r6
            r4 = r7
            goto L_0x0d58
        L_0x0ccd:
            r44 = r4
            r15 = r5
            java.lang.Long r4 = r11.zzh     // Catch:{ all -> 0x0d9b }
            if (r4 == 0) goto L_0x0cdf
            java.lang.Long r4 = r11.zzh     // Catch:{ all -> 0x0d9b }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0d9b }
            r30 = r6
            r16 = r7
            goto L_0x0cf4
        L_0x0cdf:
            r4 = r43
            com.google.android.gms.measurement.internal.zzfx r5 = r4.zzj     // Catch:{ all -> 0x0d9b }
            r5.zzi()     // Catch:{ all -> 0x0d9b }
            long r4 = r8.zzg()     // Catch:{ all -> 0x0d9b }
            r30 = r6
            r16 = r7
            r6 = r20
            long r4 = com.google.android.gms.measurement.internal.zzko.zza((long) r4, (long) r6)     // Catch:{ all -> 0x0d9b }
        L_0x0cf4:
            int r6 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r6 == 0) goto L_0x0d42
            com.google.android.gms.measurement.internal.zzkk r1 = r43.zzh()     // Catch:{ all -> 0x0d9b }
            java.lang.String r4 = "_efs"
            r5 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0d9b }
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r4, (java.lang.Object) r7)     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzkk r1 = r43.zzh()     // Catch:{ all -> 0x0d9b }
            long r5 = (long) r9     // Catch:{ all -> 0x0d9b }
            java.lang.Long r4 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0d9b }
            r1.zza((com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r4)     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzgt r1 = r8.zzu()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.internal.measurement.zzbw$zzc r1 = (com.google.android.gms.internal.measurement.zzbw.zzc) r1     // Catch:{ all -> 0x0d9b }
            r3.add(r1)     // Catch:{ all -> 0x0d9b }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0d9b }
            if (r1 == 0) goto L_0x0d32
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0d9b }
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0d9b }
            r4 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza(r4, r1, r5)     // Catch:{ all -> 0x0d9b }
        L_0x0d32:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0d9b }
            long r4 = r8.zzf()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzam r4 = r11.zza(r4, r13)     // Catch:{ all -> 0x0d9b }
            r2.put(r1, r4)     // Catch:{ all -> 0x0d9b }
            goto L_0x0d54
        L_0x0d42:
            boolean r4 = r12.booleanValue()     // Catch:{ all -> 0x0d9b }
            if (r4 == 0) goto L_0x0d54
            java.lang.String r4 = r8.zzd()     // Catch:{ all -> 0x0d9b }
            r5 = 0
            com.google.android.gms.measurement.internal.zzam r1 = r11.zza(r1, r5, r5)     // Catch:{ all -> 0x0d9b }
            r2.put(r4, r1)     // Catch:{ all -> 0x0d9b }
        L_0x0d54:
            r4 = r16
            r1 = r30
        L_0x0d58:
            r1.zza((int) r4, (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r8)     // Catch:{ all -> 0x0d9b }
        L_0x0d5b:
            int r7 = r4 + 1
            r4 = r44
            r6 = r1
            r5 = r15
            r1 = r43
            goto L_0x0a7e
        L_0x0d65:
            r44 = r4
            r1 = r6
            int r4 = r3.size()     // Catch:{ all -> 0x0d9b }
            int r5 = r1.zzb()     // Catch:{ all -> 0x0d9b }
            if (r4 >= r5) goto L_0x0d79
            com.google.android.gms.internal.measurement.zzbw$zzg$zza r4 = r1.zzc()     // Catch:{ all -> 0x0d9b }
            r4.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzbw.zzc>) r3)     // Catch:{ all -> 0x0d9b }
        L_0x0d79:
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0d9b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0d9b }
        L_0x0d81:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0d9b }
            if (r3 == 0) goto L_0x0da3
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0d9b }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzab r4 = r43.zze()     // Catch:{ all -> 0x0d9b }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0d9b }
            com.google.android.gms.measurement.internal.zzam r3 = (com.google.android.gms.measurement.internal.zzam) r3     // Catch:{ all -> 0x0d9b }
            r4.zza((com.google.android.gms.measurement.internal.zzam) r3)     // Catch:{ all -> 0x0d9b }
            goto L_0x0d81
        L_0x0d9b:
            r0 = move-exception
            r2 = r43
            goto L_0x0f67
        L_0x0da0:
            r44 = r4
            r1 = r6
        L_0x0da3:
            r2 = r43
            com.google.android.gms.measurement.internal.zzfx r3 = r2.zzj     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzaa r3 = r3.zzb()     // Catch:{ all -> 0x0f63 }
            java.lang.String r4 = r1.zzj()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzas.zzbn     // Catch:{ all -> 0x0f63 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f63 }
            if (r3 != 0) goto L_0x0dba
            zza((com.google.android.gms.internal.measurement.zzbw.zzg.zza) r1)     // Catch:{ all -> 0x0f63 }
        L_0x0dba:
            r3 = r44
            com.google.android.gms.internal.measurement.zzbw$zzg r4 = r3.zza     // Catch:{ all -> 0x0f63 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzab r5 = r43.zze()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzg r5 = r5.zzb(r4)     // Catch:{ all -> 0x0f63 }
            if (r5 != 0) goto L_0x0de6
            com.google.android.gms.measurement.internal.zzfx r5 = r2.zzj     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzr()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzev r5 = r5.zzf()     // Catch:{ all -> 0x0f63 }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = r3.zza     // Catch:{ all -> 0x0f63 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f63 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r7)     // Catch:{ all -> 0x0f63 }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0f63 }
            goto L_0x0e41
        L_0x0de6:
            int r6 = r1.zzb()     // Catch:{ all -> 0x0f63 }
            if (r6 <= 0) goto L_0x0e41
            long r6 = r5.zzk()     // Catch:{ all -> 0x0f63 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0dfa
            r1.zze((long) r6)     // Catch:{ all -> 0x0f63 }
            goto L_0x0dfd
        L_0x0dfa:
            r1.zzi()     // Catch:{ all -> 0x0f63 }
        L_0x0dfd:
            long r8 = r5.zzj()     // Catch:{ all -> 0x0f63 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0e08
            goto L_0x0e09
        L_0x0e08:
            r6 = r8
        L_0x0e09:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0e11
            r1.zzd((long) r6)     // Catch:{ all -> 0x0f63 }
            goto L_0x0e14
        L_0x0e11:
            r1.zzh()     // Catch:{ all -> 0x0f63 }
        L_0x0e14:
            r5.zzv()     // Catch:{ all -> 0x0f63 }
            long r6 = r5.zzs()     // Catch:{ all -> 0x0f63 }
            int r7 = (int) r6     // Catch:{ all -> 0x0f63 }
            r1.zzg((int) r7)     // Catch:{ all -> 0x0f63 }
            long r6 = r1.zzf()     // Catch:{ all -> 0x0f63 }
            r5.zza((long) r6)     // Catch:{ all -> 0x0f63 }
            long r6 = r1.zzg()     // Catch:{ all -> 0x0f63 }
            r5.zzb((long) r6)     // Catch:{ all -> 0x0f63 }
            java.lang.String r6 = r5.zzad()     // Catch:{ all -> 0x0f63 }
            if (r6 == 0) goto L_0x0e37
            r1.zzj((java.lang.String) r6)     // Catch:{ all -> 0x0f63 }
            goto L_0x0e3a
        L_0x0e37:
            r1.zzk()     // Catch:{ all -> 0x0f63 }
        L_0x0e3a:
            com.google.android.gms.measurement.internal.zzab r6 = r43.zze()     // Catch:{ all -> 0x0f63 }
            r6.zza((com.google.android.gms.measurement.internal.zzg) r5)     // Catch:{ all -> 0x0f63 }
        L_0x0e41:
            int r5 = r1.zzb()     // Catch:{ all -> 0x0f63 }
            if (r5 <= 0) goto L_0x0ea7
            com.google.android.gms.measurement.internal.zzfx r5 = r2.zzj     // Catch:{ all -> 0x0f63 }
            r5.zzu()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzfr r5 = r43.zzc()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.internal.measurement.zzbw$zzg r6 = r3.zza     // Catch:{ all -> 0x0f63 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.internal.measurement.zzbt$zzb r5 = r5.zza((java.lang.String) r6)     // Catch:{ all -> 0x0f63 }
            if (r5 == 0) goto L_0x0e6b
            boolean r6 = r5.zza()     // Catch:{ all -> 0x0f63 }
            if (r6 != 0) goto L_0x0e63
            goto L_0x0e6b
        L_0x0e63:
            long r5 = r5.zzb()     // Catch:{ all -> 0x0f63 }
            r1.zzi((long) r5)     // Catch:{ all -> 0x0f63 }
            goto L_0x0e96
        L_0x0e6b:
            com.google.android.gms.internal.measurement.zzbw$zzg r5 = r3.zza     // Catch:{ all -> 0x0f63 }
            java.lang.String r5 = r5.zzam()     // Catch:{ all -> 0x0f63 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0f63 }
            if (r5 == 0) goto L_0x0e7d
            r5 = -1
            r1.zzi((long) r5)     // Catch:{ all -> 0x0f63 }
            goto L_0x0e96
        L_0x0e7d:
            com.google.android.gms.measurement.internal.zzfx r5 = r2.zzj     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzr()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzev r5 = r5.zzi()     // Catch:{ all -> 0x0f63 }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzbw$zzg r7 = r3.zza     // Catch:{ all -> 0x0f63 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x0f63 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r7)     // Catch:{ all -> 0x0f63 }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0f63 }
        L_0x0e96:
            com.google.android.gms.measurement.internal.zzab r5 = r43.zze()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.internal.measurement.zzgt r1 = r1.zzu()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.internal.measurement.zzbw$zzg r1 = (com.google.android.gms.internal.measurement.zzbw.zzg) r1     // Catch:{ all -> 0x0f63 }
            r13 = r19
            r5.zza((com.google.android.gms.internal.measurement.zzbw.zzg) r1, (boolean) r13)     // Catch:{ all -> 0x0f63 }
        L_0x0ea7:
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()     // Catch:{ all -> 0x0f63 }
            java.util.List<java.lang.Long> r3 = r3.zzb     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0f63 }
            r1.zzd()     // Catch:{ all -> 0x0f63 }
            r1.zzak()     // Catch:{ all -> 0x0f63 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0f63 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0f63 }
            r6 = 0
        L_0x0ebe:
            int r7 = r3.size()     // Catch:{ all -> 0x0f63 }
            if (r6 >= r7) goto L_0x0edb
            if (r6 == 0) goto L_0x0ecb
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0f63 }
        L_0x0ecb:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0f63 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0f63 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0f63 }
            r5.append(r7)     // Catch:{ all -> 0x0f63 }
            int r6 = r6 + 1
            goto L_0x0ebe
        L_0x0edb:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0f63 }
            android.database.sqlite.SQLiteDatabase r6 = r1.mo26274c_()     // Catch:{ all -> 0x0f63 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0f63 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0f63 }
            int r6 = r3.size()     // Catch:{ all -> 0x0f63 }
            if (r5 == r6) goto L_0x0f0e
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x0f63 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0f63 }
            int r3 = r3.size()     // Catch:{ all -> 0x0f63 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0f63 }
            r1.zza(r6, r5, r3)     // Catch:{ all -> 0x0f63 }
        L_0x0f0e:
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()     // Catch:{ all -> 0x0f63 }
            android.database.sqlite.SQLiteDatabase r3 = r1.mo26274c_()     // Catch:{ all -> 0x0f63 }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0f25 }
            r7 = 0
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0f25 }
            r7 = 1
            r6[r7] = r4     // Catch:{ SQLiteException -> 0x0f25 }
            r3.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0f25 }
            goto L_0x0f38
        L_0x0f25:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x0f63 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r4)     // Catch:{ all -> 0x0f63 }
            r1.zza(r5, r4, r3)     // Catch:{ all -> 0x0f63 }
        L_0x0f38:
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()     // Catch:{ all -> 0x0f63 }
            r1.mo26273b_()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()
            r1.zzh()
            r1 = 1
            return r1
        L_0x0f48:
            r2 = r1
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()     // Catch:{ all -> 0x0f63 }
            r1.mo26273b_()     // Catch:{ all -> 0x0f63 }
            com.google.android.gms.measurement.internal.zzab r1 = r43.zze()
            r1.zzh()
            r1 = 0
            return r1
        L_0x0f59:
            r0 = move-exception
            r2 = r1
            goto L_0x024b
        L_0x0f5d:
            if (r5 == 0) goto L_0x0f62
            r5.close()     // Catch:{ all -> 0x0f63 }
        L_0x0f62:
            throw r1     // Catch:{ all -> 0x0f63 }
        L_0x0f63:
            r0 = move-exception
            goto L_0x0f67
        L_0x0f65:
            r0 = move-exception
            r2 = r1
        L_0x0f67:
            r1 = r0
            com.google.android.gms.measurement.internal.zzab r3 = r43.zze()
            r3.zzh()
            goto L_0x0f71
        L_0x0f70:
            throw r1
        L_0x0f71:
            goto L_0x0f70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zza(java.lang.String, long):boolean");
    }

    private final void zzb(zzbw.zzc.zza zza2, zzbw.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbw.zze zza4 = zzkk.zza((zzbw.zzc) ((zzfi) zza2.zzu()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzbw.zze zza5 = zzkk.zza((zzbw.zzc) ((zzfi) zza3.zzu()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh().zza(zza3, "_et", (Object) Long.valueOf(zzf2));
            zzh().zza(zza2, "_fr", (Object) 1L);
        }
    }

    private final Boolean zzb(zzg zzg2) {
        try {
            if (zzg2.zzm() != -2147483648L) {
                if (zzg2.zzm() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionName;
                if (zzg2.zzl() != null && zzg2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzkn zzkn, zzm zzm2) {
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
            } else if (!"_npa".equals(zzkn.zza) || zzm2.zzs == null) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkn.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkn.zza);
                    zze().mo26273b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkn.zza));
                } finally {
                    zze().zzh();
                }
            } else {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkn("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzm2.zzs.booleanValue() ? 1 : 0), "auto"), zzm2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x048c A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01cb A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ff A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0201 A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0205 A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0228 A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x022e A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x023b A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x024e A[Catch:{ SQLiteException -> 0x01b6, all -> 0x04b8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzm r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzw()
            r21.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            boolean r7 = r21.zze(r22)
            if (r7 != 0) goto L_0x0023
            return
        L_0x0023:
            com.google.android.gms.measurement.internal.zzab r7 = r21.zze()
            java.lang.String r8 = r2.zza
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzb(r8)
            r8 = 0
            if (r7 == 0) goto L_0x0056
            java.lang.String r10 = r7.zze()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0056
            java.lang.String r10 = r2.zzb
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0056
            r7.zzh((long) r8)
            com.google.android.gms.measurement.internal.zzab r10 = r21.zze()
            r10.zza((com.google.android.gms.measurement.internal.zzg) r7)
            com.google.android.gms.measurement.internal.zzfr r7 = r21.zzc()
            java.lang.String r10 = r2.zza
            r7.zzd(r10)
        L_0x0056:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x005e
            r21.zzc(r22)
            return
        L_0x005e:
            long r10 = r2.zzm
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.common.util.Clock r7 = r7.zzm()
            long r10 = r7.currentTimeMillis()
        L_0x006e:
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzak r7 = r7.zzx()
            r7.zzi()
            int r7 = r2.zzn
            r15 = 1
            if (r7 == 0) goto L_0x0098
            if (r7 == r15) goto L_0x0098
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzr()
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzi()
            java.lang.String r13 = r2.zza
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zza(r14, r13, r7)
            r7 = 0
        L_0x0098:
            com.google.android.gms.measurement.internal.zzab r12 = r21.zze()
            r12.zzf()
            com.google.android.gms.measurement.internal.zzab r12 = r21.zze()     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x04b8 }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzkp r14 = r12.zzc(r13, r14)     // Catch:{ all -> 0x04b8 }
            if (r14 == 0) goto L_0x00bc
            java.lang.String r12 = "auto"
            java.lang.String r13 = r14.zzb     // Catch:{ all -> 0x04b8 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x04b8 }
            if (r12 == 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            r18 = r3
            r3 = 1
            goto L_0x010f
        L_0x00bc:
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04b8 }
            if (r12 == 0) goto L_0x00f9
            com.google.android.gms.measurement.internal.zzkn r13 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04b8 }
            java.lang.String r18 = "_npa"
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04b8 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x04b8 }
            if (r12 == 0) goto L_0x00cf
            r19 = 1
            goto L_0x00d1
        L_0x00cf:
            r19 = r8
        L_0x00d1:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x04b8 }
            java.lang.String r20 = "auto"
            r8 = 1
            r12 = r13
            r8 = r13
            r13 = r18
            r18 = r3
            r9 = r14
            r3 = 1
            r14 = r10
            r16 = r19
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04b8 }
            if (r9 == 0) goto L_0x00f5
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x04b8 }
            java.lang.Long r12 = r8.zzc     // Catch:{ all -> 0x04b8 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x04b8 }
            if (r9 != 0) goto L_0x010f
        L_0x00f5:
            r1.zza((com.google.android.gms.measurement.internal.zzkn) r8, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
            goto L_0x010f
        L_0x00f9:
            r18 = r3
            r9 = r14
            r3 = 1
            if (r9 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzkn r8 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04b8 }
            r1.zzb((com.google.android.gms.measurement.internal.zzkn) r8, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
        L_0x010f:
            com.google.android.gms.measurement.internal.zzab r8 = r21.zze()     // Catch:{ all -> 0x04b8 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzb(r9)     // Catch:{ all -> 0x04b8 }
            if (r8 == 0) goto L_0x01c9
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj     // Catch:{ all -> 0x04b8 }
            r12.zzi()     // Catch:{ all -> 0x04b8 }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = r8.zze()     // Catch:{ all -> 0x04b8 }
            java.lang.String r14 = r2.zzr     // Catch:{ all -> 0x04b8 }
            java.lang.String r15 = r8.zzf()     // Catch:{ all -> 0x04b8 }
            boolean r12 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x04b8 }
            if (r12 == 0) goto L_0x01c9
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzr()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzi()     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r8.zzc()     // Catch:{ all -> 0x04b8 }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r14)     // Catch:{ all -> 0x04b8 }
            r12.zza(r13, r14)     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzab r12 = r21.zze()     // Catch:{ all -> 0x04b8 }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x04b8 }
            r12.zzak()     // Catch:{ all -> 0x04b8 }
            r12.zzd()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x04b8 }
            android.database.sqlite.SQLiteDatabase r13 = r12.mo26274c_()     // Catch:{ SQLiteException -> 0x01b6 }
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01b6 }
            r15 = 0
            r14[r15] = r8     // Catch:{ SQLiteException -> 0x01b6 }
            java.lang.String r9 = "events"
            int r9 = r13.delete(r9, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "apps"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r15
            java.lang.String r15 = "audience_filter_values"
            int r0 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01b6 }
            int r9 = r9 + r0
            if (r9 <= 0) goto L_0x01c8
            com.google.android.gms.measurement.internal.zzet r0 = r12.zzr()     // Catch:{ SQLiteException -> 0x01b6 }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzx()     // Catch:{ SQLiteException -> 0x01b6 }
            java.lang.String r13 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x01b6 }
            r0.zza(r13, r8, r9)     // Catch:{ SQLiteException -> 0x01b6 }
            goto L_0x01c8
        L_0x01b6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzet r9 = r12.zzr()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzf()     // Catch:{ all -> 0x04b8 }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r8)     // Catch:{ all -> 0x04b8 }
            r9.zza(r12, r8, r0)     // Catch:{ all -> 0x04b8 }
        L_0x01c8:
            r8 = 0
        L_0x01c9:
            if (r8 == 0) goto L_0x0228
            long r12 = r8.zzm()     // Catch:{ all -> 0x04b8 }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01e3
            long r12 = r8.zzm()     // Catch:{ all -> 0x04b8 }
            r9 = r4
            long r3 = r2.zzj     // Catch:{ all -> 0x04b8 }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01e4
            r0 = 1
            goto L_0x01e5
        L_0x01e3:
            r9 = r4
        L_0x01e4:
            r0 = 0
        L_0x01e5:
            long r3 = r8.zzm()     // Catch:{ all -> 0x04b8 }
            int r12 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x0201
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04b8 }
            if (r3 == 0) goto L_0x0201
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04b8 }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x04b8 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04b8 }
            if (r3 != 0) goto L_0x0201
            r14 = 1
            goto L_0x0202
        L_0x0201:
            r14 = 0
        L_0x0202:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x0229
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04b8 }
            r0.<init>()     // Catch:{ all -> 0x04b8 }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.zzl()     // Catch:{ all -> 0x04b8 }
            r0.putString(r3, r4)     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04b8 }
            r14.<init>(r0)     // Catch:{ all -> 0x04b8 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04b8 }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
            goto L_0x0229
        L_0x0228:
            r9 = r4
        L_0x0229:
            r21.zzc(r22)     // Catch:{ all -> 0x04b8 }
            if (r7 != 0) goto L_0x023b
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()     // Catch:{ all -> 0x04b8 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04b8 }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzam r0 = r0.zza((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x04b8 }
            goto L_0x024c
        L_0x023b:
            r3 = 1
            if (r7 != r3) goto L_0x024b
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()     // Catch:{ all -> 0x04b8 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04b8 }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzam r0 = r0.zza((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x04b8 }
            goto L_0x024c
        L_0x024b:
            r0 = 0
        L_0x024c:
            if (r0 != 0) goto L_0x048c
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r10 / r3
            r14 = 1
            long r12 = r12 + r14
            long r12 = r12 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r8 = "_et"
            if (r7 != 0) goto L_0x03ea
            com.google.android.gms.measurement.internal.zzkn r7 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04b8 }
            java.lang.String r14 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04b8 }
            java.lang.String r17 = "auto"
            r12 = r7
            r13 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04b8 }
            r1.zza((com.google.android.gms.measurement.internal.zzkn) r7, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzaa r7 = r7.zzb()     // Catch:{ all -> 0x04b8 }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzas.zzar     // Catch:{ all -> 0x04b8 }
            boolean r7 = r7.zze(r12, r13)     // Catch:{ all -> 0x04b8 }
            if (r7 == 0) goto L_0x0293
            r21.zzw()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzfx r7 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzfo r7 = r7.zzf()     // Catch:{ all -> 0x04b8 }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x04b8 }
            r7.zza(r12)     // Catch:{ all -> 0x04b8 }
        L_0x0293:
            r21.zzw()     // Catch:{ all -> 0x04b8 }
            r21.zzk()     // Catch:{ all -> 0x04b8 }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x04b8 }
            r7.<init>()     // Catch:{ all -> 0x04b8 }
            r12 = 1
            r7.putLong(r4, r12)     // Catch:{ all -> 0x04b8 }
            r7.putLong(r3, r12)     // Catch:{ all -> 0x04b8 }
            r3 = 0
            r7.putLong(r6, r3)     // Catch:{ all -> 0x04b8 }
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04b8 }
            r7.putLong(r9, r3)     // Catch:{ all -> 0x04b8 }
            r14 = r18
            r7.putLong(r14, r3)     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzaa r3 = r3.zzb()     // Catch:{ all -> 0x04b8 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x04b8 }
            boolean r3 = r3.zze(r4, r12)     // Catch:{ all -> 0x04b8 }
            if (r3 == 0) goto L_0x02cc
            r3 = 1
            r7.putLong(r8, r3)     // Catch:{ all -> 0x04b8 }
            goto L_0x02ce
        L_0x02cc:
            r3 = 1
        L_0x02ce:
            boolean r12 = r2.zzq     // Catch:{ all -> 0x04b8 }
            if (r12 == 0) goto L_0x02d5
            r7.putLong(r0, r3)     // Catch:{ all -> 0x04b8 }
        L_0x02d5:
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()     // Catch:{ all -> 0x04b8 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x04b8 }
            r0.zzd()     // Catch:{ all -> 0x04b8 }
            r0.zzak()     // Catch:{ all -> 0x04b8 }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.zzh(r3, r4)     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x04b8 }
            android.content.Context r0 = r0.zzn()     // Catch:{ all -> 0x04b8 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04b8 }
            if (r0 != 0) goto L_0x030f
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzr()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()     // Catch:{ all -> 0x04b8 }
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04b8 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r9)     // Catch:{ all -> 0x04b8 }
            r0.zza(r6, r9)     // Catch:{ all -> 0x04b8 }
        L_0x030b:
            r12 = 0
            goto L_0x03ce
        L_0x030f:
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x0321 }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x0321 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0321 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x0321 }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x0321 }
            goto L_0x0338
        L_0x0321:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzr()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzf()     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.zza     // Catch:{ all -> 0x04b8 }
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r15)     // Catch:{ all -> 0x04b8 }
            r12.zza(r13, r15, r0)     // Catch:{ all -> 0x04b8 }
            r0 = 0
        L_0x0338:
            if (r0 == 0) goto L_0x038a
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04b8 }
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x038a
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04b8 }
            r18 = r14
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x04b8 }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x036d
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzaa r0 = r0.zzb()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzbt     // Catch:{ all -> 0x04b8 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r12)     // Catch:{ all -> 0x04b8 }
            if (r0 == 0) goto L_0x0366
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x036b
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04b8 }
            goto L_0x036b
        L_0x0366:
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04b8 }
        L_0x036b:
            r14 = 0
            goto L_0x036e
        L_0x036d:
            r14 = 1
        L_0x036e:
            com.google.android.gms.measurement.internal.zzkn r0 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "_fi"
            if (r14 == 0) goto L_0x0377
            r14 = 1
            goto L_0x0379
        L_0x0377:
            r14 = 0
        L_0x0379:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x04b8 }
            java.lang.String r17 = "auto"
            r12 = r0
            r6 = r18
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04b8 }
            r1.zza((com.google.android.gms.measurement.internal.zzkn) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
            goto L_0x038b
        L_0x038a:
            r6 = r14
        L_0x038b:
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x039d }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x039d }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x039d }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x039d }
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x039d }
            goto L_0x03b4
        L_0x039d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfx r12 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzr()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzf()     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x04b8 }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r14)     // Catch:{ all -> 0x04b8 }
            r12.zza(r13, r14, r0)     // Catch:{ all -> 0x04b8 }
            r0 = 0
        L_0x03b4:
            if (r0 == 0) goto L_0x030b
            int r12 = r0.flags     // Catch:{ all -> 0x04b8 }
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x03c1
            r12 = 1
            r7.putLong(r9, r12)     // Catch:{ all -> 0x04b8 }
        L_0x03c1:
            int r0 = r0.flags     // Catch:{ all -> 0x04b8 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x030b
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04b8 }
            goto L_0x030b
        L_0x03ce:
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x03d5
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04b8 }
        L_0x03d5:
            com.google.android.gms.measurement.internal.zzaq r0 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04b8 }
            r14.<init>(r7)     // Catch:{ all -> 0x04b8 }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04b8 }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
            goto L_0x0446
        L_0x03ea:
            r5 = 1
            if (r7 != r5) goto L_0x0446
            com.google.android.gms.measurement.internal.zzkn r5 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ all -> 0x04b8 }
            java.lang.String r6 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04b8 }
            java.lang.String r17 = "auto"
            r12 = r5
            r13 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04b8 }
            r1.zza((com.google.android.gms.measurement.internal.zzkn) r5, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
            r21.zzw()     // Catch:{ all -> 0x04b8 }
            r21.zzk()     // Catch:{ all -> 0x04b8 }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x04b8 }
            r5.<init>()     // Catch:{ all -> 0x04b8 }
            r6 = 1
            r5.putLong(r4, r6)     // Catch:{ all -> 0x04b8 }
            r5.putLong(r3, r6)     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzaa r3 = r3.zzb()     // Catch:{ all -> 0x04b8 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x04b8 }
            boolean r3 = r3.zze(r4, r6)     // Catch:{ all -> 0x04b8 }
            if (r3 == 0) goto L_0x0429
            r3 = 1
            r5.putLong(r8, r3)     // Catch:{ all -> 0x04b8 }
            goto L_0x042b
        L_0x0429:
            r3 = 1
        L_0x042b:
            boolean r6 = r2.zzq     // Catch:{ all -> 0x04b8 }
            if (r6 == 0) goto L_0x0432
            r5.putLong(r0, r3)     // Catch:{ all -> 0x04b8 }
        L_0x0432:
            com.google.android.gms.measurement.internal.zzaq r0 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04b8 }
            r14.<init>(r5)     // Catch:{ all -> 0x04b8 }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04b8 }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
        L_0x0446:
            com.google.android.gms.measurement.internal.zzfx r0 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzaa r0 = r0.zzb()     // Catch:{ all -> 0x04b8 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzas.zzau     // Catch:{ all -> 0x04b8 }
            boolean r0 = r0.zze(r3, r4)     // Catch:{ all -> 0x04b8 }
            if (r0 != 0) goto L_0x04a9
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04b8 }
            r0.<init>()     // Catch:{ all -> 0x04b8 }
            r3 = 1
            r0.putLong(r8, r3)     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzfx r3 = r1.zzj     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzaa r3 = r3.zzb()     // Catch:{ all -> 0x04b8 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x04b8 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x04b8 }
            if (r3 == 0) goto L_0x0477
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04b8 }
        L_0x0477:
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04b8 }
            r14.<init>(r0)     // Catch:{ all -> 0x04b8 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04b8 }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
            goto L_0x04a9
        L_0x048c:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x04b8 }
            if (r0 == 0) goto L_0x04a9
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04b8 }
            r0.<init>()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04b8 }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzal r14 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ all -> 0x04b8 }
            r14.<init>(r0)     // Catch:{ all -> 0x04b8 }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04b8 }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04b8 }
        L_0x04a9:
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()     // Catch:{ all -> 0x04b8 }
            r0.mo26273b_()     // Catch:{ all -> 0x04b8 }
            com.google.android.gms.measurement.internal.zzab r0 = r21.zze()
            r0.zzh()
            return
        L_0x04b8:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzab r2 = r21.zze()
            r2.zzh()
            goto L_0x04c2
        L_0x04c1:
            throw r0
        L_0x04c2:
            goto L_0x04c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zzb(com.google.android.gms.measurement.internal.zzm):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzy zzy) {
        zzm zza2 = zza(zzy.zza);
        if (zza2 != null) {
            zzb(zzy, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzy zzy, zzm zzm2) {
        Preconditions.checkNotNull(zzy);
        Preconditions.checkNotEmpty(zzy.zza);
        Preconditions.checkNotNull(zzy.zzc);
        Preconditions.checkNotEmpty(zzy.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zze().zzf();
            try {
                zzc(zzm2);
                zzy zzd2 = zze().zzd(zzy.zza, zzy.zzc.zza);
                if (zzd2 != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzy.zza, this.zzj.zzj().zzc(zzy.zzc.zza));
                    zze().zze(zzy.zza, zzy.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzy.zza, zzy.zzc.zza);
                    }
                    if (zzy.zzk != null) {
                        Bundle bundle = null;
                        if (zzy.zzk.zzb != null) {
                            bundle = zzy.zzk.zzb.zzb();
                        }
                        Bundle bundle2 = bundle;
                        zzb(this.zzj.zzi().zza(zzy.zza, zzy.zzk.zza, bundle2, zzd2.zzb, zzy.zzk.zzd, true, false), zzm2);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzet.zza(zzy.zza), this.zzj.zzj().zzc(zzy.zzc.zza));
                }
                zze().mo26273b_();
            } finally {
                zze().zzh();
            }
        }
    }

    private static void zza(zzbw.zzg.zza zza2) {
        zza2.zzb(Long.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzbw.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    @VisibleForTesting
    private final void zza(zzbw.zzg.zza zza2, long j, boolean z) {
        zzkp zzkp;
        String str = z ? "_se" : "_lte";
        zzkp zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzkp = new zzkp(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkp = new zzkp(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzbw.zzk zzk2 = (zzbw.zzk) ((zzfi) zzbw.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzkp.zze).longValue()).zzu());
        boolean z2 = false;
        int zza3 = zzkk.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzkp);
            this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkp.zze);
        }
    }

    private final boolean zza(zzbw.zzc.zza zza2, zzbw.zzc.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbw.zze zza4 = zzkk.zza((zzbw.zzc) ((zzfi) zza2.zzu()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzd();
        }
        zzh();
        zzbw.zze zza5 = zzkk.zza((zzbw.zzc) ((zzfi) zza3.zzu()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    @VisibleForTesting
    private static void zza(zzbw.zzc.zza zza2, String str) {
        List<zzbw.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    @VisibleForTesting
    private static void zza(zzbw.zzc.zza zza2, int i, String str) {
        List<zzbw.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzbw.zze) ((zzfi) zzbw.zze.zzk().zza("_err").zza(Long.valueOf((long) i).longValue()).zzu())).zza((zzbw.zze) ((zzfi) zzbw.zze.zzk().zza("_ev").zzb(str).zzu()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzab zze2;
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzv;
        this.zzv = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long next : list) {
                        try {
                            zze2 = zze();
                            long longValue = next.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            if (zze2.mo26274c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzw == null || !this.zzw.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zze().mo26273b_();
                    zze().zzh();
                    this.zzw = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzx = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzm = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzm = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzm));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzr = false;
        zzaa();
    }

    private final void zza(zzg zzg2) {
        C3191a aVar;
        zzw();
        if (!zzle.zzb() || !this.zzj.zzb().zze(zzg2.zzc(), zzas.zzbo)) {
            if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzf())) {
                zza(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzg()) && TextUtils.isEmpty(zzg2.zzf())) {
            zza(zzg2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzg2);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzg2.zzc());
            zzbt.zzb zza3 = zzc().zza(zzg2.zzc());
            String zzb2 = zzc().zzb(zzg2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                aVar = null;
            } else {
                C3191a aVar2 = new C3191a();
                aVar2.put("If-Modified-Since", zzb2);
                aVar = aVar2;
            }
            this.zzq = true;
            zzfa zzd2 = zzd();
            String zzc2 = zzg2.zzc();
            zzkh zzkh = new zzkh(this);
            zzd2.zzd();
            zzd2.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkh);
            zzd2.zzq().zzb((Runnable) new zzfe(zzd2, zzc2, url, (byte[]) null, aVar, zzkh));
        } catch (MalformedURLException unused) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzet.zza(zzg2.zzc()), zza2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0172 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0176 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzw()
            r6.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0196 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzfx r1 = r6.zzj     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzr()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzx()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0196 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzab r1 = r6.zze()     // Catch:{ all -> 0x0196 }
            r1.zzf()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzab r1 = r6.zze()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzb(r7)     // Catch:{ all -> 0x018d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfx r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzi()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r7)     // Catch:{ all -> 0x018d }
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzfx r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r10 = r10.zzm()     // Catch:{ all -> 0x018d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzi((long) r10)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzab r10 = r6.zze()     // Catch:{ all -> 0x018d }
            r10.zza((com.google.android.gms.measurement.internal.zzg) r1)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfx r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzx()     // Catch:{ all -> 0x018d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfr r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            r9.zzc(r7)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfx r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzff r7 = r7.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r7 = r7.zzd     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfx r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x018d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r9)     // Catch:{ all -> 0x018d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzfx r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzff r7 = r7.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r7 = r7.zze     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfx r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r8 = r8.zzm()     // Catch:{ all -> 0x018d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r8)     // Catch:{ all -> 0x018d }
        L_0x00c5:
            r6.zzz()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x018d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x018d }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018d }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfr r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzab r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzh()     // Catch:{ all -> 0x0196 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfr r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.internal.measurement.zzbt$zzb r11 = r11.zza((java.lang.String) r7)     // Catch:{ all -> 0x018d }
            if (r11 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzfr r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzab r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzh()     // Catch:{ all -> 0x0196 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x0124:
            com.google.android.gms.measurement.internal.zzfx r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x018d }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzh((long) r2)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzab r9 = r6.zze()     // Catch:{ all -> 0x018d }
            r9.zza((com.google.android.gms.measurement.internal.zzg) r1)     // Catch:{ all -> 0x018d }
            if (r8 != r5) goto L_0x014a
            com.google.android.gms.measurement.internal.zzfx r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzk()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0162
        L_0x014a:
            com.google.android.gms.measurement.internal.zzfx r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzev r7 = r7.zzx()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            int r10 = r10.length     // Catch:{ all -> 0x018d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x018d }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x018d }
        L_0x0162:
            com.google.android.gms.measurement.internal.zzfa r7 = r6.zzd()     // Catch:{ all -> 0x018d }
            boolean r7 = r7.zzf()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            boolean r7 = r6.zzy()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            r6.zzl()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x0176:
            r6.zzz()     // Catch:{ all -> 0x018d }
        L_0x0179:
            com.google.android.gms.measurement.internal.zzab r7 = r6.zze()     // Catch:{ all -> 0x018d }
            r7.mo26273b_()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzab r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzh()     // Catch:{ all -> 0x0196 }
            r6.zzq = r0
            r6.zzaa()
            return
        L_0x018d:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzab r8 = r6.zze()     // Catch:{ all -> 0x0196 }
            r8.zzh()     // Catch:{ all -> 0x0196 }
            throw r7     // Catch:{ all -> 0x0196 }
        L_0x0196:
            r7 = move-exception
            r6.zzq = r0
            r6.zzaa()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzn == null) {
            this.zzn = new ArrayList();
        }
        this.zzn.add(runnable);
    }

    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            if (this.zzj.zzb().zza(zzas.zzbz) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzm zzm2) {
        if (this.zzv != null) {
            ArrayList arrayList = new ArrayList();
            this.zzw = arrayList;
            arrayList.addAll(this.zzv);
        }
        zzab zze2 = zze();
        String str = zzm2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.mo26274c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzet.zza(str), e);
        }
        if (zzm2.zzh) {
            zzb(zzm2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkn zzkn, zzm zzm2) {
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            int zzc2 = this.zzj.zzi().zzc(zzkn.zza);
            if (zzc2 != 0) {
                this.zzj.zzi();
                String zza2 = zzko.zza(zzkn.zza, 24, true);
                String str = zzkn.zza;
                this.zzj.zzi().zza(zzm2.zza, zzc2, "_ev", zza2, str != null ? str.length() : 0);
                return;
            }
            int zzb2 = this.zzj.zzi().zzb(zzkn.zza, zzkn.zza());
            if (zzb2 != 0) {
                this.zzj.zzi();
                String zza3 = zzko.zza(zzkn.zza, 24, true);
                Object zza4 = zzkn.zza();
                this.zzj.zzi().zza(zzm2.zza, zzb2, "_ev", zza3, (zza4 == null || (!(zza4 instanceof String) && !(zza4 instanceof CharSequence))) ? 0 : String.valueOf(zza4).length());
                return;
            }
            Object zzc3 = this.zzj.zzi().zzc(zzkn.zza, zzkn.zza());
            if (zzc3 != null) {
                if ("_sid".equals(zzkn.zza)) {
                    long j = zzkn.zzb;
                    String str2 = zzkn.zze;
                    long j2 = 0;
                    zzkp zzc4 = zze().zzc(zzm2.zza, "_sno");
                    if (zzc4 != null) {
                        Object obj = zzc4.zze;
                        if (obj instanceof Long) {
                            j2 = ((Long) obj).longValue();
                            zza(new zzkn("_sno", j, Long.valueOf(j2 + 1), str2), zzm2);
                        }
                    }
                    if (zzc4 != null) {
                        this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                    }
                    zzam zza5 = zze().zza(zzm2.zza, "_s");
                    if (zza5 != null) {
                        j2 = zza5.zzc;
                        this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                    }
                    zza(new zzkn("_sno", j, Long.valueOf(j2 + 1), str2), zzm2);
                }
                zzkp zzkp = new zzkp(zzm2.zza, zzkn.zze, zzkn.zza, zzkn.zzb, zzc3);
                this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzkp.zzc), zzc3);
                zze().zzf();
                try {
                    zzc(zzm2);
                    boolean zza6 = zze().zza(zzkp);
                    zze().mo26273b_();
                    if (!zza6) {
                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                        this.zzj.zzi().zza(zzm2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkd zzkd) {
        this.zzo++;
    }

    private final zzm zza(String str) {
        String str2 = str;
        zzg zzb2 = zze().zzb(str2);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            return new zzm(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zzle.zzb() || !this.zzj.zzb().zze(str2, zzas.zzbo)) ? null : zzb2.zzg());
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzet.zza(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzy zzy) {
        zzm zza2 = zza(zzy.zza);
        if (zza2 != null) {
            zza(zzy, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzy zzy, zzm zzm2) {
        Preconditions.checkNotNull(zzy);
        Preconditions.checkNotEmpty(zzy.zza);
        Preconditions.checkNotNull(zzy.zzb);
        Preconditions.checkNotNull(zzy.zzc);
        Preconditions.checkNotEmpty(zzy.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zzy zzy2 = new zzy(zzy);
            boolean z = false;
            zzy2.zze = false;
            zze().zzf();
            try {
                zzy zzd2 = zze().zzd(zzy2.zza, zzy2.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzy2.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzy2.zzc.zza), zzy2.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzy2.zzb = zzd2.zzb;
                    zzy2.zzd = zzd2.zzd;
                    zzy2.zzh = zzd2.zzh;
                    zzy2.zzf = zzd2.zzf;
                    zzy2.zzi = zzd2.zzi;
                    zzy2.zze = zzd2.zze;
                    zzy2.zzc = new zzkn(zzy2.zzc.zza, zzd2.zzc.zzb, zzy2.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzy2.zzf)) {
                    zzy2.zzc = new zzkn(zzy2.zzc.zza, zzy2.zzd, zzy2.zzc.zza(), zzy2.zzc.zze);
                    zzy2.zze = true;
                    z = true;
                }
                if (zzy2.zze) {
                    zzkn zzkn = zzy2.zzc;
                    zzkp zzkp = new zzkp(zzy2.zza, zzy2.zzb, zzkn.zza, zzkn.zzb, zzkn.zza());
                    if (zze().zza(zzkp)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzy2.zza, this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzet.zza(zzy2.zza), this.zzj.zzj().zzc(zzkp.zzc), zzkp.zze);
                    }
                    if (z && zzy2.zzi != null) {
                        zzb(new zzaq(zzy2.zzi, zzy2.zzd), zzm2);
                    }
                }
                if (zze().zza(zzy2)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzy2.zza, this.zzj.zzj().zzc(zzy2.zzc.zza), zzy2.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzet.zza(zzy2.zza), this.zzj.zzj().zzc(zzy2.zzc.zza), zzy2.zzc.zza());
                }
                zze().mo26273b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzg zza(com.google.android.gms.measurement.internal.zzm r9, com.google.android.gms.measurement.internal.zzg r10, java.lang.String r11) {
        /*
            r8 = this;
            r0 = 1
            if (r10 != 0) goto L_0x001e
            com.google.android.gms.measurement.internal.zzg r10 = new com.google.android.gms.measurement.internal.zzg
            com.google.android.gms.measurement.internal.zzfx r1 = r8.zzj
            java.lang.String r2 = r9.zza
            r10.<init>(r1, r2)
            com.google.android.gms.measurement.internal.zzfx r1 = r8.zzj
            com.google.android.gms.measurement.internal.zzko r1 = r1.zzi()
            java.lang.String r1 = r1.zzk()
            r10.zza((java.lang.String) r1)
            r10.zze((java.lang.String) r11)
        L_0x001c:
            r11 = 1
            goto L_0x003a
        L_0x001e:
            java.lang.String r1 = r10.zzh()
            boolean r1 = r11.equals(r1)
            if (r1 != 0) goto L_0x0039
            r10.zze((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzfx r11 = r8.zzj
            com.google.android.gms.measurement.internal.zzko r11 = r11.zzi()
            java.lang.String r11 = r11.zzk()
            r10.zza((java.lang.String) r11)
            goto L_0x001c
        L_0x0039:
            r11 = 0
        L_0x003a:
            java.lang.String r1 = r9.zzb
            java.lang.String r2 = r10.zze()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x004c
            java.lang.String r11 = r9.zzb
            r10.zzb((java.lang.String) r11)
            r11 = 1
        L_0x004c:
            java.lang.String r1 = r9.zzr
            java.lang.String r2 = r10.zzf()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x005e
            java.lang.String r11 = r9.zzr
            r10.zzc((java.lang.String) r11)
            r11 = 1
        L_0x005e:
            boolean r1 = com.google.android.gms.internal.measurement.zzle.zzb()
            if (r1 == 0) goto L_0x0088
            com.google.android.gms.measurement.internal.zzfx r1 = r8.zzj
            com.google.android.gms.measurement.internal.zzaa r1 = r1.zzb()
            java.lang.String r2 = r10.zzc()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzbo
            boolean r1 = r1.zze(r2, r3)
            if (r1 == 0) goto L_0x0088
            java.lang.String r1 = r9.zzv
            java.lang.String r2 = r10.zzg()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x0088
            java.lang.String r11 = r9.zzv
            r10.zzd((java.lang.String) r11)
            r11 = 1
        L_0x0088:
            java.lang.String r1 = r9.zzk
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = r9.zzk
            java.lang.String r2 = r10.zzi()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00a2
            java.lang.String r11 = r9.zzk
            r10.zzf((java.lang.String) r11)
            r11 = 1
        L_0x00a2:
            long r1 = r9.zze
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b8
            long r5 = r10.zzo()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00b8
            long r1 = r9.zze
            r10.zzd((long) r1)
            r11 = 1
        L_0x00b8:
            java.lang.String r1 = r9.zzc
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00d2
            java.lang.String r1 = r9.zzc
            java.lang.String r2 = r10.zzl()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00d2
            java.lang.String r11 = r9.zzc
            r10.zzg((java.lang.String) r11)
            r11 = 1
        L_0x00d2:
            long r1 = r9.zzj
            long r5 = r10.zzm()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00e2
            long r1 = r9.zzj
            r10.zzc((long) r1)
            r11 = 1
        L_0x00e2:
            java.lang.String r1 = r9.zzd
            if (r1 == 0) goto L_0x00f6
            java.lang.String r2 = r10.zzn()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00f6
            java.lang.String r11 = r9.zzd
            r10.zzh((java.lang.String) r11)
            r11 = 1
        L_0x00f6:
            long r1 = r9.zzf
            long r5 = r10.zzp()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0106
            long r1 = r9.zzf
            r10.zze((long) r1)
            r11 = 1
        L_0x0106:
            boolean r1 = r9.zzh
            boolean r2 = r10.zzr()
            if (r1 == r2) goto L_0x0114
            boolean r11 = r9.zzh
            r10.zza((boolean) r11)
            r11 = 1
        L_0x0114:
            java.lang.String r1 = r9.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x012e
            java.lang.String r1 = r9.zzg
            java.lang.String r2 = r10.zzac()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x012e
            java.lang.String r11 = r9.zzg
            r10.zzi((java.lang.String) r11)
            r11 = 1
        L_0x012e:
            com.google.android.gms.measurement.internal.zzfx r1 = r8.zzj
            com.google.android.gms.measurement.internal.zzaa r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzcm
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)
            if (r1 != 0) goto L_0x014c
            long r1 = r9.zzl
            long r5 = r10.zzae()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x014c
            long r1 = r9.zzl
            r10.zzp(r1)
            r11 = 1
        L_0x014c:
            boolean r1 = r9.zzo
            boolean r2 = r10.zzaf()
            if (r1 == r2) goto L_0x015a
            boolean r11 = r9.zzo
            r10.zzb((boolean) r11)
            r11 = 1
        L_0x015a:
            boolean r1 = r9.zzp
            boolean r2 = r10.zzag()
            if (r1 == r2) goto L_0x0168
            boolean r11 = r9.zzp
            r10.zzc((boolean) r11)
            r11 = 1
        L_0x0168:
            java.lang.Boolean r1 = r9.zzs
            java.lang.Boolean r2 = r10.zzah()
            if (r1 == r2) goto L_0x0176
            java.lang.Boolean r11 = r9.zzs
            r10.zza((java.lang.Boolean) r11)
            r11 = 1
        L_0x0176:
            long r1 = r9.zzt
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018a
            long r3 = r10.zzq()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018a
            long r1 = r9.zzt
            r10.zzf((long) r1)
            goto L_0x018b
        L_0x018a:
            r0 = r11
        L_0x018b:
            if (r0 == 0) goto L_0x0194
            com.google.android.gms.measurement.internal.zzab r9 = r8.zze()
            r9.zza((com.google.android.gms.measurement.internal.zzg) r10)
        L_0x0194:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkg.zza(com.google.android.gms.measurement.internal.zzm, com.google.android.gms.measurement.internal.zzg, java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzz();
    }
}
