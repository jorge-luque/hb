package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.database.sqlite.SQLiteDatabase;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3464z;

/* renamed from: e.c.a.a.i.v.j.j */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3448j implements C3464z.C3466b {

    /* renamed from: a */
    private final C3464z f9564a;

    /* renamed from: b */
    private final C3406l f9565b;

    private C3448j(C3464z zVar, C3406l lVar) {
        this.f9564a = zVar;
        this.f9565b = lVar;
    }

    /* renamed from: a */
    public static C3464z.C3466b m11454a(C3464z zVar, C3406l lVar) {
        return new C3448j(zVar, lVar);
    }

    public Object apply(Object obj) {
        return C3464z.m11493b(this.f9564a, this.f9565b, (SQLiteDatabase) obj);
    }
}
