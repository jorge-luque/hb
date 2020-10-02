package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzbdx extends zzbdl implements zzoi<zznu> {
    private String url;
    private ByteBuffer zzalo;
    private final zzbby zzeet;
    private boolean zzehc;
    private final zzbdy zzehd = new zzbdy();
    private final zzbdd zzehe = new zzbdd();
    private boolean zzehf;
    private final Object zzehg = new Object();
    private boolean zzehh;

    public zzbdx(zzbbx zzbbx, zzbby zzbby) {
        super(zzbbx);
        this.zzeet = zzbby;
    }

    private final void zzyx() {
        int zzaam = (int) this.zzehd.zzaam();
        int zzl = (int) this.zzehe.zzl(this.zzalo);
        int position = this.zzalo.position();
        int round = Math.round(((float) zzl) * (((float) position) / ((float) zzaam)));
        boolean z = round > 0;
        int zzaai = zzbcu.zzaai();
        int zzaaj = zzbcu.zzaaj();
        String str = this.url;
        zza(str, zzfm(str), position, zzaam, (long) round, (long) zzl, z, zzaai, zzaaj);
    }

    public final void abort() {
        this.zzehc = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzehg) {
            if (this.zzalo != null && !this.zzehf) {
                this.zzalo.flip();
                this.zzehf = true;
            }
            this.zzehc = true;
        }
        return this.zzalo;
    }

    public final String getUrl() {
        return this.url;
    }

    public final /* synthetic */ void zza(Object obj, zznv zznv) {
        zznu zznu = (zznu) obj;
        if (zznu instanceof zznx) {
            this.zzehd.zza((zznx) zznu);
        }
    }

    public final boolean zzaal() {
        return this.zzehh;
    }

    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    /* JADX WARNING: type inference failed for: r1v31, types: [com.google.android.gms.internal.ads.zzbcp] */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c2, code lost:
        if (r9.zzalo.remaining() > 0) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c4, code lost:
        zzyx();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cb, code lost:
        if (r9.zzehc != false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cd, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
        if ((r12 - r16) < r4) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d7, code lost:
        zzyx();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e3, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r1 = new java.lang.StringBuilder(49);
        r1.append("Timeout exceeded. Limit: ");
        r1.append(r6);
        r1.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010a, code lost:
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010b, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1 = r9.zzalo.limit();
        r3 = new java.lang.StringBuilder(35);
        r3.append("Precache abort at ");
        r3.append(r1);
        r3.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0130, code lost:
        throw new java.io.IOException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0136, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0137, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfl(java.lang.String r22) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            r9.url = r10
            java.lang.String r11 = r21.zzfm(r22)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zznx r0 = new com.google.android.gms.internal.ads.zznx     // Catch:{ Exception -> 0x013c }
            java.lang.String r2 = r9.zzdym     // Catch:{ Exception -> 0x013c }
            r3 = 0
            com.google.android.gms.internal.ads.zzbby r1 = r9.zzeet     // Catch:{ Exception -> 0x013c }
            int r5 = r1.zzedu     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzbby r1 = r9.zzeet     // Catch:{ Exception -> 0x013c }
            int r6 = r1.zzedw     // Catch:{ Exception -> 0x013c }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzbby r1 = r9.zzeet     // Catch:{ Exception -> 0x013c }
            boolean r1 = r1.zzeea     // Catch:{ Exception -> 0x013c }
            if (r1 == 0) goto L_0x0035
            com.google.android.gms.internal.ads.zzbcp r1 = new com.google.android.gms.internal.ads.zzbcp     // Catch:{ Exception -> 0x0032 }
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x0032 }
            r3 = 0
            r1.<init>(r2, r0, r3, r3)     // Catch:{ Exception -> 0x0032 }
            r0 = r1
            goto L_0x0035
        L_0x0032:
            r0 = move-exception
            goto L_0x013f
        L_0x0035:
            android.net.Uri r1 = android.net.Uri.parse(r22)     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zznv r2 = new com.google.android.gms.internal.ads.zznv     // Catch:{ Exception -> 0x013c }
            r2.<init>(r1)     // Catch:{ Exception -> 0x013c }
            r0.zza(r2)     // Catch:{ Exception -> 0x013c }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzbbx> r1 = r9.zzego     // Catch:{ Exception -> 0x013c }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzbbx r1 = (com.google.android.gms.internal.ads.zzbbx) r1     // Catch:{ Exception -> 0x013c }
            if (r1 == 0) goto L_0x004e
            r1.zza((java.lang.String) r11, (com.google.android.gms.internal.ads.zzbdl) r9)     // Catch:{ Exception -> 0x0032 }
        L_0x004e:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ Exception -> 0x013c }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzzz.zzcjl     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzzv r5 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ Exception -> 0x013c }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ Exception -> 0x013c }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x013c }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzzz.zzcjk     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzzv r7 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ Exception -> 0x013c }
            java.lang.Object r6 = r7.zzd(r6)     // Catch:{ Exception -> 0x013c }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x013c }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x013c }
            com.google.android.gms.internal.ads.zzbby r8 = r9.zzeet     // Catch:{ Exception -> 0x013c }
            int r8 = r8.zzedt     // Catch:{ Exception -> 0x013c }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x013c }
            r9.zzalo = r8     // Catch:{ Exception -> 0x013c }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]     // Catch:{ Exception -> 0x013c }
            r16 = r2
        L_0x0086:
            java.nio.ByteBuffer r14 = r9.zzalo     // Catch:{ Exception -> 0x013c }
            int r14 = r14.remaining()     // Catch:{ Exception -> 0x013c }
            int r14 = java.lang.Math.min(r14, r8)     // Catch:{ Exception -> 0x013c }
            int r14 = r0.read(r15, r13, r14)     // Catch:{ Exception -> 0x013c }
            r8 = -1
            if (r14 != r8) goto L_0x00a9
            r8 = 1
            r9.zzehh = r8     // Catch:{ Exception -> 0x0032 }
            com.google.android.gms.internal.ads.zzbdd r0 = r9.zzehe     // Catch:{ Exception -> 0x0032 }
            java.nio.ByteBuffer r1 = r9.zzalo     // Catch:{ Exception -> 0x0032 }
            long r0 = r0.zzl(r1)     // Catch:{ Exception -> 0x0032 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0032 }
            long r0 = (long) r1     // Catch:{ Exception -> 0x0032 }
            r9.zzb(r10, r11, r0)     // Catch:{ Exception -> 0x0032 }
        L_0x00a7:
            r1 = 1
            goto L_0x00c8
        L_0x00a9:
            java.lang.Object r8 = r9.zzehg     // Catch:{ Exception -> 0x013c }
            monitor-enter(r8)     // Catch:{ Exception -> 0x013c }
            boolean r13 = r9.zzehc     // Catch:{ all -> 0x0131 }
            if (r13 != 0) goto L_0x00b9
            java.nio.ByteBuffer r13 = r9.zzalo     // Catch:{ all -> 0x0131 }
            r18 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x013a }
            goto L_0x00bb
        L_0x00b9:
            r18 = r12
        L_0x00bb:
            monitor-exit(r8)     // Catch:{ all -> 0x013a }
            java.nio.ByteBuffer r8 = r9.zzalo     // Catch:{ Exception -> 0x0136 }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x0136 }
            if (r8 > 0) goto L_0x00c9
            r21.zzyx()     // Catch:{ Exception -> 0x0136 }
            goto L_0x00a7
        L_0x00c8:
            return r1
        L_0x00c9:
            boolean r8 = r9.zzehc     // Catch:{ Exception -> 0x0136 }
            if (r8 != 0) goto L_0x010b
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0136 }
            long r19 = r12 - r16
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00dc
            r21.zzyx()     // Catch:{ Exception -> 0x0136 }
            r16 = r12
        L_0x00dc:
            long r12 = r12 - r2
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r6
            int r8 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r8 > 0) goto L_0x00eb
            r12 = r18
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x0086
        L_0x00eb:
            java.lang.String r12 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0032 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r1.append(r0)     // Catch:{ Exception -> 0x0032 }
            r1.append(r6)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = " sec"
            r1.append(r0)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0032 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0032 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0032 }
            throw r1     // Catch:{ Exception -> 0x0032 }
        L_0x010b:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0032 }
            java.nio.ByteBuffer r1 = r9.zzalo     // Catch:{ Exception -> 0x0032 }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x0032 }
            r2 = 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0032 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = "Precache abort at "
            r3.append(r2)     // Catch:{ Exception -> 0x0032 }
            r3.append(r1)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r1 = " bytes"
            r3.append(r1)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0032 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0032 }
            throw r0     // Catch:{ Exception -> 0x0032 }
        L_0x0131:
            r0 = move-exception
            r18 = r12
        L_0x0134:
            monitor-exit(r8)     // Catch:{ all -> 0x013a }
            throw r0     // Catch:{ Exception -> 0x0136 }
        L_0x0136:
            r0 = move-exception
            r12 = r18
            goto L_0x013f
        L_0x013a:
            r0 = move-exception
            goto L_0x0134
        L_0x013c:
            r0 = move-exception
            r18 = r12
        L_0x013f:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = java.lang.String.valueOf(r22)
            int r1 = r1.length()
            int r1 = r1 + 34
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzazw.zzfc(r1)
            r9.zza(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdx.zzfl(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public final String zzfm(String str) {
        String valueOf = String.valueOf(super.zzfm(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }
}
