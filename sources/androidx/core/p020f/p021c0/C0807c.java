package androidx.core.p020f.p021c0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import androidx.core.p020f.p021c0.C0813f;
import com.facebook.internal.Utility;
import com.google.android.gms.drive.MetadataChangeSet;
import com.ogury.p159cm.OguryChoiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: androidx.core.f.c0.c */
/* compiled from: AccessibilityNodeInfoCompat */
public class C0807c {

    /* renamed from: d */
    private static int f2013d;

    /* renamed from: a */
    private final AccessibilityNodeInfo f2014a;

    /* renamed from: b */
    public int f2015b = -1;

    /* renamed from: c */
    private int f2016c = -1;

    /* renamed from: androidx.core.f.c0.c$a */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0808a {

        /* renamed from: d */
        public static final C0808a f2017d = new C0808a(1, (CharSequence) null);

        /* renamed from: e */
        public static final C0808a f2018e = new C0808a(2, (CharSequence) null);

        /* renamed from: f */
        public static final C0808a f2019f = new C0808a(CodedOutputStream.DEFAULT_BUFFER_SIZE, (CharSequence) null);

        /* renamed from: g */
        public static final C0808a f2020g = new C0808a(Utility.DEFAULT_STREAM_BUFFER_SIZE, (CharSequence) null);

        /* renamed from: h */
        public static final C0808a f2021h = new C0808a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);

        /* renamed from: i */
        public static final C0808a f2022i = new C0808a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);

        /* renamed from: a */
        final Object f2023a;

        /* renamed from: b */
        private final Class<? extends C0813f.C0814a> f2024b;

        /* renamed from: c */
        protected final C0813f f2025c;

        static {
            Class<C0813f.C0816c> cls = C0813f.C0816c.class;
            Class<C0813f.C0815b> cls2 = C0813f.C0815b.class;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            new C0808a(4, (CharSequence) null);
            new C0808a(8, (CharSequence) null);
            new C0808a(16, (CharSequence) null);
            new C0808a(32, (CharSequence) null);
            new C0808a(64, (CharSequence) null);
            new C0808a(OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE, (CharSequence) null);
            new C0808a(256, (CharSequence) null, cls2);
            new C0808a(512, (CharSequence) null, cls2);
            new C0808a(OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS, (CharSequence) null, cls);
            new C0808a(2048, (CharSequence) null, cls);
            new C0808a(16384, (CharSequence) null);
            new C0808a(32768, (CharSequence) null);
            new C0808a(65536, (CharSequence) null);
            new C0808a(MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES, (CharSequence) null, C0813f.C0820g.class);
            new C0808a(262144, (CharSequence) null);
            new C0808a(524288, (CharSequence) null);
            new C0808a(1048576, (CharSequence) null);
            new C0808a(2097152, (CharSequence) null, C0813f.C0821h.class);
            new C0808a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
            new C0808a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (CharSequence) null, (C0813f) null, C0813f.C0818e.class);
            new C0808a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
            new C0808a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
            new C0808a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
            new C0808a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
            new C0808a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
            new C0808a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
            new C0808a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
            new C0808a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (C0813f) null, C0813f.C0819f.class);
            new C0808a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (C0813f) null, C0813f.C0817d.class);
            new C0808a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            new C0808a(accessibilityAction, 16908357, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
        }

        public C0808a(int i, CharSequence charSequence) {
            this((Object) null, i, charSequence, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
        }

        /* renamed from: a */
        public int mo4166a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2023a).getId();
            }
            return 0;
        }

        /* renamed from: b */
        public CharSequence mo4168b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2023a).getLabel();
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C0808a)) {
                return false;
            }
            C0808a aVar = (C0808a) obj;
            Object obj2 = this.f2023a;
            if (obj2 == null) {
                if (aVar.f2023a != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(aVar.f2023a)) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            Object obj = this.f2023a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        C0808a(Object obj) {
            this(obj, 0, (CharSequence) null, (C0813f) null, (Class<? extends C0813f.C0814a>) null);
        }

        private C0808a(int i, CharSequence charSequence, Class<? extends C0813f.C0814a> cls) {
            this((Object) null, i, charSequence, (C0813f) null, cls);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo4167a(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.f.c0.f r0 = r4.f2025c
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends androidx.core.f.c0.f$a> r2 = r4.f2024b
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                androidx.core.f.c0.f$a r1 = (androidx.core.p020f.p021c0.C0813f.C0814a) r1     // Catch:{ Exception -> 0x0020 }
                r1.mo4173a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends androidx.core.f.c0.f$a> r1 = r4.f2024b
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r1, r6)
            L_0x0042:
                androidx.core.f.c0.f r6 = r4.f2025c
                boolean r5 = r6.mo4172a(r5, r0)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p020f.p021c0.C0807c.C0808a.mo4167a(android.view.View, android.os.Bundle):boolean");
        }

        C0808a(Object obj, int i, CharSequence charSequence, C0813f fVar, Class<? extends C0813f.C0814a> cls) {
            this.f2025c = fVar;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.f2023a = obj;
            } else {
                this.f2023a = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            }
            this.f2024b = cls;
        }
    }

    /* renamed from: androidx.core.f.c0.c$b */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0809b {

        /* renamed from: a */
        final Object f2026a;

        C0809b(Object obj) {
            this.f2026a = obj;
        }

        /* renamed from: a */
        public static C0809b m2619a(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                return new C0809b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (i4 >= 19) {
                return new C0809b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new C0809b((Object) null);
        }
    }

    /* renamed from: androidx.core.f.c0.c$c */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0810c {

        /* renamed from: a */
        final Object f2027a;

        C0810c(Object obj) {
            this.f2027a = obj;
        }

        /* renamed from: a */
        public static C0810c m2620a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                return new C0810c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (i5 >= 19) {
                return new C0810c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new C0810c((Object) null);
        }
    }

    private C0807c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2014a = accessibilityNodeInfo;
    }

    /* renamed from: a */
    public static C0807c m2550a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C0807c(accessibilityNodeInfo);
    }

    /* renamed from: c */
    private static String m2555c(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE /*128*/:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case OguryChoiceManager.TcfV2.Purpose.DEVELOP_AND_IMPROVE_PRODUCTS /*1024*/:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case CodedOutputStream.DEFAULT_BUFFER_SIZE /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES /*131072*/:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    /* renamed from: x */
    private void m2560x() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2014a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f2014a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f2014a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f2014a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    /* renamed from: y */
    private boolean m2561y() {
        return !m2552a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    /* renamed from: b */
    public int mo4119b() {
        return this.f2014a.getActions();
    }

    /* renamed from: c */
    public void mo4129c(View view) {
        this.f2016c = -1;
        this.f2014a.setSource(view);
    }

    /* renamed from: d */
    public void mo4133d(Rect rect) {
        this.f2014a.setBoundsInScreen(rect);
    }

    /* renamed from: e */
    public void mo4137e(boolean z) {
        this.f2014a.setFocusable(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0807c)) {
            return false;
        }
        C0807c cVar = (C0807c) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2014a;
        if (accessibilityNodeInfo == null) {
            if (cVar.f2014a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(cVar.f2014a)) {
            return false;
        }
        return this.f2016c == cVar.f2016c && this.f2015b == cVar.f2015b;
    }

    /* renamed from: f */
    public int mo4139f() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2014a.getMovementGranularities();
        }
        return 0;
    }

    /* renamed from: g */
    public CharSequence mo4141g() {
        return this.f2014a.getPackageName();
    }

    /* renamed from: h */
    public void mo4144h(boolean z) {
        this.f2014a.setLongClickable(z);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f2014a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* renamed from: i */
    public String mo4146i() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f2014a.getViewIdResourceName();
        }
        return null;
    }

    /* renamed from: j */
    public boolean mo4149j() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2014a.isAccessibilityFocused();
        }
        return false;
    }

    /* renamed from: k */
    public boolean mo4151k() {
        return this.f2014a.isCheckable();
    }

    /* renamed from: l */
    public boolean mo4153l() {
        return this.f2014a.isChecked();
    }

    /* renamed from: m */
    public boolean mo4154m() {
        return this.f2014a.isClickable();
    }

    /* renamed from: n */
    public boolean mo4155n() {
        return this.f2014a.isEnabled();
    }

    /* renamed from: o */
    public boolean mo4156o() {
        return this.f2014a.isFocusable();
    }

    /* renamed from: p */
    public boolean mo4157p() {
        return this.f2014a.isFocused();
    }

    /* renamed from: q */
    public boolean mo4158q() {
        return this.f2014a.isLongClickable();
    }

    /* renamed from: r */
    public boolean mo4159r() {
        return this.f2014a.isPassword();
    }

    /* renamed from: s */
    public boolean mo4160s() {
        return this.f2014a.isScrollable();
    }

    /* renamed from: t */
    public boolean mo4161t() {
        return this.f2014a.isSelected();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        mo4111a(rect);
        sb.append("; boundsInParent: " + rect);
        mo4121b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(mo4141g());
        sb.append("; className: ");
        sb.append(mo4127c());
        sb.append("; text: ");
        sb.append(mo4143h());
        sb.append("; contentDescription: ");
        sb.append(mo4132d());
        sb.append("; viewId: ");
        sb.append(mo4146i());
        sb.append("; checkable: ");
        sb.append(mo4151k());
        sb.append("; checked: ");
        sb.append(mo4153l());
        sb.append("; focusable: ");
        sb.append(mo4156o());
        sb.append("; focused: ");
        sb.append(mo4157p());
        sb.append("; selected: ");
        sb.append(mo4161t());
        sb.append("; clickable: ");
        sb.append(mo4154m());
        sb.append("; longClickable: ");
        sb.append(mo4158q());
        sb.append("; enabled: ");
        sb.append(mo4155n());
        sb.append("; password: ");
        sb.append(mo4159r());
        sb.append("; scrollable: " + mo4160s());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<C0808a> a = mo4109a();
            for (int i = 0; i < a.size(); i++) {
                C0808a aVar = a.get(i);
                String c = m2555c(aVar.mo4166a());
                if (c.equals("ACTION_UNKNOWN") && aVar.mo4168b() != null) {
                    c = aVar.mo4168b().toString();
                }
                sb.append(c);
                if (i != a.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int b = mo4119b();
            while (b != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
                b &= numberOfTrailingZeros ^ -1;
                sb.append(m2555c(numberOfTrailingZeros));
                if (b != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: u */
    public boolean mo4163u() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2014a.isVisibleToUser();
        }
        return false;
    }

    /* renamed from: v */
    public void mo4164v() {
        this.f2014a.recycle();
    }

    /* renamed from: w */
    public AccessibilityNodeInfo mo4165w() {
        return this.f2014a;
    }

    /* renamed from: a */
    public static C0807c m2551a(C0807c cVar) {
        return m2550a(AccessibilityNodeInfo.obtain(cVar.f2014a));
    }

    /* renamed from: e */
    private SparseArray<WeakReference<ClickableSpan>> m2557e(View view) {
        return (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
    }

    /* renamed from: b */
    public boolean mo4126b(C0808a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f2014a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2023a);
        }
        return false;
    }

    /* renamed from: d */
    public void mo4135d(boolean z) {
        this.f2014a.setEnabled(z);
    }

    /* renamed from: g */
    public void mo4142g(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2014a.setHeading(z);
        } else {
            m2553a(2, z);
        }
    }

    /* renamed from: h */
    public CharSequence mo4143h() {
        if (!m2561y()) {
            return this.f2014a.getText();
        }
        List<Integer> a = m2552a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> a2 = m2552a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> a3 = m2552a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> a4 = m2552a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f2014a.getText(), 0, this.f2014a.getText().length()));
        for (int i = 0; i < a.size(); i++) {
            spannableString.setSpan(new C0805a(a4.get(i).intValue(), this, mo4136e().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a.get(i).intValue(), a2.get(i).intValue(), a3.get(i).intValue());
        }
        return spannableString;
    }

    /* renamed from: k */
    public void mo4150k(boolean z) {
        this.f2014a.setSelected(z);
    }

    /* renamed from: l */
    public void mo4152l(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2014a.setVisibleToUser(z);
        }
    }

    /* renamed from: d */
    private SparseArray<WeakReference<ClickableSpan>> m2556d(View view) {
        SparseArray<WeakReference<ClickableSpan>> e = m2557e(view);
        if (e != null) {
            return e;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(R$id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    /* renamed from: e */
    public static ClickableSpan[] m2558e(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    /* renamed from: a */
    public void mo4112a(View view) {
        this.f2014a.addChild(view);
    }

    @Deprecated
    /* renamed from: c */
    public void mo4128c(Rect rect) {
        this.f2014a.setBoundsInParent(rect);
    }

    /* renamed from: f */
    public void mo4140f(boolean z) {
        this.f2014a.setFocused(z);
    }

    /* renamed from: i */
    public void mo4147i(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2014a.setScreenReaderFocusable(z);
        } else {
            m2553a(1, z);
        }
    }

    /* renamed from: j */
    public void mo4148j(boolean z) {
        this.f2014a.setScrollable(z);
    }

    /* renamed from: f */
    private void m2559f(View view) {
        SparseArray<WeakReference<ClickableSpan>> e = m2557e(view);
        if (e != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < e.size(); i++) {
                if (e.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    /* renamed from: a */
    public void mo4110a(int i) {
        this.f2014a.addAction(i);
    }

    /* renamed from: b */
    public void mo4120b(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2014a.setMovementGranularities(i);
        }
    }

    /* renamed from: c */
    public void mo4131c(boolean z) {
        this.f2014a.setClickable(z);
    }

    /* renamed from: a */
    private List<Integer> m2552a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f2014a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f2014a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    /* renamed from: c */
    public void mo4130c(CharSequence charSequence) {
        this.f2014a.setPackageName(charSequence);
    }

    /* renamed from: b */
    public void mo4122b(View view) {
        this.f2015b = -1;
        this.f2014a.setParent(view);
    }

    /* renamed from: c */
    public CharSequence mo4127c() {
        return this.f2014a.getClassName();
    }

    /* renamed from: d */
    public CharSequence mo4132d() {
        return this.f2014a.getContentDescription();
    }

    /* renamed from: e */
    public Bundle mo4136e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f2014a.getExtras();
        }
        return new Bundle();
    }

    /* renamed from: d */
    public void mo4134d(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.f2014a.setPaneTitle(charSequence);
        } else if (i >= 19) {
            this.f2014a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    /* renamed from: b */
    public void mo4121b(Rect rect) {
        this.f2014a.getBoundsInScreen(rect);
    }

    /* renamed from: b */
    public void mo4123b(CharSequence charSequence) {
        this.f2014a.setContentDescription(charSequence);
    }

    /* renamed from: b */
    public void mo4124b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2014a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0810c) obj).f2027a);
        }
    }

    /* renamed from: a */
    public void mo4113a(C0808a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2014a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2023a);
        }
    }

    /* renamed from: b */
    public void mo4125b(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2014a.setCanOpenPopup(z);
        }
    }

    /* renamed from: a */
    public boolean mo4118a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2014a.performAction(i, bundle);
        }
        return false;
    }

    @Deprecated
    /* renamed from: a */
    public void mo4111a(Rect rect) {
        this.f2014a.getBoundsInParent(rect);
    }

    /* renamed from: a */
    public void mo4117a(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2014a.setAccessibilityFocused(z);
        }
    }

    /* renamed from: a */
    public void mo4114a(CharSequence charSequence) {
        this.f2014a.setClassName(charSequence);
    }

    /* renamed from: a */
    public void mo4115a(CharSequence charSequence, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i < 26) {
            m2560x();
            m2559f(view);
            ClickableSpan[] e = m2558e(charSequence);
            if (e != null && e.length > 0) {
                mo4136e().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> d = m2556d(view);
                int i2 = 0;
                while (e != null && i2 < e.length) {
                    int a = m2549a(e[i2], d);
                    d.put(a, new WeakReference(e[i2]));
                    m2554a(e[i2], (Spanned) charSequence, a);
                    i2++;
                }
            }
        }
    }

    /* renamed from: a */
    private int m2549a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f2013d;
        f2013d = i2 + 1;
        return i2;
    }

    /* renamed from: a */
    private void m2554a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        m2552a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        m2552a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        m2552a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        m2552a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo4116a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2014a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((C0809b) obj).f2026a);
        }
    }

    /* renamed from: a */
    public List<C0808a> mo4109a() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f2014a.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new C0808a(actionList.get(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m2553a(int i, boolean z) {
        Bundle e = mo4136e();
        if (e != null) {
            int i2 = e.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ -1);
            if (!z) {
                i = 0;
            }
            e.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
