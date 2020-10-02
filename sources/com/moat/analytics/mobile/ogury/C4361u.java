package com.moat.analytics.mobile.ogury;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.C4315e;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/* renamed from: com.moat.analytics.mobile.ogury.u */
final class C4361u {

    /* renamed from: ॱ */
    private static final LinkedHashSet<String> f11679 = new LinkedHashSet<>();

    C4361u() {
    }

    /* renamed from: ˎ */
    static Optional<WebView> m14587(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            try {
                return Optional.empty();
            } catch (Exception unused) {
                return Optional.empty();
            }
        } else if (viewGroup instanceof WebView) {
            return Optional.m14414of((WebView) viewGroup);
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
                        C4315e.C43161.m14442(3, "WebViewHound", childAt, "Found WebView");
                        if (z || m14588(String.valueOf(childAt.hashCode()))) {
                            if (webView != null) {
                                C4315e.C43161.m14442(3, "WebViewHound", childAt, "Ambiguous ad container: multiple WebViews reside within it.");
                                C4315e.C43161.m14446("[ERROR] ", "WebAdTracker not created, ambiguous ad container: multiple WebViews reside within it");
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
            return Optional.ofNullable(webView);
        }
    }

    /* renamed from: ॱ */
    private static boolean m14588(String str) {
        try {
            boolean add = f11679.add(str);
            if (f11679.size() > 50) {
                Iterator<String> it = f11679.iterator();
                for (int i = 0; i < 25 && it.hasNext(); i++) {
                    it.next();
                    it.remove();
                }
            }
            C4315e.C43161.m14442(3, "WebViewHound", (Object) null, add ? "Newly Found WebView" : "Already Found WebView");
            return add;
        } catch (Exception e) {
            C4332l.m14509(e);
            return false;
        }
    }
}
