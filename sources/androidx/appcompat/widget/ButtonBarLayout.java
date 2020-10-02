package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.p020f.C0839t;

public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a */
    private boolean f1107a;

    /* renamed from: b */
    private int f1108b = -1;

    /* renamed from: c */
    private int f1109c = 0;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ButtonBarLayout);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R$styleable.ButtonBarLayout, attributeSet, obtainStyledAttributes, 0, 0);
        }
        this.f1107a = obtainStyledAttributes.getBoolean(R$styleable.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private int m1269a(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int getMinimumHeight() {
        return Math.max(this.f1109c, super.getMinimumHeight());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        if (this.f1107a) {
            if (size > this.f1108b && m1271a()) {
                m1270a(false);
            }
            this.f1108b = size;
        }
        if (m1271a() || View.MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f1107a && !m1271a()) {
            if ((getMeasuredWidthAndState() & -16777216) == 16777216) {
                m1270a(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
        int a = m1269a(0);
        if (a >= 0) {
            View childAt = getChildAt(a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (m1271a()) {
                int a2 = m1269a(a + 1);
                if (a2 >= 0) {
                    paddingTop += getChildAt(a2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i4 = paddingTop;
            } else {
                i4 = paddingTop + getPaddingBottom();
            }
        }
        if (C0839t.m2726o(this) != i4) {
            setMinimumHeight(i4);
        }
    }

    /* renamed from: a */
    private void m1270a(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(R$id.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    /* renamed from: a */
    private boolean m1271a() {
        return getOrientation() == 1;
    }
}
