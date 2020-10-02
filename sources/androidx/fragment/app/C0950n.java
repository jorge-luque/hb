package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p020f.C0837r;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.C0849v;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
/* renamed from: androidx.fragment.app.n */
/* compiled from: FragmentTransitionImpl */
public abstract class C0950n {

    /* renamed from: androidx.fragment.app.n$a */
    /* compiled from: FragmentTransitionImpl */
    class C0951a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f2473a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f2474b;

        /* renamed from: c */
        final /* synthetic */ ArrayList f2475c;

        /* renamed from: d */
        final /* synthetic */ ArrayList f2476d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f2477e;

        C0951a(C0950n nVar, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f2473a = i;
            this.f2474b = arrayList;
            this.f2475c = arrayList2;
            this.f2476d = arrayList3;
            this.f2477e = arrayList4;
        }

        public void run() {
            for (int i = 0; i < this.f2473a; i++) {
                C0839t.m2701a((View) this.f2474b.get(i), (String) this.f2475c.get(i));
                C0839t.m2701a((View) this.f2476d.get(i), (String) this.f2477e.get(i));
            }
        }
    }

    /* renamed from: androidx.fragment.app.n$b */
    /* compiled from: FragmentTransitionImpl */
    class C0952b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f2478a;

        /* renamed from: b */
        final /* synthetic */ Map f2479b;

        C0952b(C0950n nVar, ArrayList arrayList, Map map) {
            this.f2478a = arrayList;
            this.f2479b = map;
        }

        public void run() {
            int size = this.f2478a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f2478a.get(i);
                String r = C0839t.m2729r(view);
                if (r != null) {
                    C0839t.m2701a(view, C0950n.m3383a((Map<String, String>) this.f2479b, r));
                }
            }
        }
    }

    /* renamed from: androidx.fragment.app.n$c */
    /* compiled from: FragmentTransitionImpl */
    class C0953c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f2480a;

        /* renamed from: b */
        final /* synthetic */ Map f2481b;

        C0953c(C0950n nVar, ArrayList arrayList, Map map) {
            this.f2480a = arrayList;
            this.f2481b = map;
        }

        public void run() {
            int size = this.f2480a.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f2480a.get(i);
                C0839t.m2701a(view, (String) this.f2481b.get(C0839t.m2729r(view)));
            }
        }
    }

    /* renamed from: a */
    public abstract Object mo4925a(Object obj, Object obj2, Object obj3);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4954a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* renamed from: a */
    public abstract void mo4926a(ViewGroup viewGroup, Object obj);

    /* renamed from: a */
    public abstract void mo4927a(Object obj, Rect rect);

    /* renamed from: a */
    public abstract void mo4928a(Object obj, View view);

    /* renamed from: a */
    public abstract void mo4929a(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo4930a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: a */
    public abstract void mo4931a(Object obj, ArrayList<View> arrayList);

    /* renamed from: a */
    public abstract void mo4932a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: a */
    public abstract boolean mo4933a(Object obj);

    /* renamed from: b */
    public abstract Object mo4934b(Object obj);

    /* renamed from: b */
    public abstract Object mo4935b(Object obj, Object obj2, Object obj3);

    /* renamed from: b */
    public abstract void mo4936b(Object obj, View view);

    /* renamed from: b */
    public abstract void mo4937b(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: b */
    public abstract void mo4938b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: c */
    public abstract Object mo4939c(Object obj);

    /* renamed from: c */
    public abstract void mo4940c(Object obj, View view);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ArrayList<String> mo4953a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(C0839t.m2729r(view));
            C0839t.m2701a(view, (String) null);
        }
        return arrayList2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4955a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String r = C0839t.m2729r(view2);
            arrayList4.add(r);
            if (r != null) {
                C0839t.m2701a(view2, (String) null);
                String str = map.get(r);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i2))) {
                        C0839t.m2701a(arrayList2.get(i2), r);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        C0837r.m2676a(view, new C0951a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4958a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (C0849v.m2763a(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                mo4958a(arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4959a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String r = C0839t.m2729r(view);
            if (r != null) {
                map.put(r, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    mo4959a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4956a(View view, ArrayList<View> arrayList, Map<String, String> map) {
        C0837r.m2676a(view, new C0952b(this, arrayList, map));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4957a(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        C0837r.m2676a(viewGroup, new C0953c(this, arrayList, map));
    }

    /* renamed from: a */
    protected static void m3384a(List<View> list, View view) {
        int size = list.size();
        if (!m3386a(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m3386a(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m3386a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected static boolean m3385a(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: a */
    static String m3383a(Map<String, String> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            if (str.equals(next.getValue())) {
                return (String) next.getKey();
            }
        }
        return null;
    }
}
