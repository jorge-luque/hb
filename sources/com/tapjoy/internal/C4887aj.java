package com.tapjoy.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.tapjoy.internal.aj */
public class C4887aj extends ViewGroup {
    public C4887aj(Context context) {
        super(context);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        measureChildren(i, i2);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                i3 = Math.max(i3, childAt.getMeasuredWidth());
                i4 = Math.max(i4, childAt.getMeasuredHeight());
            }
        }
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(i3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i), ViewGroup.resolveSize(Math.max(i4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2));
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.LayoutParams(layoutParams);
    }
}
