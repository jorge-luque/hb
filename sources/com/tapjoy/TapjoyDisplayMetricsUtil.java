package com.tapjoy;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class TapjoyDisplayMetricsUtil {

    /* renamed from: a */
    private Context f13263a;

    /* renamed from: b */
    private Configuration f13264b;

    /* renamed from: c */
    private DisplayMetrics f13265c = new DisplayMetrics();

    public TapjoyDisplayMetricsUtil(Context context) {
        this.f13263a = context;
        ((WindowManager) this.f13263a.getSystemService("window")).getDefaultDisplay().getMetrics(this.f13265c);
        this.f13264b = this.f13263a.getResources().getConfiguration();
    }

    public int getScreenDensityDPI() {
        return this.f13265c.densityDpi;
    }

    public float getScreenDensityScale() {
        return this.f13265c.density;
    }

    public int getScreenLayoutSize() {
        return this.f13264b.screenLayout & 15;
    }
}
