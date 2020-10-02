package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.C0381b;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.p019e.C0788a;
import androidx.core.p019e.C0789b;
import androidx.core.p020f.C0837r;
import androidx.fragment.app.C0917h;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.C0965e;
import androidx.lifecycle.C0986s;
import com.ogury.p159cm.OguryChoiceManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p075d.p080b.C3193b;

/* renamed from: androidx.fragment.app.i */
/* compiled from: FragmentManagerImpl */
final class C0920i extends C0917h implements LayoutInflater.Factory2 {

    /* renamed from: H */
    static boolean f2328H = false;

    /* renamed from: I */
    static final Interpolator f2329I = new DecelerateInterpolator(2.5f);

    /* renamed from: J */
    static final Interpolator f2330J = new DecelerateInterpolator(1.5f);

    /* renamed from: A */
    ArrayList<Boolean> f2331A;

    /* renamed from: B */
    ArrayList<Fragment> f2332B;

    /* renamed from: C */
    Bundle f2333C = null;

    /* renamed from: D */
    SparseArray<Parcelable> f2334D = null;

    /* renamed from: E */
    ArrayList<C0934m> f2335E;

    /* renamed from: F */
    private C0935j f2336F;

    /* renamed from: G */
    Runnable f2337G = new C0922b();

    /* renamed from: c */
    ArrayList<C0932k> f2338c;

    /* renamed from: d */
    boolean f2339d;

    /* renamed from: e */
    int f2340e = 0;

    /* renamed from: f */
    final ArrayList<Fragment> f2341f = new ArrayList<>();

    /* renamed from: g */
    final HashMap<String, Fragment> f2342g = new HashMap<>();

    /* renamed from: h */
    ArrayList<C0908a> f2343h;

    /* renamed from: i */
    ArrayList<Fragment> f2344i;

    /* renamed from: j */
    private OnBackPressedDispatcher f2345j;

    /* renamed from: k */
    private final C0381b f2346k = new C0921a(false);

    /* renamed from: l */
    ArrayList<C0908a> f2347l;

    /* renamed from: m */
    ArrayList<Integer> f2348m;

    /* renamed from: n */
    ArrayList<C0917h.C0919b> f2349n;

    /* renamed from: o */
    private final CopyOnWriteArrayList<C0930i> f2350o = new CopyOnWriteArrayList<>();

    /* renamed from: p */
    int f2351p = 0;

    /* renamed from: q */
    C0916g f2352q;

    /* renamed from: r */
    C0913d f2353r;

    /* renamed from: s */
    Fragment f2354s;

    /* renamed from: t */
    Fragment f2355t;

    /* renamed from: u */
    boolean f2356u;

    /* renamed from: v */
    boolean f2357v;

    /* renamed from: w */
    boolean f2358w;

    /* renamed from: x */
    boolean f2359x;

    /* renamed from: y */
    boolean f2360y;

    /* renamed from: z */
    ArrayList<C0908a> f2361z;

    /* renamed from: androidx.fragment.app.i$a */
    /* compiled from: FragmentManagerImpl */
    class C0921a extends C0381b {
        C0921a(boolean z) {
            super(z);
        }

        /* renamed from: a */
        public void mo1901a() {
            C0920i.this.mo4885u();
        }
    }

    /* renamed from: androidx.fragment.app.i$b */
    /* compiled from: FragmentManagerImpl */
    class C0922b implements Runnable {
        C0922b() {
        }

        public void run() {
            C0920i.this.mo4877q();
        }
    }

    /* renamed from: androidx.fragment.app.i$c */
    /* compiled from: FragmentManagerImpl */
    class C0923c implements Animation.AnimationListener {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f2364a;

        /* renamed from: b */
        final /* synthetic */ Fragment f2365b;

        /* renamed from: androidx.fragment.app.i$c$a */
        /* compiled from: FragmentManagerImpl */
        class C0924a implements Runnable {
            C0924a() {
            }

            public void run() {
                if (C0923c.this.f2365b.getAnimatingAway() != null) {
                    C0923c.this.f2365b.setAnimatingAway((View) null);
                    C0923c cVar = C0923c.this;
                    C0920i iVar = C0920i.this;
                    Fragment fragment = cVar.f2365b;
                    iVar.mo4814a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        }

        C0923c(ViewGroup viewGroup, Fragment fragment) {
            this.f2364a = viewGroup;
            this.f2365b = fragment;
        }

        public void onAnimationEnd(Animation animation) {
            this.f2364a.post(new C0924a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.fragment.app.i$d */
    /* compiled from: FragmentManagerImpl */
    class C0925d extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f2368a;

        /* renamed from: b */
        final /* synthetic */ View f2369b;

        /* renamed from: c */
        final /* synthetic */ Fragment f2370c;

        C0925d(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f2368a = viewGroup;
            this.f2369b = view;
            this.f2370c = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2368a.endViewTransition(this.f2369b);
            Animator animator2 = this.f2370c.getAnimator();
            this.f2370c.setAnimator((Animator) null);
            if (animator2 != null && this.f2368a.indexOfChild(this.f2369b) < 0) {
                C0920i iVar = C0920i.this;
                Fragment fragment = this.f2370c;
                iVar.mo4814a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
            }
        }
    }

    /* renamed from: androidx.fragment.app.i$e */
    /* compiled from: FragmentManagerImpl */
    class C0926e extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f2372a;

        /* renamed from: b */
        final /* synthetic */ View f2373b;

        /* renamed from: c */
        final /* synthetic */ Fragment f2374c;

        C0926e(C0920i iVar, ViewGroup viewGroup, View view, Fragment fragment) {
            this.f2372a = viewGroup;
            this.f2373b = view;
            this.f2374c = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            this.f2372a.endViewTransition(this.f2373b);
            animator.removeListener(this);
            Fragment fragment = this.f2374c;
            View view = fragment.mView;
            if (view != null && fragment.mHidden) {
                view.setVisibility(8);
            }
        }
    }

    /* renamed from: androidx.fragment.app.i$f */
    /* compiled from: FragmentManagerImpl */
    class C0927f extends C0915f {
        C0927f() {
        }

        /* renamed from: a */
        public Fragment mo4773a(ClassLoader classLoader, String str) {
            C0916g gVar = C0920i.this.f2352q;
            return gVar.mo4748a(gVar.mo4775c(), str, (Bundle) null);
        }
    }

    /* renamed from: androidx.fragment.app.i$i */
    /* compiled from: FragmentManagerImpl */
    private static final class C0930i {

        /* renamed from: a */
        final C0917h.C0918a f2383a;

        /* renamed from: b */
        final boolean f2384b;

        C0930i(C0917h.C0918a aVar, boolean z) {
            this.f2383a = aVar;
            this.f2384b = z;
        }
    }

    /* renamed from: androidx.fragment.app.i$j */
    /* compiled from: FragmentManagerImpl */
    static class C0931j {

        /* renamed from: a */
        public static final int[] f2385a = {16842755, 16842960, 16842961};
    }

    /* renamed from: androidx.fragment.app.i$k */
    /* compiled from: FragmentManagerImpl */
    interface C0932k {
        /* renamed from: a */
        boolean mo4674a(ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: androidx.fragment.app.i$l */
    /* compiled from: FragmentManagerImpl */
    private class C0933l implements C0932k {

        /* renamed from: a */
        final String f2386a;

        /* renamed from: b */
        final int f2387b;

        /* renamed from: c */
        final int f2388c;

        C0933l(String str, int i, int i2) {
            this.f2386a = str;
            this.f2387b = i;
            this.f2388c = i2;
        }

        /* renamed from: a */
        public boolean mo4674a(ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = C0920i.this.f2355t;
            if (fragment != null && this.f2387b < 0 && this.f2386a == null && fragment.getChildFragmentManager().mo4786d()) {
                return false;
            }
            return C0920i.this.mo4827a(arrayList, arrayList2, this.f2386a, this.f2387b, this.f2388c);
        }
    }

    /* renamed from: androidx.fragment.app.i$m */
    /* compiled from: FragmentManagerImpl */
    static class C0934m implements Fragment.C0905e {

        /* renamed from: a */
        final boolean f2390a;

        /* renamed from: b */
        final C0908a f2391b;

        /* renamed from: c */
        private int f2392c;

        C0934m(C0908a aVar, boolean z) {
            this.f2390a = z;
            this.f2391b = aVar;
        }

        /* renamed from: a */
        public void mo4652a() {
            this.f2392c++;
        }

        /* renamed from: b */
        public void mo4653b() {
            int i = this.f2392c - 1;
            this.f2392c = i;
            if (i == 0) {
                this.f2391b.f2314r.mo4802A();
            }
        }

        /* renamed from: c */
        public void mo4901c() {
            C0908a aVar = this.f2391b;
            aVar.f2314r.mo4821a(aVar, this.f2390a, false, false);
        }

        /* renamed from: d */
        public void mo4902d() {
            boolean z = this.f2392c > 0;
            C0920i iVar = this.f2391b.f2314r;
            int size = iVar.f2341f.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = iVar.f2341f.get(i);
                fragment.setOnStartEnterTransitionListener((Fragment.C0905e) null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            C0908a aVar = this.f2391b;
            aVar.f2314r.mo4821a(aVar, this.f2390a, !z, true);
        }

        /* renamed from: e */
        public boolean mo4903e() {
            return this.f2392c == 0;
        }
    }

    C0920i() {
    }

    /* renamed from: C */
    private void m3187C() {
        this.f2342g.values().removeAll(Collections.singleton((Object) null));
    }

    /* renamed from: D */
    private void m3188D() {
        if (mo4887w()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* renamed from: E */
    private void m3189E() {
        this.f2339d = false;
        this.f2331A.clear();
        this.f2361z.clear();
    }

    /* renamed from: F */
    private void m3190F() {
        for (Fragment next : this.f2342g.values()) {
            if (next != null) {
                if (next.getAnimatingAway() != null) {
                    int stateAfterAnimating = next.getStateAfterAnimating();
                    View animatingAway = next.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    next.setAnimatingAway((View) null);
                    mo4814a(next, stateAfterAnimating, 0, 0, false);
                } else if (next.getAnimator() != null) {
                    next.getAnimator().end();
                }
            }
        }
    }

    /* renamed from: G */
    private void m3191G() {
        if (this.f2335E != null) {
            while (!this.f2335E.isEmpty()) {
                this.f2335E.remove(0).mo4902d();
            }
        }
    }

    /* renamed from: H */
    private void m3192H() {
        ArrayList<C0932k> arrayList = this.f2338c;
        boolean z = true;
        if (arrayList == null || arrayList.isEmpty()) {
            C0381b bVar = this.f2346k;
            if (mo4878r() <= 0 || !mo4859i(this.f2354s)) {
                z = false;
            }
            bVar.mo1903a(z);
            return;
        }
        this.f2346k.mo1903a(true);
    }

    /* renamed from: a */
    private void m3198a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0789b("FragmentManager"));
        C0916g gVar = this.f2352q;
        if (gVar != null) {
            try {
                gVar.mo4740a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo4783a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    /* renamed from: b */
    public static int m3202b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    /* renamed from: e */
    public static int m3209e(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public void mo4802A() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = this.f2335E != null && !this.f2335E.isEmpty();
            if (this.f2338c != null && this.f2338c.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f2352q.mo4776d().removeCallbacks(this.f2337G);
                this.f2352q.mo4776d().post(this.f2337G);
                m3192H();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public void mo4803B() {
        for (Fragment next : this.f2342g.values()) {
            if (next != null) {
                mo4869n(next);
            }
        }
    }

    /* renamed from: b */
    public void mo4831b(Fragment fragment) {
        if (f2328H) {
            "attach: " + fragment;
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (!this.f2341f.contains(fragment)) {
                if (f2328H) {
                    "add from attach: " + fragment;
                }
                synchronized (this.f2341f) {
                    this.f2341f.add(fragment);
                }
                fragment.mAdded = true;
                if (m3212w(fragment)) {
                    this.f2356u = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    /* renamed from: c */
    public List<Fragment> mo4785c() {
        List<Fragment> list;
        if (this.f2341f.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2341f) {
            list = (List) this.f2341f.clone();
        }
        return list;
    }

    /* renamed from: d */
    public boolean mo4786d() {
        m3188D();
        return m3201a((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo4846e(Fragment fragment) {
        if (fragment.mFromLayout && !fragment.mPerformedCreateView) {
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), (ViewGroup) null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                fragment.mInnerView = view;
                view.setSaveFromParentEnabled(false);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                mo4817a(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                return;
            }
            fragment.mInnerView = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C0935j mo4849f(Fragment fragment) {
        return this.f2336F.mo4907c(fragment);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public C0986s mo4852g(Fragment fragment) {
        return this.f2336F.mo4909d(fragment);
    }

    /* renamed from: h */
    public void mo4856h(Fragment fragment) {
        if (f2328H) {
            "hide: " + fragment;
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo4859i(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        C0920i iVar = fragment.mFragmentManager;
        if (fragment != iVar.mo4882t() || !mo4859i(iVar.f2354s)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo4861j(Fragment fragment) {
        if (this.f2342g.get(fragment.mWho) == null) {
            this.f2342g.put(fragment.mWho, fragment);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    mo4813a(fragment);
                } else {
                    mo4875p(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            if (f2328H) {
                "Added fragment to active set " + fragment;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo4863k(Fragment fragment) {
        if (this.f2342g.get(fragment.mWho) != null) {
            if (f2328H) {
                "Removed fragment from active set " + fragment;
            }
            for (Fragment next : this.f2342g.values()) {
                if (next != null && fragment.mWho.equals(next.mTargetWho)) {
                    next.mTarget = fragment;
                    next.mTargetWho = null;
                }
            }
            this.f2342g.put(fragment.mWho, (Object) null);
            mo4875p(fragment);
            String str = fragment.mTargetWho;
            if (str != null) {
                fragment.mTarget = this.f2342g.get(str);
            }
            fragment.initState();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        r0 = r0.mView;
        r1 = r11.mContainer;
     */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4865l(androidx.fragment.app.Fragment r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r0 = r10.f2342g
            java.lang.String r1 = r11.mWho
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0034
            boolean r0 = f2328H
            if (r0 == 0) goto L_0x0033
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Ignoring moving "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = " to state "
            r0.append(r11)
            int r11 = r10.f2351p
            r0.append(r11)
            java.lang.String r11 = "since it is not added to "
            r0.append(r11)
            r0.append(r10)
            r0.toString()
        L_0x0033:
            return
        L_0x0034:
            int r0 = r10.f2351p
            boolean r1 = r11.mRemoving
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x004b
            boolean r1 = r11.isInBackStack()
            if (r1 == 0) goto L_0x0047
            int r0 = java.lang.Math.min(r0, r2)
            goto L_0x004b
        L_0x0047:
            int r0 = java.lang.Math.min(r0, r3)
        L_0x004b:
            r6 = r0
            int r7 = r11.getNextTransition()
            int r8 = r11.getNextTransitionStyle()
            r9 = 0
            r4 = r10
            r5 = r11
            r4.mo4814a((androidx.fragment.app.Fragment) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x00b8
            androidx.fragment.app.Fragment r0 = r10.m3211v(r11)
            if (r0 == 0) goto L_0x007c
            android.view.View r0 = r0.mView
            android.view.ViewGroup r1 = r11.mContainer
            int r0 = r1.indexOfChild(r0)
            android.view.View r4 = r11.mView
            int r4 = r1.indexOfChild(r4)
            if (r4 >= r0) goto L_0x007c
            r1.removeViewAt(r4)
            android.view.View r4 = r11.mView
            r1.addView(r4, r0)
        L_0x007c:
            boolean r0 = r11.mIsNewlyAdded
            if (r0 == 0) goto L_0x00b8
            android.view.ViewGroup r0 = r11.mContainer
            if (r0 == 0) goto L_0x00b8
            float r0 = r11.mPostponedAlpha
            r1 = 0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L_0x0090
            android.view.View r4 = r11.mView
            r4.setAlpha(r0)
        L_0x0090:
            r11.mPostponedAlpha = r1
            r11.mIsNewlyAdded = r3
            int r0 = r11.getNextTransition()
            int r1 = r11.getNextTransitionStyle()
            androidx.fragment.app.i$g r0 = r10.mo4806a((androidx.fragment.app.Fragment) r11, (int) r0, (boolean) r2, (int) r1)
            if (r0 == 0) goto L_0x00b8
            android.view.animation.Animation r1 = r0.f2376a
            if (r1 == 0) goto L_0x00ac
            android.view.View r0 = r11.mView
            r0.startAnimation(r1)
            goto L_0x00b8
        L_0x00ac:
            android.animation.Animator r1 = r0.f2377b
            android.view.View r2 = r11.mView
            r1.setTarget(r2)
            android.animation.Animator r0 = r0.f2377b
            r0.start()
        L_0x00b8:
            boolean r0 = r11.mHiddenChanged
            if (r0 == 0) goto L_0x00bf
            r10.mo4839c((androidx.fragment.app.Fragment) r11)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0920i.mo4865l(androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo4867m(Fragment fragment) {
        mo4814a(fragment, this.f2351p, 0, 0, false);
    }

    /* renamed from: n */
    public void mo4869n(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.f2339d) {
            this.f2360y = true;
            return;
        }
        fragment.mDeferStart = false;
        mo4814a(fragment, this.f2351p, 0, 0, false);
    }

    /* renamed from: o */
    public void mo4871o(Fragment fragment) {
        if (f2328H) {
            "remove: " + fragment + " nesting=" + fragment.mBackStackNesting;
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.f2341f) {
                this.f2341f.remove(fragment);
            }
            if (m3212w(fragment)) {
                this.f2356u = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue((String) null, "class");
        Context context2 = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, C0931j.f2385a);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str3 == null || !C0915f.m3155b(context.getClassLoader(), str3)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str3);
        }
        if (resourceId != -1) {
            fragment = mo4804a(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = mo4777a(string);
        }
        if (fragment == null && i != -1) {
            fragment = mo4804a(i);
        }
        if (f2328H) {
            "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str3 + " existing=" + fragment;
        }
        if (fragment == null) {
            fragment = mo4784b().mo4773a(context.getClassLoader(), str3);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : i;
            fragment.mContainerId = i;
            fragment.mTag = string;
            fragment.mInLayout = true;
            fragment.mFragmentManager = this;
            C0916g gVar = this.f2352q;
            fragment.mHost = gVar;
            fragment.onInflate(gVar.mo4775c(), attributeSet2, fragment.mSavedFragmentState);
            mo4819a(fragment, true);
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            C0916g gVar2 = this.f2352q;
            fragment.mHost = gVar2;
            fragment.onInflate(gVar2.mo4775c(), attributeSet2, fragment.mSavedFragmentState);
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str3);
        }
        Fragment fragment2 = fragment;
        if (this.f2351p >= 1 || !fragment2.mFromLayout) {
            mo4867m(fragment2);
        } else {
            mo4814a(fragment2, 1, 0, 0, false);
        }
        View view2 = fragment2.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment2.mView.getTag() == null) {
                fragment2.mView.setTag(string);
            }
            return fragment2.mView;
        }
        throw new IllegalStateException("Fragment " + str3 + " did not create a view.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo4875p(Fragment fragment) {
        if (mo4887w()) {
            boolean z = f2328H;
        } else if (this.f2336F.mo4911e(fragment) && f2328H) {
            "Updating retained Fragments: Removed " + fragment;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: q */
    public boolean mo4877q() {
        m3207c(true);
        boolean z = false;
        while (m3205b(this.f2361z, this.f2331A)) {
            this.f2339d = true;
            try {
                m3206c(this.f2361z, this.f2331A);
                m3189E();
                z = true;
            } catch (Throwable th) {
                m3189E();
                throw th;
            }
        }
        m3192H();
        mo4874p();
        m3187C();
        return z;
    }

    /* renamed from: r */
    public int mo4878r() {
        ArrayList<C0908a> arrayList = this.f2343h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public LayoutInflater.Factory2 mo4880s() {
        return this;
    }

    /* renamed from: s */
    public void mo4881s(Fragment fragment) {
        if (fragment == null || (this.f2342g.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            Fragment fragment2 = this.f2355t;
            this.f2355t = fragment;
            m3210u(fragment2);
            m3210u(this.f2355t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: t */
    public void mo4883t(Fragment fragment) {
        if (f2328H) {
            "show: " + fragment;
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f2354s;
        if (fragment != null) {
            C0788a.m2491a(fragment, sb);
        } else {
            C0788a.m2491a(this.f2352q, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo4885u() {
        mo4877q();
        if (this.f2346k.mo1905b()) {
            mo4786d();
        } else {
            this.f2345j.mo1898a();
        }
    }

    /* renamed from: v */
    public boolean mo4886v() {
        return this.f2359x;
    }

    /* renamed from: w */
    public boolean mo4887w() {
        return this.f2357v || this.f2358w;
    }

    /* renamed from: x */
    public void mo4888x() {
        this.f2357v = false;
        this.f2358w = false;
        int size = this.f2341f.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.f2341f.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo4889y() {
        if (this.f2349n != null) {
            for (int i = 0; i < this.f2349n.size(); i++) {
                this.f2349n.get(i).mo4801a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public Parcelable mo4890z() {
        ArrayList<String> arrayList;
        int size;
        m3191G();
        m3190F();
        mo4877q();
        this.f2357v = true;
        BackStackState[] backStackStateArr = null;
        if (this.f2342g.isEmpty()) {
            return null;
        }
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(this.f2342g.size());
        boolean z = false;
        for (Fragment next : this.f2342g.values()) {
            if (next != null) {
                if (next.mFragmentManager == this) {
                    FragmentState fragmentState = new FragmentState(next);
                    arrayList2.add(fragmentState);
                    if (next.mState <= 0 || fragmentState.f2312m != null) {
                        fragmentState.f2312m = next.mSavedFragmentState;
                    } else {
                        fragmentState.f2312m = mo4876q(next);
                        String str = next.mTargetWho;
                        if (str != null) {
                            Fragment fragment = this.f2342g.get(str);
                            if (fragment != null) {
                                if (fragmentState.f2312m == null) {
                                    fragmentState.f2312m = new Bundle();
                                }
                                mo4810a(fragmentState.f2312m, "android:target_state", fragment);
                                int i = next.mTargetRequestCode;
                                if (i != 0) {
                                    fragmentState.f2312m.putInt("android:target_req_state", i);
                                }
                            } else {
                                m3198a((RuntimeException) new IllegalStateException("Failure saving state: " + next + " has target not in fragment manager: " + next.mTargetWho));
                                throw null;
                            }
                        }
                    }
                    if (f2328H) {
                        "Saved state of " + next + ": " + fragmentState.f2312m;
                    }
                    z = true;
                } else {
                    m3198a((RuntimeException) new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                    throw null;
                }
            }
        }
        if (!z) {
            boolean z2 = f2328H;
            return null;
        }
        int size2 = this.f2341f.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<Fragment> it = this.f2341f.iterator();
            while (it.hasNext()) {
                Fragment next2 = it.next();
                arrayList.add(next2.mWho);
                if (next2.mFragmentManager != this) {
                    m3198a((RuntimeException) new IllegalStateException("Failure saving state: active " + next2 + " was removed from the FragmentManager"));
                    throw null;
                } else if (f2328H) {
                    "saveAllState: adding fragment (" + next2.mWho + "): " + next2;
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<C0908a> arrayList3 = this.f2343h;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.f2343h.get(i2));
                if (f2328H) {
                    "saveAllState: adding back stack #" + i2 + ": " + this.f2343h.get(i2);
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f2295a = arrayList2;
        fragmentManagerState.f2296b = arrayList;
        fragmentManagerState.f2297c = backStackStateArr;
        Fragment fragment2 = this.f2355t;
        if (fragment2 != null) {
            fragmentManagerState.f2298d = fragment2.mWho;
        }
        fragmentManagerState.f2299e = this.f2340e;
        return fragmentManagerState;
    }

    /* renamed from: v */
    private Fragment m3211v(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.f2341f.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.f2341f.get(indexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* renamed from: w */
    private boolean m3212w(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.mo4848e();
    }

    /* renamed from: f */
    public void mo4850f() {
        this.f2357v = false;
        this.f2358w = false;
        m3208d(2);
    }

    /* renamed from: g */
    public void mo4853g() {
        this.f2357v = false;
        this.f2358w = false;
        m3208d(1);
    }

    /* renamed from: m */
    public void mo4866m() {
        this.f2357v = false;
        this.f2358w = false;
        m3208d(4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo4879r(Fragment fragment) {
        if (fragment.mInnerView != null) {
            SparseArray<Parcelable> sparseArray = this.f2334D;
            if (sparseArray == null) {
                this.f2334D = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.f2334D);
            if (this.f2334D.size() > 0) {
                fragment.mSavedViewState = this.f2334D;
                this.f2334D = null;
            }
        }
    }

    /* renamed from: d */
    public void mo4843d(Fragment fragment) {
        if (f2328H) {
            "detach: " + fragment;
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (f2328H) {
                    "remove from detach: " + fragment;
                }
                synchronized (this.f2341f) {
                    this.f2341f.remove(fragment);
                }
                if (m3212w(fragment)) {
                    this.f2356u = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    /* renamed from: androidx.fragment.app.i$g */
    /* compiled from: FragmentManagerImpl */
    private static class C0928g {

        /* renamed from: a */
        public final Animation f2376a;

        /* renamed from: b */
        public final Animator f2377b;

        C0928g(Animation animation) {
            this.f2376a = animation;
            this.f2377b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        C0928g(Animator animator) {
            this.f2376a = null;
            this.f2377b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: u */
    private void m3210u(Fragment fragment) {
        if (fragment != null && this.f2342g.get(fragment.mWho) == fragment) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo4851f(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4851f(fragment, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentStarted(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo4854g(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4854g(fragment, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentStopped(this, fragment);
            }
        }
    }

    /* renamed from: h */
    public void mo4855h() {
        this.f2359x = true;
        mo4877q();
        m3208d(0);
        this.f2352q = null;
        this.f2353r = null;
        this.f2354s = null;
        if (this.f2345j != null) {
            this.f2346k.mo1906c();
            this.f2345j = null;
        }
    }

    /* renamed from: i */
    public void mo4858i() {
        m3208d(1);
    }

    /* renamed from: t */
    public Fragment mo4882t() {
        return this.f2355t;
    }

    /* renamed from: androidx.fragment.app.i$h */
    /* compiled from: FragmentManagerImpl */
    private static class C0929h extends AnimationSet implements Runnable {

        /* renamed from: a */
        private final ViewGroup f2378a;

        /* renamed from: b */
        private final View f2379b;

        /* renamed from: c */
        private boolean f2380c;

        /* renamed from: d */
        private boolean f2381d;

        /* renamed from: e */
        private boolean f2382e = true;

        C0929h(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2378a = viewGroup;
            this.f2379b = view;
            addAnimation(animation);
            this.f2378a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.f2382e = true;
            if (this.f2380c) {
                return !this.f2381d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f2380c = true;
                C0837r.m2676a(this.f2378a, this);
            }
            return true;
        }

        public void run() {
            if (this.f2380c || !this.f2382e) {
                this.f2378a.endViewTransition(this.f2379b);
                this.f2381d = true;
                return;
            }
            this.f2382e = false;
            this.f2378a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f2382e = true;
            if (this.f2380c) {
                return !this.f2381d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f2380c = true;
                C0837r.m2676a(this.f2378a, this);
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo4842c(int i) {
        return this.f2351p >= i;
    }

    /* renamed from: n */
    public void mo4868n() {
        this.f2357v = false;
        this.f2358w = false;
        m3208d(3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo4874p() {
        if (this.f2360y) {
            this.f2360y = false;
            mo4803B();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4839c(Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            C0928g a = mo4806a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (a == null || (animator = a.f2377b) == null) {
                if (a != null) {
                    fragment.mView.startAnimation(a.f2376a);
                    a.f2376a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    ViewGroup viewGroup = fragment.mContainer;
                    View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    a.f2377b.addListener(new C0926e(this, viewGroup, view, fragment));
                }
                a.f2377b.start();
            }
        }
        if (fragment.mAdded && m3212w(fragment)) {
            this.f2356u = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* renamed from: j */
    public void mo4860j() {
        for (int i = 0; i < this.f2341f.size(); i++) {
            Fragment fragment = this.f2341f.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo4847e(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4847e(fragment, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentResumed(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public Bundle mo4876q(Fragment fragment) {
        if (this.f2333C == null) {
            this.f2333C = new Bundle();
        }
        fragment.performSaveInstanceState(this.f2333C);
        mo4844d(fragment, this.f2333C, false);
        Bundle bundle = null;
        if (!this.f2333C.isEmpty()) {
            Bundle bundle2 = this.f2333C;
            this.f2333C = null;
            bundle = bundle2;
        }
        if (fragment.mView != null) {
            mo4879r(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* renamed from: a */
    public C0937k mo4778a() {
        return new C0908a(this);
    }

    /* renamed from: a */
    public void mo4779a(int i, int i2) {
        if (i >= 0) {
            mo4823a((C0932k) new C0933l((String) null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    /* renamed from: k */
    public void mo4862k() {
        m3208d(3);
    }

    /* renamed from: o */
    public void mo4870o() {
        this.f2358w = true;
        m3208d(2);
    }

    /* renamed from: a */
    private boolean m3201a(String str, int i, int i2) {
        mo4877q();
        m3207c(true);
        Fragment fragment = this.f2355t;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().mo4786d()) {
            return true;
        }
        boolean a = mo4827a(this.f2361z, this.f2331A, str, i, i2);
        if (a) {
            this.f2339d = true;
            try {
                m3206c(this.f2361z, this.f2331A);
            } finally {
                m3189E();
            }
        }
        m3192H();
        mo4874p();
        m3187C();
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo4857h(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4857h(fragment, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentViewDestroyed(this, fragment);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: d */
    private void m3208d(int i) {
        try {
            this.f2339d = true;
            mo4808a(i, false);
            this.f2339d = false;
            mo4877q();
        } catch (Throwable th) {
            this.f2339d = false;
            throw th;
        }
    }

    /* renamed from: b */
    public Fragment mo4829b(String str) {
        Fragment findFragmentByWho;
        for (Fragment next : this.f2342g.values()) {
            if (next != null && (findFragmentByWho = next.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* renamed from: b */
    public int mo4828b(C0908a aVar) {
        synchronized (this) {
            if (this.f2348m != null) {
                if (this.f2348m.size() > 0) {
                    int intValue = this.f2348m.remove(this.f2348m.size() - 1).intValue();
                    if (f2328H) {
                        "Adding back stack index " + intValue + " with " + aVar;
                    }
                    this.f2347l.set(intValue, aVar);
                    return intValue;
                }
            }
            if (this.f2347l == null) {
                this.f2347l = new ArrayList<>();
            }
            int size = this.f2347l.size();
            if (f2328H) {
                "Setting back stack index " + size + " to " + aVar;
            }
            this.f2347l.add(aVar);
            return size;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo4848e() {
        boolean z = false;
        for (Fragment next : this.f2342g.values()) {
            if (next != null) {
                z = m3212w(next);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4845d(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4845d(fragment, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentPaused(this, fragment);
            }
        }
    }

    /* renamed from: a */
    public void mo4810a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
            return;
        }
        m3198a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4844d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4844d(fragment, bundle, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentSaveInstanceState(this, fragment, bundle);
            }
        }
    }

    /* renamed from: a */
    public Fragment mo4805a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.f2342g.get(string);
        if (fragment != null) {
            return fragment;
        }
        m3198a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    /* renamed from: b */
    public void mo4830b(int i) {
        synchronized (this) {
            this.f2347l.set(i, (Object) null);
            if (this.f2348m == null) {
                this.f2348m = new ArrayList<>();
            }
            if (f2328H) {
                "Freeing back stack index " + i;
            }
            this.f2348m.add(Integer.valueOf(i));
        }
    }

    /* renamed from: c */
    private void m3207c(boolean z) {
        if (this.f2339d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f2352q == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.f2352q.mo4776d().getLooper()) {
            if (!z) {
                m3188D();
            }
            if (this.f2361z == null) {
                this.f2361z = new ArrayList<>();
                this.f2331A = new ArrayList<>();
            }
            this.f2339d = true;
            try {
                m3199a((ArrayList<C0908a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.f2339d = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo4864l() {
        m3192H();
        m3210u(this.f2355t);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4813a(Fragment fragment) {
        if (mo4887w()) {
            boolean z = f2328H;
        } else if (this.f2336F.mo4904a(fragment) && f2328H) {
            "Updating retained Fragments: Added " + fragment;
        }
    }

    /* renamed from: b */
    public void mo4835b(C0932k kVar, boolean z) {
        if (!z || (this.f2352q != null && !this.f2359x)) {
            m3207c(z);
            if (kVar.mo4674a(this.f2361z, this.f2331A)) {
                this.f2339d = true;
                try {
                    m3206c(this.f2361z, this.f2331A);
                } finally {
                    m3189E();
                }
            }
            m3192H();
            mo4874p();
            m3187C();
        }
    }

    /* renamed from: a */
    public void mo4783a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f2342g.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment next : this.f2342g.values()) {
                printWriter.print(str);
                printWriter.println(next);
                if (next != null) {
                    next.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f2341f.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.f2341f.get(i).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f2344i;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f2344i.get(i2).toString());
            }
        }
        ArrayList<C0908a> arrayList2 = this.f2343h;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                C0908a aVar = this.f2343h.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.mo4671a(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.f2347l != null && (size2 = this.f2347l.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.f2347l.get(i4));
                }
            }
            if (this.f2348m != null && this.f2348m.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f2348m.toArray()));
            }
        }
        ArrayList<C0932k> arrayList3 = this.f2338c;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(this.f2338c.get(i5));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2352q);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2353r);
        if (this.f2354s != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2354s);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2351p);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f2357v);
        printWriter.print(" mStopped=");
        printWriter.print(this.f2358w);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f2359x);
        if (this.f2356u) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f2356u);
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    /* renamed from: c */
    private void m3206c(ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            m3199a(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).f2415p) {
                    if (i2 != i) {
                        m3204b(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).f2415p) {
                            i2++;
                        }
                    }
                    m3204b(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                m3204b(arrayList, arrayList2, i2, size);
            }
        }
    }

    /* renamed from: b */
    private void m3204b(ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        ArrayList<C0908a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i;
        int i6 = i2;
        boolean z = arrayList3.get(i5).f2415p;
        ArrayList<Fragment> arrayList5 = this.f2332B;
        if (arrayList5 == null) {
            this.f2332B = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.f2332B.addAll(this.f2341f);
        Fragment t = mo4882t();
        boolean z2 = false;
        for (int i7 = i5; i7 < i6; i7++) {
            C0908a aVar = arrayList3.get(i7);
            if (!arrayList4.get(i7).booleanValue()) {
                t = aVar.mo4666a(this.f2332B, t);
            } else {
                t = aVar.mo4676b(this.f2332B, t);
            }
            z2 = z2 || aVar.f2407h;
        }
        this.f2332B.clear();
        if (!z) {
            C0939l.m3353a(this, arrayList, arrayList2, i, i2, false);
        }
        m3200a(arrayList, arrayList2, i, i2);
        if (z) {
            C3193b bVar = new C3193b();
            m3197a((C3193b<Fragment>) bVar);
            int a = m3193a(arrayList, arrayList2, i, i2, (C3193b<Fragment>) bVar);
            m3203b((C3193b<Fragment>) bVar);
            i3 = a;
        } else {
            i3 = i6;
        }
        if (i3 != i5 && z) {
            C0939l.m3353a(this, arrayList, arrayList2, i, i3, true);
            mo4808a(this.f2351p, true);
        }
        while (i5 < i6) {
            C0908a aVar2 = arrayList3.get(i5);
            if (arrayList4.get(i5).booleanValue() && (i4 = aVar2.f2316t) >= 0) {
                mo4830b(i4);
                aVar2.f2316t = -1;
            }
            aVar2.mo4683h();
            i5++;
        }
        if (z2) {
            mo4889y();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4840c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4840c(fragment, bundle, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentPreCreated(this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4841c(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4841c(fragment, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentDetached(this, fragment);
            }
        }
    }

    /* renamed from: b */
    private void m3203b(C3193b<Fragment> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            Fragment f = bVar.mo18694f(i);
            if (!f.mAdded) {
                View requireView = f.requireView();
                f.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return false;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3205b(java.util.ArrayList<androidx.fragment.app.C0908a> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<androidx.fragment.app.i$k> r0 = r4.f2338c     // Catch:{ all -> 0x003c }
            r1 = 0
            if (r0 == 0) goto L_0x003a
            java.util.ArrayList<androidx.fragment.app.i$k> r0 = r4.f2338c     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            java.util.ArrayList<androidx.fragment.app.i$k> r0 = r4.f2338c     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            r2 = 0
        L_0x0016:
            if (r1 >= r0) goto L_0x0028
            java.util.ArrayList<androidx.fragment.app.i$k> r3 = r4.f2338c     // Catch:{ all -> 0x003c }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x003c }
            androidx.fragment.app.i$k r3 = (androidx.fragment.app.C0920i.C0932k) r3     // Catch:{ all -> 0x003c }
            boolean r3 = r3.mo4674a(r5, r6)     // Catch:{ all -> 0x003c }
            r2 = r2 | r3
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0028:
            java.util.ArrayList<androidx.fragment.app.i$k> r5 = r4.f2338c     // Catch:{ all -> 0x003c }
            r5.clear()     // Catch:{ all -> 0x003c }
            androidx.fragment.app.g r5 = r4.f2352q     // Catch:{ all -> 0x003c }
            android.os.Handler r5 = r5.mo4776d()     // Catch:{ all -> 0x003c }
            java.lang.Runnable r6 = r4.f2337G     // Catch:{ all -> 0x003c }
            r5.removeCallbacks(r6)     // Catch:{ all -> 0x003c }
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003a:
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r1
        L_0x003c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            goto L_0x0040
        L_0x003f:
            throw r5
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0920i.m3205b(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    /* renamed from: b */
    public void mo4836b(boolean z) {
        for (int size = this.f2341f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2341f.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* renamed from: b */
    public boolean mo4837b(Menu menu) {
        if (this.f2351p < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f2341f.size(); i++) {
            Fragment fragment = this.f2341f.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    public boolean mo4838b(MenuItem menuItem) {
        if (this.f2351p < 1) {
            return false;
        }
        for (int i = 0; i < this.f2341f.size(); i++) {
            Fragment fragment = this.f2341f.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static C0928g m3195a(float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f2329I);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f2330J);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new C0928g((Animation) animationSet);
    }

    /* renamed from: b */
    public C0915f mo4784b() {
        if (super.mo4784b() == C0917h.f2326b) {
            Fragment fragment = this.f2354s;
            if (fragment != null) {
                return fragment.mFragmentManager.mo4784b();
            }
            mo4780a((C0915f) new C0927f());
        }
        return super.mo4784b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4832b(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4832b(fragment, context, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentPreAttached(this, fragment, context);
            }
        }
    }

    /* renamed from: a */
    static C0928g m3194a(float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f2330J);
        alphaAnimation.setDuration(220);
        return new C0928g((Animation) alphaAnimation);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0928g mo4806a(Fragment fragment, int i, boolean z, int i2) {
        int b;
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
        if (onCreateAnimation != null) {
            return new C0928g(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(i, z, nextAnim);
        if (onCreateAnimator != null) {
            return new C0928g(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(this.f2352q.mo4775c().getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f2352q.mo4775c(), nextAnim);
                    if (loadAnimation != null) {
                        return new C0928g(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.f2352q.mo4775c(), nextAnim);
                    if (loadAnimator != null) {
                        return new C0928g(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f2352q.mo4775c(), nextAnim);
                        if (loadAnimation2 != null) {
                            return new C0928g(loadAnimation2);
                        }
                    } else {
                        throw e2;
                    }
                }
            }
        }
        if (i == 0 || (b = m3202b(i, z)) < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return m3195a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return m3195a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return m3195a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return m3195a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return m3194a(0.0f, 1.0f);
            case 6:
                return m3194a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f2352q.mo4746h()) {
                    i2 = this.f2352q.mo4745g();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4833b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4833b(fragment, bundle, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentCreated(this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4834b(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4834b(fragment, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentDestroyed(this, fragment);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: int} */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0082, code lost:
        if (r0 != 3) goto L_0x04a4;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04a9  */
    /* JADX WARNING: Removed duplicated region for block: B:261:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4814a(androidx.fragment.app.Fragment r18, int r19, int r20, int r21, boolean r22) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r7.mAdded
            r8 = 1
            if (r0 == 0) goto L_0x0011
            boolean r0 = r7.mDetached
            if (r0 == 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0 = r19
            goto L_0x0016
        L_0x0011:
            r0 = r19
            if (r0 <= r8) goto L_0x0016
            r0 = 1
        L_0x0016:
            boolean r1 = r7.mRemoving
            if (r1 == 0) goto L_0x002a
            int r1 = r7.mState
            if (r0 <= r1) goto L_0x002a
            if (r1 != 0) goto L_0x0028
            boolean r0 = r18.isInBackStack()
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x002a
        L_0x0028:
            int r0 = r7.mState
        L_0x002a:
            boolean r1 = r7.mDeferStart
            r9 = 3
            r10 = 2
            if (r1 == 0) goto L_0x0037
            int r1 = r7.mState
            if (r1 >= r9) goto L_0x0037
            if (r0 <= r10) goto L_0x0037
            r0 = 2
        L_0x0037:
            androidx.lifecycle.e$b r1 = r7.mMaxState
            androidx.lifecycle.e$b r2 = androidx.lifecycle.C0965e.C0967b.CREATED
            if (r1 != r2) goto L_0x0042
            int r0 = java.lang.Math.min(r0, r8)
            goto L_0x004a
        L_0x0042:
            int r1 = r1.ordinal()
            int r0 = java.lang.Math.min(r0, r1)
        L_0x004a:
            r11 = r0
            int r0 = r7.mState
            r12 = 0
            r13 = 0
            if (r0 > r11) goto L_0x0305
            boolean r0 = r7.mFromLayout
            if (r0 == 0) goto L_0x005a
            boolean r0 = r7.mInLayout
            if (r0 != 0) goto L_0x005a
            return
        L_0x005a:
            android.view.View r0 = r18.getAnimatingAway()
            if (r0 != 0) goto L_0x0066
            android.animation.Animator r0 = r18.getAnimator()
            if (r0 == 0) goto L_0x007a
        L_0x0066:
            r7.setAnimatingAway(r13)
            r7.setAnimator(r13)
            int r2 = r18.getStateAfterAnimating()
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r17
            r1 = r18
            r0.mo4814a((androidx.fragment.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
        L_0x007a:
            int r0 = r7.mState
            if (r0 == 0) goto L_0x0089
            if (r0 == r8) goto L_0x01d5
            if (r0 == r10) goto L_0x02c5
            if (r0 == r9) goto L_0x0086
            goto L_0x04a4
        L_0x0086:
            r0 = 3
            goto L_0x02e3
        L_0x0089:
            if (r11 <= 0) goto L_0x01d5
            boolean r0 = f2328H
            if (r0 == 0) goto L_0x009f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto CREATED: "
            r0.append(r1)
            r0.append(r7)
            r0.toString()
        L_0x009f:
            android.os.Bundle r0 = r7.mSavedFragmentState
            if (r0 == 0) goto L_0x00f6
            androidx.fragment.app.g r1 = r6.f2352q
            android.content.Context r1 = r1.mo4775c()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r7.mSavedViewState = r0
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_state"
            androidx.fragment.app.Fragment r0 = r6.mo4805a((android.os.Bundle) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = r0.mWho
            goto L_0x00c8
        L_0x00c7:
            r0 = r13
        L_0x00c8:
            r7.mTargetWho = r0
            if (r0 == 0) goto L_0x00d6
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r12)
            r7.mTargetRequestCode = r0
        L_0x00d6:
            java.lang.Boolean r0 = r7.mSavedUserVisibleHint
            if (r0 == 0) goto L_0x00e3
            boolean r0 = r0.booleanValue()
            r7.mUserVisibleHint = r0
            r7.mSavedUserVisibleHint = r13
            goto L_0x00ed
        L_0x00e3:
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r8)
            r7.mUserVisibleHint = r0
        L_0x00ed:
            boolean r0 = r7.mUserVisibleHint
            if (r0 != 0) goto L_0x00f6
            r7.mDeferStart = r8
            if (r11 <= r10) goto L_0x00f6
            r11 = 2
        L_0x00f6:
            androidx.fragment.app.g r0 = r6.f2352q
            r7.mHost = r0
            androidx.fragment.app.Fragment r1 = r6.f2354s
            r7.mParentFragment = r1
            if (r1 == 0) goto L_0x0103
            androidx.fragment.app.i r0 = r1.mChildFragmentManager
            goto L_0x0105
        L_0x0103:
            androidx.fragment.app.i r0 = r0.f2325e
        L_0x0105:
            r7.mFragmentManager = r0
            androidx.fragment.app.Fragment r0 = r7.mTarget
            java.lang.String r14 = " that does not belong to this FragmentManager!"
            java.lang.String r15 = " declared target fragment "
            java.lang.String r5 = "Fragment "
            if (r0 == 0) goto L_0x015a
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r1 = r6.f2342g
            java.lang.String r0 = r0.mWho
            java.lang.Object r0 = r1.get(r0)
            androidx.fragment.app.Fragment r1 = r7.mTarget
            if (r0 != r1) goto L_0x0139
            int r0 = r1.mState
            if (r0 >= r8) goto L_0x012f
            r2 = 1
            r3 = 0
            r4 = 0
            r16 = 1
            r0 = r17
            r9 = r5
            r5 = r16
            r0.mo4814a((androidx.fragment.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
            goto L_0x0130
        L_0x012f:
            r9 = r5
        L_0x0130:
            androidx.fragment.app.Fragment r0 = r7.mTarget
            java.lang.String r0 = r0.mWho
            r7.mTargetWho = r0
            r7.mTarget = r13
            goto L_0x015b
        L_0x0139:
            r9 = r5
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r7)
            r1.append(r15)
            androidx.fragment.app.Fragment r2 = r7.mTarget
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x015a:
            r9 = r5
        L_0x015b:
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x0198
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r1 = r6.f2342g
            java.lang.Object r0 = r1.get(r0)
            r1 = r0
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            if (r1 == 0) goto L_0x0178
            int r0 = r1.mState
            if (r0 >= r8) goto L_0x0198
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r17
            r0.mo4814a((androidx.fragment.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
            goto L_0x0198
        L_0x0178:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r7)
            r1.append(r15)
            java.lang.String r2 = r7.mTargetWho
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0198:
            androidx.fragment.app.g r0 = r6.f2352q
            android.content.Context r0 = r0.mo4775c()
            r6.mo4832b((androidx.fragment.app.Fragment) r7, (android.content.Context) r0, (boolean) r12)
            r18.performAttach()
            androidx.fragment.app.Fragment r0 = r7.mParentFragment
            if (r0 != 0) goto L_0x01ae
            androidx.fragment.app.g r0 = r6.f2352q
            r0.mo4736a((androidx.fragment.app.Fragment) r7)
            goto L_0x01b1
        L_0x01ae:
            r0.onAttachFragment(r7)
        L_0x01b1:
            androidx.fragment.app.g r0 = r6.f2352q
            android.content.Context r0 = r0.mo4775c()
            r6.mo4815a((androidx.fragment.app.Fragment) r7, (android.content.Context) r0, (boolean) r12)
            boolean r0 = r7.mIsCreated
            if (r0 != 0) goto L_0x01ce
            android.os.Bundle r0 = r7.mSavedFragmentState
            r6.mo4840c(r7, r0, r12)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.performCreate(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r6.mo4833b((androidx.fragment.app.Fragment) r7, (android.os.Bundle) r0, (boolean) r12)
            goto L_0x01d5
        L_0x01ce:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.restoreChildFragmentState(r0)
            r7.mState = r8
        L_0x01d5:
            if (r11 <= 0) goto L_0x01da
            r17.mo4846e((androidx.fragment.app.Fragment) r18)
        L_0x01da:
            if (r11 <= r8) goto L_0x02c5
            boolean r0 = f2328H
            if (r0 == 0) goto L_0x01f0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            r0.toString()
        L_0x01f0:
            boolean r0 = r7.mFromLayout
            if (r0 != 0) goto L_0x02b0
            int r0 = r7.mContainerId
            if (r0 == 0) goto L_0x0266
            r1 = -1
            if (r0 == r1) goto L_0x0247
            androidx.fragment.app.d r1 = r6.f2353r
            android.view.View r0 = r1.mo4650a(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0267
            boolean r1 = r7.mRestored
            if (r1 == 0) goto L_0x020a
            goto L_0x0267
        L_0x020a:
            android.content.res.Resources r0 = r18.getResources()     // Catch:{ NotFoundException -> 0x0215 }
            int r1 = r7.mContainerId     // Catch:{ NotFoundException -> 0x0215 }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x0215 }
            goto L_0x0217
        L_0x0215:
            java.lang.String r0 = "unknown"
        L_0x0217:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            int r3 = r7.mContainerId
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            r6.m3198a((java.lang.RuntimeException) r1)
            throw r13
        L_0x0247:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r6.m3198a((java.lang.RuntimeException) r0)
            throw r13
        L_0x0266:
            r0 = r13
        L_0x0267:
            r7.mContainer = r0
            android.os.Bundle r1 = r7.mSavedFragmentState
            android.view.LayoutInflater r1 = r7.performGetLayoutInflater(r1)
            android.os.Bundle r2 = r7.mSavedFragmentState
            r7.performCreateView(r1, r0, r2)
            android.view.View r1 = r7.mView
            if (r1 == 0) goto L_0x02ae
            r7.mInnerView = r1
            r1.setSaveFromParentEnabled(r12)
            if (r0 == 0) goto L_0x0284
            android.view.View r1 = r7.mView
            r0.addView(r1)
        L_0x0284:
            boolean r0 = r7.mHidden
            if (r0 == 0) goto L_0x028f
            android.view.View r0 = r7.mView
            r1 = 8
            r0.setVisibility(r1)
        L_0x028f:
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r7.onViewCreated(r0, r1)
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r6.mo4817a((androidx.fragment.app.Fragment) r7, (android.view.View) r0, (android.os.Bundle) r1, (boolean) r12)
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x02aa
            android.view.ViewGroup r0 = r7.mContainer
            if (r0 == 0) goto L_0x02aa
            goto L_0x02ab
        L_0x02aa:
            r8 = 0
        L_0x02ab:
            r7.mIsNewlyAdded = r8
            goto L_0x02b0
        L_0x02ae:
            r7.mInnerView = r13
        L_0x02b0:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.performActivityCreated(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r6.mo4816a((androidx.fragment.app.Fragment) r7, (android.os.Bundle) r0, (boolean) r12)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x02c3
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.restoreViewState(r0)
        L_0x02c3:
            r7.mSavedFragmentState = r13
        L_0x02c5:
            if (r11 <= r10) goto L_0x0086
            boolean r0 = f2328H
            if (r0 == 0) goto L_0x02db
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto STARTED: "
            r0.append(r1)
            r0.append(r7)
            r0.toString()
        L_0x02db:
            r18.performStart()
            r6.mo4851f(r7, r12)
            goto L_0x0086
        L_0x02e3:
            if (r11 <= r0) goto L_0x04a4
            boolean r0 = f2328H
            if (r0 == 0) goto L_0x02f9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto RESUMED: "
            r0.append(r1)
            r0.append(r7)
            r0.toString()
        L_0x02f9:
            r18.performResume()
            r6.mo4847e(r7, r12)
            r7.mSavedFragmentState = r13
            r7.mSavedViewState = r13
            goto L_0x04a4
        L_0x0305:
            if (r0 <= r11) goto L_0x04a4
            if (r0 == r8) goto L_0x03d7
            if (r0 == r10) goto L_0x034c
            r1 = 3
            if (r0 == r1) goto L_0x032f
            r1 = 4
            if (r0 == r1) goto L_0x0313
            goto L_0x04a4
        L_0x0313:
            if (r11 >= r1) goto L_0x032f
            boolean r0 = f2328H
            if (r0 == 0) goto L_0x0329
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom RESUMED: "
            r0.append(r1)
            r0.append(r7)
            r0.toString()
        L_0x0329:
            r18.performPause()
            r6.mo4845d(r7, r12)
        L_0x032f:
            r0 = 3
            if (r11 >= r0) goto L_0x034c
            boolean r0 = f2328H
            if (r0 == 0) goto L_0x0346
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom STARTED: "
            r0.append(r1)
            r0.append(r7)
            r0.toString()
        L_0x0346:
            r18.performStop()
            r6.mo4854g(r7, r12)
        L_0x034c:
            if (r11 >= r10) goto L_0x03d7
            boolean r0 = f2328H
            if (r0 == 0) goto L_0x0362
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            r0.toString()
        L_0x0362:
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x0375
            androidx.fragment.app.g r0 = r6.f2352q
            boolean r0 = r0.mo4742b(r7)
            if (r0 == 0) goto L_0x0375
            android.util.SparseArray<android.os.Parcelable> r0 = r7.mSavedViewState
            if (r0 != 0) goto L_0x0375
            r17.mo4879r(r18)
        L_0x0375:
            r18.performDestroyView()
            r6.mo4857h(r7, r12)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x03c8
            android.view.ViewGroup r1 = r7.mContainer
            if (r1 == 0) goto L_0x03c8
            r1.endViewTransition(r0)
            android.view.View r0 = r7.mView
            r0.clearAnimation()
            androidx.fragment.app.Fragment r0 = r18.getParentFragment()
            if (r0 == 0) goto L_0x0399
            androidx.fragment.app.Fragment r0 = r18.getParentFragment()
            boolean r0 = r0.mRemoving
            if (r0 != 0) goto L_0x03c8
        L_0x0399:
            int r0 = r6.f2351p
            r1 = 0
            if (r0 <= 0) goto L_0x03b9
            boolean r0 = r6.f2359x
            if (r0 != 0) goto L_0x03b9
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x03b9
            float r0 = r7.mPostponedAlpha
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x03b9
            r0 = r20
            r2 = r21
            androidx.fragment.app.i$g r0 = r6.mo4806a((androidx.fragment.app.Fragment) r7, (int) r0, (boolean) r12, (int) r2)
            goto L_0x03ba
        L_0x03b9:
            r0 = r13
        L_0x03ba:
            r7.mPostponedAlpha = r1
            if (r0 == 0) goto L_0x03c1
            r6.m3196a((androidx.fragment.app.Fragment) r7, (androidx.fragment.app.C0920i.C0928g) r0, (int) r11)
        L_0x03c1:
            android.view.ViewGroup r0 = r7.mContainer
            android.view.View r1 = r7.mView
            r0.removeView(r1)
        L_0x03c8:
            r7.mContainer = r13
            r7.mView = r13
            r7.mViewLifecycleOwner = r13
            androidx.lifecycle.m<androidx.lifecycle.h> r0 = r7.mViewLifecycleOwnerLiveData
            r0.mo4973b(r13)
            r7.mInnerView = r13
            r7.mInLayout = r12
        L_0x03d7:
            if (r11 >= r8) goto L_0x04a4
            boolean r0 = r6.f2359x
            if (r0 == 0) goto L_0x03fe
            android.view.View r0 = r18.getAnimatingAway()
            if (r0 == 0) goto L_0x03ee
            android.view.View r0 = r18.getAnimatingAway()
            r7.setAnimatingAway(r13)
            r0.clearAnimation()
            goto L_0x03fe
        L_0x03ee:
            android.animation.Animator r0 = r18.getAnimator()
            if (r0 == 0) goto L_0x03fe
            android.animation.Animator r0 = r18.getAnimator()
            r7.setAnimator(r13)
            r0.cancel()
        L_0x03fe:
            android.view.View r0 = r18.getAnimatingAway()
            if (r0 != 0) goto L_0x04a0
            android.animation.Animator r0 = r18.getAnimator()
            if (r0 == 0) goto L_0x040c
            goto L_0x04a0
        L_0x040c:
            boolean r0 = f2328H
            if (r0 == 0) goto L_0x0420
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom CREATED: "
            r0.append(r1)
            r0.append(r7)
            r0.toString()
        L_0x0420:
            boolean r0 = r7.mRemoving
            if (r0 == 0) goto L_0x042c
            boolean r0 = r18.isInBackStack()
            if (r0 != 0) goto L_0x042c
            r0 = 1
            goto L_0x042d
        L_0x042c:
            r0 = 0
        L_0x042d:
            if (r0 != 0) goto L_0x043b
            androidx.fragment.app.j r1 = r6.f2336F
            boolean r1 = r1.mo4913f(r7)
            if (r1 == 0) goto L_0x0438
            goto L_0x043b
        L_0x0438:
            r7.mState = r12
            goto L_0x046c
        L_0x043b:
            androidx.fragment.app.g r1 = r6.f2352q
            boolean r2 = r1 instanceof androidx.lifecycle.C0987t
            if (r2 == 0) goto L_0x0448
            androidx.fragment.app.j r1 = r6.f2336F
            boolean r8 = r1.mo4910d()
            goto L_0x045d
        L_0x0448:
            android.content.Context r1 = r1.mo4775c()
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 == 0) goto L_0x045d
            androidx.fragment.app.g r1 = r6.f2352q
            android.content.Context r1 = r1.mo4775c()
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r1 = r1.isChangingConfigurations()
            r8 = r8 ^ r1
        L_0x045d:
            if (r0 != 0) goto L_0x0461
            if (r8 == 0) goto L_0x0466
        L_0x0461:
            androidx.fragment.app.j r1 = r6.f2336F
            r1.mo4906b(r7)
        L_0x0466:
            r18.performDestroy()
            r6.mo4834b((androidx.fragment.app.Fragment) r7, (boolean) r12)
        L_0x046c:
            r18.performDetach()
            r6.mo4841c((androidx.fragment.app.Fragment) r7, (boolean) r12)
            if (r22 != 0) goto L_0x04a4
            if (r0 != 0) goto L_0x049c
            androidx.fragment.app.j r0 = r6.f2336F
            boolean r0 = r0.mo4913f(r7)
            if (r0 == 0) goto L_0x047f
            goto L_0x049c
        L_0x047f:
            r7.mHost = r13
            r7.mParentFragment = r13
            r7.mFragmentManager = r13
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x04a4
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r1 = r6.f2342g
            java.lang.Object r0 = r1.get(r0)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            if (r0 == 0) goto L_0x04a4
            boolean r1 = r0.getRetainInstance()
            if (r1 == 0) goto L_0x04a4
            r7.mTarget = r0
            goto L_0x04a4
        L_0x049c:
            r17.mo4863k(r18)
            goto L_0x04a4
        L_0x04a0:
            r7.setStateAfterAnimating(r11)
            goto L_0x04a5
        L_0x04a4:
            r8 = r11
        L_0x04a5:
            int r0 = r7.mState
            if (r0 == r8) goto L_0x04d3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r7.mState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FragmentManager"
            android.util.Log.w(r1, r0)
            r7.mState = r8
        L_0x04d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0920i.mo4814a(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    /* renamed from: a */
    private void m3196a(Fragment fragment, C0928g gVar, int i) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i);
        if (gVar.f2376a != null) {
            C0929h hVar = new C0929h(gVar.f2376a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            hVar.setAnimationListener(new C0923c(viewGroup, fragment));
            fragment.mView.startAnimation(hVar);
            return;
        }
        Animator animator = gVar.f2377b;
        fragment.setAnimator(animator);
        animator.addListener(new C0925d(viewGroup, view, fragment));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4808a(int i, boolean z) {
        C0916g gVar;
        if (this.f2352q == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.f2351p) {
            this.f2351p = i;
            int size = this.f2341f.size();
            for (int i2 = 0; i2 < size; i2++) {
                mo4865l(this.f2341f.get(i2));
            }
            for (Fragment next : this.f2342g.values()) {
                if (next != null && ((next.mRemoving || next.mDetached) && !next.mIsNewlyAdded)) {
                    mo4865l(next);
                }
            }
            mo4803B();
            if (this.f2356u && (gVar = this.f2352q) != null && this.f2351p == 4) {
                gVar.mo4747i();
                this.f2356u = false;
            }
        }
    }

    /* renamed from: a */
    public void mo4819a(Fragment fragment, boolean z) {
        if (f2328H) {
            "add: " + fragment;
        }
        mo4861j(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (!this.f2341f.contains(fragment)) {
            synchronized (this.f2341f) {
                this.f2341f.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (m3212w(fragment)) {
                this.f2356u = true;
            }
            if (z) {
                mo4867m(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* renamed from: a */
    public Fragment mo4804a(int i) {
        for (int size = this.f2341f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2341f.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (Fragment next : this.f2342g.values()) {
            if (next != null && next.mFragmentId == i) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public Fragment mo4777a(String str) {
        if (str != null) {
            for (int size = this.f2341f.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f2341f.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment next : this.f2342g.values()) {
            if (next != null && str.equals(next.mTag)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo4823a(C0932k kVar, boolean z) {
        if (!z) {
            m3188D();
        }
        synchronized (this) {
            if (!this.f2359x) {
                if (this.f2352q != null) {
                    if (this.f2338c == null) {
                        this.f2338c = new ArrayList<>();
                    }
                    this.f2338c.add(kVar);
                    mo4802A();
                    return;
                }
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* renamed from: a */
    public void mo4807a(int i, C0908a aVar) {
        synchronized (this) {
            if (this.f2347l == null) {
                this.f2347l = new ArrayList<>();
            }
            int size = this.f2347l.size();
            if (i < size) {
                if (f2328H) {
                    "Setting back stack index " + i + " to " + aVar;
                }
                this.f2347l.set(i, aVar);
            } else {
                while (size < i) {
                    this.f2347l.add((Object) null);
                    if (this.f2348m == null) {
                        this.f2348m = new ArrayList<>();
                    }
                    if (f2328H) {
                        "Adding available back stack index " + size;
                    }
                    this.f2348m.add(Integer.valueOf(size));
                    size++;
                }
                if (f2328H) {
                    "Adding back stack index " + i + " with " + aVar;
                }
                this.f2347l.add(aVar);
            }
        }
    }

    /* renamed from: a */
    private void m3199a(ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<C0934m> arrayList3 = this.f2335E;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            C0934m mVar = this.f2335E.get(i);
            if (arrayList != null && !mVar.f2390a && (indexOf2 = arrayList.indexOf(mVar.f2391b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                this.f2335E.remove(i);
                i--;
                size--;
                mVar.mo4901c();
            } else if (mVar.mo4903e() || (arrayList != null && mVar.f2391b.mo4673a(arrayList, 0, arrayList.size()))) {
                this.f2335E.remove(i);
                i--;
                size--;
                if (arrayList == null || mVar.f2390a || (indexOf = arrayList.indexOf(mVar.f2391b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                    mVar.mo4902d();
                } else {
                    mVar.mo4901c();
                }
            }
            i++;
        }
    }

    /* renamed from: a */
    private int m3193a(ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, C3193b<Fragment> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            C0908a aVar = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.mo4682g() && !aVar.mo4673a(arrayList, i4 + 1, i2)) {
                if (this.f2335E == null) {
                    this.f2335E = new ArrayList<>();
                }
                C0934m mVar = new C0934m(aVar, booleanValue);
                this.f2335E.add(mVar);
                aVar.mo4670a((Fragment.C0905e) mVar);
                if (booleanValue) {
                    aVar.mo4680e();
                } else {
                    aVar.mo4677b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                m3197a(bVar);
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4821a(C0908a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.mo4677b(z3);
        } else {
            aVar.mo4680e();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            C0939l.m3353a(this, (ArrayList<C0908a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            mo4808a(this.f2351p, true);
        }
        for (Fragment next : this.f2342g.values()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && aVar.mo4678b(next.mContainerId)) {
                float f = next.mPostponedAlpha;
                if (f > 0.0f) {
                    next.mView.setAlpha(f);
                }
                if (z3) {
                    next.mPostponedAlpha = 0.0f;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* renamed from: a */
    private static void m3200a(ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C0908a aVar = arrayList.get(i);
            boolean z = true;
            if (arrayList2.get(i).booleanValue()) {
                aVar.mo4668a(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                aVar.mo4677b(z);
            } else {
                aVar.mo4668a(1);
                aVar.mo4680e();
            }
            i++;
        }
    }

    /* renamed from: a */
    private void m3197a(C3193b<Fragment> bVar) {
        int i = this.f2351p;
        if (i >= 1) {
            int min = Math.min(i, 3);
            int size = this.f2341f.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.f2341f.get(i2);
                if (fragment.mState < min) {
                    mo4814a(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        bVar.add(fragment);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4820a(C0908a aVar) {
        if (this.f2343h == null) {
            this.f2343h = new ArrayList<>();
        }
        this.f2343h.add(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4827a(ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList<C0908a> arrayList3 = this.f2343h;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2343h.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                int size2 = this.f2343h.size() - 1;
                while (size2 >= 0) {
                    C0908a aVar = this.f2343h.get(size2);
                    if ((str != null && str.equals(aVar.mo4681f())) || (i >= 0 && i == aVar.f2316t)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        C0908a aVar2 = this.f2343h.get(size2);
                        if ((str == null || !str.equals(aVar2.mo4681f())) && (i < 0 || i != aVar2.f2316t)) {
                            break;
                        }
                    }
                }
                i3 = size2;
            } else {
                i3 = -1;
            }
            if (i3 == this.f2343h.size() - 1) {
                return false;
            }
            for (int size3 = this.f2343h.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f2343h.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4811a(Parcelable parcelable) {
        FragmentState fragmentState;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f2295a != null) {
                for (Fragment next : this.f2336F.mo4908c()) {
                    if (f2328H) {
                        "restoreSaveState: re-attaching retained " + next;
                    }
                    Iterator<FragmentState> it = fragmentManagerState.f2295a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            fragmentState = null;
                            break;
                        }
                        fragmentState = it.next();
                        if (fragmentState.f2301b.equals(next.mWho)) {
                            break;
                        }
                    }
                    if (fragmentState == null) {
                        if (f2328H) {
                            "Discarding retained Fragment " + next + " that was not found in the set of active Fragments " + fragmentManagerState.f2295a;
                        }
                        Fragment fragment = next;
                        mo4814a(fragment, 1, 0, 0, false);
                        next.mRemoving = true;
                        mo4814a(fragment, 0, 0, 0, false);
                    } else {
                        fragmentState.f2313n = next;
                        next.mSavedViewState = null;
                        next.mBackStackNesting = 0;
                        next.mInLayout = false;
                        next.mAdded = false;
                        Fragment fragment2 = next.mTarget;
                        next.mTargetWho = fragment2 != null ? fragment2.mWho : null;
                        next.mTarget = null;
                        Bundle bundle = fragmentState.f2312m;
                        if (bundle != null) {
                            bundle.setClassLoader(this.f2352q.mo4775c().getClassLoader());
                            next.mSavedViewState = fragmentState.f2312m.getSparseParcelableArray("android:view_state");
                            next.mSavedFragmentState = fragmentState.f2312m;
                        }
                    }
                }
                this.f2342g.clear();
                Iterator<FragmentState> it2 = fragmentManagerState.f2295a.iterator();
                while (it2.hasNext()) {
                    FragmentState next2 = it2.next();
                    if (next2 != null) {
                        Fragment a = next2.mo4658a(this.f2352q.mo4775c().getClassLoader(), mo4784b());
                        a.mFragmentManager = this;
                        if (f2328H) {
                            "restoreSaveState: active (" + a.mWho + "): " + a;
                        }
                        this.f2342g.put(a.mWho, a);
                        next2.f2313n = null;
                    }
                }
                this.f2341f.clear();
                ArrayList<String> arrayList = fragmentManagerState.f2296b;
                if (arrayList != null) {
                    Iterator<String> it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        String next3 = it3.next();
                        Fragment fragment3 = this.f2342g.get(next3);
                        if (fragment3 != null) {
                            fragment3.mAdded = true;
                            if (f2328H) {
                                "restoreSaveState: added (" + next3 + "): " + fragment3;
                            }
                            if (!this.f2341f.contains(fragment3)) {
                                synchronized (this.f2341f) {
                                    this.f2341f.add(fragment3);
                                }
                            } else {
                                throw new IllegalStateException("Already added " + fragment3);
                            }
                        } else {
                            m3198a((RuntimeException) new IllegalStateException("No instantiated fragment for (" + next3 + ")"));
                            throw null;
                        }
                    }
                }
                if (fragmentManagerState.f2297c != null) {
                    this.f2343h = new ArrayList<>(fragmentManagerState.f2297c.length);
                    int i = 0;
                    while (true) {
                        BackStackState[] backStackStateArr = fragmentManagerState.f2297c;
                        if (i >= backStackStateArr.length) {
                            break;
                        }
                        C0908a a2 = backStackStateArr[i].mo4474a(this);
                        if (f2328H) {
                            "restoreAllState: back stack #" + i + " (index " + a2.f2316t + "): " + a2;
                            PrintWriter printWriter = new PrintWriter(new C0789b("FragmentManager"));
                            a2.mo4672a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f2343h.add(a2);
                        int i2 = a2.f2316t;
                        if (i2 >= 0) {
                            mo4807a(i2, a2);
                        }
                        i++;
                    }
                } else {
                    this.f2343h = null;
                }
                String str = fragmentManagerState.f2298d;
                if (str != null) {
                    Fragment fragment4 = this.f2342g.get(str);
                    this.f2355t = fragment4;
                    m3210u(fragment4);
                }
                this.f2340e = fragmentManagerState.f2299e;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: androidx.activity.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: androidx.fragment.app.Fragment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4822a(androidx.fragment.app.C0916g r3, androidx.fragment.app.C0913d r4, androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.g r0 = r2.f2352q
            if (r0 != 0) goto L_0x004b
            r2.f2352q = r3
            r2.f2353r = r4
            r2.f2354s = r5
            if (r5 == 0) goto L_0x000f
            r2.m3192H()
        L_0x000f:
            boolean r4 = r3 instanceof androidx.activity.C0382c
            if (r4 == 0) goto L_0x0026
            r4 = r3
            androidx.activity.c r4 = (androidx.activity.C0382c) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f2345j = r0
            if (r5 == 0) goto L_0x001f
            r4 = r5
        L_0x001f:
            androidx.activity.OnBackPressedDispatcher r0 = r2.f2345j
            androidx.activity.b r1 = r2.f2346k
            r0.mo1899a(r4, r1)
        L_0x0026:
            if (r5 == 0) goto L_0x0031
            androidx.fragment.app.i r3 = r5.mFragmentManager
            androidx.fragment.app.j r3 = r3.mo4849f(r5)
            r2.f2336F = r3
            goto L_0x004a
        L_0x0031:
            boolean r4 = r3 instanceof androidx.lifecycle.C0987t
            if (r4 == 0) goto L_0x0042
            androidx.lifecycle.t r3 = (androidx.lifecycle.C0987t) r3
            androidx.lifecycle.s r3 = r3.getViewModelStore()
            androidx.fragment.app.j r3 = androidx.fragment.app.C0935j.m3317a((androidx.lifecycle.C0986s) r3)
            r2.f2336F = r3
            goto L_0x004a
        L_0x0042:
            androidx.fragment.app.j r3 = new androidx.fragment.app.j
            r4 = 0
            r3.<init>(r4)
            r2.f2336F = r3
        L_0x004a:
            return
        L_0x004b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0920i.mo4822a(androidx.fragment.app.g, androidx.fragment.app.d, androidx.fragment.app.Fragment):void");
    }

    /* renamed from: a */
    public void mo4824a(boolean z) {
        for (int size = this.f2341f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f2341f.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    /* renamed from: a */
    public void mo4809a(Configuration configuration) {
        for (int i = 0; i < this.f2341f.size(); i++) {
            Fragment fragment = this.f2341f.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    /* renamed from: a */
    public boolean mo4825a(Menu menu, MenuInflater menuInflater) {
        if (this.f2351p < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f2341f.size(); i++) {
            Fragment fragment = this.f2341f.get(i);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f2344i != null) {
            for (int i2 = 0; i2 < this.f2344i.size(); i2++) {
                Fragment fragment2 = this.f2344i.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2344i = arrayList;
        return z;
    }

    /* renamed from: a */
    public boolean mo4826a(MenuItem menuItem) {
        if (this.f2351p < 1) {
            return false;
        }
        for (int i = 0; i < this.f2341f.size(); i++) {
            Fragment fragment = this.f2341f.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo4812a(Menu menu) {
        if (this.f2351p >= 1) {
            for (int i = 0; i < this.f2341f.size(); i++) {
                Fragment fragment = this.f2341f.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4818a(Fragment fragment, C0965e.C0967b bVar) {
        if (this.f2342g.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this)) {
            fragment.mMaxState = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: a */
    public void mo4782a(C0917h.C0918a aVar, boolean z) {
        this.f2350o.add(new C0930i(aVar, z));
    }

    /* renamed from: a */
    public void mo4781a(C0917h.C0918a aVar) {
        synchronized (this.f2350o) {
            int i = 0;
            int size = this.f2350o.size();
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.f2350o.get(i).f2383a == aVar) {
                    this.f2350o.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4815a(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4815a(fragment, context, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentAttached(this, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4816a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4816a(fragment, bundle, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentActivityCreated(this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4817a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f2354s;
        if (fragment2 != null) {
            C0917h fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof C0920i) {
                ((C0920i) fragmentManager).mo4817a(fragment, view, bundle, true);
            }
        }
        Iterator<C0930i> it = this.f2350o.iterator();
        while (it.hasNext()) {
            C0930i next = it.next();
            if (!z || next.f2384b) {
                next.f2383a.onFragmentViewCreated(this, fragment, view, bundle);
            }
        }
    }
}
