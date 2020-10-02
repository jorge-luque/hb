package p113i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import p113i.p114e0.C3500c;

/* renamed from: i.r */
/* compiled from: Headers */
public final class C3537r {

    /* renamed from: a */
    private final String[] f9855a;

    C3537r(C3538a aVar) {
        List<String> list = aVar.f9856a;
        this.f9855a = (String[]) list.toArray(new String[list.size()]);
    }

    /* renamed from: c */
    static void m11833c(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(C3500c.m11639a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }

    @Nullable
    /* renamed from: a */
    public String mo19502a(String str) {
        return m11831a(this.f9855a, str);
    }

    /* renamed from: b */
    public int mo19503b() {
        return this.f9855a.length / 2;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C3537r) && Arrays.equals(((C3537r) obj).f9855a, this.f9855a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f9855a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b = mo19503b();
        for (int i = 0; i < b; i++) {
            sb.append(mo19501a(i));
            sb.append(": ");
            sb.append(mo19504b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: i.r$a */
    /* compiled from: Headers */
    public static final class C3538a {

        /* renamed from: a */
        final List<String> f9856a = new ArrayList(20);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C3538a mo19509a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                mo19512b(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            } else if (str.startsWith(":")) {
                mo19512b("", str.substring(1));
                return this;
            } else {
                mo19512b("", str);
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C3538a mo19512b(String str, String str2) {
            this.f9856a.add(str);
            this.f9856a.add(str2.trim());
            return this;
        }

        /* renamed from: c */
        public C3538a mo19514c(String str) {
            int i = 0;
            while (i < this.f9856a.size()) {
                if (str.equalsIgnoreCase(this.f9856a.get(i))) {
                    this.f9856a.remove(i);
                    this.f9856a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: b */
        public String mo19513b(String str) {
            for (int size = this.f9856a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f9856a.get(size))) {
                    return this.f9856a.get(size + 1);
                }
            }
            return null;
        }

        /* renamed from: c */
        public C3538a mo19515c(String str, String str2) {
            C3537r.m11833c(str);
            C3537r.m11832a(str2, str);
            mo19514c(str);
            mo19512b(str, str2);
            return this;
        }

        /* renamed from: a */
        public C3538a mo19510a(String str, String str2) {
            C3537r.m11833c(str);
            C3537r.m11832a(str2, str);
            mo19512b(str, str2);
            return this;
        }

        /* renamed from: a */
        public C3537r mo19511a() {
            return new C3537r(this);
        }
    }

    /* renamed from: a */
    public String mo19501a(int i) {
        return this.f9855a[i * 2];
    }

    /* renamed from: b */
    public String mo19504b(int i) {
        return this.f9855a[(i * 2) + 1];
    }

    /* renamed from: a */
    public C3538a mo19500a() {
        C3538a aVar = new C3538a();
        Collections.addAll(aVar.f9856a, this.f9855a);
        return aVar;
    }

    /* renamed from: b */
    public List<String> mo19505b(String str) {
        int b = mo19503b();
        ArrayList arrayList = null;
        for (int i = 0; i < b; i++) {
            if (str.equalsIgnoreCase(mo19501a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(mo19504b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    private static String m11831a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    static void m11832a(String str, String str2) {
        if (str != null) {
            int length = str.length();
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i++;
                } else {
                    throw new IllegalArgumentException(C3500c.m11639a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }
}
