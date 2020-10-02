package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.C0402b;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.appcompat.view.menu.C0502p;
import androidx.core.p020f.C0838s;
import androidx.core.p020f.C0839t;

public class AppCompatSpinner extends Spinner implements C0838s {

    /* renamed from: i */
    private static final int[] f1073i = {16843505};

    /* renamed from: a */
    private final C0592e f1074a;

    /* renamed from: b */
    private final Context f1075b;

    /* renamed from: c */
    private C0627t f1076c;

    /* renamed from: d */
    private SpinnerAdapter f1077d;

    /* renamed from: e */
    private final boolean f1078e;

    /* renamed from: f */
    private C0535f f1079f;

    /* renamed from: g */
    int f1080g;

    /* renamed from: h */
    final Rect f1081h;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0526a();

        /* renamed from: a */
        boolean f1082a;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$SavedState$a */
        static class C0526a implements Parcelable.Creator<SavedState> {
            C0526a() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f1082a ? (byte) 1 : 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1082a = parcel.readByte() != 0;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$a */
    class C0527a extends C0627t {

        /* renamed from: j */
        final /* synthetic */ C0531e f1083j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0527a(View view, C0531e eVar) {
            super(view);
            this.f1083j = eVar;
        }

        /* renamed from: a */
        public C0502p mo2379a() {
            return this.f1083j;
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b */
        public boolean mo2380b() {
            if (AppCompatSpinner.this.mo3016a().mo3050a()) {
                return true;
            }
            AppCompatSpinner.this.mo3017b();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$b */
    class C0528b implements ViewTreeObserver.OnGlobalLayoutListener {
        C0528b() {
        }

        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.mo3016a().mo3050a()) {
                AppCompatSpinner.this.mo3017b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$c */
    class C0529c implements C0535f, DialogInterface.OnClickListener {

        /* renamed from: a */
        C0402b f1086a;

        /* renamed from: b */
        private ListAdapter f1087b;

        /* renamed from: c */
        private CharSequence f1088c;

        C0529c() {
        }

        /* renamed from: a */
        public boolean mo3050a() {
            C0402b bVar = this.f1086a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        /* renamed from: b */
        public int mo3051b() {
            return 0;
        }

        /* renamed from: b */
        public void mo3052b(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        /* renamed from: c */
        public CharSequence mo3053c() {
            return this.f1088c;
        }

        /* renamed from: d */
        public Drawable mo3055d() {
            return null;
        }

        public void dismiss() {
            C0402b bVar = this.f1086a;
            if (bVar != null) {
                bVar.dismiss();
                this.f1086a = null;
            }
        }

        /* renamed from: f */
        public int mo3057f() {
            return 0;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i, this.f1087b.getItemId(i));
            }
            dismiss();
        }

        /* renamed from: a */
        public void mo3048a(ListAdapter listAdapter) {
            this.f1087b = listAdapter;
        }

        /* renamed from: c */
        public void mo3054c(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        /* renamed from: a */
        public void mo3049a(CharSequence charSequence) {
            this.f1088c = charSequence;
        }

        /* renamed from: a */
        public void mo3046a(int i, int i2) {
            if (this.f1087b != null) {
                C0402b.C0403a aVar = new C0402b.C0403a(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f1088c;
                if (charSequence != null) {
                    aVar.mo1981a(charSequence);
                }
                aVar.mo1979a(this.f1087b, AppCompatSpinner.this.getSelectedItemPosition(), this);
                C0402b a = aVar.mo1982a();
                this.f1086a = a;
                ListView b = a.mo1971b();
                if (Build.VERSION.SDK_INT >= 17) {
                    b.setTextDirection(i);
                    b.setTextAlignment(i2);
                }
                this.f1086a.show();
            }
        }

        /* renamed from: a */
        public void mo3047a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        /* renamed from: a */
        public void mo3045a(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$d */
    private static class C0530d implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        private SpinnerAdapter f1090a;

        /* renamed from: b */
        private ListAdapter f1091b;

        public C0530d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1090a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1091b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof C0584c0) {
                C0584c0 c0Var = (C0584c0) spinnerAdapter;
                if (c0Var.getDropDownViewTheme() == null) {
                    c0Var.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1091b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1090a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1090a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f1090a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f1090a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1090a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1091b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1090a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1090a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e */
    class C0531e extends ListPopupWindow implements C0535f {

        /* renamed from: I */
        private CharSequence f1092I;

        /* renamed from: J */
        ListAdapter f1093J;

        /* renamed from: K */
        private final Rect f1094K = new Rect();

        /* renamed from: L */
        private int f1095L;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e$a */
        class C0532a implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ AppCompatSpinner f1097a;

            C0532a(AppCompatSpinner appCompatSpinner) {
                this.f1097a = appCompatSpinner;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppCompatSpinner.this.setSelection(i);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    C0531e eVar = C0531e.this;
                    AppCompatSpinner.this.performItemClick(view, i, eVar.f1093J.getItemId(i));
                }
                C0531e.this.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e$b */
        class C0533b implements ViewTreeObserver.OnGlobalLayoutListener {
            C0533b() {
            }

            public void onGlobalLayout() {
                C0531e eVar = C0531e.this;
                if (!eVar.mo3072b(AppCompatSpinner.this)) {
                    C0531e.this.dismiss();
                    return;
                }
                C0531e.this.mo3073l();
                C0531e.super.show();
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e$c */
        class C0534c implements PopupWindow.OnDismissListener {

            /* renamed from: a */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1100a;

            C0534c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1100a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1100a);
                }
            }
        }

        public C0531e(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            mo3161a((View) AppCompatSpinner.this);
            mo3164a(true);
            mo3176h(0);
            mo3162a((AdapterView.OnItemClickListener) new C0532a(AppCompatSpinner.this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo3072b(View view) {
            return C0839t.m2735x(view) && view.getGlobalVisibleRect(this.f1094K);
        }

        /* renamed from: c */
        public CharSequence mo3053c() {
            return this.f1092I;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public void mo3073l() {
            int i;
            Drawable d = mo3168d();
            int i2 = 0;
            if (d != null) {
                d.getPadding(AppCompatSpinner.this.f1081h);
                i2 = C0616m0.m1739a(AppCompatSpinner.this) ? AppCompatSpinner.this.f1081h.right : -AppCompatSpinner.this.f1081h.left;
            } else {
                Rect rect = AppCompatSpinner.this.f1081h;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i3 = appCompatSpinner.f1080g;
            if (i3 == -2) {
                int a = appCompatSpinner.mo3015a((SpinnerAdapter) this.f1093J, mo3168d());
                int i4 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f1081h;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (a > i5) {
                    a = i5;
                }
                mo3170e(Math.max(a, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                mo3170e((width - paddingLeft) - paddingRight);
            } else {
                mo3170e(i3);
            }
            if (C0616m0.m1739a(AppCompatSpinner.this)) {
                i = i2 + (((width - paddingRight) - mo3177i()) - mo3074m());
            } else {
                i = i2 + paddingLeft + mo3074m();
            }
            mo3158a(i);
        }

        /* renamed from: m */
        public int mo3074m() {
            return this.f1095L;
        }

        /* renamed from: a */
        public void mo3048a(ListAdapter listAdapter) {
            super.mo3048a(listAdapter);
            this.f1093J = listAdapter;
        }

        /* renamed from: c */
        public void mo3054c(int i) {
            this.f1095L = i;
        }

        /* renamed from: a */
        public void mo3049a(CharSequence charSequence) {
            this.f1092I = charSequence;
        }

        /* renamed from: a */
        public void mo3046a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean a = mo2476a();
            mo3073l();
            mo3174g(2);
            super.show();
            ListView e = mo2484e();
            e.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                e.setTextDirection(i);
                e.setTextAlignment(i2);
            }
            mo3178i(AppCompatSpinner.this.getSelectedItemPosition());
            if (!a && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                C0533b bVar = new C0533b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                mo3163a((PopupWindow.OnDismissListener) new C0534c(bVar));
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$f */
    interface C0535f {
        /* renamed from: a */
        void mo3045a(int i);

        /* renamed from: a */
        void mo3046a(int i, int i2);

        /* renamed from: a */
        void mo3047a(Drawable drawable);

        /* renamed from: a */
        void mo3048a(ListAdapter listAdapter);

        /* renamed from: a */
        void mo3049a(CharSequence charSequence);

        /* renamed from: a */
        boolean mo3050a();

        /* renamed from: b */
        int mo3051b();

        /* renamed from: b */
        void mo3052b(int i);

        /* renamed from: c */
        CharSequence mo3053c();

        /* renamed from: c */
        void mo3054c(int i);

        /* renamed from: d */
        Drawable mo3055d();

        void dismiss();

        /* renamed from: f */
        int mo3057f();
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo3015a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.f1081h);
        Rect rect = this.f1081h;
        return i2 + rect.left + rect.right;
    }

    /* renamed from: b */
    public void mo2925b(ColorStateList colorStateList) {
        C0592e eVar = this.f1074a;
        if (eVar != null) {
            eVar.mo3411b(colorStateList);
        }
    }

    /* renamed from: d */
    public ColorStateList mo2927d() {
        C0592e eVar = this.f1074a;
        if (eVar != null) {
            return eVar.mo3410b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0592e eVar = this.f1074a;
        if (eVar != null) {
            eVar.mo3404a();
        }
    }

    /* renamed from: f */
    public PorterDuff.Mode mo2929f() {
        C0592e eVar = this.f1074a;
        if (eVar != null) {
            return eVar.mo3412c();
        }
        return null;
    }

    public int getDropDownHorizontalOffset() {
        C0535f fVar = this.f1079f;
        if (fVar != null) {
            return fVar.mo3051b();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        C0535f fVar = this.f1079f;
        if (fVar != null) {
            return fVar.mo3057f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        if (this.f1079f != null) {
            return this.f1080g;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public Drawable getPopupBackground() {
        C0535f fVar = this.f1079f;
        if (fVar != null) {
            return fVar.mo3055d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        return this.f1075b;
    }

    public CharSequence getPrompt() {
        C0535f fVar = this.f1079f;
        return fVar != null ? fVar.mo3053c() : super.getPrompt();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0535f fVar = this.f1079f;
        if (fVar != null && fVar.mo3050a()) {
            this.f1079f.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1079f != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), mo3015a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1082a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new C0528b());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        C0535f fVar = this.f1079f;
        savedState.f1082a = fVar != null && fVar.mo3050a();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0627t tVar = this.f1076c;
        if (tVar == null || !tVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        C0535f fVar = this.f1079f;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.mo3050a()) {
            return true;
        }
        mo3017b();
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0592e eVar = this.f1074a;
        if (eVar != null) {
            eVar.mo3408a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0592e eVar = this.f1074a;
        if (eVar != null) {
            eVar.mo3405a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        C0535f fVar = this.f1079f;
        if (fVar != null) {
            fVar.mo3054c(i);
            this.f1079f.mo3045a(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        C0535f fVar = this.f1079f;
        if (fVar != null) {
            fVar.mo3052b(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f1079f != null) {
            this.f1080g = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        C0535f fVar = this.f1079f;
        if (fVar != null) {
            fVar.mo3047a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0383a.m323c(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        C0535f fVar = this.f1079f;
        if (fVar != null) {
            fVar.mo3049a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1078e) {
            this.f1077d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1079f != null) {
            Context context = this.f1075b;
            if (context == null) {
                context = getContext();
            }
            this.f1079f.mo3048a((ListAdapter) new C0530d(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, (Resources.Theme) null);
    }

    /* renamed from: b */
    public void mo2926b(PorterDuff.Mode mode) {
        C0592e eVar = this.f1074a;
        if (eVar != null) {
            eVar.mo3407a(mode);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r10 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        r10.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r10 != null) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(android.content.Context r6, android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) {
        /*
            r5 = this;
            r5.<init>(r6, r7, r8)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.f1081h = r0
            int[] r0 = androidx.appcompat.R$styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.g0 r0 = androidx.appcompat.widget.C0598g0.m1610a(r6, r7, r0, r8, r1)
            androidx.appcompat.widget.e r2 = new androidx.appcompat.widget.e
            r2.<init>(r5)
            r5.f1074a = r2
            if (r10 == 0) goto L_0x0022
            androidx.appcompat.d.d r2 = new androidx.appcompat.d.d
            r2.<init>((android.content.Context) r6, (android.content.res.Resources.Theme) r10)
            r5.f1075b = r2
            goto L_0x0034
        L_0x0022:
            int r10 = androidx.appcompat.R$styleable.Spinner_popupTheme
            int r10 = r0.mo3446g(r10, r1)
            if (r10 == 0) goto L_0x0032
            androidx.appcompat.d.d r2 = new androidx.appcompat.d.d
            r2.<init>((android.content.Context) r6, (int) r10)
            r5.f1075b = r2
            goto L_0x0034
        L_0x0032:
            r5.f1075b = r6
        L_0x0034:
            r10 = -1
            r2 = 0
            if (r9 != r10) goto L_0x005c
            int[] r10 = f1073i     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            android.content.res.TypedArray r10 = r6.obtainStyledAttributes(r7, r10, r8, r1)     // Catch:{ Exception -> 0x0058, all -> 0x0051 }
            boolean r3 = r10.hasValue(r1)     // Catch:{ Exception -> 0x0059, all -> 0x004e }
            if (r3 == 0) goto L_0x0048
            int r9 = r10.getInt(r1, r1)     // Catch:{ Exception -> 0x0059, all -> 0x004e }
        L_0x0048:
            if (r10 == 0) goto L_0x005c
        L_0x004a:
            r10.recycle()
            goto L_0x005c
        L_0x004e:
            r6 = move-exception
            r2 = r10
            goto L_0x0052
        L_0x0051:
            r6 = move-exception
        L_0x0052:
            if (r2 == 0) goto L_0x0057
            r2.recycle()
        L_0x0057:
            throw r6
        L_0x0058:
            r10 = r2
        L_0x0059:
            if (r10 == 0) goto L_0x005c
            goto L_0x004a
        L_0x005c:
            r10 = 1
            if (r9 == 0) goto L_0x0099
            if (r9 == r10) goto L_0x0062
            goto L_0x00a9
        L_0x0062:
            androidx.appcompat.widget.AppCompatSpinner$e r9 = new androidx.appcompat.widget.AppCompatSpinner$e
            android.content.Context r3 = r5.f1075b
            r9.<init>(r3, r7, r8)
            android.content.Context r3 = r5.f1075b
            int[] r4 = androidx.appcompat.R$styleable.Spinner
            androidx.appcompat.widget.g0 r1 = androidx.appcompat.widget.C0598g0.m1610a(r3, r7, r4, r8, r1)
            int r3 = androidx.appcompat.R$styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.mo3444f(r3, r4)
            r5.f1080g = r3
            int r3 = androidx.appcompat.R$styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.mo3437b(r3)
            r9.mo3160a((android.graphics.drawable.Drawable) r3)
            int r3 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r3 = r0.mo3441d(r3)
            r9.mo3049a((java.lang.CharSequence) r3)
            r1.mo3434a()
            r5.f1079f = r9
            androidx.appcompat.widget.AppCompatSpinner$a r1 = new androidx.appcompat.widget.AppCompatSpinner$a
            r1.<init>(r5, r9)
            r5.f1076c = r1
            goto L_0x00a9
        L_0x0099:
            androidx.appcompat.widget.AppCompatSpinner$c r9 = new androidx.appcompat.widget.AppCompatSpinner$c
            r9.<init>()
            r5.f1079f = r9
            int r1 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r1 = r0.mo3441d(r1)
            r9.mo3049a((java.lang.CharSequence) r1)
        L_0x00a9:
            int r9 = androidx.appcompat.R$styleable.Spinner_android_entries
            java.lang.CharSequence[] r9 = r0.mo3445f(r9)
            if (r9 == 0) goto L_0x00c1
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r6, r3, r9)
            int r6 = androidx.appcompat.R$layout.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r6)
            r5.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00c1:
            r0.mo3434a()
            r5.f1078e = r10
            android.widget.SpinnerAdapter r6 = r5.f1077d
            if (r6 == 0) goto L_0x00cf
            r5.setAdapter((android.widget.SpinnerAdapter) r6)
            r5.f1077d = r2
        L_0x00cf:
            androidx.appcompat.widget.e r6 = r5.f1074a
            r6.mo3409a(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3017b() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1079f.mo3046a(getTextDirection(), getTextAlignment());
        } else {
            this.f1079f.mo3046a(-1, -1);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C0535f mo3016a() {
        return this.f1079f;
    }
}
