package com.moat.analytics.mobile.vng;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.vng.p156a.p158b.C4374a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* renamed from: com.moat.analytics.mobile.vng.ab */
class C4376ab {

    /* renamed from: a */
    private static final LinkedHashSet<String> f11719a = new LinkedHashSet<>();

    C4376ab() {
    }

    /* renamed from: a */
    static C4374a<WebView> m14631a(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            try {
                return C4374a.m14624a();
            } catch (Exception unused) {
                return C4374a.m14624a();
            }
        } else if (viewGroup instanceof WebView) {
            return C4374a.m14625a((WebView) viewGroup);
        } else {
            LinkedList linkedList = new LinkedList();
            linkedList.add(viewGroup);
            WebView webView = null;
            int i = 0;
            while (!linkedList.isEmpty() && i < 100) {
                i++;
                ViewGroup viewGroup2 = (ViewGroup) linkedList.poll();
                int childCount = viewGroup2.getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = viewGroup2.getChildAt(i2);
                    if (childAt instanceof WebView) {
                        C4409p.m14772a(3, "WebViewHound", (Object) childAt, "Found WebView");
                        if (z || m14632a(String.valueOf(childAt.hashCode()))) {
                            if (webView != null) {
                                C4409p.m14772a(3, "WebViewHound", (Object) childAt, "Ambiguous ad container: multiple WebViews reside within it.");
                                C4409p.m14775a("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
                                webView = null;
                                break;
                            }
                            webView = (WebView) childAt;
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        linkedList.add((ViewGroup) childAt);
                    }
                    i2++;
                }
            }
            return C4374a.m14626b(webView);
        }
    }

    /* renamed from: a */
    private static boolean m14632a(String str) {
        try {
            boolean add = f11719a.add(str);
            if (f11719a.size() > 50) {
                Iterator it = f11719a.iterator();
                for (int i = 0; i < 25 && it.hasNext(); i++) {
                    it.next();
                    it.remove();
                }
            }
            C4409p.m14772a(3, "WebViewHound", (Object) null, add ? "Newly Found WebView" : "Already Found WebView");
            return add;
        } catch (Exception e) {
            C4403n.m14758a(e);
            return false;
        }
    }
}
