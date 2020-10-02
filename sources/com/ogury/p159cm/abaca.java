package com.ogury.p159cm;

import android.content.Context;
import com.tapjoy.TapjoyConstants;

/* renamed from: com.ogury.cm.abaca */
public final class abaca {

    /* renamed from: a */
    private final abacc f12066a = new abacc();

    /* renamed from: a */
    public static void m15098a(Context context, String str, String str2, aacbc aacbc) {
        accbb.m15218b(context, "context");
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(str2, "requestType");
        accbb.m15218b(aacbc, "callback");
        abbac b = m15102b(str2, aacbc);
        new abbab();
        abacc.m15106a(b.mo29472b(abbab.m15112a(context, str)).mo29478f());
    }

    /* renamed from: a */
    public static void m15099a(String str, aacbc aacbc) {
        accbb.m15218b(str, "errorMessage");
        accbb.m15218b(aacbc, "callback");
        abbac b = m15102b(TapjoyConstants.TJC_SDK_TYPE_DEFAULT, aacbc);
        new abbab();
        abbac b2 = b.mo29472b(abbab.m15113a(str));
        aacca aacca = aacca.f12035a;
        abacc.m15106a(b2.mo29470a("X-CM-SECURE-TOKEN", aacca.m15042g()).mo29478f());
    }

    /* renamed from: a */
    public static void m15100a(String str, aacbc aacbc, String str2, Integer[] numArr) {
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(aacbc, "callback");
        accbb.m15218b(str2, "iabString");
        abbac b = m15102b("external-consent", aacbc);
        new abbab();
        abacc.m15106a(b.mo29472b(abbab.m15114a(str, str2, numArr)).mo29478f());
    }

    /* renamed from: a */
    public static void m15101a(String str, aacbc aacbc, String str2, String[] strArr) {
        accbb.m15218b(str, "assetKey");
        accbb.m15218b(aacbc, "callback");
        accbb.m15218b(str2, "iabString");
        abbac b = m15102b("external-consent", aacbc);
        new abbab();
        abacc.m15106a(b.mo29472b(abbab.m15115a(str, str2, strArr)).mo29478f());
    }

    /* renamed from: b */
    private static abbac m15102b(String str, aacbc aacbc) {
        return new abbac().mo29469a("POST").mo29474c(str).mo29468a(aacbc);
    }
}
