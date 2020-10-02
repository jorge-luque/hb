package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* renamed from: com.tapjoy.internal.ab */
public final class C4875ab {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m16661a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
