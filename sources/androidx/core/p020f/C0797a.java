package androidx.core.p020f;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import androidx.core.p020f.p021c0.C0807c;
import androidx.core.p020f.p021c0.C0811d;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: androidx.core.f.a */
/* compiled from: AccessibilityDelegateCompat */
public class C0797a {

    /* renamed from: c */
    private static final View.AccessibilityDelegate f2003c = new View.AccessibilityDelegate();

    /* renamed from: a */
    private final View.AccessibilityDelegate f2004a;

    /* renamed from: b */
    private final View.AccessibilityDelegate f2005b;

    /* renamed from: androidx.core.f.a$a */
    /* compiled from: AccessibilityDelegateCompat */
    static final class C0798a extends View.AccessibilityDelegate {

        /* renamed from: a */
        final C0797a f2006a;

        C0798a(C0797a aVar) {
            this.f2006a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2006a.mo4082a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            C0811d a = this.f2006a.mo4078a(view);
            if (a != null) {
                return (AccessibilityNodeProvider) a.mo4171a();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2006a.mo4084b(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            C0807c a = C0807c.m2550a(accessibilityNodeInfo);
            a.mo4147i(C0839t.m2737z(view));
            a.mo4142g(C0839t.m2734w(view));
            a.mo4134d(C0839t.m2715f(view));
            this.f2006a.mo4080a(view, a);
            a.mo4115a(accessibilityNodeInfo.getText(), view);
            List<C0807c.C0808a> b = C0797a.m2513b(view);
            for (int i = 0; i < b.size(); i++) {
                a.mo4113a(b.get(i));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2006a.mo4085c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2006a.mo4083a(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f2006a.mo4081a(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f2006a.mo4079a(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2006a.mo4086d(view, accessibilityEvent);
        }
    }

    public C0797a() {
        this(f2003c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View.AccessibilityDelegate mo4077a() {
        return this.f2005b;
    }

    /* renamed from: b */
    public void mo4084b(View view, AccessibilityEvent accessibilityEvent) {
        this.f2004a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: c */
    public void mo4085c(View view, AccessibilityEvent accessibilityEvent) {
        this.f2004a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: d */
    public void mo4086d(View view, AccessibilityEvent accessibilityEvent) {
        this.f2004a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0797a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f2004a = accessibilityDelegate;
        this.f2005b = new C0798a(this);
    }

    /* renamed from: b */
    static List<C0807c.C0808a> m2513b(View view) {
        List<C0807c.C0808a> list = (List) view.getTag(R$id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    /* renamed from: a */
    public void mo4079a(View view, int i) {
        this.f2004a.sendAccessibilityEvent(view, i);
    }

    /* renamed from: a */
    public boolean mo4082a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f2004a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: a */
    public void mo4080a(View view, C0807c cVar) {
        this.f2004a.onInitializeAccessibilityNodeInfo(view, cVar.mo4165w());
    }

    /* renamed from: a */
    public boolean mo4083a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f2004a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* renamed from: a */
    public C0811d mo4078a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f2004a.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new C0811d(accessibilityNodeProvider);
    }

    /* renamed from: a */
    public boolean mo4081a(View view, int i, Bundle bundle) {
        List<C0807c.C0808a> b = m2513b(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= b.size()) {
                break;
            }
            C0807c.C0808a aVar = b.get(i2);
            if (aVar.mo4166a() == i) {
                z = aVar.mo4167a(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.f2004a.performAccessibilityAction(view, i, bundle);
        }
        return (z || i != R$id.accessibility_action_clickable_span) ? z : m2511a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    /* renamed from: a */
    private boolean m2511a(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!m2512a(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    /* renamed from: a */
    private boolean m2512a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] e = C0807c.m2558e(view.createAccessibilityNodeInfo().getText());
            int i = 0;
            while (e != null && i < e.length) {
                if (clickableSpan.equals(e[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
