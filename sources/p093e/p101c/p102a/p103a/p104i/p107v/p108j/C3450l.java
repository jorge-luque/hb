package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.database.sqlite.SQLiteDatabase;
import p093e.p101c.p102a.p103a.p104i.p107v.p108j.C3464z;

/* renamed from: e.c.a.a.i.v.j.l */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
final /* synthetic */ class C3450l implements C3464z.C3466b {

    /* renamed from: a */
    private final long f9567a;

    private C3450l(long j) {
        this.f9567a = j;
    }

    /* renamed from: a */
    public static C3464z.C3466b m11456a(long j) {
        return new C3450l(j);
    }

    public Object apply(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f9567a)}));
    }
}
