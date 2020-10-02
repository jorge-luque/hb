package com.iab.omid.library.adcolony.adsession;

import com.iab.omid.library.adcolony.p146d.C4170e;
import java.net.URL;

public final class VerificationScriptResource {

    /* renamed from: a */
    private final String f11140a;

    /* renamed from: b */
    private final URL f11141b;

    /* renamed from: c */
    private final String f11142c;

    private VerificationScriptResource(String str, URL url, String str2) {
        this.f11140a = str;
        this.f11141b = url;
        this.f11142c = str2;
    }

    public static VerificationScriptResource createVerificationScriptResourceWithParameters(String str, URL url, String str2) {
        C4170e.m14003a(str, "VendorKey is null or empty");
        C4170e.m14001a((Object) url, "ResourceURL is null");
        C4170e.m14003a(str2, "VerificationParameters is null or empty");
        return new VerificationScriptResource(str, url, str2);
    }

    public static VerificationScriptResource createVerificationScriptResourceWithoutParameters(URL url) {
        C4170e.m14001a((Object) url, "ResourceURL is null");
        return new VerificationScriptResource((String) null, url, (String) null);
    }

    public URL getResourceUrl() {
        return this.f11141b;
    }

    public String getVendorKey() {
        return this.f11140a;
    }

    public String getVerificationParameters() {
        return this.f11142c;
    }
}
