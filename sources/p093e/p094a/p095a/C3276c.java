package p093e.p094a.p095a;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: e.a.a.c */
/* compiled from: ActivityPackage */
public class C3276c implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = -35935556512024097L;

    /* renamed from: a */
    private transient int f9105a;

    /* renamed from: b */
    private String f9106b;

    /* renamed from: c */
    private String f9107c;

    /* renamed from: d */
    private Map<String, String> f9108d;

    /* renamed from: e */
    private C3270b f9109e = C3270b.UNKNOWN;

    /* renamed from: f */
    private String f9110f;

    /* renamed from: g */
    private Map<String, String> f9111g;

    /* renamed from: h */
    private Map<String, String> f9112h;

    /* renamed from: i */
    private int f9113i;

    /* renamed from: j */
    private long f9114j;

    /* renamed from: k */
    private long f9115k;

    /* renamed from: l */
    private long f9116l;

    static {
        Class<String> cls = String.class;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("path", cls), new ObjectStreamField("clientSdk", cls), new ObjectStreamField("parameters", Map.class), new ObjectStreamField("activityKind", C3270b.class), new ObjectStreamField("suffix", cls), new ObjectStreamField("callbackParameters", Map.class), new ObjectStreamField("partnerParameters", Map.class)};
    }

    public C3276c(C3270b bVar) {
        this.f9109e = bVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.f9106b = C3268a1.m10830a(readFields, "path", (String) null);
        this.f9107c = C3268a1.m10830a(readFields, "clientSdk", (String) null);
        this.f9108d = (Map) C3268a1.m10826a(readFields, "parameters", null);
        this.f9109e = (C3270b) C3268a1.m10826a(readFields, "activityKind", C3270b.UNKNOWN);
        this.f9110f = C3268a1.m10830a(readFields, "suffix", (String) null);
        this.f9111g = (Map) C3268a1.m10826a(readFields, "callbackParameters", null);
        this.f9112h = (Map) C3268a1.m10826a(readFields, "partnerParameters", null);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    /* renamed from: a */
    public void mo18956a(String str) {
        this.f9107c = str;
    }

    /* renamed from: b */
    public void mo18960b(String str) {
        this.f9106b = str;
    }

    /* renamed from: c */
    public void mo18965c(Map<String, String> map) {
        this.f9112h = map;
    }

    /* renamed from: d */
    public long mo18966d() {
        return this.f9115k;
    }

    /* renamed from: e */
    public String mo18967e() {
        return this.f9107c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || C3276c.class != obj.getClass()) {
            return false;
        }
        C3276c cVar = (C3276c) obj;
        return C3268a1.m10848a(this.f9106b, cVar.f9106b) && C3268a1.m10848a(this.f9107c, cVar.f9107c) && C3268a1.m10847a((Object) this.f9108d, (Object) cVar.f9108d) && C3268a1.m10844a((Enum) this.f9109e, (Enum) cVar.f9109e) && C3268a1.m10848a(this.f9110f, cVar.f9110f) && C3268a1.m10847a((Object) this.f9111g, (Object) cVar.f9111g) && C3268a1.m10847a((Object) this.f9112h, (Object) cVar.f9112h);
    }

    /* renamed from: f */
    public String mo18969f() {
        StringBuilder sb = new StringBuilder();
        sb.append(C3268a1.m10834a("Path:      %s\n", this.f9106b));
        sb.append(C3268a1.m10834a("ClientSdk: %s\n", this.f9107c));
        if (this.f9108d != null) {
            sb.append("Parameters:");
            TreeMap treeMap = new TreeMap(this.f9108d);
            List asList = Arrays.asList(new String[]{"app_secret", "secret_id", "event_callback_id"});
            for (Map.Entry entry : treeMap.entrySet()) {
                String str = (String) entry.getKey();
                if (!asList.contains(str)) {
                    sb.append(C3268a1.m10834a("\n\t%-16s %s", str, entry.getValue()));
                }
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public String mo18970g() {
        return C3268a1.m10834a("Failed to track %s%s", this.f9109e.toString(), this.f9110f);
    }

    /* renamed from: h */
    public long mo18971h() {
        return this.f9116l;
    }

    public int hashCode() {
        if (this.f9105a == 0) {
            this.f9105a = 17;
            int c = (17 * 37) + C3268a1.m10856c(this.f9106b);
            this.f9105a = c;
            int c2 = (c * 37) + C3268a1.m10856c(this.f9107c);
            this.f9105a = c2;
            int a = (c2 * 37) + C3268a1.m10822a((Object) this.f9108d);
            this.f9105a = a;
            int a2 = (a * 37) + C3268a1.m10820a((Enum) this.f9109e);
            this.f9105a = a2;
            int c3 = (a2 * 37) + C3268a1.m10856c(this.f9110f);
            this.f9105a = c3;
            int a3 = (c3 * 37) + C3268a1.m10822a((Object) this.f9111g);
            this.f9105a = a3;
            this.f9105a = (a3 * 37) + C3268a1.m10822a((Object) this.f9112h);
        }
        return this.f9105a;
    }

    /* renamed from: i */
    public Map<String, String> mo18973i() {
        return this.f9108d;
    }

    /* renamed from: j */
    public Map<String, String> mo18974j() {
        return this.f9112h;
    }

    /* renamed from: k */
    public String mo18975k() {
        return this.f9106b;
    }

    /* renamed from: l */
    public int mo18976l() {
        return this.f9113i;
    }

    /* renamed from: m */
    public String mo18977m() {
        return this.f9110f;
    }

    /* renamed from: n */
    public int mo18978n() {
        int i = this.f9113i + 1;
        this.f9113i = i;
        return i;
    }

    public String toString() {
        return C3268a1.m10834a("%s%s", this.f9109e.toString(), this.f9110f);
    }

    /* renamed from: a */
    public void mo18957a(Map<String, String> map) {
        this.f9111g = map;
    }

    /* renamed from: b */
    public void mo18961b(Map<String, String> map) {
        this.f9108d = map;
    }

    /* renamed from: c */
    public void mo18964c(String str) {
        this.f9110f = str;
    }

    /* renamed from: a */
    public C3270b mo18954a() {
        return this.f9109e;
    }

    /* renamed from: b */
    public void mo18959b(long j) {
        this.f9115k = j;
    }

    /* renamed from: c */
    public long mo18962c() {
        return this.f9114j;
    }

    /* renamed from: a */
    public void mo18955a(long j) {
        this.f9114j = j;
    }

    /* renamed from: b */
    public Map<String, String> mo18958b() {
        return this.f9111g;
    }

    /* renamed from: c */
    public void mo18963c(long j) {
        this.f9116l = j;
    }
}
