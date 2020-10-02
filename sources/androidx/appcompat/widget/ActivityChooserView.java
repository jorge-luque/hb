package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.C0502p;
import androidx.core.p020f.C0800b;
import androidx.core.p020f.p021c0.C0807c;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: a */
    final C0524f f1015a;

    /* renamed from: b */
    private final C0525g f1016b;

    /* renamed from: c */
    private final View f1017c;

    /* renamed from: d */
    private final Drawable f1018d;

    /* renamed from: e */
    final FrameLayout f1019e;

    /* renamed from: f */
    private final ImageView f1020f;

    /* renamed from: g */
    final FrameLayout f1021g;

    /* renamed from: h */
    private final ImageView f1022h;

    /* renamed from: i */
    private final int f1023i;

    /* renamed from: j */
    C0800b f1024j;

    /* renamed from: k */
    final DataSetObserver f1025k = new C0519a();

    /* renamed from: l */
    private final ViewTreeObserver.OnGlobalLayoutListener f1026l = new C0520b();

    /* renamed from: m */
    private ListPopupWindow f1027m;

    /* renamed from: n */
    PopupWindow.OnDismissListener f1028n;

    /* renamed from: o */
    boolean f1029o;

    /* renamed from: p */
    int f1030p = 4;

    /* renamed from: q */
    private boolean f1031q;

    /* renamed from: r */
    private int f1032r;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        private static final int[] f1033a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C0598g0 a = C0598g0.m1609a(context, attributeSet, f1033a);
            setBackgroundDrawable(a.mo3437b(0));
            a.mo3434a();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$a */
    class C0519a extends DataSetObserver {
        C0519a() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f1015a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f1015a.notifyDataSetInvalidated();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$b */
    class C0520b implements ViewTreeObserver.OnGlobalLayoutListener {
        C0520b() {
        }

        public void onGlobalLayout() {
            if (!ActivityChooserView.this.mo2893c()) {
                return;
            }
            if (!ActivityChooserView.this.isShown()) {
                ActivityChooserView.this.mo2892b().dismiss();
                return;
            }
            ActivityChooserView.this.mo2892b().show();
            C0800b bVar = ActivityChooserView.this.f1024j;
            if (bVar != null) {
                bVar.mo4097a(true);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$c */
    class C0521c extends View.AccessibilityDelegate {
        C0521c() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            C0807c.m2550a(accessibilityNodeInfo).mo4125b(true);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$d */
    class C0522d extends C0627t {
        C0522d(View view) {
            super(view);
        }

        /* renamed from: a */
        public C0502p mo2379a() {
            return ActivityChooserView.this.mo2892b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public boolean mo2380b() {
            ActivityChooserView.this.mo2894d();
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public boolean mo2904c() {
            ActivityChooserView.this.mo2891a();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$e */
    class C0523e extends DataSetObserver {
        C0523e() {
        }

        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.mo2895e();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$g */
    private class C0525g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        C0525g() {
        }

        /* renamed from: a */
        private void m1169a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f1028n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f1021g) {
                activityChooserView.mo2891a();
                Intent a = ActivityChooserView.this.f1015a.mo2910b().mo3384a(ActivityChooserView.this.f1015a.mo2910b().mo3383a(ActivityChooserView.this.f1015a.mo2911c()));
                if (a != null) {
                    a.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(a);
                }
            } else if (view == activityChooserView.f1019e) {
                activityChooserView.f1029o = false;
                activityChooserView.mo2890a(activityChooserView.f1030p);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            m1169a();
            C0800b bVar = ActivityChooserView.this.f1024j;
            if (bVar != null) {
                bVar.mo4097a(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((C0524f) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType == 0) {
                ActivityChooserView.this.mo2891a();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.f1029o) {
                    if (!activityChooserView.f1015a.mo2913e()) {
                        i++;
                    }
                    Intent a = ActivityChooserView.this.f1015a.mo2910b().mo3384a(i);
                    if (a != null) {
                        a.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(a);
                    }
                } else if (i > 0) {
                    activityChooserView.f1015a.mo2910b().mo3388c(i);
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.mo2890a(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f1021g) {
                if (activityChooserView.f1015a.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.f1029o = true;
                    activityChooserView2.mo2890a(activityChooserView2.f1030p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActivityChooserView, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R$styleable.ActivityChooserView, attributeSet, obtainStyledAttributes, i, 0);
        }
        this.f1030p = obtainStyledAttributes.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, this, true);
        this.f1016b = new C0525g();
        View findViewById = findViewById(R$id.activity_chooser_view_content);
        this.f1017c = findViewById;
        this.f1018d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.default_activity_button);
        this.f1021g = frameLayout;
        frameLayout.setOnClickListener(this.f1016b);
        this.f1021g.setOnLongClickListener(this.f1016b);
        this.f1022h = (ImageView) this.f1021g.findViewById(R$id.image);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.expand_activities_button);
        frameLayout2.setOnClickListener(this.f1016b);
        frameLayout2.setAccessibilityDelegate(new C0521c());
        frameLayout2.setOnTouchListener(new C0522d(frameLayout2));
        this.f1019e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(R$id.image);
        this.f1020f = imageView;
        imageView.setImageDrawable(drawable);
        C0524f fVar = new C0524f();
        this.f1015a = fVar;
        fVar.registerDataSetObserver(new C0523e());
        Resources resources = context.getResources();
        this.f1023i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2890a(int i) {
        if (this.f1015a.mo2910b() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f1026l);
            boolean z = this.f1021g.getVisibility() == 0;
            int a = this.f1015a.mo2906a();
            if (i == Integer.MAX_VALUE || a <= i + (z ? 1 : 0)) {
                this.f1015a.mo2908a(false);
                this.f1015a.mo2907a(i);
            } else {
                this.f1015a.mo2908a(true);
                this.f1015a.mo2907a(i - 1);
            }
            ListPopupWindow b = mo2892b();
            if (!b.mo2476a()) {
                if (this.f1029o || !z) {
                    this.f1015a.mo2909a(true, z);
                } else {
                    this.f1015a.mo2909a(false, false);
                }
                b.mo3170e(Math.min(this.f1015a.mo2914f(), this.f1023i));
                b.show();
                C0800b bVar = this.f1024j;
                if (bVar != null) {
                    bVar.mo4097a(true);
                }
                b.mo2484e().setContentDescription(getContext().getString(R$string.abc_activitychooserview_choose_application));
                b.mo2484e().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ListPopupWindow mo2892b() {
        if (this.f1027m == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1027m = listPopupWindow;
            listPopupWindow.mo3048a((ListAdapter) this.f1015a);
            this.f1027m.mo3161a((View) this);
            this.f1027m.mo3164a(true);
            this.f1027m.mo3162a((AdapterView.OnItemClickListener) this.f1016b);
            this.f1027m.mo3163a((PopupWindow.OnDismissListener) this.f1016b);
        }
        return this.f1027m;
    }

    /* renamed from: c */
    public boolean mo2893c() {
        return mo2892b().mo2476a();
    }

    /* renamed from: d */
    public boolean mo2894d() {
        if (mo2893c() || !this.f1031q) {
            return false;
        }
        this.f1029o = false;
        mo2890a(this.f1030p);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo2895e() {
        if (this.f1015a.getCount() > 0) {
            this.f1019e.setEnabled(true);
        } else {
            this.f1019e.setEnabled(false);
        }
        int a = this.f1015a.mo2906a();
        int d = this.f1015a.mo2912d();
        if (a == 1 || (a > 1 && d > 0)) {
            this.f1021g.setVisibility(0);
            ResolveInfo c = this.f1015a.mo2911c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1022h.setImageDrawable(c.loadIcon(packageManager));
            if (this.f1032r != 0) {
                CharSequence loadLabel = c.loadLabel(packageManager);
                this.f1021g.setContentDescription(getContext().getString(this.f1032r, new Object[]{loadLabel}));
            }
        } else {
            this.f1021g.setVisibility(8);
        }
        if (this.f1021g.getVisibility() == 0) {
            this.f1017c.setBackgroundDrawable(this.f1018d);
        } else {
            this.f1017c.setBackgroundDrawable((Drawable) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0585d b = this.f1015a.mo2910b();
        if (b != null) {
            b.registerObserver(this.f1025k);
        }
        this.f1031q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0585d b = this.f1015a.mo2910b();
        if (b != null) {
            b.unregisterObserver(this.f1025k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1026l);
        }
        if (mo2893c()) {
            mo2891a();
        }
        this.f1031q = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1017c.layout(0, 0, i3 - i, i4 - i2);
        if (!mo2893c()) {
            mo2891a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        View view = this.f1017c;
        if (this.f1021g.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$f */
    private class C0524f extends BaseAdapter {

        /* renamed from: a */
        private C0585d f1039a;

        /* renamed from: b */
        private int f1040b = 4;

        /* renamed from: c */
        private boolean f1041c;

        /* renamed from: d */
        private boolean f1042d;

        /* renamed from: e */
        private boolean f1043e;

        C0524f() {
        }

        /* renamed from: a */
        public void mo2907a(int i) {
            if (this.f1040b != i) {
                this.f1040b = i;
                notifyDataSetChanged();
            }
        }

        /* renamed from: b */
        public C0585d mo2910b() {
            return this.f1039a;
        }

        /* renamed from: c */
        public ResolveInfo mo2911c() {
            return this.f1039a.mo3385b();
        }

        /* renamed from: d */
        public int mo2912d() {
            return this.f1039a.mo3387c();
        }

        /* renamed from: e */
        public boolean mo2913e() {
            return this.f1041c;
        }

        /* renamed from: f */
        public int mo2914f() {
            int i = this.f1040b;
            this.f1040b = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f1040b = i;
            return i2;
        }

        public int getCount() {
            int a = this.f1039a.mo3382a();
            if (!this.f1041c && this.f1039a.mo3385b() != null) {
                a--;
            }
            int min = Math.min(a, this.f1040b);
            return this.f1043e ? min + 1 : min;
        }

        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (!this.f1041c && this.f1039a.mo3385b() != null) {
                    i++;
                }
                return this.f1039a.mo3386b(i);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (!this.f1043e || i != getCount() - 1) ? 0 : 1;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R$id.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(R$id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R$id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f1041c || i != 0 || !this.f1042d) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R$id.title)).setText(ActivityChooserView.this.getContext().getString(R$string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }

        /* renamed from: a */
        public void mo2908a(boolean z) {
            if (this.f1043e != z) {
                this.f1043e = z;
                notifyDataSetChanged();
            }
        }

        /* renamed from: a */
        public int mo2906a() {
            return this.f1039a.mo3382a();
        }

        /* renamed from: a */
        public void mo2909a(boolean z, boolean z2) {
            if (this.f1041c != z || this.f1042d != z2) {
                this.f1041c = z;
                this.f1042d = z2;
                notifyDataSetChanged();
            }
        }
    }

    /* renamed from: a */
    public boolean mo2891a() {
        if (!mo2893c()) {
            return true;
        }
        mo2892b().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1026l);
        return true;
    }
}
