package com.google.android.datatransport.cct;

import com.loopj.android.http.C4250c;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import p093e.p101c.p102a.p103a.C3378b;
import p093e.p101c.p102a.p103a.p104i.C3398f;

/* renamed from: com.google.android.datatransport.cct.a */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class C2941a implements C3398f {

    /* renamed from: c */
    static final String f8212c = C2987f.m9849a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* renamed from: d */
    static final String f8213d = C2987f.m9849a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");

    /* renamed from: e */
    private static final String f8214e = C2987f.m9849a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");

    /* renamed from: f */
    private static final Set<C3378b> f8215f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new C3378b[]{C3378b.m11260a("proto"), C3378b.m11260a("json")})));

    /* renamed from: g */
    public static final C2941a f8216g = new C2941a(f8213d, f8214e);

    /* renamed from: a */
    private final String f8217a;

    /* renamed from: b */
    private final String f8218b;

    static {
        new C2941a(f8212c, (String) null);
    }

    public C2941a(String str, String str2) {
        this.f8217a = str;
        this.f8218b = str2;
    }

    /* renamed from: a */
    public static C2941a m9721a(byte[] bArr) {
        String str = new String(bArr, Charset.forName(C4250c.DEFAULT_CHARSET));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new C2941a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    /* renamed from: b */
    public byte[] mo12852b() {
        if (this.f8218b == null && this.f8217a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f8217a;
        objArr[2] = "\\";
        String str = this.f8218b;
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName(C4250c.DEFAULT_CHARSET));
    }

    /* renamed from: c */
    public String mo12853c() {
        return this.f8218b;
    }

    /* renamed from: d */
    public String mo12854d() {
        return this.f8217a;
    }

    public byte[] getExtras() {
        return mo12852b();
    }

    public String getName() {
        return "cct";
    }

    /* renamed from: a */
    public Set<C3378b> mo12851a() {
        return f8215f;
    }
}
