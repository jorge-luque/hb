package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.p004v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzif {
    private static boolean zzaiv = false;
    private static boolean zzaiw = false;
    private int streamType;
    private zzhl zzaek;
    private int zzagt;
    private final zzhs zzaix = null;
    private final zzim zzaiy;
    private final zziv zzaiz;
    private final zzhv[] zzaja;
    private final zzil zzajb;
    /* access modifiers changed from: private */
    public final ConditionVariable zzajc;
    private final long[] zzajd;
    private final zzih zzaje;
    private final LinkedList<zzik> zzajf;
    private AudioTrack zzajg;
    private int zzajh;
    private int zzaji;
    private int zzajj;
    private boolean zzajk;
    private int zzajl;
    private long zzajm;
    private zzhl zzajn;
    private long zzajo;
    private long zzajp;
    private ByteBuffer zzajq;
    private int zzajr;
    private int zzajs;
    private int zzajt;
    private long zzaju;
    private long zzajv;
    private boolean zzajw;
    private long zzajx;
    private Method zzajy;
    private int zzajz;
    private long zzaka;
    private long zzakb;
    private int zzakc;
    private long zzakd;
    private long zzake;
    private int zzakf;
    private int zzakg;
    private long zzakh;
    private long zzaki;
    private long zzakj;
    private zzhv[] zzakk;
    private ByteBuffer[] zzakl;
    private ByteBuffer zzakm;
    private ByteBuffer zzakn;
    private byte[] zzako;
    private int zzakp;
    private int zzakq;
    private boolean zzakr;
    private boolean zzaks;
    private int zzakt;
    private boolean zzaku;
    private boolean zzakv;
    private long zzakw;
    private float zzcy;

    public zzif(zzhs zzhs, zzhv[] zzhvArr, zzil zzil) {
        this.zzajb = zzil;
        this.zzajc = new ConditionVariable(true);
        if (zzov.SDK_INT >= 18) {
            try {
                this.zzajy = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzov.SDK_INT >= 19) {
            this.zzaje = new zzig();
        } else {
            this.zzaje = new zzih((zzie) null);
        }
        this.zzaiy = new zzim();
        this.zzaiz = new zziv();
        zzhv[] zzhvArr2 = new zzhv[(zzhvArr.length + 3)];
        this.zzaja = zzhvArr2;
        zzhvArr2[0] = new zzit();
        zzhv[] zzhvArr3 = this.zzaja;
        zzhvArr3[1] = this.zzaiy;
        System.arraycopy(zzhvArr, 0, zzhvArr3, 2, zzhvArr.length);
        this.zzaja[zzhvArr.length + 2] = this.zzaiz;
        this.zzajd = new long[10];
        this.zzcy = 1.0f;
        this.zzakg = 0;
        this.streamType = 3;
        this.zzakt = 0;
        this.zzaek = zzhl.zzahe;
        this.zzakq = -1;
        this.zzakk = new zzhv[0];
        this.zzakl = new ByteBuffer[0];
        this.zzajf = new LinkedList<>();
    }

    private final boolean isInitialized() {
        return this.zzajg != null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzax(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1095064472: goto L_0x002a;
                case 187078296: goto L_0x0020;
                case 1504578661: goto L_0x0016;
                case 1505942594: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0034
        L_0x000c:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 3
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "audio/eac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "audio/ac3"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x0045
            if (r5 == r4) goto L_0x0043
            if (r5 == r3) goto L_0x0041
            if (r5 == r2) goto L_0x003e
            return r1
        L_0x003e:
            r5 = 8
            return r5
        L_0x0041:
            r5 = 7
            return r5
        L_0x0043:
            r5 = 6
            return r5
        L_0x0045:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzif.zzax(java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r11 < r10) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zzin {
        /*
            r8 = this;
            boolean r0 = r9.hasRemaining()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.nio.ByteBuffer r0 = r8.zzakn
            r2 = 21
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r9) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.google.android.gms.internal.ads.zzoh.checkArgument(r0)
            goto L_0x003b
        L_0x0018:
            r8.zzakn = r9
            int r0 = com.google.android.gms.internal.ads.zzov.SDK_INT
            if (r0 >= r2) goto L_0x003b
            int r0 = r9.remaining()
            byte[] r4 = r8.zzako
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r8.zzako = r4
        L_0x002d:
            int r4 = r9.position()
            byte[] r5 = r8.zzako
            r9.get(r5, r3, r0)
            r9.position(r4)
            r8.zzakp = r3
        L_0x003b:
            int r0 = r9.remaining()
            int r4 = com.google.android.gms.internal.ads.zzov.SDK_INT
            if (r4 >= r2) goto L_0x0079
            long r10 = r8.zzakd
            com.google.android.gms.internal.ads.zzih r2 = r8.zzaje
            long r4 = r2.zzga()
            int r2 = r8.zzakc
            long r6 = (long) r2
            long r4 = r4 * r6
            long r10 = r10 - r4
            int r11 = (int) r10
            int r10 = r8.zzajl
            int r10 = r10 - r11
            if (r10 <= 0) goto L_0x0076
            int r10 = java.lang.Math.min(r0, r10)
            android.media.AudioTrack r11 = r8.zzajg
            byte[] r2 = r8.zzako
            int r4 = r8.zzakp
            int r10 = r11.write(r2, r4, r10)
            if (r10 <= 0) goto L_0x00f0
            int r11 = r8.zzakp
            int r11 = r11 + r10
            r8.zzakp = r11
            int r11 = r9.position()
            int r11 = r11 + r10
            r9.position(r11)
            goto L_0x00f0
        L_0x0076:
            r10 = 0
            goto L_0x00f0
        L_0x0079:
            boolean r2 = r8.zzaku
            if (r2 == 0) goto L_0x00ea
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0088
            r2 = 1
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            com.google.android.gms.internal.ads.zzoh.checkState(r2)
            android.media.AudioTrack r2 = r8.zzajg
            java.nio.ByteBuffer r4 = r8.zzajq
            if (r4 != 0) goto L_0x00a7
            r4 = 16
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r8.zzajq = r4
            java.nio.ByteOrder r5 = java.nio.ByteOrder.BIG_ENDIAN
            r4.order(r5)
            java.nio.ByteBuffer r4 = r8.zzajq
            r5 = 1431633921(0x55550001, float:1.46372496E13)
            r4.putInt(r5)
        L_0x00a7:
            int r4 = r8.zzajr
            if (r4 != 0) goto L_0x00c3
            java.nio.ByteBuffer r4 = r8.zzajq
            r5 = 4
            r4.putInt(r5, r0)
            java.nio.ByteBuffer r4 = r8.zzajq
            r5 = 8
            r6 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r6
            r4.putLong(r5, r10)
            java.nio.ByteBuffer r10 = r8.zzajq
            r10.position(r3)
            r8.zzajr = r0
        L_0x00c3:
            java.nio.ByteBuffer r10 = r8.zzajq
            int r10 = r10.remaining()
            if (r10 <= 0) goto L_0x00da
            java.nio.ByteBuffer r11 = r8.zzajq
            int r11 = r2.write(r11, r10, r1)
            if (r11 >= 0) goto L_0x00d7
            r8.zzajr = r3
            r10 = r11
            goto L_0x00f0
        L_0x00d7:
            if (r11 >= r10) goto L_0x00da
            goto L_0x0076
        L_0x00da:
            int r9 = r2.write(r9, r0, r1)
            if (r9 >= 0) goto L_0x00e3
            r8.zzajr = r3
            goto L_0x00e8
        L_0x00e3:
            int r10 = r8.zzajr
            int r10 = r10 - r9
            r8.zzajr = r10
        L_0x00e8:
            r10 = r9
            goto L_0x00f0
        L_0x00ea:
            android.media.AudioTrack r10 = r8.zzajg
            int r10 = r10.write(r9, r0, r1)
        L_0x00f0:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r8.zzakw = r4
            if (r10 < 0) goto L_0x0115
            boolean r9 = r8.zzajk
            if (r9 != 0) goto L_0x0102
            long r4 = r8.zzakd
            long r6 = (long) r10
            long r4 = r4 + r6
            r8.zzakd = r4
        L_0x0102:
            if (r10 != r0) goto L_0x0114
            boolean r9 = r8.zzajk
            if (r9 == 0) goto L_0x0110
            long r9 = r8.zzake
            int r11 = r8.zzakf
            long r2 = (long) r11
            long r9 = r9 + r2
            r8.zzake = r9
        L_0x0110:
            r9 = 0
            r8.zzakn = r9
            return r1
        L_0x0114:
            return r3
        L_0x0115:
            com.google.android.gms.internal.ads.zzin r9 = new com.google.android.gms.internal.ads.zzin
            r9.<init>(r10)
            goto L_0x011c
        L_0x011b:
            throw r9
        L_0x011c:
            goto L_0x011b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzif.zzb(java.nio.ByteBuffer, long):boolean");
    }

    private final void zzdv(long j) throws zzin {
        ByteBuffer byteBuffer;
        int length = this.zzakk.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzakl[i - 1];
            } else {
                byteBuffer = this.zzakm;
                if (byteBuffer == null) {
                    byteBuffer = zzhv.zzaig;
                }
            }
            if (i == length) {
                zzb(byteBuffer, j);
            } else {
                zzhv zzhv = this.zzakk[i];
                zzhv.zzi(byteBuffer);
                ByteBuffer zzfl = zzhv.zzfl();
                this.zzakl[i] = zzfl;
                if (zzfl.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    private final long zzdw(long j) {
        return (j * 1000000) / ((long) this.zzagt);
    }

    private final long zzdx(long j) {
        return (j * ((long) this.zzagt)) / 1000000;
    }

    private final void zzfm() {
        ArrayList arrayList = new ArrayList();
        for (zzhv zzhv : this.zzaja) {
            if (zzhv.isActive()) {
                arrayList.add(zzhv);
            } else {
                zzhv.flush();
            }
        }
        int size = arrayList.size();
        this.zzakk = (zzhv[]) arrayList.toArray(new zzhv[size]);
        this.zzakl = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzhv zzhv2 = this.zzakk[i];
            zzhv2.flush();
            this.zzakl[i] = zzhv2.zzfl();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzfp() throws com.google.android.gms.internal.ads.zzin {
        /*
            r9 = this;
            int r0 = r9.zzakq
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.zzajk
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzhv[] r0 = r9.zzakk
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.zzakq = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.zzakq
            com.google.android.gms.internal.ads.zzhv[] r5 = r9.zzakk
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zzfk()
        L_0x0028:
            r9.zzdv(r7)
            boolean r0 = r4.zzfd()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.zzakq
            int r0 = r0 + r2
            r9.zzakq = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.zzakn
            if (r0 == 0) goto L_0x0044
            r9.zzb(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzakn
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.zzakq = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzif.zzfp():boolean");
    }

    private final void zzft() {
        if (!isInitialized()) {
            return;
        }
        if (zzov.SDK_INT >= 21) {
            this.zzajg.setVolume(this.zzcy);
            return;
        }
        AudioTrack audioTrack = this.zzajg;
        float f = this.zzcy;
        audioTrack.setStereoVolume(f, f);
    }

    private final long zzfu() {
        return this.zzajk ? this.zzake : this.zzakd / ((long) this.zzakc);
    }

    private final void zzfv() {
        this.zzaju = 0;
        this.zzajt = 0;
        this.zzajs = 0;
        this.zzajv = 0;
        this.zzajw = false;
        this.zzajx = 0;
    }

    private final boolean zzfw() {
        if (zzov.SDK_INT >= 23) {
            return false;
        }
        int i = this.zzajj;
        return i == 5 || i == 6;
    }

    public final void pause() {
        this.zzaks = false;
        if (isInitialized()) {
            zzfv();
            this.zzaje.pause();
        }
    }

    public final void play() {
        this.zzaks = true;
        if (isInitialized()) {
            this.zzaki = System.nanoTime() / 1000;
            this.zzajg.play();
        }
    }

    public final void release() {
        reset();
        for (zzhv reset : this.zzaja) {
            reset.reset();
        }
        this.zzakt = 0;
        this.zzaks = false;
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzaka = 0;
            this.zzakb = 0;
            this.zzakd = 0;
            this.zzake = 0;
            this.zzakf = 0;
            zzhl zzhl = this.zzajn;
            if (zzhl != null) {
                this.zzaek = zzhl;
                this.zzajn = null;
            } else if (!this.zzajf.isEmpty()) {
                this.zzaek = this.zzajf.getLast().zzaek;
            }
            this.zzajf.clear();
            this.zzajo = 0;
            this.zzajp = 0;
            this.zzakm = null;
            this.zzakn = null;
            int i = 0;
            while (true) {
                zzhv[] zzhvArr = this.zzakk;
                if (i >= zzhvArr.length) {
                    break;
                }
                zzhv zzhv = zzhvArr[i];
                zzhv.flush();
                this.zzakl[i] = zzhv.zzfl();
                i++;
            }
            this.zzakr = false;
            this.zzakq = -1;
            this.zzajq = null;
            this.zzajr = 0;
            this.zzakg = 0;
            this.zzakj = 0;
            zzfv();
            if (this.zzajg.getPlayState() == 3) {
                this.zzajg.pause();
            }
            AudioTrack audioTrack = this.zzajg;
            this.zzajg = null;
            this.zzaje.zza((AudioTrack) null, false);
            this.zzajc.close();
            new zzie(this, audioTrack).start();
        }
    }

    public final void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            if (!this.zzaku) {
                reset();
                this.zzakt = 0;
            }
        }
    }

    public final void setVolume(float f) {
        if (this.zzcy != f) {
            this.zzcy = f;
            zzft();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzij {
        /*
            r7 = this;
            java.lang.String r12 = "audio/raw"
            boolean r12 = r12.equals(r8)
            r0 = 1
            r12 = r12 ^ r0
            if (r12 == 0) goto L_0x000f
            int r8 = zzax(r8)
            goto L_0x0010
        L_0x000f:
            r8 = r11
        L_0x0010:
            r1 = 0
            if (r12 != 0) goto L_0x004a
            int r11 = com.google.android.gms.internal.ads.zzov.zzg(r11, r9)
            r7.zzajz = r11
            com.google.android.gms.internal.ads.zzim r11 = r7.zzaiy
            r11.zzb(r13)
            com.google.android.gms.internal.ads.zzhv[] r11 = r7.zzaja
            int r13 = r11.length
            r2 = 0
            r3 = 0
        L_0x0023:
            if (r2 >= r13) goto L_0x0044
            r4 = r11[r2]
            boolean r5 = r4.zzb(r10, r9, r8)     // Catch:{ zzhu -> 0x003d }
            r3 = r3 | r5
            boolean r5 = r4.isActive()
            if (r5 == 0) goto L_0x003a
            int r9 = r4.zzfi()
            int r8 = r4.zzfj()
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0023
        L_0x003d:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzij r9 = new com.google.android.gms.internal.ads.zzij
            r9.<init>((java.lang.Throwable) r8)
            throw r9
        L_0x0044:
            if (r3 == 0) goto L_0x004b
            r7.zzfm()
            goto L_0x004b
        L_0x004a:
            r3 = 0
        L_0x004b:
            r11 = 252(0xfc, float:3.53E-43)
            r13 = 12
            switch(r9) {
                case 1: goto L_0x0080;
                case 2: goto L_0x007d;
                case 3: goto L_0x007a;
                case 4: goto L_0x0077;
                case 5: goto L_0x0074;
                case 6: goto L_0x0071;
                case 7: goto L_0x006e;
                case 8: goto L_0x006b;
                default: goto L_0x0052;
            }
        L_0x0052:
            com.google.android.gms.internal.ads.zzij r8 = new com.google.android.gms.internal.ads.zzij
            r10 = 38
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            java.lang.String r10 = "Unsupported channel count: "
            r11.append(r10)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r8.<init>((java.lang.String) r9)
            throw r8
        L_0x006b:
            int r2 = com.google.android.gms.internal.ads.zzgr.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x0081
        L_0x006e:
            r2 = 1276(0x4fc, float:1.788E-42)
            goto L_0x0081
        L_0x0071:
            r2 = 252(0xfc, float:3.53E-43)
            goto L_0x0081
        L_0x0074:
            r2 = 220(0xdc, float:3.08E-43)
            goto L_0x0081
        L_0x0077:
            r2 = 204(0xcc, float:2.86E-43)
            goto L_0x0081
        L_0x007a:
            r2 = 28
            goto L_0x0081
        L_0x007d:
            r2 = 12
            goto L_0x0081
        L_0x0080:
            r2 = 4
        L_0x0081:
            int r4 = com.google.android.gms.internal.ads.zzov.SDK_INT
            r5 = 23
            r6 = 5
            if (r4 > r5) goto L_0x00a8
            java.lang.String r4 = com.google.android.gms.internal.ads.zzov.DEVICE
            java.lang.String r5 = "foster"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00a8
            java.lang.String r4 = com.google.android.gms.internal.ads.zzov.MANUFACTURER
            java.lang.String r5 = "NVIDIA"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00a8
            r4 = 3
            if (r9 == r4) goto L_0x00a9
            if (r9 == r6) goto L_0x00a9
            r11 = 7
            if (r9 == r11) goto L_0x00a5
            goto L_0x00a8
        L_0x00a5:
            int r11 = com.google.android.gms.internal.ads.zzgr.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00a9
        L_0x00a8:
            r11 = r2
        L_0x00a9:
            int r2 = com.google.android.gms.internal.ads.zzov.SDK_INT
            r4 = 25
            if (r2 > r4) goto L_0x00be
            java.lang.String r2 = com.google.android.gms.internal.ads.zzov.DEVICE
            java.lang.String r4 = "fugu"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x00be
            if (r12 == 0) goto L_0x00be
            if (r9 != r0) goto L_0x00be
            goto L_0x00bf
        L_0x00be:
            r13 = r11
        L_0x00bf:
            if (r3 != 0) goto L_0x00d4
            boolean r11 = r7.isInitialized()
            if (r11 == 0) goto L_0x00d4
            int r11 = r7.zzaji
            if (r11 != r8) goto L_0x00d4
            int r11 = r7.zzagt
            if (r11 != r10) goto L_0x00d4
            int r11 = r7.zzajh
            if (r11 != r13) goto L_0x00d4
            return
        L_0x00d4:
            r7.reset()
            r7.zzaji = r8
            r7.zzajk = r12
            r7.zzagt = r10
            r7.zzajh = r13
            r11 = 2
            if (r12 == 0) goto L_0x00e3
            goto L_0x00e4
        L_0x00e3:
            r8 = 2
        L_0x00e4:
            r7.zzajj = r8
            int r8 = com.google.android.gms.internal.ads.zzov.zzg(r11, r9)
            r7.zzakc = r8
            if (r12 == 0) goto L_0x00fd
            int r8 = r7.zzajj
            if (r8 == r6) goto L_0x00fa
            r9 = 6
            if (r8 != r9) goto L_0x00f6
            goto L_0x00fa
        L_0x00f6:
            r8 = 49152(0xc000, float:6.8877E-41)
            goto L_0x0133
        L_0x00fa:
            r8 = 20480(0x5000, float:2.8699E-41)
            goto L_0x0133
        L_0x00fd:
            int r8 = r7.zzajj
            int r8 = android.media.AudioTrack.getMinBufferSize(r10, r13, r8)
            r9 = -2
            if (r8 == r9) goto L_0x0107
            goto L_0x0108
        L_0x0107:
            r0 = 0
        L_0x0108:
            com.google.android.gms.internal.ads.zzoh.checkState(r0)
            int r9 = r8 << 2
            r10 = 250000(0x3d090, double:1.235164E-318)
            long r10 = r7.zzdx(r10)
            int r11 = (int) r10
            int r10 = r7.zzakc
            int r10 = r10 * r11
            long r0 = (long) r8
            r2 = 750000(0xb71b0, double:3.70549E-318)
            long r2 = r7.zzdx(r2)
            int r8 = r7.zzakc
            long r4 = (long) r8
            long r2 = r2 * r4
            long r0 = java.lang.Math.max(r0, r2)
            int r8 = (int) r0
            if (r9 >= r10) goto L_0x012f
            r8 = r10
            goto L_0x0133
        L_0x012f:
            if (r9 <= r8) goto L_0x0132
            goto L_0x0133
        L_0x0132:
            r8 = r9
        L_0x0133:
            r7.zzajl = r8
            if (r12 == 0) goto L_0x013d
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0145
        L_0x013d:
            int r9 = r7.zzakc
            int r8 = r8 / r9
            long r8 = (long) r8
            long r8 = r7.zzdw(r8)
        L_0x0145:
            r7.zzajm = r8
            com.google.android.gms.internal.ads.zzhl r8 = r7.zzaek
            r7.zzb(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzif.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    public final boolean zzaw(String str) {
        zzhs zzhs = this.zzaix;
        return zzhs != null && zzhs.zzs(zzax(str));
    }

    public final boolean zzfd() {
        if (isInitialized()) {
            return this.zzakr && !zzfq();
        }
        return true;
    }

    public final void zzfn() {
        if (this.zzakg == 1) {
            this.zzakg = 2;
        }
    }

    public final void zzfo() throws zzin {
        if (!this.zzakr && isInitialized() && zzfp()) {
            this.zzaje.zzdy(zzfu());
            this.zzajr = 0;
            this.zzakr = true;
        }
    }

    public final boolean zzfq() {
        if (isInitialized()) {
            if (zzfu() <= this.zzaje.zzga()) {
                if (zzfw() && this.zzajg.getPlayState() == 2 && this.zzajg.getPlaybackHeadPosition() == 0) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final zzhl zzfr() {
        return this.zzaek;
    }

    public final void zzfs() {
        if (this.zzaku) {
            this.zzaku = false;
            this.zzakt = 0;
            reset();
        }
    }

    public final long zzj(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (!(isInitialized() && this.zzakg != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzajg.getPlayState() == 3) {
            long zzgb = this.zzaje.zzgb();
            if (zzgb != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzajv >= 30000) {
                    long[] jArr = this.zzajd;
                    int i = this.zzajs;
                    jArr[i] = zzgb - nanoTime;
                    this.zzajs = (i + 1) % 10;
                    int i2 = this.zzajt;
                    if (i2 < 10) {
                        this.zzajt = i2 + 1;
                    }
                    this.zzajv = nanoTime;
                    this.zzaju = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzajt;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzaju += this.zzajd[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzfw() && nanoTime - this.zzajx >= 500000) {
                    boolean zzfx = this.zzaje.zzfx();
                    this.zzajw = zzfx;
                    if (zzfx) {
                        long zzfy = this.zzaje.zzfy() / 1000;
                        long zzfz = this.zzaje.zzfz();
                        if (zzfy < this.zzaki) {
                            this.zzajw = false;
                        } else if (Math.abs(zzfy - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(zzfz);
                            sb.append(", ");
                            sb.append(zzfy);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(zzgb);
                            Log.w("AudioTrack", sb.toString());
                            this.zzajw = false;
                        } else if (Math.abs(zzdw(zzfz) - zzgb) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(zzfz);
                            sb2.append(", ");
                            sb2.append(zzfy);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(zzgb);
                            Log.w("AudioTrack", sb2.toString());
                            this.zzajw = false;
                        }
                    }
                    Method method = this.zzajy;
                    if (method != null && !this.zzajk) {
                        try {
                            long intValue = (((long) ((Integer) method.invoke(this.zzajg, (Object[]) null)).intValue()) * 1000) - this.zzajm;
                            this.zzakj = intValue;
                            long max = Math.max(intValue, 0);
                            this.zzakj = max;
                            if (max > 5000000) {
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(max);
                                Log.w("AudioTrack", sb3.toString());
                                this.zzakj = 0;
                            }
                        } catch (Exception unused) {
                            this.zzajy = null;
                        }
                    }
                    this.zzajx = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzajw) {
            j = zzdw(this.zzaje.zzfz() + zzdx(nanoTime2 - (this.zzaje.zzfy() / 1000)));
        } else {
            if (this.zzajt == 0) {
                j = this.zzaje.zzgb();
            } else {
                j = nanoTime2 + this.zzaju;
            }
            if (!z) {
                j -= this.zzakj;
            }
        }
        long j5 = this.zzakh;
        while (!this.zzajf.isEmpty() && j >= this.zzajf.getFirst().zzafn) {
            zzik remove = this.zzajf.remove();
            this.zzaek = remove.zzaek;
            this.zzajp = remove.zzafn;
            this.zzajo = remove.zzalj - this.zzakh;
        }
        if (this.zzaek.zzahf == 1.0f) {
            j2 = (j + this.zzajo) - this.zzajp;
        } else {
            if (!this.zzajf.isEmpty() || this.zzaiz.zzgk() < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                j3 = this.zzajo;
                double d = (double) this.zzaek.zzahf;
                double d2 = (double) (j - this.zzajp);
                Double.isNaN(d);
                Double.isNaN(d2);
                j4 = (long) (d * d2);
            } else {
                j3 = this.zzajo;
                j4 = zzov.zza(j - this.zzajp, this.zzaiz.zzgj(), this.zzaiz.zzgk());
            }
            j2 = j4 + j3;
        }
        return j5 + j2;
    }

    public final void zzv(int i) {
        zzoh.checkState(zzov.SDK_INT >= 21);
        if (!this.zzaku || this.zzakt != i) {
            this.zzaku = true;
            this.zzakt = i;
            reset();
        }
    }

    public final boolean zza(ByteBuffer byteBuffer, long j) throws zzii, zzin {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        ByteBuffer byteBuffer3 = this.zzakm;
        zzoh.checkArgument(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!isInitialized()) {
            this.zzajc.block();
            if (this.zzaku) {
                this.zzajg = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzajh).setEncoding(this.zzajj).setSampleRate(this.zzagt).build(), this.zzajl, 1, this.zzakt);
            } else if (this.zzakt == 0) {
                this.zzajg = new AudioTrack(this.streamType, this.zzagt, this.zzajh, this.zzajj, this.zzajl, 1);
            } else {
                this.zzajg = new AudioTrack(this.streamType, this.zzagt, this.zzajh, this.zzajj, this.zzajl, 1, this.zzakt);
            }
            int state = this.zzajg.getState();
            if (state == 1) {
                int audioSessionId = this.zzajg.getAudioSessionId();
                if (this.zzakt != audioSessionId) {
                    this.zzakt = audioSessionId;
                    this.zzajb.zzu(audioSessionId);
                }
                this.zzaje.zza(this.zzajg, zzfw());
                zzft();
                this.zzakv = false;
                if (this.zzaks) {
                    play();
                }
            } else {
                try {
                    this.zzajg.release();
                } catch (Exception unused) {
                } finally {
                    this.zzajg = null;
                }
                throw new zzii(state, this.zzagt, this.zzajh, this.zzajl);
            }
        }
        if (zzfw()) {
            if (this.zzajg.getPlayState() == 2) {
                this.zzakv = false;
                return false;
            } else if (this.zzajg.getPlayState() == 1 && this.zzaje.zzga() != 0) {
                return false;
            }
        }
        boolean z = this.zzakv;
        boolean zzfq = zzfq();
        this.zzakv = zzfq;
        if (z && !zzfq && this.zzajg.getPlayState() != 1) {
            this.zzajb.zzc(this.zzajl, zzgr.zzdo(this.zzajm), SystemClock.elapsedRealtime() - this.zzakw);
        }
        if (this.zzakm == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzajk && this.zzakf == 0) {
                int i3 = this.zzajj;
                if (i3 == 7 || i3 == 8) {
                    i2 = zzip.zzj(byteBuffer);
                } else if (i3 == 5) {
                    i2 = zzht.zzfh();
                } else if (i3 == 6) {
                    i2 = zzht.zzh(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzakf = i2;
            }
            if (this.zzajn != null) {
                if (!zzfp()) {
                    return false;
                }
                LinkedList<zzik> linkedList = this.zzajf;
                zzik zzik = r11;
                zzik zzik2 = new zzik(this.zzajn, Math.max(0, j2), zzdw(zzfu()), (zzie) null);
                linkedList.add(zzik);
                this.zzajn = null;
                zzfm();
            }
            if (this.zzakg == 0) {
                this.zzakh = Math.max(0, j2);
                this.zzakg = 1;
            } else {
                long zzdw = this.zzakh + zzdw(this.zzajk ? this.zzakb : this.zzaka / ((long) this.zzajz));
                if (this.zzakg != 1 || Math.abs(zzdw - j2) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzdw);
                    sb2.append(", got ");
                    sb2.append(j2);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.zzakg = 2;
                }
                if (this.zzakg == i) {
                    this.zzakh += j2 - zzdw;
                    this.zzakg = 1;
                    this.zzajb.zzej();
                }
            }
            if (this.zzajk) {
                this.zzakb += (long) this.zzakf;
            } else {
                this.zzaka += (long) byteBuffer.remaining();
            }
            this.zzakm = byteBuffer2;
        }
        if (this.zzajk) {
            zzb(this.zzakm, j2);
        } else {
            zzdv(j2);
        }
        if (this.zzakm.hasRemaining()) {
            return false;
        }
        this.zzakm = null;
        return true;
    }

    public final zzhl zzb(zzhl zzhl) {
        if (this.zzajk) {
            zzhl zzhl2 = zzhl.zzahe;
            this.zzaek = zzhl2;
            return zzhl2;
        }
        zzhl zzhl3 = new zzhl(this.zzaiz.zzb(zzhl.zzahf), this.zzaiz.zzc(zzhl.zzahg));
        zzhl zzhl4 = this.zzajn;
        if (zzhl4 == null) {
            if (!this.zzajf.isEmpty()) {
                zzhl4 = this.zzajf.getLast().zzaek;
            } else {
                zzhl4 = this.zzaek;
            }
        }
        if (!zzhl3.equals(zzhl4)) {
            if (isInitialized()) {
                this.zzajn = zzhl3;
            } else {
                this.zzaek = zzhl3;
            }
        }
        return this.zzaek;
    }
}
