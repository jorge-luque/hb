package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPrivacyPolicy;

/* renamed from: com.tapjoy.internal.gd */
final class C5118gd extends C5117gc {
    C5118gd() {
    }

    /* renamed from: a */
    public final Object mo31295a(Context context, String str, TJPlacementListener tJPlacementListener) {
        return new TJPlacement(context, str, tJPlacementListener);
    }

    /* renamed from: b */
    public final Object mo31296b() {
        return TJPrivacyPolicy.getInstance();
    }
}
