package com.tapjoy;

import com.tapjoy.internal.C4889al;
import com.tapjoy.internal.C5119ge;

public class TJPrivacyPolicy {

    /* renamed from: a */
    private static final TJPrivacyPolicy f13084a = new TJPrivacyPolicy();

    public static TJPrivacyPolicy getInstance() {
        return f13084a;
    }

    public void setBelowConsentAge(boolean z) {
        C5119ge.m17262a().mo31300b(z);
    }

    public void setSubjectToGDPR(boolean z) {
        C5119ge.m17262a().mo31299a(z);
    }

    public void setUSPrivacy(String str) {
        C5119ge a = C5119ge.m17262a();
        if (!C4889al.m16672a(str)) {
            a.f14012d = str;
            if (!a.mo31301b()) {
                a.f14013e = true;
            }
        }
    }

    public void setUserConsent(String str) {
        C5119ge.m17262a().mo31298a(str);
    }
}
