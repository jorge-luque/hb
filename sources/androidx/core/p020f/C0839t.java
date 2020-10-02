package androidx.core.p020f;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R$id;
import androidx.core.p020f.C0797a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: androidx.core.f.t */
/* compiled from: ViewCompat */
public class C0839t {

    /* renamed from: a */
    private static Field f2046a;

    /* renamed from: b */
    private static boolean f2047b;

    /* renamed from: c */
    private static Field f2048c;

    /* renamed from: d */
    private static boolean f2049d;

    /* renamed from: e */
    private static WeakHashMap<View, String> f2050e;

    /* renamed from: f */
    private static WeakHashMap<View, C0851x> f2051f = null;

    /* renamed from: g */
    private static Field f2052g;

    /* renamed from: h */
    private static boolean f2053h = false;

    /* renamed from: i */
    private static ThreadLocal<Rect> f2054i;

    /* renamed from: androidx.core.f.t$a */
    /* compiled from: ViewCompat */
    static class C0840a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a */
        final /* synthetic */ C0836q f2055a;

        C0840a(C0836q qVar) {
            this.f2055a = qVar;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return this.f2055a.mo2081a(view, C0803b0.m2537a(windowInsets)).mo4106f();
        }
    }

    /* renamed from: androidx.core.f.t$b */
    /* compiled from: ViewCompat */
    static class C0841b extends C0845f<Boolean> {
        C0841b(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Boolean m2739a(View view) {
            return Boolean.valueOf(view.isScreenReaderFocusable());
        }
    }

    /* renamed from: androidx.core.f.t$c */
    /* compiled from: ViewCompat */
    static class C0842c extends C0845f<CharSequence> {
        C0842c(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public CharSequence m2741a(View view) {
            return view.getAccessibilityPaneTitle();
        }
    }

    /* renamed from: androidx.core.f.t$d */
    /* compiled from: ViewCompat */
    static class C0843d extends C0845f<Boolean> {
        C0843d(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Boolean m2743a(View view) {
            return Boolean.valueOf(view.isAccessibilityHeading());
        }
    }

    /* renamed from: androidx.core.f.t$f */
    /* compiled from: ViewCompat */
    static abstract class C0845f<T> {

        /* renamed from: a */
        private final int f2057a;

        /* renamed from: b */
        private final Class<T> f2058b;

        /* renamed from: c */
        private final int f2059c;

        C0845f(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        /* renamed from: a */
        private boolean m2746a() {
            return Build.VERSION.SDK_INT >= 19;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract T mo4198a(View view);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public T mo4202b(View view) {
            if (m2747b()) {
                return mo4198a(view);
            }
            if (!m2746a()) {
                return null;
            }
            T tag = view.getTag(this.f2057a);
            if (this.f2058b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        C0845f(int i, Class<T> cls, int i2, int i3) {
            this.f2057a = i;
            this.f2058b = cls;
            this.f2059c = i3;
        }

        /* renamed from: b */
        private boolean m2747b() {
            return Build.VERSION.SDK_INT >= this.f2059c;
        }
    }

    /* renamed from: androidx.core.f.t$g */
    /* compiled from: ViewCompat */
    public interface C0846g {
        /* renamed from: a */
        boolean mo4203a(View view, KeyEvent keyEvent);
    }

    static {
        new AtomicInteger(1);
        new C0844e();
    }

    /* renamed from: A */
    public static void m2682A(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    /* renamed from: B */
    public static void m2683B(View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            view.requestApplyInsets();
        } else if (i >= 16) {
            view.requestFitSystemWindows();
        }
    }

    /* renamed from: C */
    public static void m2684C(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof C0830k) {
            ((C0830k) view).stopNestedScroll();
        }
    }

    /* renamed from: D */
    private static void m2685D(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* renamed from: a */
    public static void m2697a(View view, C0797a aVar) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (aVar == null && (m2707c(view) instanceof C0797a.C0798a)) {
            aVar = new C0797a();
        }
        if (aVar == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = aVar.mo4077a();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    /* renamed from: b */
    private static Rect m2703b() {
        if (f2054i == null) {
            f2054i = new ThreadLocal<>();
        }
        Rect rect = f2054i.get();
        if (rect == null) {
            rect = new Rect();
            f2054i.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* renamed from: c */
    private static View.AccessibilityDelegate m2707c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return m2710d(view);
    }

    /* renamed from: d */
    private static View.AccessibilityDelegate m2710d(View view) {
        if (f2053h) {
            return null;
        }
        if (f2052g == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f2052g = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f2053h = true;
                return null;
            }
        }
        try {
            Object obj = f2052g.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f2053h = true;
            return null;
        }
    }

    /* renamed from: e */
    public static int m2713e(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    /* renamed from: f */
    public static void m2716f(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            view.setImportantForAccessibility(i);
        } else if (i2 >= 16) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }
    }

    /* renamed from: g */
    public static void m2718g(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    /* renamed from: h */
    public static PorterDuff.Mode m2719h(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof C0838s) {
            return ((C0838s) view).mo2929f();
        }
        return null;
    }

    /* renamed from: i */
    public static Display m2720i(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (m2735x(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    /* renamed from: j */
    public static float m2721j(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    /* renamed from: k */
    public static boolean m2722k(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    /* renamed from: l */
    public static int m2723l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: m */
    public static int m2724m(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    /* renamed from: n */
    public static int m2725n(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    /* renamed from: o */
    public static int m2726o(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f2049d) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f2048c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2049d = true;
        }
        Field field = f2048c;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* renamed from: p */
    public static int m2727p(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f2047b) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f2046a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2047b = true;
        }
        Field field = f2046a;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    /* renamed from: q */
    public static ViewParent m2728q(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getParentForAccessibility();
        }
        return view.getParent();
    }

    /* renamed from: r */
    public static String m2729r(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f2050e;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    /* renamed from: s */
    public static int m2730s(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    /* renamed from: t */
    public static float m2731t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    /* renamed from: u */
    public static boolean m2732u(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    /* renamed from: v */
    public static boolean m2733v(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    /* renamed from: w */
    public static boolean m2734w(View view) {
        Boolean b = m2687a().mo4202b(view);
        if (b == null) {
            return false;
        }
        return b.booleanValue();
    }

    /* renamed from: x */
    public static boolean m2735x(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    /* renamed from: y */
    public static boolean m2736y(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* renamed from: z */
    public static boolean m2737z(View view) {
        Boolean b = m2711d().mo4202b(view);
        if (b == null) {
            return false;
        }
        return b.booleanValue();
    }

    /* renamed from: androidx.core.f.t$e */
    /* compiled from: ViewCompat */
    static class C0844e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a */
        private WeakHashMap<View, Boolean> f2056a = new WeakHashMap<>();

        C0844e() {
        }

        /* renamed from: a */
        private void m2745a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    C0839t.m2709c(view, 16);
                }
                this.f2056a.put(view, Boolean.valueOf(z2));
            }
        }

        public void onGlobalLayout() {
            for (Map.Entry next : this.f2056a.entrySet()) {
                m2745a((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
            }
        }

        public void onViewAttachedToWindow(View view) {
            m2744a(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }

        /* renamed from: a */
        private void m2744a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: androidx.core.f.t$h */
    /* compiled from: ViewCompat */
    static class C0847h {

        /* renamed from: d */
        private static final ArrayList<WeakReference<View>> f2060d = new ArrayList<>();

        /* renamed from: a */
        private WeakHashMap<View, Boolean> f2061a = null;

        /* renamed from: b */
        private SparseArray<WeakReference<View>> f2062b = null;

        /* renamed from: c */
        private WeakReference<KeyEvent> f2063c = null;

        C0847h() {
        }

        /* renamed from: a */
        private SparseArray<WeakReference<View>> m2751a() {
            if (this.f2062b == null) {
                this.f2062b = new SparseArray<>();
            }
            return this.f2062b;
        }

        /* renamed from: b */
        private View m2753b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f2061a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b = m2753b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b != null) {
                            return b;
                        }
                    }
                }
                if (m2755c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        /* renamed from: c */
        private boolean m2755c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((C0846g) arrayList.get(size)).mo4203a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        static C0847h m2752a(View view) {
            C0847h hVar = (C0847h) view.getTag(R$id.tag_unhandled_key_event_manager);
            if (hVar != null) {
                return hVar;
            }
            C0847h hVar2 = new C0847h();
            view.setTag(R$id.tag_unhandled_key_event_manager, hVar2);
            return hVar2;
        }

        /* renamed from: b */
        private void m2754b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f2061a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (!f2060d.isEmpty()) {
                synchronized (f2060d) {
                    if (this.f2061a == null) {
                        this.f2061a = new WeakHashMap<>();
                    }
                    for (int size = f2060d.size() - 1; size >= 0; size--) {
                        View view = (View) f2060d.get(size).get();
                        if (view == null) {
                            f2060d.remove(size);
                        } else {
                            this.f2061a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f2061a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo4205a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                m2754b();
            }
            View b = m2753b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b != null && !KeyEvent.isModifierKey(keyCode)) {
                    m2751a().put(keyCode, new WeakReference(b));
                }
            }
            return b != null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo4204a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f2063c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f2063c = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray<WeakReference<View>> a = m2751a();
            if (keyEvent.getAction() == 1 && (indexOfKey = a.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = a.valueAt(indexOfKey);
                a.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = a.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && C0839t.m2735x(view)) {
                m2755c(view, keyEvent);
            }
            return true;
        }
    }

    /* renamed from: e */
    public static void m2714e(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetTopAndBottom(i);
        } else if (i2 >= 21) {
            Rect b = m2703b();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m2705b(view, i);
            if (z && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b);
            }
        } else {
            m2705b(view, i);
        }
    }

    /* renamed from: g */
    public static ColorStateList m2717g(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof C0838s) {
            return ((C0838s) view).mo2927d();
        }
        return null;
    }

    /* renamed from: a */
    public static void m2692a(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        } else {
            view.postInvalidate(i, i2, i3, i4);
        }
    }

    /* renamed from: c */
    private static C0845f<CharSequence> m2708c() {
        return new C0842c(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    /* renamed from: f */
    public static CharSequence m2715f(View view) {
        return m2708c().mo4202b(view);
    }

    /* renamed from: c */
    static void m2709c(View view, int i) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = m2715f(view) != null;
            if (m2713e(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2699a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    /* renamed from: b */
    public static C0797a m2704b(View view) {
        View.AccessibilityDelegate c = m2707c(view);
        if (c == null) {
            return null;
        }
        if (c instanceof C0797a.C0798a) {
            return ((C0797a.C0798a) c).f2006a;
        }
        return new C0797a(c);
    }

    /* renamed from: a */
    public static void m2700a(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    /* renamed from: b */
    private static void m2705b(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            m2685D(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m2685D((View) parent);
            }
        }
    }

    /* renamed from: d */
    public static void m2712d(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetLeftAndRight(i);
        } else if (i2 >= 21) {
            Rect b = m2703b();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m2690a(view, i);
            if (z && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b);
            }
        } else {
            m2690a(view, i);
        }
    }

    /* renamed from: a */
    public static void m2694a(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    /* renamed from: a */
    public static C0851x m2688a(View view) {
        if (f2051f == null) {
            f2051f = new WeakHashMap<>();
        }
        C0851x xVar = f2051f.get(view);
        if (xVar != null) {
            return xVar;
        }
        C0851x xVar2 = new C0851x(view);
        f2051f.put(view, xVar2);
        return xVar2;
    }

    /* renamed from: b */
    static boolean m2706b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0847h.m2752a(view).mo4204a(keyEvent);
    }

    /* renamed from: a */
    public static void m2689a(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    /* renamed from: a */
    public static void m2701a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f2050e == null) {
            f2050e = new WeakHashMap<>();
        }
        f2050e.put(view, str);
    }

    /* renamed from: d */
    private static C0845f<Boolean> m2711d() {
        return new C0841b(R$id.tag_screen_reader_focusable, Boolean.class, 28);
    }

    /* renamed from: a */
    public static void m2698a(View view, C0836q qVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (qVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
        } else {
            view.setOnApplyWindowInsetsListener(new C0840a(qVar));
        }
    }

    /* renamed from: a */
    public static C0803b0 m2686a(View view, C0803b0 b0Var) {
        if (Build.VERSION.SDK_INT < 21) {
            return b0Var;
        }
        WindowInsets f = b0Var.mo4106f();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f);
        if (!onApplyWindowInsets.equals(f)) {
            f = new WindowInsets(onApplyWindowInsets);
        }
        return C0803b0.m2537a(f);
    }

    /* renamed from: a */
    public static void m2696a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: a */
    public static void m2693a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof C0838s) {
            ((C0838s) view).mo2925b(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m2695a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof C0838s) {
            ((C0838s) view).mo2926b(mode);
        }
    }

    /* renamed from: a */
    private static void m2690a(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            m2685D(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m2685D((View) parent);
            }
        }
    }

    /* renamed from: a */
    public static void m2691a(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* renamed from: a */
    static boolean m2702a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0847h.m2752a(view).mo4205a(view, keyEvent);
    }

    /* renamed from: a */
    private static C0845f<Boolean> m2687a() {
        return new C0843d(R$id.tag_accessibility_heading, Boolean.class, 28);
    }
}
