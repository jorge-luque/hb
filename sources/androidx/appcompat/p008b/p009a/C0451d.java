package androidx.appcompat.p008b.p009a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.p008b.p009a.C0446b;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.b.a.d */
/* compiled from: StateListDrawable */
class C0451d extends C0446b {

    /* renamed from: m */
    private C0452a f638m;

    /* renamed from: n */
    private boolean f639n;

    /* renamed from: androidx.appcompat.b.a.d$a */
    /* compiled from: StateListDrawable */
    static class C0452a extends C0446b.C0449c {

        /* renamed from: J */
        int[][] f640J;

        C0452a(C0452a aVar, C0451d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.f640J = aVar.f640J;
            } else {
                this.f640J = new int[mo2241c()][];
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo2290a(int[] iArr, Drawable drawable) {
            int a = mo2230a(drawable);
            this.f640J[a] = iArr;
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public void mo2182m() {
            int[][] iArr = this.f640J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.f640J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.f640J = iArr2;
        }

        public Drawable newDrawable() {
            return new C0451d(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0451d(this, resources);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo2289a(int[] iArr) {
            int[][] iArr2 = this.f640J;
            int d = mo2244d();
            for (int i = 0; i < d; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        /* renamed from: a */
        public void mo2232a(int i, int i2) {
            super.mo2232a(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.f640J, 0, iArr, 0, i);
            this.f640J = iArr;
        }
    }

    C0451d(C0452a aVar, Resources resources) {
        mo2167a((C0446b.C0449c) new C0452a(aVar, this, resources));
        onStateChange(getState());
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if (!this.f639n) {
            super.mutate();
            if (this == this) {
                this.f638m.mo2182m();
                this.f639n = true;
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int a = this.f638m.mo2289a(iArr);
        if (a < 0) {
            a = this.f638m.mo2289a(StateSet.WILD_CARD);
        }
        return mo2192a(a) || onStateChange;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo2288a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    C0451d(C0452a aVar) {
        if (aVar != null) {
            mo2167a((C0446b.C0449c) aVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0452a m712a() {
        return new C0452a(this.f638m, this, (Resources) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2167a(C0446b.C0449c cVar) {
        super.mo2167a(cVar);
        if (cVar instanceof C0452a) {
            this.f638m = (C0452a) cVar;
        }
    }
}
