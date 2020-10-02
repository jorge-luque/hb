package org.cocos2dx.lib;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ResizeLayout extends FrameLayout {
    private boolean mEnableForceDoLayout = false;

    public ResizeLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mEnableForceDoLayout) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ResizeLayout.this.requestLayout();
                    ResizeLayout.this.invalidate();
                }
            }, 41);
        }
    }

    public void setEnableForceDoLayout(boolean z) {
        this.mEnableForceDoLayout = z;
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
