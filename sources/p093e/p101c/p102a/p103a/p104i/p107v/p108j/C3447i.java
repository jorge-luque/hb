package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.database.sqlite.SQLiteDatabase;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3464z;

/* renamed from: e.c.a.a.i.v.j.i */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3447i implements C3464z.C3466b {

    /* renamed from: a */
    private final long f9562a;

    /* renamed from: b */
    private final C3406l f9563b;

    private C3447i(long j, C3406l lVar) {
        this.f9562a = j;
        this.f9563b = lVar;
    }

    /* renamed from: a */
    public static C3464z.C3466b m11453a(long j, C3406l lVar) {
        return new C3447i(j, lVar);
    }

    public Object apply(Object obj) {
        return C3464z.m11477a(this.f9562a, this.f9563b, (SQLiteDatabase) obj);
    }
}
