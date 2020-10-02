package com.ogury.p159cm;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Base64;

/* renamed from: com.ogury.cm.aabba */
public final class aabba {

    /* renamed from: a */
    public static final aaaaa f12009a = new aaaaa((baaca) null);

    /* renamed from: com.ogury.cm.aabba$aaaaa */
    public static final class aaaaa {
        private aaaaa() {
        }

        public /* synthetic */ aaaaa(baaca baaca) {
            this();
        }

        /* renamed from: a */
        public static String m14997a(String str) {
            accbb.m15218b(str, "receiver$0");
            byte[] bytes = str.getBytes(babaa.f12165a);
            accbb.m15215a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 11);
            accbb.m15215a((Object) encodeToString, "Base64.encodeToString(by…ADDING + Base64.URL_SAFE)");
            return encodeToString;
        }

        /* renamed from: a */
        public static void m14998a(Context context, int i) {
            ababa ababa;
            String str;
            accbb.m15218b(context, "context");
            if (i == 1) {
                ababa = new ababb();
                str = "cacheConsentV2";
            } else if (i == 2) {
                ababa = new ababc();
                str = "cacheConsent";
            } else {
                throw new IllegalStateException("Bad TCF version used! Please use one of the declared ones in OguryChoiceManager class.");
            }
            if (context.getSharedPreferences(str, 0).contains("assetKey")) {
                Context applicationContext = context.getApplicationContext();
                accbb.m15215a((Object) applicationContext, "context.applicationContext");
                PreferenceManager.getDefaultSharedPreferences(applicationContext).edit().clear().apply();
                applicationContext.getSharedPreferences(str, 0).edit().clear().apply();
                aacca aacca = aacca.f12035a;
                aacca.m15035b(ababa);
                OguryChoiceManager.INSTANCE.resetClientConsentImpl$consent_manager_prodRelease();
            }
        }

        /* renamed from: b */
        public static String m14999b(String str) {
            accbb.m15218b(str, "receiver$0");
            return baacc.m15246a(str, "-", " ", false, 4, (Object) null);
        }
    }
}
