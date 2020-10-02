package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;

@C3135ft
public class TapjoyNative {
    @C3135ft
    public static Object createPlacement(Context context, String str, TJPlacementListener tJPlacementListener) {
        return C5117gc.m17257a().mo31295a(context, str, tJPlacementListener);
    }

    @C3135ft
    public static Object getPrivacyPolicy() {
        return C5117gc.m17257a().mo31296b();
    }
}
