package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzin extends zze {
    /* access modifiers changed from: private */
    public final zzjf zza;
    /* access modifiers changed from: private */
    public zzel zzb;
    private volatile Boolean zzc;
    private final zzai zzd;
    private final zzjz zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzai zzg;

    protected zzin(zzfx zzfx) {
        super(zzfx);
        this.zze = new zzjz(zzfx.zzm());
        this.zza = new zzjf(this);
        this.zzd = new zziq(this, zzfx);
        this.zzg = new zzix(this, zzfx);
    }

    private final boolean zzaj() {
        zzu();
        return true;
    }

    /* access modifiers changed from: private */
    public final void zzak() {
        zzd();
        this.zze.zza();
        this.zzd.zza(zzas.zzai.zza(null).longValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzal() {
        /*
            r5 = this;
            r5.zzd()
            r5.zzw()
            java.lang.Boolean r0 = r5.zzc
            if (r0 != 0) goto L_0x0104
            r5.zzd()
            r5.zzw()
            com.google.android.gms.measurement.internal.zzff r0 = r5.zzs()
            java.lang.Boolean r0 = r0.zzj()
            r1 = 1
            if (r0 == 0) goto L_0x0023
            boolean r2 = r0.booleanValue()
            if (r2 == 0) goto L_0x0023
            goto L_0x00fe
        L_0x0023:
            r5.zzu()
            com.google.android.gms.measurement.internal.zzeq r2 = r5.zzg()
            int r2 = r2.zzag()
            r3 = 0
            if (r2 != r1) goto L_0x0034
        L_0x0031:
            r0 = 1
            goto L_0x00da
        L_0x0034:
            com.google.android.gms.measurement.internal.zzet r2 = r5.zzr()
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzx()
            java.lang.String r4 = "Checking service availability"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzko r2 = r5.zzp()
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r2 = r2.zza((int) r4)
            if (r2 == 0) goto L_0x00cb
            if (r2 == r1) goto L_0x00bb
            r4 = 2
            if (r2 == r4) goto L_0x009b
            r0 = 3
            if (r2 == r0) goto L_0x008c
            r0 = 9
            if (r2 == r0) goto L_0x007e
            r0 = 18
            if (r2 == r0) goto L_0x0070
            com.google.android.gms.measurement.internal.zzet r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzi()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "Unexpected service status"
            r0.zza(r2, r1)
            goto L_0x0099
        L_0x0070:
            com.google.android.gms.measurement.internal.zzet r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzi()
            java.lang.String r2 = "Service updating"
            r0.zza(r2)
            goto L_0x0031
        L_0x007e:
            com.google.android.gms.measurement.internal.zzet r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzi()
            java.lang.String r1 = "Service invalid"
            r0.zza(r1)
            goto L_0x0099
        L_0x008c:
            com.google.android.gms.measurement.internal.zzet r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzi()
            java.lang.String r1 = "Service disabled"
            r0.zza(r1)
        L_0x0099:
            r0 = 0
            goto L_0x00c9
        L_0x009b:
            com.google.android.gms.measurement.internal.zzet r2 = r5.zzr()
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzw()
            java.lang.String r4 = "Service container out of date"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzko r2 = r5.zzp()
            int r2 = r2.zzj()
            r4 = 17443(0x4423, float:2.4443E-41)
            if (r2 >= r4) goto L_0x00b5
            goto L_0x00c8
        L_0x00b5:
            if (r0 != 0) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r1 = 0
        L_0x00b9:
            r0 = 0
            goto L_0x00da
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzet r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzx()
            java.lang.String r2 = "Service missing"
            r0.zza(r2)
        L_0x00c8:
            r0 = 1
        L_0x00c9:
            r1 = 0
            goto L_0x00da
        L_0x00cb:
            com.google.android.gms.measurement.internal.zzet r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzx()
            java.lang.String r2 = "Service available"
            r0.zza(r2)
            goto L_0x0031
        L_0x00da:
            if (r1 != 0) goto L_0x00f4
            com.google.android.gms.measurement.internal.zzaa r2 = r5.zzt()
            boolean r2 = r2.zzy()
            if (r2 == 0) goto L_0x00f4
            com.google.android.gms.measurement.internal.zzet r0 = r5.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()
            java.lang.String r2 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r2)
            goto L_0x00f5
        L_0x00f4:
            r3 = r0
        L_0x00f5:
            if (r3 == 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzff r0 = r5.zzs()
            r0.zza((boolean) r1)
        L_0x00fe:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r5.zzc = r0
        L_0x0104:
            java.lang.Boolean r0 = r5.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzin.zzal():boolean");
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        zzd();
        if (zzab()) {
            zzr().zzx().zza("Inactivity, disconnecting from the service");
            zzah();
        }
    }

    /* access modifiers changed from: private */
    public final void zzan() {
        zzd();
        zzr().zzx().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (Exception e) {
                zzr().zzf().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzel zzel, AbstractSafeParcelable abstractSafeParcelable, zzm zzm) {
        int i;
        List<AbstractSafeParcelable> zza2;
        zzd();
        zzb();
        zzw();
        boolean zzaj = zzaj();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zzaj || (zza2 = zzj().zza(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(zza2);
                i = zza2.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzaq) {
                    try {
                        zzel.zza((zzaq) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e) {
                        zzr().zzf().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkn) {
                    try {
                        zzel.zza((zzkn) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e2) {
                        zzr().zzf().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzy) {
                    try {
                        zzel.zza((zzy) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e3) {
                        zzr().zzf().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzr().zzf().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    public final boolean zzab() {
        zzd();
        zzw();
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    public final void zzac() {
        zzd();
        zzw();
        zza((Runnable) new zzja(this, zza(true)));
    }

    /* access modifiers changed from: protected */
    public final void zzad() {
        zzd();
        zzb();
        zzw();
        zzm zza2 = zza(false);
        if (zzaj()) {
            zzj().zzab();
        }
        zza((Runnable) new zzir(this, zza2));
    }

    /* access modifiers changed from: protected */
    public final void zzae() {
        zzd();
        zzw();
        zzm zza2 = zza(true);
        zzj().zzac();
        zza((Runnable) new zziw(this, zza2));
    }

    /* access modifiers changed from: package-private */
    public final void zzaf() {
        zzd();
        zzw();
        if (!zzab()) {
            if (zzal()) {
                this.zza.zzb();
            } else if (!zzt().zzy()) {
                zzu();
                List<ResolveInfo> queryIntentServices = zzn().getPackageManager().queryIntentServices(new Intent().setClassName(zzn(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context zzn = zzn();
                    zzu();
                    intent.setComponent(new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent);
                    return;
                }
                zzr().zzf().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzag() {
        return this.zzc;
    }

    public final void zzah() {
        zzd();
        zzw();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzn(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzai() {
        zzd();
        zzw();
        if (zzal() && zzp().zzj() < 200900) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
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

    /* access modifiers changed from: protected */
    public final void zza(zzaq zzaq, String str) {
        Preconditions.checkNotNull(zzaq);
        zzd();
        zzw();
        boolean zzaj = zzaj();
        zza((Runnable) new zziz(this, zzaj, zzaj && zzj().zza(zzaq), zzaq, zza(true), str));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzy zzy) {
        Preconditions.checkNotNull(zzy);
        zzd();
        zzw();
        zzu();
        zza((Runnable) new zzjc(this, true, zzj().zza(zzy), new zzy(zzy), zza(true), zzy));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzy>> atomicReference, String str, String str2, String str3) {
        zzd();
        zzw();
        zza((Runnable) new zzjb(this, atomicReference, str, str2, str3, zza(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzs zzs, String str, String str2) {
        zzd();
        zzw();
        zza((Runnable) new zzje(this, str, str2, zza(false), zzs));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkn>> atomicReference, String str, String str2, String str3, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzjd(this, atomicReference, str, str2, str3, z, zza(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzs zzs, String str, String str2, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzjg(this, str, str2, z, zza(false), zzs));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzkn zzkn) {
        zzd();
        zzw();
        zza((Runnable) new zzip(this, zzaj() && zzj().zza(zzkn), zzkn, zza(true)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkn>> atomicReference, boolean z) {
        zzd();
        zzw();
        zza((Runnable) new zzis(this, atomicReference, zza(false), z));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzd();
        zzw();
        zza((Runnable) new zziu(this, atomicReference, zza(false)));
    }

    public final void zza(zzs zzs) {
        zzd();
        zzw();
        zza((Runnable) new zzit(this, zza(false), zzs));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzii zzii) {
        zzd();
        zzw();
        zza((Runnable) new zziv(this, zzii));
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(zzel zzel) {
        zzd();
        Preconditions.checkNotNull(zzel);
        this.zzb = zzel;
        zzak();
        zzan();
    }

    /* access modifiers changed from: private */
    public final void zza(ComponentName componentName) {
        zzd();
        if (this.zzb != null) {
            this.zzb = null;
            zzr().zzx().zza("Disconnected from device MeasurementService", componentName);
            zzd();
            zzaf();
        }
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzd();
        if (zzab()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzr().zzf().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(60000);
            zzaf();
        }
    }

    private final zzm zza(boolean z) {
        zzu();
        return zzg().zza(z ? zzr().zzy() : null);
    }

    public final void zza(zzs zzs, zzaq zzaq, String str) {
        zzd();
        zzw();
        if (zzp().zza((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzr().zzi().zza("Not bundling data. Service unavailable or out of date");
            zzp().zza(zzs, new byte[0]);
            return;
        }
        zza((Runnable) new zziy(this, zzaq, str, zzs));
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
