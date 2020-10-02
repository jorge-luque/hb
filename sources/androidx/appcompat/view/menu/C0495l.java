package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.C0497m;
import androidx.core.p020f.C0804c;
import androidx.core.p020f.C0839t;

/* renamed from: androidx.appcompat.view.menu.l */
/* compiled from: MenuPopupHelper */
public class C0495l {

    /* renamed from: a */
    private final Context f902a;

    /* renamed from: b */
    private final C0482g f903b;

    /* renamed from: c */
    private final boolean f904c;

    /* renamed from: d */
    private final int f905d;

    /* renamed from: e */
    private final int f906e;

    /* renamed from: f */
    private View f907f;

    /* renamed from: g */
    private int f908g;

    /* renamed from: h */
    private boolean f909h;

    /* renamed from: i */
    private C0497m.C0498a f910i;

    /* renamed from: j */
    private C0494k f911j;

    /* renamed from: k */
    private PopupWindow.OnDismissListener f912k;

    /* renamed from: l */
    private final PopupWindow.OnDismissListener f913l;

    /* renamed from: androidx.appcompat.view.menu.l$a */
    /* compiled from: MenuPopupHelper */
    class C0496a implements PopupWindow.OnDismissListener {
        C0496a() {
        }

        public void onDismiss() {
            C0495l.this.mo2726d();
        }
    }

    public C0495l(Context context, C0482g gVar, View view, boolean z, int i) {
        this(context, gVar, view, z, i, 0);
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.m, androidx.appcompat.view.menu.k] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.q] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.d] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.C0494k m1012g() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f902a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x001d
            r0.getRealSize(r1)
            goto L_0x0020
        L_0x001d:
            r0.getSize(r1)
        L_0x0020:
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f902a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R$dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x004c
            androidx.appcompat.view.menu.d r0 = new androidx.appcompat.view.menu.d
            android.content.Context r2 = r14.f902a
            android.view.View r3 = r14.f907f
            int r4 = r14.f905d
            int r5 = r14.f906e
            boolean r6 = r14.f904c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x005e
        L_0x004c:
            androidx.appcompat.view.menu.q r0 = new androidx.appcompat.view.menu.q
            android.content.Context r8 = r14.f902a
            androidx.appcompat.view.menu.g r9 = r14.f903b
            android.view.View r10 = r14.f907f
            int r11 = r14.f905d
            int r12 = r14.f906e
            boolean r13 = r14.f904c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x005e:
            androidx.appcompat.view.menu.g r1 = r14.f903b
            r0.mo2475a((androidx.appcompat.view.menu.C0482g) r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f913l
            r0.mo2474a((android.widget.PopupWindow.OnDismissListener) r1)
            android.view.View r1 = r14.f907f
            r0.mo2473a((android.view.View) r1)
            androidx.appcompat.view.menu.m$a r1 = r14.f910i
            r0.mo2459a((androidx.appcompat.view.menu.C0497m.C0498a) r1)
            boolean r1 = r14.f909h
            r0.mo2478b((boolean) r1)
            int r1 = r14.f908g
            r0.mo2472a((int) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.C0495l.m1012g():androidx.appcompat.view.menu.k");
    }

    /* renamed from: a */
    public void mo2720a(PopupWindow.OnDismissListener onDismissListener) {
        this.f912k = onDismissListener;
    }

    /* renamed from: b */
    public C0494k mo2724b() {
        if (this.f911j == null) {
            this.f911j = m1012g();
        }
        return this.f911j;
    }

    /* renamed from: c */
    public boolean mo2725c() {
        C0494k kVar = this.f911j;
        return kVar != null && kVar.mo2476a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo2726d() {
        this.f911j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f912k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* renamed from: e */
    public void mo2727e() {
        if (!mo2728f()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: f */
    public boolean mo2728f() {
        if (mo2725c()) {
            return true;
        }
        if (this.f907f == null) {
            return false;
        }
        m1011a(0, 0, false, false);
        return true;
    }

    public C0495l(Context context, C0482g gVar, View view, boolean z, int i, int i2) {
        this.f908g = 8388611;
        this.f913l = new C0496a();
        this.f902a = context;
        this.f903b = gVar;
        this.f907f = view;
        this.f904c = z;
        this.f905d = i;
        this.f906e = i2;
    }

    /* renamed from: a */
    public void mo2719a(View view) {
        this.f907f = view;
    }

    /* renamed from: a */
    public void mo2722a(boolean z) {
        this.f909h = z;
        C0494k kVar = this.f911j;
        if (kVar != null) {
            kVar.mo2478b(z);
        }
    }

    /* renamed from: a */
    public void mo2718a(int i) {
        this.f908g = i;
    }

    /* renamed from: a */
    public boolean mo2723a(int i, int i2) {
        if (mo2725c()) {
            return true;
        }
        if (this.f907f == null) {
            return false;
        }
        m1011a(i, i2, true, true);
        return true;
    }

    /* renamed from: a */
    private void m1011a(int i, int i2, boolean z, boolean z2) {
        C0494k b = mo2724b();
        b.mo2481c(z2);
        if (z) {
            if ((C0804c.m2545a(this.f908g, C0839t.m2725n(this.f907f)) & 7) == 5) {
                i -= this.f907f.getWidth();
            }
            b.mo2477b(i);
            b.mo2480c(i2);
            int i3 = (int) ((this.f902a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.mo2714a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        b.show();
    }

    /* renamed from: a */
    public void mo2717a() {
        if (mo2725c()) {
            this.f911j.dismiss();
        }
    }

    /* renamed from: a */
    public void mo2721a(C0497m.C0498a aVar) {
        this.f910i = aVar;
        C0494k kVar = this.f911j;
        if (kVar != null) {
            kVar.mo2459a(aVar);
        }
    }
}
