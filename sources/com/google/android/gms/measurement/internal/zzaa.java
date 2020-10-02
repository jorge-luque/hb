package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzjn;
import com.google.android.gms.internal.measurement.zzlv;
import com.ogury.p159cm.OguryChoiceManager;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzaa extends zzgs {
    private Boolean zza;
    private zzac zzb = zzz.zza;
    private Boolean zzc;

    zzaa(zzfx zzfx) {
        super(zzfx);
    }

    public static long zzk() {
        return zzas.zzac.zza(null).longValue();
    }

    public static long zzv() {
        return zzas.zzc.zza(null).longValue();
    }

    @VisibleForTesting
    private final Bundle zzz() {
        try {
            if (zzn().getPackageManager() == null) {
                zzr().zzf().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzn()).getApplicationInfo(zzn().getPackageName(), OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzr().zzf().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzac zzac) {
        this.zzb = zzac;
    }

    public final int zzb(String str) {
        return zzb(str, zzas.zzn);
    }

    /* access modifiers changed from: package-private */
    public final int zzc(String str) {
        if (!zzjn.zzb() || !zzd((String) null, zzas.zzck)) {
            return 25;
        }
        return zza(str, zzas.zzaf, 25, 100);
    }

    public final boolean zzd(String str, zzem<Boolean> zzem) {
        if (str == null) {
            return zzem.zza(null).booleanValue();
        }
        String zza2 = this.zzb.zza(str, zzem.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzem.zza(null).booleanValue();
        }
        return zzem.zza(Boolean.valueOf(Boolean.parseBoolean(zza2))).booleanValue();
    }

    public final int zze() {
        if (!zzjn.zzb() || !zzt().zzd((String) null, zzas.zzcl) || zzp().zzj() < 2147483) {
            return 25;
        }
        return 100;
    }

    public final long zzf() {
        zzu();
        return 27000;
    }

    public final boolean zzg() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzn().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzr().zzf().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final boolean zzh() {
        zzu();
        Boolean zzd = zzd("firebase_analytics_collection_deactivated");
        return zzd != null && zzd.booleanValue();
    }

    public final Boolean zzi() {
        zzb();
        Boolean zzd = zzd("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(zzd == null || zzd.booleanValue());
    }

    public final Boolean zzj() {
        zzb();
        boolean z = true;
        if (!zzlv.zzb() || !zza(zzas.zzcc)) {
            return true;
        }
        Boolean zzd = zzd("google_analytics_automatic_screen_reporting_enabled");
        if (zzd != null && !zzd.booleanValue()) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final /* bridge */ /* synthetic */ zzak zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzer zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzko zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfu zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzet zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzff zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzaa zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzv zzu() {
        return super.zzu();
    }

    public final String zzw() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzx() {
        return zza("debug.deferred.deeplink", "");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzy() {
        if (this.zza == null) {
            Boolean zzd = zzd("app_measurement_lite");
            this.zza = zzd;
            if (zzd == null) {
                this.zza = false;
            }
        }
        if (this.zza.booleanValue() || !this.zzz.zzt()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int zza(String str) {
        if (!zzjn.zzb() || !zzd((String) null, zzas.zzck)) {
            return 500;
        }
        return zza(str, zzas.zzag, 500, 2000);
    }

    public final int zzb(String str, zzem<Integer> zzem) {
        if (str == null) {
            return zzem.zza(null).intValue();
        }
        String zza2 = this.zzb.zza(str, zzem.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzem.zza(null).intValue();
        }
        try {
            return zzem.zza(Integer.valueOf(Integer.parseInt(zza2))).intValue();
        } catch (NumberFormatException unused) {
            return zzem.zza(null).intValue();
        }
    }

    public final boolean zzf(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final double zzc(String str, zzem<Double> zzem) {
        if (str == null) {
            return zzem.zza(null).doubleValue();
        }
        String zza2 = this.zzb.zza(str, zzem.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzem.zza(null).doubleValue();
        }
        try {
            return zzem.zza(Double.valueOf(Double.parseDouble(zza2))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzem.zza(null).doubleValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh(String str) {
        return zzd(str, zzas.zzaj);
    }

    /* access modifiers changed from: package-private */
    public final String zzi(String str) {
        zzem<String> zzem = zzas.zzak;
        if (str == null) {
            return zzem.zza(null);
        }
        return zzem.zza(this.zzb.zza(str, zzem.zza()));
    }

    public final long zza(String str, zzem<Long> zzem) {
        if (str == null) {
            return zzem.zza(null).longValue();
        }
        String zza2 = this.zzb.zza(str, zzem.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzem.zza(null).longValue();
        }
        try {
            return zzem.zza(Long.valueOf(Long.parseLong(zza2))).longValue();
        } catch (NumberFormatException unused) {
            return zzem.zza(null).longValue();
        }
    }

    public final boolean zze(String str, zzem<Boolean> zzem) {
        return zzd(str, zzem);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b A[SYNTHETIC, Splitter:B:9:0x002b] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> zze(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzz()
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.google.android.gms.measurement.internal.zzet r4 = r3.zzr()
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x0017:
            r4 = r1
            goto L_0x0028
        L_0x0019:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0028:
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            android.content.Context r0 = r3.zzn()     // Catch:{ NotFoundException -> 0x0043 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0043 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0043 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0043 }
            if (r4 != 0) goto L_0x003e
            return r1
        L_0x003e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzet r0 = r3.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zze(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean zzd(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzz = zzz();
        if (zzz == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzz.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzz.getBoolean(str));
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final boolean zzg(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final int zza(String str, zzem<Integer> zzem, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzem), i2), i);
    }

    public final boolean zza(zzem<Boolean> zzem) {
        return zzd((String) null, zzem);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(com.google.android.gms.measurement.internal.zzg r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.zze()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0033
            boolean r1 = com.google.android.gms.internal.measurement.zzle.zzb()
            if (r1 == 0) goto L_0x002f
            com.google.android.gms.measurement.internal.zzaa r1 = r5.zzt()
            java.lang.String r2 = r6.zzc()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzbo
            boolean r1 = r1.zzd(r2, r3)
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r6.zzg()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0033
        L_0x002f:
            java.lang.String r1 = r6.zzf()
        L_0x0033:
            com.google.android.gms.measurement.internal.zzem<java.lang.String> r2 = com.google.android.gms.measurement.internal.zzas.zzd
            r3 = 0
            java.lang.Object r2 = r2.zza(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.zzem<java.lang.String> r4 = com.google.android.gms.measurement.internal.zzas.zze
            java.lang.Object r3 = r4.zza(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L_0x005d
            java.lang.String r1 = r3.concat(r1)
            goto L_0x0062
        L_0x005d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L_0x0062:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.zzd()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            long r1 = r5.zzf()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "gmp_version"
            r6.appendQueryParameter(r2, r1)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(com.google.android.gms.measurement.internal.zzg):java.lang.String");
    }

    private final String zza(String str, String str2) {
        Class<String> cls = String.class;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, str2});
        } catch (ClassNotFoundException e) {
            zzr().zzf().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (NoSuchMethodException e2) {
            zzr().zzf().zza("Could not find SystemProperties.get() method", e2);
            return str2;
        } catch (IllegalAccessException e3) {
            zzr().zzf().zza("Could not access SystemProperties.get()", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzr().zzf().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
