package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.C0857a;
import com.google.android.gms.base.C3082R;
import com.google.android.gms.common.util.DeviceProperties;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int zaa(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        configure(resources, signInButtonConfig.getButtonSize(), signInButtonConfig.getColorScheme());
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    public final void configure(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        int i4 = C3082R.C3083drawable.common_google_signin_btn_icon_dark;
        int i5 = C3082R.C3083drawable.common_google_signin_btn_icon_light;
        int zaa = zaa(i2, i4, i5, i5);
        int i6 = C3082R.C3083drawable.common_google_signin_btn_text_dark;
        int i7 = C3082R.C3083drawable.common_google_signin_btn_text_light;
        int zaa2 = zaa(i2, i6, i7, i7);
        if (i == 0 || i == 1) {
            zaa = zaa2;
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Unknown button size: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
        Drawable h = C0857a.m2818h(resources.getDrawable(zaa));
        C0857a.m2804a(h, resources.getColorStateList(C3082R.color.common_google_signin_btn_tint));
        C0857a.m2807a(h, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(h);
        int i8 = C3082R.color.common_google_signin_btn_text_dark;
        int i9 = C3082R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zaa(i2, i8, i9, i9))));
        if (i == 0) {
            setText(resources.getString(C3082R.string.common_signin_button_text));
        } else if (i == 1) {
            setText(resources.getString(C3082R.string.common_signin_button_text_long));
        } else if (i == 2) {
            setText((CharSequence) null);
        } else {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Unknown button size: ");
            sb2.append(i);
            throw new IllegalStateException(sb2.toString());
        }
        setTransformationMethod((TransformationMethod) null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
