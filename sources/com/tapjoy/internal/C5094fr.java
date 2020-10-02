package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;

/* renamed from: com.tapjoy.internal.fr */
public final class C5094fr {

    /* renamed from: a */
    private static final C5103fz f13947a = new C5103fz() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* synthetic */ TJPlacement mo31253a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            return TJPlacementManager.createPlacement(context, "InsufficientCurrency", true, tJPlacementListener);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ String mo31254a(Object obj) {
            return "InsufficientCurrency";
        }
    };

    /* renamed from: a */
    public static void m17213a() {
        f13947a.mo31269c((Object) null);
    }
}
