package com.moat.analytics.mobile.ogury;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.NoOp;
import java.util.Map;

public abstract class MoatFactory {
    public static MoatFactory create() {
        try {
            return new C4337o();
        } catch (Exception e) {
            C4332l.m14509(e);
            return new NoOp.MoatFactory();
        }
    }

    public abstract <T> T createCustomTracker(C4336n<T> nVar);

    public abstract NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map);

    public abstract NativeVideoTracker createNativeVideoTracker(String str);

    public abstract WebAdTracker createWebAdTracker(ViewGroup viewGroup);

    public abstract WebAdTracker createWebAdTracker(WebView webView);
}
