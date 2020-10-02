package p118io.presage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.util.Calendar;

/* renamed from: io.presage.CamembertdeNormandie */
public final class CamembertdeNormandie extends FrameLayout {

    /* renamed from: a */
    public static final CamembertauCalvados f16413a = new CamembertauCalvados((byte) 0);

    /* renamed from: b */
    private float f16414b;

    /* renamed from: c */
    private float f16415c;

    /* renamed from: d */
    private int f16416d;

    /* renamed from: e */
    private int f16417e;

    /* renamed from: f */
    private long f16418f;

    /* renamed from: g */
    private BriedeMeaux f16419g = new BriedeMeaux();

    /* renamed from: h */
    private boolean f16420h;

    /* renamed from: i */
    private C6388cu f16421i;

    /* renamed from: j */
    private C6482gg<? super CamembertdeNormandie, C6437ep> f16422j;

    /* renamed from: k */
    private C6481gf<C6437ep> f16423k;

    /* renamed from: l */
    private C6481gf<C6437ep> f16424l;

    /* renamed from: m */
    private boolean f16425m;

    /* renamed from: n */
    private boolean f16426n;

    /* renamed from: o */
    private C6388cu f16427o;

    /* renamed from: io.presage.CamembertdeNormandie$CamembertauCalvados */
    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte b) {
            this();
        }
    }

    public CamembertdeNormandie(Context context) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(600, 600));
        addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) {

            /* renamed from: a */
            final /* synthetic */ CamembertdeNormandie f16428a;

            {
                this.f16428a = r1;
            }

            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                C6482gg<CamembertdeNormandie, C6437ep> adLayoutChangeListener = this.f16428a.getAdLayoutChangeListener();
                if (adLayoutChangeListener != null) {
                    adLayoutChangeListener.mo34409a(this.f16428a);
                }
            }
        });
    }

    /* renamed from: b */
    private final void m20273b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            m20276c(motionEvent);
        } else if (action == 2) {
            m20277d(motionEvent);
        }
    }

    /* renamed from: c */
    private final void m20276c(MotionEvent motionEvent) {
        this.f16414b = getX() - motionEvent.getRawX();
        this.f16415c = getY() - motionEvent.getRawY();
    }

    /* renamed from: d */
    private final void m20277d(MotionEvent motionEvent) {
        bringToFront();
        if (m20271a(motionEvent.getRawX() + this.f16414b + ((float) (getWidth() / 4)))) {
            setX(motionEvent.getRawX() + this.f16414b);
        }
        if (m20275b(motionEvent.getRawY() + this.f16415c + ((float) (getHeight() / 4)))) {
            setY(motionEvent.getRawY() + this.f16415c);
        }
    }

    /* renamed from: f */
    private final void m20278f() {
        setX(0.0f);
        setY(0.0f);
    }

    /* renamed from: g */
    private final void m20279g() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof C6396db) {
                ((C6396db) childAt).mo35340f();
            }
        }
    }

    /* renamed from: h */
    private final void m20280h() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            if (this.f16416d != viewGroup.getMeasuredHeight() || this.f16417e != viewGroup.getMeasuredWidth()) {
                m20269a(viewGroup);
                m20274b(viewGroup);
            }
        }
    }

    /* renamed from: a */
    public final void mo34472a() {
        ViewGroup parentAsViewGroup = getParentAsViewGroup();
        if (parentAsViewGroup != null) {
            parentAsViewGroup.removeView(this);
        }
    }

    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof WebView) || getChildCount() <= 0) {
            super.addView(view, layoutParams);
        } else {
            super.addView(view, getChildCount() - 1, layoutParams);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f16420h || m20272a(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        m20279g();
        return true;
    }

    /* renamed from: e */
    public final void mo34478e() {
        this.f16422j = null;
        this.f16423k = null;
        this.f16424l = null;
        removeAllViews();
    }

    public final C6482gg<CamembertdeNormandie, C6437ep> getAdLayoutChangeListener() {
        return this.f16422j;
    }

    public final int getContainerHeight() {
        return this.f16416d;
    }

    public final int getContainerWidth() {
        return this.f16417e;
    }

    public final boolean getContainsOverlayAd() {
        return this.f16426n;
    }

    public final boolean getEnableDrag() {
        return this.f16420h;
    }

    public final C6481gf<C6437ep> getOnWindowGainFocusListener() {
        return this.f16423k;
    }

    public final C6481gf<C6437ep> getOnWindowLoseFocusListener() {
        return this.f16424l;
    }

    public final ViewGroup getParentAsViewGroup() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        return (ViewGroup) parent;
    }

    public final C6388cu getResizeProps() {
        return this.f16421i;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        if (this.f16426n) {
            AffideliceauChablis affideliceauChablis = AffideliceauChablis.f16369a;
            AffideliceauChablis.m20197a(true);
        }
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        this.f16425m = false;
        if (this.f16426n) {
            AffideliceauChablis affideliceauChablis = AffideliceauChablis.f16369a;
            AffideliceauChablis.m20197a(false);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.f16425m) {
            m20280h();
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            C6481gf<C6437ep> gfVar = this.f16423k;
            if (gfVar != null) {
                gfVar.mo34405a();
                return;
            }
            return;
        }
        C6481gf<C6437ep> gfVar2 = this.f16424l;
        if (gfVar2 != null) {
            gfVar2.mo34405a();
        }
    }

    public final void setAdLayoutChangeListener(C6482gg<? super CamembertdeNormandie, C6437ep> ggVar) {
        this.f16422j = ggVar;
    }

    public final void setContainsOverlayAd(boolean z) {
        this.f16426n = z;
    }

    public final void setDisplayedInFullScreen(boolean z) {
        this.f16425m = z;
    }

    public final void setEnableDrag(boolean z) {
        this.f16420h = z;
    }

    public final void setInitialSize(C6388cu cuVar) {
        this.f16427o = cuVar;
        m20278f();
        m20270a(cuVar);
    }

    public final void setOnWindowGainFocusListener(C6481gf<C6437ep> gfVar) {
        this.f16423k = gfVar;
    }

    public final void setOnWindowLoseFocusListener(C6481gf<C6437ep> gfVar) {
        this.f16424l = gfVar;
    }

    public final void setRectHelper(BriedeMeaux briedeMeaux) {
        this.f16419g = briedeMeaux;
    }

    public final void setResizeProps(C6388cu cuVar) {
        this.f16421i = cuVar;
    }

    /* renamed from: a */
    private final boolean m20272a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            Calendar instance = Calendar.getInstance();
            C6514hl.m21414a((Object) instance, "Calendar.getInstance()");
            this.f16418f = instance.getTimeInMillis();
        } else if (action == 1) {
            C6482gg<? super CamembertdeNormandie, C6437ep> ggVar = this.f16422j;
            if (ggVar != null) {
                ggVar.mo34409a(this);
            }
            Calendar instance2 = Calendar.getInstance();
            C6514hl.m21414a((Object) instance2, "Calendar.getInstance()");
            if (instance2.getTimeInMillis() - this.f16418f < 200) {
                return true;
            }
            return false;
        }
        m20273b(motionEvent);
        return true;
    }

    /* renamed from: c */
    public final void mo34475c() {
        m20278f();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            setLayoutParams(layoutParams2);
            return;
        }
        throw new C6434em("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    /* renamed from: b */
    private final boolean m20275b(float f) {
        return f > 0.0f && f + ((float) (getHeight() / 2)) < ((float) this.f16416d);
    }

    /* renamed from: b */
    public final void mo34474b() {
        m20270a(this.f16421i);
    }

    /* renamed from: b */
    private final void m20274b(ViewGroup viewGroup) {
        m20270a(BriedeMeaux.m20234a((View) this, (View) viewGroup));
    }

    /* renamed from: d */
    public final void mo34476d() {
        m20278f();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            this.f16421i = BriedeMeaux.m20235a((View) viewGroup, this.f16427o);
            m20269a(viewGroup);
        }
    }

    /* renamed from: a */
    private final boolean m20271a(float f) {
        return f > 0.0f && f + ((float) (getWidth() / 2)) < ((float) this.f16417e);
    }

    /* renamed from: a */
    private final void m20270a(C6388cu cuVar) {
        if (cuVar != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                setX((float) cuVar.mo35324e());
                setY((float) cuVar.mo35326f());
                layoutParams2.width = cuVar.mo35320c();
                layoutParams2.height = cuVar.mo35322d();
                setLayoutParams(layoutParams2);
                return;
            }
            throw new C6434em("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    /* renamed from: a */
    private final void m20269a(ViewGroup viewGroup) {
        this.f16417e = viewGroup.getMeasuredWidth();
        this.f16416d = viewGroup.getMeasuredHeight();
    }
}
