package androidx.core.p020f;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.core.f.p */
/* compiled from: NestedScrollingParentHelper */
public class C0835p {

    /* renamed from: a */
    private int f2041a;

    /* renamed from: b */
    private int f2042b;

    public C0835p(ViewGroup viewGroup) {
    }

    /* renamed from: a */
    public void mo4191a(View view, View view2, int i) {
        mo4192a(view, view2, i, 0);
    }

    /* renamed from: a */
    public void mo4192a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f2042b = i;
        } else {
            this.f2041a = i;
        }
    }

    /* renamed from: a */
    public int mo4189a() {
        return this.f2041a | this.f2042b;
    }

    /* renamed from: a */
    public void mo4190a(View view, int i) {
        if (i == 1) {
            this.f2042b = 0;
        } else {
            this.f2041a = 0;
        }
    }
}
