package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.fragment.app.m */
/* compiled from: FragmentTransitionCompat21 */
class C0945m extends C0950n {

    /* renamed from: androidx.fragment.app.m$a */
    /* compiled from: FragmentTransitionCompat21 */
    class C0946a extends Transition.EpicenterCallback {

        /* renamed from: a */
        final /* synthetic */ Rect f2462a;

        C0946a(C0945m mVar, Rect rect) {
            this.f2462a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.f2462a;
        }
    }

    /* renamed from: androidx.fragment.app.m$b */
    /* compiled from: FragmentTransitionCompat21 */
    class C0947b implements Transition.TransitionListener {

        /* renamed from: a */
        final /* synthetic */ View f2463a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f2464b;

        C0947b(C0945m mVar, View view, ArrayList arrayList) {
            this.f2463a = view;
            this.f2464b = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f2463a.setVisibility(8);
            int size = this.f2464b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f2464b.get(i)).setVisibility(0);
            }
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    /* renamed from: androidx.fragment.app.m$c */
    /* compiled from: FragmentTransitionCompat21 */
    class C0948c implements Transition.TransitionListener {

        /* renamed from: a */
        final /* synthetic */ Object f2465a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f2466b;

        /* renamed from: c */
        final /* synthetic */ Object f2467c;

        /* renamed from: d */
        final /* synthetic */ ArrayList f2468d;

        /* renamed from: e */
        final /* synthetic */ Object f2469e;

        /* renamed from: f */
        final /* synthetic */ ArrayList f2470f;

        C0948c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f2465a = obj;
            this.f2466b = arrayList;
            this.f2467c = obj2;
            this.f2468d = arrayList2;
            this.f2469e = obj3;
            this.f2470f = arrayList3;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.f2465a;
            if (obj != null) {
                C0945m.this.mo4932a(obj, (ArrayList<View>) this.f2466b, (ArrayList<View>) null);
            }
            Object obj2 = this.f2467c;
            if (obj2 != null) {
                C0945m.this.mo4932a(obj2, (ArrayList<View>) this.f2468d, (ArrayList<View>) null);
            }
            Object obj3 = this.f2469e;
            if (obj3 != null) {
                C0945m.this.mo4932a(obj3, (ArrayList<View>) this.f2470f, (ArrayList<View>) null);
            }
        }
    }

    /* renamed from: androidx.fragment.app.m$d */
    /* compiled from: FragmentTransitionCompat21 */
    class C0949d extends Transition.EpicenterCallback {

        /* renamed from: a */
        final /* synthetic */ Rect f2472a;

        C0949d(C0945m mVar, Rect rect) {
            this.f2472a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f2472a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f2472a;
        }
    }

    C0945m() {
    }

    /* renamed from: a */
    public boolean mo4933a(Object obj) {
        return obj instanceof Transition;
    }

    /* renamed from: b */
    public Object mo4934b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    /* renamed from: c */
    public Object mo4939c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    /* renamed from: a */
    public void mo4931a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i < transitionCount) {
                    mo4931a((Object) transitionSet.getTransitionAt(i), arrayList);
                    i++;
                }
            } else if (!m3366a(transition) && C0950n.m3385a((List) transition.getTargets())) {
                int size = arrayList.size();
                while (i < size) {
                    transition.addTarget(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    /* renamed from: b */
    public void mo4937b(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0950n.m3384a((List<View>) targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        mo4931a((Object) transitionSet, arrayList);
    }

    /* renamed from: c */
    public void mo4940c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            mo4954a(view, rect);
            ((Transition) obj).setEpicenterCallback(new C0946a(this, rect));
        }
    }

    /* renamed from: b */
    public Object mo4935b(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    /* renamed from: a */
    private static boolean m3366a(Transition transition) {
        return !C0950n.m3385a((List) transition.getTargetIds()) || !C0950n.m3385a((List) transition.getTargetNames()) || !C0950n.m3385a((List) transition.getTargetTypes());
    }

    /* renamed from: b */
    public void mo4938b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            mo4932a((Object) transitionSet, arrayList, arrayList2);
        }
    }

    /* renamed from: a */
    public void mo4929a(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new C0947b(this, view, arrayList));
    }

    /* renamed from: a */
    public Object mo4925a(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    /* renamed from: b */
    public void mo4936b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    /* renamed from: a */
    public void mo4926a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    /* renamed from: a */
    public void mo4930a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new C0948c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    /* renamed from: a */
    public void mo4932a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        int i;
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                mo4932a((Object) transitionSet.getTransitionAt(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!m3366a(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            if (arrayList2 == null) {
                i = 0;
            } else {
                i = arrayList2.size();
            }
            while (i2 < i) {
                transition.addTarget(arrayList2.get(i2));
                i2++;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                transition.removeTarget(arrayList.get(size));
            }
        }
    }

    /* renamed from: a */
    public void mo4928a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    /* renamed from: a */
    public void mo4927a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new C0949d(this, rect));
        }
    }
}
