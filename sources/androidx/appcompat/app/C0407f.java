package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.p006a.p007a.C0383a;
import androidx.appcompat.p011d.C0455b;
import androidx.appcompat.p011d.C0458d;
import androidx.appcompat.p011d.C0460f;
import androidx.appcompat.p011d.C0462g;
import androidx.appcompat.p011d.C0467i;
import androidx.appcompat.view.menu.C0479e;
import androidx.appcompat.view.menu.C0482g;
import androidx.appcompat.view.menu.C0497m;
import androidx.appcompat.view.menu.C0499n;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0596g;
import androidx.appcompat.widget.C0598g0;
import androidx.appcompat.widget.C0612l0;
import androidx.appcompat.widget.C0616m0;
import androidx.appcompat.widget.C0619o;
import androidx.appcompat.widget.C0625s;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.core.app.C0696a;
import androidx.core.app.C0723g;
import androidx.core.p020f.C0803b0;
import androidx.core.p020f.C0822d;
import androidx.core.p020f.C0824e;
import androidx.core.p020f.C0836q;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.C0851x;
import androidx.core.p020f.C0855y;
import androidx.core.p020f.C0856z;
import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0970h;
import com.ogury.p159cm.OguryChoiceManager;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import p075d.p080b.C3191a;

/* renamed from: androidx.appcompat.app.f */
/* compiled from: AppCompatDelegateImpl */
class C0407f extends C0406e implements C0482g.C0483a, LayoutInflater.Factory2 {

    /* renamed from: b0 */
    private static final Map<Class<?>, Integer> f415b0 = new C3191a();

    /* renamed from: c0 */
    private static final boolean f416c0 = (Build.VERSION.SDK_INT < 21);

    /* renamed from: d0 */
    private static final int[] f417d0 = {16842836};

    /* renamed from: e0 */
    private static boolean f418e0 = true;

    /* renamed from: f0 */
    private static final boolean f419f0;

    /* renamed from: A */
    boolean f420A;

    /* renamed from: B */
    boolean f421B;

    /* renamed from: C */
    boolean f422C;

    /* renamed from: D */
    boolean f423D;

    /* renamed from: E */
    boolean f424E;

    /* renamed from: F */
    private boolean f425F;

    /* renamed from: G */
    private C0425o[] f426G;

    /* renamed from: H */
    private C0425o f427H;

    /* renamed from: I */
    private boolean f428I;

    /* renamed from: J */
    private boolean f429J;

    /* renamed from: K */
    private boolean f430K;

    /* renamed from: L */
    private boolean f431L;

    /* renamed from: M */
    boolean f432M;

    /* renamed from: N */
    private int f433N;

    /* renamed from: O */
    private int f434O;

    /* renamed from: P */
    private boolean f435P;

    /* renamed from: Q */
    private boolean f436Q;

    /* renamed from: R */
    private C0421l f437R;

    /* renamed from: S */
    private C0421l f438S;

    /* renamed from: U */
    boolean f439U;

    /* renamed from: V */
    int f440V;

    /* renamed from: W */
    private final Runnable f441W;

    /* renamed from: X */
    private boolean f442X;

    /* renamed from: Y */
    private Rect f443Y;

    /* renamed from: Z */
    private Rect f444Z;

    /* renamed from: a0 */
    private AppCompatViewInflater f445a0;

    /* renamed from: d */
    final Object f446d;

    /* renamed from: e */
    final Context f447e;

    /* renamed from: f */
    Window f448f;

    /* renamed from: g */
    private C0419j f449g;

    /* renamed from: h */
    final C0405d f450h;

    /* renamed from: i */
    C0399a f451i;

    /* renamed from: j */
    MenuInflater f452j;

    /* renamed from: k */
    private CharSequence f453k;

    /* renamed from: l */
    private C0619o f454l;

    /* renamed from: m */
    private C0416h f455m;

    /* renamed from: n */
    private C0426p f456n;

    /* renamed from: o */
    C0455b f457o;

    /* renamed from: p */
    ActionBarContextView f458p;

    /* renamed from: q */
    PopupWindow f459q;

    /* renamed from: r */
    Runnable f460r;

    /* renamed from: s */
    C0851x f461s;

    /* renamed from: t */
    private boolean f462t;

    /* renamed from: u */
    private boolean f463u;

    /* renamed from: v */
    private ViewGroup f464v;

    /* renamed from: w */
    private TextView f465w;

    /* renamed from: x */
    private View f466x;

    /* renamed from: y */
    private boolean f467y;

    /* renamed from: z */
    private boolean f468z;

    /* renamed from: androidx.appcompat.app.f$a */
    /* compiled from: AppCompatDelegateImpl */
    static class C0408a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a */
        final /* synthetic */ Thread.UncaughtExceptionHandler f469a;

        C0408a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f469a = uncaughtExceptionHandler;
        }

        /* renamed from: a */
        private boolean m531a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            if (message.contains("drawable") || message.contains("Drawable")) {
                return true;
            }
            return false;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            if (m531a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f469a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f469a.uncaughtException(thread, th);
        }
    }

    /* renamed from: androidx.appcompat.app.f$b */
    /* compiled from: AppCompatDelegateImpl */
    class C0409b implements Runnable {
        C0409b() {
        }

        public void run() {
            C0407f fVar = C0407f.this;
            if ((fVar.f440V & 1) != 0) {
                fVar.mo2061f(0);
            }
            C0407f fVar2 = C0407f.this;
            if ((fVar2.f440V & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0) {
                fVar2.mo2061f(108);
            }
            C0407f fVar3 = C0407f.this;
            fVar3.f439U = false;
            fVar3.f440V = 0;
        }
    }

    /* renamed from: androidx.appcompat.app.f$c */
    /* compiled from: AppCompatDelegateImpl */
    class C0410c implements C0836q {
        C0410c() {
        }

        /* renamed from: a */
        public C0803b0 mo2081a(View view, C0803b0 b0Var) {
            int d = b0Var.mo4103d();
            int j = C0407f.this.mo2065j(d);
            if (d != j) {
                b0Var = b0Var.mo4100a(b0Var.mo4101b(), j, b0Var.mo4102c(), b0Var.mo4099a());
            }
            return C0839t.m2686a(view, b0Var);
        }
    }

    /* renamed from: androidx.appcompat.app.f$d */
    /* compiled from: AppCompatDelegateImpl */
    class C0411d implements C0625s.C0626a {
        C0411d() {
        }

        /* renamed from: a */
        public void mo2082a(Rect rect) {
            rect.top = C0407f.this.mo2065j(rect.top);
        }
    }

    /* renamed from: androidx.appcompat.app.f$e */
    /* compiled from: AppCompatDelegateImpl */
    class C0412e implements ContentFrameLayout.C0536a {
        C0412e() {
        }

        /* renamed from: a */
        public void mo2083a() {
        }

        public void onDetachedFromWindow() {
            C0407f.this.mo2067l();
        }
    }

    /* renamed from: androidx.appcompat.app.f$f */
    /* compiled from: AppCompatDelegateImpl */
    class C0413f implements Runnable {

        /* renamed from: androidx.appcompat.app.f$f$a */
        /* compiled from: AppCompatDelegateImpl */
        class C0414a extends C0856z {
            C0414a() {
            }

            /* renamed from: b */
            public void mo2086b(View view) {
                C0407f.this.f458p.setAlpha(1.0f);
                C0407f.this.f461s.mo4210a((C0855y) null);
                C0407f.this.f461s = null;
            }

            /* renamed from: c */
            public void mo2087c(View view) {
                C0407f.this.f458p.setVisibility(0);
            }
        }

        C0413f() {
        }

        public void run() {
            C0407f fVar = C0407f.this;
            fVar.f459q.showAtLocation(fVar.f458p, 55, 0, 0);
            C0407f.this.mo2068m();
            if (C0407f.this.mo2078u()) {
                C0407f.this.f458p.setAlpha(0.0f);
                C0407f fVar2 = C0407f.this;
                C0851x a = C0839t.m2688a(fVar2.f458p);
                a.mo4206a(1.0f);
                fVar2.f461s = a;
                C0407f.this.f461s.mo4210a((C0855y) new C0414a());
                return;
            }
            C0407f.this.f458p.setAlpha(1.0f);
            C0407f.this.f458p.setVisibility(0);
        }
    }

    /* renamed from: androidx.appcompat.app.f$g */
    /* compiled from: AppCompatDelegateImpl */
    class C0415g extends C0856z {
        C0415g() {
        }

        /* renamed from: b */
        public void mo2086b(View view) {
            C0407f.this.f458p.setAlpha(1.0f);
            C0407f.this.f461s.mo4210a((C0855y) null);
            C0407f.this.f461s = null;
        }

        /* renamed from: c */
        public void mo2087c(View view) {
            C0407f.this.f458p.setVisibility(0);
            C0407f.this.f458p.sendAccessibilityEvent(32);
            if (C0407f.this.f458p.getParent() instanceof View) {
                C0839t.m2683B((View) C0407f.this.f458p.getParent());
            }
        }
    }

    /* renamed from: androidx.appcompat.app.f$i */
    /* compiled from: AppCompatDelegateImpl */
    class C0417i implements C0455b.C0456a {

        /* renamed from: a */
        private C0455b.C0456a f478a;

        /* renamed from: androidx.appcompat.app.f$i$a */
        /* compiled from: AppCompatDelegateImpl */
        class C0418a extends C0856z {
            C0418a() {
            }

            /* renamed from: b */
            public void mo2086b(View view) {
                C0407f.this.f458p.setVisibility(8);
                C0407f fVar = C0407f.this;
                PopupWindow popupWindow = fVar.f459q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (fVar.f458p.getParent() instanceof View) {
                    C0839t.m2683B((View) C0407f.this.f458p.getParent());
                }
                C0407f.this.f458p.removeAllViews();
                C0407f.this.f461s.mo4210a((C0855y) null);
                C0407f.this.f461s = null;
            }
        }

        public C0417i(C0455b.C0456a aVar) {
            this.f478a = aVar;
        }

        /* renamed from: a */
        public boolean mo2091a(C0455b bVar, Menu menu) {
            return this.f478a.mo2091a(bVar, menu);
        }

        /* renamed from: b */
        public boolean mo2093b(C0455b bVar, Menu menu) {
            return this.f478a.mo2093b(bVar, menu);
        }

        /* renamed from: a */
        public boolean mo2092a(C0455b bVar, MenuItem menuItem) {
            return this.f478a.mo2092a(bVar, menuItem);
        }

        /* renamed from: a */
        public void mo2090a(C0455b bVar) {
            this.f478a.mo2090a(bVar);
            C0407f fVar = C0407f.this;
            if (fVar.f459q != null) {
                fVar.f448f.getDecorView().removeCallbacks(C0407f.this.f460r);
            }
            C0407f fVar2 = C0407f.this;
            if (fVar2.f458p != null) {
                fVar2.mo2068m();
                C0407f fVar3 = C0407f.this;
                C0851x a = C0839t.m2688a(fVar3.f458p);
                a.mo4206a(0.0f);
                fVar3.f461s = a;
                C0407f.this.f461s.mo4210a((C0855y) new C0418a());
            }
            C0407f fVar4 = C0407f.this;
            C0405d dVar = fVar4.f450h;
            if (dVar != null) {
                dVar.mo1993b(fVar4.f457o);
            }
            C0407f.this.f457o = null;
        }
    }

    /* renamed from: androidx.appcompat.app.f$k */
    /* compiled from: AppCompatDelegateImpl */
    private class C0420k extends C0421l {

        /* renamed from: c */
        private final PowerManager f482c;

        C0420k(Context context) {
            super();
            this.f482c = (PowerManager) context.getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public IntentFilter mo2105b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        /* renamed from: c */
        public int mo2106c() {
            if (Build.VERSION.SDK_INT < 21 || !this.f482c.isPowerSaveMode()) {
                return 1;
            }
            return 2;
        }

        /* renamed from: d */
        public void mo2107d() {
            C0407f.this.mo2066k();
        }
    }

    /* renamed from: androidx.appcompat.app.f$l */
    /* compiled from: AppCompatDelegateImpl */
    abstract class C0421l {

        /* renamed from: a */
        private BroadcastReceiver f484a;

        /* renamed from: androidx.appcompat.app.f$l$a */
        /* compiled from: AppCompatDelegateImpl */
        class C0422a extends BroadcastReceiver {
            C0422a() {
            }

            public void onReceive(Context context, Intent intent) {
                C0421l.this.mo2107d();
            }
        }

        C0421l() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo2108a() {
            BroadcastReceiver broadcastReceiver = this.f484a;
            if (broadcastReceiver != null) {
                try {
                    C0407f.this.f447e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f484a = null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract IntentFilter mo2105b();

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract int mo2106c();

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract void mo2107d();

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo2109e() {
            mo2108a();
            IntentFilter b = mo2105b();
            if (b != null && b.countActions() != 0) {
                if (this.f484a == null) {
                    this.f484a = new C0422a();
                }
                C0407f.this.f447e.registerReceiver(this.f484a, b);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.f$m */
    /* compiled from: AppCompatDelegateImpl */
    private class C0423m extends C0421l {

        /* renamed from: c */
        private final C0431j f487c;

        C0423m(C0431j jVar) {
            super();
            this.f487c = jVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public IntentFilter mo2105b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* renamed from: c */
        public int mo2106c() {
            return this.f487c.mo2132a() ? 2 : 1;
        }

        /* renamed from: d */
        public void mo2107d() {
            C0407f.this.mo2066k();
        }
    }

    /* renamed from: androidx.appcompat.app.f$n */
    /* compiled from: AppCompatDelegateImpl */
    private class C0424n extends ContentFrameLayout {
        public C0424n(Context context) {
            super(context);
        }

        /* renamed from: a */
        private boolean m558a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return C0407f.this.mo2054a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m558a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            C0407f.this.mo2060e(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0383a.m323c(getContext(), i));
        }
    }

    static {
        boolean z = false;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21 && i <= 25) {
            z = true;
        }
        f419f0 = z;
        if (f416c0 && !f418e0) {
            Thread.setDefaultUncaughtExceptionHandler(new C0408a(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    C0407f(Activity activity, C0405d dVar) {
        this(activity, (Window) null, dVar, activity);
    }

    /* renamed from: A */
    private void m450A() {
        if (this.f448f == null) {
            Object obj = this.f446d;
            if (obj instanceof Activity) {
                m456a(((Activity) obj).getWindow());
            }
        }
        if (this.f448f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    /* renamed from: B */
    private C0421l m451B() {
        if (this.f438S == null) {
            this.f438S = new C0420k(this.f447e);
        }
        return this.f438S;
    }

    /* renamed from: C */
    private void m452C() {
        m476z();
        if (this.f420A && this.f451i == null) {
            Object obj = this.f446d;
            if (obj instanceof Activity) {
                this.f451i = new C0433k((Activity) this.f446d, this.f421B);
            } else if (obj instanceof Dialog) {
                this.f451i = new C0433k((Dialog) this.f446d);
            }
            C0399a aVar = this.f451i;
            if (aVar != null) {
                aVar.mo1961c(this.f442X);
            }
        }
    }

    /* renamed from: D */
    private boolean m453D() {
        if (!this.f436Q && (this.f446d instanceof Activity)) {
            PackageManager packageManager = this.f447e.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f447e, this.f446d.getClass()), 0);
                this.f435P = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused) {
                this.f435P = false;
            }
        }
        this.f436Q = true;
        return this.f435P;
    }

    /* renamed from: E */
    private void m454E() {
        if (this.f463u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: F */
    private C0404c m455F() {
        Context context = this.f447e;
        while (context != null) {
            if (!(context instanceof C0404c)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (C0404c) context;
            }
        }
        return null;
    }

    /* renamed from: k */
    private void m470k(int i) {
        this.f440V = (1 << i) | this.f440V;
        if (!this.f439U) {
            C0839t.m2699a(this.f448f.getDecorView(), this.f441W);
            this.f439U = true;
        }
    }

    /* renamed from: l */
    private int m471l(int i) {
        if (i == 8) {
            return 108;
        }
        if (i == 9) {
            return 109;
        }
        return i;
    }

    /* renamed from: v */
    private void m472v() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f464v.findViewById(16908290);
        View decorView = this.f448f.getDecorView();
        contentFrameLayout.mo3115a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f447e.obtainStyledAttributes(R$styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.mo3121e());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.mo3122f());
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.mo3119c());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.mo3120d());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.mo3114a());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.mo3118b());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* renamed from: w */
    private int m473w() {
        int i = this.f433N;
        return i != -100 ? i : C0406e.m427j();
    }

    /* renamed from: x */
    private void m474x() {
        C0421l lVar = this.f437R;
        if (lVar != null) {
            lVar.mo2108a();
        }
        C0421l lVar2 = this.f438S;
        if (lVar2 != null) {
            lVar2.mo2108a();
        }
    }

    /* renamed from: y */
    private ViewGroup m475y() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f447e.obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
                mo2034b(1);
            } else if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
                mo2034b(108);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                mo2034b(109);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                mo2034b(10);
            }
            this.f423D = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            m450A();
            this.f448f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f447e);
            if (this.f424E) {
                if (this.f422C) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    C0839t.m2698a((View) viewGroup, (C0836q) new C0410c());
                } else {
                    ((C0625s) viewGroup).mo3126a(new C0411d());
                }
            } else if (this.f423D) {
                viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
                this.f421B = false;
                this.f420A = false;
            } else if (this.f420A) {
                TypedValue typedValue = new TypedValue();
                this.f447e.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new C0458d(this.f447e, typedValue.resourceId);
                } else {
                    context = this.f447e;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
                C0619o oVar = (C0619o) viewGroup.findViewById(R$id.decor_content_parent);
                this.f454l = oVar;
                oVar.mo2818a(mo2074q());
                if (this.f421B) {
                    this.f454l.mo2812a(109);
                }
                if (this.f467y) {
                    this.f454l.mo2812a(2);
                }
                if (this.f468z) {
                    this.f454l.mo2812a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.f454l == null) {
                    this.f465w = (TextView) viewGroup.findViewById(R$id.title);
                }
                C0616m0.m1740b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f448f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f448f.setContentView(viewGroup);
                contentFrameLayout.mo3117a((ContentFrameLayout.C0536a) new C0412e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f420A + ", windowActionBarOverlay: " + this.f421B + ", android:windowIsFloating: " + this.f423D + ", windowActionModeOverlay: " + this.f422C + ", windowNoTitle: " + this.f424E + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* renamed from: z */
    private void m476z() {
        if (!this.f463u) {
            this.f464v = m475y();
            CharSequence p = mo2073p();
            if (!TextUtils.isEmpty(p)) {
                C0619o oVar = this.f454l;
                if (oVar != null) {
                    oVar.mo2820a(p);
                } else if (mo2077t() != null) {
                    mo2077t().mo1957a(p);
                } else {
                    TextView textView = this.f465w;
                    if (textView != null) {
                        textView.setText(p);
                    }
                }
            }
            m472v();
            mo2050a(this.f464v);
            this.f463u = true;
            C0425o a = mo2046a(0, false);
            if (this.f432M) {
                return;
            }
            if (a == null || a.f499j == null) {
                m470k(108);
            }
        }
    }

    /* renamed from: a */
    public void mo2025a(Context context) {
        m462a(false);
        this.f429J = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2050a(ViewGroup viewGroup) {
    }

    /* renamed from: b */
    public void mo2032b(Bundle bundle) {
        m476z();
    }

    /* renamed from: c */
    public C0399a mo2035c() {
        m452C();
        return this.f451i;
    }

    /* renamed from: d */
    public void mo2039d(int i) {
        this.f434O = i;
    }

    /* renamed from: e */
    public void mo2040e() {
        C0399a c = mo2035c();
        if (c == null || !c.mo1967i()) {
            m470k(0);
        }
    }

    /* renamed from: f */
    public void mo2041f() {
        C0406e.m425b((C0406e) this);
        if (this.f439U) {
            this.f448f.getDecorView().removeCallbacks(this.f441W);
        }
        this.f431L = false;
        this.f432M = true;
        C0399a aVar = this.f451i;
        if (aVar != null) {
            aVar.mo1968j();
        }
        m474x();
    }

    /* renamed from: g */
    public void mo2042g() {
        C0399a c = mo2035c();
        if (c != null) {
            c.mo1962d(true);
        }
    }

    /* renamed from: h */
    public void mo2043h() {
        this.f431L = true;
        mo2066k();
        C0406e.m424a((C0406e) this);
    }

    /* renamed from: i */
    public void mo2044i() {
        this.f431L = false;
        C0406e.m425b((C0406e) this);
        C0399a c = mo2035c();
        if (c != null) {
            c.mo1962d(false);
        }
        if (this.f446d instanceof Dialog) {
            m474x();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo2065j(int i) {
        boolean z;
        boolean z2;
        ActionBarContextView actionBarContextView = this.f458p;
        int i2 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f458p.getLayoutParams();
            boolean z3 = true;
            if (this.f458p.isShown()) {
                if (this.f443Y == null) {
                    this.f443Y = new Rect();
                    this.f444Z = new Rect();
                }
                Rect rect = this.f443Y;
                Rect rect2 = this.f444Z;
                rect.set(0, i, 0, 0);
                C0616m0.m1738a(this.f464v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    View view = this.f466x;
                    if (view == null) {
                        View view2 = new View(this.f447e);
                        this.f466x = view2;
                        view2.setBackgroundColor(this.f447e.getResources().getColor(R$color.abc_input_method_navigation_guard));
                        this.f464v.addView(this.f466x, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f466x.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.f466x == null) {
                    z3 = false;
                }
                if (!this.f422C && z3) {
                    i = 0;
                }
                boolean z4 = z3;
                z3 = z2;
                z = z4;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z3 = false;
            }
            if (z3) {
                this.f458p.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.f466x;
        if (view3 != null) {
            if (!z) {
                i2 = 8;
            }
            view3.setVisibility(i2);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo2067l() {
        C0482g gVar;
        C0619o oVar = this.f454l;
        if (oVar != null) {
            oVar.mo2837g();
        }
        if (this.f459q != null) {
            this.f448f.getDecorView().removeCallbacks(this.f460r);
            if (this.f459q.isShowing()) {
                try {
                    this.f459q.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f459q = null;
        }
        mo2068m();
        C0425o a = mo2046a(0, false);
        if (a != null && (gVar = a.f499j) != null) {
            gVar.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo2068m() {
        C0851x xVar = this.f461s;
        if (xVar != null) {
            xVar.mo4211a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final Context mo2069n() {
        C0399a c = mo2035c();
        Context h = c != null ? c.mo1966h() : null;
        return h == null ? this.f447e : h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final C0421l mo2070o() {
        if (this.f437R == null) {
            this.f437R = new C0423m(C0431j.m580a(this.f447e));
        }
        return this.f437R;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return mo2045a(view, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final CharSequence mo2073p() {
        Object obj = this.f446d;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f453k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public final Window.Callback mo2074q() {
        return this.f448f.getCallback();
    }

    /* renamed from: r */
    public boolean mo2075r() {
        return this.f462t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean mo2076s() {
        C0455b bVar = this.f457o;
        if (bVar != null) {
            bVar.mo2150a();
            return true;
        }
        C0399a c = mo2035c();
        if (c == null || !c.mo1964f()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public final C0399a mo2077t() {
        return this.f451i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f464v;
     */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo2078u() {
        /*
            r1 = this;
            boolean r0 = r1.f463u
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.f464v
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.p020f.C0839t.m2736y(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0407f.mo2078u():boolean");
    }

    /* renamed from: androidx.appcompat.app.f$h */
    /* compiled from: AppCompatDelegateImpl */
    private final class C0416h implements C0497m.C0498a {
        C0416h() {
        }

        /* renamed from: a */
        public boolean mo2089a(C0482g gVar) {
            Window.Callback q = C0407f.this.mo2074q();
            if (q == null) {
                return true;
            }
            q.onMenuOpened(108, gVar);
            return true;
        }

        /* renamed from: a */
        public void mo2088a(C0482g gVar, boolean z) {
            C0407f.this.mo2057b(gVar);
        }
    }

    C0407f(Dialog dialog, C0405d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    /* renamed from: b */
    public MenuInflater mo2031b() {
        if (this.f452j == null) {
            m452C();
            C0399a aVar = this.f451i;
            this.f452j = new C0462g(aVar != null ? aVar.mo1966h() : this.f447e);
        }
        return this.f452j;
    }

    /* renamed from: d */
    public void mo2038d() {
        LayoutInflater from = LayoutInflater.from(this.f447e);
        if (from.getFactory() == null) {
            C0824e.m2633b(from, this);
        } else {
            boolean z = from.getFactory2() instanceof C0407f;
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    /* renamed from: androidx.appcompat.app.f$o */
    /* compiled from: AppCompatDelegateImpl */
    protected static final class C0425o {

        /* renamed from: a */
        int f490a;

        /* renamed from: b */
        int f491b;

        /* renamed from: c */
        int f492c;

        /* renamed from: d */
        int f493d;

        /* renamed from: e */
        int f494e;

        /* renamed from: f */
        int f495f;

        /* renamed from: g */
        ViewGroup f496g;

        /* renamed from: h */
        View f497h;

        /* renamed from: i */
        View f498i;

        /* renamed from: j */
        C0482g f499j;

        /* renamed from: k */
        C0479e f500k;

        /* renamed from: l */
        Context f501l;

        /* renamed from: m */
        boolean f502m;

        /* renamed from: n */
        boolean f503n;

        /* renamed from: o */
        boolean f504o;

        /* renamed from: p */
        public boolean f505p;

        /* renamed from: q */
        boolean f506q = false;

        /* renamed from: r */
        boolean f507r;

        /* renamed from: s */
        Bundle f508s;

        C0425o(int i) {
            this.f490a = i;
        }

        /* renamed from: a */
        public boolean mo2117a() {
            if (this.f497h == null) {
                return false;
            }
            if (this.f498i == null && this.f500k.mo2495a().getCount() <= 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo2115a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            } else {
                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            C0458d dVar = new C0458d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f501l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f491b = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f495f = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo2116a(C0482g gVar) {
            C0479e eVar;
            C0482g gVar2 = this.f499j;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.mo2543b((C0497m) this.f500k);
                }
                this.f499j = gVar;
                if (gVar != null && (eVar = this.f500k) != null) {
                    gVar.mo2523a((C0497m) eVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0499n mo2114a(C0497m.C0498a aVar) {
            if (this.f499j == null) {
                return null;
            }
            if (this.f500k == null) {
                C0479e eVar = new C0479e(this.f501l, R$layout.abc_list_menu_item_layout);
                this.f500k = eVar;
                eVar.mo2459a(aVar);
                this.f499j.mo2523a((C0497m) this.f500k);
            }
            return this.f500k.mo2496a(this.f496g);
        }
    }

    private C0407f(Context context, Window window, C0405d dVar, Object obj) {
        Integer num;
        C0404c F;
        this.f461s = null;
        this.f462t = true;
        this.f433N = -100;
        this.f441W = new C0409b();
        this.f447e = context;
        this.f450h = dVar;
        this.f446d = obj;
        if (this.f433N == -100 && (obj instanceof Dialog) && (F = m455F()) != null) {
            this.f433N = F.mo1992b().mo2023a();
        }
        if (this.f433N == -100 && (num = f415b0.get(this.f446d.getClass())) != null) {
            this.f433N = num.intValue();
            f415b0.remove(this.f446d.getClass());
        }
        if (window != null) {
            m456a(window);
        }
        C0596g.m1591c();
    }

    /* renamed from: a */
    public void mo2027a(Bundle bundle) {
        this.f429J = true;
        m462a(false);
        m450A();
        Object obj = this.f446d;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = C0723g.m2237b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                C0399a t = mo2077t();
                if (t == null) {
                    this.f442X = true;
                } else {
                    t.mo1961c(true);
                }
            }
        }
        this.f430K = true;
    }

    /* renamed from: c */
    public void mo2036c(int i) {
        m476z();
        ViewGroup viewGroup = (ViewGroup) this.f464v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f447e).inflate(i, viewGroup);
        this.f449g.mo2347a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo2062g(int i) {
        if (i == -100) {
            return -1;
        }
        if (i == -1) {
            return i;
        }
        if (i != 0) {
            if (i == 1 || i == 2) {
                return i;
            }
            if (i == 3) {
                return m451B().mo2106c();
            }
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.f447e.getSystemService(UiModeManager.class)).getNightMode() != 0) {
            return mo2070o().mo2106c();
        } else {
            return -1;
        }
    }

    /* renamed from: androidx.appcompat.app.f$j */
    /* compiled from: AppCompatDelegateImpl */
    class C0419j extends C0467i {
        C0419j(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final ActionMode mo2094a(ActionMode.Callback callback) {
            C0460f.C0461a aVar = new C0460f.C0461a(C0407f.this.f447e, callback);
            C0455b a = C0407f.this.mo2048a((C0455b.C0456a) aVar);
            if (a != null) {
                return aVar.mo2328b(a);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return C0407f.this.mo2054a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || C0407f.this.mo2058b(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C0482g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            C0407f.this.mo2063h(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            C0407f.this.mo2064i(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0482g gVar = menu instanceof C0482g ? (C0482g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.mo2549c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.mo2549c(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            C0482g gVar;
            C0425o a = C0407f.this.mo2046a(0, true);
            if (a == null || (gVar = a.f499j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (C0407f.this.mo2075r()) {
                return mo2094a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!C0407f.this.mo2075r() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return mo2094a(callback);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo2060e(int i) {
        mo2051a(mo2046a(i, true), true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo2063h(int i) {
        C0399a c;
        if (i == 108 && (c = mo2035c()) != null) {
            c.mo1960b(true);
        }
    }

    /* renamed from: androidx.appcompat.app.f$p */
    /* compiled from: AppCompatDelegateImpl */
    private final class C0426p implements C0497m.C0498a {
        C0426p() {
        }

        /* renamed from: a */
        public void mo2088a(C0482g gVar, boolean z) {
            C0482g m = gVar.mo2569m();
            boolean z2 = m != gVar;
            C0407f fVar = C0407f.this;
            if (z2) {
                gVar = m;
            }
            C0425o a = fVar.mo2047a((Menu) gVar);
            if (a == null) {
                return;
            }
            if (z2) {
                C0407f.this.mo2049a(a.f490a, a, m);
                C0407f.this.mo2051a(a, true);
                return;
            }
            C0407f.this.mo2051a(a, z);
        }

        /* renamed from: a */
        public boolean mo2089a(C0482g gVar) {
            Window.Callback q;
            if (gVar != null) {
                return true;
            }
            C0407f fVar = C0407f.this;
            if (!fVar.f420A || (q = fVar.mo2074q()) == null || C0407f.this.f432M) {
                return true;
            }
            q.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m469e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.d.b r0 = r3.f457o
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.f$o r2 = r3.mo2046a((int) r4, (boolean) r0)
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.o r4 = r3.f454l
            if (r4 == 0) goto L_0x0043
            boolean r4 = r4.mo2829c()
            if (r4 == 0) goto L_0x0043
            android.content.Context r4 = r3.f447e
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.o r4 = r3.f454l
            boolean r4 = r4.mo2822a()
            if (r4 != 0) goto L_0x003c
            boolean r4 = r3.f432M
            if (r4 != 0) goto L_0x0062
            boolean r4 = r3.m465b((androidx.appcompat.app.C0407f.C0425o) r2, (android.view.KeyEvent) r5)
            if (r4 == 0) goto L_0x0062
            androidx.appcompat.widget.o r4 = r3.f454l
            boolean r0 = r4.mo2835f()
            goto L_0x006a
        L_0x003c:
            androidx.appcompat.widget.o r4 = r3.f454l
            boolean r0 = r4.mo2834e()
            goto L_0x006a
        L_0x0043:
            boolean r4 = r2.f504o
            if (r4 != 0) goto L_0x0064
            boolean r4 = r2.f503n
            if (r4 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r4 = r2.f502m
            if (r4 == 0) goto L_0x0062
            boolean r4 = r2.f507r
            if (r4 == 0) goto L_0x005b
            r2.f502m = r1
            boolean r4 = r3.m465b((androidx.appcompat.app.C0407f.C0425o) r2, (android.view.KeyEvent) r5)
            goto L_0x005c
        L_0x005b:
            r4 = 1
        L_0x005c:
            if (r4 == 0) goto L_0x0062
            r3.m457a((androidx.appcompat.app.C0407f.C0425o) r2, (android.view.KeyEvent) r5)
            goto L_0x006a
        L_0x0062:
            r0 = 0
            goto L_0x006a
        L_0x0064:
            boolean r4 = r2.f504o
            r3.mo2051a((androidx.appcompat.app.C0407f.C0425o) r2, (boolean) r0)
            r0 = r4
        L_0x006a:
            if (r0 == 0) goto L_0x0083
            android.content.Context r4 = r3.f447e
            java.lang.String r5 = "audio"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L_0x007c
            r4.playSoundEffect(r1)
            goto L_0x0083
        L_0x007c:
            java.lang.String r4 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r4, r5)
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0407f.m469e(int, android.view.KeyEvent):boolean");
    }

    /* renamed from: k */
    public boolean mo2066k() {
        return m462a(true);
    }

    /* renamed from: d */
    private boolean m468d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        C0425o a = mo2046a(i, true);
        if (!a.f504o) {
            return m465b(a, keyEvent);
        }
        return false;
    }

    /* renamed from: b */
    public void mo2033b(View view, ViewGroup.LayoutParams layoutParams) {
        m476z();
        ViewGroup viewGroup = (ViewGroup) this.f464v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f449g.mo2347a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo2064i(int i) {
        if (i == 108) {
            C0399a c = mo2035c();
            if (c != null) {
                c.mo1960b(false);
            }
        } else if (i == 0) {
            C0425o a = mo2046a(i, true);
            if (a.f504o) {
                mo2051a(a, false);
            }
        }
    }

    /* renamed from: c */
    public void mo2037c(Bundle bundle) {
        if (this.f433N != -100) {
            f415b0.put(this.f446d.getClass(), Integer.valueOf(this.f433N));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo2061f(int i) {
        C0425o a;
        C0425o a2 = mo2046a(i, true);
        if (a2.f499j != null) {
            Bundle bundle = new Bundle();
            a2.f499j.mo2542b(bundle);
            if (bundle.size() > 0) {
                a2.f508s = bundle;
            }
            a2.f499j.mo2579s();
            a2.f499j.clear();
        }
        a2.f507r = true;
        a2.f506q = true;
        if ((i == 108 || i == 0) && this.f454l != null && (a = mo2046a(0, false)) != null) {
            a.f502m = false;
            m465b(a, (KeyEvent) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo2059c(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.f428I;
            this.f428I = false;
            C0425o a = mo2046a(0, false);
            if (a != null && a.f504o) {
                if (!z) {
                    mo2051a(a, true);
                }
                return true;
            } else if (mo2076s()) {
                return true;
            }
        } else if (i == 82) {
            m469e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public <T extends View> T mo2024a(int i) {
        m476z();
        return this.f448f.findViewById(i);
    }

    /* renamed from: b */
    public boolean mo2034b(int i) {
        int l = m471l(i);
        if (this.f424E && l == 108) {
            return false;
        }
        if (this.f420A && l == 1) {
            this.f420A = false;
        }
        if (l == 1) {
            m454E();
            this.f424E = true;
            return true;
        } else if (l == 2) {
            m454E();
            this.f467y = true;
            return true;
        } else if (l == 5) {
            m454E();
            this.f468z = true;
            return true;
        } else if (l == 10) {
            m454E();
            this.f422C = true;
            return true;
        } else if (l == 108) {
            m454E();
            this.f420A = true;
            return true;
        } else if (l != 109) {
            return this.f448f.requestFeature(l);
        } else {
            m454E();
            this.f421B = true;
            return true;
        }
    }

    /* renamed from: a */
    public void mo2026a(Configuration configuration) {
        C0399a c;
        if (this.f420A && this.f463u && (c = mo2035c()) != null) {
            c.mo1956a(configuration);
        }
        C0596g.m1590b().mo3423a(this.f447e);
        m462a(false);
    }

    /* renamed from: c */
    private boolean m467c(C0425o oVar) {
        Context context = this.f447e;
        int i = oVar.f490a;
        if ((i == 0 || i == 108) && this.f454l != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                C0458d dVar = new C0458d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        C0482g gVar = new C0482g(context);
        gVar.mo2522a((C0482g.C0483a) this);
        oVar.mo2116a(gVar);
        return true;
    }

    /* renamed from: a */
    public void mo2028a(View view) {
        m476z();
        ViewGroup viewGroup = (ViewGroup) this.f464v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f449g.mo2347a().onContentChanged();
    }

    /* renamed from: a */
    public void mo2029a(View view, ViewGroup.LayoutParams layoutParams) {
        m476z();
        ((ViewGroup) this.f464v.findViewById(16908290)).addView(view, layoutParams);
        this.f449g.mo2347a().onContentChanged();
    }

    /* renamed from: a */
    private void m456a(Window window) {
        if (this.f448f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof C0419j)) {
                C0419j jVar = new C0419j(callback);
                this.f449g = jVar;
                window.setCallback(jVar);
                C0598g0 a = C0598g0.m1609a(this.f447e, (AttributeSet) null, f417d0);
                Drawable c = a.mo3439c(0);
                if (c != null) {
                    window.setBackgroundDrawable(c);
                }
                a.mo3434a();
                this.f448f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.p011d.C0455b mo2056b(androidx.appcompat.p011d.C0455b.C0456a r8) {
        /*
            r7 = this;
            r7.mo2068m()
            androidx.appcompat.d.b r0 = r7.f457o
            if (r0 == 0) goto L_0x000a
            r0.mo2150a()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.C0407f.C0417i
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.f$i r0 = new androidx.appcompat.app.f$i
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.d r0 = r7.f450h
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.f432M
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.d.b r0 = r0.mo1985a((androidx.appcompat.p011d.C0455b.C0456a) r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.f457o = r0
            goto L_0x0161
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f458p
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.f423D
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f447e
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R$attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f447e
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.d.d r4 = new androidx.appcompat.d.d
            android.content.Context r6 = r7.f447e
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f447e
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f458p = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R$attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.f459q = r5
            r6 = 2
            androidx.core.widget.C0878h.m2932a((android.widget.PopupWindow) r5, (int) r6)
            android.widget.PopupWindow r5 = r7.f459q
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f458p
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f459q
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R$attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f458p
            r4.mo2793a((int) r0)
            android.widget.PopupWindow r0 = r7.f459q
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.f$f r0 = new androidx.appcompat.app.f$f
            r0.<init>()
            r7.f460r = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.f464v
            int r4 = androidx.appcompat.R$id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.mo2069n()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.mo3346a(r4)
            android.view.View r0 = r0.mo3345a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f458p = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f458p
            if (r0 == 0) goto L_0x0161
            r7.mo2068m()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f458p
            r0.mo2802e()
            androidx.appcompat.d.e r0 = new androidx.appcompat.d.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f458p
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f458p
            android.widget.PopupWindow r6 = r7.f459q
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = 0
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.mo2158c()
            boolean r8 = r8.mo2091a((androidx.appcompat.p011d.C0455b) r0, (android.view.Menu) r3)
            if (r8 == 0) goto L_0x015f
            r0.mo2162i()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f458p
            r8.mo2795a((androidx.appcompat.p011d.C0455b) r0)
            r7.f457o = r0
            boolean r8 = r7.mo2078u()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x0129
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f458p
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f458p
            androidx.core.f.x r8 = androidx.core.p020f.C0839t.m2688a(r8)
            r8.mo4206a((float) r0)
            r7.f461s = r8
            androidx.appcompat.app.f$g r0 = new androidx.appcompat.app.f$g
            r0.<init>()
            r8.mo4210a((androidx.core.p020f.C0855y) r0)
            goto L_0x014f
        L_0x0129:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f458p
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f458p
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f458p
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f458p
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x014f
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f458p
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.p020f.C0839t.m2683B(r8)
        L_0x014f:
            android.widget.PopupWindow r8 = r7.f459q
            if (r8 == 0) goto L_0x0161
            android.view.Window r8 = r7.f448f
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f460r
            r8.post(r0)
            goto L_0x0161
        L_0x015f:
            r7.f457o = r1
        L_0x0161:
            androidx.appcompat.d.b r8 = r7.f457o
            if (r8 == 0) goto L_0x016c
            androidx.appcompat.app.d r0 = r7.f450h
            if (r0 == 0) goto L_0x016c
            r0.mo1988a((androidx.appcompat.p011d.C0455b) r8)
        L_0x016c:
            androidx.appcompat.d.b r8 = r7.f457o
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0407f.mo2056b(androidx.appcompat.d.b$a):androidx.appcompat.d.b");
    }

    /* renamed from: c */
    private void m466c(int i, boolean z) {
        Resources resources = this.f447e.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            C0429h.m572a(resources);
        }
        int i2 = this.f434O;
        if (i2 != 0) {
            this.f447e.setTheme(i2);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f447e.getTheme().applyStyle(this.f434O, true);
            }
        }
        if (z) {
            Object obj = this.f446d;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof C0970h) {
                    if (((C0970h) activity).getLifecycle().mo4995a().mo4998a(C0965e.C0967b.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.f431L) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo2030a(CharSequence charSequence) {
        this.f453k = charSequence;
        C0619o oVar = this.f454l;
        if (oVar != null) {
            oVar.mo2820a(charSequence);
        } else if (mo2077t() != null) {
            mo2077t().mo1957a(charSequence);
        } else {
            TextView textView = this.f465w;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    /* renamed from: a */
    public boolean mo2055a(C0482g gVar, MenuItem menuItem) {
        C0425o a;
        Window.Callback q = mo2074q();
        if (q == null || this.f432M || (a = mo2047a((Menu) gVar.mo2569m())) == null) {
            return false;
        }
        return q.onMenuItemSelected(a.f490a, menuItem);
    }

    /* renamed from: a */
    public void mo2052a(C0482g gVar) {
        m458a(gVar, true);
    }

    /* renamed from: a */
    public C0455b mo2048a(C0455b.C0456a aVar) {
        C0405d dVar;
        if (aVar != null) {
            C0455b bVar = this.f457o;
            if (bVar != null) {
                bVar.mo2150a();
            }
            C0417i iVar = new C0417i(aVar);
            C0399a c = mo2035c();
            if (c != null) {
                C0455b a = c.mo1955a((C0455b.C0456a) iVar);
                this.f457o = a;
                if (!(a == null || (dVar = this.f450h) == null)) {
                    dVar.mo1988a(a);
                }
            }
            if (this.f457o == null) {
                this.f457o = mo2056b((C0455b.C0456a) iVar);
            }
            return this.f457o;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2054a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f446d;
        boolean z = true;
        if (((obj instanceof C0822d.C0823a) || (obj instanceof C0427g)) && (decorView = this.f448f.getDecorView()) != null && C0822d.m2630a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f449g.mo2347a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? mo2053a(keyCode, keyEvent) : mo2059c(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2053a(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (i == 4) {
            if ((keyEvent.getFlags() & OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE) == 0) {
                z = false;
            }
            this.f428I = z;
        } else if (i == 82) {
            m468d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public View mo2045a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.f445a0 == null) {
            String string = this.f447e.obtainStyledAttributes(R$styleable.AppCompatTheme).getString(R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.f445a0 = new AppCompatViewInflater();
            } else {
                try {
                    this.f445a0 = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    "Failed to instantiate custom view inflater " + string + ". Falling back to default.";
                    this.f445a0 = new AppCompatViewInflater();
                }
            }
        }
        if (f416c0) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z2 = m459a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z2 = true;
            }
            z = z2;
        } else {
            z = false;
        }
        return this.f445a0.mo1939a(view, str, context, attributeSet, z, f416c0, true, C0612l0.m1707b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo2058b(int i, KeyEvent keyEvent) {
        C0399a c = mo2035c();
        if (c != null && c.mo1958a(i, keyEvent)) {
            return true;
        }
        C0425o oVar = this.f427H;
        if (oVar == null || !m461a(oVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f427H == null) {
                C0425o a = mo2046a(0, true);
                m465b(a, keyEvent);
                boolean a2 = m461a(a, keyEvent.getKeyCode(), keyEvent, 1);
                a.f502m = false;
                if (a2) {
                    return true;
                }
            }
            return false;
        }
        C0425o oVar2 = this.f427H;
        if (oVar2 != null) {
            oVar2.f503n = true;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m459a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f448f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || C0839t.m2735x((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    /* renamed from: a */
    private void m457a(C0425o oVar, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (!oVar.f504o && !this.f432M) {
            if (oVar.f490a == 0) {
                if ((this.f447e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback q = mo2074q();
            if (q == null || q.onMenuOpened(oVar.f490a, oVar.f499j)) {
                WindowManager windowManager = (WindowManager) this.f447e.getSystemService("window");
                if (windowManager != null && m465b(oVar, keyEvent)) {
                    if (oVar.f496g == null || oVar.f506q) {
                        ViewGroup viewGroup = oVar.f496g;
                        if (viewGroup == null) {
                            if (!m464b(oVar) || oVar.f496g == null) {
                                return;
                            }
                        } else if (oVar.f506q && viewGroup.getChildCount() > 0) {
                            oVar.f496g.removeAllViews();
                        }
                        if (m460a(oVar) && oVar.mo2117a()) {
                            ViewGroup.LayoutParams layoutParams2 = oVar.f497h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            oVar.f496g.setBackgroundResource(oVar.f491b);
                            ViewParent parent = oVar.f497h.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(oVar.f497h);
                            }
                            oVar.f496g.addView(oVar.f497h, layoutParams2);
                            if (!oVar.f497h.hasFocus()) {
                                oVar.f497h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else {
                        View view = oVar.f498i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i = -1;
                            oVar.f503n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, oVar.f493d, oVar.f494e, 1002, 8519680, -3);
                            layoutParams3.gravity = oVar.f492c;
                            layoutParams3.windowAnimations = oVar.f495f;
                            windowManager.addView(oVar.f496g, layoutParams3);
                            oVar.f504o = true;
                            return;
                        }
                    }
                    i = -2;
                    oVar.f503n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, oVar.f493d, oVar.f494e, 1002, 8519680, -3);
                    layoutParams32.gravity = oVar.f492c;
                    layoutParams32.windowAnimations = oVar.f495f;
                    windowManager.addView(oVar.f496g, layoutParams32);
                    oVar.f504o = true;
                    return;
                }
                return;
            }
            mo2051a(oVar, true);
        }
    }

    /* renamed from: b */
    private boolean m464b(C0425o oVar) {
        oVar.mo2115a(mo2069n());
        oVar.f496g = new C0424n(oVar.f501l);
        oVar.f492c = 81;
        return true;
    }

    /* renamed from: b */
    private boolean m465b(C0425o oVar, KeyEvent keyEvent) {
        C0619o oVar2;
        C0619o oVar3;
        C0619o oVar4;
        if (this.f432M) {
            return false;
        }
        if (oVar.f502m) {
            return true;
        }
        C0425o oVar5 = this.f427H;
        if (!(oVar5 == null || oVar5 == oVar)) {
            mo2051a(oVar5, false);
        }
        Window.Callback q = mo2074q();
        if (q != null) {
            oVar.f498i = q.onCreatePanelView(oVar.f490a);
        }
        int i = oVar.f490a;
        boolean z = i == 0 || i == 108;
        if (z && (oVar4 = this.f454l) != null) {
            oVar4.mo2824b();
        }
        if (oVar.f498i == null) {
            if (z) {
                mo2077t();
            }
            if (oVar.f499j == null || oVar.f507r) {
                if (oVar.f499j == null && (!m467c(oVar) || oVar.f499j == null)) {
                    return false;
                }
                if (z && this.f454l != null) {
                    if (this.f455m == null) {
                        this.f455m = new C0416h();
                    }
                    this.f454l.mo2813a(oVar.f499j, this.f455m);
                }
                oVar.f499j.mo2579s();
                if (!q.onCreatePanelMenu(oVar.f490a, oVar.f499j)) {
                    oVar.mo2116a((C0482g) null);
                    if (z && (oVar3 = this.f454l) != null) {
                        oVar3.mo2813a((Menu) null, this.f455m);
                    }
                    return false;
                }
                oVar.f507r = false;
            }
            oVar.f499j.mo2579s();
            Bundle bundle = oVar.f508s;
            if (bundle != null) {
                oVar.f499j.mo2520a(bundle);
                oVar.f508s = null;
            }
            if (!q.onPreparePanel(0, oVar.f498i, oVar.f499j)) {
                if (z && (oVar2 = this.f454l) != null) {
                    oVar2.mo2813a((Menu) null, this.f455m);
                }
                oVar.f499j.mo2576r();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            oVar.f505p = z2;
            oVar.f499j.setQwertyMode(z2);
            oVar.f499j.mo2576r();
        }
        oVar.f502m = true;
        oVar.f503n = false;
        this.f427H = oVar;
        return true;
    }

    /* renamed from: a */
    private void m458a(C0482g gVar, boolean z) {
        C0619o oVar = this.f454l;
        if (oVar == null || !oVar.mo2829c() || (ViewConfiguration.get(this.f447e).hasPermanentMenuKey() && !this.f454l.mo2832d())) {
            C0425o a = mo2046a(0, true);
            a.f506q = true;
            mo2051a(a, false);
            m457a(a, (KeyEvent) null);
            return;
        }
        Window.Callback q = mo2074q();
        if (this.f454l.mo2822a() && z) {
            this.f454l.mo2834e();
            if (!this.f432M) {
                q.onPanelClosed(108, mo2046a(0, true).f499j);
            }
        } else if (q != null && !this.f432M) {
            if (this.f439U && (this.f440V & 1) != 0) {
                this.f448f.getDecorView().removeCallbacks(this.f441W);
                this.f441W.run();
            }
            C0425o a2 = mo2046a(0, true);
            C0482g gVar2 = a2.f499j;
            if (gVar2 != null && !a2.f507r && q.onPreparePanel(0, a2.f498i, gVar2)) {
                q.onMenuOpened(108, a2.f499j);
                this.f454l.mo2835f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2057b(C0482g gVar) {
        if (!this.f425F) {
            this.f425F = true;
            this.f454l.mo2837g();
            Window.Callback q = mo2074q();
            if (q != null && !this.f432M) {
                q.onPanelClosed(108, gVar);
            }
            this.f425F = false;
        }
    }

    /* renamed from: b */
    private boolean m463b(int i, boolean z) {
        int i2 = this.f447e.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z2 = true;
        int i3 = i != 1 ? i != 2 ? i2 : 32 : 16;
        boolean D = m453D();
        boolean z3 = false;
        if ((f419f0 || i3 != i2) && !D && Build.VERSION.SDK_INT >= 17 && !this.f429J && (this.f446d instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & -49) | i3;
            try {
                ((ContextThemeWrapper) this.f446d).applyOverrideConfiguration(configuration);
                z3 = true;
            } catch (IllegalStateException e) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e);
            }
        }
        int i4 = this.f447e.getResources().getConfiguration().uiMode & 48;
        if (!z3 && i4 != i3 && z && !D && this.f429J && (Build.VERSION.SDK_INT >= 17 || this.f430K)) {
            Object obj = this.f446d;
            if (obj instanceof Activity) {
                C0696a.m2199d((Activity) obj);
                z3 = true;
            }
        }
        if (z3 || i4 == i3) {
            z2 = z3;
        } else {
            m466c(i3, D);
        }
        if (z2) {
            Object obj2 = this.f446d;
            if (obj2 instanceof C0404c) {
                ((C0404c) obj2).mo1986a(i);
            }
        }
        return z2;
    }

    /* renamed from: a */
    private boolean m460a(C0425o oVar) {
        View view = oVar.f498i;
        if (view != null) {
            oVar.f497h = view;
            return true;
        } else if (oVar.f499j == null) {
            return false;
        } else {
            if (this.f456n == null) {
                this.f456n = new C0426p();
            }
            View view2 = (View) oVar.mo2114a((C0497m.C0498a) this.f456n);
            oVar.f497h = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2051a(C0425o oVar, boolean z) {
        ViewGroup viewGroup;
        C0619o oVar2;
        if (!z || oVar.f490a != 0 || (oVar2 = this.f454l) == null || !oVar2.mo2822a()) {
            WindowManager windowManager = (WindowManager) this.f447e.getSystemService("window");
            if (!(windowManager == null || !oVar.f504o || (viewGroup = oVar.f496g) == null)) {
                windowManager.removeView(viewGroup);
                if (z) {
                    mo2049a(oVar.f490a, oVar, (Menu) null);
                }
            }
            oVar.f502m = false;
            oVar.f503n = false;
            oVar.f504o = false;
            oVar.f497h = null;
            oVar.f506q = true;
            if (this.f427H == oVar) {
                this.f427H = null;
                return;
            }
            return;
        }
        mo2057b(oVar.f499j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2049a(int i, C0425o oVar, Menu menu) {
        if (menu == null) {
            if (oVar == null && i >= 0) {
                C0425o[] oVarArr = this.f426G;
                if (i < oVarArr.length) {
                    oVar = oVarArr[i];
                }
            }
            if (oVar != null) {
                menu = oVar.f499j;
            }
        }
        if ((oVar == null || oVar.f504o) && !this.f432M) {
            this.f449g.mo2347a().onPanelClosed(i, menu);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0425o mo2047a(Menu menu) {
        C0425o[] oVarArr = this.f426G;
        int length = oVarArr != null ? oVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0425o oVar = oVarArr[i];
            if (oVar != null && oVar.f499j == menu) {
                return oVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0425o mo2046a(int i, boolean z) {
        C0425o[] oVarArr = this.f426G;
        if (oVarArr == null || oVarArr.length <= i) {
            C0425o[] oVarArr2 = new C0425o[(i + 1)];
            if (oVarArr != null) {
                System.arraycopy(oVarArr, 0, oVarArr2, 0, oVarArr.length);
            }
            this.f426G = oVarArr2;
            oVarArr = oVarArr2;
        }
        C0425o oVar = oVarArr[i];
        if (oVar != null) {
            return oVar;
        }
        C0425o oVar2 = new C0425o(i);
        oVarArr[i] = oVar2;
        return oVar2;
    }

    /* renamed from: a */
    private boolean m461a(C0425o oVar, int i, KeyEvent keyEvent, int i2) {
        C0482g gVar;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((oVar.f502m || m465b(oVar, keyEvent)) && (gVar = oVar.f499j) != null) {
            z = gVar.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.f454l == null) {
            mo2051a(oVar, true);
        }
        return z;
    }

    /* renamed from: a */
    private boolean m462a(boolean z) {
        if (this.f432M) {
            return false;
        }
        int w = m473w();
        boolean b = m463b(mo2062g(w), z);
        if (w == 0) {
            mo2070o().mo2109e();
        } else {
            C0421l lVar = this.f437R;
            if (lVar != null) {
                lVar.mo2108a();
            }
        }
        if (w == 3) {
            m451B().mo2109e();
        } else {
            C0421l lVar2 = this.f438S;
            if (lVar2 != null) {
                lVar2.mo2108a();
            }
        }
        return b;
    }

    /* renamed from: a */
    public int mo2023a() {
        return this.f433N;
    }
}
