package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.p020f.C0797a;
import androidx.core.p020f.C0839t;
import androidx.core.p020f.p021c0.C0807c;
import androidx.core.p020f.p021c0.C0811d;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: androidx.recyclerview.widget.i */
/* compiled from: RecyclerViewAccessibilityDelegate */
public class C1109i extends C0797a {

    /* renamed from: d */
    final RecyclerView f3016d;

    /* renamed from: e */
    private final C1110a f3017e;

    /* renamed from: androidx.recyclerview.widget.i$a */
    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class C1110a extends C0797a {

        /* renamed from: d */
        final C1109i f3018d;

        /* renamed from: e */
        private Map<View, C0797a> f3019e = new WeakHashMap();

        public C1110a(C1109i iVar) {
            this.f3018d = iVar;
        }

        /* renamed from: a */
        public void mo4080a(View view, C0807c cVar) {
            if (this.f3018d.mo5896c() || this.f3018d.f3016d.mo5341j() == null) {
                super.mo4080a(view, cVar);
                return;
            }
            this.f3018d.f3016d.mo5341j().mo5547a(view, cVar);
            C0797a aVar = this.f3019e.get(view);
            if (aVar != null) {
                aVar.mo4080a(view, cVar);
            } else {
                super.mo4080a(view, cVar);
            }
        }

        /* renamed from: b */
        public void mo4084b(View view, AccessibilityEvent accessibilityEvent) {
            C0797a aVar = this.f3019e.get(view);
            if (aVar != null) {
                aVar.mo4084b(view, accessibilityEvent);
            } else {
                super.mo4084b(view, accessibilityEvent);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public C0797a mo5897c(View view) {
            return this.f3019e.remove(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo5898d(View view) {
            C0797a b = C0839t.m2704b(view);
            if (b != null && b != this) {
                this.f3019e.put(view, b);
            }
        }

        /* renamed from: c */
        public void mo4085c(View view, AccessibilityEvent accessibilityEvent) {
            C0797a aVar = this.f3019e.get(view);
            if (aVar != null) {
                aVar.mo4085c(view, accessibilityEvent);
            } else {
                super.mo4085c(view, accessibilityEvent);
            }
        }

        /* renamed from: d */
        public void mo4086d(View view, AccessibilityEvent accessibilityEvent) {
            C0797a aVar = this.f3019e.get(view);
            if (aVar != null) {
                aVar.mo4086d(view, accessibilityEvent);
            } else {
                super.mo4086d(view, accessibilityEvent);
            }
        }

        /* renamed from: a */
        public boolean mo4081a(View view, int i, Bundle bundle) {
            if (this.f3018d.mo5896c() || this.f3018d.f3016d.mo5341j() == null) {
                return super.mo4081a(view, i, bundle);
            }
            C0797a aVar = this.f3019e.get(view);
            if (aVar != null) {
                if (aVar.mo4081a(view, i, bundle)) {
                    return true;
                }
            } else if (super.mo4081a(view, i, bundle)) {
                return true;
            }
            return this.f3018d.f3016d.mo5341j().mo5560a(view, i, bundle);
        }

        /* renamed from: a */
        public void mo4079a(View view, int i) {
            C0797a aVar = this.f3019e.get(view);
            if (aVar != null) {
                aVar.mo4079a(view, i);
            } else {
                super.mo4079a(view, i);
            }
        }

        /* renamed from: a */
        public boolean mo4082a(View view, AccessibilityEvent accessibilityEvent) {
            C0797a aVar = this.f3019e.get(view);
            if (aVar != null) {
                return aVar.mo4082a(view, accessibilityEvent);
            }
            return super.mo4082a(view, accessibilityEvent);
        }

        /* renamed from: a */
        public boolean mo4083a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C0797a aVar = this.f3019e.get(viewGroup);
            if (aVar != null) {
                return aVar.mo4083a(viewGroup, view, accessibilityEvent);
            }
            return super.mo4083a(viewGroup, view, accessibilityEvent);
        }

        /* renamed from: a */
        public C0811d mo4078a(View view) {
            C0797a aVar = this.f3019e.get(view);
            if (aVar != null) {
                return aVar.mo4078a(view);
            }
            return super.mo4078a(view);
        }
    }

    public C1109i(RecyclerView recyclerView) {
        this.f3016d = recyclerView;
        C0797a b = mo5895b();
        if (b == null || !(b instanceof C1110a)) {
            this.f3017e = new C1110a(this);
        } else {
            this.f3017e = (C1110a) b;
        }
    }

    /* renamed from: a */
    public boolean mo4081a(View view, int i, Bundle bundle) {
        if (super.mo4081a(view, i, bundle)) {
            return true;
        }
        if (mo5896c() || this.f3016d.mo5341j() == null) {
            return false;
        }
        return this.f3016d.mo5341j().mo5558a(i, bundle);
    }

    /* renamed from: b */
    public void mo4084b(View view, AccessibilityEvent accessibilityEvent) {
        super.mo4084b(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !mo5896c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.mo5341j() != null) {
                recyclerView.mo5341j().mo5206a(accessibilityEvent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5896c() {
        return this.f3016d.mo5346m();
    }

    /* renamed from: a */
    public void mo4080a(View view, C0807c cVar) {
        super.mo4080a(view, cVar);
        if (!mo5896c() && this.f3016d.mo5341j() != null) {
            this.f3016d.mo5341j().mo5550a(cVar);
        }
    }

    /* renamed from: b */
    public C0797a mo5895b() {
        return this.f3017e;
    }
}
