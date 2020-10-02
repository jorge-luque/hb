package admost.adserver.videocache.p003s;

import admost.adserver.videocache.C0077k;
import admost.adserver.videocache.C0083o;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: admost.adserver.videocache.s.a */
/* compiled from: DatabaseSourceInfoStorage */
class C0097a extends SQLiteOpenHelper implements C0099c {

    /* renamed from: a */
    private static final String[] f242a = {"_id", "url", "length", "mime"};

    C0097a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        C0077k.m231a(context);
    }

    /* renamed from: a */
    public void mo156a(String str, C0083o oVar) {
        C0077k.m235a(str, oVar);
        boolean z = get(str) != null;
        ContentValues a = m287a(oVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", a, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", (String) null, a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public admost.adserver.videocache.C0083o get(java.lang.String r11) {
        /*
            r10 = this;
            admost.adserver.videocache.C0077k.m231a(r11)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "SourceInfo"
            java.lang.String[] r3 = f242a     // Catch:{ all -> 0x0031 }
            java.lang.String r4 = "url=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0031 }
            r6 = 0
            r5[r6] = r11     // Catch:{ all -> 0x0031 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0031 }
            if (r11 == 0) goto L_0x002b
            boolean r1 = r11.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0024
            goto L_0x002b
        L_0x0024:
            admost.adserver.videocache.o r0 = r10.m286a((android.database.Cursor) r11)     // Catch:{ all -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            r0 = move-exception
            goto L_0x0035
        L_0x002b:
            if (r11 == 0) goto L_0x0030
            r11.close()
        L_0x0030:
            return r0
        L_0x0031:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x0035:
            if (r11 == 0) goto L_0x003a
            r11.close()
        L_0x003a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: admost.adserver.videocache.p003s.C0097a.get(java.lang.String):admost.adserver.videocache.o");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C0077k.m231a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    public void release() {
        close();
    }

    /* renamed from: a */
    private C0083o m286a(Cursor cursor) {
        return new C0083o(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    /* renamed from: a */
    private ContentValues m287a(C0083o oVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", oVar.f232a);
        contentValues.put("length", Long.valueOf(oVar.f233b));
        contentValues.put("mime", oVar.f234c);
        return contentValues;
    }
}
