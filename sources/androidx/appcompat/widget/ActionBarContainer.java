package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.p020f.C0839t;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    private boolean f942a;

    /* renamed from: b */
    private View f943b;

    /* renamed from: c */
    private View f944c;

    /* renamed from: d */
    private View f945d;

    /* renamed from: e */
    Drawable f946e;

    /* renamed from: f */
    Drawable f947f;

    /* renamed from: g */
    Drawable f948g;

    /* renamed from: h */
    boolean f949h;

    /* renamed from: i */
    boolean f950i;

    /* renamed from: j */
    private int f951j;

    public ActionBarContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: b */
    private boolean m1068b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: a */
    public void mo2779a(boolean z) {
        this.f942a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f946e;
        if (drawable != null && drawable.isStateful()) {
            this.f946e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f947f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f947f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f948g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f948g.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f946e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f947f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f948g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f944c = findViewById(R$id.action_bar);
        this.f945d = findViewById(R$id.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f942a || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f943b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i5 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - i5, i3, measuredHeight - i5);
        }
        if (this.f949h) {
            Drawable drawable2 = this.f948g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f946e != null) {
                if (this.f944c.getVisibility() == 0) {
                    this.f946e.setBounds(this.f944c.getLeft(), this.f944c.getTop(), this.f944c.getRight(), this.f944c.getBottom());
                } else {
                    View view2 = this.f945d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f946e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f946e.setBounds(this.f945d.getLeft(), this.f945d.getTop(), this.f945d.getRight(), this.f945d.getBottom());
                    }
                }
                z3 = true;
            }
            this.f950i = z4;
            if (!z4 || (drawable = this.f947f) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.f944c == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i4 = this.f951j) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f944c != null) {
            int mode = View.MeasureSpec.getMode(i2);
            View view = this.f943b;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!m1068b(this.f944c)) {
                    i3 = m1067a(this.f944c);
                } else {
                    i3 = !m1068b(this.f945d) ? m1067a(this.f945d) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + m1067a(this.f943b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f946e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f947f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f948g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f946e && !this.f949h) || (drawable == this.f947f && this.f950i) || ((drawable == this.f948g && this.f949h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0839t.m2696a((View) this, (Drawable) new C0574b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBar);
        this.f946e = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f947f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f951j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R$id.split_action_bar) {
            this.f949h = true;
            this.f948g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f949h ? !(this.f946e == null && this.f947f == null) : this.f948g != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    /* renamed from: a */
    public void mo2778a(C0642z zVar) {
        View view = this.f943b;
        if (view != null) {
            removeView(view);
        }
        this.f943b = zVar;
        if (zVar != null) {
            addView(zVar);
            ViewGroup.LayoutParams layoutParams = zVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            zVar.mo3638a(false);
            throw null;
        }
    }

    /* renamed from: a */
    public View mo2777a() {
        return this.f943b;
    }

    /* renamed from: a */
    private int m1067a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }
}
