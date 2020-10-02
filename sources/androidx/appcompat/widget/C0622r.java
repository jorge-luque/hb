package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.p008b.p009a.C0450c;
import androidx.core.graphics.drawable.C0857a;
import androidx.core.p020f.C0851x;
import androidx.core.widget.C0876f;
import java.lang.reflect.Field;

/* renamed from: androidx.appcompat.widget.r */
/* compiled from: DropDownListView */
class C0622r extends ListView {

    /* renamed from: a */
    private final Rect f1541a = new Rect();

    /* renamed from: b */
    private int f1542b = 0;

    /* renamed from: c */
    private int f1543c = 0;

    /* renamed from: d */
    private int f1544d = 0;

    /* renamed from: e */
    private int f1545e = 0;

    /* renamed from: f */
    private int f1546f;

    /* renamed from: g */
    private Field f1547g;

    /* renamed from: h */
    private C0623a f1548h;

    /* renamed from: i */
    private boolean f1549i;

    /* renamed from: j */
    private boolean f1550j;

    /* renamed from: k */
    private boolean f1551k;

    /* renamed from: l */
    private C0851x f1552l;

    /* renamed from: m */
    private C0876f f1553m;

    /* renamed from: n */
    C0624b f1554n;

    /* renamed from: androidx.appcompat.widget.r$a */
    /* compiled from: DropDownListView */
    private static class C0623a extends C0450c {

        /* renamed from: b */
        private boolean f1555b = true;

        C0623a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3563a(boolean z) {
            this.f1555b = z;
        }

        public void draw(Canvas canvas) {
            if (this.f1555b) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f1555b) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f1555b) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f1555b) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1555b) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.r$b */
    /* compiled from: DropDownListView */
    private class C0624b implements Runnable {
        C0624b() {
        }

        /* renamed from: a */
        public void mo3564a() {
            C0622r rVar = C0622r.this;
            rVar.f1554n = null;
            rVar.removeCallbacks(this);
        }

        /* renamed from: b */
        public void mo3565b() {
            C0622r.this.post(this);
        }

        public void run() {
            C0622r rVar = C0622r.this;
            rVar.f1554n = null;
            rVar.drawableStateChanged();
        }
    }

    C0622r(Context context, boolean z) {
        super(context, (AttributeSet) null, R$attr.dropDownListViewStyle);
        this.f1550j = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1547g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m1818b(boolean z) {
        C0623a aVar = this.f1548h;
        if (aVar != null) {
            aVar.mo3563a(z);
        }
    }

    /* renamed from: c */
    private void m1820c() {
        Drawable selector = getSelector();
        if (selector != null && m1819b() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* renamed from: a */
    public int mo3550a(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i7 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < count) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i11 = layoutParams.height;
            if (i11 > 0) {
                i6 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else {
                i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, i6);
            view.forceLayout();
            if (i8 > 0) {
                i7 += dividerHeight;
            }
            i7 += view.getMeasuredHeight();
            if (i7 >= i4) {
                return (i5 < 0 || i8 <= i5 || i10 <= 0 || i7 == i4) ? i4 : i10;
            }
            if (i5 >= 0 && i8 >= i5) {
                i10 = i7;
            }
            i8++;
        }
        return i7;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        m1814a(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f1554n == null) {
            super.drawableStateChanged();
            m1818b(true);
            m1820c();
        }
    }

    public boolean hasFocus() {
        return this.f1550j || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f1550j || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f1550j || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f1550j && this.f1549i) || super.isInTouchMode();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1554n = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1554n == null) {
            C0624b bVar = new C0624b();
            this.f1554n = bVar;
            bVar.mo3565b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                m1820c();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1546f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        C0624b bVar = this.f1554n;
        if (bVar != null) {
            bVar.mo3564a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSelector(Drawable drawable) {
        C0623a aVar = drawable != null ? new C0623a(drawable) : null;
        this.f1548h = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1542b = rect.left;
        this.f1543c = rect.top;
        this.f1544d = rect.right;
        this.f1545e = rect.bottom;
    }

    /* renamed from: b */
    private void m1817b(int i, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m1812a(i, view);
        if (z2) {
            Rect rect = this.f1541a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0857a.m2802a(selector, exactCenterX, exactCenterY);
        }
    }

    /* renamed from: b */
    private boolean m1819b() {
        return this.f1551k;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo3552a(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r9 = 0
            r3 = 1
            goto L_0x0046
        L_0x0011:
            r9 = 0
            r3 = 0
            goto L_0x0046
        L_0x0014:
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = 1
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.m1816a((android.view.View) r3, (int) r5, (float) r4, (float) r9)
            if (r0 != r2) goto L_0x000e
            r7.m1815a((android.view.View) r3, (int) r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.m1811a()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.f r9 = r7.f1553m
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f1553m = r9
        L_0x005a:
            androidx.core.widget.f r9 = r7.f1553m
            r9.mo4338a((boolean) r2)
            androidx.core.widget.f r9 = r7.f1553m
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.f r8 = r7.f1553m
            if (r8 == 0) goto L_0x006c
            r8.mo4338a((boolean) r1)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0622r.mo3552a(android.view.MotionEvent, int):boolean");
    }

    /* renamed from: a */
    private void m1815a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3551a(boolean z) {
        this.f1549i = z;
    }

    /* renamed from: a */
    private void m1814a(Canvas canvas) {
        Drawable selector;
        if (!this.f1541a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1541a);
            selector.draw(canvas);
        }
    }

    /* renamed from: a */
    private void m1813a(int i, View view, float f, float f2) {
        m1817b(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0857a.m2802a(selector, f, f2);
        }
    }

    /* renamed from: a */
    private void m1812a(int i, View view) {
        Rect rect = this.f1541a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1542b;
        rect.top -= this.f1543c;
        rect.right += this.f1544d;
        rect.bottom += this.f1545e;
        try {
            boolean z = this.f1547g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1547g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m1811a() {
        this.f1551k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1546f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        C0851x xVar = this.f1552l;
        if (xVar != null) {
            xVar.mo4211a();
            this.f1552l = null;
        }
    }

    /* renamed from: a */
    private void m1816a(View view, int i, float f, float f2) {
        View childAt;
        this.f1551k = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.f1546f;
        if (!(i2 == -1 || (childAt = getChildAt(i2 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f1546f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m1813a(i, view, f, f2);
        m1818b(false);
        refreshDrawableState();
    }
}
