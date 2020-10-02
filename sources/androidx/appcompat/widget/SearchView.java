package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.p011d.C0457c;
import androidx.core.p020f.C0839t;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.drive.DriveFile;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p075d.p081c.p082a.C3206a;

public class SearchView extends LinearLayoutCompat implements C0457c {

    /* renamed from: n0 */
    static final C0557k f1178n0 = new C0557k();

    /* renamed from: A */
    private Rect f1179A;

    /* renamed from: B */
    private int[] f1180B;

    /* renamed from: C */
    private int[] f1181C;

    /* renamed from: D */
    private final ImageView f1182D;

    /* renamed from: E */
    private final Drawable f1183E;

    /* renamed from: F */
    private final Intent f1184F;

    /* renamed from: G */
    private final Intent f1185G;

    /* renamed from: H */
    private final CharSequence f1186H;

    /* renamed from: I */
    private C0559m f1187I;

    /* renamed from: J */
    private C0558l f1188J;

    /* renamed from: K */
    View.OnFocusChangeListener f1189K;

    /* renamed from: L */
    private C0560n f1190L;

    /* renamed from: M */
    private View.OnClickListener f1191M;

    /* renamed from: N */
    private boolean f1192N;

    /* renamed from: O */
    private boolean f1193O;

    /* renamed from: P */
    C3206a f1194P;

    /* renamed from: Q */
    private boolean f1195Q;

    /* renamed from: R */
    private CharSequence f1196R;

    /* renamed from: S */
    private boolean f1197S;

    /* renamed from: U */
    private int f1198U;

    /* renamed from: V */
    private boolean f1199V;

    /* renamed from: W */
    private CharSequence f1200W;

    /* renamed from: a0 */
    private CharSequence f1201a0;

    /* renamed from: b0 */
    private boolean f1202b0;

    /* renamed from: c0 */
    private int f1203c0;

    /* renamed from: d0 */
    SearchableInfo f1204d0;

    /* renamed from: e0 */
    private Bundle f1205e0;

    /* renamed from: f0 */
    private final Runnable f1206f0;

    /* renamed from: g0 */
    private Runnable f1207g0;

    /* renamed from: h0 */
    private final View.OnClickListener f1208h0;

    /* renamed from: i0 */
    View.OnKeyListener f1209i0;

    /* renamed from: j0 */
    private final TextView.OnEditorActionListener f1210j0;

    /* renamed from: k0 */
    private final AdapterView.OnItemClickListener f1211k0;

    /* renamed from: l0 */
    private final AdapterView.OnItemSelectedListener f1212l0;

    /* renamed from: m0 */
    private TextWatcher f1213m0;

    /* renamed from: p */
    final SearchAutoComplete f1214p;

    /* renamed from: q */
    private final View f1215q;

    /* renamed from: r */
    private final View f1216r;

    /* renamed from: s */
    private final View f1217s;

    /* renamed from: t */
    final ImageView f1218t;

    /* renamed from: u */
    final ImageView f1219u;

    /* renamed from: v */
    final ImageView f1220v;

    /* renamed from: w */
    final ImageView f1221w;

    /* renamed from: x */
    private final View f1222x;

    /* renamed from: y */
    private C0561o f1223y;

    /* renamed from: z */
    private Rect f1224z;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0545a();

        /* renamed from: c */
        boolean f1225c;

        /* renamed from: androidx.appcompat.widget.SearchView$SavedState$a */
        static class C0545a implements Parcelable.ClassLoaderCreator<SavedState> {
            C0545a() {
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

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1225c + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1225c));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1225c = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: d */
        private int f1226d;

        /* renamed from: e */
        private SearchView f1227e;

        /* renamed from: f */
        private boolean f1228f;

        /* renamed from: g */
        final Runnable f1229g;

        /* renamed from: androidx.appcompat.widget.SearchView$SearchAutoComplete$a */
        class C0546a implements Runnable {
            C0546a() {
            }

            public void run() {
                SearchAutoComplete.this.mo3227b();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, (AttributeSet) null);
        }

        /* renamed from: c */
        private int m1387c() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3224a(SearchView searchView) {
            this.f1227e = searchView;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo3227b() {
            if (this.f1228f) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1228f = false;
            }
        }

        public boolean enoughToFilter() {
            return this.f1226d <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1228f) {
                removeCallbacks(this.f1229g);
                post(this.f1229g);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) m1387c(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1227e.mo3211n();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1227e.clearFocus();
                        mo3225a(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1227e.hasFocus() && getVisibility() == 0) {
                this.f1228f = true;
                if (SearchView.m1347a(getContext())) {
                    SearchView.f1178n0.mo3251a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1226d = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo3226a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1229g = new C0546a();
            this.f1226d = getThreshold();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3225a(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f1228f = false;
                removeCallbacks(this.f1229g);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1228f = false;
                removeCallbacks(this.f1229g);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1228f = true;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$a */
    class C0547a implements TextWatcher {
        C0547a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.mo3193a(charSequence);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$b */
    class C0548b implements Runnable {
        C0548b() {
        }

        public void run() {
            SearchView.this.mo3217p();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$c */
    class C0549c implements Runnable {
        C0549c() {
        }

        public void run() {
            C3206a aVar = SearchView.this.f1194P;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$d */
    class C0550d implements View.OnFocusChangeListener {
        C0550d() {
        }

        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f1189K;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$e */
    class C0551e implements View.OnLayoutChangeListener {
        C0551e() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView.this.mo3201g();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$f */
    class C0552f implements View.OnClickListener {
        C0552f() {
        }

        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f1218t) {
                searchView.mo3209l();
            } else if (view == searchView.f1220v) {
                searchView.mo3208k();
            } else if (view == searchView.f1219u) {
                searchView.mo3210m();
            } else if (view == searchView.f1221w) {
                searchView.mo3212o();
            } else if (view == searchView.f1214p) {
                searchView.mo3203h();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$g */
    class C0553g implements View.OnKeyListener {
        C0553g() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f1204d0 == null) {
                return false;
            }
            if (searchView.f1214p.isPopupShowing() && SearchView.this.f1214p.getListSelection() != -1) {
                return SearchView.this.mo3196a(view, i, keyEvent);
            }
            if (SearchView.this.f1214p.mo3226a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.mo3192a(0, (String) null, searchView2.f1214p.getText().toString());
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$h */
    class C0554h implements TextView.OnEditorActionListener {
        C0554h() {
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.mo3210m();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$i */
    class C0555i implements AdapterView.OnItemClickListener {
        C0555i() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.mo3195a(i, 0, (String) null);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$j */
    class C0556j implements AdapterView.OnItemSelectedListener {
        C0556j() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.mo3200f(i);
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$l */
    public interface C0558l {
        boolean onClose();
    }

    /* renamed from: androidx.appcompat.widget.SearchView$m */
    public interface C0559m {
        /* renamed from: a */
        boolean mo3254a(String str);

        /* renamed from: b */
        boolean mo3255b(String str);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$n */
    public interface C0560n {
        /* renamed from: a */
        boolean mo3256a(int i);

        /* renamed from: b */
        boolean mo3257b(int i);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$o */
    private static class C0561o extends TouchDelegate {

        /* renamed from: a */
        private final View f1244a;

        /* renamed from: b */
        private final Rect f1245b = new Rect();

        /* renamed from: c */
        private final Rect f1246c = new Rect();

        /* renamed from: d */
        private final Rect f1247d = new Rect();

        /* renamed from: e */
        private final int f1248e;

        /* renamed from: f */
        private boolean f1249f;

        public C0561o(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1248e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            mo3258a(rect, rect2);
            this.f1244a = view;
        }

        /* renamed from: a */
        public void mo3258a(Rect rect, Rect rect2) {
            this.f1245b.set(rect);
            this.f1247d.set(rect);
            Rect rect3 = this.f1247d;
            int i = this.f1248e;
            rect3.inset(-i, -i);
            this.f1246c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0032
                if (r2 == r4) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003d
            L_0x001b:
                boolean r2 = r7.f1249f
                r7.f1249f = r5
                goto L_0x002f
            L_0x0020:
                boolean r2 = r7.f1249f
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r7.f1247d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r4 = r2
                r2 = 0
                goto L_0x003f
            L_0x002f:
                r4 = r2
            L_0x0030:
                r2 = 1
                goto L_0x003f
            L_0x0032:
                android.graphics.Rect r2 = r7.f1245b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003d
                r7.f1249f = r4
                goto L_0x0030
            L_0x003d:
                r2 = 1
                r4 = 0
            L_0x003f:
                if (r4 == 0) goto L_0x0072
                if (r2 == 0) goto L_0x005f
                android.graphics.Rect r2 = r7.f1246c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005f
                android.view.View r0 = r7.f1244a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.f1244a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                goto L_0x006c
            L_0x005f:
                android.graphics.Rect r2 = r7.f1246c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r8.setLocation(r0, r1)
            L_0x006c:
                android.view.View r0 = r7.f1244a
                boolean r5 = r0.dispatchTouchEvent(r8)
            L_0x0072:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.C0561o.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* renamed from: d */
    private void m1352d(boolean z) {
        this.f1219u.setVisibility((!this.f1195Q || !m1359t() || !hasFocus() || (!z && this.f1199V)) ? 8 : 0);
    }

    /* renamed from: e */
    private void m1353e(boolean z) {
        this.f1193O = z;
        int i = 0;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f1214p.getText());
        this.f1218t.setVisibility(i2);
        m1352d(z2);
        this.f1215q.setVisibility(z ? 8 : 0);
        if (this.f1182D.getDrawable() == null || this.f1192N) {
            i = 8;
        }
        this.f1182D.setVisibility(i);
        m1361v();
        m1354f(!z2);
        m1363x();
    }

    /* renamed from: f */
    private void m1354f(boolean z) {
        int i = 8;
        if (this.f1199V && !mo3207j() && z) {
            this.f1219u.setVisibility(8);
            i = 0;
        }
        this.f1221w.setVisibility(i);
    }

    /* renamed from: q */
    private void m1356q() {
        this.f1214p.dismissDropDown();
    }

    /* renamed from: r */
    private int m1357r() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    /* renamed from: s */
    private int m1358s() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    /* renamed from: t */
    private boolean m1359t() {
        return (this.f1195Q || this.f1199V) && !mo3207j();
    }

    /* renamed from: u */
    private void m1360u() {
        post(this.f1206f0);
    }

    /* renamed from: v */
    private void m1361v() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1214p.getText());
        int i = 0;
        if (!z2 && (!this.f1192N || this.f1202b0)) {
            z = false;
        }
        ImageView imageView = this.f1220v;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.f1220v.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    /* renamed from: w */
    private void m1362w() {
        CharSequence i = mo3205i();
        SearchAutoComplete searchAutoComplete = this.f1214p;
        if (i == null) {
            i = "";
        }
        searchAutoComplete.setHint(m1349b(i));
    }

    /* renamed from: x */
    private void m1363x() {
        this.f1217s.setVisibility((!m1359t() || !(this.f1219u.getVisibility() == 0 || this.f1221w.getVisibility() == 0)) ? 8 : 0);
    }

    /* renamed from: a */
    public void mo3194a(CharSequence charSequence, boolean z) {
        this.f1214p.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1214p;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f1201a0 = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            mo3210m();
        }
    }

    /* renamed from: b */
    public void mo3197b(boolean z) {
        if (z) {
            mo3208k();
        } else {
            mo3209l();
        }
    }

    /* renamed from: c */
    public void mo3198c(boolean z) {
        if (this.f1192N != z) {
            this.f1192N = z;
            m1353e(z);
            m1362w();
        }
    }

    public void clearFocus() {
        this.f1197S = true;
        super.clearFocus();
        this.f1214p.clearFocus();
        this.f1214p.mo3225a(false);
        this.f1197S = false;
    }

    /* renamed from: g */
    public void mo3202g(int i) {
        this.f1214p.setImeOptions(i);
    }

    /* renamed from: h */
    public void mo3204h(int i) {
        this.f1214p.setInputType(i);
    }

    /* renamed from: i */
    public CharSequence mo3205i() {
        CharSequence charSequence = this.f1196R;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f1204d0;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.f1186H;
        }
        return getContext().getText(this.f1204d0.getHintId());
    }

    /* renamed from: j */
    public boolean mo3207j() {
        return this.f1193O;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo3208k() {
        if (!TextUtils.isEmpty(this.f1214p.getText())) {
            this.f1214p.setText("");
            this.f1214p.requestFocus();
            this.f1214p.mo3225a(true);
        } else if (this.f1192N) {
            C0558l lVar = this.f1188J;
            if (lVar == null || !lVar.onClose()) {
                clearFocus();
                m1353e(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo3209l() {
        m1353e(false);
        this.f1214p.requestFocus();
        this.f1214p.mo3225a(true);
        View.OnClickListener onClickListener = this.f1191M;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo3210m() {
        Editable text = this.f1214p.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            C0559m mVar = this.f1187I;
            if (mVar == null || !mVar.mo3255b(text.toString())) {
                if (this.f1204d0 != null) {
                    mo3192a(0, (String) null, text.toString());
                }
                this.f1214p.mo3225a(false);
                m1356q();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo3211n() {
        m1353e(mo3207j());
        m1360u();
        if (this.f1214p.hasFocus()) {
            mo3203h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo3212o() {
        SearchableInfo searchableInfo = this.f1204d0;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(m1348b(this.f1184F, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(m1342a(this.f1185G, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f1206f0);
        post(this.f1207g0);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m1346a((View) this.f1214p, this.f1224z);
            Rect rect = this.f1179A;
            Rect rect2 = this.f1224z;
            rect.set(rect2.left, 0, rect2.right, i4 - i2);
            C0561o oVar = this.f1223y;
            if (oVar == null) {
                C0561o oVar2 = new C0561o(this.f1179A, this.f1224z, this.f1214p);
                this.f1223y = oVar2;
                setTouchDelegate(oVar2);
                return;
            }
            oVar.mo3258a(this.f1179A, this.f1224z);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        if (mo3207j()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.f1198U;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(m1358s(), size);
        } else if (mode == 0) {
            size = this.f1198U;
            if (size <= 0) {
                size = m1358s();
            }
        } else if (mode == 1073741824 && (i3 = this.f1198U) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(m1357r(), size2);
        } else if (mode2 == 0) {
            size2 = m1357r();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mo4406a());
        m1353e(savedState.f1225c);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1225c = mo3207j();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m1360u();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo3217p() {
        int[] iArr = this.f1214p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f1216r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1217s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1197S || !isFocusable()) {
            return false;
        }
        if (mo3207j()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1214p.requestFocus(i, rect);
        if (requestFocus) {
            m1353e(false);
        }
        return requestFocus;
    }

    /* renamed from: androidx.appcompat.widget.SearchView$k */
    private static class C0557k {

        /* renamed from: a */
        private Method f1241a;

        /* renamed from: b */
        private Method f1242b;

        /* renamed from: c */
        private Method f1243c;

        C0557k() {
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1241a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1242b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1243c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3250a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f1242b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo3252b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f1241a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo3251a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            Method method = this.f1243c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                }
            }
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.searchViewStyle);
    }

    /* renamed from: j */
    private void m1355j(int i) {
        Editable text = this.f1214p.getText();
        Cursor a = this.f1194P.mo18834a();
        if (a != null) {
            if (a.moveToPosition(i)) {
                CharSequence a2 = this.f1194P.mo18835a(a);
                if (a2 != null) {
                    m1351c(a2);
                } else {
                    m1351c((CharSequence) text);
                }
            } else {
                m1351c((CharSequence) text);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo3201g() {
        int i;
        if (this.f1222x.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1216r.getPaddingLeft();
            Rect rect = new Rect();
            boolean a = C0616m0.m1739a(this);
            int dimensionPixelSize = this.f1192N ? resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left) : 0;
            this.f1214p.getDropDownBackground().getPadding(rect);
            if (a) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.f1214p.setDropDownHorizontalOffset(i);
            this.f1214p.setDropDownWidth((((this.f1222x.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo3203h() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1214p.refreshAutoCompleteResults();
            return;
        }
        f1178n0.mo3252b(this.f1214p);
        f1178n0.mo3250a(this.f1214p);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1224z = new Rect();
        this.f1179A = new Rect();
        this.f1180B = new int[2];
        this.f1181C = new int[2];
        this.f1206f0 = new C0548b();
        this.f1207g0 = new C0549c();
        new WeakHashMap();
        this.f1208h0 = new C0552f();
        this.f1209i0 = new C0553g();
        this.f1210j0 = new C0554h();
        this.f1211k0 = new C0555i();
        this.f1212l0 = new C0556j();
        this.f1213m0 = new C0547a();
        C0598g0 a = C0598g0.m1610a(context, attributeSet, R$styleable.SearchView, i, 0);
        LayoutInflater.from(context).inflate(a.mo3446g(R$styleable.SearchView_layout, R$layout.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.search_src_text);
        this.f1214p = searchAutoComplete;
        searchAutoComplete.mo3224a(this);
        this.f1215q = findViewById(R$id.search_edit_frame);
        this.f1216r = findViewById(R$id.search_plate);
        this.f1217s = findViewById(R$id.submit_area);
        this.f1218t = (ImageView) findViewById(R$id.search_button);
        this.f1219u = (ImageView) findViewById(R$id.search_go_btn);
        this.f1220v = (ImageView) findViewById(R$id.search_close_btn);
        this.f1221w = (ImageView) findViewById(R$id.search_voice_btn);
        this.f1182D = (ImageView) findViewById(R$id.search_mag_icon);
        C0839t.m2696a(this.f1216r, a.mo3437b(R$styleable.SearchView_queryBackground));
        C0839t.m2696a(this.f1217s, a.mo3437b(R$styleable.SearchView_submitBackground));
        this.f1218t.setImageDrawable(a.mo3437b(R$styleable.SearchView_searchIcon));
        this.f1219u.setImageDrawable(a.mo3437b(R$styleable.SearchView_goIcon));
        this.f1220v.setImageDrawable(a.mo3437b(R$styleable.SearchView_closeIcon));
        this.f1221w.setImageDrawable(a.mo3437b(R$styleable.SearchView_voiceIcon));
        this.f1182D.setImageDrawable(a.mo3437b(R$styleable.SearchView_searchIcon));
        this.f1183E = a.mo3437b(R$styleable.SearchView_searchHintIcon);
        C0604i0.m1679a(this.f1218t, getResources().getString(R$string.abc_searchview_description_search));
        a.mo3446g(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        a.mo3446g(R$styleable.SearchView_commitIcon, 0);
        this.f1218t.setOnClickListener(this.f1208h0);
        this.f1220v.setOnClickListener(this.f1208h0);
        this.f1219u.setOnClickListener(this.f1208h0);
        this.f1221w.setOnClickListener(this.f1208h0);
        this.f1214p.setOnClickListener(this.f1208h0);
        this.f1214p.addTextChangedListener(this.f1213m0);
        this.f1214p.setOnEditorActionListener(this.f1210j0);
        this.f1214p.setOnItemClickListener(this.f1211k0);
        this.f1214p.setOnItemSelectedListener(this.f1212l0);
        this.f1214p.setOnKeyListener(this.f1209i0);
        this.f1214p.setOnFocusChangeListener(new C0550d());
        mo3198c(a.mo3435a(R$styleable.SearchView_iconifiedByDefault, true));
        int c = a.mo3438c(R$styleable.SearchView_android_maxWidth, -1);
        if (c != -1) {
            mo3206i(c);
        }
        this.f1186H = a.mo3443e(R$styleable.SearchView_defaultQueryHint);
        this.f1196R = a.mo3443e(R$styleable.SearchView_queryHint);
        int d = a.mo3440d(R$styleable.SearchView_android_imeOptions, -1);
        if (d != -1) {
            mo3202g(d);
        }
        int d2 = a.mo3440d(R$styleable.SearchView_android_inputType, -1);
        if (d2 != -1) {
            mo3204h(d2);
        }
        setFocusable(a.mo3435a(R$styleable.SearchView_android_focusable, true));
        a.mo3434a();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1184F = intent;
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        this.f1184F.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1185G = intent2;
        intent2.addFlags(DriveFile.MODE_READ_ONLY);
        View findViewById = findViewById(this.f1214p.getDropDownAnchor());
        this.f1222x = findViewById;
        if (findViewById != null) {
            findViewById.addOnLayoutChangeListener(new C0551e());
        }
        m1353e(this.f1192N);
        m1362w();
    }

    /* renamed from: b */
    private CharSequence m1349b(CharSequence charSequence) {
        if (!this.f1192N || this.f1183E == null) {
            return charSequence;
        }
        double textSize = (double) this.f1214p.getTextSize();
        Double.isNaN(textSize);
        int i = (int) (textSize * 1.25d);
        this.f1183E.setBounds(0, 0, i, i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1183E), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo3200f(int i) {
        C0560n nVar = this.f1190L;
        if (nVar != null && nVar.mo3256a(i)) {
            return false;
        }
        m1355j(i);
        return true;
    }

    /* renamed from: c */
    private void m1351c(CharSequence charSequence) {
        this.f1214p.setText(charSequence);
        this.f1214p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* renamed from: i */
    public void mo3206i(int i) {
        this.f1198U = i;
        requestLayout();
    }

    /* renamed from: a */
    private void m1346a(View view, Rect rect) {
        view.getLocationInWindow(this.f1180B);
        getLocationInWindow(this.f1181C);
        int[] iArr = this.f1180B;
        int i = iArr[1];
        int[] iArr2 = this.f1181C;
        int i2 = i - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    /* renamed from: b */
    public void mo2302b() {
        mo3194a((CharSequence) "", false);
        clearFocus();
        m1353e(true);
        this.f1214p.setImeOptions(this.f1203c0);
        this.f1202b0 = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3196a(View view, int i, KeyEvent keyEvent) {
        int i2;
        if (this.f1204d0 != null && this.f1194P != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return mo3195a(this.f1214p.getListSelection(), 0, (String) null);
            }
            if (i == 21 || i == 22) {
                if (i == 21) {
                    i2 = 0;
                } else {
                    i2 = this.f1214p.length();
                }
                this.f1214p.setSelection(i2);
                this.f1214p.setListSelection(0);
                this.f1214p.clearListSelection();
                f1178n0.mo3251a(this.f1214p, true);
                return true;
            } else if (i != 19 || this.f1214p.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    private boolean m1350b(int i, int i2, String str) {
        Cursor a = this.f1194P.mo18834a();
        if (a == null || !a.moveToPosition(i)) {
            return false;
        }
        m1345a(m1343a(a, i2, str));
        return true;
    }

    /* renamed from: b */
    private Intent m1348b(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", str);
        return intent2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3193a(CharSequence charSequence) {
        Editable text = this.f1214p.getText();
        this.f1201a0 = text;
        boolean z = !TextUtils.isEmpty(text);
        m1352d(z);
        m1354f(!z);
        m1361v();
        m1363x();
        if (this.f1187I != null && !TextUtils.equals(charSequence, this.f1200W)) {
            this.f1187I.mo3254a(charSequence.toString());
        }
        this.f1200W = charSequence.toString();
    }

    /* renamed from: a */
    public void mo2301a() {
        if (!this.f1202b0) {
            this.f1202b0 = true;
            int imeOptions = this.f1214p.getImeOptions();
            this.f1203c0 = imeOptions;
            this.f1214p.setImeOptions(imeOptions | 33554432);
            this.f1214p.setText("");
            mo3197b(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3195a(int i, int i2, String str) {
        C0560n nVar = this.f1190L;
        if (nVar != null && nVar.mo3257b(i)) {
            return false;
        }
        m1350b(i, 0, (String) null);
        this.f1214p.mo3225a(false);
        m1356q();
        return true;
    }

    /* renamed from: a */
    private void m1345a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                Log.e("SearchView", "Failed launch activity: " + intent, e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3192a(int i, String str, String str2) {
        getContext().startActivity(m1344a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* renamed from: a */
    private Intent m1344a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1201a0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f1205e0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1204d0.getSearchActivity());
        return intent;
    }

    /* renamed from: a */
    private Intent m1342a(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1205e0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: a */
    private Intent m1343a(Cursor cursor, int i, String str) {
        int i2;
        Uri uri;
        String a;
        try {
            String a2 = C0573a0.m1505a(cursor, "suggest_intent_action");
            if (a2 == null) {
                a2 = this.f1204d0.getSuggestIntentAction();
            }
            if (a2 == null) {
                a2 = "android.intent.action.SEARCH";
            }
            String str2 = a2;
            String a3 = C0573a0.m1505a(cursor, "suggest_intent_data");
            if (a3 == null) {
                a3 = this.f1204d0.getSuggestIntentData();
            }
            if (!(a3 == null || (a = C0573a0.m1505a(cursor, "suggest_intent_data_id")) == null)) {
                a3 = a3 + "/" + Uri.encode(a);
            }
            if (a3 == null) {
                uri = null;
            } else {
                uri = Uri.parse(a3);
            }
            return m1344a(str2, uri, C0573a0.m1505a(cursor, "suggest_intent_extra_data"), C0573a0.m1505a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i2 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e);
            return null;
        }
    }

    /* renamed from: a */
    static boolean m1347a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
