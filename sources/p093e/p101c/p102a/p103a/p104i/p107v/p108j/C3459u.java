package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.database.sqlite.SQLiteDatabase;
import p093e.p101c.p102a.p103a.p104i.C3400h;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3464z;

/* renamed from: e.c.a.a.i.v.j.u */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3459u implements C3464z.C3466b {

    /* renamed from: a */
    private final C3464z f9577a;

    /* renamed from: b */
    private final C3406l f9578b;

    /* renamed from: c */
    private final C3400h f9579c;

    private C3459u(C3464z zVar, C3406l lVar, C3400h hVar) {
        this.f9577a = zVar;
        this.f9578b = lVar;
        this.f9579c = hVar;
    }

    /* renamed from: a */
    public static C3464z.C3466b m11467a(C3464z zVar, C3406l lVar, C3400h hVar) {
        return new C3459u(zVar, lVar, hVar);
    }

    public Object apply(Object obj) {
        return C3464z.m11476a(this.f9577a, this.f9578b, this.f9579c, (SQLiteDatabase) obj);
    }
}
