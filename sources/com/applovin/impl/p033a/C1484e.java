package com.applovin.impl.p033a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2032t;

/* renamed from: com.applovin.impl.a.e */
public class C1484e {

    /* renamed from: a */
    private C1485a f4642a;

    /* renamed from: b */
    private Uri f4643b;

    /* renamed from: c */
    private String f4644c;

    /* renamed from: com.applovin.impl.a.e$a */
    public enum C1485a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private C1484e() {
    }

    /* renamed from: a */
    static C1484e m5763a(C2032t tVar, C1484e eVar, C1941j jVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (jVar != null) {
            if (eVar == null) {
                try {
                    eVar = new C1484e();
                } catch (Throwable th) {
                    jVar.mo8602v().mo8743b("VastNonVideoResource", "Error occurred while initializing", th);
                    return null;
                }
            }
            if (eVar.f4643b == null && !C2025o.m7963b(eVar.f4644c)) {
                String a = m5764a(tVar, "StaticResource");
                if (URLUtil.isValidUrl(a)) {
                    eVar.f4643b = Uri.parse(a);
                    eVar.f4642a = C1485a.STATIC;
                    return eVar;
                }
                String a2 = m5764a(tVar, "IFrameResource");
                if (C2025o.m7963b(a2)) {
                    eVar.f4642a = C1485a.IFRAME;
                    if (URLUtil.isValidUrl(a2)) {
                        eVar.f4643b = Uri.parse(a2);
                    } else {
                        eVar.f4644c = a2;
                    }
                    return eVar;
                }
                String a3 = m5764a(tVar, "HTMLResource");
                if (C2025o.m7963b(a3)) {
                    eVar.f4642a = C1485a.HTML;
                    if (URLUtil.isValidUrl(a3)) {
                        eVar.f4643b = Uri.parse(a3);
                    } else {
                        eVar.f4644c = a3;
                    }
                }
            }
            return eVar;
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    private static String m5764a(C2032t tVar, String str) {
        C2032t b = tVar.mo8825b(str);
        if (b != null) {
            return b.mo8828c();
        }
        return null;
    }

    /* renamed from: a */
    public C1485a mo7200a() {
        return this.f4642a;
    }

    /* renamed from: a */
    public void mo7201a(Uri uri) {
        this.f4643b = uri;
    }

    /* renamed from: a */
    public void mo7202a(String str) {
        this.f4644c = str;
    }

    /* renamed from: b */
    public Uri mo7203b() {
        return this.f4643b;
    }

    /* renamed from: c */
    public String mo7204c() {
        return this.f4644c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1484e)) {
            return false;
        }
        C1484e eVar = (C1484e) obj;
        if (this.f4642a != eVar.f4642a) {
            return false;
        }
        Uri uri = this.f4643b;
        if (uri == null ? eVar.f4643b != null : !uri.equals(eVar.f4643b)) {
            return false;
        }
        String str = this.f4644c;
        String str2 = eVar.f4644c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        C1485a aVar = this.f4642a;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Uri uri = this.f4643b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f4644c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f4642a + ", resourceUri=" + this.f4643b + ", resourceContents='" + this.f4644c + '\'' + '}';
    }
}
