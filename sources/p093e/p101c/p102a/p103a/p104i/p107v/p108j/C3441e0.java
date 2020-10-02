package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* renamed from: e.c.a.a.i.v.j.e0 */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final class C3441e0 extends SQLiteOpenHelper {

    /* renamed from: c */
    static int f9551c = 3;

    /* renamed from: d */
    private static final C3442a f9552d = C3434b0.m11411a();

    /* renamed from: e */
    private static final C3442a f9553e = C3436c0.m11422a();

    /* renamed from: f */
    private static final C3442a f9554f;

    /* renamed from: g */
    private static final List<C3442a> f9555g;

    /* renamed from: a */
    private final int f9556a;

    /* renamed from: b */
    private boolean f9557b = false;

    /* renamed from: e.c.a.a.i.v.j.e0$a */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public interface C3442a {
        /* renamed from: a */
        void mo19238a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        C3442a a = C3439d0.m11434a();
        f9554f = a;
        f9555g = Arrays.asList(new C3442a[]{f9552d, f9553e, a});
    }

    C3441e0(Context context, int i) {
        super(context, "com.google.android.datatransport.events", (SQLiteDatabase.CursorFactory) null, i);
        this.f9556a = i;
    }

    /* renamed from: a */
    private void m11438a(SQLiteDatabase sQLiteDatabase) {
        if (!this.f9557b) {
            onConfigure(sQLiteDatabase);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m11440b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    /* renamed from: c */
    static /* synthetic */ void m11441c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f9557b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        if (Build.VERSION.SDK_INT >= 16) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m11438a(sQLiteDatabase);
        m11439a(sQLiteDatabase, 0, this.f9556a);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        onCreate(sQLiteDatabase);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        m11438a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m11438a(sQLiteDatabase);
        m11439a(sQLiteDatabase, i, i2);
    }

    /* renamed from: a */
    private void m11439a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i2 <= f9555g.size()) {
            while (i < i2) {
                f9555g.get(i).mo19238a(sQLiteDatabase);
                i++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i + " to " + i2 + " was requested, but cannot be performed. Only " + f9555g.size() + " migrations are provided");
    }
}
