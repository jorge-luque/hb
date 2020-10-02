package com.google.android.datatransport.cct.p070b;

import android.util.SparseArray;
import com.facebook.share.internal.MessengerShareContentUtility;

/* renamed from: com.google.android.datatransport.cct.b.b */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public enum C2944b {
    f8219a(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);
    

    /* renamed from: g */
    private static final SparseArray<C2944b> f8225g = null;

    static {
        f8219a = new C2944b(MessengerShareContentUtility.PREVIEW_DEFAULT, 0, 0);
        UNMETERED_ONLY = new C2944b("UNMETERED_ONLY", 1, 1);
        UNMETERED_OR_DAILY = new C2944b("UNMETERED_OR_DAILY", 2, 2);
        FAST_IF_RADIO_AWAKE = new C2944b("FAST_IF_RADIO_AWAKE", 3, 3);
        NEVER = new C2944b("NEVER", 4, 4);
        UNRECOGNIZED = new C2944b("UNRECOGNIZED", 5, -1);
        SparseArray<C2944b> sparseArray = new SparseArray<>();
        f8225g = sparseArray;
        sparseArray.put(0, f8219a);
        f8225g.put(1, UNMETERED_ONLY);
        f8225g.put(2, UNMETERED_OR_DAILY);
        f8225g.put(3, FAST_IF_RADIO_AWAKE);
        f8225g.put(4, NEVER);
        f8225g.put(-1, UNRECOGNIZED);
    }

    private C2944b(int i) {
    }
}
