package androidx.core.p016c;

import android.util.Base64;
import androidx.core.p019e.C0795h;
import java.util.List;

/* renamed from: androidx.core.c.a */
/* compiled from: FontRequest */
public final class C0751a {

    /* renamed from: a */
    private final String f1910a;

    /* renamed from: b */
    private final String f1911b;

    /* renamed from: c */
    private final String f1912c;

    /* renamed from: d */
    private final List<List<byte[]>> f1913d;

    /* renamed from: e */
    private final int f1914e = 0;

    /* renamed from: f */
    private final String f1915f = (this.f1910a + "-" + this.f1911b + "-" + this.f1912c);

    public C0751a(String str, String str2, String str3, List<List<byte[]>> list) {
        C0795h.m2503a(str);
        this.f1910a = str;
        C0795h.m2503a(str2);
        this.f1911b = str2;
        C0795h.m2503a(str3);
        this.f1912c = str3;
        C0795h.m2503a(list);
        this.f1913d = list;
    }

    /* renamed from: a */
    public List<List<byte[]>> mo3984a() {
        return this.f1913d;
    }

    /* renamed from: b */
    public int mo3985b() {
        return this.f1914e;
    }

    /* renamed from: c */
    public String mo3986c() {
        return this.f1915f;
    }

    /* renamed from: d */
    public String mo3987d() {
        return this.f1910a;
    }

    /* renamed from: e */
    public String mo3988e() {
        return this.f1911b;
    }

    /* renamed from: f */
    public String mo3989f() {
        return this.f1912c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1910a + ", mProviderPackage: " + this.f1911b + ", mQuery: " + this.f1912c + ", mCertificates:");
        for (int i = 0; i < this.f1913d.size(); i++) {
            sb.append(" [");
            List list = this.f1913d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1914e);
        return sb.toString();
    }
}
