package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

/* renamed from: com.tapjoy.internal.g */
public final class C5105g extends C4896at implements C4901ax, Closeable {

    /* renamed from: a */
    private SQLiteDatabase f13968a;

    /* renamed from: b */
    private final C4907bd f13969b;

    /* renamed from: c */
    private int f13970c;

    public C5105g(File file, C4907bd bdVar) {
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        this.f13968a = openOrCreateDatabase;
        this.f13969b = bdVar;
        if (openOrCreateDatabase.getVersion() != 1) {
            this.f13968a.beginTransaction();
            try {
                this.f13968a.execSQL("CREATE TABLE IF NOT EXISTS List(value BLOB)");
                this.f13968a.setVersion(1);
                this.f13968a.setTransactionSuccessful();
            } finally {
                this.f13968a.endTransaction();
            }
        }
        this.f13970c = m17234a();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* renamed from: a */
    private int m17234a() {
        Cursor cursor = 0;
        try {
            cursor = this.f13968a.rawQuery("SELECT COUNT(1) FROM List", cursor);
            if (cursor.moveToNext()) {
                return cursor.getInt(0);
            }
            m17235a(cursor);
            return 0;
        } finally {
            m17235a((Cursor) cursor);
        }
    }

    /* renamed from: b */
    public final void mo30932b(int i) {
        int i2;
        if (i <= 0 || i > (i2 = this.f13970c)) {
            throw new IndexOutOfBoundsException();
        } else if (i == i2) {
            clear();
        } else {
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.f13968a;
                StringBuilder sb = new StringBuilder("SELECT rowid FROM List ORDER BY rowid LIMIT ");
                sb.append(i - 1);
                sb.append(",1");
                Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), (String[]) null);
                try {
                    if (rawQuery.moveToNext()) {
                        long j = rawQuery.getLong(0);
                        rawQuery.close();
                        SQLiteDatabase sQLiteDatabase2 = this.f13968a;
                        int delete = sQLiteDatabase2.delete("List", "rowid <= " + j, (String[]) null);
                        this.f13970c = this.f13970c - delete;
                        if (delete == i) {
                            m17235a((Cursor) null);
                            return;
                        }
                        throw new IllegalStateException("Try to delete " + i + ", but deleted " + delete);
                    }
                    throw new IllegalStateException();
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    m17235a(cursor);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                m17235a(cursor);
                throw th;
            }
        }
    }

    public final void clear() {
        this.f13968a.delete("List", "1", (String[]) null);
        this.f13970c = 0;
    }

    public final void close() {
        SQLiteDatabase sQLiteDatabase = this.f13968a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.f13968a = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        close();
        super.finalize();
    }

    public final boolean offer(Object obj) {
        C5241jp.m17607a(obj);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f13969b.mo18607a(byteArrayOutputStream, obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C3168jz.m10439a(byteArrayOutputStream);
            ContentValues contentValues = new ContentValues();
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, byteArray);
            if (this.f13968a.insert("List", (String) null, contentValues) == -1) {
                return false;
            }
            this.f13970c++;
            return true;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable th) {
            C3168jz.m10439a(byteArrayOutputStream);
            throw th;
        }
    }

    public final Object peek() {
        if (this.f13970c > 0) {
            return mo30931a(0);
        }
        return null;
    }

    public final Object poll() {
        if (this.f13970c <= 0) {
            return null;
        }
        Object peek = peek();
        mo30932b(1);
        return peek;
    }

    public final int size() {
        return this.f13970c;
    }

    /* renamed from: a */
    public final Object mo30931a(int i) {
        ByteArrayInputStream byteArrayInputStream;
        if (i < 0 || i >= this.f13970c) {
            throw new IndexOutOfBoundsException();
        }
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f13968a;
            cursor = sQLiteDatabase.rawQuery("SELECT value FROM List ORDER BY rowid LIMIT " + i + ",1", (String[]) null);
            if (cursor.moveToNext()) {
                byteArrayInputStream = new ByteArrayInputStream(cursor.getBlob(0));
                Object b = this.f13969b.mo18608b(byteArrayInputStream);
                C3168jz.m10439a(byteArrayInputStream);
                m17235a(cursor);
                return b;
            }
            throw new NoSuchElementException();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (Throwable th) {
            m17235a(cursor);
            throw th;
        }
    }

    /* renamed from: a */
    private static Cursor m17235a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        cursor.close();
        return null;
    }
}
