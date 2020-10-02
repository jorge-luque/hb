package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.database.sqlite.SQLiteDatabase;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3441e0;

/* renamed from: e.c.a.a.i.v.j.d0 */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3439d0 implements C3441e0.C3442a {

    /* renamed from: a */
    private static final C3439d0 f9550a = new C3439d0();

    private C3439d0() {
    }

    /* renamed from: a */
    public static C3441e0.C3442a m11434a() {
        return f9550a;
    }

    /* renamed from: a */
    public void mo19238a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
