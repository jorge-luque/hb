package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzks;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import p075d.p080b.C3191a;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzhc extends zze {
    @VisibleForTesting
    protected zzhx zza;
    final zzn zzb;
    @VisibleForTesting
    protected boolean zzc = true;
    private zzgx zzd;
    private final Set<zzha> zze = new CopyOnWriteArraySet();
    private boolean zzf;
    private final AtomicReference<String> zzg = new AtomicReference<>();

    protected zzhc(zzfx zzfx) {
        super(zzfx);
        this.zzb = new zzn(zzfx);
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        zzd();
        String zza2 = zzs().zzn.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zza(TapjoyConstants.TJC_APP_PLACEMENT, "_npa", (Object) null, zzm().currentTimeMillis());
            } else {
                zza(TapjoyConstants.TJC_APP_PLACEMENT, "_npa", (Object) Long.valueOf("true".equals(zza2) ? 1 : 0), zzm().currentTimeMillis());
            }
        }
        if (!this.zzz.zzab() || !this.zzc) {
            zzr().zzw().zza("Updating Scion state (FE)");
            zzh().zzac();
            return;
        }
        zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzai();
        if (zzks.zzb() && zzt().zza(zzas.zzbw)) {
            zzk().zza.zza();
        }
        if (zzkl.zzb() && zzt().zza(zzas.zzcb)) {
            if (!(this.zzz.zzf().zza.zzc().zzi.zza() > 0)) {
                zzfo zzf2 = this.zzz.zzf();
                zzf2.zza.zzad();
                zzf2.zza(zzf2.zza.zzn().getPackageName());
            }
        }
        if (zzt().zza(zzas.zzcp)) {
            zzq().zza((Runnable) new zzhv(this));
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        zzr().zzi().zza("Interrupted waiting for app instance id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zze(long r4) {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            monitor-enter(r0)
            com.google.android.gms.measurement.internal.zzfu r1 = r3.zzq()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzhk r2 = new com.google.android.gms.measurement.internal.zzhk     // Catch:{ all -> 0x002d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x002d }
            r1.zza((java.lang.Runnable) r2)     // Catch:{ all -> 0x002d }
            r0.wait(r4)     // Catch:{ InterruptedException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            java.lang.Object r4 = r0.get()
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L_0x001d:
            com.google.android.gms.measurement.internal.zzet r4 = r3.zzr()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzi()     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "Interrupted waiting for app instance id"
            r4.zza(r5)     // Catch:{ all -> 0x002d }
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhc.zze(long):java.lang.String");
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza((Runnable) new zzht(this, z));
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000, "boolean test flag value", new zzhd(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000, "String test flag value", new zzhn(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000, "long test flag value", new zzhs(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000, "int test flag value", new zzhr(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000, "double test flag value", new zzhu(this, atomicReference));
    }

    public final String zzah() {
        zzb();
        return this.zzg.get();
    }

    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzz.zzag()) {
            if (zzt().zza(zzas.zzbh)) {
                zzaa zzt = zzt();
                zzt.zzu();
                Boolean zzd2 = zzt.zzd("google_analytics_deferred_deep_link_enabled");
                if (zzd2 != null && zzd2.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza((Runnable) new zzhe(this));
                }
            }
            zzh().zzae();
            this.zzc = false;
            String zzw = zzs().zzw();
            if (!TextUtils.isEmpty(zzw)) {
                zzl().zzaa();
                if (!zzw.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzw);
                    zza("auto", "_ou", bundle);
                }
            }
        }
    }

    public final String zzaj() {
        zzii zzab = this.zzz.zzv().zzab();
        if (zzab != null) {
            return zzab.zza;
        }
        return null;
    }

    public final String zzak() {
        zzii zzab = this.zzz.zzv().zzab();
        if (zzab != null) {
            return zzab.zzb;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzz.zzo() != null) {
            return this.zzz.zzo();
        }
        try {
            return new StringResourceValueReader(zzn()).getString("google_app_id");
        } catch (IllegalStateException e) {
            this.zzz.zzr().zzf().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final void zzb(boolean z) {
        zzw();
        zzb();
        zzq().zza((Runnable) new zzhw(this, z));
    }

    public final List<zzkn> zzc(boolean z) {
        zzb();
        zzw();
        zzr().zzx().zza("Getting user properties (FE)");
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzv.zza()) {
            zzr().zzf().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzz.zzq().zza(atomicReference, 5000, "get user properties", new zzhh(this, atomicReference, z));
            List<zzkn> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzr().zzf().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final /* bridge */ /* synthetic */ zzhc zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzeq zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzin zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzih zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzep zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzjs zzk() {
        return super.zzk();
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

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    public final void zza(long j) {
        zzb();
        zzq().zza((Runnable) new zzhy(this, j));
    }

    public final void zzb(long j) {
        zzb();
        zzq().zza((Runnable) new zzhg(this, j));
    }

    public final void zzd(long j) {
        zza((String) null);
        zzq().zza((Runnable) new zzhj(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, false, true, zzm().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    /* access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        if (!this.zzz.zzab()) {
            zzr().zzx().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkn zzkn = new zzkn(bundle2.getString("name"), 0, (Object) null, (String) null);
        try {
            zzaq zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false);
            zzkn zzkn2 = zzkn;
            zzh().zza(new zzy(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN), zzkn2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzaq) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzaq) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza2));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzd == null || zzko.zze(str2), false, (String) null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzq().zza((Runnable) new zzhf(this, str, str2, j, zzko.zzb(bundle), z, z2, z3, str3));
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03fc  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0538  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x05b9  */
    /* JADX WARNING: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r26, java.lang.String r27, long r28, android.os.Bundle r30, boolean r31, boolean r32, boolean r33, java.lang.String r34) {
        /*
            r25 = this;
            r7 = r25
            r8 = r26
            r15 = r27
            r13 = r28
            r12 = r30
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r30)
            r25.zzd()
            r25.zzw()
            com.google.android.gms.measurement.internal.zzfx r0 = r7.zzz
            boolean r0 = r0.zzab()
            if (r0 != 0) goto L_0x002c
            com.google.android.gms.measurement.internal.zzet r0 = r25.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzw()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        L_0x002c:
            com.google.android.gms.measurement.internal.zzaa r0 = r25.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzbc
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x0056
            com.google.android.gms.measurement.internal.zzeq r0 = r25.zzg()
            java.util.List r0 = r0.zzah()
            if (r0 == 0) goto L_0x0056
            boolean r0 = r0.contains(r15)
            if (r0 != 0) goto L_0x0056
            com.google.android.gms.measurement.internal.zzet r0 = r25.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzw()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zza(r1, r15, r8)
            return
        L_0x0056:
            boolean r0 = r7.zzf
            r11 = 0
            r10 = 0
            r9 = 1
            if (r0 != 0) goto L_0x00b0
            r7.zzf = r9
            com.google.android.gms.measurement.internal.zzfx r0 = r7.zzz     // Catch:{ ClassNotFoundException -> 0x00a3 }
            boolean r0 = r0.zzt()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            android.content.Context r1 = r25.zzn()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            java.lang.Class r0 = java.lang.Class.forName(r0, r9, r1)     // Catch:{ ClassNotFoundException -> 0x00a3 }
            goto L_0x007c
        L_0x0076:
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x00a3 }
        L_0x007c:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x0094 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r10] = r3     // Catch:{ Exception -> 0x0094 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0094 }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0094 }
            android.content.Context r2 = r25.zzn()     // Catch:{ Exception -> 0x0094 }
            r1[r10] = r2     // Catch:{ Exception -> 0x0094 }
            r0.invoke(r11, r1)     // Catch:{ Exception -> 0x0094 }
            goto L_0x00b0
        L_0x0094:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzet r1 = r25.zzr()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzi()     // Catch:{ ClassNotFoundException -> 0x00a3 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zza(r2, r0)     // Catch:{ ClassNotFoundException -> 0x00a3 }
            goto L_0x00b0
        L_0x00a3:
            com.google.android.gms.measurement.internal.zzet r0 = r25.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzv()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00b0:
            com.google.android.gms.measurement.internal.zzaa r0 = r25.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzbi
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x00e1
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x00e1
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00e1
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.common.util.Clock r0 = r25.zzm()
            long r5 = r0.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r25
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
        L_0x00e1:
            boolean r0 = com.google.android.gms.internal.measurement.zzlj.zzb()
            if (r0 == 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzaa r0 = r25.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzcn
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x0134
            r25.zzu()
            if (r31 == 0) goto L_0x0134
            boolean r0 = com.google.android.gms.measurement.internal.zzko.zzg(r27)
            if (r0 == 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzko r0 = r25.zzp()
            com.google.android.gms.measurement.internal.zzff r1 = r25.zzs()
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzy
            android.os.Bundle r1 = r1.zza()
            if (r1 == 0) goto L_0x0134
            java.util.Set r2 = r1.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0116:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0134
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = r12.containsKey(r3)
            if (r4 != 0) goto L_0x0116
            com.google.android.gms.measurement.internal.zzko r4 = r0.zzp()
            java.lang.Object r5 = r1.get(r3)
            r4.zza((android.os.Bundle) r12, (java.lang.String) r3, (java.lang.Object) r5)
            goto L_0x0116
        L_0x0134:
            r0 = 40
            r1 = 2
            if (r33 == 0) goto L_0x0199
            r25.zzu()
            java.lang.String r2 = "_iap"
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x0199
            com.google.android.gms.measurement.internal.zzfx r2 = r7.zzz
            com.google.android.gms.measurement.internal.zzko r2 = r2.zzi()
            java.lang.String r3 = "event"
            boolean r4 = r2.zza((java.lang.String) r3, (java.lang.String) r15)
            if (r4 != 0) goto L_0x0154
        L_0x0152:
            r2 = 2
            goto L_0x0167
        L_0x0154:
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzgw.zza
            boolean r4 = r2.zza((java.lang.String) r3, (java.lang.String[]) r4, (java.lang.String) r15)
            if (r4 != 0) goto L_0x015f
            r2 = 13
            goto L_0x0167
        L_0x015f:
            boolean r2 = r2.zza((java.lang.String) r3, (int) r0, (java.lang.String) r15)
            if (r2 != 0) goto L_0x0166
            goto L_0x0152
        L_0x0166:
            r2 = 0
        L_0x0167:
            if (r2 == 0) goto L_0x0199
            com.google.android.gms.measurement.internal.zzet r1 = r25.zzr()
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzer r3 = r25.zzo()
            java.lang.String r3 = r3.zza((java.lang.String) r15)
            java.lang.String r4 = "Invalid public event name. Event will not be logged (FE)"
            r1.zza(r4, r3)
            com.google.android.gms.measurement.internal.zzfx r1 = r7.zzz
            r1.zzi()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x018d
            int r10 = r27.length()
        L_0x018d:
            com.google.android.gms.measurement.internal.zzfx r1 = r7.zzz
            com.google.android.gms.measurement.internal.zzko r1 = r1.zzi()
            java.lang.String r3 = "_ev"
            r1.zza((int) r2, (java.lang.String) r3, (java.lang.String) r0, (int) r10)
            return
        L_0x0199:
            r25.zzu()
            com.google.android.gms.measurement.internal.zzih r2 = r25.zzi()
            com.google.android.gms.measurement.internal.zzii r2 = r2.zza((boolean) r10)
            java.lang.String r3 = "_sc"
            if (r2 == 0) goto L_0x01b0
            boolean r4 = r12.containsKey(r3)
            if (r4 != 0) goto L_0x01b0
            r2.zzd = r9
        L_0x01b0:
            if (r31 == 0) goto L_0x01b6
            if (r33 == 0) goto L_0x01b6
            r4 = 1
            goto L_0x01b7
        L_0x01b6:
            r4 = 0
        L_0x01b7:
            com.google.android.gms.measurement.internal.zzih.zza((com.google.android.gms.measurement.internal.zzii) r2, (android.os.Bundle) r12, (boolean) r4)
            java.lang.String r4 = "am"
            boolean r16 = r4.equals(r8)
            boolean r4 = com.google.android.gms.measurement.internal.zzko.zze(r27)
            if (r31 == 0) goto L_0x01f9
            com.google.android.gms.measurement.internal.zzgx r5 = r7.zzd
            if (r5 == 0) goto L_0x01f9
            if (r4 != 0) goto L_0x01f9
            if (r16 != 0) goto L_0x01f9
            com.google.android.gms.measurement.internal.zzet r0 = r25.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzw()
            com.google.android.gms.measurement.internal.zzer r1 = r25.zzo()
            java.lang.String r1 = r1.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzer r2 = r25.zzo()
            java.lang.String r2 = r2.zza((android.os.Bundle) r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzgx r1 = r7.zzd
            r2 = r26
            r3 = r27
            r4 = r30
            r5 = r28
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01f9:
            com.google.android.gms.measurement.internal.zzfx r4 = r7.zzz
            boolean r4 = r4.zzag()
            if (r4 != 0) goto L_0x0202
            return
        L_0x0202:
            com.google.android.gms.measurement.internal.zzko r4 = r25.zzp()
            int r4 = r4.zzb((java.lang.String) r15)
            if (r4 == 0) goto L_0x0246
            com.google.android.gms.measurement.internal.zzet r1 = r25.zzr()
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzh()
            com.google.android.gms.measurement.internal.zzer r2 = r25.zzo()
            java.lang.String r2 = r2.zza((java.lang.String) r15)
            java.lang.String r3 = "Invalid event name. Event will not be logged (FE)"
            r1.zza(r3, r2)
            r25.zzp()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzko.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x022e
            int r10 = r27.length()
        L_0x022e:
            com.google.android.gms.measurement.internal.zzfx r1 = r7.zzz
            com.google.android.gms.measurement.internal.zzko r1 = r1.zzi()
            java.lang.String r2 = "_ev"
            r26 = r1
            r27 = r34
            r28 = r4
            r29 = r2
            r30 = r0
            r31 = r10
            r26.zza((java.lang.String) r27, (int) r28, (java.lang.String) r29, (java.lang.String) r30, (int) r31)
            return
        L_0x0246:
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r5 = "_o"
            r0[r10] = r5
            java.lang.String r4 = "_sn"
            r0[r9] = r4
            r0[r1] = r3
            r1 = 3
            java.lang.String r6 = "_si"
            r0[r1] = r6
            java.util.List r0 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r0)
            com.google.android.gms.measurement.internal.zzko r1 = r25.zzp()
            r17 = 1
            r9 = r1
            r1 = 0
            r10 = r34
            r19 = r11
            r11 = r27
            r12 = r30
            r13 = r0
            r14 = r33
            r15 = r17
            android.os.Bundle r15 = r9.zza((java.lang.String) r10, (java.lang.String) r11, (android.os.Bundle) r12, (java.util.List<java.lang.String>) r13, (boolean) r14, (boolean) r15)
            if (r15 == 0) goto L_0x029e
            boolean r9 = r15.containsKey(r3)
            if (r9 == 0) goto L_0x029e
            boolean r9 = r15.containsKey(r6)
            if (r9 != 0) goto L_0x0284
            goto L_0x029e
        L_0x0284:
            java.lang.String r4 = r15.getString(r4)
            java.lang.String r3 = r15.getString(r3)
            long r9 = r15.getLong(r6)
            java.lang.Long r6 = java.lang.Long.valueOf(r9)
            com.google.android.gms.measurement.internal.zzii r11 = new com.google.android.gms.measurement.internal.zzii
            long r9 = r6.longValue()
            r11.<init>(r4, r3, r9)
            goto L_0x02a0
        L_0x029e:
            r11 = r19
        L_0x02a0:
            if (r11 != 0) goto L_0x02a4
            r14 = r2
            goto L_0x02a5
        L_0x02a4:
            r14 = r11
        L_0x02a5:
            com.google.android.gms.measurement.internal.zzaa r2 = r25.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzat
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            java.lang.String r13 = "_ae"
            r9 = 0
            if (r2 == 0) goto L_0x02e0
            r25.zzu()
            com.google.android.gms.measurement.internal.zzih r2 = r25.zzi()
            com.google.android.gms.measurement.internal.zzii r2 = r2.zza((boolean) r1)
            if (r2 == 0) goto L_0x02e0
            r12 = r27
            boolean r2 = r13.equals(r12)
            if (r2 == 0) goto L_0x02e2
            com.google.android.gms.measurement.internal.zzjs r2 = r25.zzk()
            com.google.android.gms.measurement.internal.zzjy r2 = r2.zzb
            long r2 = r2.zzb()
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x02e2
            com.google.android.gms.measurement.internal.zzko r4 = r25.zzp()
            r4.zza((android.os.Bundle) r15, (long) r2)
            goto L_0x02e2
        L_0x02e0:
            r12 = r27
        L_0x02e2:
            boolean r2 = com.google.android.gms.internal.measurement.zzka.zzb()
            if (r2 == 0) goto L_0x0364
            com.google.android.gms.measurement.internal.zzaa r2 = r25.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzbv
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x0364
            java.lang.String r2 = "auto"
            boolean r2 = r2.equals(r8)
            java.lang.String r3 = "_ffr"
            if (r2 != 0) goto L_0x0347
            java.lang.String r2 = "_ssr"
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x0347
            com.google.android.gms.measurement.internal.zzko r2 = r25.zzp()
            java.lang.String r3 = r15.getString(r3)
            boolean r4 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r3)
            if (r4 == 0) goto L_0x0317
            r11 = r19
            goto L_0x031b
        L_0x0317:
            java.lang.String r11 = r3.trim()
        L_0x031b:
            com.google.android.gms.measurement.internal.zzff r3 = r2.zzs()
            com.google.android.gms.measurement.internal.zzfl r3 = r3.zzv
            java.lang.String r3 = r3.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzko.zzc((java.lang.String) r11, (java.lang.String) r3)
            if (r3 == 0) goto L_0x033a
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzw()
            java.lang.String r3 = "Not logging duplicate session_start_with_rollout event"
            r2.zza(r3)
            r2 = 0
            goto L_0x0344
        L_0x033a:
            com.google.android.gms.measurement.internal.zzff r2 = r2.zzs()
            com.google.android.gms.measurement.internal.zzfl r2 = r2.zzv
            r2.zza(r11)
            r2 = 1
        L_0x0344:
            if (r2 != 0) goto L_0x0364
            return
        L_0x0347:
            boolean r2 = r13.equals(r12)
            if (r2 == 0) goto L_0x0364
            com.google.android.gms.measurement.internal.zzko r2 = r25.zzp()
            com.google.android.gms.measurement.internal.zzff r2 = r2.zzs()
            com.google.android.gms.measurement.internal.zzfl r2 = r2.zzv
            java.lang.String r2 = r2.zza()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x0364
            r15.putString(r3, r2)
        L_0x0364:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r11.add(r15)
            com.google.android.gms.measurement.internal.zzko r2 = r25.zzp()
            java.security.SecureRandom r2 = r2.zzh()
            long r3 = r2.nextLong()
            com.google.android.gms.measurement.internal.zzff r2 = r25.zzs()
            com.google.android.gms.measurement.internal.zzfj r2 = r2.zzq
            long r19 = r2.zza()
            int r2 = (r19 > r9 ? 1 : (r19 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x03e9
            com.google.android.gms.measurement.internal.zzff r2 = r25.zzs()
            r9 = r28
            boolean r2 = r2.zza((long) r9)
            if (r2 == 0) goto L_0x03eb
            com.google.android.gms.measurement.internal.zzff r2 = r25.zzs()
            com.google.android.gms.measurement.internal.zzfh r2 = r2.zzs
            boolean r2 = r2.zza()
            if (r2 == 0) goto L_0x03eb
            com.google.android.gms.measurement.internal.zzet r2 = r25.zzr()
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzx()
            java.lang.String r6 = "Current session is expired, remove the session number, ID, and engagement time"
            r2.zza(r6)
            r6 = 0
            com.google.android.gms.common.util.Clock r2 = r25.zzm()
            long r19 = r2.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r17 = "_sid"
            r1 = r25
            r21 = r3
            r3 = r17
            r4 = r6
            r8 = r5
            r5 = r19
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            r4 = 0
            com.google.android.gms.common.util.Clock r1 = r25.zzm()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r25
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            com.google.android.gms.common.util.Clock r1 = r25.zzm()
            long r5 = r1.currentTimeMillis()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r25
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            goto L_0x03ee
        L_0x03e9:
            r9 = r28
        L_0x03eb:
            r21 = r3
            r8 = r5
        L_0x03ee:
            java.lang.String r1 = "extend_session"
            r2 = 0
            long r1 = r15.getLong(r1, r2)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0416
            com.google.android.gms.measurement.internal.zzet r1 = r25.zzr()
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzx()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfx r1 = r7.zzz
            com.google.android.gms.measurement.internal.zzjs r1 = r1.zze()
            com.google.android.gms.measurement.internal.zzka r1 = r1.zza
            r5 = 1
            r1.zza(r9, r5)
            goto L_0x0417
        L_0x0416:
            r5 = 1
        L_0x0417:
            java.util.Set r1 = r15.keySet()
            int r2 = r15.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            boolean r2 = com.google.android.gms.internal.measurement.zzjt.zzb()
            if (r2 == 0) goto L_0x046a
            com.google.android.gms.measurement.internal.zzaa r2 = r25.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzch
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x046a
            com.google.android.gms.measurement.internal.zzaa r2 = r25.zzt()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzcg
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x046a
            int r0 = r1.length
            r2 = 0
        L_0x044a:
            if (r2 >= r0) goto L_0x0461
            r3 = r1[r2]
            r25.zzp()
            java.lang.Object r4 = r15.get(r3)
            android.os.Bundle[] r4 = com.google.android.gms.measurement.internal.zzko.zzb((java.lang.Object) r4)
            if (r4 == 0) goto L_0x045e
            r15.putParcelableArray(r3, r4)
        L_0x045e:
            int r2 = r2 + 1
            goto L_0x044a
        L_0x0461:
            r31 = r8
            r10 = r11
            r11 = r12
            r8 = r13
            r19 = 1
            goto L_0x0531
        L_0x046a:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x046d:
            java.lang.String r6 = "_eid"
            if (r3 >= r2) goto L_0x051d
            r5 = r1[r3]
            java.lang.Object r17 = r15.get(r5)
            r25.zzp()
            r30 = r1
            android.os.Bundle[] r1 = com.google.android.gms.measurement.internal.zzko.zzb((java.lang.Object) r17)
            if (r1 == 0) goto L_0x04f6
            r17 = r2
            int r2 = r1.length
            r15.putInt(r5, r2)
            r31 = r8
            r2 = 0
        L_0x048b:
            int r8 = r1.length
            if (r2 >= r8) goto L_0x04e7
            r8 = r1[r2]
            r19 = r15
            r15 = 1
            com.google.android.gms.measurement.internal.zzih.zza((com.google.android.gms.measurement.internal.zzii) r14, (android.os.Bundle) r8, (boolean) r15)
            com.google.android.gms.measurement.internal.zzko r18 = r25.zzp()
            r20 = 0
            java.lang.String r23 = "_ep"
            r9 = r18
            r10 = r34
            r24 = r11
            r11 = r23
            r12 = r8
            r8 = r13
            r13 = r0
            r18 = r14
            r14 = r33
            r23 = r0
            r0 = r19
            r19 = 1
            r15 = r20
            android.os.Bundle r9 = r9.zza((java.lang.String) r10, (java.lang.String) r11, (android.os.Bundle) r12, (java.util.List<java.lang.String>) r13, (boolean) r14, (boolean) r15)
            java.lang.String r10 = "_en"
            r11 = r27
            r9.putString(r10, r11)
            r12 = r21
            r9.putLong(r6, r12)
            java.lang.String r10 = "_gn"
            r9.putString(r10, r5)
            int r10 = r1.length
            java.lang.String r14 = "_ll"
            r9.putInt(r14, r10)
            java.lang.String r10 = "_i"
            r9.putInt(r10, r2)
            r10 = r24
            r10.add(r9)
            int r2 = r2 + 1
            r15 = r0
            r14 = r18
            r0 = r23
            r13 = r8
            r12 = r11
            r11 = r10
            r9 = r28
            goto L_0x048b
        L_0x04e7:
            r23 = r0
            r10 = r11
            r11 = r12
            r8 = r13
            r18 = r14
            r0 = r15
            r12 = r21
            r19 = 1
            int r1 = r1.length
            int r4 = r4 + r1
            goto L_0x0506
        L_0x04f6:
            r23 = r0
            r17 = r2
            r31 = r8
            r10 = r11
            r11 = r12
            r8 = r13
            r18 = r14
            r0 = r15
            r12 = r21
            r19 = 1
        L_0x0506:
            int r3 = r3 + 1
            r1 = r30
            r15 = r0
            r21 = r12
            r2 = r17
            r14 = r18
            r0 = r23
            r5 = 1
            r13 = r8
            r12 = r11
            r8 = r31
            r11 = r10
            r9 = r28
            goto L_0x046d
        L_0x051d:
            r31 = r8
            r10 = r11
            r11 = r12
            r8 = r13
            r0 = r15
            r12 = r21
            r19 = 1
            if (r4 == 0) goto L_0x0531
            r0.putLong(r6, r12)
            java.lang.String r1 = "_epc"
            r0.putInt(r1, r4)
        L_0x0531:
            r0 = 0
        L_0x0532:
            int r1 = r10.size()
            if (r0 >= r1) goto L_0x05a4
            java.lang.Object r1 = r10.get(r0)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r0 == 0) goto L_0x0542
            r2 = 1
            goto L_0x0543
        L_0x0542:
            r2 = 0
        L_0x0543:
            if (r2 == 0) goto L_0x054c
            java.lang.String r2 = "_ep"
            r9 = r26
            r12 = r31
            goto L_0x0551
        L_0x054c:
            r9 = r26
            r12 = r31
            r2 = r11
        L_0x0551:
            r1.putString(r12, r9)
            if (r32 == 0) goto L_0x055e
            com.google.android.gms.measurement.internal.zzko r3 = r25.zzp()
            android.os.Bundle r1 = r3.zza((android.os.Bundle) r1)
        L_0x055e:
            r13 = r1
            com.google.android.gms.measurement.internal.zzaq r14 = new com.google.android.gms.measurement.internal.zzaq
            com.google.android.gms.measurement.internal.zzal r3 = new com.google.android.gms.measurement.internal.zzal
            r3.<init>(r13)
            r1 = r14
            r4 = r26
            r15 = 1
            r5 = r28
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzin r1 = r25.zzh()
            r5 = r34
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r14, (java.lang.String) r5)
            if (r16 != 0) goto L_0x059d
            java.util.Set<com.google.android.gms.measurement.internal.zzha> r1 = r7.zze
            java.util.Iterator r14 = r1.iterator()
        L_0x0580:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x059d
            java.lang.Object r1 = r14.next()
            com.google.android.gms.measurement.internal.zzha r1 = (com.google.android.gms.measurement.internal.zzha) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r13)
            r2 = r26
            r3 = r27
            r5 = r28
            r1.onEvent(r2, r3, r4, r5)
            r5 = r34
            goto L_0x0580
        L_0x059d:
            int r0 = r0 + 1
            r31 = r12
            r19 = 1
            goto L_0x0532
        L_0x05a4:
            r15 = 1
            r25.zzu()
            com.google.android.gms.measurement.internal.zzih r0 = r25.zzi()
            r1 = 0
            com.google.android.gms.measurement.internal.zzii r0 = r0.zza((boolean) r1)
            if (r0 == 0) goto L_0x05c8
            boolean r0 = r8.equals(r11)
            if (r0 == 0) goto L_0x05c8
            com.google.android.gms.measurement.internal.zzjs r0 = r25.zzk()
            com.google.android.gms.common.util.Clock r1 = r25.zzm()
            long r1 = r1.elapsedRealtime()
            r0.zza(r15, r15, r1)
        L_0x05c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhc.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzb(zzha zzha) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzha);
        if (!this.zze.remove(zzha)) {
            zzr().zzi().zza("OnEventListener had not been registered");
        }
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    public final String zzc(long j) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzv.zza()) {
            zzr().zzf().zza("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzm().elapsedRealtime();
            String zze2 = zze(120000);
            long elapsedRealtime2 = zzm().elapsedRealtime() - elapsedRealtime;
            return (zze2 != null || elapsedRealtime2 >= 120000) ? zze2 : zze(120000 - elapsedRealtime2);
        }
    }

    private final void zzb(Bundle bundle, long j) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        Preconditions.checkNotNull(bundle);
        zzgt.zza(bundle, "app_id", cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.ORIGIN, cls2, null);
        zzgt.zza(bundle, "name", cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.VALUE, Object.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, cls, 0L);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, cls, 0L);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, cls2, null);
        zzgt.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN));
        Preconditions.checkNotNull(bundle.get(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString("name");
        Object obj = bundle.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
        } else if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
        } else {
            Object zzc2 = zzp().zzc(string, obj);
            if (zzc2 == null) {
                zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
                return;
            }
            zzgt.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
                } else {
                    zzq().zza((Runnable) new zzhl(this, bundle));
                }
            } else {
                zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    /* access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN));
        Preconditions.checkNotNull(bundle2.get(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        if (!this.zzz.zzab()) {
            zzr().zzx().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkn zzkn = new zzkn(bundle2.getString("name"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get(AppMeasurementSdk.ConditionalUserProperty.VALUE), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN));
        try {
            zzaq zza2 = zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN), 0, true, false);
            zzh().zza(new zzy(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN), zzkn, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN), 0, true, false), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN), 0, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza((Runnable) new zzho(this, bundle2));
    }

    @VisibleForTesting
    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzv.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzz.zzq().zza(atomicReference, 5000, "get conditional user properties", new zzhq(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzko.zzb((List<zzy>) list);
            }
            zzr().zzf().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzv.zza()) {
            zzr().zzf().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzz.zzq().zza(atomicReference, 5000, "get user properties", new zzhp(this, atomicReference, str, str2, str3, z));
            List<zzkn> list = (List) atomicReference.get();
            if (list == null) {
                zzr().zzf().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            C3191a aVar = new C3191a(list.size());
            for (zzkn zzkn : list) {
                aVar.put(zzkn.zza, zzkn.zza());
            }
            return aVar;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzb();
        zzb(str == null ? TapjoyConstants.TJC_APP_PLACEMENT : str, str2, j, bundle == null ? new Bundle() : bundle, z2, !z2 || this.zzd == null || zzko.zze(str2), !z, (String) null);
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = TapjoyConstants.TJC_APP_PLACEMENT;
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzp().zzc(str2);
        } else {
            zzko zzp = zzp();
            if (zzp.zza("user property", str2)) {
                if (!zzp.zza("user property", zzgy.zza, str2)) {
                    i = 15;
                } else if (zzp.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzp();
            String zza2 = zzko.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzz.zzi().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzp().zzb(str2, obj);
            if (zzb2 != 0) {
                zzp();
                String zza3 = zzko.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzz.zzi().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzp().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzq().zza((Runnable) new zzhi(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzd()
            r8.zzb()
            r8.zzw()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0063
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0053
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0053
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0038
            r4 = r2
            goto L_0x003a
        L_0x0038:
            r4 = 0
        L_0x003a:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzff r0 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfl r0 = r0.zzn
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004e
            java.lang.String r11 = "true"
        L_0x004e:
            r0.zza(r11)
            r6 = r10
            goto L_0x0061
        L_0x0053:
            if (r11 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzff r10 = r8.zzs()
            com.google.android.gms.measurement.internal.zzfl r10 = r10.zzn
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L_0x0061:
            r3 = r1
            goto L_0x0065
        L_0x0063:
            r3 = r10
            r6 = r11
        L_0x0065:
            com.google.android.gms.measurement.internal.zzfx r10 = r8.zzz
            boolean r10 = r10.zzab()
            if (r10 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.zzet r9 = r8.zzr()
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzx()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x007b:
            com.google.android.gms.measurement.internal.zzfx r10 = r8.zzz
            boolean r10 = r10.zzag()
            if (r10 != 0) goto L_0x0084
            return
        L_0x0084:
            com.google.android.gms.measurement.internal.zzkn r10 = new com.google.android.gms.measurement.internal.zzkn
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzin r9 = r8.zzh()
            r9.zza((com.google.android.gms.measurement.internal.zzkn) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhc.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        this.zzg.set(str);
    }

    public final void zza(zzgx zzgx) {
        zzgx zzgx2;
        zzd();
        zzb();
        zzw();
        if (!(zzgx == null || zzgx == (zzgx2 = this.zzd))) {
            Preconditions.checkState(zzgx2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzgx;
    }

    public final void zza(zzha zzha) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzha);
        if (!this.zze.add(zzha)) {
            zzr().zzi().zza("OnEventListener already registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
