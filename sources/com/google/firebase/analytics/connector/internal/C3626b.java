package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzif;
import com.google.firebase.analytics.p122a.C3619a;
import com.tapjoy.TapjoyConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.google.firebase.analytics.connector.internal.b */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
public final class C3626b {

    /* renamed from: a */
    private static final List<String> f10160a = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"});

    /* renamed from: b */
    private static final List<String> f10161b = Arrays.asList(new String[]{"auto", TapjoyConstants.TJC_APP_PLACEMENT, "am"});

    /* renamed from: c */
    private static final List<String> f10162c = Arrays.asList(new String[]{"_r", "_dbg"});

    /* renamed from: d */
    private static final List<String> f10163d = Arrays.asList((String[]) ArrayUtils.concat(zzgy.zza, zzgy.zzb));

    /* renamed from: e */
    private static final List<String> f10164e = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    static {
        new HashSet(Arrays.asList(new String[]{"_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}));
    }

    /* renamed from: a */
    public static boolean m12349a(String str) {
        return !f10161b.contains(str);
    }

    /* renamed from: b */
    public static AppMeasurement.ConditionalUserProperty m12353b(C3619a.C3620a aVar) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mOrigin = aVar.f10139a;
        conditionalUserProperty.mActive = aVar.f10152n;
        conditionalUserProperty.mCreationTimestamp = aVar.f10151m;
        conditionalUserProperty.mExpiredEventName = aVar.f10149k;
        if (aVar.f10150l != null) {
            conditionalUserProperty.mExpiredEventParams = new Bundle(aVar.f10150l);
        }
        conditionalUserProperty.mName = aVar.f10140b;
        conditionalUserProperty.mTimedOutEventName = aVar.f10144f;
        if (aVar.f10145g != null) {
            conditionalUserProperty.mTimedOutEventParams = new Bundle(aVar.f10145g);
        }
        conditionalUserProperty.mTimeToLive = aVar.f10148j;
        conditionalUserProperty.mTriggeredEventName = aVar.f10146h;
        if (aVar.f10147i != null) {
            conditionalUserProperty.mTriggeredEventParams = new Bundle(aVar.f10147i);
        }
        conditionalUserProperty.mTriggeredTimestamp = aVar.f10153o;
        conditionalUserProperty.mTriggerEventName = aVar.f10142d;
        conditionalUserProperty.mTriggerTimeout = aVar.f10143e;
        Object obj = aVar.f10141c;
        if (obj != null) {
            conditionalUserProperty.mValue = zzif.zza(obj);
        }
        return conditionalUserProperty;
    }

    /* renamed from: a */
    public static boolean m12350a(String str, Bundle bundle) {
        if (f10160a.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        for (String containsKey : f10162c) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m12351a(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if (AppMeasurement.UserProperty.FIREBASE_LAST_NOTIFICATION.equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (f10163d.contains(str2)) {
            return false;
        }
        for (String matches : f10164e) {
            if (str2.matches(matches)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m12348a(C3619a.C3620a aVar) {
        String str;
        if (aVar == null || (str = aVar.f10139a) == null || str.isEmpty()) {
            return false;
        }
        Object obj = aVar.f10141c;
        if ((obj != null && zzif.zza(obj) == null) || !m12349a(str) || !m12351a(str, aVar.f10140b)) {
            return false;
        }
        String str2 = aVar.f10149k;
        if (str2 != null && (!m12350a(str2, aVar.f10150l) || !m12352a(str, aVar.f10149k, aVar.f10150l))) {
            return false;
        }
        String str3 = aVar.f10146h;
        if (str3 != null && (!m12350a(str3, aVar.f10147i) || !m12352a(str, aVar.f10146h, aVar.f10147i))) {
            return false;
        }
        String str4 = aVar.f10144f;
        if (str4 == null) {
            return true;
        }
        if (m12350a(str4, aVar.f10145g) && m12352a(str, aVar.f10144f, aVar.f10145g)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static void m12354b(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1);
        }
    }

    /* renamed from: a */
    public static boolean m12352a(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!m12349a(str) || bundle == null) {
            return false;
        }
        for (String containsKey : f10162c) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals("fiam")) {
                    c = 2;
                }
            } else if (str.equals("fdl")) {
                c = 1;
            }
        } else if (str.equals("fcm")) {
            c = 0;
        }
        if (c == 0) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        } else if (c == 1) {
            bundle.putString("_cis", "fdl_integration");
            return true;
        } else if (c != 2) {
            return false;
        } else {
            bundle.putString("_cis", "fiam_integration");
            return true;
        }
    }

    /* renamed from: a */
    public static C3619a.C3620a m12347a(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        C3619a.C3620a aVar = new C3619a.C3620a();
        aVar.f10139a = conditionalUserProperty.mOrigin;
        aVar.f10152n = conditionalUserProperty.mActive;
        aVar.f10151m = conditionalUserProperty.mCreationTimestamp;
        aVar.f10149k = conditionalUserProperty.mExpiredEventName;
        if (conditionalUserProperty.mExpiredEventParams != null) {
            aVar.f10150l = new Bundle(conditionalUserProperty.mExpiredEventParams);
        }
        aVar.f10140b = conditionalUserProperty.mName;
        aVar.f10144f = conditionalUserProperty.mTimedOutEventName;
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            aVar.f10145g = new Bundle(conditionalUserProperty.mTimedOutEventParams);
        }
        aVar.f10148j = conditionalUserProperty.mTimeToLive;
        aVar.f10146h = conditionalUserProperty.mTriggeredEventName;
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            aVar.f10147i = new Bundle(conditionalUserProperty.mTriggeredEventParams);
        }
        aVar.f10153o = conditionalUserProperty.mTriggeredTimestamp;
        aVar.f10142d = conditionalUserProperty.mTriggerEventName;
        aVar.f10143e = conditionalUserProperty.mTriggerTimeout;
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            aVar.f10141c = zzif.zza(obj);
        }
        return aVar;
    }
}
