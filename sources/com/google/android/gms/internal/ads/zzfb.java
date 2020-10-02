package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbo;
import com.google.android.gms.internal.ads.zzbv;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzfb extends zzfz {
    private static final zzgc<zzco> zzaaf = new zzgc<>();
    private final Context zzaag;
    private zzbo.zza zzaah = null;

    public zzfb(zzeo zzeo, String str, String str2, zzbv.zza.C6825zza zza, int i, int i2, Context context, zzbo.zza zza2) {
        super(zzeo, str, str2, zza, i, 27);
        this.zzaag = context;
        this.zzaah = zza2;
    }

    private static String zza(zzbo.zza zza) {
        if (zza == null || !zza.zzaa() || zzet.zzaq(zza.zzab().zzag())) {
            return null;
        }
        return zza.zzab().zzag();
    }

    private final String zzcy() {
        try {
            if (this.zzvp.zzcq() != null) {
                this.zzvp.zzcq().get();
            }
            zzbv.zza zzcp = this.zzvp.zzcp();
            if (zzcp == null || !zzcp.zzak()) {
                return null;
            }
            return zzcp.zzag();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcx() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzgc<com.google.android.gms.internal.ads.zzco> r0 = zzaaf
            android.content.Context r1 = r8.zzaag
            java.lang.String r1 = r1.getPackageName()
            java.util.concurrent.atomic.AtomicReference r0 = r0.zzar(r1)
            monitor-enter(r0)
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzco r1 = (com.google.android.gms.internal.ads.zzco) r1     // Catch:{ all -> 0x011e }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0036
            java.lang.String r4 = r1.zznk     // Catch:{ all -> 0x011e }
            boolean r4 = com.google.android.gms.internal.ads.zzet.zzaq(r4)     // Catch:{ all -> 0x011e }
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = r1.zznk     // Catch:{ all -> 0x011e }
            java.lang.String r5 = "E"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x011e }
            if (r4 != 0) goto L_0x0036
            java.lang.String r1 = r1.zznk     // Catch:{ all -> 0x011e }
            java.lang.String r4 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 == 0) goto L_0x00ea
            com.google.android.gms.internal.ads.zzbo$zza r1 = r8.zzaah     // Catch:{ all -> 0x011e }
            java.lang.String r1 = zza(r1)     // Catch:{ all -> 0x011e }
            boolean r1 = com.google.android.gms.internal.ads.zzet.zzaq(r1)     // Catch:{ all -> 0x011e }
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzbr r1 = com.google.android.gms.internal.ads.zzbr.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED     // Catch:{ all -> 0x011e }
            goto L_0x0082
        L_0x0048:
            com.google.android.gms.internal.ads.zzbo$zza r1 = r8.zzaah     // Catch:{ all -> 0x011e }
            java.lang.String r4 = zza(r1)     // Catch:{ all -> 0x011e }
            boolean r4 = com.google.android.gms.internal.ads.zzet.zzaq(r4)     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x006a
            if (r1 == 0) goto L_0x006a
            boolean r4 = r1.zzy()     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzbo$zzb r1 = r1.zzz()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbr r1 = r1.zzad()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbr r4 = com.google.android.gms.internal.ads.zzbr.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x011e }
            if (r1 != r4) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x011e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzeo r1 = r8.zzvp     // Catch:{ all -> 0x011e }
            boolean r1 = r1.zzcn()     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzbr r1 = com.google.android.gms.internal.ads.zzbr.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x011e }
            goto L_0x0082
        L_0x0080:
            com.google.android.gms.internal.ads.zzbr r1 = com.google.android.gms.internal.ads.zzbr.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011e }
        L_0x0082:
            java.lang.reflect.Method r4 = r8.zzaaw     // Catch:{ all -> 0x011e }
            r5 = 0
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x011e }
            android.content.Context r7 = r8.zzaag     // Catch:{ all -> 0x011e }
            r6[r2] = r7     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbr r7 = com.google.android.gms.internal.ads.zzbr.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011e }
            if (r1 != r7) goto L_0x0091
            r2 = 1
        L_0x0091:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x011e }
            r6[r3] = r2     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzzz.zzcnx     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzzv r7 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x011e }
            java.lang.Object r2 = r7.zzd(r2)     // Catch:{ all -> 0x011e }
            r7 = 2
            r6[r7] = r2     // Catch:{ all -> 0x011e }
            java.lang.Object r2 = r4.invoke(r5, r6)     // Catch:{ all -> 0x011e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzco r4 = new com.google.android.gms.internal.ads.zzco     // Catch:{ all -> 0x011e }
            r4.<init>(r2)     // Catch:{ all -> 0x011e }
            java.lang.String r2 = r4.zznk     // Catch:{ all -> 0x011e }
            boolean r2 = com.google.android.gms.internal.ads.zzet.zzaq(r2)     // Catch:{ all -> 0x011e }
            if (r2 != 0) goto L_0x00c1
            java.lang.String r2 = r4.zznk     // Catch:{ all -> 0x011e }
            java.lang.String r5 = "E"
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x00e7
        L_0x00c1:
            int[] r2 = com.google.android.gms.internal.ads.zzfe.zzaaj     // Catch:{ all -> 0x011e }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x011e }
            r1 = r2[r1]     // Catch:{ all -> 0x011e }
            if (r1 == r3) goto L_0x00db
            if (r1 == r7) goto L_0x00ce
            goto L_0x00e7
        L_0x00ce:
            java.lang.String r1 = r8.zzcy()     // Catch:{ all -> 0x011e }
            boolean r2 = com.google.android.gms.internal.ads.zzet.zzaq(r1)     // Catch:{ all -> 0x011e }
            if (r2 != 0) goto L_0x00e7
            r4.zznk = r1     // Catch:{ all -> 0x011e }
            goto L_0x00e7
        L_0x00db:
            com.google.android.gms.internal.ads.zzbo$zza r1 = r8.zzaah     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbo$zzc r1 = r1.zzab()     // Catch:{ all -> 0x011e }
            java.lang.String r1 = r1.zzag()     // Catch:{ all -> 0x011e }
            r4.zznk = r1     // Catch:{ all -> 0x011e }
        L_0x00e7:
            r0.set(r4)     // Catch:{ all -> 0x011e }
        L_0x00ea:
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzco r1 = (com.google.android.gms.internal.ads.zzco) r1     // Catch:{ all -> 0x011e }
            monitor-exit(r0)     // Catch:{ all -> 0x011e }
            com.google.android.gms.internal.ads.zzbv$zza$zza r2 = r8.zzaam
            monitor-enter(r2)
            if (r1 == 0) goto L_0x0119
            com.google.android.gms.internal.ads.zzbv$zza$zza r0 = r8.zzaam     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r1.zznk     // Catch:{ all -> 0x011b }
            r0.zzu((java.lang.String) r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzbv$zza$zza r0 = r8.zzaam     // Catch:{ all -> 0x011b }
            long r3 = r1.zznl     // Catch:{ all -> 0x011b }
            r0.zzt((long) r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzbv$zza$zza r0 = r8.zzaam     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r1.zznm     // Catch:{ all -> 0x011b }
            r0.zzw((java.lang.String) r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzbv$zza$zza r0 = r8.zzaam     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r1.zznn     // Catch:{ all -> 0x011b }
            r0.zzx((java.lang.String) r3)     // Catch:{ all -> 0x011b }
            com.google.android.gms.internal.ads.zzbv$zza$zza r0 = r8.zzaam     // Catch:{ all -> 0x011b }
            java.lang.String r1 = r1.zzno     // Catch:{ all -> 0x011b }
            r0.zzy((java.lang.String) r1)     // Catch:{ all -> 0x011b }
        L_0x0119:
            monitor-exit(r2)     // Catch:{ all -> 0x011b }
            return
        L_0x011b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x011b }
            throw r0
        L_0x011e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfb.zzcx():void");
    }
}
