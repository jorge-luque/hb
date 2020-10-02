package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.view.menu.C0499n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0604i0;
import androidx.appcompat.widget.C0627t;

public class ActionMenuItemView extends AppCompatTextView implements C0499n.C0500a, View.OnClickListener, ActionMenuView.C0514a {

    /* renamed from: e */
    C0486i f713e;

    /* renamed from: f */
    private CharSequence f714f;

    /* renamed from: g */
    private Drawable f715g;

    /* renamed from: h */
    C0482g.C0484b f716h;

    /* renamed from: i */
    private C0627t f717i;

    /* renamed from: j */
    C0469b f718j;

    /* renamed from: k */
    private boolean f719k;

    /* renamed from: l */
    private boolean f720l;

    /* renamed from: m */
    private int f721m;

    /* renamed from: n */
    private int f722n;

    /* renamed from: o */
    private int f723o;

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$a */
    private class C0468a extends C0627t {
        public C0468a() {
            super(ActionMenuItemView.this);
        }

        /* renamed from: a */
        public C0502p mo2379a() {
            C0469b bVar = ActionMenuItemView.this.f718j;
            if (bVar != null) {
                return bVar.mo2381a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public boolean mo2380b() {
            C0502p a;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            C0482g.C0484b bVar = actionMenuItemView.f716h;
            if (bVar == null || !bVar.mo2383a(actionMenuItemView.f713e) || (a = mo2379a()) == null || !a.mo2476a()) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$b */
    public static abstract class C0469b {
        /* renamed from: a */
        public abstract C0502p mo2381a();
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: h */
    private boolean m798h() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    /* renamed from: i */
    private void m799i() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f714f);
        if (this.f715g != null && (!this.f713e.mo2627m() || (!this.f719k && !this.f720l))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.f714f : null);
        CharSequence contentDescription = this.f713e.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.f713e.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f713e.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.f713e.getTitle();
            }
            C0604i0.m1679a(this, charSequence2);
            return;
        }
        C0604i0.m1679a(this, tooltipText);
    }

    /* renamed from: a */
    public C0486i mo2363a() {
        return this.f713e;
    }

    /* renamed from: b */
    public boolean mo2369b() {
        return mo2372g();
    }

    /* renamed from: c */
    public boolean mo2370c() {
        return true;
    }

    /* renamed from: e */
    public boolean mo2371e() {
        return mo2372g() && this.f713e.getIcon() == null;
    }

    /* renamed from: g */
    public boolean mo2372g() {
        return !TextUtils.isEmpty(getText());
    }

    public void onClick(View view) {
        C0482g.C0484b bVar = this.f716h;
        if (bVar != null) {
            bVar.mo2383a(this.f713e);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f719k = m798h();
        m799i();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        boolean g = mo2372g();
        if (g && (i3 = this.f722n) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f721m) : this.f721m;
        if (mode != 1073741824 && this.f721m > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!g && this.f715g != null) {
            super.setPadding((getMeasuredWidth() - this.f715g.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0627t tVar;
        if (!this.f713e.hasSubMenu() || (tVar = this.f717i) == null || !tVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f722n = i;
        super.setPadding(i, i2, i3, i4);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public void mo2367a(C0486i iVar, int i) {
        this.f713e = iVar;
        mo2364a(iVar.getIcon());
        mo2368a(iVar.mo2591a((C0499n.C0500a) this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f717i == null) {
            this.f717i = new C0468a();
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f719k = m798h();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i, 0);
        this.f721m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f723o = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f722n = -1;
        setSaveEnabled(false);
    }

    /* renamed from: a */
    public void mo2366a(C0482g.C0484b bVar) {
        this.f716h = bVar;
    }

    /* renamed from: a */
    public void mo2365a(C0469b bVar) {
        this.f718j = bVar;
    }

    /* renamed from: a */
    public void mo2364a(Drawable drawable) {
        this.f715g = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f723o;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i) / ((float) intrinsicWidth)));
                intrinsicWidth = i;
            }
            int i2 = this.f723o;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i2) / ((float) intrinsicHeight)));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        m799i();
    }

    /* renamed from: a */
    public void mo2368a(CharSequence charSequence) {
        this.f714f = charSequence;
        m799i();
    }
}
