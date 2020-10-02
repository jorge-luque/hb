package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.C0399a;
import androidx.appcompat.p011d.C0457c;
import androidx.appcompat.p011d.C0462g;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.view.menu.C0486i;
import androidx.appcompat.view.menu.C0497m;
import androidx.appcompat.view.menu.C0506r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.p020f.C0804c;
import androidx.core.p020f.C0825f;
import androidx.core.p020f.C0839t;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {

    /* renamed from: A */
    private ColorStateList f1291A;

    /* renamed from: B */
    private boolean f1292B;

    /* renamed from: C */
    private boolean f1293C;

    /* renamed from: D */
    private final ArrayList<View> f1294D;

    /* renamed from: E */
    private final ArrayList<View> f1295E;

    /* renamed from: F */
    private final int[] f1296F;

    /* renamed from: G */
    C0569f f1297G;

    /* renamed from: H */
    private final ActionMenuView.C0518e f1298H;

    /* renamed from: I */
    private C0600h0 f1299I;

    /* renamed from: J */
    private C0576c f1300J;

    /* renamed from: K */
    private C0567d f1301K;

    /* renamed from: L */
    private C0497m.C0498a f1302L;

    /* renamed from: M */
    private C0482g.C0483a f1303M;

    /* renamed from: N */
    private boolean f1304N;

    /* renamed from: O */
    private final Runnable f1305O;

    /* renamed from: a */
    private ActionMenuView f1306a;

    /* renamed from: b */
    private TextView f1307b;

    /* renamed from: c */
    private TextView f1308c;

    /* renamed from: d */
    private ImageButton f1309d;

    /* renamed from: e */
    private ImageView f1310e;

    /* renamed from: f */
    private Drawable f1311f;

    /* renamed from: g */
    private CharSequence f1312g;

    /* renamed from: h */
    ImageButton f1313h;

    /* renamed from: i */
    View f1314i;

    /* renamed from: j */
    private Context f1315j;

    /* renamed from: k */
    private int f1316k;

    /* renamed from: l */
    private int f1317l;

    /* renamed from: m */
    private int f1318m;

    /* renamed from: n */
    int f1319n;

    /* renamed from: o */
    private int f1320o;

    /* renamed from: p */
    private int f1321p;

    /* renamed from: q */
    private int f1322q;

    /* renamed from: r */
    private int f1323r;

    /* renamed from: s */
    private int f1324s;

    /* renamed from: t */
    private C0641y f1325t;

    /* renamed from: u */
    private int f1326u;

    /* renamed from: v */
    private int f1327v;

    /* renamed from: w */
    private int f1328w;

    /* renamed from: x */
    private CharSequence f1329x;

    /* renamed from: y */
    private CharSequence f1330y;

    /* renamed from: z */
    private ColorStateList f1331z;

    /* renamed from: androidx.appcompat.widget.Toolbar$a */
    class C0564a implements ActionMenuView.C0518e {
        C0564a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            C0569f fVar = Toolbar.this.f1297G;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$b */
    class C0565b implements Runnable {
        C0565b() {
        }

        public void run() {
            Toolbar.this.mo3337w();
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$c */
    class C0566c implements View.OnClickListener {
        C0566c() {
        }

        public void onClick(View view) {
            Toolbar.this.mo3302c();
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$f */
    public interface C0569f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: A */
    private void m1419A() {
        if (this.f1306a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1306a = actionMenuView;
            actionMenuView.mo2873g(this.f1316k);
            this.f1306a.mo2865a(this.f1298H);
            this.f1306a.mo2864a(this.f1302L, this.f1303M);
            C0568e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f406a = 8388613 | (this.f1319n & 112);
            this.f1306a.setLayoutParams(generateDefaultLayoutParams);
            m1430a((View) this.f1306a, false);
        }
    }

    /* renamed from: B */
    private void m1420B() {
        if (this.f1309d == null) {
            this.f1309d = new AppCompatImageButton(getContext(), (AttributeSet) null, R$attr.toolbarNavigationButtonStyle);
            C0568e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f406a = 8388611 | (this.f1319n & 112);
            this.f1309d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    /* renamed from: C */
    private MenuInflater m1421C() {
        return new C0462g(getContext());
    }

    /* renamed from: D */
    private void m1422D() {
        removeCallbacks(this.f1305O);
        post(this.f1305O);
    }

    /* renamed from: E */
    private boolean m1423E() {
        if (!this.f1304N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m1436d(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: x */
    private void m1438x() {
        if (this.f1325t == null) {
            this.f1325t = new C0641y();
        }
    }

    /* renamed from: y */
    private void m1439y() {
        if (this.f1310e == null) {
            this.f1310e = new AppCompatImageView(getContext());
        }
    }

    /* renamed from: z */
    private void m1440z() {
        m1419A();
        if (this.f1306a.mo2883n() == null) {
            C0482g gVar = (C0482g) this.f1306a.mo2878i();
            if (this.f1301K == null) {
                this.f1301K = new C0567d();
            }
            this.f1306a.mo2867b(true);
            gVar.mo2524a((C0497m) this.f1301K, this.f1315j);
        }
    }

    /* renamed from: a */
    public void mo3293a(C0482g gVar, C0576c cVar) {
        if (gVar != null || this.f1306a != null) {
            m1419A();
            C0482g n = this.f1306a.mo2883n();
            if (n != gVar) {
                if (n != null) {
                    n.mo2543b((C0497m) this.f1300J);
                    n.mo2543b((C0497m) this.f1301K);
                }
                if (this.f1301K == null) {
                    this.f1301K = new C0567d();
                }
                cVar.mo3369c(true);
                if (gVar != null) {
                    gVar.mo2524a((C0497m) cVar, this.f1315j);
                    gVar.mo2524a((C0497m) this.f1301K, this.f1315j);
                } else {
                    cVar.mo2455a(this.f1315j, (C0482g) null);
                    this.f1301K.mo2455a(this.f1315j, (C0482g) null);
                    cVar.mo2460a(true);
                    this.f1301K.mo2460a(true);
                }
                this.f1306a.mo2873g(this.f1316k);
                this.f1306a.mo2866a(cVar);
                this.f1300J = cVar;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f1306a;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo3301b() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.f1306a
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.mo2882m()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.mo3301b():boolean");
    }

    /* renamed from: c */
    public void mo3303c(int i) {
        if (this.f1316k != i) {
            this.f1316k = i;
            if (i == 0) {
                this.f1315j = getContext();
            } else {
                this.f1315j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0568e);
    }

    /* renamed from: d */
    public void mo3306d() {
        ActionMenuView actionMenuView = this.f1306a;
        if (actionMenuView != null) {
            actionMenuView.mo2872g();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo3308e() {
        if (this.f1313h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), (AttributeSet) null, R$attr.toolbarNavigationButtonStyle);
            this.f1313h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1311f);
            this.f1313h.setContentDescription(this.f1312g);
            C0568e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f406a = 8388611 | (this.f1319n & 112);
            generateDefaultLayoutParams.f1340b = 2;
            this.f1313h.setLayoutParams(generateDefaultLayoutParams);
            this.f1313h.setOnClickListener(new C0566c());
        }
    }

    /* renamed from: f */
    public int mo3309f() {
        C0641y yVar = this.f1325t;
        if (yVar != null) {
            return yVar.mo3633a();
        }
        return 0;
    }

    /* renamed from: g */
    public int mo3310g() {
        C0641y yVar = this.f1325t;
        if (yVar != null) {
            return yVar.mo3636b();
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.mo2883n();
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo3314h() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.f1306a
            r1 = 0
            if (r0 == 0) goto L_0x0013
            androidx.appcompat.view.menu.g r0 = r0.mo2883n()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0025
            int r0 = r3.mo3309f()
            int r2 = r3.f1327v
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x0029
        L_0x0025:
            int r0 = r3.mo3309f()
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.mo3314h():int");
    }

    /* renamed from: i */
    public int mo3315i() {
        if (C0839t.m2725n(this) == 1) {
            return mo3314h();
        }
        return mo3317k();
    }

    /* renamed from: j */
    public int mo3316j() {
        if (C0839t.m2725n(this) == 1) {
            return mo3317k();
        }
        return mo3314h();
    }

    /* renamed from: k */
    public int mo3317k() {
        if (mo3320n() != null) {
            return Math.max(mo3310g(), Math.max(this.f1326u, 0));
        }
        return mo3310g();
    }

    /* renamed from: l */
    public Menu mo3318l() {
        m1440z();
        return this.f1306a.mo2878i();
    }

    /* renamed from: m */
    public CharSequence mo3319m() {
        ImageButton imageButton = this.f1309d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    /* renamed from: n */
    public Drawable mo3320n() {
        ImageButton imageButton = this.f1309d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* renamed from: o */
    public CharSequence mo3321o() {
        return this.f1330y;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1305O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1293C = false;
        }
        if (!this.f1293C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1293C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1293C = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a3 A[LOOP:0: B:101:0x02a1->B:102:0x02a3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c5 A[LOOP:1: B:104:0x02c3->B:105:0x02c5, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02fe A[LOOP:2: B:112:0x02fc->B:113:0x02fe, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0229  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = androidx.core.p020f.C0839t.m2725n(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.f1296F
            r11[r2] = r3
            r11[r3] = r3
            int r12 = androidx.core.p020f.C0839t.m2726o(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = 0
        L_0x003b:
            android.widget.ImageButton r13 = r0.f1309d
            boolean r13 = r0.m1436d((android.view.View) r13)
            if (r13 == 0) goto L_0x0055
            if (r1 == 0) goto L_0x004e
            android.widget.ImageButton r13 = r0.f1309d
            int r13 = r0.m1433b(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0057
        L_0x004e:
            android.widget.ImageButton r13 = r0.f1309d
            int r13 = r0.m1427a(r13, r6, r11, r12)
            goto L_0x0056
        L_0x0055:
            r13 = r6
        L_0x0056:
            r14 = r10
        L_0x0057:
            android.widget.ImageButton r15 = r0.f1313h
            boolean r15 = r0.m1436d((android.view.View) r15)
            if (r15 == 0) goto L_0x006e
            if (r1 == 0) goto L_0x0068
            android.widget.ImageButton r15 = r0.f1313h
            int r14 = r0.m1433b(r15, r14, r11, r12)
            goto L_0x006e
        L_0x0068:
            android.widget.ImageButton r15 = r0.f1313h
            int r13 = r0.m1427a(r15, r13, r11, r12)
        L_0x006e:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1306a
            boolean r15 = r0.m1436d((android.view.View) r15)
            if (r15 == 0) goto L_0x0085
            if (r1 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1306a
            int r13 = r0.m1427a(r15, r13, r11, r12)
            goto L_0x0085
        L_0x007f:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f1306a
            int r14 = r0.m1433b(r15, r14, r11, r12)
        L_0x0085:
            int r15 = r19.mo3315i()
            int r16 = r19.mo3316j()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.f1314i
            boolean r13 = r0.m1436d((android.view.View) r13)
            if (r13 == 0) goto L_0x00c2
            if (r1 == 0) goto L_0x00bc
            android.view.View r13 = r0.f1314i
            int r10 = r0.m1433b(r13, r10, r11, r12)
            goto L_0x00c2
        L_0x00bc:
            android.view.View r13 = r0.f1314i
            int r2 = r0.m1427a(r13, r2, r11, r12)
        L_0x00c2:
            android.widget.ImageView r13 = r0.f1310e
            boolean r13 = r0.m1436d((android.view.View) r13)
            if (r13 == 0) goto L_0x00d9
            if (r1 == 0) goto L_0x00d3
            android.widget.ImageView r13 = r0.f1310e
            int r10 = r0.m1433b(r13, r10, r11, r12)
            goto L_0x00d9
        L_0x00d3:
            android.widget.ImageView r13 = r0.f1310e
            int r2 = r0.m1427a(r13, r2, r11, r12)
        L_0x00d9:
            android.widget.TextView r13 = r0.f1307b
            boolean r13 = r0.m1436d((android.view.View) r13)
            android.widget.TextView r14 = r0.f1308c
            boolean r14 = r0.m1436d((android.view.View) r14)
            if (r13 == 0) goto L_0x0100
            android.widget.TextView r15 = r0.f1307b
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r15 = (androidx.appcompat.widget.Toolbar.C0568e) r15
            int r3 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.f1307b
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x0103
        L_0x0100:
            r23 = r7
            r3 = 0
        L_0x0103:
            if (r14 == 0) goto L_0x011d
            android.widget.TextView r7 = r0.f1308c
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r7 = (androidx.appcompat.widget.Toolbar.C0568e) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.f1308c
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x011f
        L_0x011d:
            r16 = r4
        L_0x011f:
            if (r13 != 0) goto L_0x012b
            if (r14 == 0) goto L_0x0124
            goto L_0x012b
        L_0x0124:
            r18 = r6
            r22 = r12
        L_0x0128:
            r1 = 0
            goto L_0x0294
        L_0x012b:
            if (r13 == 0) goto L_0x0130
            android.widget.TextView r4 = r0.f1307b
            goto L_0x0132
        L_0x0130:
            android.widget.TextView r4 = r0.f1308c
        L_0x0132:
            if (r14 == 0) goto L_0x0137
            android.widget.TextView r7 = r0.f1308c
            goto L_0x0139
        L_0x0137:
            android.widget.TextView r7 = r0.f1307b
        L_0x0139:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r4 = (androidx.appcompat.widget.Toolbar.C0568e) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r7 = (androidx.appcompat.widget.Toolbar.C0568e) r7
            if (r13 == 0) goto L_0x014f
            android.widget.TextView r15 = r0.f1307b
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x0159
        L_0x014f:
            if (r14 == 0) goto L_0x015c
            android.widget.TextView r15 = r0.f1308c
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x015c
        L_0x0159:
            r17 = 1
            goto L_0x015e
        L_0x015c:
            r17 = 0
        L_0x015e:
            int r15 = r0.f1328w
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x01a6
            r6 = 80
            if (r15 == r6) goto L_0x0198
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.f1323r
            r24 = r2
            int r2 = r15 + r12
            if (r6 >= r2) goto L_0x0181
            int r6 = r15 + r12
            goto L_0x0196
        L_0x0181:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.f1324s
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x0196
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x0196:
            int r8 = r8 + r6
            goto L_0x01b5
        L_0x0198:
            r24 = r2
            r22 = r12
            int r5 = r5 - r9
            int r2 = r7.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.f1324s
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01b5
        L_0x01a6:
            r24 = r2
            r22 = r12
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.f1323r
            int r8 = r2 + r3
        L_0x01b5:
            if (r1 == 0) goto L_0x0229
            if (r17 == 0) goto L_0x01bc
            int r1 = r0.f1321p
            goto L_0x01bd
        L_0x01bc:
            r1 = 0
        L_0x01bd:
            r2 = 1
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x01f4
            android.widget.TextView r1 = r0.f1307b
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r1 = (androidx.appcompat.widget.Toolbar.C0568e) r1
            android.widget.TextView r2 = r0.f1307b
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.f1307b
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f1307b
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.f1322q
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01f5
        L_0x01f4:
            r2 = r10
        L_0x01f5:
            if (r14 == 0) goto L_0x021d
            android.widget.TextView r1 = r0.f1308c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r1 = (androidx.appcompat.widget.Toolbar.C0568e) r1
            int r3 = r1.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.f1308c
            int r3 = r3.getMeasuredWidth()
            int r3 = r10 - r3
            android.widget.TextView r4 = r0.f1308c
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.f1308c
            r5.layout(r3, r8, r10, r4)
            int r3 = r0.f1322q
            int r3 = r10 - r3
            int r1 = r1.bottomMargin
            goto L_0x021e
        L_0x021d:
            r3 = r10
        L_0x021e:
            if (r17 == 0) goto L_0x0225
            int r1 = java.lang.Math.min(r2, r3)
            r10 = r1
        L_0x0225:
            r2 = r24
            goto L_0x0128
        L_0x0229:
            if (r17 == 0) goto L_0x022f
            int r7 = r0.f1321p
            r1 = 0
            goto L_0x0231
        L_0x022f:
            r1 = 0
            r7 = 0
        L_0x0231:
            r2 = r11[r1]
            int r7 = r7 - r2
            int r2 = java.lang.Math.max(r1, r7)
            int r2 = r24 + r2
            int r3 = -r7
            int r3 = java.lang.Math.max(r1, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x0266
            android.widget.TextView r3 = r0.f1307b
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r3 = (androidx.appcompat.widget.Toolbar.C0568e) r3
            android.widget.TextView r4 = r0.f1307b
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.f1307b
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f1307b
            r6.layout(r2, r8, r4, r5)
            int r6 = r0.f1322q
            int r4 = r4 + r6
            int r3 = r3.bottomMargin
            int r8 = r5 + r3
            goto L_0x0267
        L_0x0266:
            r4 = r2
        L_0x0267:
            if (r14 == 0) goto L_0x028d
            android.widget.TextView r3 = r0.f1308c
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r3 = (androidx.appcompat.widget.Toolbar.C0568e) r3
            int r5 = r3.topMargin
            int r8 = r8 + r5
            android.widget.TextView r5 = r0.f1308c
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 + r2
            android.widget.TextView r6 = r0.f1308c
            int r6 = r6.getMeasuredHeight()
            int r6 = r6 + r8
            android.widget.TextView r7 = r0.f1308c
            r7.layout(r2, r8, r5, r6)
            int r6 = r0.f1322q
            int r5 = r5 + r6
            int r3 = r3.bottomMargin
            goto L_0x028e
        L_0x028d:
            r5 = r2
        L_0x028e:
            if (r17 == 0) goto L_0x0294
            int r2 = java.lang.Math.max(r4, r5)
        L_0x0294:
            java.util.ArrayList<android.view.View> r3 = r0.f1294D
            r4 = 3
            r0.m1431a((java.util.List<android.view.View>) r3, (int) r4)
            java.util.ArrayList<android.view.View> r3 = r0.f1294D
            int r3 = r3.size()
            r7 = 0
        L_0x02a1:
            if (r7 >= r3) goto L_0x02b4
            java.util.ArrayList<android.view.View> r4 = r0.f1294D
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r2 = r0.m1427a(r4, r2, r11, r12)
            int r7 = r7 + 1
            goto L_0x02a1
        L_0x02b4:
            r12 = r22
            java.util.ArrayList<android.view.View> r3 = r0.f1294D
            r4 = 5
            r0.m1431a((java.util.List<android.view.View>) r3, (int) r4)
            java.util.ArrayList<android.view.View> r3 = r0.f1294D
            int r3 = r3.size()
            r7 = 0
        L_0x02c3:
            if (r7 >= r3) goto L_0x02d4
            java.util.ArrayList<android.view.View> r4 = r0.f1294D
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.m1433b(r4, r10, r11, r12)
            int r7 = r7 + 1
            goto L_0x02c3
        L_0x02d4:
            java.util.ArrayList<android.view.View> r3 = r0.f1294D
            r4 = 1
            r0.m1431a((java.util.List<android.view.View>) r3, (int) r4)
            java.util.ArrayList<android.view.View> r3 = r0.f1294D
            int r3 = r0.m1428a((java.util.List<android.view.View>) r3, (int[]) r11)
            int r4 = r16 - r18
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r18 + r4
            int r4 = r3 / 2
            int r6 = r6 - r4
            int r3 = r3 + r6
            if (r6 >= r2) goto L_0x02ef
            goto L_0x02f6
        L_0x02ef:
            if (r3 <= r10) goto L_0x02f5
            int r3 = r3 - r10
            int r2 = r6 - r3
            goto L_0x02f6
        L_0x02f5:
            r2 = r6
        L_0x02f6:
            java.util.ArrayList<android.view.View> r3 = r0.f1294D
            int r3 = r3.size()
        L_0x02fc:
            if (r1 >= r3) goto L_0x030d
            java.util.ArrayList<android.view.View> r4 = r0.f1294D
            java.lang.Object r4 = r4.get(r1)
            android.view.View r4 = (android.view.View) r4
            int r2 = r0.m1427a(r4, r2, r11, r12)
            int r1 = r1 + 1
            goto L_0x02fc
        L_0x030d:
            java.util.ArrayList<android.view.View> r1 = r0.f1294D
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.f1296F;
        int i10 = 0;
        if (C0616m0.m1739a(this)) {
            c2 = 1;
            c = 0;
        } else {
            c2 = 0;
            c = 1;
        }
        if (m1436d((View) this.f1309d)) {
            m1429a((View) this.f1309d, i, 0, i2, 0, this.f1320o);
            i5 = this.f1309d.getMeasuredWidth() + m1424a((View) this.f1309d);
            i4 = Math.max(0, this.f1309d.getMeasuredHeight() + m1432b((View) this.f1309d));
            i3 = View.combineMeasuredStates(0, this.f1309d.getMeasuredState());
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (m1436d((View) this.f1313h)) {
            m1429a((View) this.f1313h, i, 0, i2, 0, this.f1320o);
            i5 = this.f1313h.getMeasuredWidth() + m1424a((View) this.f1313h);
            i4 = Math.max(i4, this.f1313h.getMeasuredHeight() + m1432b((View) this.f1313h));
            i3 = View.combineMeasuredStates(i3, this.f1313h.getMeasuredState());
        }
        int k = mo3317k();
        int max = 0 + Math.max(k, i5);
        iArr[c2] = Math.max(0, k - i5);
        if (m1436d((View) this.f1306a)) {
            m1429a((View) this.f1306a, i, max, i2, 0, this.f1320o);
            i6 = this.f1306a.getMeasuredWidth() + m1424a((View) this.f1306a);
            i4 = Math.max(i4, this.f1306a.getMeasuredHeight() + m1432b((View) this.f1306a));
            i3 = View.combineMeasuredStates(i3, this.f1306a.getMeasuredState());
        } else {
            i6 = 0;
        }
        int h = mo3314h();
        int max2 = max + Math.max(h, i6);
        iArr[c] = Math.max(0, h - i6);
        if (m1436d(this.f1314i)) {
            max2 += m1426a(this.f1314i, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.f1314i.getMeasuredHeight() + m1432b(this.f1314i));
            i3 = View.combineMeasuredStates(i3, this.f1314i.getMeasuredState());
        }
        if (m1436d((View) this.f1310e)) {
            max2 += m1426a((View) this.f1310e, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.f1310e.getMeasuredHeight() + m1432b((View) this.f1310e));
            i3 = View.combineMeasuredStates(i3, this.f1310e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((C0568e) childAt.getLayoutParams()).f1340b == 0 && m1436d(childAt)) {
                max2 += m1426a(childAt, i, max2, i2, 0, iArr);
                i4 = Math.max(i4, childAt.getMeasuredHeight() + m1432b(childAt));
                i3 = View.combineMeasuredStates(i3, childAt.getMeasuredState());
            }
        }
        int i12 = this.f1323r + this.f1324s;
        int i13 = this.f1321p + this.f1322q;
        if (m1436d((View) this.f1307b)) {
            m1426a((View) this.f1307b, i, max2 + i13, i2, i12, iArr);
            int measuredWidth = this.f1307b.getMeasuredWidth() + m1424a((View) this.f1307b);
            i7 = this.f1307b.getMeasuredHeight() + m1432b((View) this.f1307b);
            i9 = View.combineMeasuredStates(i3, this.f1307b.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i9 = i3;
            i8 = 0;
            i7 = 0;
        }
        if (m1436d((View) this.f1308c)) {
            int i14 = i7 + i12;
            i8 = Math.max(i8, m1426a((View) this.f1308c, i, max2 + i13, i2, i14, iArr));
            i7 += this.f1308c.getMeasuredHeight() + m1432b((View) this.f1308c);
            i9 = View.combineMeasuredStates(i9, this.f1308c.getMeasuredState());
        } else {
            int i15 = i9;
        }
        int max3 = Math.max(i4, i7);
        int paddingLeft = max2 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i9);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i9 << 16);
        if (!m1423E()) {
            i10 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i10);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mo4406a());
        ActionMenuView actionMenuView = this.f1306a;
        C0482g n = actionMenuView != null ? actionMenuView.mo2883n() : null;
        int i = savedState.f1332c;
        if (!(i == 0 || this.f1301K == null || n == null || (findItem = n.findItem(i)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.f1333d) {
            m1422D();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        m1438x();
        C0641y yVar = this.f1325t;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        yVar.mo3635a(z);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C0486i iVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        C0567d dVar = this.f1301K;
        if (!(dVar == null || (iVar = dVar.f1338b) == null)) {
            savedState.f1332c = iVar.getItemId();
        }
        savedState.f1333d = mo3335u();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1292B = false;
        }
        if (!this.f1292B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1292B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1292B = false;
        }
        return true;
    }

    /* renamed from: p */
    public CharSequence mo3330p() {
        return this.f1329x;
    }

    /* renamed from: q */
    public C0620p mo3331q() {
        if (this.f1299I == null) {
            this.f1299I = new C0600h0(this, true);
        }
        return this.f1299I;
    }

    /* renamed from: r */
    public boolean mo3332r() {
        C0567d dVar = this.f1301K;
        return (dVar == null || dVar.f1338b == null) ? false : true;
    }

    /* renamed from: s */
    public boolean mo3333s() {
        ActionMenuView actionMenuView = this.f1306a;
        return actionMenuView != null && actionMenuView.mo2879j();
    }

    /* renamed from: t */
    public boolean mo3334t() {
        ActionMenuView actionMenuView = this.f1306a;
        return actionMenuView != null && actionMenuView.mo2880k();
    }

    /* renamed from: u */
    public boolean mo3335u() {
        ActionMenuView actionMenuView = this.f1306a;
        return actionMenuView != null && actionMenuView.mo2881l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo3336v() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0568e) childAt.getLayoutParams()).f1340b == 2 || childAt == this.f1306a)) {
                removeViewAt(childCount);
                this.f1295E.add(childAt);
            }
        }
    }

    /* renamed from: w */
    public boolean mo3337w() {
        ActionMenuView actionMenuView = this.f1306a;
        return actionMenuView != null && actionMenuView.mo2884o();
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$e */
    public static class C0568e extends C0399a.C0400a {

        /* renamed from: b */
        int f1340b = 0;

        public C0568e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3343a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public C0568e(int i, int i2) {
            super(i, i2);
            this.f406a = 8388627;
        }

        public C0568e(C0568e eVar) {
            super((C0399a.C0400a) eVar);
            this.f1340b = eVar.f1340b;
        }

        public C0568e(C0399a.C0400a aVar) {
            super(aVar);
        }

        public C0568e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            mo3343a(marginLayoutParams);
        }

        public C0568e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    /* renamed from: b */
    public void mo3297b(Context context, int i) {
        this.f1317l = i;
        TextView textView = this.f1307b;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public C0568e generateDefaultLayoutParams() {
        return new C0568e(-2, -2);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0563a();

        /* renamed from: c */
        int f1332c;

        /* renamed from: d */
        boolean f1333d;

        /* renamed from: androidx.appcompat.widget.Toolbar$SavedState$a */
        static class C0563a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0563a() {
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1332c = parcel.readInt();
            this.f1333d = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1332c);
            parcel.writeInt(this.f1333d ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$d */
    private class C0567d implements C0497m {

        /* renamed from: a */
        C0482g f1337a;

        /* renamed from: b */
        C0486i f1338b;

        C0567d() {
        }

        /* renamed from: a */
        public void mo2455a(Context context, C0482g gVar) {
            C0486i iVar;
            C0482g gVar2 = this.f1337a;
            if (!(gVar2 == null || (iVar = this.f1338b) == null)) {
                gVar2.mo2530a(iVar);
            }
            this.f1337a = gVar;
        }

        /* renamed from: a */
        public void mo2457a(C0482g gVar, boolean z) {
        }

        /* renamed from: a */
        public void mo2459a(C0497m.C0498a aVar) {
        }

        /* renamed from: a */
        public boolean mo2464a(C0506r rVar) {
            return false;
        }

        /* renamed from: b */
        public boolean mo2479b() {
            return false;
        }

        /* renamed from: b */
        public boolean mo2466b(C0482g gVar, C0486i iVar) {
            Toolbar.this.mo3308e();
            ViewParent parent = Toolbar.this.f1313h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1313h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1313h);
            }
            Toolbar.this.f1314i = iVar.getActionView();
            this.f1338b = iVar;
            ViewParent parent2 = Toolbar.this.f1314i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1314i);
                }
                C0568e generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f406a = 8388611 | (toolbar4.f1319n & 112);
                generateDefaultLayoutParams.f1340b = 2;
                toolbar4.f1314i.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1314i);
            }
            Toolbar.this.mo3336v();
            Toolbar.this.requestLayout();
            iVar.mo2594a(true);
            View view = Toolbar.this.f1314i;
            if (view instanceof C0457c) {
                ((C0457c) view).mo2301a();
            }
            return true;
        }

        /* renamed from: a */
        public void mo2460a(boolean z) {
            if (this.f1338b != null) {
                C0482g gVar = this.f1337a;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f1337a.getItem(i) == this.f1338b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    mo2463a(this.f1337a, this.f1338b);
                }
            }
        }

        /* renamed from: a */
        public boolean mo2463a(C0482g gVar, C0486i iVar) {
            View view = Toolbar.this.f1314i;
            if (view instanceof C0457c) {
                ((C0457c) view).mo2302b();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1314i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1313h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1314i = null;
            toolbar3.mo3286a();
            this.f1338b = null;
            Toolbar.this.requestLayout();
            iVar.mo2594a(false);
            return true;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1328w = 8388627;
        this.f1294D = new ArrayList<>();
        this.f1295E = new ArrayList<>();
        this.f1296F = new int[2];
        this.f1298H = new C0564a();
        this.f1305O = new C0565b();
        C0598g0 a = C0598g0.m1610a(getContext(), attributeSet, R$styleable.Toolbar, i, 0);
        this.f1317l = a.mo3446g(R$styleable.Toolbar_titleTextAppearance, 0);
        this.f1318m = a.mo3446g(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.f1328w = a.mo3442e(R$styleable.Toolbar_android_gravity, this.f1328w);
        this.f1319n = a.mo3442e(R$styleable.Toolbar_buttonGravity, 48);
        int b = a.mo3436b(R$styleable.Toolbar_titleMargin, 0);
        b = a.mo3447g(R$styleable.Toolbar_titleMargins) ? a.mo3436b(R$styleable.Toolbar_titleMargins, b) : b;
        this.f1324s = b;
        this.f1323r = b;
        this.f1322q = b;
        this.f1321p = b;
        int b2 = a.mo3436b(R$styleable.Toolbar_titleMarginStart, -1);
        if (b2 >= 0) {
            this.f1321p = b2;
        }
        int b3 = a.mo3436b(R$styleable.Toolbar_titleMarginEnd, -1);
        if (b3 >= 0) {
            this.f1322q = b3;
        }
        int b4 = a.mo3436b(R$styleable.Toolbar_titleMarginTop, -1);
        if (b4 >= 0) {
            this.f1323r = b4;
        }
        int b5 = a.mo3436b(R$styleable.Toolbar_titleMarginBottom, -1);
        if (b5 >= 0) {
            this.f1324s = b5;
        }
        this.f1320o = a.mo3438c(R$styleable.Toolbar_maxButtonHeight, -1);
        int b6 = a.mo3436b(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int b7 = a.mo3436b(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int c = a.mo3438c(R$styleable.Toolbar_contentInsetLeft, 0);
        int c2 = a.mo3438c(R$styleable.Toolbar_contentInsetRight, 0);
        m1438x();
        this.f1325t.mo3634a(c, c2);
        if (!(b6 == Integer.MIN_VALUE && b7 == Integer.MIN_VALUE)) {
            this.f1325t.mo3637b(b6, b7);
        }
        this.f1326u = a.mo3436b(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1327v = a.mo3436b(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1311f = a.mo3437b(R$styleable.Toolbar_collapseIcon);
        this.f1312g = a.mo3443e(R$styleable.Toolbar_collapseContentDescription);
        CharSequence e = a.mo3443e(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(e)) {
            mo3307d(e);
        }
        CharSequence e2 = a.mo3443e(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(e2)) {
            mo3304c(e2);
        }
        this.f1315j = getContext();
        mo3303c(a.mo3446g(R$styleable.Toolbar_popupTheme, 0));
        Drawable b8 = a.mo3437b(R$styleable.Toolbar_navigationIcon);
        if (b8 != null) {
            mo3299b(b8);
        }
        CharSequence e3 = a.mo3443e(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(e3)) {
            mo3300b(e3);
        }
        Drawable b9 = a.mo3437b(R$styleable.Toolbar_logo);
        if (b9 != null) {
            mo3291a(b9);
        }
        CharSequence e4 = a.mo3443e(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(e4)) {
            mo3294a(e4);
        }
        if (a.mo3447g(R$styleable.Toolbar_titleTextColor)) {
            mo3298b(a.mo3432a(R$styleable.Toolbar_titleTextColor));
        }
        if (a.mo3447g(R$styleable.Toolbar_subtitleTextColor)) {
            mo3290a(a.mo3432a(R$styleable.Toolbar_subtitleTextColor));
        }
        if (a.mo3447g(R$styleable.Toolbar_menu)) {
            mo3287a(a.mo3446g(R$styleable.Toolbar_menu, 0));
        }
        a.mo3434a();
    }

    /* renamed from: d */
    public void mo3307d(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1307b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1307b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1307b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f1317l;
                if (i != 0) {
                    this.f1307b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f1331z;
                if (colorStateList != null) {
                    this.f1307b.setTextColor(colorStateList);
                }
            }
            if (!m1434c((View) this.f1307b)) {
                m1430a((View) this.f1307b, true);
            }
        } else {
            TextView textView = this.f1307b;
            if (textView != null && m1434c((View) textView)) {
                removeView(this.f1307b);
                this.f1295E.remove(this.f1307b);
            }
        }
        TextView textView2 = this.f1307b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1329x = charSequence;
    }

    public C0568e generateLayoutParams(AttributeSet attributeSet) {
        return new C0568e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0568e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0568e) {
            return new C0568e((C0568e) layoutParams);
        }
        if (layoutParams instanceof C0399a.C0400a) {
            return new C0568e((C0399a.C0400a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0568e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0568e(layoutParams);
    }

    /* renamed from: b */
    public void mo3298b(ColorStateList colorStateList) {
        this.f1331z = colorStateList;
        TextView textView = this.f1307b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* renamed from: c */
    public void mo3302c() {
        C0567d dVar = this.f1301K;
        C0486i iVar = dVar == null ? null : dVar.f1338b;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    /* renamed from: c */
    public void mo3304c(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1308c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.f1308c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.f1308c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.f1318m;
                if (i != 0) {
                    this.f1308c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.f1291A;
                if (colorStateList != null) {
                    this.f1308c.setTextColor(colorStateList);
                }
            }
            if (!m1434c((View) this.f1308c)) {
                m1430a((View) this.f1308c, true);
            }
        } else {
            TextView textView = this.f1308c;
            if (textView != null && m1434c((View) textView)) {
                removeView(this.f1308c);
                this.f1295E.remove(this.f1308c);
            }
        }
        TextView textView2 = this.f1308c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1330y = charSequence;
    }

    /* renamed from: b */
    public void mo3296b(int i) {
        mo3300b(i != 0 ? getContext().getText(i) : null);
    }

    /* renamed from: b */
    public void mo3300b(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m1420B();
        }
        ImageButton imageButton = this.f1309d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    /* renamed from: e */
    private int m1437e(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.f1328w & 112;
    }

    /* renamed from: b */
    public void mo3299b(Drawable drawable) {
        if (drawable != null) {
            m1420B();
            if (!m1434c((View) this.f1309d)) {
                m1430a((View) this.f1309d, true);
            }
        } else {
            ImageButton imageButton = this.f1309d;
            if (imageButton != null && m1434c((View) imageButton)) {
                removeView(this.f1309d);
                this.f1295E.remove(this.f1309d);
            }
        }
        ImageButton imageButton2 = this.f1309d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    /* renamed from: a */
    public void mo3291a(Drawable drawable) {
        if (drawable != null) {
            m1439y();
            if (!m1434c((View) this.f1310e)) {
                m1430a((View) this.f1310e, true);
            }
        } else {
            ImageView imageView = this.f1310e;
            if (imageView != null && m1434c((View) imageView)) {
                removeView(this.f1310e);
                this.f1295E.remove(this.f1310e);
            }
        }
        ImageView imageView2 = this.f1310e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    /* renamed from: b */
    private int m1433b(View view, int i, int[] iArr, int i2) {
        C0568e eVar = (C0568e) view.getLayoutParams();
        int i3 = eVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int a = m1425a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a, max, view.getMeasuredHeight() + a);
        return max - (measuredWidth + eVar.leftMargin);
    }

    /* renamed from: d */
    private int m1435d(int i) {
        int n = C0839t.m2725n(this);
        int a = C0804c.m2545a(i, n) & 7;
        if (a == 1 || a == 3 || a == 5) {
            return a;
        }
        return n == 1 ? 5 : 3;
    }

    /* renamed from: d */
    private boolean m1436d(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: c */
    private boolean m1434c(View view) {
        return view.getParent() == this || this.f1295E.contains(view);
    }

    /* renamed from: a */
    public void mo3294a(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m1439y();
        }
        ImageView imageView = this.f1310e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    /* renamed from: b */
    private int m1432b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: a */
    public void mo3289a(Context context, int i) {
        this.f1318m = i;
        TextView textView = this.f1308c;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    /* renamed from: a */
    public void mo3290a(ColorStateList colorStateList) {
        this.f1291A = colorStateList;
        TextView textView = this.f1308c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* renamed from: a */
    public void mo3292a(View.OnClickListener onClickListener) {
        m1420B();
        this.f1309d.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    public void mo3287a(int i) {
        m1421C().inflate(i, mo3318l());
    }

    /* renamed from: a */
    public void mo3288a(int i, int i2) {
        m1438x();
        this.f1325t.mo3637b(i, i2);
    }

    /* renamed from: a */
    private void m1430a(View view, boolean z) {
        C0568e eVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            eVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            eVar = generateLayoutParams(layoutParams);
        } else {
            eVar = (C0568e) layoutParams;
        }
        eVar.f1340b = 1;
        if (!z || this.f1314i == null) {
            addView(view, eVar);
            return;
        }
        view.setLayoutParams(eVar);
        this.f1295E.add(view);
    }

    /* renamed from: a */
    private void m1429a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* renamed from: a */
    private int m1426a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    /* renamed from: a */
    private int m1428a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            View view = list.get(i3);
            C0568e eVar = (C0568e) view.getLayoutParams();
            int i5 = eVar.leftMargin - i;
            int i6 = eVar.rightMargin - i2;
            int max = Math.max(0, i5);
            int max2 = Math.max(0, i6);
            int max3 = Math.max(0, -i5);
            int max4 = Math.max(0, -i6);
            i4 += max + view.getMeasuredWidth() + max2;
            i3++;
            i2 = max4;
            i = max3;
        }
        return i4;
    }

    /* renamed from: a */
    private int m1427a(View view, int i, int[] iArr, int i2) {
        C0568e eVar = (C0568e) view.getLayoutParams();
        int i3 = eVar.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int a = m1425a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a, max + measuredWidth, view.getMeasuredHeight() + a);
        return max + measuredWidth + eVar.rightMargin;
    }

    /* renamed from: a */
    private int m1425a(View view, int i) {
        C0568e eVar = (C0568e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int e = m1437e(eVar.f406a);
        if (e == 48) {
            return getPaddingTop() - i2;
        }
        if (e == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = eVar.topMargin;
        if (i3 < i4) {
            i3 = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
            int i6 = eVar.bottomMargin;
            if (i5 < i6) {
                i3 = Math.max(0, i3 - (i6 - i5));
            }
        }
        return paddingTop + i3;
    }

    /* renamed from: a */
    private void m1431a(List<View> list, int i) {
        boolean z = C0839t.m2725n(this) == 1;
        int childCount = getChildCount();
        int a = C0804c.m2545a(i, C0839t.m2725n(this));
        list.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                C0568e eVar = (C0568e) childAt.getLayoutParams();
                if (eVar.f1340b == 0 && m1436d(childAt) && m1435d(eVar.f406a) == a) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            C0568e eVar2 = (C0568e) childAt2.getLayoutParams();
            if (eVar2.f1340b == 0 && m1436d(childAt2) && m1435d(eVar2.f406a) == a) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: a */
    private int m1424a(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return C0825f.m2636b(marginLayoutParams) + C0825f.m2634a(marginLayoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3286a() {
        for (int size = this.f1295E.size() - 1; size >= 0; size--) {
            addView(this.f1295E.get(size));
        }
        this.f1295E.clear();
    }

    /* renamed from: a */
    public void mo3295a(boolean z) {
        this.f1304N = z;
        requestLayout();
    }
}
