package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public abstract class zzcq<T> {
    private static final Object zza = new Object();
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzb = null;
    private static boolean zzc = false;
    private static zzde<zzdd<zzcm>> zzd;
    private static final AtomicInteger zzh = new AtomicInteger();
    private final zzcw zze;
    private final String zzf;
    private final T zzg;
    private volatile int zzi;
    private volatile T zzj;
    private final boolean zzk;

    private zzcq(zzcw zzcw, String str, T t, boolean z) {
        this.zzi = -1;
        if (zzcw.zzb != null) {
            this.zze = zzcw;
            this.zzf = str;
            this.zzg = t;
            this.zzk = z;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void zza(Context context) {
        synchronized (zza) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzb != context) {
                zzcc.zzc();
                zzcz.zza();
                zzcl.zza();
                zzh.incrementAndGet();
                zzb = context;
                zzd = zzdh.zza(zzct.zza);
            }
        }
    }

    static final /* synthetic */ zzdd zzd() {
        new zzcp();
        return zzcp.zza(zzb);
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    public final String zzb() {
        return zza(this.zze.zzd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzc() {
        /*
            r6 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = zzh
            int r0 = r0.get()
            int r1 = r6.zzi
            if (r1 >= r0) goto L_0x00f1
            monitor-enter(r6)
            int r1 = r6.zzi     // Catch:{ all -> 0x00ee }
            if (r1 >= r0) goto L_0x00ec
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00e4
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcl r1 = com.google.android.gms.internal.measurement.zzcl.zza((android.content.Context) r1)     // Catch:{ all -> 0x00ee }
            java.lang.String r2 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.Object r1 = r1.zza((java.lang.String) r2)     // Catch:{ all -> 0x00ee }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x0031
            java.util.regex.Pattern r2 = com.google.android.gms.internal.measurement.zzcb.zzb     // Catch:{ all -> 0x00ee }
            java.util.regex.Matcher r1 = r2.matcher(r1)     // Catch:{ all -> 0x00ee }
            boolean r1 = r1.matches()     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            r2 = 0
            if (r1 != 0) goto L_0x006f
            com.google.android.gms.internal.measurement.zzcw r1 = r6.zze     // Catch:{ all -> 0x00ee }
            android.net.Uri r1 = r1.zzb     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x0058
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcw r3 = r6.zze     // Catch:{ all -> 0x00ee }
            android.net.Uri r3 = r3.zzb     // Catch:{ all -> 0x00ee }
            boolean r1 = com.google.android.gms.internal.measurement.zzco.zza(r1, r3)     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x0056
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00ee }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcw r3 = r6.zze     // Catch:{ all -> 0x00ee }
            android.net.Uri r3 = r3.zzb     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcc r1 = com.google.android.gms.internal.measurement.zzcc.zza(r1, r3)     // Catch:{ all -> 0x00ee }
            goto L_0x005e
        L_0x0056:
            r1 = r2
            goto L_0x005e
        L_0x0058:
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcz r1 = com.google.android.gms.internal.measurement.zzcz.zza((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00ee }
        L_0x005e:
            if (r1 == 0) goto L_0x0091
            java.lang.String r3 = r6.zzb()     // Catch:{ all -> 0x00ee }
            java.lang.Object r1 = r1.zza(r3)     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x0091
            java.lang.Object r1 = r6.zza((java.lang.Object) r1)     // Catch:{ all -> 0x00ee }
            goto L_0x0092
        L_0x006f:
            java.lang.String r1 = "PhenotypeFlag"
            r3 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r3)     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x0091
            java.lang.String r1 = "Bypass reading Phenotype values for flag: "
            java.lang.String r3 = r6.zzb()     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00ee }
            int r4 = r3.length()     // Catch:{ all -> 0x00ee }
            if (r4 == 0) goto L_0x008c
            r1.concat(r3)     // Catch:{ all -> 0x00ee }
            goto L_0x0091
        L_0x008c:
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x00ee }
            r3.<init>(r1)     // Catch:{ all -> 0x00ee }
        L_0x0091:
            r1 = r2
        L_0x0092:
            if (r1 == 0) goto L_0x0095
            goto L_0x00b4
        L_0x0095:
            android.content.Context r1 = zzb     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcl r1 = com.google.android.gms.internal.measurement.zzcl.zza((android.content.Context) r1)     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcw r3 = r6.zze     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = r3.zzc     // Catch:{ all -> 0x00ee }
            java.lang.String r3 = r6.zza((java.lang.String) r3)     // Catch:{ all -> 0x00ee }
            java.lang.Object r1 = r1.zza(r3)     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00ae
            java.lang.Object r1 = r6.zza((java.lang.Object) r1)     // Catch:{ all -> 0x00ee }
            goto L_0x00af
        L_0x00ae:
            r1 = r2
        L_0x00af:
            if (r1 == 0) goto L_0x00b2
            goto L_0x00b4
        L_0x00b2:
            T r1 = r6.zzg     // Catch:{ all -> 0x00ee }
        L_0x00b4:
            com.google.android.gms.internal.measurement.zzde<com.google.android.gms.internal.measurement.zzdd<com.google.android.gms.internal.measurement.zzcm>> r3 = zzd     // Catch:{ all -> 0x00ee }
            java.lang.Object r3 = r3.zza()     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzdd r3 = (com.google.android.gms.internal.measurement.zzdd) r3     // Catch:{ all -> 0x00ee }
            boolean r4 = r3.zza()     // Catch:{ all -> 0x00ee }
            if (r4 == 0) goto L_0x00df
            java.lang.Object r1 = r3.zzb()     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcm r1 = (com.google.android.gms.internal.measurement.zzcm) r1     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcw r3 = r6.zze     // Catch:{ all -> 0x00ee }
            android.net.Uri r3 = r3.zzb     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.measurement.zzcw r4 = r6.zze     // Catch:{ all -> 0x00ee }
            java.lang.String r4 = r4.zzd     // Catch:{ all -> 0x00ee }
            java.lang.String r5 = r6.zzf     // Catch:{ all -> 0x00ee }
            java.lang.String r1 = r1.zza(r3, r2, r4, r5)     // Catch:{ all -> 0x00ee }
            if (r1 != 0) goto L_0x00db
            T r1 = r6.zzg     // Catch:{ all -> 0x00ee }
            goto L_0x00df
        L_0x00db:
            java.lang.Object r1 = r6.zza((java.lang.Object) r1)     // Catch:{ all -> 0x00ee }
        L_0x00df:
            r6.zzj = r1     // Catch:{ all -> 0x00ee }
            r6.zzi = r0     // Catch:{ all -> 0x00ee }
            goto L_0x00ec
        L_0x00e4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00ee }
            java.lang.String r1 = "Must call PhenotypeFlag.init() first"
            r0.<init>(r1)     // Catch:{ all -> 0x00ee }
            throw r0     // Catch:{ all -> 0x00ee }
        L_0x00ec:
            monitor-exit(r6)     // Catch:{ all -> 0x00ee }
            goto L_0x00f1
        L_0x00ee:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00ee }
            throw r0
        L_0x00f1:
            T r0 = r6.zzj
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcq.zzc():java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static zzcq<Long> zzb(zzcw zzcw, String str, long j, boolean z) {
        return new zzcs(zzcw, str, Long.valueOf(j), false);
    }

    /* access modifiers changed from: private */
    public static zzcq<Boolean> zzb(zzcw zzcw, String str, boolean z, boolean z2) {
        return new zzcv(zzcw, str, Boolean.valueOf(z), false);
    }

    /* access modifiers changed from: private */
    public static zzcq<Double> zzb(zzcw zzcw, String str, double d, boolean z) {
        return new zzcu(zzcw, str, Double.valueOf(d), false);
    }

    /* access modifiers changed from: private */
    public static zzcq<String> zzb(zzcw zzcw, String str, String str2, boolean z) {
        return new zzcx(zzcw, str, str2, false);
    }

    /* synthetic */ zzcq(zzcw zzcw, String str, Object obj, boolean z, zzcs zzcs) {
        this(zzcw, str, obj, z);
    }

    static void zza() {
        zzh.incrementAndGet();
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzf;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzf);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }
}
