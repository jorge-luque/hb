package com.applovin.impl.p033a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2032t;
import java.util.Locale;

/* renamed from: com.applovin.impl.a.k */
public class C1493k {

    /* renamed from: a */
    private Uri f4672a;

    /* renamed from: b */
    private Uri f4673b;

    /* renamed from: c */
    private C1494a f4674c;

    /* renamed from: d */
    private String f4675d;

    /* renamed from: e */
    private int f4676e;

    /* renamed from: f */
    private int f4677f;

    /* renamed from: g */
    private int f4678g;

    /* renamed from: com.applovin.impl.a.k$a */
    public enum C1494a {
        Progressive,
        Streaming
    }

    private C1493k() {
    }

    /* renamed from: a */
    private static C1494a m5805a(String str) {
        if (C2025o.m7963b(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return C1494a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return C1494a.Streaming;
            }
        }
        return C1494a.Progressive;
    }

    /* renamed from: a */
    public static C1493k m5806a(C2032t tVar, C1941j jVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (jVar != null) {
            try {
                String c = tVar.mo8828c();
                if (URLUtil.isValidUrl(c)) {
                    Uri parse = Uri.parse(c);
                    C1493k kVar = new C1493k();
                    kVar.f4672a = parse;
                    kVar.f4673b = parse;
                    kVar.f4678g = C2025o.m7953a(tVar.mo8826b().get("bitrate"));
                    kVar.f4674c = m5805a(tVar.mo8826b().get("delivery"));
                    kVar.f4677f = C2025o.m7953a(tVar.mo8826b().get("height"));
                    kVar.f4676e = C2025o.m7953a(tVar.mo8826b().get("width"));
                    kVar.f4675d = tVar.mo8826b().get("type").toLowerCase(Locale.ENGLISH);
                    return kVar;
                }
                jVar.mo8602v().mo8746e("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            } catch (Throwable th) {
                jVar.mo8602v().mo8743b("VastVideoFile", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public Uri mo7228a() {
        return this.f4672a;
    }

    /* renamed from: a */
    public void mo7229a(Uri uri) {
        this.f4673b = uri;
    }

    /* renamed from: b */
    public Uri mo7230b() {
        return this.f4673b;
    }

    /* renamed from: c */
    public String mo7231c() {
        return this.f4675d;
    }

    /* renamed from: d */
    public int mo7232d() {
        return this.f4678g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1493k)) {
            return false;
        }
        C1493k kVar = (C1493k) obj;
        if (this.f4676e != kVar.f4676e || this.f4677f != kVar.f4677f || this.f4678g != kVar.f4678g) {
            return false;
        }
        Uri uri = this.f4672a;
        if (uri == null ? kVar.f4672a != null : !uri.equals(kVar.f4672a)) {
            return false;
        }
        Uri uri2 = this.f4673b;
        if (uri2 == null ? kVar.f4673b != null : !uri2.equals(kVar.f4673b)) {
            return false;
        }
        if (this.f4674c != kVar.f4674c) {
            return false;
        }
        String str = this.f4675d;
        String str2 = kVar.f4675d;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Uri uri = this.f4672a;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f4673b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        C1494a aVar = this.f4674c;
        int hashCode3 = (hashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f4675d;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((hashCode3 + i) * 31) + this.f4676e) * 31) + this.f4677f) * 31) + this.f4678g;
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f4672a + ", videoUri=" + this.f4673b + ", deliveryType=" + this.f4674c + ", fileType='" + this.f4675d + '\'' + ", width=" + this.f4676e + ", height=" + this.f4677f + ", bitrate=" + this.f4678g + '}';
    }
}
