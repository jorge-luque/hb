package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.database.Cursor;
import java.util.List;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3464z;

/* renamed from: e.c.a.a.i.v.j.m */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3451m implements C3464z.C3466b {

    /* renamed from: a */
    private final List f9568a;

    /* renamed from: b */
    private final C3406l f9569b;

    private C3451m(List list, C3406l lVar) {
        this.f9568a = list;
        this.f9569b = lVar;
    }

    /* renamed from: a */
    public static C3464z.C3466b m11457a(List list, C3406l lVar) {
        return new C3451m(list, lVar);
    }

    public Object apply(Object obj) {
        return C3464z.m11483a(this.f9568a, this.f9569b, (Cursor) obj);
    }
}
