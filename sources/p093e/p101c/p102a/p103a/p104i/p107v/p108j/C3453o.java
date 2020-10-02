package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.database.sqlite.SQLiteDatabase;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3464z;

/* renamed from: e.c.a.a.i.v.j.o */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3453o implements C3464z.C3468d {

    /* renamed from: a */
    private final SQLiteDatabase f9571a;

    private C3453o(SQLiteDatabase sQLiteDatabase) {
        this.f9571a = sQLiteDatabase;
    }

    /* renamed from: a */
    public static C3464z.C3468d m11459a(SQLiteDatabase sQLiteDatabase) {
        return new C3453o(sQLiteDatabase);
    }

    /* renamed from: a */
    public Object mo19254a() {
        return this.f9571a.beginTransaction();
    }
}
