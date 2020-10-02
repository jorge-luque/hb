package com.criteo.publisher.advancednative;

import android.graphics.Rect;
import android.view.View;

/* renamed from: com.criteo.publisher.advancednative.m */
public class C2372m {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10228a(View view) {
        if (!view.isShown()) {
            return false;
        }
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return false;
        }
        return view.getGlobalVisibleRect(new Rect());
    }
}
