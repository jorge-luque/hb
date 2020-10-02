package p163cz.msebera.android.httpclient.impl.cookie;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p163cz.msebera.android.httpclient.cookie.C5677a;
import p163cz.msebera.android.httpclient.cookie.C5690m;
import p163cz.msebera.android.httpclient.p187k0.C5886a;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.d */
/* compiled from: BasicClientCookie */
public class C5840d implements C5690m, C5677a, Cloneable, Serializable {
    private static final long serialVersionUID = -3869795591041535538L;

    /* renamed from: a */
    private final String f15072a;

    /* renamed from: b */
    private Map<String, String> f15073b = new HashMap();

    /* renamed from: c */
    private String f15074c;

    /* renamed from: d */
    private String f15075d;

    /* renamed from: e */
    private Date f15076e;

    /* renamed from: f */
    private String f15077f;

    /* renamed from: g */
    private boolean f15078g;

    /* renamed from: h */
    private int f15079h;

    public C5840d(String str, String str2) {
        C5886a.m18894a(str, "Name");
        this.f15072a = str;
        this.f15074c = str2;
    }

    /* renamed from: B */
    public boolean mo33122B() {
        return this.f15078g;
    }

    /* renamed from: a */
    public void mo33157a(Date date) {
        this.f15076e = date;
    }

    /* renamed from: a */
    public int[] mo33123a() {
        return null;
    }

    /* renamed from: b */
    public Date mo33124b() {
        return this.f15076e;
    }

    /* renamed from: c */
    public String mo33126c() {
        return this.f15077f;
    }

    public Object clone() throws CloneNotSupportedException {
        C5840d dVar = (C5840d) super.clone();
        dVar.f15073b = new HashMap(this.f15073b);
        return dVar;
    }

    /* renamed from: d */
    public String mo33127d() {
        return this.f15075d;
    }

    /* renamed from: d */
    public void mo33160d(String str) {
    }

    /* renamed from: f */
    public void mo33161f(String str) {
        if (str != null) {
            this.f15075d = str.toLowerCase(Locale.ROOT);
        } else {
            this.f15075d = null;
        }
    }

    public String getName() {
        return this.f15072a;
    }

    public String getValue() {
        return this.f15074c;
    }

    public int getVersion() {
        return this.f15079h;
    }

    public String toString() {
        return "[version: " + Integer.toString(this.f15079h) + "]" + "[name: " + this.f15072a + "]" + "[value: " + this.f15074c + "]" + "[domain: " + this.f15075d + "]" + "[path: " + this.f15077f + "]" + "[expiry: " + this.f15076e + "]";
    }

    /* renamed from: a */
    public void mo33158a(boolean z) {
        this.f15078g = z;
    }

    /* renamed from: b */
    public void mo33159b(String str) {
        this.f15077f = str;
    }

    /* renamed from: c */
    public boolean mo33120c(String str) {
        return this.f15073b.containsKey(str);
    }

    /* renamed from: a */
    public void mo33156a(int i) {
        this.f15079h = i;
    }

    /* renamed from: b */
    public boolean mo33125b(Date date) {
        C5886a.m18894a(date, "Date");
        Date date2 = this.f15076e;
        return date2 != null && date2.getTime() <= date.getTime();
    }

    /* renamed from: a */
    public void mo33616a(String str, String str2) {
        this.f15073b.put(str, str2);
    }

    /* renamed from: a */
    public String mo33119a(String str) {
        return this.f15073b.get(str);
    }
}
