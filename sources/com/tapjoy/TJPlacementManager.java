package com.tapjoy;

import android.content.Context;
import com.tapjoy.internal.C3166jq;
import com.tapjoy.internal.C4903az;
import com.tapjoy.internal.C5135gv;
import com.tapjoy.internal.C5151he;

public class TJPlacementManager {

    /* renamed from: a */
    private static final C4903az f13079a = C4903az.m16690a();

    /* renamed from: b */
    private static int f13080b = 0;

    /* renamed from: c */
    private static int f13081c = 0;

    /* renamed from: d */
    private static int f13082d = 3;

    /* renamed from: e */
    private static int f13083e = 3;

    /* renamed from: a */
    public static TJPlacement m16594a(String str, String str2, String str3, TJPlacementListener tJPlacementListener) {
        TJPlacement tJPlacement;
        synchronized (f13079a) {
            tJPlacement = new TJPlacement(m16593a(str, str2, str3, false, false), tJPlacementListener);
        }
        return tJPlacement;
    }

    /* renamed from: b */
    public static TJPlacement m16595b(String str, String str2, String str3, TJPlacementListener tJPlacementListener) {
        TJPlacement tJPlacement;
        synchronized (f13079a) {
            tJPlacement = new TJPlacement(m16593a(str, str2, str3, false, true), tJPlacementListener);
        }
        return tJPlacement;
    }

    public static boolean canCachePlacement() {
        return getCachedPlacementCount() < getCachedPlacementLimit();
    }

    public static boolean canPreRenderPlacement() {
        return getPreRenderedPlacementCount() < getPreRenderedPlacementLimit();
    }

    public static TJPlacement createPlacement(Context context, String str, boolean z, TJPlacementListener tJPlacementListener) {
        TJCorePlacement a = m16593a(str, (String) null, (String) null, z, false);
        a.f13003j = z;
        a.f12996c.setPlacementType("sdk");
        a.setContext(context);
        return new TJPlacement(a, tJPlacementListener);
    }

    public static void decrementPlacementCacheCount() {
        int i = f13080b - 1;
        f13080b = i;
        if (i < 0) {
            f13080b = 0;
        }
        printPlacementCacheInformation();
    }

    public static void decrementPlacementPreRenderCount() {
        int i = f13081c - 1;
        f13081c = i;
        if (i < 0) {
            f13081c = 0;
        }
    }

    public static void dismissContentShowing(boolean z) {
        if (z) {
            TJAdUnitActivity.m16538a();
        }
        C5151he.m17351a();
        C5135gv.m17314a();
    }

    public static int getCachedPlacementCount() {
        return f13080b;
    }

    public static int getCachedPlacementLimit() {
        return f13082d;
    }

    public static int getPreRenderedPlacementCount() {
        return f13081c;
    }

    public static int getPreRenderedPlacementLimit() {
        return f13083e;
    }

    public static void incrementPlacementCacheCount() {
        int i = f13080b + 1;
        f13080b = i;
        int i2 = f13082d;
        if (i > i2) {
            f13080b = i2;
        }
        printPlacementCacheInformation();
    }

    public static void incrementPlacementPreRenderCount() {
        int i = f13081c + 1;
        f13081c = i;
        int i2 = f13083e;
        if (i > i2) {
            f13081c = i2;
        }
    }

    public static void printPlacementCacheInformation() {
        TapjoyLog.m16652i("TJPlacementManager", "Space available in placement cache: " + f13080b + " out of " + f13082d);
    }

    public static void printPlacementPreRenderInformation() {
        TapjoyLog.m16652i("TJPlacementManager", "Space available for placement pre-render: " + f13081c + " out of " + f13083e);
    }

    public static void setCachedPlacementLimit(int i) {
        f13082d = i;
    }

    public static void setPreRenderedPlacementLimit(int i) {
        f13083e = i;
    }

    /* renamed from: a */
    static TJCorePlacement m16592a(String str) {
        TJCorePlacement tJCorePlacement;
        synchronized (f13079a) {
            tJCorePlacement = (TJCorePlacement) f13079a.get(str);
        }
        return tJCorePlacement;
    }

    /* renamed from: a */
    static TJCorePlacement m16593a(String str, String str2, String str3, boolean z, boolean z2) {
        TJCorePlacement a;
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "!SYSTEM!" : "");
        sb.append(!C3166jq.m10436c(str) ? str : "");
        if (C3166jq.m10436c(str2)) {
            str2 = "";
        }
        sb.append(str2);
        if (C3166jq.m10436c(str3)) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(Boolean.toString(z2));
        String sb2 = sb.toString();
        TapjoyLog.m16649d("TJPlacementManager", "TJCorePlacement key=" + sb2);
        synchronized (f13079a) {
            a = m16592a(sb2);
            if (a == null) {
                a = new TJCorePlacement(str, sb2, z2);
                f13079a.put(sb2, a);
                TapjoyLog.m16649d("TJPlacementManager", "Created TJCorePlacement with GUID: " + a.f12997d);
            }
        }
        return a;
    }
}
