package p093e.p094a.p095a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;

/* renamed from: e.a.a.d */
/* compiled from: ActivityState */
public class C3294d implements Serializable, Cloneable {
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 9039439291143138148L;

    /* renamed from: a */
    protected String f9146a = C3268a1.m10827a();

    /* renamed from: b */
    protected boolean f9147b = true;

    /* renamed from: c */
    protected boolean f9148c = false;

    /* renamed from: d */
    protected boolean f9149d = false;

    /* renamed from: e */
    protected int f9150e = 0;

    /* renamed from: f */
    protected int f9151f = 0;

    /* renamed from: g */
    protected int f9152g = -1;

    /* renamed from: h */
    protected long f9153h = -1;

    /* renamed from: i */
    protected long f9154i = -1;

    /* renamed from: j */
    protected long f9155j = -1;

    /* renamed from: k */
    protected long f9156k = -1;

    /* renamed from: l */
    protected boolean f9157l = false;

    /* renamed from: m */
    protected LinkedList<String> f9158m = null;

    /* renamed from: n */
    protected String f9159n = null;

    /* renamed from: o */
    protected String f9160o = null;

    /* renamed from: p */
    protected long f9161p = 0;

    /* renamed from: q */
    protected long f9162q = 0;

    /* renamed from: r */
    protected String f9163r = null;

    static {
        Class<String> cls = String.class;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("uuid", cls), new ObjectStreamField("enabled", Boolean.TYPE), new ObjectStreamField("isGdprForgotten", Boolean.TYPE), new ObjectStreamField("askingAttribution", Boolean.TYPE), new ObjectStreamField("eventCount", Integer.TYPE), new ObjectStreamField("sessionCount", Integer.TYPE), new ObjectStreamField("subsessionCount", Integer.TYPE), new ObjectStreamField("sessionLength", Long.TYPE), new ObjectStreamField("timeSpent", Long.TYPE), new ObjectStreamField("lastActivity", Long.TYPE), new ObjectStreamField("lastInterval", Long.TYPE), new ObjectStreamField("updatePackages", Boolean.TYPE), new ObjectStreamField("orderIds", LinkedList.class), new ObjectStreamField("pushToken", cls), new ObjectStreamField("adid", cls), new ObjectStreamField("clickTime", Long.TYPE), new ObjectStreamField("installBegin", Long.TYPE), new ObjectStreamField("installReferrer", cls)};
    }

    protected C3294d() {
        C3309k.m11002d();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.f9150e = C3268a1.m10818a(readFields, "eventCount", 0);
        this.f9151f = C3268a1.m10818a(readFields, "sessionCount", 0);
        this.f9152g = C3268a1.m10818a(readFields, "subsessionCount", -1);
        this.f9153h = C3268a1.m10824a(readFields, "sessionLength", -1);
        this.f9154i = C3268a1.m10824a(readFields, "timeSpent", -1);
        this.f9155j = C3268a1.m10824a(readFields, "lastActivity", -1);
        this.f9156k = C3268a1.m10824a(readFields, "lastInterval", -1);
        this.f9146a = C3268a1.m10830a(readFields, "uuid", (String) null);
        this.f9147b = C3268a1.m10842a(readFields, "enabled", true);
        this.f9148c = C3268a1.m10842a(readFields, "isGdprForgotten", false);
        this.f9149d = C3268a1.m10842a(readFields, "askingAttribution", false);
        this.f9157l = C3268a1.m10842a(readFields, "updatePackages", false);
        this.f9158m = (LinkedList) C3268a1.m10826a(readFields, "orderIds", null);
        this.f9159n = C3268a1.m10830a(readFields, "pushToken", (String) null);
        this.f9160o = C3268a1.m10830a(readFields, "adid", (String) null);
        this.f9161p = C3268a1.m10824a(readFields, "clickTime", -1);
        this.f9162q = C3268a1.m10824a(readFields, "installBegin", -1);
        this.f9163r = C3268a1.m10830a(readFields, "installReferrer", (String) null);
        if (this.f9146a == null) {
            this.f9146a = C3268a1.m10827a();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19003a(long j) {
        this.f9152g = 1;
        this.f9153h = 0;
        this.f9154i = 0;
        this.f9155j = j;
        this.f9156k = -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo19005b(String str) {
        LinkedList<String> linkedList = this.f9158m;
        if (linkedList == null) {
            return false;
        }
        return linkedList.contains(str);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || C3294d.class != obj.getClass()) {
            return false;
        }
        C3294d dVar = (C3294d) obj;
        return C3268a1.m10848a(this.f9146a, dVar.f9146a) && C3268a1.m10843a(Boolean.valueOf(this.f9147b), Boolean.valueOf(dVar.f9147b)) && C3268a1.m10843a(Boolean.valueOf(this.f9148c), Boolean.valueOf(dVar.f9148c)) && C3268a1.m10843a(Boolean.valueOf(this.f9149d), Boolean.valueOf(dVar.f9149d)) && C3268a1.m10845a(Integer.valueOf(this.f9150e), Integer.valueOf(dVar.f9150e)) && C3268a1.m10845a(Integer.valueOf(this.f9151f), Integer.valueOf(dVar.f9151f)) && C3268a1.m10845a(Integer.valueOf(this.f9152g), Integer.valueOf(dVar.f9152g)) && C3268a1.m10846a(Long.valueOf(this.f9153h), Long.valueOf(dVar.f9153h)) && C3268a1.m10846a(Long.valueOf(this.f9154i), Long.valueOf(dVar.f9154i)) && C3268a1.m10846a(Long.valueOf(this.f9156k), Long.valueOf(dVar.f9156k)) && C3268a1.m10843a(Boolean.valueOf(this.f9157l), Boolean.valueOf(dVar.f9157l)) && C3268a1.m10847a((Object) this.f9158m, (Object) dVar.f9158m) && C3268a1.m10848a(this.f9159n, dVar.f9159n) && C3268a1.m10848a(this.f9160o, dVar.f9160o) && C3268a1.m10846a(Long.valueOf(this.f9161p), Long.valueOf(dVar.f9161p)) && C3268a1.m10846a(Long.valueOf(this.f9162q), Long.valueOf(dVar.f9162q)) && C3268a1.m10848a(this.f9163r, dVar.f9163r);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((629 + C3268a1.m10856c(this.f9146a)) * 37) + C3268a1.m10819a(Boolean.valueOf(this.f9147b))) * 37) + C3268a1.m10819a(Boolean.valueOf(this.f9148c))) * 37) + C3268a1.m10819a(Boolean.valueOf(this.f9149d))) * 37) + this.f9150e) * 37) + this.f9151f) * 37) + this.f9152g) * 37) + C3268a1.m10821a(Long.valueOf(this.f9153h))) * 37) + C3268a1.m10821a(Long.valueOf(this.f9154i))) * 37) + C3268a1.m10821a(Long.valueOf(this.f9156k))) * 37) + C3268a1.m10819a(Boolean.valueOf(this.f9157l))) * 37) + C3268a1.m10822a((Object) this.f9158m)) * 37) + C3268a1.m10856c(this.f9159n)) * 37) + C3268a1.m10856c(this.f9160o)) * 37) + C3268a1.m10821a(Long.valueOf(this.f9161p))) * 37) + C3268a1.m10821a(Long.valueOf(this.f9162q))) * 37) + C3268a1.m10856c(this.f9163r);
    }

    public String toString() {
        double d = (double) this.f9153h;
        Double.isNaN(d);
        double d2 = (double) this.f9154i;
        Double.isNaN(d2);
        return C3268a1.m10834a("ec:%d sc:%d ssc:%d sl:%.1f ts:%.1f la:%s uuid:%s", Integer.valueOf(this.f9150e), Integer.valueOf(this.f9151f), Integer.valueOf(this.f9152g), Double.valueOf(d / 1000.0d), Double.valueOf(d2 / 1000.0d), m10938b(this.f9155j), this.f9146a);
    }

    /* renamed from: b */
    private static String m10938b(long j) {
        Calendar.getInstance().setTimeInMillis(j);
        return C3268a1.m10834a("%02d:%02d:%02d", 11, 12, 13);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19004a(String str) {
        if (this.f9158m == null) {
            this.f9158m = new LinkedList<>();
        }
        if (this.f9158m.size() >= 10) {
            this.f9158m.removeLast();
        }
        this.f9158m.addFirst(str);
    }
}
