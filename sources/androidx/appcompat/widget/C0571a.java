package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.C0851x;
import androidx.core.p020f.C0855y;

/* renamed from: androidx.appcompat.widget.a */
/* compiled from: AbsActionBarView */
abstract class C0571a extends ViewGroup {

    /* renamed from: a */
    protected final C0572a f1346a;

    /* renamed from: b */
    protected final Context f1347b;

    /* renamed from: c */
    protected ActionMenuView f1348c;

    /* renamed from: d */
    protected C0576c f1349d;

    /* renamed from: e */
    protected int f1350e;

    /* renamed from: f */
    protected C0851x f1351f;

    /* renamed from: g */
    private boolean f1352g;

    /* renamed from: h */
    private boolean f1353h;

    C0571a(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: a */
    protected static int m1493a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* renamed from: a */
    public abstract void mo2793a(int i);

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        mo2793a(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        C0576c cVar = this.f1349d;
        if (cVar != null) {
            cVar.mo3366a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1353h = false;
        }
        if (!this.f1353h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1353h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1353h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1352g = false;
        }
        if (!this.f1352g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1352g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1352g = false;
        }
        return true;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            C0851x xVar = this.f1351f;
            if (xVar != null) {
                xVar.mo4211a();
            }
            super.setVisibility(i);
        }
    }

    /* renamed from: androidx.appcompat.widget.a$a */
    /* compiled from: AbsActionBarView */
    protected class C0572a implements C0855y {

        /* renamed from: a */
        private boolean f1354a = false;

        /* renamed from: b */
        int f1355b;

        protected C0572a() {
        }

        /* renamed from: a */
        public C0572a mo3359a(C0851x xVar, int i) {
            C0571a.this.f1351f = xVar;
            this.f1355b = i;
            return this;
        }

        /* renamed from: b */
        public void mo2086b(View view) {
            if (!this.f1354a) {
                C0571a aVar = C0571a.this;
                aVar.f1351f = null;
                C0571a.super.setVisibility(this.f1355b);
            }
        }

        /* renamed from: c */
        public void mo2087c(View view) {
            C0571a.super.setVisibility(0);
            this.f1354a = false;
        }

        /* renamed from: a */
        public void mo3360a(View view) {
            this.f1354a = true;
        }
    }

    C0571a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public C0851x mo3354a(int i, long j) {
        C0851x xVar = this.f1351f;
        if (xVar != null) {
            xVar.mo4211a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            C0851x a = C0839t.m2688a(this);
            a.mo4206a(1.0f);
            a.mo4207a(j);
            C0572a aVar = this.f1346a;
            aVar.mo3359a(a, i);
            a.mo4210a((C0855y) aVar);
            return a;
        }
        C0851x a2 = C0839t.m2688a(this);
        a2.mo4206a(0.0f);
        a2.mo4207a(j);
        C0572a aVar2 = this.f1346a;
        aVar2.mo3359a(a2, i);
        a2.mo4210a((C0855y) aVar2);
        return a2;
    }

    C0571a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1346a = new C0572a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1347b = context;
        } else {
            this.f1347b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo3352a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo3353a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
