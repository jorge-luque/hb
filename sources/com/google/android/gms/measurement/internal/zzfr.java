package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzjt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p075d.p080b.C3191a;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
public final class zzfr extends zzkd implements zzac {
    @VisibleForTesting
    private static int zzb = 65535;
    @VisibleForTesting
    private static int zzc = 2;
    private final Map<String, Map<String, String>> zzd = new C3191a();
    private final Map<String, Map<String, Boolean>> zze = new C3191a();
    private final Map<String, Map<String, Boolean>> zzf = new C3191a();
    private final Map<String, zzbt.zzb> zzg = new C3191a();
    private final Map<String, Map<String, Integer>> zzh = new C3191a();
    private final Map<String, String> zzi = new C3191a();

    zzfr(zzkg zzkg) {
        super(zzkg);
    }

    private final void zzi(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] zzd2 = zzi().zzd(str);
            if (zzd2 == null) {
                this.zzd.put(str, (Object) null);
                this.zze.put(str, (Object) null);
                this.zzf.put(str, (Object) null);
                this.zzg.put(str, (Object) null);
                this.zzi.put(str, (Object) null);
                this.zzh.put(str, (Object) null);
                return;
            }
            zzbt.zzb.zza zza = (zzbt.zzb.zza) zza(str, zzd2).zzbm();
            zza(str, zza);
            this.zzd.put(str, zza((zzbt.zzb) ((zzfi) zza.zzu())));
            this.zzg.put(str, (zzbt.zzb) ((zzfi) zza.zzu()));
            this.zzi.put(str, (Object) null);
        }
    }

    /* renamed from: e_ */
    public final /* bridge */ /* synthetic */ zzq mo26444e_() {
        return super.mo26444e_();
    }

    /* access modifiers changed from: protected */
    public final zzbt.zzb zza(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    /* access modifiers changed from: protected */
    public final String zzb(String str) {
        zzd();
        return this.zzi.get(str);
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str) {
        zzd();
        this.zzi.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zzd();
        this.zzg.remove(str);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(String str) {
        zzd();
        zzbt.zzb zza = zza(str);
        if (zza == null) {
            return false;
        }
        return zza.zzh();
    }

    /* access modifiers changed from: package-private */
    public final long zzf(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e) {
            zzr().zzi().zza("Unable to parse timezone offset. appId", zzet.zza(str), e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ zzfr zzj() {
        return super.zzj();
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

    public final /* bridge */ /* synthetic */ zzkk zzg() {
        return super.zzg();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str, String str2) {
        Boolean bool;
        zzd();
        zzi(str);
        if (zzg(str) && zzko.zze(str2)) {
            return true;
        }
        if (zzh(str) && zzko.zza(str2)) {
            return true;
        }
        Map map = this.zze.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(String str, String str2) {
        Boolean bool;
        zzd();
        zzi(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        if (zzjt.zzb() && zzt().zza(zzas.zzcj) && ("purchase".equals(str2) || "refund".equals(str2))) {
            return true;
        }
        Map map = this.zzf.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final int zzd(String str, String str2) {
        Integer num;
        zzd();
        zzi(str);
        Map map = this.zzh.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final String zza(String str, String str2) {
        zzd();
        zzi(str);
        Map map = this.zzd.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    private static Map<String, String> zza(zzbt.zzb zzb2) {
        C3191a aVar = new C3191a();
        if (zzb2 != null) {
            for (zzbt.zzc next : zzb2.zze()) {
                aVar.put(next.zza(), next.zzb());
            }
        }
        return aVar;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    private final void zza(String str, zzbt.zzb.zza zza) {
        C3191a aVar = new C3191a();
        C3191a aVar2 = new C3191a();
        C3191a aVar3 = new C3191a();
        if (zza != null) {
            for (int i = 0; i < zza.zza(); i++) {
                zzbt.zza.C6845zza zza2 = (zzbt.zza.C6845zza) zza.zza(i).zzbm();
                if (TextUtils.isEmpty(zza2.zza())) {
                    zzr().zzi().zza("EventConfig contained null event name");
                } else {
                    String zzb2 = zzgw.zzb(zza2.zza());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zza2 = zza2.zza(zzb2);
                        zza.zza(i, zza2);
                    }
                    aVar.put(zza2.zza(), Boolean.valueOf(zza2.zzb()));
                    aVar2.put(zza2.zza(), Boolean.valueOf(zza2.zzc()));
                    if (zza2.zzd()) {
                        if (zza2.zze() < zzc || zza2.zze() > zzb) {
                            zzr().zzi().zza("Invalid sampling rate. Event name, sample rate", zza2.zza(), Integer.valueOf(zza2.zze()));
                        } else {
                            aVar3.put(zza2.zza(), Integer.valueOf(zza2.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, aVar);
        this.zzf.put(str, aVar2);
        this.zzh.put(str, aVar3);
    }

    public final /* bridge */ /* synthetic */ zzab zzi() {
        return super.zzi();
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, byte[] bArr, String str2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzbt.zzb.zza zza = (zzbt.zzb.zza) zza(str, bArr).zzbm();
        if (zza == null) {
            return false;
        }
        zza(str, zza);
        this.zzg.put(str, (zzbt.zzb) ((zzfi) zza.zzu()));
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((zzbt.zzb) ((zzfi) zza.zzu())));
        zzi().zza(str, (List<zzbo.zza>) new ArrayList(zza.zzb()));
        try {
            zza.zzc();
            bArr = ((zzbt.zzb) ((zzfi) zza.zzu())).zzbi();
        } catch (RuntimeException e) {
            zzr().zzi().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzet.zza(str), e);
        }
        zzab zzi2 = zzi();
        Preconditions.checkNotEmpty(str);
        zzi2.zzd();
        zzi2.zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzi2.mo26274c_().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzi2.zzr().zzf().zza("Failed to update remote config (got 0). appId", zzet.zza(str));
            }
        } catch (SQLiteException e2) {
            zzi2.zzr().zzf().zza("Error storing remote config. appId", zzet.zza(str), e2);
        }
        this.zzg.put(str, (zzbt.zzb) ((zzfi) zza.zzu()));
        return true;
    }

    private final zzbt.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzbt.zzb.zzj();
        }
        try {
            zzbt.zzb zzb2 = (zzbt.zzb) ((zzfi) ((zzbt.zzb.zza) zzkk.zza(zzbt.zzb.zzi(), bArr)).zzu());
            zzev zzx = zzr().zzx();
            String str2 = null;
            Long valueOf = zzb2.zza() ? Long.valueOf(zzb2.zzb()) : null;
            if (zzb2.zzc()) {
                str2 = zzb2.zzd();
            }
            zzx.zza("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzb2;
        } catch (zzft e) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzet.zza(str), e);
            return zzbt.zzb.zzj();
        } catch (RuntimeException e2) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzet.zza(str), e2);
            return zzbt.zzb.zzj();
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
