package com.moat.analytics.mobile.vng;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.vng.C4418v;
import java.util.Map;

public abstract class MoatFactory {
    public static MoatFactory create() {
        try {
            return new C4404o();
        } catch (Exception e) {
            C4403n.m14758a(e);
            return new C4418v.C4420b();
        }
    }

    public abstract <T> T createCustomTracker(MoatPlugin<T> moatPlugin);

    public abstract NativeDisplayTracker createNativeDisplayTracker(View view, Map<String, String> map);

    public abstract NativeVideoTracker createNativeVideoTracker(String str);

    public abstract WebAdTracker createWebAdTracker(ViewGroup viewGroup);

    public abstract WebAdTracker createWebAdTracker(WebView webView);
}
