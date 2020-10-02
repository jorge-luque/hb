package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.p011d.C0455b;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.view.menu.C0497m;
import androidx.core.p020f.C0839t;

public class ActionBarContextView extends C0571a {

    /* renamed from: i */
    private CharSequence f952i;

    /* renamed from: j */
    private CharSequence f953j;

    /* renamed from: k */
    private View f954k;

    /* renamed from: l */
    private View f955l;

    /* renamed from: m */
    private LinearLayout f956m;

    /* renamed from: n */
    private TextView f957n;

    /* renamed from: o */
    private TextView f958o;

    /* renamed from: p */
    private int f959p;

    /* renamed from: q */
    private int f960q;

    /* renamed from: r */
    private boolean f961r;

    /* renamed from: s */
    private int f962s;

    /* renamed from: androidx.appcompat.widget.ActionBarContextView$a */
    class C0508a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ C0455b f963a;

        C0508a(C0455b bVar) {
            this.f963a = bVar;
        }

        public void onClick(View view) {
            this.f963a.mo2150a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: g */
    private void m1072g() {
        if (this.f956m == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f956m = linearLayout;
            this.f957n = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f958o = (TextView) this.f956m.findViewById(R$id.action_bar_subtitle);
            if (this.f959p != 0) {
                this.f957n.setTextAppearance(getContext(), this.f959p);
            }
            if (this.f960q != 0) {
                this.f958o.setTextAppearance(getContext(), this.f960q);
            }
        }
        this.f957n.setText(this.f952i);
        this.f958o.setText(this.f953j);
        boolean z = !TextUtils.isEmpty(this.f952i);
        boolean z2 = !TextUtils.isEmpty(this.f953j);
        int i = 0;
        this.f958o.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout2 = this.f956m;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        if (this.f956m.getParent() == null) {
            addView(this.f956m);
        }
    }

    /* renamed from: b */
    public void mo2799b(CharSequence charSequence) {
        this.f952i = charSequence;
        m1072g();
    }

    /* renamed from: c */
    public CharSequence mo2800c() {
        return this.f952i;
    }

    /* renamed from: d */
    public boolean mo2801d() {
        return this.f961r;
    }

    /* renamed from: e */
    public void mo2802e() {
        removeAllViews();
        this.f955l = null;
        this.f1348c = null;
    }

    /* renamed from: f */
    public boolean mo2803f() {
        C0576c cVar = this.f1349d;
        if (cVar != null) {
            return cVar.mo3376h();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0576c cVar = this.f1349d;
        if (cVar != null) {
            cVar.mo3372d();
            this.f1349d.mo3373e();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(ActionBarContextView.class.getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f952i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean a = C0616m0.m1739a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f954k;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f954k.getLayoutParams();
            int i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a2 = C0571a.m1493a(paddingRight, i5, a);
            paddingRight = C0571a.m1493a(a2 + mo3353a(this.f954k, a2, paddingTop, paddingTop2, a), i6, a);
        }
        int i7 = paddingRight;
        LinearLayout linearLayout = this.f956m;
        if (!(linearLayout == null || this.f955l != null || linearLayout.getVisibility() == 8)) {
            i7 += mo3353a(this.f956m, i7, paddingTop, paddingTop2, a);
        }
        int i8 = i7;
        View view2 = this.f955l;
        if (view2 != null) {
            mo3353a(view2, i8, paddingTop, paddingTop2, a);
        }
        int paddingLeft = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1348c;
        if (actionMenuView != null) {
            mo3353a(actionMenuView, paddingLeft, paddingTop, paddingTop2, !a);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            int i4 = this.f1350e;
            if (i4 <= 0) {
                i4 = View.MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = i4 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            View view = this.f954k;
            if (view != null) {
                int a = mo3352a(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f954k.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f1348c;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = mo3352a(this.f1348c, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.f956m;
            if (linearLayout != null && this.f955l == null) {
                if (this.f961r) {
                    this.f956m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f956m.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f956m.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = mo3352a(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.f955l;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i6 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                int i7 = layoutParams.width;
                if (i7 >= 0) {
                    paddingLeft = Math.min(i7, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                int i8 = layoutParams.height;
                if (i8 >= 0) {
                    i5 = Math.min(i8, i5);
                }
                this.f955l.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i5, i3));
            }
            if (this.f1350e <= 0) {
                int childCount = getChildCount();
                int i9 = 0;
                for (int i10 = 0; i10 < childCount; i10++) {
                    int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i9) {
                        i9 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i9);
                return;
            }
            setMeasuredDimension(size, i4);
        } else {
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    /* renamed from: a */
    public void mo2793a(int i) {
        this.f1350e = i;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0598g0 a = C0598g0.m1610a(context, attributeSet, R$styleable.ActionMode, i, 0);
        C0839t.m2696a((View) this, a.mo3437b(R$styleable.ActionMode_background));
        this.f959p = a.mo3446g(R$styleable.ActionMode_titleTextStyle, 0);
        this.f960q = a.mo3446g(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f1350e = a.mo3444f(R$styleable.ActionMode_height, 0);
        this.f962s = a.mo3446g(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        a.mo3434a();
    }

    /* renamed from: a */
    public void mo2794a(View view) {
        LinearLayout linearLayout;
        View view2 = this.f955l;
        if (view2 != null) {
            removeView(view2);
        }
        this.f955l = view;
        if (!(view == null || (linearLayout = this.f956m) == null)) {
            removeView(linearLayout);
            this.f956m = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    /* renamed from: b */
    public CharSequence mo2798b() {
        return this.f953j;
    }

    /* renamed from: a */
    public void mo2796a(CharSequence charSequence) {
        this.f953j = charSequence;
        m1072g();
    }

    /* renamed from: a */
    public void mo2795a(C0455b bVar) {
        View view = this.f954k;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f962s, this, false);
            this.f954k = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f954k);
        }
        this.f954k.findViewById(R$id.action_mode_close_button).setOnClickListener(new C0508a(bVar));
        C0482g gVar = (C0482g) bVar.mo2158c();
        C0576c cVar = this.f1349d;
        if (cVar != null) {
            cVar.mo3370c();
        }
        C0576c cVar2 = new C0576c(getContext());
        this.f1349d = cVar2;
        cVar2.mo3371d(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.mo2524a((C0497m) this.f1349d, this.f1347b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1349d.mo2465b((ViewGroup) this);
        this.f1348c = actionMenuView;
        C0839t.m2696a((View) actionMenuView, (Drawable) null);
        addView(this.f1348c, layoutParams);
    }

    /* renamed from: a */
    public void mo2792a() {
        if (this.f954k == null) {
            mo2802e();
        }
    }

    /* renamed from: a */
    public void mo2797a(boolean z) {
        if (z != this.f961r) {
            requestLayout();
        }
        this.f961r = z;
    }
}
