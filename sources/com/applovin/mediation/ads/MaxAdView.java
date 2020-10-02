package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.ads.C1694a;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.sdk.utils.C1985b;
import com.applovin.impl.sdk.utils.C2025o;
import com.applovin.impl.sdk.utils.C2029r;
import com.applovin.impl.sdk.utils.C2030s;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

public class MaxAdView extends RelativeLayout {

    /* renamed from: a */
    private MaxAdViewImpl f6787a;

    /* renamed from: b */
    private View f6788b;

    /* renamed from: c */
    private int f6789c;

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String attributeValue = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "adUnitId");
        String attributeValue2 = attributeSet.getAttributeValue(AppLovinAdView.NAMESPACE, "adFormat");
        MaxAdFormat c = C2025o.m7963b(attributeValue2) ? C2029r.m8031c(attributeValue2) : C1985b.m7815a(context);
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (attributeValue == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(attributeValue)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            m8095a(attributeValue, c, attributeIntValue, AppLovinSdk.getInstance(activity), activity);
        } else {
            throw new IllegalArgumentException("Max ad view context is not an activity");
        }
    }

    public MaxAdView(String str, Activity activity) {
        this(str, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, Activity activity) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Activity activity) {
        super(activity);
        C1694a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", sdk=" + appLovinSdk + ")");
        m8095a(str, maxAdFormat, 49, appLovinSdk, activity);
    }

    public MaxAdView(String str, AppLovinSdk appLovinSdk, Activity activity) {
        this(str, C1985b.m7815a((Context) activity), appLovinSdk, activity);
    }

    /* renamed from: a */
    private void m8094a(MaxAdFormat maxAdFormat, Context context) {
        int i;
        int i2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (maxAdFormat == MaxAdFormat.MREC) {
            i = (int) TypedValue.applyDimension(1, (float) AppLovinAdSize.MREC.getWidth(), displayMetrics);
            i2 = (int) TypedValue.applyDimension(1, (float) AppLovinAdSize.MREC.getHeight(), displayMetrics);
        } else {
            int i3 = displayMetrics.widthPixels;
            i2 = (int) TypedValue.applyDimension(1, (float) (maxAdFormat == MaxAdFormat.BANNER ? AppLovinAdSize.BANNER : AppLovinAdSize.LEADER).getHeight(), displayMetrics);
            i = i3;
        }
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, i, i2);
    }

    /* renamed from: a */
    private void m8095a(String str, MaxAdFormat maxAdFormat, int i, AppLovinSdk appLovinSdk, Activity activity) {
        if (!isInEditMode()) {
            View view = new View(activity);
            this.f6788b = view;
            view.setBackgroundColor(0);
            addView(this.f6788b);
            this.f6788b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f6789c = getVisibility();
            this.f6787a = new MaxAdViewImpl(str, maxAdFormat, this, this.f6788b, C2029r.m7993a(appLovinSdk), activity);
            setGravity(i);
            if (getBackground() instanceof ColorDrawable) {
                setBackgroundColor(((ColorDrawable) getBackground()).getColor());
            }
            super.setBackgroundColor(0);
            return;
        }
        m8094a(maxAdFormat, activity);
    }

    public void destroy() {
        this.f6787a.destroy();
    }

    public String getPlacement() {
        return this.f6787a.getPlacement();
    }

    public void loadAd() {
        this.f6787a.loadAd();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        MaxAdViewImpl maxAdViewImpl = this.f6787a;
        maxAdViewImpl.logApiCall("onWindowVisibilityChanged(visibility=" + i + ")");
        if (this.f6787a != null && C2030s.m8043a(this.f6789c, i)) {
            this.f6787a.onWindowVisibilityChanged(i);
        }
        this.f6789c = i;
    }

    public void setAlpha(float f) {
        MaxAdViewImpl maxAdViewImpl = this.f6787a;
        maxAdViewImpl.logApiCall("setAlpha(alpha=" + f + ")");
        View view = this.f6788b;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    public void setBackgroundColor(int i) {
        MaxAdViewImpl maxAdViewImpl = this.f6787a;
        maxAdViewImpl.logApiCall("setBackgroundColor(color=" + i + ")");
        MaxAdViewImpl maxAdViewImpl2 = this.f6787a;
        if (maxAdViewImpl2 != null) {
            maxAdViewImpl2.setPublisherBackgroundColor(i);
        }
        View view = this.f6788b;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setExtraParameter(String str, String str2) {
        MaxAdViewImpl maxAdViewImpl = this.f6787a;
        maxAdViewImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f6787a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        MaxAdViewImpl maxAdViewImpl = this.f6787a;
        maxAdViewImpl.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.f6787a.setListener(maxAdViewAdListener);
    }

    public void setPlacement(String str) {
        this.f6787a.setPlacement(str);
    }

    public void startAutoRefresh() {
        this.f6787a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f6787a.stopAutoRefresh();
    }

    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f6787a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }
}
