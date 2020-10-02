package com.tapjoy.internal;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tapjoy.internal.cu */
public final class C4950cu {

    /* renamed from: a */
    public final C4953cx f13443a;

    /* renamed from: b */
    final WebView f13444b = null;

    /* renamed from: c */
    public final List f13445c;

    /* renamed from: d */
    final String f13446d;

    /* renamed from: e */
    public final String f13447e;

    /* renamed from: f */
    public final C4951cv f13448f;

    private C4950cu(C4953cx cxVar, String str, List list, String str2) {
        C4951cv cvVar;
        ArrayList arrayList = new ArrayList();
        this.f13445c = arrayList;
        this.f13443a = cxVar;
        this.f13446d = str;
        if (list != null) {
            arrayList.addAll(list);
            cvVar = C4951cv.NATIVE;
        } else {
            cvVar = C4951cv.HTML;
        }
        this.f13448f = cvVar;
        this.f13447e = str2;
    }

    /* renamed from: a */
    public static C4950cu m16791a(C4953cx cxVar, String str, List list, String str2) {
        C4975do.m16853a((Object) cxVar, "Partner is null");
        C4975do.m16853a((Object) str, "OM SDK JS script content is null");
        C4975do.m16853a((Object) list, "VerificationScriptResources is null");
        if (str2.length() <= 256) {
            return new C4950cu(cxVar, str, list, str2);
        }
        throw new IllegalArgumentException("CustomReferenceData is greater than 256 characters");
    }
}
