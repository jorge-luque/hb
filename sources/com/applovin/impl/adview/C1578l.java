package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.C1563h;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.applovin.impl.adview.l */
public class C1578l extends FrameLayout {

    /* renamed from: a */
    private final C1563h f4941a;

    public C1578l(C1563h.C1564a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        C1563h a = C1563h.m6016a(aVar, activity);
        this.f4941a = a;
        addView(a);
    }

    /* renamed from: a */
    public void mo7462a(int i, int i2, int i3, int i4) {
        int i5 = i2 + i + i3;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i5;
            layoutParams.width = i5;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i5, i5));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i, i4);
        layoutParams2.setMargins(i3, i3, i3, 0);
        this.f4941a.setLayoutParams(layoutParams2);
        this.f4941a.mo7436a(i);
    }
}
