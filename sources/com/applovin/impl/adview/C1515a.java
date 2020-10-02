package com.applovin.impl.adview;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.a */
public class C1515a extends RelativeLayout {

    /* renamed from: a */
    private final ProgressBar f4772a;

    public C1515a(Activity activity, int i, int i2) {
        super(activity);
        RelativeLayout.LayoutParams layoutParams;
        setClickable(false);
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, i2);
        this.f4772a = progressBar;
        progressBar.setIndeterminate(true);
        this.f4772a.setClickable(false);
        if (i == -2 || i == -1) {
            layoutParams = new RelativeLayout.LayoutParams(i, i);
        } else {
            int dpToPx = AppLovinSdkUtils.dpToPx(activity, i);
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        }
        layoutParams.addRule(13);
        this.f4772a.setLayoutParams(layoutParams);
        addView(this.f4772a);
    }

    /* renamed from: a */
    public void mo7293a() {
        setVisibility(0);
    }

    /* renamed from: b */
    public void mo7294b() {
        setVisibility(8);
    }

    public void setColor(int i) {
        this.f4772a.getIndeterminateDrawable().setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }
}
