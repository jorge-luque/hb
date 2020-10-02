package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.C0744n;
import androidx.core.p020f.C0837r;
import androidx.core.p020f.C0839t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p075d.p080b.C3191a;

/* renamed from: androidx.fragment.app.l */
/* compiled from: FragmentTransition */
class C0939l {

    /* renamed from: a */
    private static final int[] f2425a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b */
    private static final C0950n f2426b = (Build.VERSION.SDK_INT >= 21 ? new C0945m() : null);

    /* renamed from: c */
    private static final C0950n f2427c = m3339a();

    /* renamed from: androidx.fragment.app.l$a */
    /* compiled from: FragmentTransition */
    static class C0940a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f2428a;

        C0940a(ArrayList arrayList) {
            this.f2428a = arrayList;
        }

        public void run() {
            C0939l.m3358a((ArrayList<View>) this.f2428a, 4);
        }
    }

    /* renamed from: androidx.fragment.app.l$b */
    /* compiled from: FragmentTransition */
    static class C0941b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object f2429a;

        /* renamed from: b */
        final /* synthetic */ C0950n f2430b;

        /* renamed from: c */
        final /* synthetic */ View f2431c;

        /* renamed from: d */
        final /* synthetic */ Fragment f2432d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f2433e;

        /* renamed from: f */
        final /* synthetic */ ArrayList f2434f;

        /* renamed from: g */
        final /* synthetic */ ArrayList f2435g;

        /* renamed from: h */
        final /* synthetic */ Object f2436h;

        C0941b(Object obj, C0950n nVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f2429a = obj;
            this.f2430b = nVar;
            this.f2431c = view;
            this.f2432d = fragment;
            this.f2433e = arrayList;
            this.f2434f = arrayList2;
            this.f2435g = arrayList3;
            this.f2436h = obj2;
        }

        public void run() {
            Object obj = this.f2429a;
            if (obj != null) {
                this.f2430b.mo4936b(obj, this.f2431c);
                this.f2434f.addAll(C0939l.m3348a(this.f2430b, this.f2429a, this.f2432d, (ArrayList<View>) this.f2433e, this.f2431c));
            }
            if (this.f2435g != null) {
                if (this.f2436h != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f2431c);
                    this.f2430b.mo4932a(this.f2436h, (ArrayList<View>) this.f2435g, (ArrayList<View>) arrayList);
                }
                this.f2435g.clear();
                this.f2435g.add(this.f2431c);
            }
        }
    }

    /* renamed from: androidx.fragment.app.l$c */
    /* compiled from: FragmentTransition */
    static class C0942c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Fragment f2437a;

        /* renamed from: b */
        final /* synthetic */ Fragment f2438b;

        /* renamed from: c */
        final /* synthetic */ boolean f2439c;

        /* renamed from: d */
        final /* synthetic */ C3191a f2440d;

        /* renamed from: e */
        final /* synthetic */ View f2441e;

        /* renamed from: f */
        final /* synthetic */ C0950n f2442f;

        /* renamed from: g */
        final /* synthetic */ Rect f2443g;

        C0942c(Fragment fragment, Fragment fragment2, boolean z, C3191a aVar, View view, C0950n nVar, Rect rect) {
            this.f2437a = fragment;
            this.f2438b = fragment2;
            this.f2439c = z;
            this.f2440d = aVar;
            this.f2441e = view;
            this.f2442f = nVar;
            this.f2443g = rect;
        }

        public void run() {
            C0939l.m3349a(this.f2437a, this.f2438b, this.f2439c, (C3191a<String, View>) this.f2440d, false);
            View view = this.f2441e;
            if (view != null) {
                this.f2442f.mo4954a(view, this.f2443g);
            }
        }
    }

    /* renamed from: androidx.fragment.app.l$d */
    /* compiled from: FragmentTransition */
    static class C0943d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0950n f2444a;

        /* renamed from: b */
        final /* synthetic */ C3191a f2445b;

        /* renamed from: c */
        final /* synthetic */ Object f2446c;

        /* renamed from: d */
        final /* synthetic */ C0944e f2447d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f2448e;

        /* renamed from: f */
        final /* synthetic */ View f2449f;

        /* renamed from: g */
        final /* synthetic */ Fragment f2450g;

        /* renamed from: h */
        final /* synthetic */ Fragment f2451h;

        /* renamed from: i */
        final /* synthetic */ boolean f2452i;

        /* renamed from: j */
        final /* synthetic */ ArrayList f2453j;

        /* renamed from: k */
        final /* synthetic */ Object f2454k;

        /* renamed from: l */
        final /* synthetic */ Rect f2455l;

        C0943d(C0950n nVar, C3191a aVar, Object obj, C0944e eVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f2444a = nVar;
            this.f2445b = aVar;
            this.f2446c = obj;
            this.f2447d = eVar;
            this.f2448e = arrayList;
            this.f2449f = view;
            this.f2450g = fragment;
            this.f2451h = fragment2;
            this.f2452i = z;
            this.f2453j = arrayList2;
            this.f2454k = obj2;
            this.f2455l = rect;
        }

        public void run() {
            C3191a<String, View> a = C0939l.m3342a(this.f2444a, (C3191a<String, String>) this.f2445b, this.f2446c, this.f2447d);
            if (a != null) {
                this.f2448e.addAll(a.values());
                this.f2448e.add(this.f2449f);
            }
            C0939l.m3349a(this.f2450g, this.f2451h, this.f2452i, a, false);
            Object obj = this.f2446c;
            if (obj != null) {
                this.f2444a.mo4938b(obj, (ArrayList<View>) this.f2453j, (ArrayList<View>) this.f2448e);
                View a2 = C0939l.m3337a(a, this.f2447d, this.f2454k, this.f2452i);
                if (a2 != null) {
                    this.f2444a.mo4954a(a2, this.f2455l);
                }
            }
        }
    }

    /* renamed from: androidx.fragment.app.l$e */
    /* compiled from: FragmentTransition */
    static class C0944e {

        /* renamed from: a */
        public Fragment f2456a;

        /* renamed from: b */
        public boolean f2457b;

        /* renamed from: c */
        public C0908a f2458c;

        /* renamed from: d */
        public Fragment f2459d;

        /* renamed from: e */
        public boolean f2460e;

        /* renamed from: f */
        public C0908a f2461f;

        C0944e() {
        }
    }

    /* renamed from: a */
    private static C0950n m3339a() {
        try {
            return (C0950n) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r11 = r4.f2456a;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m3365b(androidx.fragment.app.C0920i r17, int r18, androidx.fragment.app.C0939l.C0944e r19, android.view.View r20, p075d.p080b.C3191a<java.lang.String, java.lang.String> r21) {
        /*
            r0 = r17
            r4 = r19
            r9 = r20
            androidx.fragment.app.d r1 = r0.f2353r
            boolean r1 = r1.mo4651a()
            if (r1 == 0) goto L_0x0019
            androidx.fragment.app.d r0 = r0.f2353r
            r1 = r18
            android.view.View r0 = r0.mo4650a(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r10 = r0
            if (r10 != 0) goto L_0x001e
            return
        L_0x001e:
            androidx.fragment.app.Fragment r11 = r4.f2456a
            androidx.fragment.app.Fragment r12 = r4.f2459d
            androidx.fragment.app.n r13 = m3340a((androidx.fragment.app.Fragment) r12, (androidx.fragment.app.Fragment) r11)
            if (r13 != 0) goto L_0x0029
            return
        L_0x0029:
            boolean r14 = r4.f2457b
            boolean r0 = r4.f2460e
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.Object r7 = m3345a((androidx.fragment.app.C0950n) r13, (androidx.fragment.app.Fragment) r11, (boolean) r14)
            java.lang.Object r6 = m3363b((androidx.fragment.app.C0950n) r13, (androidx.fragment.app.Fragment) r12, (boolean) r0)
            r0 = r13
            r1 = r10
            r2 = r20
            r3 = r21
            r4 = r19
            r5 = r8
            r17 = r6
            r6 = r15
            r18 = r7
            r16 = r10
            r10 = r8
            r8 = r17
            java.lang.Object r8 = m3362b(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r18
            if (r6 != 0) goto L_0x0061
            if (r8 != 0) goto L_0x0061
            r7 = r17
            if (r7 != 0) goto L_0x0063
            return
        L_0x0061:
            r7 = r17
        L_0x0063:
            java.util.ArrayList r5 = m3348a((androidx.fragment.app.C0950n) r13, (java.lang.Object) r7, (androidx.fragment.app.Fragment) r12, (java.util.ArrayList<android.view.View>) r10, (android.view.View) r9)
            java.util.ArrayList r9 = m3348a((androidx.fragment.app.C0950n) r13, (java.lang.Object) r6, (androidx.fragment.app.Fragment) r11, (java.util.ArrayList<android.view.View>) r15, (android.view.View) r9)
            r0 = 4
            m3358a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r0 = r13
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r11
            r11 = r5
            r5 = r14
            java.lang.Object r14 = m3346a((androidx.fragment.app.C0950n) r0, (java.lang.Object) r1, (java.lang.Object) r2, (java.lang.Object) r3, (androidx.fragment.app.Fragment) r4, (boolean) r5)
            if (r14 == 0) goto L_0x00a4
            m3355a((androidx.fragment.app.C0950n) r13, (java.lang.Object) r7, (androidx.fragment.app.Fragment) r12, (java.util.ArrayList<android.view.View>) r11)
            java.util.ArrayList r12 = r13.mo4953a((java.util.ArrayList<android.view.View>) r15)
            r0 = r13
            r1 = r14
            r2 = r6
            r3 = r9
            r4 = r7
            r5 = r11
            r6 = r8
            r7 = r15
            r0.mo4930a(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            r13.mo4926a((android.view.ViewGroup) r0, (java.lang.Object) r14)
            r1 = r13
            r2 = r0
            r3 = r10
            r4 = r15
            r5 = r12
            r6 = r21
            r1.mo4955a(r2, r3, r4, r5, r6)
            r0 = 0
            m3358a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r13.mo4938b((java.lang.Object) r8, (java.util.ArrayList<android.view.View>) r10, (java.util.ArrayList<android.view.View>) r15)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0939l.m3365b(androidx.fragment.app.i, int, androidx.fragment.app.l$e, android.view.View, d.b.a):void");
    }

    /* renamed from: a */
    static void m3353a(C0920i iVar, ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (iVar.f2351p >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                C0908a aVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    m3364b(aVar, (SparseArray<C0944e>) sparseArray, z);
                } else {
                    m3350a(aVar, (SparseArray<C0944e>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(iVar.f2352q.mo4775c());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    C3191a<String, String> a = m3341a(keyAt, arrayList, arrayList2, i, i2);
                    C0944e eVar = (C0944e) sparseArray.valueAt(i4);
                    if (z) {
                        m3365b(iVar, keyAt, eVar, view, a);
                    } else {
                        m3352a(iVar, keyAt, eVar, view, a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static C3191a<String, String> m3341a(int i, ArrayList<C0908a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        C3191a<String, String> aVar = new C3191a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0908a aVar2 = arrayList.get(i4);
            if (aVar2.mo4678b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = aVar2.f2413n;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f2413n;
                        arrayList4 = aVar2.f2414o;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.f2413n;
                        arrayList3 = aVar2.f2414o;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    /* renamed from: b */
    private static Object m3363b(C0950n nVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return nVar.mo4934b(obj);
    }

    /* renamed from: b */
    private static Object m3362b(C0950n nVar, ViewGroup viewGroup, View view, C3191a<String, String> aVar, C0944e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Rect rect;
        View view2;
        C0950n nVar2 = nVar;
        View view3 = view;
        C3191a<String, String> aVar2 = aVar;
        C0944e eVar2 = eVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = eVar2.f2456a;
        Fragment fragment2 = eVar2.f2459d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = eVar2.f2457b;
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = m3344a(nVar, fragment, fragment2, z);
        }
        C3191a<String, View> b = m3361b(nVar, aVar2, obj3, eVar2);
        C3191a<String, View> a = m3342a(nVar, aVar2, obj3, eVar2);
        if (aVar.isEmpty()) {
            if (b != null) {
                b.clear();
            }
            if (a != null) {
                a.clear();
            }
            obj4 = null;
        } else {
            m3359a(arrayList3, b, (Collection<String>) aVar.keySet());
            m3359a(arrayList4, a, aVar.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        m3349a(fragment, fragment2, z, b, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            nVar.mo4937b(obj4, view3, arrayList3);
            m3356a(nVar, obj4, obj2, b, eVar2.f2460e, eVar2.f2461f);
            Rect rect2 = new Rect();
            View a2 = m3337a(a, eVar2, obj5, z);
            if (a2 != null) {
                nVar.mo4927a(obj5, rect2);
            }
            rect = rect2;
            view2 = a2;
        } else {
            view2 = null;
            rect = null;
        }
        C0837r.m2676a(viewGroup, new C0942c(fragment, fragment2, z, a, view2, nVar, rect));
        return obj4;
    }

    /* renamed from: a */
    private static void m3355a(C0950n nVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            nVar.mo4929a(obj, fragment.getView(), arrayList);
            C0837r.m2676a(fragment.mContainer, new C0940a(arrayList));
        }
    }

    /* renamed from: a */
    private static void m3352a(C0920i iVar, int i, C0944e eVar, View view, C3191a<String, String> aVar) {
        Fragment fragment;
        Fragment fragment2;
        C0950n a;
        Object obj;
        C0920i iVar2 = iVar;
        C0944e eVar2 = eVar;
        View view2 = view;
        C3191a<String, String> aVar2 = aVar;
        ViewGroup viewGroup = iVar2.f2353r.mo4651a() ? (ViewGroup) iVar2.f2353r.mo4650a(i) : null;
        if (viewGroup != null && (a = m3340a(fragment2, fragment)) != null) {
            boolean z = eVar2.f2457b;
            boolean z2 = eVar2.f2460e;
            Object a2 = m3345a(a, (fragment = eVar2.f2456a), z);
            Object b = m3363b(a, (fragment2 = eVar2.f2459d), z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = b;
            C0950n nVar = a;
            Object a3 = m3343a(a, viewGroup, view, aVar, eVar, (ArrayList<View>) arrayList, (ArrayList<View>) arrayList2, a2, obj2);
            Object obj3 = a2;
            if (obj3 == null && a3 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> a4 = m3348a(nVar, obj, fragment2, (ArrayList<View>) arrayList3, view2);
            Object obj4 = (a4 == null || a4.isEmpty()) ? null : obj;
            nVar.mo4928a(obj3, view2);
            Object a5 = m3346a(nVar, obj3, obj4, a3, fragment, eVar2.f2457b);
            if (a5 != null) {
                ArrayList arrayList4 = new ArrayList();
                C0950n nVar2 = nVar;
                nVar2.mo4930a(a5, obj3, arrayList4, obj4, a4, a3, arrayList2);
                m3354a(nVar2, viewGroup, fragment, view, (ArrayList<View>) arrayList2, obj3, (ArrayList<View>) arrayList4, obj4, a4);
                ArrayList arrayList5 = arrayList2;
                nVar.mo4956a((View) viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) aVar2);
                nVar.mo4926a(viewGroup, a5);
                nVar.mo4957a(viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) aVar2);
            }
        }
    }

    /* renamed from: b */
    private static C3191a<String, View> m3361b(C0950n nVar, C3191a<String, String> aVar, Object obj, C0944e eVar) {
        C0744n nVar2;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = eVar.f2459d;
        C3191a<String, View> aVar2 = new C3191a<>();
        nVar.mo4959a((Map<String, View>) aVar2, fragment.requireView());
        C0908a aVar3 = eVar.f2461f;
        if (eVar.f2460e) {
            nVar2 = fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2414o;
        } else {
            nVar2 = fragment.getExitTransitionCallback();
            arrayList = aVar3.f2413n;
        }
        aVar2.mo18672a(arrayList);
        if (nVar2 != null) {
            nVar2.mo3976a((List<String>) arrayList, (Map<String, View>) aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(C0839t.m2729r(view))) {
                    aVar.put(C0839t.m2729r(view), aVar.remove(str));
                }
            }
        } else {
            aVar.mo18672a(aVar2.keySet());
        }
        return aVar2;
    }

    /* renamed from: a */
    private static void m3354a(C0950n nVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        ViewGroup viewGroup2 = viewGroup;
        C0837r.m2676a(viewGroup, new C0941b(obj, nVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    /* renamed from: a */
    private static C0950n m3340a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        C0950n nVar = f2426b;
        if (nVar != null && m3360a(nVar, (List<Object>) arrayList)) {
            return f2426b;
        }
        C0950n nVar2 = f2427c;
        if (nVar2 != null && m3360a(nVar2, (List<Object>) arrayList)) {
            return f2427c;
        }
        if (f2426b == null && f2427c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: b */
    public static void m3364b(C0908a aVar, SparseArray<C0944e> sparseArray, boolean z) {
        if (aVar.f2314r.f2353r.mo4651a()) {
            for (int size = aVar.f2400a.size() - 1; size >= 0; size--) {
                m3351a(aVar, aVar.f2400a.get(size), sparseArray, true, z);
            }
        }
    }

    /* renamed from: a */
    private static boolean m3360a(C0950n nVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!nVar.mo4933a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static Object m3344a(C0950n nVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return nVar.mo4939c(nVar.mo4934b(obj));
    }

    /* renamed from: a */
    private static Object m3345a(C0950n nVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return nVar.mo4934b(obj);
    }

    /* renamed from: a */
    private static void m3359a(ArrayList<View> arrayList, C3191a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View d = aVar.mo18808d(size);
            if (collection.contains(C0839t.m2729r(d))) {
                arrayList.add(d);
            }
        }
    }

    /* renamed from: a */
    private static Object m3343a(C0950n nVar, ViewGroup viewGroup, View view, C3191a<String, String> aVar, C0944e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        C3191a<String, String> aVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        C0950n nVar2 = nVar;
        C0944e eVar2 = eVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = eVar2.f2456a;
        Fragment fragment2 = eVar2.f2459d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = eVar2.f2457b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            obj3 = null;
        } else {
            obj3 = m3344a(nVar2, fragment, fragment2, z);
            aVar2 = aVar;
        }
        C3191a<String, View> b = m3361b(nVar2, aVar2, obj3, eVar2);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        m3349a(fragment, fragment2, z, b, true);
        if (obj4 != null) {
            rect = new Rect();
            nVar2.mo4937b(obj4, view, arrayList3);
            m3356a(nVar, obj4, obj2, b, eVar2.f2460e, eVar2.f2461f);
            if (obj5 != null) {
                nVar2.mo4927a(obj5, rect);
            }
        } else {
            rect = null;
        }
        C0943d dVar = r0;
        C0943d dVar2 = new C0943d(nVar, aVar, obj4, eVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect);
        C0837r.m2676a(viewGroup, dVar);
        return obj4;
    }

    /* renamed from: a */
    static C3191a<String, View> m3342a(C0950n nVar, C3191a<String, String> aVar, Object obj, C0944e eVar) {
        C0744n nVar2;
        ArrayList<String> arrayList;
        String a;
        Fragment fragment = eVar.f2456a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        C3191a<String, View> aVar2 = new C3191a<>();
        nVar.mo4959a((Map<String, View>) aVar2, view);
        C0908a aVar3 = eVar.f2458c;
        if (eVar.f2457b) {
            nVar2 = fragment.getExitTransitionCallback();
            arrayList = aVar3.f2413n;
        } else {
            nVar2 = fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2414o;
        }
        if (arrayList != null) {
            aVar2.mo18672a(arrayList);
            aVar2.mo18672a(aVar.values());
        }
        if (nVar2 != null) {
            nVar2.mo3976a((List<String>) arrayList, (Map<String, View>) aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = aVar2.get(str);
                if (view2 == null) {
                    String a2 = m3347a(aVar, str);
                    if (a2 != null) {
                        aVar.remove(a2);
                    }
                } else if (!str.equals(C0839t.m2729r(view2)) && (a = m3347a(aVar, str)) != null) {
                    aVar.put(a, C0839t.m2729r(view2));
                }
            }
        } else {
            m3357a(aVar, aVar2);
        }
        return aVar2;
    }

    /* renamed from: a */
    private static String m3347a(C3191a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.mo18808d(i))) {
                return aVar.mo18803b(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    static View m3337a(C3191a<String, View> aVar, C0944e eVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        C0908a aVar2 = eVar.f2458c;
        if (obj == null || aVar == null || (arrayList = aVar2.f2413n) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar2.f2413n.get(0);
        } else {
            str = aVar2.f2414o.get(0);
        }
        return aVar.get(str);
    }

    /* renamed from: a */
    private static void m3356a(C0950n nVar, Object obj, Object obj2, C3191a<String, View> aVar, boolean z, C0908a aVar2) {
        String str;
        ArrayList<String> arrayList = aVar2.f2413n;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = aVar2.f2414o.get(0);
            } else {
                str = aVar2.f2413n.get(0);
            }
            View view = aVar.get(str);
            nVar.mo4940c(obj, view);
            if (obj2 != null) {
                nVar.mo4940c(obj2, view);
            }
        }
    }

    /* renamed from: a */
    private static void m3357a(C3191a<String, String> aVar, C3191a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.mo18808d(size))) {
                aVar.mo18804c(size);
            }
        }
    }

    /* renamed from: a */
    static void m3349a(Fragment fragment, Fragment fragment2, boolean z, C3191a<String, View> aVar, boolean z2) {
        C0744n nVar;
        int i;
        if (z) {
            nVar = fragment2.getEnterTransitionCallback();
        } else {
            nVar = fragment.getEnterTransitionCallback();
        }
        if (nVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (aVar == null) {
                i = 0;
            } else {
                i = aVar.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(aVar.mo18803b(i2));
                arrayList.add(aVar.mo18808d(i2));
            }
            if (z2) {
                nVar.mo3977b(arrayList2, arrayList, (List<View>) null);
            } else {
                nVar.mo3975a((List<String>) arrayList2, (List<View>) arrayList, (List<View>) null);
            }
        }
    }

    /* renamed from: a */
    static ArrayList<View> m3348a(C0950n nVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            nVar.mo4958a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        nVar.mo4931a(obj, arrayList2);
        return arrayList2;
    }

    /* renamed from: a */
    static void m3358a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* renamed from: a */
    private static Object m3346a(C0950n nVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return nVar.mo4935b(obj2, obj, obj3);
        }
        return nVar.mo4925a(obj2, obj, obj3);
    }

    /* renamed from: a */
    public static void m3350a(C0908a aVar, SparseArray<C0944e> sparseArray, boolean z) {
        int size = aVar.f2400a.size();
        for (int i = 0; i < size; i++) {
            m3351a(aVar, aVar.f2400a.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        if (r10.mAdded != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0092, code lost:
        if (r10.mHidden == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0094, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m3351a(androidx.fragment.app.C0908a r16, androidx.fragment.app.C0937k.C0938a r17, android.util.SparseArray<androidx.fragment.app.C0939l.C0944e> r18, boolean r19, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            androidx.fragment.app.Fragment r10 = r1.f2418b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.mContainerId
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = f2425a
            int r1 = r1.f2417a
            r1 = r4[r1]
            goto L_0x001d
        L_0x001b:
            int r1 = r1.f2417a
        L_0x001d:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x0087
            r6 = 3
            if (r1 == r6) goto L_0x005f
            r6 = 4
            if (r1 == r6) goto L_0x0047
            r6 = 5
            if (r1 == r6) goto L_0x0035
            r6 = 6
            if (r1 == r6) goto L_0x005f
            r6 = 7
            if (r1 == r6) goto L_0x0087
            r1 = 0
        L_0x0031:
            r12 = 0
            r13 = 0
            goto L_0x009a
        L_0x0035:
            if (r20 == 0) goto L_0x0044
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x0096
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0096
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0096
            goto L_0x0094
        L_0x0044:
            boolean r1 = r10.mHidden
            goto L_0x0097
        L_0x0047:
            if (r20 == 0) goto L_0x0056
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.mHidden
            if (r1 == 0) goto L_0x0078
        L_0x0055:
            goto L_0x0076
        L_0x0056:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0078
            goto L_0x0055
        L_0x005f:
            if (r20 == 0) goto L_0x007a
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x0078
            android.view.View r1 = r10.mView
            if (r1 == 0) goto L_0x0078
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0078
            float r1 = r10.mPostponedAlpha
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0078
        L_0x0076:
            r1 = 1
            goto L_0x0083
        L_0x0078:
            r1 = 0
            goto L_0x0083
        L_0x007a:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0078
            goto L_0x0076
        L_0x0083:
            r13 = r1
            r1 = 0
            r12 = 1
            goto L_0x009a
        L_0x0087:
            if (r20 == 0) goto L_0x008c
            boolean r1 = r10.mIsNewlyAdded
            goto L_0x0097
        L_0x008c:
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x0096
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0096
        L_0x0094:
            r1 = 1
            goto L_0x0097
        L_0x0096:
            r1 = 0
        L_0x0097:
            r4 = r1
            r1 = 1
            goto L_0x0031
        L_0x009a:
            java.lang.Object r6 = r2.get(r11)
            androidx.fragment.app.l$e r6 = (androidx.fragment.app.C0939l.C0944e) r6
            if (r4 == 0) goto L_0x00ac
            androidx.fragment.app.l$e r6 = m3338a((androidx.fragment.app.C0939l.C0944e) r6, (android.util.SparseArray<androidx.fragment.app.C0939l.C0944e>) r2, (int) r11)
            r6.f2456a = r10
            r6.f2457b = r3
            r6.f2458c = r0
        L_0x00ac:
            r14 = r6
            r15 = 0
            if (r20 != 0) goto L_0x00d3
            if (r1 == 0) goto L_0x00d3
            if (r14 == 0) goto L_0x00ba
            androidx.fragment.app.Fragment r1 = r14.f2459d
            if (r1 != r10) goto L_0x00ba
            r14.f2459d = r15
        L_0x00ba:
            androidx.fragment.app.i r4 = r0.f2314r
            int r1 = r10.mState
            if (r1 >= r5) goto L_0x00d3
            int r1 = r4.f2351p
            if (r1 < r5) goto L_0x00d3
            boolean r1 = r0.f2415p
            if (r1 != 0) goto L_0x00d3
            r4.mo4861j(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.mo4814a((androidx.fragment.app.Fragment) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
        L_0x00d3:
            if (r13 == 0) goto L_0x00e5
            if (r14 == 0) goto L_0x00db
            androidx.fragment.app.Fragment r1 = r14.f2459d
            if (r1 != 0) goto L_0x00e5
        L_0x00db:
            androidx.fragment.app.l$e r14 = m3338a((androidx.fragment.app.C0939l.C0944e) r14, (android.util.SparseArray<androidx.fragment.app.C0939l.C0944e>) r2, (int) r11)
            r14.f2459d = r10
            r14.f2460e = r3
            r14.f2461f = r0
        L_0x00e5:
            if (r20 != 0) goto L_0x00f1
            if (r12 == 0) goto L_0x00f1
            if (r14 == 0) goto L_0x00f1
            androidx.fragment.app.Fragment r0 = r14.f2456a
            if (r0 != r10) goto L_0x00f1
            r14.f2456a = r15
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0939l.m3351a(androidx.fragment.app.a, androidx.fragment.app.k$a, android.util.SparseArray, boolean, boolean):void");
    }

    /* renamed from: a */
    private static C0944e m3338a(C0944e eVar, SparseArray<C0944e> sparseArray, int i) {
        if (eVar != null) {
            return eVar;
        }
        C0944e eVar2 = new C0944e();
        sparseArray.put(i, eVar2);
        return eVar2;
    }
}
