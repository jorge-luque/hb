package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.C0497m;
import androidx.core.p020f.C0832m;
import androidx.core.p020f.C0833n;
import androidx.core.p020f.C0834o;
import androidx.core.p020f.C0835p;
import androidx.core.p020f.C0839t;

public class ActionBarOverlayLayout extends ViewGroup implements C0619o, C0834o, C0832m, C0833n {

    /* renamed from: B */
    static final int[] f965B = {R$attr.actionBarSize, 16842841};

    /* renamed from: A */
    private final C0835p f966A;

    /* renamed from: a */
    private int f967a;

    /* renamed from: b */
    private int f968b;

    /* renamed from: c */
    private ContentFrameLayout f969c;

    /* renamed from: d */
    ActionBarContainer f970d;

    /* renamed from: e */
    private C0620p f971e;

    /* renamed from: f */
    private Drawable f972f;

    /* renamed from: g */
    private boolean f973g;

    /* renamed from: h */
    private boolean f974h;

    /* renamed from: i */
    private boolean f975i;

    /* renamed from: j */
    private boolean f976j;

    /* renamed from: k */
    boolean f977k;

    /* renamed from: l */
    private int f978l;

    /* renamed from: m */
    private int f979m;

    /* renamed from: n */
    private final Rect f980n;

    /* renamed from: o */
    private final Rect f981o;

    /* renamed from: p */
    private final Rect f982p;

    /* renamed from: q */
    private final Rect f983q;

    /* renamed from: r */
    private final Rect f984r;

    /* renamed from: s */
    private final Rect f985s;

    /* renamed from: t */
    private final Rect f986t;

    /* renamed from: u */
    private C0512d f987u;

    /* renamed from: v */
    private OverScroller f988v;

    /* renamed from: w */
    ViewPropertyAnimator f989w;

    /* renamed from: x */
    final AnimatorListenerAdapter f990x;

    /* renamed from: y */
    private final Runnable f991y;

    /* renamed from: z */
    private final Runnable f992z;

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$a */
    class C0509a extends AnimatorListenerAdapter {
        C0509a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f989w = null;
            actionBarOverlayLayout.f977k = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f989w = null;
            actionBarOverlayLayout.f977k = false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$b */
    class C0510b implements Runnable {
        C0510b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.mo2843i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f989w = actionBarOverlayLayout.f970d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f990x);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$c */
    class C0511c implements Runnable {
        C0511c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.mo2843i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f989w = actionBarOverlayLayout.f970d.animate().translationY((float) (-ActionBarOverlayLayout.this.f970d.getHeight())).setListener(ActionBarOverlayLayout.this.f990x);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$d */
    public interface C0512d {
        /* renamed from: a */
        void mo2133a();

        /* renamed from: a */
        void mo2136a(boolean z);

        /* renamed from: b */
        void mo2137b();

        /* renamed from: c */
        void mo2138c();

        /* renamed from: d */
        void mo2139d();

        void onWindowVisibilityChanged(int i);
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$e */
    public static class C0513e extends ViewGroup.MarginLayoutParams {
        public C0513e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0513e(int i, int i2) {
            super(i, i2);
        }

        public C0513e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    private void m1086a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f965B);
        boolean z = false;
        this.f967a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f972f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.f973g = z;
        this.f988v = new OverScroller(context);
    }

    /* renamed from: l */
    private void m1089l() {
        mo2843i();
        this.f992z.run();
    }

    /* renamed from: m */
    private void m1090m() {
        mo2843i();
        postDelayed(this.f992z, 600);
    }

    /* renamed from: n */
    private void m1091n() {
        mo2843i();
        postDelayed(this.f991y, 600);
    }

    /* renamed from: o */
    private void m1092o() {
        mo2843i();
        this.f991y.run();
    }

    /* renamed from: b */
    public void mo2826b(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    /* renamed from: c */
    public void mo2828c(boolean z) {
        this.f974h = z;
        this.f973g = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0513e;
    }

    /* renamed from: d */
    public void mo2831d(boolean z) {
    }

    /* renamed from: d */
    public boolean mo2832d() {
        mo2845k();
        return this.f971e.mo3470d();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f972f != null && !this.f973g) {
            int bottom = this.f970d.getVisibility() == 0 ? (int) (((float) this.f970d.getBottom()) + this.f970d.getTranslationY() + 0.5f) : 0;
            this.f972f.setBounds(0, bottom, getWidth(), this.f972f.getIntrinsicHeight() + bottom);
            this.f972f.draw(canvas);
        }
    }

    /* renamed from: e */
    public boolean mo2834e() {
        mo2845k();
        return this.f971e.mo3471e();
    }

    /* renamed from: f */
    public boolean mo2835f() {
        mo2845k();
        return this.f971e.mo3472f();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        mo2845k();
        int s = C0839t.m2730s(this) & 256;
        boolean a = m1088a((View) this.f970d, rect, true, true, false, true);
        this.f983q.set(rect);
        C0616m0.m1738a(this, this.f983q, this.f980n);
        if (!this.f984r.equals(this.f983q)) {
            this.f984r.set(this.f983q);
            a = true;
        }
        if (!this.f981o.equals(this.f980n)) {
            this.f981o.set(this.f980n);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    /* renamed from: g */
    public void mo2837g() {
        mo2845k();
        this.f971e.mo3473g();
    }

    public int getNestedScrollAxes() {
        return this.f966A.mo4189a();
    }

    /* renamed from: h */
    public int mo2842h() {
        ActionBarContainer actionBarContainer = this.f970d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo2843i() {
        removeCallbacks(this.f991y);
        removeCallbacks(this.f992z);
        ViewPropertyAnimator viewPropertyAnimator = this.f989w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    /* renamed from: j */
    public boolean mo2844j() {
        return this.f974h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo2845k() {
        if (this.f969c == null) {
            this.f969c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f970d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f971e = m1085a(findViewById(R$id.action_bar));
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1086a(getContext());
        C0839t.m2683B(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo2843i();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0513e eVar = (C0513e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = eVar.leftMargin + paddingLeft;
                int i7 = eVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        mo2845k();
        measureChildWithMargins(this.f970d, i, 0, i2, 0);
        C0513e eVar = (C0513e) this.f970d.getLayoutParams();
        int max = Math.max(0, this.f970d.getMeasuredWidth() + eVar.leftMargin + eVar.rightMargin);
        int max2 = Math.max(0, this.f970d.getMeasuredHeight() + eVar.topMargin + eVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f970d.getMeasuredState());
        boolean z = (C0839t.m2730s(this) & 256) != 0;
        if (z) {
            i3 = this.f967a;
            if (this.f975i && this.f970d.mo2777a() != null) {
                i3 += this.f967a;
            }
        } else {
            i3 = this.f970d.getVisibility() != 8 ? this.f970d.getMeasuredHeight() : 0;
        }
        this.f982p.set(this.f980n);
        this.f985s.set(this.f983q);
        if (this.f974h || z) {
            Rect rect = this.f985s;
            rect.top += i3;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.f982p;
            rect2.top += i3;
            rect2.bottom += 0;
        }
        m1088a((View) this.f969c, this.f982p, true, true, true, true);
        if (!this.f986t.equals(this.f985s)) {
            this.f986t.set(this.f985s);
            this.f969c.mo3116a(this.f985s);
        }
        measureChildWithMargins(this.f969c, i, 0, i2, 0);
        C0513e eVar2 = (C0513e) this.f969c.getLayoutParams();
        int max3 = Math.max(max, this.f969c.getMeasuredWidth() + eVar2.leftMargin + eVar2.rightMargin);
        int max4 = Math.max(max2, this.f969c.getMeasuredHeight() + eVar2.topMargin + eVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f969c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f976j || !z) {
            return false;
        }
        if (m1087a(f, f2)) {
            m1089l();
        } else {
            m1092o();
        }
        this.f977k = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.f978l + i2;
        this.f978l = i5;
        mo2825b(i5);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f966A.mo4191a(view, view2, i);
        this.f978l = mo2842h();
        mo2843i();
        C0512d dVar = this.f987u;
        if (dVar != null) {
            dVar.mo2139d();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f970d.getVisibility() != 0) {
            return false;
        }
        return this.f976j;
    }

    public void onStopNestedScroll(View view) {
        if (this.f976j && !this.f977k) {
            if (this.f978l <= this.f970d.getHeight()) {
                m1091n();
            } else {
                m1090m();
            }
        }
        C0512d dVar = this.f987u;
        if (dVar != null) {
            dVar.mo2137b();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        mo2845k();
        int i2 = this.f979m ^ i;
        this.f979m = i;
        boolean z = false;
        boolean z2 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        }
        C0512d dVar = this.f987u;
        if (dVar != null) {
            dVar.mo2136a(!z);
            if (z2 || !z) {
                this.f987u.mo2133a();
            } else {
                this.f987u.mo2138c();
            }
        }
        if ((i2 & 256) != 0 && this.f987u != null) {
            C0839t.m2683B(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f968b = i;
        C0512d dVar = this.f987u;
        if (dVar != null) {
            dVar.onWindowVisibilityChanged(i);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f968b = 0;
        this.f980n = new Rect();
        this.f981o = new Rect();
        this.f982p = new Rect();
        this.f983q = new Rect();
        this.f984r = new Rect();
        this.f985s = new Rect();
        this.f986t = new Rect();
        this.f990x = new C0509a();
        this.f991y = new C0510b();
        this.f992z = new C0511c();
        m1086a(context);
        this.f966A = new C0835p(this);
    }

    /* renamed from: b */
    public void mo2827b(boolean z) {
        if (z != this.f976j) {
            this.f976j = z;
            if (!z) {
                mo2843i();
                mo2825b(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public C0513e generateDefaultLayoutParams() {
        return new C0513e(-1, -1);
    }

    public C0513e generateLayoutParams(AttributeSet attributeSet) {
        return new C0513e(getContext(), attributeSet);
    }

    /* renamed from: c */
    public boolean mo2829c() {
        mo2845k();
        return this.f971e.mo3466c();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0513e(layoutParams);
    }

    /* renamed from: b */
    public void mo2825b(int i) {
        mo2843i();
        this.f970d.setTranslationY((float) (-Math.max(0, Math.min(i, this.f970d.getHeight()))));
    }

    /* renamed from: a */
    public void mo2819a(C0512d dVar) {
        this.f987u = dVar;
        if (getWindowToken() != null) {
            this.f987u.onWindowVisibilityChanged(this.f968b);
            int i = this.f979m;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                C0839t.m2683B(this);
            }
        }
    }

    /* renamed from: b */
    public void mo2824b() {
        mo2845k();
        this.f971e.mo3458b();
    }

    /* renamed from: a */
    public void mo2821a(boolean z) {
        this.f975i = z;
    }

    /* renamed from: a */
    private boolean m1088a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        int i;
        int i2;
        int i3;
        int i4;
        C0513e eVar = (C0513e) view.getLayoutParams();
        if (!z || eVar.leftMargin == (i4 = rect.left)) {
            z5 = false;
        } else {
            eVar.leftMargin = i4;
            z5 = true;
        }
        if (z2 && eVar.topMargin != (i3 = rect.top)) {
            eVar.topMargin = i3;
            z5 = true;
        }
        if (z4 && eVar.rightMargin != (i2 = rect.right)) {
            eVar.rightMargin = i2;
            z5 = true;
        }
        if (!z3 || eVar.bottomMargin == (i = rect.bottom)) {
            return z5;
        }
        eVar.bottomMargin = i;
        return true;
    }

    /* renamed from: a */
    public void mo2816a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        mo2815a(view, i, i2, i3, i4, i5);
    }

    /* renamed from: a */
    public boolean mo2823a(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    /* renamed from: a */
    public void mo2814a(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    /* renamed from: a */
    public void mo2815a(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public void mo2817a(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    /* renamed from: a */
    private C0620p m1085a(View view) {
        if (view instanceof C0620p) {
            return (C0620p) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).mo3331q();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* renamed from: a */
    private boolean m1087a(float f, float f2) {
        this.f988v.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f988v.getFinalY() > this.f970d.getHeight();
    }

    /* renamed from: a */
    public void mo2818a(Window.Callback callback) {
        mo2845k();
        this.f971e.mo3453a(callback);
    }

    /* renamed from: a */
    public void mo2820a(CharSequence charSequence) {
        mo2845k();
        this.f971e.mo3455a(charSequence);
    }

    /* renamed from: a */
    public void mo2812a(int i) {
        mo2845k();
        if (i == 2) {
            this.f971e.mo3479l();
        } else if (i == 5) {
            this.f971e.mo3480m();
        } else if (i == 109) {
            mo2828c(true);
        }
    }

    /* renamed from: a */
    public boolean mo2822a() {
        mo2845k();
        return this.f971e.mo3457a();
    }

    /* renamed from: a */
    public void mo2813a(Menu menu, C0497m.C0498a aVar) {
        mo2845k();
        this.f971e.mo3451a(menu, aVar);
    }
}
