package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.C1928g;

public class AppLovinPrivacySettings {
    public static boolean hasUserConsent(Context context) {
        Boolean a = C1928g.m7409a(context);
        if (a != null) {
            return a.booleanValue();
        }
        return false;
    }

    public static boolean isAgeRestrictedUser(Context context) {
        Boolean b = C1928g.m7413b(context);
        if (b != null) {
            return b.booleanValue();
        }
        return false;
    }

    public static boolean isDoNotSell(Context context) {
        Boolean c = C1928g.m7415c(context);
        if (c != null) {
            return c.booleanValue();
        }
        return false;
    }

    public static void setDoNotSell(boolean z, Context context) {
        if (C1928g.m7416c(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, (Boolean) null, Boolean.valueOf(z));
        }
    }

    public static void setHasUserConsent(boolean z, Context context) {
        if (C1928g.m7412a(z, context)) {
            AppLovinSdk.reinitializeAll(Boolean.valueOf(z), (Boolean) null, (Boolean) null);
        }
    }

    public static void setIsAgeRestrictedUser(boolean z, Context context) {
        if (C1928g.m7414b(z, context)) {
            AppLovinSdk.reinitializeAll((Boolean) null, Boolean.valueOf(z), (Boolean) null);
        }
    }
}
