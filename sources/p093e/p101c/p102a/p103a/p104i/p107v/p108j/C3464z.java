package p093e.p101c.p102a.p103a.p104i.p107v.p108j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.datatransport.runtime.synchronization.C3031a;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import p093e.p101c.p102a.p103a.C3378b;
import p093e.p101c.p102a.p103a.p104i.C3399g;
import p093e.p101c.p102a.p103a.p104i.C3400h;
import p093e.p101c.p102a.p103a.p104i.C3406l;
import p093e.p101c.p102a.p103a.p104i.p105t.C3416a;
import p093e.p101c.p102a.p103a.p104i.p109w.C3469a;
import p093e.p101c.p102a.p103a.p104i.p110x.C3475a;

/* renamed from: e.c.a.a.i.v.j.z */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class C3464z implements C3435c, C3031a {

    /* renamed from: e */
    private static final C3378b f9585e = C3378b.m11260a("proto");

    /* renamed from: a */
    private final C3441e0 f9586a;

    /* renamed from: b */
    private final C3469a f9587b;

    /* renamed from: c */
    private final C3469a f9588c;

    /* renamed from: d */
    private final C3437d f9589d;

    /* renamed from: e.c.a.a.i.v.j.z$b */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    interface C3466b<T, U> {
        U apply(T t);
    }

    /* renamed from: e.c.a.a.i.v.j.z$c */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    private static class C3467c {

        /* renamed from: a */
        final String f9590a;

        /* renamed from: b */
        final String f9591b;

        private C3467c(String str, String str2) {
            this.f9590a = str;
            this.f9591b = str2;
        }
    }

    /* renamed from: e.c.a.a.i.v.j.z$d */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    interface C3468d<T> {
        /* renamed from: a */
        T mo19254a();
    }

    C3464z(C3469a aVar, C3469a aVar2, C3437d dVar, C3441e0 e0Var) {
        this.f9586a = e0Var;
        this.f9587b = aVar;
        this.f9588c = aVar2;
        this.f9589d = dVar;
    }

    /* renamed from: b */
    static /* synthetic */ SQLiteDatabase m11489b(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    /* renamed from: c */
    private static String m11495c(Iterable<C3446h> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<C3446h> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().mo19233b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: d */
    private SQLiteDatabase m11499d() {
        C3441e0 e0Var = this.f9586a;
        e0Var.getClass();
        return (SQLiteDatabase) m11480a(C3456r.m11463a(e0Var), C3458t.m11466a());
    }

    /* renamed from: t */
    private long m11500t() {
        return m11499d().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    /* renamed from: u */
    private long m11501u() {
        return m11499d().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    /* renamed from: v */
    private boolean m11502v() {
        return m11500t() * m11501u() >= this.f9589d.mo19223d();
    }

    /* renamed from: E */
    public int mo19239E() {
        return ((Integer) m11479a(C3450l.m11456a(this.f9587b.mo19256a() - this.f9589d.mo19221b()))).intValue();
    }

    /* renamed from: I */
    public Iterable<C3406l> mo19240I() {
        return (Iterable) m11479a(C3449k.m11455a());
    }

    /* renamed from: a */
    public C3446h mo19241a(C3406l lVar, C3400h hVar) {
        C3416a.m11381a("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", lVar.mo19186c(), hVar.mo19158f(), lVar.mo19184a());
        long longValue = ((Long) m11479a(C3459u.m11467a(this, lVar, hVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return C3446h.m11449a(longValue, lVar, hVar);
    }

    public void close() {
        this.f9586a.close();
    }

    /* renamed from: b */
    private Long m11491b(SQLiteDatabase sQLiteDatabase, C3406l lVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{lVar.mo19184a(), String.valueOf(C3475a.m11523a(lVar.mo19186c()))}));
        if (lVar.mo19185b() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(lVar.mo19185b(), 0));
        }
        return (Long) m11478a(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), C3460v.m11468a());
    }

    /* renamed from: a */
    static /* synthetic */ Long m11476a(C3464z zVar, C3406l lVar, C3400h hVar, SQLiteDatabase sQLiteDatabase) {
        if (zVar.m11502v()) {
            return -1L;
        }
        long a = zVar.m11472a(sQLiteDatabase, lVar);
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(a));
        contentValues.put("transport_name", hVar.mo19158f());
        contentValues.put("timestamp_ms", Long.valueOf(hVar.mo19156d()));
        contentValues.put("uptime_ms", Long.valueOf(hVar.mo19159g()));
        contentValues.put("payload_encoding", hVar.mo19155c().mo19198b().mo19145a());
        contentValues.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, hVar.mo19155c().mo19197a());
        contentValues.put("code", hVar.mo19154b());
        contentValues.put("num_attempts", 0);
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues);
        for (Map.Entry next : hVar.mo19205e().entrySet()) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("event_id", Long.valueOf(insert));
            contentValues2.put("name", (String) next.getKey());
            contentValues2.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues2);
        }
        return Long.valueOf(insert);
    }

    /* renamed from: c */
    public boolean mo19247c(C3406l lVar) {
        return ((Boolean) m11479a(C3463y.m11471a(this, lVar))).booleanValue();
    }

    /* renamed from: c */
    static /* synthetic */ List m11497c(SQLiteDatabase sQLiteDatabase) {
        return (List) m11478a(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), C3455q.m11462a());
    }

    /* renamed from: c */
    static /* synthetic */ List m11496c(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            C3406l.C3407a d = C3406l.m11350d();
            d.mo19190a(cursor.getString(1));
            d.mo19189a(C3475a.m11524a(cursor.getInt(2)));
            d.mo19191a(m11488a(cursor.getString(3)));
            arrayList.add(d.mo19192a());
        }
        return arrayList;
    }

    /* renamed from: b */
    static /* synthetic */ Long m11490b(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* renamed from: b */
    public void mo19246b(Iterable<C3446h> iterable) {
        if (iterable.iterator().hasNext()) {
            m11479a(C3461w.m11469a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + m11495c(iterable)));
        }
    }

    /* renamed from: c */
    private List<C3446h> m11498c(SQLiteDatabase sQLiteDatabase, C3406l lVar) {
        ArrayList arrayList = new ArrayList();
        Long b = m11491b(sQLiteDatabase, lVar);
        if (b == null) {
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        m11478a(sQLiteDatabase2.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "code"}, "context_id = ?", new String[]{b.toString()}, (String) null, (String) null, (String) null, String.valueOf(this.f9589d.mo19222c())), C3451m.m11457a(arrayList, lVar));
        return arrayList;
    }

    /* renamed from: b */
    public long mo19245b(C3406l lVar) {
        return ((Long) m11478a(m11499d().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{lVar.mo19184a(), String.valueOf(C3475a.m11523a(lVar.mo19186c()))}), C3462x.m11470a())).longValue();
    }

    /* renamed from: b */
    static /* synthetic */ List m11493b(C3464z zVar, C3406l lVar, SQLiteDatabase sQLiteDatabase) {
        List<C3446h> c = zVar.m11498c(sQLiteDatabase, lVar);
        zVar.m11485a(c, zVar.m11486a(sQLiteDatabase, c));
        return c;
    }

    /* renamed from: c */
    private static C3378b m11494c(String str) {
        if (str == null) {
            return f9585e;
        }
        return C3378b.m11260a(str);
    }

    /* renamed from: a */
    private long m11472a(SQLiteDatabase sQLiteDatabase, C3406l lVar) {
        Long b = m11491b(sQLiteDatabase, lVar);
        if (b != null) {
            return b.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", lVar.mo19184a());
        contentValues.put("priority", Integer.valueOf(C3475a.m11523a(lVar.mo19186c())));
        contentValues.put("next_request_ms", 0);
        if (lVar.mo19185b() != null) {
            contentValues.put("extras", Base64.encodeToString(lVar.mo19185b(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
    }

    /* renamed from: a */
    static /* synthetic */ Object m11481a(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 10").execute();
        return null;
    }

    /* renamed from: a */
    public void mo19244a(Iterable<C3446h> iterable) {
        if (iterable.iterator().hasNext()) {
            m11499d().compileStatement("DELETE FROM events WHERE _id in " + m11495c(iterable)).execute();
        }
    }

    /* renamed from: a */
    static /* synthetic */ Long m11475a(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m11473a(C3464z zVar, C3406l lVar, SQLiteDatabase sQLiteDatabase) {
        Long b = zVar.m11491b(sQLiteDatabase, lVar);
        if (b == null) {
            return false;
        }
        return (Boolean) m11478a(zVar.m11499d().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{b.toString()}), C3457s.m11465a());
    }

    /* renamed from: a */
    public void mo19243a(C3406l lVar, long j) {
        m11479a(C3447i.m11453a(j, lVar));
    }

    /* renamed from: a */
    static /* synthetic */ Object m11477a(long j, C3406l lVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{lVar.mo19184a(), String.valueOf(C3475a.m11523a(lVar.mo19186c()))}) < 1) {
            contentValues.put("backend_name", lVar.mo19184a());
            contentValues.put("priority", Integer.valueOf(C3475a.m11523a(lVar.mo19186c())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    /* renamed from: a */
    public Iterable<C3446h> mo19242a(C3406l lVar) {
        return (Iterable) m11479a(C3448j.m11454a(this, lVar));
    }

    /* renamed from: a */
    private static byte[] m11488a(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    /* renamed from: a */
    static /* synthetic */ Object m11483a(List list, C3406l lVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            C3400h.C3401a i = C3400h.m11311i();
            i.mo19165a(cursor.getString(1));
            i.mo19162a(cursor.getLong(2));
            i.mo19168b(cursor.getLong(3));
            i.mo19163a(new C3399g(m11494c(cursor.getString(4)), cursor.getBlob(5)));
            if (!cursor.isNull(6)) {
                i.mo19164a(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(C3446h.m11449a(j, lVar, i.mo19167a()));
        }
        return null;
    }

    /* renamed from: a */
    private Map<Long, Set<C3467c>> m11486a(SQLiteDatabase sQLiteDatabase, List<C3446h> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).mo19233b());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        m11478a(sQLiteDatabase2.query("event_metadata", new String[]{"event_id", "name", AppMeasurementSdk.ConditionalUserProperty.VALUE}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), C3452n.m11458a(hashMap));
        return hashMap;
    }

    /* renamed from: a */
    static /* synthetic */ Object m11484a(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new C3467c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    /* renamed from: a */
    private List<C3446h> m11485a(List<C3446h> list, Map<Long, Set<C3467c>> map) {
        ListIterator<C3446h> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            C3446h next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.mo19233b()))) {
                C3400h.C3401a h = next.mo19232a().mo19206h();
                for (C3467c cVar : map.get(Long.valueOf(next.mo19233b()))) {
                    h.mo19209a(cVar.f9590a, cVar.f9591b);
                }
                listIterator.set(C3446h.m11449a(next.mo19233b(), next.mo19234c(), h.mo19167a()));
            }
        }
        return list;
    }

    /* renamed from: a */
    private <T> T m11480a(C3468d<T> dVar, C3466b<Throwable, T> bVar) {
        long a = this.f9588c.mo19256a();
        while (true) {
            try {
                return dVar.mo19254a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.f9588c.mo19256a() >= ((long) this.f9589d.mo19220a()) + a) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50);
            }
        }
    }

    /* renamed from: a */
    private void m11487a(SQLiteDatabase sQLiteDatabase) {
        m11480a(C3453o.m11459a(sQLiteDatabase), C3454p.m11461a());
    }

    /* renamed from: a */
    static /* synthetic */ Object m11482a(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* renamed from: a */
    public <T> T mo13006a(C3031a.C3032a<T> aVar) {
        SQLiteDatabase d = m11499d();
        m11487a(d);
        try {
            T execute = aVar.execute();
            d.setTransactionSuccessful();
            return execute;
        } finally {
            d.endTransaction();
        }
    }

    /* renamed from: a */
    private <T> T m11479a(C3466b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase d = m11499d();
        d.beginTransaction();
        try {
            T apply = bVar.apply(d);
            d.setTransactionSuccessful();
            return apply;
        } finally {
            d.endTransaction();
        }
    }

    /* renamed from: a */
    private static <T> T m11478a(Cursor cursor, C3466b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }
}
