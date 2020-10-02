package com.iab.omid.library.adcolony.p146d;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

/* renamed from: com.iab.omid.library.adcolony.d.f */
public final class C4171f {
    /* renamed from: a */
    public static float m14011a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    /* renamed from: b */
    public static View m14012b(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* renamed from: c */
    public static boolean m14013c(View view) {
        if ((Build.VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) || !view.isShown()) {
            return false;
        }
        while (view != null) {
            if (view.getAlpha() == 0.0f) {
                return false;
            }
            view = m14012b(view);
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m14014d(View view) {
        return m14015e(view) == null;
    }

    /* renamed from: e */
    public static String m14015e(View view) {
        if (Build.VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) {
            return "notAttached";
        }
        int visibility = view.getVisibility();
        if (visibility != 0) {
            return visibility != 4 ? visibility != 8 ? "viewNotVisible" : "viewGone" : "viewInvisible";
        }
        if (view.getAlpha() == 0.0f) {
            return "viewAlphaZero";
        }
        return null;
    }
}
