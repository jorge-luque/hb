package com.facebook.share.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.p006a.p007a.C0383a;
import com.facebook.FacebookButtonBase;
import com.facebook.common.C2707R;
import com.facebook.internal.AnalyticsEvents;

@Deprecated
public class LikeButton extends FacebookButtonBase {
    @Deprecated
    public LikeButton(Context context, boolean z) {
        super(context, (AttributeSet) null, 0, 0, AnalyticsEvents.EVENT_LIKE_BUTTON_CREATE, AnalyticsEvents.EVENT_LIKE_BUTTON_DID_TAP);
        setSelected(z);
    }

    private void updateForLikeStatus() {
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(C2707R.C2708drawable.com_facebook_button_like_icon_selected, 0, 0, 0);
            setText(getResources().getString(C2707R.string.com_facebook_like_button_liked));
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(C0383a.m323c(getContext(), C2707R.C2708drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        setText(getResources().getString(C2707R.string.com_facebook_like_button_not_liked));
    }

    /* access modifiers changed from: protected */
    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        updateForLikeStatus();
    }

    /* access modifiers changed from: protected */
    public int getDefaultRequestCode() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        return C2707R.style.com_facebook_button_like;
    }

    @Deprecated
    public void setSelected(boolean z) {
        super.setSelected(z);
        updateForLikeStatus();
    }
}
