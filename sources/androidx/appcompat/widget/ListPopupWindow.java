package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.C0502p;
import androidx.core.p020f.C0839t;
import androidx.core.widget.C0878h;
import java.lang.reflect.Method;

public class ListPopupWindow implements C0502p {

    /* renamed from: F */
    private static Method f1137F;

    /* renamed from: G */
    private static Method f1138G;

    /* renamed from: H */
    private static Method f1139H;

    /* renamed from: A */
    final Handler f1140A;

    /* renamed from: B */
    private final Rect f1141B;

    /* renamed from: C */
    private Rect f1142C;

    /* renamed from: D */
    private boolean f1143D;

    /* renamed from: E */
    PopupWindow f1144E;

    /* renamed from: a */
    private Context f1145a;

    /* renamed from: b */
    private ListAdapter f1146b;

    /* renamed from: c */
    C0622r f1147c;

    /* renamed from: d */
    private int f1148d;

    /* renamed from: e */
    private int f1149e;

    /* renamed from: f */
    private int f1150f;

    /* renamed from: g */
    private int f1151g;

    /* renamed from: h */
    private int f1152h;

    /* renamed from: i */
    private boolean f1153i;

    /* renamed from: j */
    private boolean f1154j;

    /* renamed from: k */
    private boolean f1155k;

    /* renamed from: l */
    private int f1156l;

    /* renamed from: m */
    private boolean f1157m;

    /* renamed from: n */
    private boolean f1158n;

    /* renamed from: o */
    int f1159o;

    /* renamed from: p */
    private View f1160p;

    /* renamed from: q */
    private int f1161q;

    /* renamed from: r */
    private DataSetObserver f1162r;

    /* renamed from: s */
    private View f1163s;

    /* renamed from: t */
    private Drawable f1164t;

    /* renamed from: u */
    private AdapterView.OnItemClickListener f1165u;

    /* renamed from: v */
    private AdapterView.OnItemSelectedListener f1166v;

    /* renamed from: w */
    final C0544g f1167w;

    /* renamed from: x */
    private final C0543f f1168x;

    /* renamed from: y */
    private final C0542e f1169y;

    /* renamed from: z */
    private final C0540c f1170z;

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$a */
    class C0538a implements Runnable {
        C0538a() {
        }

        public void run() {
            View h = ListPopupWindow.this.mo3175h();
            if (h != null && h.getWindowToken() != null) {
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$b */
    class C0539b implements AdapterView.OnItemSelectedListener {
        C0539b() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            C0622r rVar;
            if (i != -1 && (rVar = ListPopupWindow.this.f1147c) != null) {
                rVar.mo3551a(false);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$c */
    private class C0540c implements Runnable {
        C0540c() {
        }

        public void run() {
            ListPopupWindow.this.mo3173g();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$d */
    private class C0541d extends DataSetObserver {
        C0541d() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.mo2476a()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$e */
    private class C0542e implements AbsListView.OnScrollListener {
        C0542e() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.mo3180j() && ListPopupWindow.this.f1144E.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f1140A.removeCallbacks(listPopupWindow.f1167w);
                ListPopupWindow.this.f1167w.run();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$f */
    private class C0543f implements View.OnTouchListener {
        C0543f() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.f1144E) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.f1144E.getWidth() && y >= 0 && y < ListPopupWindow.this.f1144E.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f1140A.postDelayed(listPopupWindow.f1167w, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.f1140A.removeCallbacks(listPopupWindow2.f1167w);
                return false;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$g */
    private class C0544g implements Runnable {
        C0544g() {
        }

        public void run() {
            C0622r rVar = ListPopupWindow.this.f1147c;
            if (rVar != null && C0839t.m2735x(rVar) && ListPopupWindow.this.f1147c.getCount() > ListPopupWindow.this.f1147c.getChildCount()) {
                int childCount = ListPopupWindow.this.f1147c.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.f1159o) {
                    listPopupWindow.f1144E.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f1137F = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
            }
            try {
                f1139H = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                f1138G = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, R$attr.listPopupWindowStyle);
    }

    /* renamed from: c */
    private void mo3576c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f1137F;
            if (method != null) {
                try {
                    method.invoke(this.f1144E, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                }
            }
        } else {
            this.f1144E.setIsClippedToScreen(z);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.r} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int mo3073l() {
        /*
            r12 = this;
            androidx.appcompat.widget.r r0 = r12.f1147c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00bd
            android.content.Context r0 = r12.f1145a
            androidx.appcompat.widget.ListPopupWindow$a r5 = new androidx.appcompat.widget.ListPopupWindow$a
            r5.<init>()
            boolean r5 = r12.f1143D
            r5 = r5 ^ r3
            androidx.appcompat.widget.r r5 = r12.mo3157a(r0, r5)
            r12.f1147c = r5
            android.graphics.drawable.Drawable r6 = r12.f1164t
            if (r6 == 0) goto L_0x0020
            r5.setSelector(r6)
        L_0x0020:
            androidx.appcompat.widget.r r5 = r12.f1147c
            android.widget.ListAdapter r6 = r12.f1146b
            r5.setAdapter(r6)
            androidx.appcompat.widget.r r5 = r12.f1147c
            android.widget.AdapterView$OnItemClickListener r6 = r12.f1165u
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.r r5 = r12.f1147c
            r5.setFocusable(r3)
            androidx.appcompat.widget.r r5 = r12.f1147c
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.r r5 = r12.f1147c
            androidx.appcompat.widget.ListPopupWindow$b r6 = new androidx.appcompat.widget.ListPopupWindow$b
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.r r5 = r12.f1147c
            androidx.appcompat.widget.ListPopupWindow$e r6 = r12.f1169y
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.f1166v
            if (r5 == 0) goto L_0x0052
            androidx.appcompat.widget.r r6 = r12.f1147c
            r6.setOnItemSelectedListener(r5)
        L_0x0052:
            androidx.appcompat.widget.r r5 = r12.f1147c
            android.view.View r6 = r12.f1160p
            if (r6 == 0) goto L_0x00b6
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f1161q
            if (r8 == 0) goto L_0x008d
            if (r8 == r3) goto L_0x0086
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.f1161q
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0093
        L_0x0086:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0093
        L_0x008d:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0093:
            int r0 = r12.f1149e
            if (r0 < 0) goto L_0x009a
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x009c
        L_0x009a:
            r0 = 0
            r5 = 0
        L_0x009c:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b7
        L_0x00b6:
            r0 = 0
        L_0x00b7:
            android.widget.PopupWindow r6 = r12.f1144E
            r6.setContentView(r5)
            goto L_0x00db
        L_0x00bd:
            android.widget.PopupWindow r0 = r12.f1144E
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f1160p
            if (r0 == 0) goto L_0x00da
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00db
        L_0x00da:
            r0 = 0
        L_0x00db:
            android.widget.PopupWindow r5 = r12.f1144E
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f7
            android.graphics.Rect r6 = r12.f1141B
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.f1141B
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.f1153i
            if (r7 != 0) goto L_0x00fd
            int r6 = -r6
            r12.f1151g = r6
            goto L_0x00fd
        L_0x00f7:
            android.graphics.Rect r5 = r12.f1141B
            r5.setEmpty()
            r5 = 0
        L_0x00fd:
            android.widget.PopupWindow r6 = r12.f1144E
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0107
            goto L_0x0108
        L_0x0107:
            r3 = 0
        L_0x0108:
            android.view.View r4 = r12.mo3175h()
            int r6 = r12.f1151g
            int r3 = r12.m1310a(r4, r6, r3)
            boolean r4 = r12.f1157m
            if (r4 != 0) goto L_0x0179
            int r4 = r12.f1148d
            if (r4 != r2) goto L_0x011b
            goto L_0x0179
        L_0x011b:
            int r4 = r12.f1149e
            r6 = -2
            if (r4 == r6) goto L_0x0142
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x0129
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x015a
        L_0x0129:
            android.content.Context r2 = r12.f1145a
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.f1141B
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x015a
        L_0x0142:
            android.content.Context r2 = r12.f1145a
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.f1141B
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x015a:
            r7 = r1
            androidx.appcompat.widget.r r6 = r12.f1147c
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.mo3550a(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0177
            androidx.appcompat.widget.r r2 = r12.f1147c
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.r r3 = r12.f1147c
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0177:
            int r1 = r1 + r0
            return r1
        L_0x0179:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.mo3073l():int");
    }

    /* renamed from: m */
    private void mo3074m() {
        View view = this.f1160p;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1160p);
            }
        }
    }

    /* renamed from: a */
    public void mo3048a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1162r;
        if (dataSetObserver == null) {
            this.f1162r = new C0541d();
        } else {
            ListAdapter listAdapter2 = this.f1146b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1146b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1162r);
        }
        C0622r rVar = this.f1147c;
        if (rVar != null) {
            rVar.setAdapter(this.f1146b);
        }
    }

    /* renamed from: b */
    public int mo3165b() {
        return this.f1150f;
    }

    /* renamed from: d */
    public Drawable mo3168d() {
        return this.f1144E.getBackground();
    }

    public void dismiss() {
        this.f1144E.dismiss();
        mo3074m();
        this.f1144E.setContentView((View) null);
        this.f1147c = null;
        this.f1140A.removeCallbacks(this.f1167w);
    }

    /* renamed from: e */
    public void mo3170e(int i) {
        Drawable background = this.f1144E.getBackground();
        if (background != null) {
            background.getPadding(this.f1141B);
            Rect rect = this.f1141B;
            this.f1149e = rect.left + rect.right + i;
            return;
        }
        mo3179j(i);
    }

    /* renamed from: f */
    public int mo3171f() {
        if (!this.f1153i) {
            return 0;
        }
        return this.f1151g;
    }

    /* renamed from: g */
    public void mo3174g(int i) {
        this.f1144E.setInputMethodMode(i);
    }

    /* renamed from: h */
    public void mo3176h(int i) {
        this.f1161q = i;
    }

    /* renamed from: i */
    public int mo3177i() {
        return this.f1149e;
    }

    /* renamed from: j */
    public void mo3179j(int i) {
        this.f1149e = i;
    }

    /* renamed from: k */
    public boolean mo3181k() {
        return this.f1143D;
    }

    public void show() {
        int l = mo3073l();
        boolean j = mo3180j();
        C0878h.m2932a(this.f1144E, this.f1152h);
        boolean z = true;
        if (!this.f1144E.isShowing()) {
            int i = this.f1149e;
            if (i == -1) {
                i = -1;
            } else if (i == -2) {
                i = mo3175h().getWidth();
            }
            int i2 = this.f1148d;
            if (i2 == -1) {
                l = -1;
            } else if (i2 != -2) {
                l = i2;
            }
            this.f1144E.setWidth(i);
            this.f1144E.setHeight(l);
            mo3576c(true);
            this.f1144E.setOutsideTouchable(!this.f1158n && !this.f1157m);
            this.f1144E.setTouchInterceptor(this.f1168x);
            if (this.f1155k) {
                C0878h.m2934a(this.f1144E, this.f1154j);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = f1139H;
                if (method != null) {
                    try {
                        method.invoke(this.f1144E, new Object[]{this.f1142C});
                    } catch (Exception e) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                    }
                }
            } else {
                this.f1144E.setEpicenterBounds(this.f1142C);
            }
            C0878h.m2933a(this.f1144E, mo3175h(), this.f1150f, this.f1151g, this.f1156l);
            this.f1147c.setSelection(-1);
            if (!this.f1143D || this.f1147c.isInTouchMode()) {
                mo3173g();
            }
            if (!this.f1143D) {
                this.f1140A.post(this.f1170z);
            }
        } else if (C0839t.m2735x(mo3175h())) {
            int i3 = this.f1149e;
            if (i3 == -1) {
                i3 = -1;
            } else if (i3 == -2) {
                i3 = mo3175h().getWidth();
            }
            int i4 = this.f1148d;
            if (i4 == -1) {
                if (!j) {
                    l = -1;
                }
                if (j) {
                    this.f1144E.setWidth(this.f1149e == -1 ? -1 : 0);
                    this.f1144E.setHeight(0);
                } else {
                    this.f1144E.setWidth(this.f1149e == -1 ? -1 : 0);
                    this.f1144E.setHeight(-1);
                }
            } else if (i4 != -2) {
                l = i4;
            }
            PopupWindow popupWindow = this.f1144E;
            if (this.f1158n || this.f1157m) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.f1144E.update(mo3175h(), this.f1150f, this.f1151g, i3 < 0 ? -1 : i3, l < 0 ? -1 : l);
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* renamed from: b */
    public void mo3166b(int i) {
        this.f1151g = i;
        this.f1153i = true;
    }

    /* renamed from: d */
    public void mo3169d(int i) {
        this.f1144E.setAnimationStyle(i);
    }

    /* renamed from: g */
    public void mo3173g() {
        C0622r rVar = this.f1147c;
        if (rVar != null) {
            rVar.mo3551a(true);
            rVar.requestLayout();
        }
    }

    /* renamed from: h */
    public View mo3175h() {
        return this.f1163s;
    }

    /* renamed from: i */
    public void mo3178i(int i) {
        C0622r rVar = this.f1147c;
        if (mo2476a() && rVar != null) {
            rVar.mo3551a(false);
            rVar.setSelection(i);
            if (rVar.getChoiceMode() != 0) {
                rVar.setItemChecked(i, true);
            }
        }
    }

    /* renamed from: j */
    public boolean mo3180j() {
        return this.f1144E.getInputMethodMode() == 2;
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1148d = -2;
        this.f1149e = -2;
        this.f1152h = 1002;
        this.f1156l = 0;
        this.f1157m = false;
        this.f1158n = false;
        this.f1159o = Integer.MAX_VALUE;
        this.f1161q = 0;
        this.f1167w = new C0544g();
        this.f1168x = new C0543f();
        this.f1169y = new C0542e();
        this.f1170z = new C0540c();
        this.f1141B = new Rect();
        this.f1145a = context;
        this.f1140A = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i, i2);
        this.f1150f = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1151g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1153i = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.f1144E = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    /* renamed from: f */
    public void mo3172f(int i) {
        this.f1156l = i;
    }

    /* renamed from: b */
    public void mo3167b(boolean z) {
        this.f1155k = true;
        this.f1154j = z;
    }

    /* renamed from: e */
    public ListView mo2484e() {
        return this.f1147c;
    }

    /* renamed from: a */
    public void mo3164a(boolean z) {
        this.f1143D = z;
        this.f1144E.setFocusable(z);
    }

    /* renamed from: a */
    public void mo3160a(Drawable drawable) {
        this.f1144E.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public void mo3161a(View view) {
        this.f1163s = view;
    }

    /* renamed from: a */
    public void mo3158a(int i) {
        this.f1150f = i;
    }

    /* renamed from: a */
    public void mo3159a(Rect rect) {
        this.f1142C = rect != null ? new Rect(rect) : null;
    }

    /* renamed from: a */
    public void mo3162a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1165u = onItemClickListener;
    }

    /* renamed from: a */
    public void mo3163a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1144E.setOnDismissListener(onDismissListener);
    }

    /* renamed from: a */
    public boolean mo2476a() {
        return this.f1144E.isShowing();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0622r mo3157a(Context context, boolean z) {
        return new C0622r(context, z);
    }

    /* renamed from: a */
    private int m1310a(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.f1144E.getMaxAvailableHeight(view, i, z);
        }
        Method method = f1138G;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f1144E, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception unused) {
            }
        }
        return this.f1144E.getMaxAvailableHeight(view, i);
    }
}
