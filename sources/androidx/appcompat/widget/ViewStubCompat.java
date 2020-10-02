package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: a */
    private int f1341a;

    /* renamed from: b */
    private int f1342b;

    /* renamed from: c */
    private WeakReference<View> f1343c;

    /* renamed from: d */
    private LayoutInflater f1344d;

    /* renamed from: e */
    private C0570a f1345e;

    /* renamed from: androidx.appcompat.widget.ViewStubCompat$a */
    public interface C0570a {
        /* renamed from: a */
        void mo3351a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public void mo3346a(LayoutInflater layoutInflater) {
        this.f1344d = layoutInflater;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.f1343c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            mo3345a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1341a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewStubCompat, i, 0);
        this.f1342b = obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_inflatedId, -1);
        this.f1341a = obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    /* renamed from: a */
    public View mo3345a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1341a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.f1344d;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1341a, viewGroup, false);
            int i = this.f1342b;
            if (i != -1) {
                inflate.setId(i);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1343c = new WeakReference<>(inflate);
            C0570a aVar = this.f1345e;
            if (aVar != null) {
                aVar.mo3351a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }
}
