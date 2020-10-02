package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
public final class zzep extends zze {
    private final zzes zza = new zzes(this, zzn(), "google_app_measurement_local.db");
    private boolean zzb;

    zzep(zzfx zzfx) {
        super(zzfx);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4 A[SYNTHETIC, Splitter:B:47:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x011a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzb()
            r16.zzd()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000e
            return r2
        L_0x000e:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0026:
            if (r5 >= r4) goto L_0x012c
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r16.zzae()     // Catch:{ SQLiteFullException -> 0x00fe, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00c0, all -> 0x00bd }
            if (r9 != 0) goto L_0x0038
            r1.zzb = r8     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ed, SQLiteException -> 0x00b7 }
            if (r9 == 0) goto L_0x0037
            r9.close()
        L_0x0037:
            return r2
        L_0x0038:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ed, SQLiteException -> 0x00b7 }
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00bb, SQLiteDatabaseLockedException -> 0x00ed, SQLiteException -> 0x00b7 }
            if (r12 == 0) goto L_0x0059
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            if (r0 == 0) goto L_0x0059
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            goto L_0x0059
        L_0x0050:
            r0 = move-exception
            goto L_0x00ea
        L_0x0053:
            r0 = move-exception
            goto L_0x00b9
        L_0x0055:
            r0 = move-exception
            r7 = r12
            goto L_0x0100
        L_0x0059:
            java.lang.String r0 = "messages"
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzet r15 = r16.zzr()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            com.google.android.gms.measurement.internal.zzev r15 = r15.zzf()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.String r4 = "Data loss, local db full"
            r15.zza(r4)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r4 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            r10[r2] = r11     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            int r4 = r9.delete(r0, r4, r10)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            long r10 = (long) r4     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            int r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.zzet r4 = r16.zzr()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            com.google.android.gms.measurement.internal.zzev r4 = r4.zzf()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            r4.zza(r15, r2, r8, r10)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
        L_0x00a0:
            r9.insertOrThrow(r0, r7, r3)     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0055, SQLiteDatabaseLockedException -> 0x00b5, SQLiteException -> 0x0053, all -> 0x0050 }
            if (r12 == 0) goto L_0x00ae
            r12.close()
        L_0x00ae:
            if (r9 == 0) goto L_0x00b3
            r9.close()
        L_0x00b3:
            r2 = 1
            return r2
        L_0x00b5:
            r7 = r12
            goto L_0x00ed
        L_0x00b7:
            r0 = move-exception
            r12 = r7
        L_0x00b9:
            r7 = r9
            goto L_0x00c2
        L_0x00bb:
            r0 = move-exception
            goto L_0x0100
        L_0x00bd:
            r0 = move-exception
            r9 = r7
            goto L_0x0121
        L_0x00c0:
            r0 = move-exception
            r12 = r7
        L_0x00c2:
            if (r7 == 0) goto L_0x00cd
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x00cd
            r7.endTransaction()     // Catch:{ all -> 0x00e8 }
        L_0x00cd:
            com.google.android.gms.measurement.internal.zzet r2 = r16.zzr()     // Catch:{ all -> 0x00e8 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zza(r4, r0)     // Catch:{ all -> 0x00e8 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00e8 }
            if (r12 == 0) goto L_0x00e2
            r12.close()
        L_0x00e2:
            if (r7 == 0) goto L_0x011a
            r7.close()
            goto L_0x011a
        L_0x00e8:
            r0 = move-exception
            r9 = r7
        L_0x00ea:
            r7 = r12
            goto L_0x0121
        L_0x00ec:
            r9 = r7
        L_0x00ed:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x0120 }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x00f8
            r7.close()
        L_0x00f8:
            if (r9 == 0) goto L_0x011a
            r9.close()
            goto L_0x011a
        L_0x00fe:
            r0 = move-exception
            r9 = r7
        L_0x0100:
            com.google.android.gms.measurement.internal.zzet r2 = r16.zzr()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzev r2 = r2.zzf()     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zza(r4, r0)     // Catch:{ all -> 0x0120 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x0120 }
            if (r7 == 0) goto L_0x0115
            r7.close()
        L_0x0115:
            if (r9 == 0) goto L_0x011a
            r9.close()
        L_0x011a:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0026
        L_0x0120:
            r0 = move-exception
        L_0x0121:
            if (r7 == 0) goto L_0x0126
            r7.close()
        L_0x0126:
            if (r9 == 0) goto L_0x012b
            r9.close()
        L_0x012b:
            throw r0
        L_0x012c:
            com.google.android.gms.measurement.internal.zzet r0 = r16.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzx()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzep.zza(int, byte[]):boolean");
    }

    @VisibleForTesting
    private final SQLiteDatabase zzae() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    @VisibleForTesting
    private final boolean zzaf() {
        return zzn().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final void zzab() {
        zzb();
        zzd();
        try {
            int delete = zzae().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzr().zzx().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzac() {
        return zza(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0089, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzad() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.zzd()
            r11.zzb()
            boolean r1 = r11.zzb
            r2 = 0
            if (r1 == 0) goto L_0x000e
            return r2
        L_0x000e:
            boolean r1 = r11.zzaf()
            if (r1 != 0) goto L_0x0015
            return r2
        L_0x0015:
            r1 = 5
            r3 = 0
            r4 = 5
        L_0x0018:
            if (r3 >= r1) goto L_0x0092
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r11.zzae()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 != 0) goto L_0x002a
            r11.zzb = r6     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 == 0) goto L_0x0029
            r5.close()
        L_0x0029:
            return r2
        L_0x002a:
            r5.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r9[r2] = r10     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 == 0) goto L_0x0048
            r5.close()
        L_0x0048:
            return r6
        L_0x0049:
            r0 = move-exception
            goto L_0x008c
        L_0x004b:
            r7 = move-exception
            if (r5 == 0) goto L_0x0057
            boolean r8 = r5.inTransaction()     // Catch:{ all -> 0x0049 }
            if (r8 == 0) goto L_0x0057
            r5.endTransaction()     // Catch:{ all -> 0x0049 }
        L_0x0057:
            com.google.android.gms.measurement.internal.zzet r8 = r11.zzr()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzf()     // Catch:{ all -> 0x0049 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0049 }
            r11.zzb = r6     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0089
            r5.close()
            goto L_0x0089
        L_0x006a:
            long r6 = (long) r4
            android.os.SystemClock.sleep(r6)     // Catch:{ all -> 0x0049 }
            int r4 = r4 + 20
            if (r5 == 0) goto L_0x0089
            r5.close()
            goto L_0x0089
        L_0x0076:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzet r8 = r11.zzr()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzev r8 = r8.zzf()     // Catch:{ all -> 0x0049 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0049 }
            r11.zzb = r6     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0089
            r5.close()
        L_0x0089:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x008c:
            if (r5 == 0) goto L_0x0091
            r5.close()
        L_0x0091:
            throw r0
        L_0x0092:
            com.google.android.gms.measurement.internal.zzet r0 = r11.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzi()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.zza(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzep.zzad():boolean");
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

    public final boolean zza(zzaq zzaq) {
        Parcel obtain = Parcel.obtain();
        zzaq.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzr().zzg().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzkn zzkn) {
        Parcel obtain = Parcel.obtain();
        zzkn.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzr().zzg().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzy zzy) {
        zzp();
        byte[] zza2 = zzko.zza((Parcelable) zzy);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzr().zzg().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:63|64|65|66) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:78|79|80|81) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:50|51|52|53|179) */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01ab, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r0 = th;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        r10 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        r10 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        zzr().zzf().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        zzr().zzf().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r11.recycle();
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        zzr().zzf().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r11.recycle();
        r12 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x00b6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00e6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x011c */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01bc A[SYNTHETIC, Splitter:B:130:0x01bc] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x020a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x020a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x020a A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r23) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "Error reading entries from local database"
            r22.zzd()
            r22.zzb()
            boolean r0 = r1.zzb
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r22.zzaf()
            if (r0 != 0) goto L_0x001c
            return r4
        L_0x001c:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x0020:
            if (r7 >= r5) goto L_0x021d
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r22.zzae()     // Catch:{ SQLiteFullException -> 0x01f0, SQLiteDatabaseLockedException -> 0x01dd, SQLiteException -> 0x01b7, all -> 0x01b3 }
            if (r15 != 0) goto L_0x003c
            r1.zzb = r9     // Catch:{ SQLiteFullException -> 0x0038, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x0034, all -> 0x0031 }
            if (r15 == 0) goto L_0x0030
            r15.close()
        L_0x0030:
            return r3
        L_0x0031:
            r0 = move-exception
            goto L_0x0212
        L_0x0034:
            r0 = move-exception
            r10 = r3
            goto L_0x01ba
        L_0x0038:
            r0 = move-exception
            r10 = r3
            goto L_0x01f3
        L_0x003c:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x01af, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x01a7, all -> 0x01a2 }
            long r10 = zza((android.database.sqlite.SQLiteDatabase) r15)     // Catch:{ SQLiteFullException -> 0x01af, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x01a7, all -> 0x01a2 }
            r19 = -1
            int r0 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0038, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x0034, all -> 0x0031 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0038, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x0034, all -> 0x0031 }
            r12[r6] = r10     // Catch:{ SQLiteFullException -> 0x0038, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x0034, all -> 0x0031 }
            r13 = r0
            r14 = r12
            goto L_0x0058
        L_0x0056:
            r13 = r3
            r14 = r13
        L_0x0058:
            java.lang.String r11 = "messages"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteFullException -> 0x01af, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x01a7, all -> 0x01a2 }
            java.lang.String r10 = "rowid"
            r12[r6] = r10     // Catch:{ SQLiteFullException -> 0x01af, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x01a7, all -> 0x01a2 }
            java.lang.String r10 = "type"
            r12[r9] = r10     // Catch:{ SQLiteFullException -> 0x01af, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x01a7, all -> 0x01a2 }
            java.lang.String r10 = "entry"
            r5 = 2
            r12[r5] = r10     // Catch:{ SQLiteFullException -> 0x01af, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x01a7, all -> 0x01a2 }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid asc"
            r10 = 100
            java.lang.String r21 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x01af, SQLiteDatabaseLockedException -> 0x01ab, SQLiteException -> 0x01a7, all -> 0x01a2 }
            r10 = r15
            r3 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r21
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x019f, SQLiteDatabaseLockedException -> 0x01ac, SQLiteException -> 0x019c, all -> 0x0199 }
        L_0x0084:
            boolean r11 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            if (r11 == 0) goto L_0x0158
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            int r11 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            byte[] r12 = r10.getBlob(r5)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            if (r11 != 0) goto L_0x00cb
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            int r13 = r12.length     // Catch:{ ParseException -> 0x00b6 }
            r11.unmarshall(r12, r6, r13)     // Catch:{ ParseException -> 0x00b6 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00b6 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaq> r12 = com.google.android.gms.measurement.internal.zzaq.CREATOR     // Catch:{ ParseException -> 0x00b6 }
            java.lang.Object r12 = r12.createFromParcel(r11)     // Catch:{ ParseException -> 0x00b6 }
            com.google.android.gms.measurement.internal.zzaq r12 = (com.google.android.gms.measurement.internal.zzaq) r12     // Catch:{ ParseException -> 0x00b6 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            if (r12 == 0) goto L_0x0084
            r4.add(r12)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            goto L_0x0084
        L_0x00b4:
            r0 = move-exception
            goto L_0x00c7
        L_0x00b6:
            com.google.android.gms.measurement.internal.zzet r12 = r22.zzr()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzf()     // Catch:{ all -> 0x00b4 }
            java.lang.String r13 = "Failed to load event from local database"
            r12.zza(r13)     // Catch:{ all -> 0x00b4 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            goto L_0x0084
        L_0x00c7:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            throw r0     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
        L_0x00cb:
            if (r11 != r9) goto L_0x0101
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            int r13 = r12.length     // Catch:{ ParseException -> 0x00e6 }
            r11.unmarshall(r12, r6, r13)     // Catch:{ ParseException -> 0x00e6 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00e6 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkn> r12 = com.google.android.gms.measurement.internal.zzkn.CREATOR     // Catch:{ ParseException -> 0x00e6 }
            java.lang.Object r12 = r12.createFromParcel(r11)     // Catch:{ ParseException -> 0x00e6 }
            com.google.android.gms.measurement.internal.zzkn r12 = (com.google.android.gms.measurement.internal.zzkn) r12     // Catch:{ ParseException -> 0x00e6 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            goto L_0x00f7
        L_0x00e4:
            r0 = move-exception
            goto L_0x00fd
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzet r12 = r22.zzr()     // Catch:{ all -> 0x00e4 }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzf()     // Catch:{ all -> 0x00e4 }
            java.lang.String r13 = "Failed to load user property from local database"
            r12.zza(r13)     // Catch:{ all -> 0x00e4 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            r12 = 0
        L_0x00f7:
            if (r12 == 0) goto L_0x0084
            r4.add(r12)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            goto L_0x0084
        L_0x00fd:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            throw r0     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
        L_0x0101:
            if (r11 != r5) goto L_0x0138
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            int r13 = r12.length     // Catch:{ ParseException -> 0x011c }
            r11.unmarshall(r12, r6, r13)     // Catch:{ ParseException -> 0x011c }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x011c }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzy> r12 = com.google.android.gms.measurement.internal.zzy.CREATOR     // Catch:{ ParseException -> 0x011c }
            java.lang.Object r12 = r12.createFromParcel(r11)     // Catch:{ ParseException -> 0x011c }
            com.google.android.gms.measurement.internal.zzy r12 = (com.google.android.gms.measurement.internal.zzy) r12     // Catch:{ ParseException -> 0x011c }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            goto L_0x012d
        L_0x011a:
            r0 = move-exception
            goto L_0x0134
        L_0x011c:
            com.google.android.gms.measurement.internal.zzet r12 = r22.zzr()     // Catch:{ all -> 0x011a }
            com.google.android.gms.measurement.internal.zzev r12 = r12.zzf()     // Catch:{ all -> 0x011a }
            java.lang.String r13 = "Failed to load conditional user property from local database"
            r12.zza(r13)     // Catch:{ all -> 0x011a }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            r12 = 0
        L_0x012d:
            if (r12 == 0) goto L_0x0084
            r4.add(r12)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            goto L_0x0084
        L_0x0134:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            throw r0     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
        L_0x0138:
            if (r11 != r0) goto L_0x0149
            com.google.android.gms.measurement.internal.zzet r11 = r22.zzr()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            com.google.android.gms.measurement.internal.zzev r11 = r11.zzi()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            java.lang.String r12 = "Skipping app launch break"
            r11.zza(r12)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            goto L_0x0084
        L_0x0149:
            com.google.android.gms.measurement.internal.zzet r11 = r22.zzr()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            com.google.android.gms.measurement.internal.zzev r11 = r11.zzf()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            java.lang.String r12 = "Unknown record type in local database"
            r11.zza(r12)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            goto L_0x0084
        L_0x0158:
            java.lang.String r0 = "messages"
            java.lang.String r5 = "rowid <= ?"
            java.lang.String[] r11 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            java.lang.String r12 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            r11[r6] = r12     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            int r0 = r3.delete(r0, r5, r11)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            int r5 = r4.size()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            if (r0 >= r5) goto L_0x017b
            com.google.android.gms.measurement.internal.zzet r0 = r22.zzr()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzf()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            java.lang.String r5 = "Fewer entries removed from local database than expected"
            r0.zza(r5)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
        L_0x017b:
            r3.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            r3.endTransaction()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x0193, SQLiteException -> 0x0190, all -> 0x018c }
            if (r10 == 0) goto L_0x0186
            r10.close()
        L_0x0186:
            if (r3 == 0) goto L_0x018b
            r3.close()
        L_0x018b:
            return r4
        L_0x018c:
            r0 = move-exception
            r15 = r3
            goto L_0x0211
        L_0x0190:
            r0 = move-exception
            r15 = r3
            goto L_0x01ba
        L_0x0193:
            r15 = r3
            goto L_0x01df
        L_0x0195:
            r0 = move-exception
            r15 = r3
            goto L_0x01f3
        L_0x0199:
            r0 = move-exception
            r15 = r3
            goto L_0x01a4
        L_0x019c:
            r0 = move-exception
            r15 = r3
            goto L_0x01a9
        L_0x019f:
            r0 = move-exception
            r15 = r3
            goto L_0x01b1
        L_0x01a2:
            r0 = move-exception
            r3 = r15
        L_0x01a4:
            r3 = 0
            goto L_0x0212
        L_0x01a7:
            r0 = move-exception
            r3 = r15
        L_0x01a9:
            r10 = 0
            goto L_0x01ba
        L_0x01ab:
            r3 = r15
        L_0x01ac:
            r15 = r3
            r10 = 0
            goto L_0x01df
        L_0x01af:
            r0 = move-exception
            r3 = r15
        L_0x01b1:
            r10 = 0
            goto L_0x01f3
        L_0x01b3:
            r0 = move-exception
            r3 = 0
            r15 = 0
            goto L_0x0212
        L_0x01b7:
            r0 = move-exception
            r10 = 0
            r15 = 0
        L_0x01ba:
            if (r15 == 0) goto L_0x01c5
            boolean r3 = r15.inTransaction()     // Catch:{ all -> 0x0210 }
            if (r3 == 0) goto L_0x01c5
            r15.endTransaction()     // Catch:{ all -> 0x0210 }
        L_0x01c5:
            com.google.android.gms.measurement.internal.zzet r3 = r22.zzr()     // Catch:{ all -> 0x0210 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x0210 }
            r3.zza(r2, r0)     // Catch:{ all -> 0x0210 }
            r1.zzb = r9     // Catch:{ all -> 0x0210 }
            if (r10 == 0) goto L_0x01d7
            r10.close()
        L_0x01d7:
            if (r15 == 0) goto L_0x020a
            r15.close()
            goto L_0x020a
        L_0x01dd:
            r10 = 0
            r15 = 0
        L_0x01df:
            long r11 = (long) r8
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x0210 }
            int r8 = r8 + 20
            if (r10 == 0) goto L_0x01ea
            r10.close()
        L_0x01ea:
            if (r15 == 0) goto L_0x020a
            r15.close()
            goto L_0x020a
        L_0x01f0:
            r0 = move-exception
            r10 = 0
            r15 = 0
        L_0x01f3:
            com.google.android.gms.measurement.internal.zzet r3 = r22.zzr()     // Catch:{ all -> 0x0210 }
            com.google.android.gms.measurement.internal.zzev r3 = r3.zzf()     // Catch:{ all -> 0x0210 }
            r3.zza(r2, r0)     // Catch:{ all -> 0x0210 }
            r1.zzb = r9     // Catch:{ all -> 0x0210 }
            if (r10 == 0) goto L_0x0205
            r10.close()
        L_0x0205:
            if (r15 == 0) goto L_0x020a
            r15.close()
        L_0x020a:
            int r7 = r7 + 1
            r3 = 0
            r5 = 5
            goto L_0x0020
        L_0x0210:
            r0 = move-exception
        L_0x0211:
            r3 = r10
        L_0x0212:
            if (r3 == 0) goto L_0x0217
            r3.close()
        L_0x0217:
            if (r15 == 0) goto L_0x021c
            r15.close()
        L_0x021c:
            throw r0
        L_0x021d:
            com.google.android.gms.measurement.internal.zzet r0 = r22.zzr()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzi()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzep.zza(int):java.util.List");
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, (String) null, (String) null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
