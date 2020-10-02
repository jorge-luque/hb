package com.vungle.warren.p074ui;

import android.os.Build;

/* renamed from: com.vungle.warren.ui.VungleFlexViewActivity */
public class VungleFlexViewActivity extends VungleActivity {
    private static final String TAG = VungleFlexViewActivity.class.getSimpleName();

    /* access modifiers changed from: protected */
    public boolean canRotate() {
        boolean z = getApplication().getApplicationInfo().targetSdkVersion >= 27 && Build.VERSION.SDK_INT == 26;
        StringBuilder sb = new StringBuilder();
        sb.append("allow rotation = ");
        sb.append(!z);
        sb.toString();
        return !z;
    }
}
