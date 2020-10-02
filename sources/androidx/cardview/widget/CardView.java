package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

public class CardView extends FrameLayout {

    /* renamed from: h */
    private static final int[] f1635h = {16842801};

    /* renamed from: i */
    private static final C0665e f1636i;

    /* renamed from: a */
    private boolean f1637a;

    /* renamed from: b */
    private boolean f1638b;

    /* renamed from: c */
    int f1639c;

    /* renamed from: d */
    int f1640d;

    /* renamed from: e */
    final Rect f1641e;

    /* renamed from: f */
    final Rect f1642f;

    /* renamed from: g */
    private final C0664d f1643g;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f1636i = new C0661b();
        } else if (i >= 17) {
            f1636i = new C0659a();
        } else {
            f1636i = new C0662c();
        }
        f1636i.mo3682a();
    }

    public CardView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!(f1636i instanceof C0661b)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1636i.mo3687b(this.f1643g)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1636i.mo3684a(this.f1643g)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setMinimumHeight(int i) {
        this.f1640d = i;
        super.setMinimumHeight(i);
    }

    public void setMinimumWidth(int i) {
        this.f1639c = i;
        super.setMinimumWidth(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    /* renamed from: androidx.cardview.widget.CardView$a */
    class C0658a implements C0664d {

        /* renamed from: a */
        private Drawable f1644a;

        C0658a() {
        }

        /* renamed from: a */
        public void mo3677a(Drawable drawable) {
            this.f1644a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        /* renamed from: b */
        public boolean mo3679b() {
            return CardView.this.mo3669b();
        }

        /* renamed from: c */
        public Drawable mo3680c() {
            return this.f1644a;
        }

        /* renamed from: d */
        public View mo3681d() {
            return CardView.this;
        }

        /* renamed from: a */
        public boolean mo3678a() {
            return CardView.this.mo3667a();
        }

        /* renamed from: a */
        public void mo3676a(int i, int i2, int i3, int i4) {
            CardView.this.f1642f.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.f1641e;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }

        /* renamed from: a */
        public void mo3675a(int i, int i2) {
            CardView cardView = CardView.this;
            if (i > cardView.f1639c) {
                CardView.super.setMinimumWidth(i);
            }
            CardView cardView2 = CardView.this;
            if (i2 > cardView2.f1640d) {
                CardView.super.setMinimumHeight(i2);
            }
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    /* renamed from: b */
    public boolean mo3669b() {
        return this.f1637a;
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        ColorStateList valueOf;
        this.f1641e = new Rect();
        this.f1642f = new Rect();
        this.f1643g = new C0658a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i, R$style.CardView);
        if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R$styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1635h);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i2 = getResources().getColor(R$color.cardview_light_background);
            } else {
                i2 = getResources().getColor(R$color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i2);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.f1637a = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.f1638b = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        this.f1641e.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f1641e.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.f1641e.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.f1641e.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1639c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f1640d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f1636i.mo3686a(this.f1643g, context, colorStateList, dimension, dimension2, f);
    }

    /* renamed from: a */
    public void mo3665a(float f) {
        f1636i.mo3688b(this.f1643g, f);
    }

    /* renamed from: b */
    public void mo3668b(float f) {
        f1636i.mo3685a(this.f1643g, f);
    }

    /* renamed from: a */
    public boolean mo3667a() {
        return this.f1638b;
    }

    /* renamed from: a */
    public void mo3666a(boolean z) {
        if (z != this.f1638b) {
            this.f1638b = z;
            f1636i.mo3689c(this.f1643g);
        }
    }
}
