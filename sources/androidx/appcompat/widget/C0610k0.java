package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

/* renamed from: androidx.appcompat.widget.k0 */
/* compiled from: TooltipPopup */
class C0610k0 {

    /* renamed from: a */
    private final Context f1494a;

    /* renamed from: b */
    private final View f1495b;

    /* renamed from: c */
    private final TextView f1496c;

    /* renamed from: d */
    private final WindowManager.LayoutParams f1497d = new WindowManager.LayoutParams();

    /* renamed from: e */
    private final Rect f1498e = new Rect();

    /* renamed from: f */
    private final int[] f1499f = new int[2];

    /* renamed from: g */
    private final int[] f1500g = new int[2];

    C0610k0(Context context) {
        this.f1494a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.abc_tooltip, (ViewGroup) null);
        this.f1495b = inflate;
        this.f1496c = (TextView) inflate.findViewById(R$id.message);
        this.f1497d.setTitle(C0610k0.class.getSimpleName());
        this.f1497d.packageName = this.f1494a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f1497d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3505a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (mo3506b()) {
            mo3504a();
        }
        this.f1496c.setText(charSequence);
        m1700a(view, i, i2, z, this.f1497d);
        ((WindowManager) this.f1494a.getSystemService("window")).addView(this.f1495b, this.f1497d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo3506b() {
        return this.f1495b.getParent() != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3504a() {
        if (mo3506b()) {
            ((WindowManager) this.f1494a.getSystemService("window")).removeView(this.f1495b);
        }
    }

    /* renamed from: a */
    private void m1700a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int i3;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1494a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1494a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
            i4 = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            i4 = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1494a.getResources().getDimensionPixelOffset(z ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch);
        View a = m1699a(view);
        if (a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a.getWindowVisibleDisplayFrame(this.f1498e);
        Rect rect = this.f1498e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1494a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1498e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a.getLocationOnScreen(this.f1500g);
        view.getLocationOnScreen(this.f1499f);
        int[] iArr = this.f1499f;
        int i5 = iArr[0];
        int[] iArr2 = this.f1500g;
        iArr[0] = i5 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (a.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1495b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1495b.getMeasuredHeight();
        int[] iArr3 = this.f1499f;
        int i6 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i7 = iArr3[1] + i4 + dimensionPixelOffset3;
        if (z) {
            if (i6 >= 0) {
                layoutParams.y = i6;
            } else {
                layoutParams.y = i7;
            }
        } else if (measuredHeight + i7 <= this.f1498e.height()) {
            layoutParams.y = i7;
        } else {
            layoutParams.y = i6;
        }
    }

    /* renamed from: a */
    private static View m1699a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
