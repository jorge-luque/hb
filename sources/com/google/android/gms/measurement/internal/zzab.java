package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p075d.p080b.C3191a;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
final class zzab extends zzkd {
    /* access modifiers changed from: private */
    public static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {TapjoyConstants.TJC_APP_VERSION_NAME, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", TapjoyConstants.TJC_ANDROID_ID, "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzag zzj = new zzag(this, zzn(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzjz zzk = new zzjz(zzm());

    zzab(zzkg zzkg) {
        super(zzkg);
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = mo26274c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @VisibleForTesting
    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = mo26274c_().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: b_ */
    public final void mo26273b_() {
        zzak();
        mo26274c_().setTransactionSuccessful();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: c_ */
    public final SQLiteDatabase mo26274c_() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzr().zzi().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    /* renamed from: d_ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo26275d_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.mo26274c_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x002b
        L_0x0024:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003f
        L_0x0029:
            r2 = move-exception
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.zzet r3 = r6.zzr()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.mo26275d_():java.lang.String");
    }

    public final long zzaa() {
        Cursor cursor = null;
        try {
            cursor = mo26274c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzkp zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzd()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.mo26274c_()     // Catch:{ SQLiteException -> 0x0087, all -> 0x0083 }
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0087, all -> 0x0083 }
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch:{ SQLiteException -> 0x0087, all -> 0x0083 }
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch:{ SQLiteException -> 0x0087, all -> 0x0083 }
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch:{ SQLiteException -> 0x0087, all -> 0x0083 }
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0087, all -> 0x0083 }
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x0087, all -> 0x0083 }
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x0087, all -> 0x0083 }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0087, all -> 0x0083 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x007f, all -> 0x007b }
            if (r0 != 0) goto L_0x0044
            if (r10 == 0) goto L_0x0043
            r10.close()
        L_0x0043:
            return r9
        L_0x0044:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x007f, all -> 0x007b }
            r11 = r18
            java.lang.Object r7 = r11.zza((android.database.Cursor) r10, (int) r2)     // Catch:{ SQLiteException -> 0x0079 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.measurement.internal.zzkp r0 = new com.google.android.gms.measurement.internal.zzkp     // Catch:{ SQLiteException -> 0x0079 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0079 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0079 }
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzet r1 = r18.zzr()     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x0079 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x0079 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0079 }
        L_0x0073:
            if (r10 == 0) goto L_0x0078
            r10.close()
        L_0x0078:
            return r0
        L_0x0079:
            r0 = move-exception
            goto L_0x008b
        L_0x007b:
            r0 = move-exception
            r11 = r18
            goto L_0x00ab
        L_0x007f:
            r0 = move-exception
            r11 = r18
            goto L_0x008b
        L_0x0083:
            r0 = move-exception
            r11 = r18
            goto L_0x00ac
        L_0x0087:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x008b:
            com.google.android.gms.measurement.internal.zzet r1 = r18.zzr()     // Catch:{ all -> 0x00aa }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r19)     // Catch:{ all -> 0x00aa }
            com.google.android.gms.measurement.internal.zzer r4 = r18.zzo()     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = r4.zzc(r8)     // Catch:{ all -> 0x00aa }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x00aa }
            if (r10 == 0) goto L_0x00a9
            r10.close()
        L_0x00a9:
            return r9
        L_0x00aa:
            r0 = move-exception
        L_0x00ab:
            r9 = r10
        L_0x00ac:
            if (r9 == 0) goto L_0x00b1
            r9.close()
        L_0x00b1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzkp");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzy zzd(java.lang.String r33, java.lang.String r34) {
        /*
            r32 = this;
            r7 = r34
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r33)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r34)
            r32.zzd()
            r32.zzak()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r32.mo26274c_()     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r10 = "conditional_properties"
            r0 = 11
            java.lang.String[] r11 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "origin"
            r1 = 0
            r11[r1] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "value"
            r2 = 1
            r11[r2] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "active"
            r3 = 2
            r11[r3] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "trigger_event_name"
            r4 = 3
            r11[r4] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "trigger_timeout"
            r5 = 4
            r11[r5] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "timed_out_event"
            r6 = 5
            r11[r6] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "creation_timestamp"
            r15 = 6
            r11[r15] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "triggered_event"
            r14 = 7
            r11[r14] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "triggered_timestamp"
            r13 = 8
            r11[r13] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "time_to_live"
            r12 = 9
            r11[r12] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "expired_event"
            r6 = 10
            r11[r6] = r0     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            java.lang.String r0 = "app_id=? and name=?"
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            r13[r1] = r33     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            r17 = 0
            r18 = 0
            r19 = 0
            r6 = 9
            r12 = r0
            r0 = 8
            r6 = 7
            r14 = r17
            r0 = 6
            r15 = r18
            r16 = r19
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x012e, all -> 0x012a }
            boolean r10 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0126, all -> 0x0122 }
            if (r10 != 0) goto L_0x007e
            if (r9 == 0) goto L_0x007d
            r9.close()
        L_0x007d:
            return r8
        L_0x007e:
            java.lang.String r19 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x0126, all -> 0x0122 }
            r10 = r32
            java.lang.Object r11 = r10.zza((android.database.Cursor) r9, (int) r2)     // Catch:{ SQLiteException -> 0x0120 }
            int r3 = r9.getInt(r3)     // Catch:{ SQLiteException -> 0x0120 }
            if (r3 == 0) goto L_0x0091
            r23 = 1
            goto L_0x0093
        L_0x0091:
            r23 = 0
        L_0x0093:
            java.lang.String r24 = r9.getString(r4)     // Catch:{ SQLiteException -> 0x0120 }
            long r26 = r9.getLong(r5)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzkk r1 = r32.zzg()     // Catch:{ SQLiteException -> 0x0120 }
            r2 = 5
            byte[] r2 = r9.getBlob(r2)     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r3 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable r1 = r1.zza((byte[]) r2, r3)     // Catch:{ SQLiteException -> 0x0120 }
            r25 = r1
            com.google.android.gms.measurement.internal.zzaq r25 = (com.google.android.gms.measurement.internal.zzaq) r25     // Catch:{ SQLiteException -> 0x0120 }
            long r12 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzkk r0 = r32.zzg()     // Catch:{ SQLiteException -> 0x0120 }
            byte[] r1 = r9.getBlob(r6)     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r2 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x0120 }
            r28 = r0
            com.google.android.gms.measurement.internal.zzaq r28 = (com.google.android.gms.measurement.internal.zzaq) r28     // Catch:{ SQLiteException -> 0x0120 }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0120 }
            r0 = 9
            long r29 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzkk r0 = r32.zzg()     // Catch:{ SQLiteException -> 0x0120 }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r2 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x0120 }
            r31 = r0
            com.google.android.gms.measurement.internal.zzaq r31 = (com.google.android.gms.measurement.internal.zzaq) r31     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzkn r20 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ SQLiteException -> 0x0120 }
            r1 = r20
            r2 = r34
            r5 = r11
            r6 = r19
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzy r0 = new com.google.android.gms.measurement.internal.zzy     // Catch:{ SQLiteException -> 0x0120 }
            r17 = r0
            r18 = r33
            r21 = r12
            r17.<init>(r18, r19, r20, r21, r23, r24, r25, r26, r28, r29, r31)     // Catch:{ SQLiteException -> 0x0120 }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x0120 }
            if (r1 == 0) goto L_0x011a
            com.google.android.gms.measurement.internal.zzet r1 = r32.zzr()     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x0120 }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r33)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzer r4 = r32.zzo()     // Catch:{ SQLiteException -> 0x0120 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ SQLiteException -> 0x0120 }
            r1.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x0120 }
        L_0x011a:
            if (r9 == 0) goto L_0x011f
            r9.close()
        L_0x011f:
            return r0
        L_0x0120:
            r0 = move-exception
            goto L_0x0132
        L_0x0122:
            r0 = move-exception
            r10 = r32
            goto L_0x0152
        L_0x0126:
            r0 = move-exception
            r10 = r32
            goto L_0x0132
        L_0x012a:
            r0 = move-exception
            r10 = r32
            goto L_0x0153
        L_0x012e:
            r0 = move-exception
            r10 = r32
            r9 = r8
        L_0x0132:
            com.google.android.gms.measurement.internal.zzet r1 = r32.zzr()     // Catch:{ all -> 0x0151 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x0151 }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r33)     // Catch:{ all -> 0x0151 }
            com.google.android.gms.measurement.internal.zzer r4 = r32.zzo()     // Catch:{ all -> 0x0151 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ all -> 0x0151 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0151 }
            if (r9 == 0) goto L_0x0150
            r9.close()
        L_0x0150:
            return r8
        L_0x0151:
            r0 = move-exception
        L_0x0152:
            r8 = r9
        L_0x0153:
            if (r8 == 0) goto L_0x0158
            r8.close()
        L_0x0158:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzy");
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return mo26274c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting conditional property", zzet.zza(str), zzo().zzc(str2), e);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    public final void zzf() {
        zzak();
        mo26274c_().beginTransaction();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbo.zze>> zzg(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            d.b.a r0 = new d.b.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.mo26274c_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            java.lang.String r5 = "app_id=? AND property_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            r6[r10] = r13     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x009c }
            if (r1 != 0) goto L_0x0048
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x009c }
            if (r14 == 0) goto L_0x0047
            r14.close()
        L_0x0047:
            return r13
        L_0x0048:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.internal.measurement.zzbo$zze$zza r2 = com.google.android.gms.internal.measurement.zzbo.zze.zzi()     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzgs r1 = com.google.android.gms.measurement.internal.zzkk.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzbo$zze$zza r1 = (com.google.android.gms.internal.measurement.zzbo.zze.zza) r1     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzgt r1 = r1.zzu()     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzbo$zze r1 = (com.google.android.gms.internal.measurement.zzbo.zze) r1     // Catch:{ IOException -> 0x007e }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x009c }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x009c }
            if (r3 != 0) goto L_0x007a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x009c }
            r3.<init>()     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x009c }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x009c }
        L_0x007a:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x009c }
            goto L_0x0090
        L_0x007e:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzet r2 = r12.zzr()     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ SQLiteException -> 0x009c }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x009c }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x009c }
        L_0x0090:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x009c }
            if (r1 != 0) goto L_0x0048
            if (r14 == 0) goto L_0x009b
            r14.close()
        L_0x009b:
            return r0
        L_0x009c:
            r0 = move-exception
            goto L_0x00a2
        L_0x009e:
            r13 = move-exception
            goto L_0x00bb
        L_0x00a0:
            r0 = move-exception
            r14 = r9
        L_0x00a2:
            com.google.android.gms.measurement.internal.zzet r1 = r12.zzr()     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x00b9 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r13)     // Catch:{ all -> 0x00b9 }
            r1.zza(r2, r13, r0)     // Catch:{ all -> 0x00b9 }
            if (r14 == 0) goto L_0x00b8
            r14.close()
        L_0x00b8:
            return r9
        L_0x00b9:
            r13 = move-exception
            r9 = r14
        L_0x00bb:
            if (r9 == 0) goto L_0x00c0
            r9.close()
        L_0x00c0:
            goto L_0x00c2
        L_0x00c1:
            throw r13
        L_0x00c2:
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    public final void zzh() {
        zzak();
        mo26274c_().endTransaction();
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        int delete;
        zzd();
        zzak();
        if (zzam()) {
            long zza = zzs().zzf.zza();
            long elapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzas.zzx.zza(null).longValue()) {
                zzs().zzf.zza(elapsedRealtime);
                zzd();
                zzak();
                if (zzam() && (delete = mo26274c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzaa.zzk())})) > 0) {
                    zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbo.zzb>> zzf(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            d.b.a r0 = new d.b.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.mo26274c_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            java.lang.String r5 = "app_id=? AND event_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            r6[r10] = r13     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00a0, all -> 0x009e }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x009c }
            if (r1 != 0) goto L_0x0048
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x009c }
            if (r14 == 0) goto L_0x0047
            r14.close()
        L_0x0047:
            return r13
        L_0x0048:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.internal.measurement.zzbo$zzb$zza r2 = com.google.android.gms.internal.measurement.zzbo.zzb.zzl()     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzgs r1 = com.google.android.gms.measurement.internal.zzkk.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzbo$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzbo.zzb.zza) r1     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzgt r1 = r1.zzu()     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzfi r1 = (com.google.android.gms.internal.measurement.zzfi) r1     // Catch:{ IOException -> 0x007e }
            com.google.android.gms.internal.measurement.zzbo$zzb r1 = (com.google.android.gms.internal.measurement.zzbo.zzb) r1     // Catch:{ IOException -> 0x007e }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x009c }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x009c }
            if (r3 != 0) goto L_0x007a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x009c }
            r3.<init>()     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x009c }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x009c }
        L_0x007a:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x009c }
            goto L_0x0090
        L_0x007e:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzet r2 = r12.zzr()     // Catch:{ SQLiteException -> 0x009c }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ SQLiteException -> 0x009c }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x009c }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x009c }
        L_0x0090:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x009c }
            if (r1 != 0) goto L_0x0048
            if (r14 == 0) goto L_0x009b
            r14.close()
        L_0x009b:
            return r0
        L_0x009c:
            r0 = move-exception
            goto L_0x00a2
        L_0x009e:
            r13 = move-exception
            goto L_0x00bb
        L_0x00a0:
            r0 = move-exception
            r14 = r9
        L_0x00a2:
            com.google.android.gms.measurement.internal.zzet r1 = r12.zzr()     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x00b9 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r13)     // Catch:{ all -> 0x00b9 }
            r1.zza(r2, r13, r0)     // Catch:{ all -> 0x00b9 }
            if (r14 == 0) goto L_0x00b8
            r14.close()
        L_0x00b8:
            return r9
        L_0x00b9:
            r13 = move-exception
            r9 = r14
        L_0x00bb:
            if (r9 == 0) goto L_0x00c0
            r9.close()
        L_0x00c0:
            goto L_0x00c2
        L_0x00c1:
            throw r13
        L_0x00c2:
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final long zzh(String str, String str2) {
        long zza;
        String str3 = str;
        String str4 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase c_ = mo26274c_();
        c_.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str4);
            sb.append(" from app2 where app_id=?");
            try {
                zza = zza(sb.toString(), new String[]{str3}, -1);
                if (zza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", 0);
                    contentValues.put("previous_install_count", 0);
                    if (c_.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                        zzr().zzf().zza("Failed to insert column (got -1). appId", zzet.zza(str), str4);
                        c_.endTransaction();
                        return -1;
                    }
                    zza = 0;
                }
            } catch (SQLiteException e) {
                e = e;
                try {
                    zzr().zzf().zza("Error inserting column. appId", zzet.zza(str), str4, e);
                    c_.endTransaction();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    c_.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put(str4, Long.valueOf(1 + zza));
                if (((long) c_.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                    zzr().zzf().zza("Failed to update column (got 0). appId", zzet.zza(str), str4);
                    c_.endTransaction();
                    return -1;
                }
                c_.setTransactionSuccessful();
                c_.endTransaction();
                return zza;
            } catch (SQLiteException e2) {
                e = e2;
                j = zza;
                zzr().zzf().zza("Error inserting column. appId", zzet.zza(str), str4, e);
                c_.endTransaction();
                return j;
            }
        } catch (SQLiteException e3) {
            e = e3;
            zzr().zzf().zza("Error inserting column. appId", zzet.zza(str), str4, e);
            c_.endTransaction();
            return j;
        } catch (Throwable th2) {
            th = th2;
            c_.endTransaction();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x016b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzam zza(java.lang.String r28, java.lang.String r29) {
        /*
            r27 = this;
            r15 = r29
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
            r27.zzd()
            r27.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 9
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r2 = "lifetime_count"
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "current_bundle_count"
            r4 = 1
            r1[r4] = r2
            java.lang.String r2 = "last_fire_timestamp"
            r5 = 2
            r1[r5] = r2
            java.lang.String r2 = "last_bundled_timestamp"
            r6 = 3
            r1[r6] = r2
            java.lang.String r2 = "last_bundled_day"
            r7 = 4
            r1[r7] = r2
            java.lang.String r2 = "last_sampled_complex_event_id"
            r8 = 5
            r1[r8] = r2
            java.lang.String r2 = "last_sampling_rate"
            r9 = 6
            r1[r9] = r2
            java.lang.String r2 = "last_exempt_from_sampling"
            r10 = 7
            r1[r10] = r2
            java.lang.String r2 = "current_session_count"
            r11 = 8
            r1[r11] = r2
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r18 = 0
            android.database.sqlite.SQLiteDatabase r19 = r27.mo26274c_()     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            java.lang.String r20 = "events"
            java.lang.String[] r1 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r21 = r0
            java.lang.String[] r21 = (java.lang.String[]) r21     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            java.lang.String r22 = "app_id=? and name=?"
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r0[r3] = r28     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r0[r4] = r15     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            r24 = 0
            r25 = 0
            r26 = 0
            r23 = r0
            android.database.Cursor r14 = r19.query(r20, r21, r22, r23, r24, r25, r26)     // Catch:{ SQLiteException -> 0x0142, all -> 0x0140 }
            boolean r0 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            if (r0 != 0) goto L_0x007b
            if (r14 == 0) goto L_0x007a
            r14.close()
        L_0x007a:
            return r18
        L_0x007b:
            long r12 = r14.getLong(r3)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            long r16 = r14.getLong(r4)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            long r19 = r14.getLong(r5)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            boolean r0 = r14.isNull(r6)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            r1 = 0
            if (r0 == 0) goto L_0x0092
            r21 = r1
            goto L_0x0098
        L_0x0092:
            long r5 = r14.getLong(r6)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            r21 = r5
        L_0x0098:
            boolean r0 = r14.isNull(r7)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            if (r0 == 0) goto L_0x00a1
            r0 = r18
            goto L_0x00a9
        L_0x00a1:
            long r5 = r14.getLong(r7)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
        L_0x00a9:
            boolean r5 = r14.isNull(r8)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            if (r5 == 0) goto L_0x00b2
            r23 = r18
            goto L_0x00bc
        L_0x00b2:
            long r5 = r14.getLong(r8)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            r23 = r5
        L_0x00bc:
            boolean r5 = r14.isNull(r9)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            if (r5 == 0) goto L_0x00c5
            r24 = r18
            goto L_0x00cf
        L_0x00c5:
            long r5 = r14.getLong(r9)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            r24 = r5
        L_0x00cf:
            boolean r5 = r14.isNull(r10)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            if (r5 != 0) goto L_0x00ea
            long r5 = r14.getLong(r10)     // Catch:{ SQLiteException -> 0x00e7 }
            r7 = 1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x00e0
            r3 = 1
        L_0x00e0:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ SQLiteException -> 0x00e7 }
            r25 = r3
            goto L_0x00ec
        L_0x00e7:
            r0 = move-exception
            goto L_0x0145
        L_0x00ea:
            r25 = r18
        L_0x00ec:
            boolean r3 = r14.isNull(r11)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            if (r3 == 0) goto L_0x00f3
            goto L_0x00f7
        L_0x00f3:
            long r1 = r14.getLong(r11)     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
        L_0x00f7:
            r8 = r1
            com.google.android.gms.measurement.internal.zzam r26 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ SQLiteException -> 0x013c, all -> 0x0136 }
            r1 = r26
            r2 = r28
            r3 = r29
            r4 = r12
            r6 = r16
            r10 = r19
            r12 = r21
            r19 = r14
            r14 = r0
            r15 = r23
            r16 = r24
            r17 = r25
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0132, all -> 0x0130 }
            boolean r0 = r19.moveToNext()     // Catch:{ SQLiteException -> 0x0132, all -> 0x0130 }
            if (r0 == 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzet r0 = r27.zzr()     // Catch:{ SQLiteException -> 0x0132, all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0132, all -> 0x0130 }
            java.lang.String r1 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r28)     // Catch:{ SQLiteException -> 0x0132, all -> 0x0130 }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0132, all -> 0x0130 }
        L_0x012a:
            if (r19 == 0) goto L_0x012f
            r19.close()
        L_0x012f:
            return r26
        L_0x0130:
            r0 = move-exception
            goto L_0x0139
        L_0x0132:
            r0 = move-exception
            r14 = r19
            goto L_0x0145
        L_0x0136:
            r0 = move-exception
            r19 = r14
        L_0x0139:
            r18 = r19
            goto L_0x0169
        L_0x013c:
            r0 = move-exception
            r19 = r14
            goto L_0x0145
        L_0x0140:
            r0 = move-exception
            goto L_0x0169
        L_0x0142:
            r0 = move-exception
            r14 = r18
        L_0x0145:
            com.google.android.gms.measurement.internal.zzet r1 = r27.zzr()     // Catch:{ all -> 0x0166 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x0166 }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r28)     // Catch:{ all -> 0x0166 }
            com.google.android.gms.measurement.internal.zzer r4 = r27.zzo()     // Catch:{ all -> 0x0166 }
            r5 = r29
            java.lang.String r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x0166 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0166 }
            if (r14 == 0) goto L_0x0165
            r14.close()
        L_0x0165:
            return r18
        L_0x0166:
            r0 = move-exception
            r18 = r14
        L_0x0169:
            if (r18 == 0) goto L_0x016e
            r18.close()
        L_0x016e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzam");
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            mo26274c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting user property. appId", zzet.zza(str), zzo().zzc(str2), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzbo.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        C3191a aVar = new C3191a();
        Cursor cursor = null;
        try {
            cursor = mo26274c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzbo.zzb>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzbo.zzb zzb2 = (zzbo.zzb) ((zzfi) ((zzbo.zzb.zza) zzkk.zza(zzbo.zzb.zzl(), cursor.getBlob(1))).zzu());
                    if (zzb2.zzf()) {
                        int i = cursor.getInt(0);
                        List list = (List) aVar.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            aVar.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e) {
                    zzr().zzf().zza("Failed to merge filter. appId", zzet.zza(str), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return aVar;
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Database error querying filters. appId", zzet.zza(str), e2);
            Map<Integer, List<zzbo.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzy> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return (long) mo26274c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzas.zzo))))});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting over the limit events. appId", zzet.zza(str), e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzbw.zzi> zzg(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzak()
            r11.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.mo26274c_()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            java.lang.String r3 = "audience_id"
            r9 = 0
            r2[r9] = r3     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            java.lang.String r3 = "current_results"
            r10 = 1
            r2[r10] = r3     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            java.lang.String r3 = "app_id=?"
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            r4[r9] = r12     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0083, all -> 0x0081 }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x007f }
            if (r1 != 0) goto L_0x0036
            if (r0 == 0) goto L_0x0035
            r0.close()
        L_0x0035:
            return r8
        L_0x0036:
            d.b.a r1 = new d.b.a     // Catch:{ SQLiteException -> 0x007f }
            r1.<init>()     // Catch:{ SQLiteException -> 0x007f }
        L_0x003b:
            int r2 = r0.getInt(r9)     // Catch:{ SQLiteException -> 0x007f }
            byte[] r3 = r0.getBlob(r10)     // Catch:{ SQLiteException -> 0x007f }
            com.google.android.gms.internal.measurement.zzbw$zzi$zza r4 = com.google.android.gms.internal.measurement.zzbw.zzi.zzi()     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.zzgs r3 = com.google.android.gms.measurement.internal.zzkk.zza(r4, (byte[]) r3)     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.zzbw$zzi$zza r3 = (com.google.android.gms.internal.measurement.zzbw.zzi.zza) r3     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.zzgt r3 = r3.zzu()     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.zzfi r3 = (com.google.android.gms.internal.measurement.zzfi) r3     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.zzbw$zzi r3 = (com.google.android.gms.internal.measurement.zzbw.zzi) r3     // Catch:{ IOException -> 0x005d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x007f }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x007f }
            goto L_0x0073
        L_0x005d:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzet r4 = r11.zzr()     // Catch:{ SQLiteException -> 0x007f }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()     // Catch:{ SQLiteException -> 0x007f }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x007f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x007f }
            r4.zza(r5, r6, r2, r3)     // Catch:{ SQLiteException -> 0x007f }
        L_0x0073:
            boolean r2 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x007f }
            if (r2 != 0) goto L_0x003b
            if (r0 == 0) goto L_0x007e
            r0.close()
        L_0x007e:
            return r1
        L_0x007f:
            r1 = move-exception
            goto L_0x0085
        L_0x0081:
            r12 = move-exception
            goto L_0x009e
        L_0x0083:
            r1 = move-exception
            r0 = r8
        L_0x0085:
            com.google.android.gms.measurement.internal.zzet r2 = r11.zzr()     // Catch:{ all -> 0x009c }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x009c }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r12)     // Catch:{ all -> 0x009c }
            r2.zza(r3, r12, r1)     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x009b
            r0.close()
        L_0x009b:
            return r8
        L_0x009c:
            r12 = move-exception
            r8 = r0
        L_0x009e:
            if (r8 == 0) goto L_0x00a3
            r8.close()
        L_0x00a3:
            goto L_0x00a5
        L_0x00a4:
            throw r12
        L_0x00a5:
            goto L_0x00a4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzg(java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzf(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzak()
            r7.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            d.b.a r0 = new d.b.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.mo26274c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0069, all -> 0x0067 }
            r5 = 0
            r4[r5] = r8     // Catch:{ SQLiteException -> 0x0069, all -> 0x0067 }
            r6 = 1
            r4[r6] = r8     // Catch:{ SQLiteException -> 0x0069, all -> 0x0067 }
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0069, all -> 0x0067 }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0065 }
            if (r1 == 0) goto L_0x0031
            r1.close()
        L_0x0031:
            return r8
        L_0x0032:
            int r3 = r1.getInt(r5)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ SQLiteException -> 0x0065 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x0065 }
            if (r4 != 0) goto L_0x004e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0065 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x0065 }
        L_0x004e:
            int r3 = r1.getInt(r6)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x0065 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            if (r1 == 0) goto L_0x0064
            r1.close()
        L_0x0064:
            return r0
        L_0x0065:
            r0 = move-exception
            goto L_0x006b
        L_0x0067:
            r8 = move-exception
            goto L_0x0084
        L_0x0069:
            r0 = move-exception
            r1 = r2
        L_0x006b:
            com.google.android.gms.measurement.internal.zzet r3 = r7.zzr()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x0082 }
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r8)     // Catch:{ all -> 0x0082 }
            r3.zza(r4, r8, r0)     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0081
            r1.close()
        L_0x0081:
            return r2
        L_0x0082:
            r8 = move-exception
            r2 = r1
        L_0x0084:
            if (r2 == 0) goto L_0x0089
            r2.close()
        L_0x0089:
            goto L_0x008b
        L_0x008a:
            throw r8
        L_0x008b:
            goto L_0x008a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzf(java.lang.String):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0192 A[Catch:{ SQLiteException -> 0x0277 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0196 A[Catch:{ SQLiteException -> 0x0277 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01ce A[Catch:{ SQLiteException -> 0x0277 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01e8 A[Catch:{ SQLiteException -> 0x0277 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0218 A[Catch:{ SQLiteException -> 0x0277 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x021b A[Catch:{ SQLiteException -> 0x0277 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x022a A[Catch:{ SQLiteException -> 0x0277 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0260 A[Catch:{ SQLiteException -> 0x0277 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zzb(java.lang.String r24) {
        /*
            r23 = this;
            r1 = r24
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            r23.zzd()
            r23.zzak()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r23.mo26274c_()     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r4 = "apps"
            r0 = 29
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "app_instance_id"
            r11 = 0
            r5[r11] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "gmp_app_id"
            r12 = 1
            r5[r12] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "resettable_device_id_hash"
            r13 = 2
            r5[r13] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "last_bundle_index"
            r14 = 3
            r5[r14] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "last_bundle_start_timestamp"
            r15 = 4
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "last_bundle_end_timestamp"
            r10 = 5
            r5[r10] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "app_version"
            r9 = 6
            r5[r9] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "app_store"
            r8 = 7
            r5[r8] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "gmp_version"
            r7 = 8
            r5[r7] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "dev_cert_hash"
            r6 = 9
            r5[r6] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "measurement_enabled"
            r15 = 10
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "day"
            r15 = 11
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "daily_public_events_count"
            r15 = 12
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "daily_events_count"
            r15 = 13
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "daily_conversions_count"
            r15 = 14
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r0 = 15
            java.lang.String r16 = "config_fetched_time"
            r5[r0] = r16     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r0 = 16
            java.lang.String r16 = "failed_config_fetch_time"
            r5[r0] = r16     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "app_version_int"
            r15 = 17
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r0 = 18
            java.lang.String r17 = "firebase_instance_id"
            r5[r0] = r17     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r0 = 19
            java.lang.String r17 = "daily_error_events_count"
            r5[r0] = r17     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r0 = 20
            java.lang.String r17 = "daily_realtime_events_count"
            r5[r0] = r17     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r0 = 21
            java.lang.String r17 = "health_monitor_sample"
            r5[r0] = r17     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "android_id"
            r15 = 22
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "adid_reporting_enabled"
            r15 = 23
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "ssaid_reporting_enabled"
            r15 = 24
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r0 = 25
            java.lang.String r18 = "admob_app_id"
            r5[r0] = r18     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "dynamite_version"
            r15 = 26
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "safelisted_events"
            r15 = 27
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r0 = 28
            java.lang.String r19 = "ga_app_id"
            r5[r0] = r19     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            java.lang.String r0 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            r20 = 0
            r21 = 0
            r22 = 0
            r15 = 9
            r6 = r0
            r0 = 8
            r15 = 7
            r8 = r20
            r0 = 6
            r9 = r21
            r15 = 5
            r10 = r22
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0285, all -> 0x0281 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x027d, all -> 0x0279 }
            if (r4 != 0) goto L_0x00e6
            if (r3 == 0) goto L_0x00e5
            r3.close()
        L_0x00e5:
            return r2
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzg r4 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ SQLiteException -> 0x027d, all -> 0x0279 }
            r5 = r23
            com.google.android.gms.measurement.internal.zzkg r6 = r5.zza     // Catch:{ SQLiteException -> 0x0277 }
            com.google.android.gms.measurement.internal.zzfx r6 = r6.zzs()     // Catch:{ SQLiteException -> 0x0277 }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x0277 }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0277 }
            java.lang.String r6 = r3.getString(r12)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzb((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0277 }
            java.lang.String r6 = r3.getString(r13)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zze((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0277 }
            long r6 = r3.getLong(r14)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzg((long) r6)     // Catch:{ SQLiteException -> 0x0277 }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zza((long) r6)     // Catch:{ SQLiteException -> 0x0277 }
            long r6 = r3.getLong(r15)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzb((long) r6)     // Catch:{ SQLiteException -> 0x0277 }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzg((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 7
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzh((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 8
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzd((long) r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 9
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zze((long) r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 10
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r6 != 0) goto L_0x0150
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r0 = 0
            goto L_0x0151
        L_0x0150:
            r0 = 1
        L_0x0151:
            r4.zza((boolean) r0)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 11
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzj(r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 12
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzk(r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 13
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzl(r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 14
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzm(r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 15
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzh((long) r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 16
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzi((long) r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 17
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r6 == 0) goto L_0x0196
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x019b
        L_0x0196:
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x0277 }
            long r6 = (long) r0     // Catch:{ SQLiteException -> 0x0277 }
        L_0x019b:
            r4.zzc((long) r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 18
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzf((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 19
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzo(r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 20
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzn(r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 21
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzi((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0277 }
            com.google.android.gms.measurement.internal.zzaa r0 = r23.zzt()     // Catch:{ SQLiteException -> 0x0277 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzcm     // Catch:{ SQLiteException -> 0x0277 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r6)     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 != 0) goto L_0x01e0
            r0 = 22
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r6 == 0) goto L_0x01d9
            r6 = 0
            goto L_0x01dd
        L_0x01d9:
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
        L_0x01dd:
            r4.zzp(r6)     // Catch:{ SQLiteException -> 0x0277 }
        L_0x01e0:
            r0 = 23
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r6 != 0) goto L_0x01f1
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 == 0) goto L_0x01ef
            goto L_0x01f1
        L_0x01ef:
            r0 = 0
            goto L_0x01f2
        L_0x01f1:
            r0 = 1
        L_0x01f2:
            r4.zzb((boolean) r0)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 24
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r6 != 0) goto L_0x0203
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 == 0) goto L_0x0204
        L_0x0203:
            r11 = 1
        L_0x0204:
            r4.zzc((boolean) r11)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 25
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzc((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 26
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r6 == 0) goto L_0x021b
            r6 = 0
            goto L_0x021f
        L_0x021b:
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0277 }
        L_0x021f:
            r4.zzf((long) r6)     // Catch:{ SQLiteException -> 0x0277 }
            r0 = 27
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0277 }
            if (r6 != 0) goto L_0x023c
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0277 }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x0277 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zza((java.util.List<java.lang.String>) r0)     // Catch:{ SQLiteException -> 0x0277 }
        L_0x023c:
            boolean r0 = com.google.android.gms.internal.measurement.zzle.zzb()     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 == 0) goto L_0x0257
            com.google.android.gms.measurement.internal.zzaa r0 = r23.zzt()     // Catch:{ SQLiteException -> 0x0277 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzbo     // Catch:{ SQLiteException -> 0x0277 }
            boolean r0 = r0.zze(r1, r6)     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 == 0) goto L_0x0257
            r0 = 28
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0277 }
            r4.zzd((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0277 }
        L_0x0257:
            r4.zzb()     // Catch:{ SQLiteException -> 0x0277 }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 == 0) goto L_0x0271
            com.google.android.gms.measurement.internal.zzet r0 = r23.zzr()     // Catch:{ SQLiteException -> 0x0277 }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x0277 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r24)     // Catch:{ SQLiteException -> 0x0277 }
            r0.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0277 }
        L_0x0271:
            if (r3 == 0) goto L_0x0276
            r3.close()
        L_0x0276:
            return r4
        L_0x0277:
            r0 = move-exception
            goto L_0x0289
        L_0x0279:
            r0 = move-exception
            r5 = r23
            goto L_0x02a1
        L_0x027d:
            r0 = move-exception
            r5 = r23
            goto L_0x0289
        L_0x0281:
            r0 = move-exception
            r5 = r23
            goto L_0x02a2
        L_0x0285:
            r0 = move-exception
            r5 = r23
            r3 = r2
        L_0x0289:
            com.google.android.gms.measurement.internal.zzet r4 = r23.zzr()     // Catch:{ all -> 0x02a0 }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()     // Catch:{ all -> 0x02a0 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r24)     // Catch:{ all -> 0x02a0 }
            r4.zza(r6, r1, r0)     // Catch:{ all -> 0x02a0 }
            if (r3 == 0) goto L_0x029f
            r3.close()
        L_0x029f:
            return r2
        L_0x02a0:
            r0 = move-exception
        L_0x02a1:
            r2 = r3
        L_0x02a2:
            if (r2 == 0) goto L_0x02a7
            r2.close()
        L_0x02a7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzd(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzd()
            r11.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.mo26274c_()     // Catch:{ SQLiteException -> 0x005c, all -> 0x005a }
            java.lang.String r2 = "apps"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x005c, all -> 0x005a }
            java.lang.String r5 = "remote_config"
            r9 = 0
            r4[r9] = r5     // Catch:{ SQLiteException -> 0x005c, all -> 0x005a }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x005c, all -> 0x005a }
            r6[r9] = r12     // Catch:{ SQLiteException -> 0x005c, all -> 0x005a }
            r7 = 0
            r8 = 0
            r10 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x005c, all -> 0x005a }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0058 }
            if (r2 != 0) goto L_0x0037
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            byte[] r2 = r1.getBlob(r9)     // Catch:{ SQLiteException -> 0x0058 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0058 }
            if (r3 == 0) goto L_0x0052
            com.google.android.gms.measurement.internal.zzet r3 = r11.zzr()     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x0058 }
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0058 }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x0058 }
        L_0x0052:
            if (r1 == 0) goto L_0x0057
            r1.close()
        L_0x0057:
            return r2
        L_0x0058:
            r2 = move-exception
            goto L_0x005e
        L_0x005a:
            r12 = move-exception
            goto L_0x0077
        L_0x005c:
            r2 = move-exception
            r1 = r0
        L_0x005e:
            com.google.android.gms.measurement.internal.zzet r3 = r11.zzr()     // Catch:{ all -> 0x0075 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x0075 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r12)     // Catch:{ all -> 0x0075 }
            r3.zza(r4, r12, r2)     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0074
            r1.close()
        L_0x0074:
            return r0
        L_0x0075:
            r12 = move-exception
            r0 = r1
        L_0x0077:
            if (r0 == 0) goto L_0x007c
            r0.close()
        L_0x007c:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzd(java.lang.String):byte[]");
    }

    public final void zza(zzam zzam) {
        Preconditions.checkNotNull(zzam);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzam.zza);
        contentValues.put("name", zzam.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzam.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzam.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzam.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzam.zzg));
        contentValues.put("last_bundled_day", zzam.zzh);
        contentValues.put("last_sampled_complex_event_id", zzam.zzi);
        contentValues.put("last_sampling_rate", zzam.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzam.zze));
        Boolean bool = zzam.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (mo26274c_().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzet.zza(zzam.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzet.zza(zzam.zza), e);
        }
    }

    public final boolean zza(zzkp zzkp) {
        Preconditions.checkNotNull(zzkp);
        zzd();
        zzak();
        if (zzc(zzkp.zza, zzkp.zzc) == null) {
            if (zzko.zza(zzkp.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzkp.zza}) >= ((long) zzt().zzc(zzkp.zza))) {
                    return false;
                }
            } else if (!"_npa".equals(zzkp.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzkp.zza, zzkp.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkp.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ORIGIN, zzkp.zzb);
        contentValues.put("name", zzkp.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzkp.zzd));
        zza(contentValues, AppMeasurementSdk.ConditionalUserProperty.VALUE, zzkp.zze);
        try {
            if (mo26274c_().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzet.zza(zzkp.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing user property. appId", zzet.zza(zzkp.zza), e);
        }
        return true;
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase c_ = mo26274c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzt().zzb(str, zzas.zzae)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return c_.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error querying filters. appId", zzet.zza(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkp> zza(java.lang.String r23) {
        /*
            r22 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzd()
            r22.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r22.mo26274c_()     // Catch:{ SQLiteException -> 0x0099, all -> 0x0095 }
            java.lang.String r3 = "user_attributes"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0099, all -> 0x0095 }
            java.lang.String r5 = "name"
            r11 = 0
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x0099, all -> 0x0095 }
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch:{ SQLiteException -> 0x0099, all -> 0x0095 }
            java.lang.String r5 = "set_timestamp"
            r13 = 2
            r4[r13] = r5     // Catch:{ SQLiteException -> 0x0099, all -> 0x0095 }
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch:{ SQLiteException -> 0x0099, all -> 0x0095 }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0099, all -> 0x0095 }
            r6[r11] = r23     // Catch:{ SQLiteException -> 0x0099, all -> 0x0095 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0099, all -> 0x0095 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r3 != 0) goto L_0x0048
            if (r2 == 0) goto L_0x0047
            r2.close()
        L_0x0047:
            return r0
        L_0x0048:
            java.lang.String r18 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            java.lang.String r3 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r3 != 0) goto L_0x0054
            java.lang.String r3 = ""
        L_0x0054:
            r17 = r3
            long r19 = r2.getLong(r13)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            r3 = r22
            java.lang.Object r21 = r3.zza((android.database.Cursor) r2, (int) r14)     // Catch:{ SQLiteException -> 0x008b }
            if (r21 != 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzet r4 = r22.zzr()     // Catch:{ SQLiteException -> 0x008b }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()     // Catch:{ SQLiteException -> 0x008b }
            java.lang.String r5 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r23)     // Catch:{ SQLiteException -> 0x008b }
            r4.zza(r5, r6)     // Catch:{ SQLiteException -> 0x008b }
            goto L_0x007f
        L_0x0074:
            com.google.android.gms.measurement.internal.zzkp r4 = new com.google.android.gms.measurement.internal.zzkp     // Catch:{ SQLiteException -> 0x008b }
            r15 = r4
            r16 = r23
            r15.<init>(r16, r17, r18, r19, r21)     // Catch:{ SQLiteException -> 0x008b }
            r0.add(r4)     // Catch:{ SQLiteException -> 0x008b }
        L_0x007f:
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x008b }
            if (r4 != 0) goto L_0x0048
            if (r2 == 0) goto L_0x008a
            r2.close()
        L_0x008a:
            return r0
        L_0x008b:
            r0 = move-exception
            goto L_0x009d
        L_0x008d:
            r0 = move-exception
            r3 = r22
            goto L_0x00b5
        L_0x0091:
            r0 = move-exception
            r3 = r22
            goto L_0x009d
        L_0x0095:
            r0 = move-exception
            r3 = r22
            goto L_0x00b6
        L_0x0099:
            r0 = move-exception
            r3 = r22
            r2 = r1
        L_0x009d:
            com.google.android.gms.measurement.internal.zzet r4 = r22.zzr()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = "Error querying user properties. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r23)     // Catch:{ all -> 0x00b4 }
            r4.zza(r5, r6, r0)     // Catch:{ all -> 0x00b4 }
            if (r2 == 0) goto L_0x00b3
            r2.close()
        L_0x00b3:
            return r1
        L_0x00b4:
            r0 = move-exception
        L_0x00b5:
            r1 = r2
        L_0x00b6:
            if (r1 == 0) goto L_0x00bb
            r1.close()
        L_0x00bb:
            goto L_0x00bd
        L_0x00bc:
            throw r0
        L_0x00bd:
            goto L_0x00bc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011b, code lost:
        r14 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0122, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0123, code lost:
        r14 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0126, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0127, code lost:
        r14 = r21;
        r11 = r22;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0122 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkp> zza(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            r21 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r22)
            r21.zzd()
            r21.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0126, all -> 0x0122 }
            r3 = 3
            r2.<init>(r3)     // Catch:{ SQLiteException -> 0x0126, all -> 0x0122 }
            r11 = r22
            r2.add(r11)     // Catch:{ SQLiteException -> 0x011e, all -> 0x0122 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x011e, all -> 0x0122 }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x011e, all -> 0x0122 }
            boolean r5 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x011e, all -> 0x0122 }
            if (r5 != 0) goto L_0x0032
            r5 = r23
            r2.add(r5)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r6 = " and origin=?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            goto L_0x0034
        L_0x0032:
            r5 = r23
        L_0x0034:
            boolean r6 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            if (r6 != 0) goto L_0x004c
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r7 = "*"
            java.lang.String r6 = r6.concat(r7)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            r2.add(r6)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r6 = " and name glob ?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
        L_0x004c:
            int r6 = r2.size()     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.Object[] r2 = r2.toArray(r6)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            r16 = r2
            java.lang.String[] r16 = (java.lang.String[]) r16     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            android.database.sqlite.SQLiteDatabase r12 = r21.mo26274c_()     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r13 = "user_attributes"
            r2 = 4
            java.lang.String[] r14 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r2 = "name"
            r10 = 0
            r14[r10] = r2     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r2 = "set_timestamp"
            r8 = 1
            r14[r8] = r2     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r2 = "value"
            r9 = 2
            r14[r9] = r2     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r2 = "origin"
            r14[r3] = r2     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r15 = r4.toString()     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid"
            java.lang.String r20 = "1001"
            android.database.Cursor r2 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            boolean r4 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            if (r4 != 0) goto L_0x0092
            if (r2 == 0) goto L_0x0091
            r2.close()
        L_0x0091:
            return r0
        L_0x0092:
            int r4 = r0.size()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            r6 = 1000(0x3e8, float:1.401E-42)
            if (r4 < r6) goto L_0x00ae
            com.google.android.gms.measurement.internal.zzet r3 = r21.zzr()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            r3.zza(r4, r6)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            r14 = r21
            goto L_0x00fb
        L_0x00ae:
            java.lang.String r7 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            long r12 = r2.getLong(r8)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            r14 = r21
            java.lang.Object r15 = r14.zza((android.database.Cursor) r2, (int) r9)     // Catch:{ SQLiteException -> 0x0110 }
            java.lang.String r6 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x0110 }
            if (r15 != 0) goto L_0x00e0
            com.google.android.gms.measurement.internal.zzet r4 = r21.zzr()     // Catch:{ SQLiteException -> 0x00dd }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()     // Catch:{ SQLiteException -> 0x00dd }
            java.lang.String r5 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r22)     // Catch:{ SQLiteException -> 0x00dd }
            r12 = r24
            r4.zza(r5, r7, r6, r12)     // Catch:{ SQLiteException -> 0x00dd }
            r17 = r6
            r12 = 0
            r18 = 2
            r19 = 1
            goto L_0x00f5
        L_0x00dd:
            r0 = move-exception
            r5 = r6
            goto L_0x012e
        L_0x00e0:
            com.google.android.gms.measurement.internal.zzkp r5 = new com.google.android.gms.measurement.internal.zzkp     // Catch:{ SQLiteException -> 0x010a }
            r4 = r5
            r3 = r5
            r5 = r22
            r17 = r6
            r18 = 2
            r19 = 1
            r8 = r12
            r12 = 0
            r10 = r15
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x0108 }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x0108 }
        L_0x00f5:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0108 }
            if (r3 != 0) goto L_0x0101
        L_0x00fb:
            if (r2 == 0) goto L_0x0100
            r2.close()
        L_0x0100:
            return r0
        L_0x0101:
            r5 = r17
            r3 = 3
            r8 = 1
            r9 = 2
            r10 = 0
            goto L_0x0092
        L_0x0108:
            r0 = move-exception
            goto L_0x010d
        L_0x010a:
            r0 = move-exception
            r17 = r6
        L_0x010d:
            r5 = r17
            goto L_0x012e
        L_0x0110:
            r0 = move-exception
            goto L_0x012e
        L_0x0112:
            r0 = move-exception
            r14 = r21
            goto L_0x0146
        L_0x0116:
            r0 = move-exception
            r14 = r21
            goto L_0x012e
        L_0x011a:
            r0 = move-exception
            r14 = r21
            goto L_0x012d
        L_0x011e:
            r0 = move-exception
            r14 = r21
            goto L_0x012b
        L_0x0122:
            r0 = move-exception
            r14 = r21
            goto L_0x0147
        L_0x0126:
            r0 = move-exception
            r14 = r21
            r11 = r22
        L_0x012b:
            r5 = r23
        L_0x012d:
            r2 = r1
        L_0x012e:
            com.google.android.gms.measurement.internal.zzet r3 = r21.zzr()     // Catch:{ all -> 0x0145 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x0145 }
            java.lang.String r4 = "(2)Error querying user properties"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r22)     // Catch:{ all -> 0x0145 }
            r3.zza(r4, r6, r5, r0)     // Catch:{ all -> 0x0145 }
            if (r2 == 0) goto L_0x0144
            r2.close()
        L_0x0144:
            return r1
        L_0x0145:
            r0 = move-exception
        L_0x0146:
            r1 = r2
        L_0x0147:
            if (r1 == 0) goto L_0x014c
            r1.close()
        L_0x014c:
            goto L_0x014e
        L_0x014d:
            throw r0
        L_0x014e:
            goto L_0x014d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zza(zzy zzy) {
        Preconditions.checkNotNull(zzy);
        zzd();
        zzak();
        if (zzc(zzy.zza, zzy.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzy.zza}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzy.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ORIGIN, zzy.zzb);
        contentValues.put("name", zzy.zzc.zza);
        zza(contentValues, AppMeasurementSdk.ConditionalUserProperty.VALUE, zzy.zzc.zza());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzy.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzy.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzy.zzh));
        zzp();
        contentValues.put("timed_out_event", zzko.zza((Parcelable) zzy.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzy.zzd));
        zzp();
        contentValues.put("triggered_event", zzko.zza((Parcelable) zzy.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzy.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzy.zzj));
        zzp();
        contentValues.put("expired_event", zzko.zza((Parcelable) zzy.zzk));
        try {
            if (mo26274c_().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzet.zza(zzy.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing conditional user property", zzet.zza(zzy.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzy> zza(java.lang.String r40, java.lang.String[] r41) {
        /*
            r39 = this;
            r39.zzd()
            r39.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r39.mo26274c_()     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r3 = "conditional_properties"
            r4 = 13
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "app_id"
            r11 = 0
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "name"
            r13 = 2
            r4[r13] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "active"
            r15 = 4
            r4[r15] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "trigger_event_name"
            r10 = 5
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "trigger_timeout"
            r9 = 6
            r4[r9] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "timed_out_event"
            r8 = 7
            r4[r8] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "creation_timestamp"
            r7 = 8
            r4[r7] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "triggered_event"
            r6 = 9
            r4[r6] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "triggered_timestamp"
            r1 = 10
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "time_to_live"
            r1 = 11
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            java.lang.String r5 = "expired_event"
            r1 = 12
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            java.lang.String r22 = "1001"
            r5 = r40
            r1 = 9
            r6 = r41
            r1 = 8
            r7 = r19
            r1 = 7
            r8 = r20
            r1 = 6
            r9 = r21
            r1 = 5
            r10 = r22
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0159, all -> 0x0156 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            if (r3 != 0) goto L_0x0086
            if (r2 == 0) goto L_0x0085
            r2.close()
        L_0x0085:
            return r0
        L_0x0086:
            int r3 = r0.size()     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzet r1 = r39.zzr()     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r3 = "Read more than the max allowed conditional properties, ignoring extra"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r1.zza(r3, r4)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            goto L_0x0146
        L_0x00a1:
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r10 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = r2.getString(r13)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r9 = r39
            java.lang.Object r8 = r9.zza((android.database.Cursor) r2, (int) r14)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            int r4 = r2.getInt(r15)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            if (r4 == 0) goto L_0x00bc
            r22 = 1
            goto L_0x00be
        L_0x00bc:
            r22 = 0
        L_0x00be:
            java.lang.String r24 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r6 = 6
            long r25 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzkk r4 = r39.zzg()     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r7 = 7
            byte[] r1 = r2.getBlob(r7)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r6 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            android.os.Parcelable r1 = r4.zza((byte[]) r1, r6)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzaq r1 = (com.google.android.gms.measurement.internal.zzaq) r1     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r6 = 8
            long r27 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzkk r4 = r39.zzg()     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r11 = 9
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r7 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            android.os.Parcelable r4 = r4.zza((byte[]) r6, r7)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r29 = r4
            com.google.android.gms.measurement.internal.zzaq r29 = (com.google.android.gms.measurement.internal.zzaq) r29     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r6 = 10
            long r16 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r7 = 11
            long r31 = r2.getLong(r7)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzkk r4 = r39.zzg()     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r11 = 12
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r7 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            android.os.Parcelable r4 = r4.zza((byte[]) r6, r7)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r30 = r4
            com.google.android.gms.measurement.internal.zzaq r30 = (com.google.android.gms.measurement.internal.zzaq) r30     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzkn r33 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r4 = r33
            r34 = 11
            r35 = 10
            r36 = 8
            r37 = 7
            r38 = 6
            r6 = r16
            r9 = r10
            r4.<init>(r5, r6, r8, r9)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzy r4 = new com.google.android.gms.measurement.internal.zzy     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r16 = r4
            r17 = r3
            r18 = r10
            r19 = r33
            r20 = r27
            r23 = r24
            r24 = r1
            r27 = r29
            r28 = r31
            r16.<init>(r17, r18, r19, r20, r22, r23, r24, r25, r27, r28, r30)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r0.add(r4)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            boolean r1 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            if (r1 != 0) goto L_0x014c
        L_0x0146:
            if (r2 == 0) goto L_0x014b
            r2.close()
        L_0x014b:
            return r0
        L_0x014c:
            r1 = 5
            r11 = 0
            goto L_0x0086
        L_0x0150:
            r0 = move-exception
            r1 = r2
            goto L_0x0173
        L_0x0153:
            r0 = move-exception
            r1 = r2
            goto L_0x015b
        L_0x0156:
            r0 = move-exception
            r1 = 0
            goto L_0x0173
        L_0x0159:
            r0 = move-exception
            r1 = 0
        L_0x015b:
            com.google.android.gms.measurement.internal.zzet r2 = r39.zzr()     // Catch:{ all -> 0x0172 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x0172 }
            java.lang.String r3 = "Error querying conditional user property value"
            r2.zza(r3, r0)     // Catch:{ all -> 0x0172 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0172 }
            if (r1 == 0) goto L_0x0171
            r1.close()
        L_0x0171:
            return r0
        L_0x0172:
            r0 = move-exception
        L_0x0173:
            if (r1 == 0) goto L_0x0178
            r1.close()
        L_0x0178:
            goto L_0x017a
        L_0x0179:
            throw r0
        L_0x017a:
            goto L_0x0179
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final void zza(zzg zzg2) {
        Preconditions.checkNotNull(zzg2);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzc());
        contentValues.put("app_instance_id", zzg2.zzd());
        contentValues.put("gmp_app_id", zzg2.zze());
        contentValues.put("resettable_device_id_hash", zzg2.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzg2.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzg2.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzg2.zzk()));
        contentValues.put(TapjoyConstants.TJC_APP_VERSION_NAME, zzg2.zzl());
        contentValues.put("app_store", zzg2.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzg2.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzg2.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzg2.zzr()));
        contentValues.put("day", Long.valueOf(zzg2.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzg2.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzg2.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzg2.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzg2.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzg2.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzg2.zzm()));
        contentValues.put("firebase_instance_id", zzg2.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzg2.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzg2.zzaa()));
        contentValues.put("health_monitor_sample", zzg2.zzac());
        contentValues.put(TapjoyConstants.TJC_ANDROID_ID, Long.valueOf(zzg2.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzg2.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzg2.zzag()));
        contentValues.put("admob_app_id", zzg2.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzg2.zzq()));
        if (zzg2.zzai() != null) {
            if (zzg2.zzai().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzg2.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzg2.zzai()));
            }
        }
        if (zzle.zzb() && zzt().zze(zzg2.zzc(), zzas.zzbo)) {
            contentValues.put("ga_app_id", zzg2.zzg());
        }
        try {
            SQLiteDatabase c_ = mo26274c_();
            if (((long) c_.update("apps", contentValues, "app_id = ?", new String[]{zzg2.zzc()})) == 0 && c_.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzet.zza(zzg2.zzc()));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing app. appId", zzet.zza(zzg2.zzc()), e);
        }
    }

    public final zzae zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1, false, false, z3, false, z5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzae zza(long r22, java.lang.String r24, long r25, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31) {
        /*
            r21 = this;
            java.lang.String r0 = "daily_realtime_events_count"
            java.lang.String r1 = "daily_error_events_count"
            java.lang.String r2 = "daily_conversions_count"
            java.lang.String r3 = "daily_public_events_count"
            java.lang.String r4 = "daily_events_count"
            java.lang.String r5 = "day"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            r21.zzd()
            r21.zzak()
            r6 = 1
            java.lang.String[] r7 = new java.lang.String[r6]
            r8 = 0
            r7[r8] = r24
            com.google.android.gms.measurement.internal.zzae r9 = new com.google.android.gms.measurement.internal.zzae
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r15 = r21.mo26274c_()     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            java.lang.String r12 = "apps"
            r11 = 6
            java.lang.String[] r13 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r13[r8] = r5     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r13[r6] = r4     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r14 = 2
            r13[r14] = r3     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r11 = 3
            r13[r11] = r2     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r10 = 4
            r13[r10] = r1     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r10 = 5
            r13[r10] = r0     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            java.lang.String r16 = "app_id=?"
            java.lang.String[] r10 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r10[r8] = r24     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            r17 = 0
            r18 = 0
            r19 = 0
            r11 = r15
            r14 = r16
            r20 = r15
            r15 = r10
            r16 = r17
            r17 = r18
            r18 = r19
            android.database.Cursor r10 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0111, all -> 0x010e }
            boolean r11 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x010c }
            if (r11 != 0) goto L_0x0072
            com.google.android.gms.measurement.internal.zzet r0 = r21.zzr()     // Catch:{ SQLiteException -> 0x010c }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzi()     // Catch:{ SQLiteException -> 0x010c }
            java.lang.String r1 = "Not updating daily counts, app is not known. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r24)     // Catch:{ SQLiteException -> 0x010c }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x010c }
            if (r10 == 0) goto L_0x0071
            r10.close()
        L_0x0071:
            return r9
        L_0x0072:
            long r11 = r10.getLong(r8)     // Catch:{ SQLiteException -> 0x010c }
            int r8 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r8 != 0) goto L_0x009c
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zzb = r11     // Catch:{ SQLiteException -> 0x010c }
            r6 = 2
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zza = r11     // Catch:{ SQLiteException -> 0x010c }
            r6 = 3
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zzc = r11     // Catch:{ SQLiteException -> 0x010c }
            r6 = 4
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zzd = r11     // Catch:{ SQLiteException -> 0x010c }
            r6 = 5
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x010c }
            r9.zze = r11     // Catch:{ SQLiteException -> 0x010c }
        L_0x009c:
            if (r27 == 0) goto L_0x00a4
            long r11 = r9.zzb     // Catch:{ SQLiteException -> 0x010c }
            long r11 = r11 + r25
            r9.zzb = r11     // Catch:{ SQLiteException -> 0x010c }
        L_0x00a4:
            if (r28 == 0) goto L_0x00ac
            long r11 = r9.zza     // Catch:{ SQLiteException -> 0x010c }
            long r11 = r11 + r25
            r9.zza = r11     // Catch:{ SQLiteException -> 0x010c }
        L_0x00ac:
            if (r29 == 0) goto L_0x00b4
            long r11 = r9.zzc     // Catch:{ SQLiteException -> 0x010c }
            long r11 = r11 + r25
            r9.zzc = r11     // Catch:{ SQLiteException -> 0x010c }
        L_0x00b4:
            if (r30 == 0) goto L_0x00bc
            long r11 = r9.zzd     // Catch:{ SQLiteException -> 0x010c }
            long r11 = r11 + r25
            r9.zzd = r11     // Catch:{ SQLiteException -> 0x010c }
        L_0x00bc:
            if (r31 == 0) goto L_0x00c4
            long r11 = r9.zze     // Catch:{ SQLiteException -> 0x010c }
            long r11 = r11 + r25
            r9.zze = r11     // Catch:{ SQLiteException -> 0x010c }
        L_0x00c4:
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x010c }
            r6.<init>()     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r8 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r5, r8)     // Catch:{ SQLiteException -> 0x010c }
            long r11 = r9.zza     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r3, r5)     // Catch:{ SQLiteException -> 0x010c }
            long r11 = r9.zzb     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r4, r3)     // Catch:{ SQLiteException -> 0x010c }
            long r3 = r9.zzc     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r2, r3)     // Catch:{ SQLiteException -> 0x010c }
            long r2 = r9.zzd     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r1, r2)     // Catch:{ SQLiteException -> 0x010c }
            long r1 = r9.zze     // Catch:{ SQLiteException -> 0x010c }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x010c }
            r6.put(r0, r1)     // Catch:{ SQLiteException -> 0x010c }
            java.lang.String r0 = "apps"
            java.lang.String r1 = "app_id=?"
            r2 = r20
            r2.update(r0, r6, r1, r7)     // Catch:{ SQLiteException -> 0x010c }
            if (r10 == 0) goto L_0x010b
            r10.close()
        L_0x010b:
            return r9
        L_0x010c:
            r0 = move-exception
            goto L_0x0113
        L_0x010e:
            r0 = move-exception
            r10 = 0
            goto L_0x012b
        L_0x0111:
            r0 = move-exception
            r10 = 0
        L_0x0113:
            com.google.android.gms.measurement.internal.zzet r1 = r21.zzr()     // Catch:{ all -> 0x012a }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x012a }
            java.lang.String r2 = "Error updating daily counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r24)     // Catch:{ all -> 0x012a }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x012a }
            if (r10 == 0) goto L_0x0129
            r10.close()
        L_0x0129:
            return r9
        L_0x012a:
            r0 = move-exception
        L_0x012b:
            if (r10 == 0) goto L_0x0130
            r10.close()
        L_0x0130:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzae");
    }

    public final boolean zza(zzbw.zzg zzg2, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        Preconditions.checkState(zzg2.zzk());
        zzv();
        long currentTimeMillis = zzm().currentTimeMillis();
        if (zzg2.zzl() < currentTimeMillis - zzaa.zzk() || zzg2.zzl() > zzaa.zzk() + currentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzet.zza(zzg2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzg2.zzl()));
        }
        try {
            byte[] zzc2 = zzg().zzc(zzg2.zzbi());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzg2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzg2.zzl()));
            contentValues.put("data", zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzg2.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzg2.zzba()));
            }
            try {
                if (mo26274c_().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzet.zza(zzg2.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error storing bundle. appId", zzet.zza(zzg2.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzr().zzf().zza("Data loss. Failed to serialize bundle. appId", zzet.zza(zzg2.zzx()), e2);
            return false;
        }
    }

    public final List<Pair<zzbw.zzg, Long>> zza(String str, int i, int i2) {
        int i3 = i2;
        zzd();
        zzak();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i3 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = mo26274c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", String.valueOf(i));
            if (!cursor.moveToFirst()) {
                List<Pair<zzbw.zzg, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            do {
                long j = cursor.getLong(0);
                try {
                    byte[] zzb2 = zzg().zzb(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && zzb2.length + i4 > i3) {
                        break;
                    }
                    try {
                        zzbw.zzg.zza zza = (zzbw.zzg.zza) zzkk.zza(zzbw.zzg.zzbf(), zzb2);
                        if (!cursor.isNull(2)) {
                            zza.zzi(cursor.getInt(2));
                        }
                        i4 += zzb2.length;
                        arrayList.add(Pair.create((zzbw.zzg) ((zzfi) zza.zzu()), Long.valueOf(j)));
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to merge queued bundle. appId", zzet.zza(str), e);
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzr().zzf().zza("Failed to unzip queued bundle. appId", zzet.zza(str), e2);
                }
            } while (i4 <= i3);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzr().zzf().zza("Error querying bundles. appId", zzet.zza(str), e3);
            List<Pair<zzbw.zzg, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(List<Long> list) {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb3.toString(), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase c_ = mo26274c_();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + Notifications.NOTIFICATION_TYPES_ALL);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                c_.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error incrementing retry count. error", e);
            }
        }
    }

    private final boolean zza(String str, int i, zzbo.zzb zzb2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (TextUtils.isEmpty(zzb2.zzc())) {
            zzev zzi2 = zzr().zzi();
            Object zza = zzet.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zza()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzi2.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zzb2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zza() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put(TJAdUnitConstants.PARAM_PLACEMENT_NAME, zzb2.zzc());
        contentValues.put("session_scoped", zzb2.zzj() ? Boolean.valueOf(zzb2.zzk()) : null);
        contentValues.put("data", zzbi);
        try {
            if (mo26274c_().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzet.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event filter. appId", zzet.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzbo.zze zze2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (TextUtils.isEmpty(zze2.zzc())) {
            zzev zzi2 = zzr().zzi();
            Object zza = zzet.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zza()) {
                num = Integer.valueOf(zze2.zzb());
            }
            zzi2.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbi = zze2.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zza() ? Integer.valueOf(zze2.zzb()) : null);
        contentValues.put("property_name", zze2.zzc());
        contentValues.put("session_scoped", zze2.zzg() ? Boolean.valueOf(zze2.zzh()) : null);
        contentValues.put("data", zzbi);
        try {
            if (mo26274c_().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzet.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing property filter. appId", zzet.zza(str), e);
            return false;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final long zza(zzbw.zzg zzg2) throws IOException {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        byte[] zzbi = zzg2.zzbi();
        long zza = zzg().zza(zzbi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put("metadata", zzbi);
        try {
            mo26274c_().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzet.zza(zzg2.zzx()), e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzd()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.mo26274c_()     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003e }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzet r6 = r4.zzr()     // Catch:{ SQLiteException -> 0x003e }
            com.google.android.gms.measurement.internal.zzev r6 = r6.zzx()     // Catch:{ SQLiteException -> 0x003e }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x0033
            r5.close()
        L_0x0033:
            return r0
        L_0x0034:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x003d
            r5.close()
        L_0x003d:
            return r6
        L_0x003e:
            r6 = move-exception
            goto L_0x0044
        L_0x0040:
            r6 = move-exception
            goto L_0x0059
        L_0x0042:
            r6 = move-exception
            r5 = r0
        L_0x0044:
            com.google.android.gms.measurement.internal.zzet r1 = r4.zzr()     // Catch:{ all -> 0x0057 }
            com.google.android.gms.measurement.internal.zzev r1 = r1.zzf()     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0057 }
            if (r5 == 0) goto L_0x0056
            r5.close()
        L_0x0056:
            return r0
        L_0x0057:
            r6 = move-exception
            r0 = r5
        L_0x0059:
            if (r0 == 0) goto L_0x005e
            r0.close()
        L_0x005e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzbw.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzd()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.mo26274c_()     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0077 }
            if (r2 != 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzet r8 = r7.zzr()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzx()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0077 }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r4 = com.google.android.gms.internal.measurement.zzbw.zzc.zzj()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzgs r2 = com.google.android.gms.measurement.internal.zzkk.zza(r4, (byte[]) r2)     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzbw$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbw.zzc.zza) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzgt r2 = r2.zzu()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzfi r2 = (com.google.android.gms.internal.measurement.zzfi) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzbw$zzc r2 = (com.google.android.gms.internal.measurement.zzbw.zzc) r2     // Catch:{ IOException -> 0x005f }
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x005e
            r1.close()
        L_0x005e:
            return r8
        L_0x005f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzet r3 = r7.zzr()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzet.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x0077 }
            r3.zza(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x0076
            r1.close()
        L_0x0076:
            return r0
        L_0x0077:
            r8 = move-exception
            goto L_0x007d
        L_0x0079:
            r8 = move-exception
            goto L_0x0092
        L_0x007b:
            r8 = move-exception
            r1 = r0
        L_0x007d:
            com.google.android.gms.measurement.internal.zzet r9 = r7.zzr()     // Catch:{ all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzev r9 = r9.zzf()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x008f
            r1.close()
        L_0x008f:
            return r0
        L_0x0090:
            r8 = move-exception
            r0 = r1
        L_0x0092:
            if (r0 == 0) goto L_0x0097
            r0.close()
        L_0x0097:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzbw.zzc zzc2) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzc2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbi = zzc2.zzbi();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(zzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbi);
        try {
            if (mo26274c_().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzet.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing complex main event. appId", zzet.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzaj zzaj, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzaj);
        Preconditions.checkNotEmpty(zzaj.zza);
        zzbw.zzc.zza zzb2 = zzbw.zzc.zzj().zzb(zzaj.zzd);
        Iterator<String> it = zzaj.zze.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzbw.zze.zza zza = zzbw.zze.zzk().zza(next);
            zzg().zza(zza, zzaj.zze.zza(next));
            zzb2.zza(zza);
        }
        byte[] zzbi = ((zzbw.zzc) ((zzfi) zzb2.zzu())).zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaj.zza);
        contentValues.put("name", zzaj.zzb);
        contentValues.put("timestamp", Long.valueOf(zzaj.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbi);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (mo26274c_().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzet.zza(zzaj.zza));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event. appId", zzet.zza(zzaj.zza), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, List<zzbo.zza> list) {
        boolean z;
        boolean z2;
        String str2 = str;
        List<zzbo.zza> list2 = list;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbo.zza.C6844zza zza = (zzbo.zza.C6844zza) list2.get(i).zzbm();
            if (zza.zzb() != 0) {
                for (int i2 = 0; i2 < zza.zzb(); i2++) {
                    zzbo.zzb.zza zza2 = (zzbo.zzb.zza) zza.zzb(i2).zzbm();
                    zzbo.zzb.zza zza3 = (zzbo.zzb.zza) ((zzfi.zzb) zza2.clone());
                    String zzb2 = zzgw.zzb(zza2.zza());
                    if (zzb2 != null) {
                        zza3.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zza2.zzb(); i3++) {
                        zzbo.zzc zza4 = zza2.zza(i3);
                        String zza5 = zzgv.zza(zza4.zzh());
                        if (zza5 != null) {
                            zza3.zza(i3, (zzbo.zzc) ((zzfi) ((zzbo.zzc.zza) zza4.zzbm()).zza(zza5).zzu()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza = zza.zza(i2, zza3);
                        list2.set(i, (zzbo.zza) ((zzfi) zza.zzu()));
                    }
                }
            }
            if (zza.zza() != 0) {
                for (int i4 = 0; i4 < zza.zza(); i4++) {
                    zzbo.zze zza6 = zza.zza(i4);
                    String zza7 = zzgy.zza(zza6.zzc());
                    if (zza7 != null) {
                        zza = zza.zza(i4, ((zzbo.zze.zza) zza6.zzbm()).zza(zza7));
                        list2.set(i, (zzbo.zza) ((zzfi) zza.zzu()));
                    }
                }
            }
        }
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase c_ = mo26274c_();
        c_.beginTransaction();
        try {
            zzak();
            zzd();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase c_2 = mo26274c_();
            c_2.delete("property_filters", "app_id=?", new String[]{str2});
            c_2.delete("event_filters", "app_id=?", new String[]{str2});
            for (zzbo.zza next : list) {
                zzak();
                zzd();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(next);
                if (!next.zza()) {
                    zzr().zzi().zza("Audience with no ID. appId", zzet.zza(str));
                } else {
                    int zzb3 = next.zzb();
                    Iterator<zzbo.zzb> it = next.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                zzr().zzi().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzet.zza(str), Integer.valueOf(zzb3));
                                break;
                            }
                        } else {
                            Iterator<zzbo.zze> it2 = next.zzc().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        zzr().zzi().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzet.zza(str), Integer.valueOf(zzb3));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbo.zzb> it3 = next.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str2, zzb3, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbo.zze> it4 = next.zzc().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str2, zzb3, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzd();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase c_3 = mo26274c_();
                                        c_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zzb3)});
                                        c_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zzb3)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbo.zza next2 : list) {
                arrayList.add(next2.zza() ? Integer.valueOf(next2.zzb()) : null);
            }
            zzb(str2, (List<Integer>) arrayList);
            c_.setTransactionSuccessful();
        } finally {
            c_.endTransaction();
        }
    }
}
