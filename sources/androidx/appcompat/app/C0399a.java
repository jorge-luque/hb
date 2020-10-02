package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import androidx.appcompat.p011d.C0455b;

/* renamed from: androidx.appcompat.app.a */
/* compiled from: ActionBar */
public abstract class C0399a {

    /* renamed from: androidx.appcompat.app.a$b */
    /* compiled from: ActionBar */
    public interface C0401b {
        /* renamed from: a */
        void mo1970a(boolean z);
    }

    /* renamed from: a */
    public abstract C0455b mo1955a(C0455b.C0456a aVar);

    /* renamed from: a */
    public abstract void mo1956a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo1957a(CharSequence charSequence);

    /* renamed from: a */
    public abstract boolean mo1958a(int i, KeyEvent keyEvent);

    /* renamed from: a */
    public boolean mo1959a(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public abstract void mo1960b(boolean z);

    /* renamed from: c */
    public abstract void mo1961c(boolean z);

    /* renamed from: d */
    public abstract void mo1962d(boolean z);

    /* renamed from: e */
    public boolean mo1963e() {
        return false;
    }

    /* renamed from: f */
    public abstract boolean mo1964f();

    /* renamed from: g */
    public abstract int mo1965g();

    /* renamed from: h */
    public abstract Context mo1966h();

    /* renamed from: i */
    public boolean mo1967i() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo1968j() {
    }

    /* renamed from: k */
    public boolean mo1969k() {
        return false;
    }

    /* renamed from: androidx.appcompat.app.a$a */
    /* compiled from: ActionBar */
    public static class C0400a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f406a;

        public C0400a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f406a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
            this.f406a = obtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0400a(int i, int i2) {
            super(i, i2);
            this.f406a = 0;
            this.f406a = 8388627;
        }

        public C0400a(C0400a aVar) {
            super(aVar);
            this.f406a = 0;
            this.f406a = aVar.f406a;
        }

        public C0400a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f406a = 0;
        }
    }
}
