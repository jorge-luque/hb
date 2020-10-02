package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzsv;
import com.google.android.gms.internal.ads.zztf;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.1.0 */
public final class zzcnf {
    private zzazz zzdls;
    private zzcmp zzgdu;
    private zzst zzgeg;
    private Context zzvf;

    public zzcnf(Context context, zzazz zzazz, zzst zzst, zzcmp zzcmp) {
        this.zzvf = context;
        this.zzdls = zzazz;
        this.zzgeg = zzst;
        this.zzgdu = zzcmp;
    }

    public final void zzapc() {
        try {
            this.zzgdu.zza(new zzcne(this));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzazw.zzfa(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzb(SQLiteDatabase sQLiteDatabase) throws Exception {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        ArrayList<zztf.zzo.zza> zza = zzcnc.zza(sQLiteDatabase);
        zztf.zzo zzo = (zztf.zzo) ((zzecd) zztf.zzo.zzoi().zzcc(this.zzvf.getPackageName()).zzcd(Build.MODEL).zzcg(zzcnc.zza(sQLiteDatabase2, 0)).zze(zza).zzch(zzcnc.zza(sQLiteDatabase2, 1)).zzes(zzq.zzld().currentTimeMillis()).zzet(zzcnc.zzb(sQLiteDatabase2, 2)).zzbet());
        int size = zza.size();
        long j = 0;
        int i = 0;
        while (i < size) {
            zztf.zzo.zza zza2 = zza.get(i);
            i++;
            zztf.zzo.zza zza3 = zza2;
            if (zza3.zzok() == zztp.ENUM_TRUE && zza3.getTimestamp() > j) {
                j = zza3.getTimestamp();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, Long.valueOf(j));
            sQLiteDatabase2.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
        }
        this.zzgeg.zza((zzsw) new zzcnh(zzo));
        this.zzgeg.zza((zzsw) new zzcng((zztf.zzu) ((zzecd) zztf.zzu.zzos().zzcn(this.zzdls.zzdzn).zzco(this.zzdls.zzdzo).zzcp(this.zzdls.zzdzp ? 0 : 2).zzbet())));
        this.zzgeg.zza(zzsv.zza.C6839zza.OFFLINE_UPLOAD);
        sQLiteDatabase2.delete("offline_signal_contents", (String) null, (String[]) null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0);
        sQLiteDatabase2.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0);
        sQLiteDatabase2.update("offline_signal_statistics", contentValues3, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
