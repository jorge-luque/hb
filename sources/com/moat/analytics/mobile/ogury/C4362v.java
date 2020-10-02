package com.moat.analytics.mobile.ogury;

import android.graphics.Rect;
import android.location.Location;
import android.util.DisplayMetrics;
import android.view.View;
import com.ogury.p159cm.OguryChoiceManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.ogury.v */
final class C4362v {

    /* renamed from: ʼ */
    private static int f11680 = 0;

    /* renamed from: ˊॱ */
    private static int f11681 = 1;

    /* renamed from: ʻ */
    private Map<String, Object> f11682 = new HashMap();

    /* renamed from: ʽ */
    private Location f11683;

    /* renamed from: ˊ */
    private C4365d f11684 = new C4365d();

    /* renamed from: ˋ */
    private Rect f11685;

    /* renamed from: ˎ */
    String f11686 = "{}";

    /* renamed from: ˏ */
    private JSONObject f11687;

    /* renamed from: ॱ */
    private Rect f11688;

    /* renamed from: ॱॱ */
    private JSONObject f11689;

    /* renamed from: ᐝ */
    private JSONObject f11690;

    /* renamed from: com.moat.analytics.mobile.ogury.v$c */
    static class C4364c {

        /* renamed from: ˊ */
        int f11691 = 0;

        /* renamed from: ˋ */
        final Set<Rect> f11692 = new HashSet();

        /* renamed from: ॱ */
        boolean f11693 = false;

        C4364c() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.ogury.v$d */
    static class C4365d {

        /* renamed from: ˋ */
        double f11694 = 0.0d;

        /* renamed from: ˏ */
        Rect f11695 = new Rect(0, 0, 0, 0);

        /* renamed from: ॱ */
        double f11696 = 0.0d;

        C4365d() {
        }
    }

    /* renamed from: com.moat.analytics.mobile.ogury.v$e */
    static class C4366e {

        /* renamed from: ˊ */
        final Rect f11697;

        /* renamed from: ˋ */
        final View f11698;

        C4366e(View view, C4366e eVar) {
            this.f11698 = view;
            if (eVar != null) {
                Rect rect = eVar.f11697;
                int i = rect.left;
                int i2 = rect.top;
                int left = i + view.getLeft();
                int top = i2 + view.getTop();
                this.f11697 = new Rect(left, top, view.getWidth() + left, view.getHeight() + top);
                return;
            }
            this.f11697 = C4362v.m14589(view);
        }
    }

    C4362v() {
    }

    /* renamed from: ˊ */
    static /* synthetic */ Rect m14589(View view) {
        int i = f11680 + 35;
        f11681 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        if (i % 2 == 0) {
        }
        return m14593(view);
    }

    /* renamed from: ˋ */
    private static Map<String, String> m14592(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put("x", String.valueOf(rect.left));
        hashMap.put("y", String.valueOf(rect.top));
        hashMap.put("w", String.valueOf(rect.right - rect.left));
        hashMap.put("h", String.valueOf(rect.bottom - rect.top));
        int i = f11681 + 107;
        f11680 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        return hashMap;
    }

    /* renamed from: ˎ */
    private static Rect m14593(View view) {
        int[] iArr = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        Rect rect = new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
        int i3 = f11681 + 81;
        f11680 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i4 = i3 % 2;
        return rect;
    }

    /* renamed from: ˏ */
    private static float m14594(View view) {
        float alpha = view.getAlpha();
        int i = f11681 + 73;
        f11680 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        while (true) {
            if ((view != null ? 'X' : 19) == 19) {
                break;
            }
            int i3 = f11681 + 85;
            f11680 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
            int i4 = i3 % 2;
            if (view.getParent() == null) {
                break;
            }
            int i5 = f11681 + 51;
            f11680 = i5 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
            int i6 = i5 % 2;
            if (((double) alpha) == 0.0d) {
                break;
            }
            int i7 = f11681 + 83;
            f11680 = i7 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
            int i8 = i7 % 2;
            if (!(view.getParent() instanceof View)) {
                break;
            }
            alpha *= ((View) view.getParent()).getAlpha();
            view = (View) view.getParent();
        }
        int i9 = f11680 + 17;
        f11681 = i9 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i10 = i9 % 2;
        return alpha;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r3 = new android.graphics.Rect(0, 0, 0, 0);
        r0 = f11680 + 105;
        f11681 = r0 % com.ogury.p159cm.OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r1 != false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r3 != null) goto L_0x001c;
     */
    /* renamed from: ॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Rect m14596(android.view.View r3) {
        /*
            int r0 = f11681
            int r0 = r0 + 17
            int r1 = r0 % 128
            f11680 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            if (r0 == r1) goto L_0x001a
            if (r3 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            if (r1 == 0) goto L_0x0021
            goto L_0x001c
        L_0x001a:
            if (r3 == 0) goto L_0x0021
        L_0x001c:
            android.graphics.Rect r3 = m14593(r3)
            return r3
        L_0x0021:
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>(r2, r2, r2, r2)
            int r0 = f11680
            int r0 = r0 + 105
            int r1 = r0 % 128
            f11681 = r1
            int r0 = r0 % 2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4362v.m14596(android.view.View):android.graphics.Rect");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        r3 = f11681 + 65;
        f11680 = r3 % com.ogury.p159cm.OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        r3 = r3 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        com.moat.analytics.mobile.ogury.C4315e.C43161.m14442(3, "VisibilityInfo", r9, "Short-circuiting chain retrieval, reached max");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b9, code lost:
        r0 = f11681 + 73;
        f11680 = r0 % com.ogury.p159cm.OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
        if ((r0 % 2) == 0) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        com.moat.analytics.mobile.ogury.C4315e.C43161.m14442(5, "VisibilityInfo", r9, "Short-circuiting cover retrieval, reached max");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cb, code lost:
        com.moat.analytics.mobile.ogury.C4315e.C43161.m14442(r6, "VisibilityInfo", r9, "Short-circuiting cover retrieval, reached max");
     */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0141 A[Catch:{ Exception -> 0x0185 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0156  */
    /* renamed from: ॱ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.moat.analytics.mobile.ogury.C4362v.C4364c m14597(android.graphics.Rect r19, android.view.View r20) {
        /*
            com.moat.analytics.mobile.ogury.v$c r1 = new com.moat.analytics.mobile.ogury.v$c
            r1.<init>()
            java.util.ArrayDeque r0 = new java.util.ArrayDeque     // Catch:{ Exception -> 0x0185 }
            r0.<init>()     // Catch:{ Exception -> 0x0185 }
            r3 = r20
            r4 = 0
        L_0x000d:
            android.view.ViewParent r5 = r3.getParent()     // Catch:{ Exception -> 0x0185 }
            r6 = 3
            r7 = 49
            java.lang.String r8 = "VisibilityInfo"
            r9 = 0
            r10 = 2
            r11 = 1
            if (r5 != 0) goto L_0x0044
            int r5 = f11681
            int r5 = r5 + r7
            int r12 = r5 % 128
            f11680 = r12
            int r5 = r5 % r10
            r12 = 46
            if (r5 == 0) goto L_0x002a
            r5 = 46
            goto L_0x002b
        L_0x002a:
            r5 = 7
        L_0x002b:
            if (r5 == r12) goto L_0x0034
            android.view.View r5 = r20.getRootView()     // Catch:{ Exception -> 0x0185 }
            if (r3 != r5) goto L_0x0068
            goto L_0x0044
        L_0x0034:
            android.view.View r5 = r20.getRootView()     // Catch:{ Exception -> 0x0185 }
            super.hashCode()     // Catch:{ Exception -> 0x0185 }
            if (r3 != r5) goto L_0x003f
            r5 = 2
            goto L_0x0041
        L_0x003f:
            r5 = 25
        L_0x0041:
            if (r5 == r10) goto L_0x0044
            goto L_0x0068
        L_0x0044:
            int r4 = r4 + r11
            r5 = 50
            if (r4 <= r5) goto L_0x0058
            int r3 = f11681
            int r3 = r3 + 65
            int r4 = r3 % 128
            f11680 = r4
            int r3 = r3 % r10
            java.lang.String r3 = "Short-circuiting chain retrieval, reached max"
            com.moat.analytics.mobile.ogury.C4315e.C43161.m14442(r6, r8, r9, r3)     // Catch:{ Exception -> 0x0185 }
            goto L_0x0068
        L_0x0058:
            r0.add(r3)     // Catch:{ Exception -> 0x0185 }
            android.view.ViewParent r5 = r3.getParent()     // Catch:{ Exception -> 0x0185 }
            boolean r5 = r5 instanceof android.view.View     // Catch:{ Exception -> 0x0185 }
            if (r5 == 0) goto L_0x0065
            r5 = 0
            goto L_0x0066
        L_0x0065:
            r5 = 1
        L_0x0066:
            if (r5 == 0) goto L_0x0163
        L_0x0068:
            boolean r3 = r0.isEmpty()     // Catch:{ Exception -> 0x0185 }
            if (r3 == 0) goto L_0x0070
            r3 = 1
            goto L_0x0071
        L_0x0070:
            r3 = 0
        L_0x0071:
            if (r3 == 0) goto L_0x0074
            return r1
        L_0x0074:
            java.lang.String r3 = "starting covering rect search"
            r5 = r20
            com.moat.analytics.mobile.ogury.C4315e.C43161.m14443(r8, r5, r3)     // Catch:{ Exception -> 0x0185 }
            r3 = r9
        L_0x007c:
            boolean r4 = r0.isEmpty()     // Catch:{ Exception -> 0x0185 }
            if (r4 != 0) goto L_0x0189
            java.lang.Object r4 = r0.pollLast()     // Catch:{ Exception -> 0x0185 }
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x0185 }
            com.moat.analytics.mobile.ogury.v$e r5 = new com.moat.analytics.mobile.ogury.v$e     // Catch:{ Exception -> 0x0185 }
            r5.<init>(r4, r3)     // Catch:{ Exception -> 0x0185 }
            android.view.ViewParent r12 = r4.getParent()     // Catch:{ Exception -> 0x0185 }
            if (r12 == 0) goto L_0x015d
            android.view.ViewParent r12 = r4.getParent()     // Catch:{ Exception -> 0x0185 }
            boolean r12 = r12 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x0185 }
            if (r12 == 0) goto L_0x015d
            android.view.ViewParent r12 = r4.getParent()     // Catch:{ Exception -> 0x0185 }
            android.view.ViewGroup r12 = (android.view.ViewGroup) r12     // Catch:{ Exception -> 0x0185 }
            int r13 = r12.getChildCount()     // Catch:{ Exception -> 0x0185 }
            r14 = 0
            r15 = 0
        L_0x00a7:
            if (r14 >= r13) goto L_0x015d
            int r16 = f11681
            int r2 = r16 + 91
            int r7 = r2 % 128
            f11680 = r7
            int r2 = r2 % r10
            int r2 = r1.f11691     // Catch:{ Exception -> 0x0185 }
            r7 = 500(0x1f4, float:7.0E-43)
            r11 = 5
            if (r2 < r7) goto L_0x00d0
            int r0 = f11681
            int r0 = r0 + 73
            int r2 = r0 % 128
            f11680 = r2
            int r0 = r0 % r10
            java.lang.String r2 = "Short-circuiting cover retrieval, reached max"
            if (r0 == 0) goto L_0x00cb
            com.moat.analytics.mobile.ogury.C4315e.C43161.m14442(r11, r8, r9, r2)     // Catch:{ Exception -> 0x0185 }
            goto L_0x0189
        L_0x00cb:
            com.moat.analytics.mobile.ogury.C4315e.C43161.m14442(r6, r8, r9, r2)     // Catch:{ Exception -> 0x0185 }
            goto L_0x0189
        L_0x00d0:
            android.view.View r2 = r12.getChildAt(r14)     // Catch:{ Exception -> 0x0185 }
            if (r2 != r4) goto L_0x00de
            r7 = 49
            r11 = 1
            r15 = 1
        L_0x00da:
            r2 = r19
            goto L_0x0158
        L_0x00de:
            int r7 = r1.f11691     // Catch:{ Exception -> 0x0185 }
            r17 = 1
            int r7 = r7 + 1
            r1.f11691 = r7     // Catch:{ Exception -> 0x0185 }
            r7 = 90
            if (r15 == 0) goto L_0x00ef
            r18 = 72
            r6 = 72
            goto L_0x00f1
        L_0x00ef:
            r6 = 90
        L_0x00f1:
            r11 = 21
            if (r6 == r7) goto L_0x0122
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0185 }
            if (r6 < r11) goto L_0x011e
            float r6 = r2.getZ()     // Catch:{ Exception -> 0x0185 }
            float r7 = r4.getZ()     // Catch:{ Exception -> 0x0185 }
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x0106
            goto L_0x011e
        L_0x0106:
            int r6 = f11681
            int r6 = r6 + 89
            int r7 = r6 % 128
            f11680 = r7
            int r6 = r6 % r10
            if (r6 == 0) goto L_0x0114
            r6 = 69
            goto L_0x0116
        L_0x0114:
            r6 = 49
        L_0x0116:
            r7 = 49
            if (r6 == r7) goto L_0x013e
            super.hashCode()
            goto L_0x013e
        L_0x011e:
            r7 = 49
        L_0x0120:
            r6 = 1
            goto L_0x013f
        L_0x0122:
            r7 = 49
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0185 }
            if (r6 < r11) goto L_0x013e
            int r6 = f11680
            r11 = 5
            int r6 = r6 + r11
            int r11 = r6 % 128
            f11681 = r11
            int r6 = r6 % r10
            float r6 = r2.getZ()     // Catch:{ Exception -> 0x0185 }
            float r11 = r4.getZ()     // Catch:{ Exception -> 0x0185 }
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x013e
            goto L_0x0120
        L_0x013e:
            r6 = 0
        L_0x013f:
            if (r6 == 0) goto L_0x0156
            com.moat.analytics.mobile.ogury.v$e r6 = new com.moat.analytics.mobile.ogury.v$e     // Catch:{ Exception -> 0x0185 }
            r6.<init>(r2, r3)     // Catch:{ Exception -> 0x0185 }
            r2 = r19
            m14590(r6, r2, r1)     // Catch:{ Exception -> 0x0185 }
            boolean r6 = r1.f11693     // Catch:{ Exception -> 0x0185 }
            if (r6 == 0) goto L_0x0151
            r6 = 0
            goto L_0x0152
        L_0x0151:
            r6 = 1
        L_0x0152:
            r11 = 1
            if (r6 == r11) goto L_0x0158
            return r1
        L_0x0156:
            r11 = 1
            goto L_0x00da
        L_0x0158:
            int r14 = r14 + 1
            r6 = 3
            goto L_0x00a7
        L_0x015d:
            r2 = r19
            r3 = r5
            r6 = 3
            goto L_0x007c
        L_0x0163:
            r2 = r19
            r5 = r20
            int r6 = f11680
            int r6 = r6 + 109
            int r7 = r6 % 128
            f11681 = r7
            int r6 = r6 % r10
            if (r6 != 0) goto L_0x017d
            android.view.ViewParent r3 = r3.getParent()     // Catch:{ Exception -> 0x0185 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ Exception -> 0x0185 }
            super.hashCode()     // Catch:{ Exception -> 0x0185 }
            goto L_0x000d
        L_0x017d:
            android.view.ViewParent r3 = r3.getParent()     // Catch:{ Exception -> 0x0185 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ Exception -> 0x0185 }
            goto L_0x000d
        L_0x0185:
            r0 = move-exception
            com.moat.analytics.mobile.ogury.C4332l.m14509(r0)
        L_0x0189:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4362v.m14597(android.graphics.Rect, android.view.View):com.moat.analytics.mobile.ogury.v$c");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: java.util.HashMap} */
    /* JADX WARNING: type inference failed for: r5v13, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0220, code lost:
        if (r13.f11695.equals(r1.f11684.f11695) != false) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0280, code lost:
        if (r9.equals(r1.f11685) == false) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
        if (r19.getWindowToken() != null) goto L_0x007d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0200 A[SYNTHETIC, Splitter:B:122:0x0200] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0216 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x022c A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x022d A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0272 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0275 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0279 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x027a A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02b3 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02b7 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02ba A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0084 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0098 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009c A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b3 A[SYNTHETIC, Splitter:B:52:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f1 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f3 A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x013d A[Catch:{ Exception -> 0x034f }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0167 A[SYNTHETIC, Splitter:B:84:0x0167] */
    /* renamed from: ˊ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo29192(java.lang.String r18, android.view.View r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "{}"
            if (r0 == 0) goto L_0x0355
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x034f }
            r5 = 17
            r6 = 1
            r7 = 0
            if (r4 < r5) goto L_0x0044
            java.lang.ref.WeakReference<android.app.Activity> r4 = com.moat.analytics.mobile.ogury.C4307a.f11485     // Catch:{ Exception -> 0x034f }
            if (r4 == 0) goto L_0x001b
            r4 = 0
            goto L_0x001c
        L_0x001b:
            r4 = 1
        L_0x001c:
            if (r4 == 0) goto L_0x001f
            goto L_0x0044
        L_0x001f:
            int r4 = f11680
            int r4 = r4 + 95
            int r5 = r4 % 128
            f11681 = r5
            int r4 = r4 % 2
            java.lang.ref.WeakReference<android.app.Activity> r4 = com.moat.analytics.mobile.ogury.C4307a.f11485     // Catch:{ Exception -> 0x034f }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x034f }
            android.app.Activity r4 = (android.app.Activity) r4     // Catch:{ Exception -> 0x034f }
            if (r4 == 0) goto L_0x0044
            android.util.DisplayMetrics r5 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x034f }
            r5.<init>()     // Catch:{ Exception -> 0x034f }
            android.view.WindowManager r4 = r4.getWindowManager()     // Catch:{ Exception -> 0x034f }
            android.view.Display r4 = r4.getDefaultDisplay()     // Catch:{ Exception -> 0x034f }
            r4.getRealMetrics(r5)     // Catch:{ Exception -> 0x034f }
            goto L_0x0050
        L_0x0044:
            android.content.Context r4 = r19.getContext()     // Catch:{ Exception -> 0x034f }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x034f }
            android.util.DisplayMetrics r5 = r4.getDisplayMetrics()     // Catch:{ Exception -> 0x034f }
        L_0x0050:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x034f }
            r8 = 37
            r9 = 19
            r10 = 21
            if (r4 < r9) goto L_0x0075
            if (r0 == 0) goto L_0x007f
            boolean r4 = r19.isAttachedToWindow()     // Catch:{ Exception -> 0x034f }
            r11 = 33
            if (r4 == 0) goto L_0x0067
            r4 = 37
            goto L_0x0069
        L_0x0067:
            r4 = 33
        L_0x0069:
            if (r4 == r11) goto L_0x007f
            int r4 = f11681
            int r4 = r4 + r10
            int r11 = r4 % 128
            f11680 = r11
            int r4 = r4 % 2
            goto L_0x007d
        L_0x0075:
            if (r0 == 0) goto L_0x007f
            android.os.IBinder r4 = r19.getWindowToken()     // Catch:{ Exception -> 0x034f }
            if (r4 == 0) goto L_0x007f
        L_0x007d:
            r4 = 1
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            r11 = 62
            if (r0 == 0) goto L_0x0087
            r12 = 71
            goto L_0x0089
        L_0x0087:
            r12 = 62
        L_0x0089:
            if (r12 == r11) goto L_0x0093
            boolean r11 = r19.hasWindowFocus()     // Catch:{ Exception -> 0x034f }
            if (r11 == 0) goto L_0x0093
            r11 = 1
            goto L_0x0094
        L_0x0093:
            r11 = 0
        L_0x0094:
            if (r0 == 0) goto L_0x0098
            r12 = 0
            goto L_0x0099
        L_0x0098:
            r12 = 1
        L_0x0099:
            if (r12 == 0) goto L_0x009c
            goto L_0x00a2
        L_0x009c:
            boolean r12 = r19.isShown()     // Catch:{ Exception -> 0x034f }
            if (r12 != 0) goto L_0x00a4
        L_0x00a2:
            r12 = 1
            goto L_0x00a5
        L_0x00a4:
            r12 = 0
        L_0x00a5:
            if (r0 != 0) goto L_0x00b3
            int r13 = f11681
            int r13 = r13 + 65
            int r14 = r13 % 128
            f11680 = r14
            int r13 = r13 % 2
            r13 = 0
            goto L_0x00b7
        L_0x00b3:
            float r13 = m14594(r19)     // Catch:{ Exception -> 0x034f }
        L_0x00b7:
            java.lang.String r14 = "dr"
            float r15 = r5.density     // Catch:{ Exception -> 0x034f }
            java.lang.Float r15 = java.lang.Float.valueOf(r15)     // Catch:{ Exception -> 0x034f }
            r2.put(r14, r15)     // Catch:{ Exception -> 0x034f }
            java.lang.String r14 = "dv"
            double r15 = com.moat.analytics.mobile.ogury.C4356s.m14572()     // Catch:{ Exception -> 0x034f }
            java.lang.Double r15 = java.lang.Double.valueOf(r15)     // Catch:{ Exception -> 0x034f }
            r2.put(r14, r15)     // Catch:{ Exception -> 0x034f }
            java.lang.String r14 = "adKey"
            r15 = r18
            r2.put(r14, r15)     // Catch:{ Exception -> 0x034f }
            java.lang.String r14 = "isAttached"
            if (r4 == 0) goto L_0x00e5
            int r15 = f11681
            int r15 = r15 + r9
            int r9 = r15 % 128
            f11680 = r9
            int r15 = r15 % 2
            r9 = 1
            goto L_0x00e6
        L_0x00e5:
            r9 = 0
        L_0x00e6:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x034f }
            r2.put(r14, r9)     // Catch:{ Exception -> 0x034f }
            java.lang.String r9 = "inFocus"
            if (r11 == 0) goto L_0x00f3
            r14 = 1
            goto L_0x00f4
        L_0x00f3:
            r14 = 0
        L_0x00f4:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x034f }
            r2.put(r9, r14)     // Catch:{ Exception -> 0x034f }
            java.lang.String r9 = "isHidden"
            if (r12 == 0) goto L_0x010b
            int r14 = f11681
            int r14 = r14 + 25
            int r15 = r14 % 128
            f11680 = r15
            int r14 = r14 % 2
            r14 = 1
            goto L_0x010c
        L_0x010b:
            r14 = 0
        L_0x010c:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x034f }
            r2.put(r9, r14)     // Catch:{ Exception -> 0x034f }
            java.lang.String r9 = "opacity"
            java.lang.Float r13 = java.lang.Float.valueOf(r13)     // Catch:{ Exception -> 0x034f }
            r2.put(r9, r13)     // Catch:{ Exception -> 0x034f }
            int r9 = r5.widthPixels     // Catch:{ Exception -> 0x034f }
            int r13 = r5.heightPixels     // Catch:{ Exception -> 0x034f }
            android.graphics.Rect r14 = new android.graphics.Rect     // Catch:{ Exception -> 0x034f }
            r14.<init>(r7, r7, r9, r13)     // Catch:{ Exception -> 0x034f }
            if (r0 == 0) goto L_0x013d
            int r9 = f11681
            int r9 = r9 + 61
            int r13 = r9 % 128
            f11680 = r13
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x0138
            android.graphics.Rect r9 = m14593(r19)     // Catch:{ Exception -> 0x034f }
            goto L_0x0142
        L_0x0138:
            android.graphics.Rect r9 = m14593(r19)     // Catch:{ Exception -> 0x034f }
            goto L_0x0142
        L_0x013d:
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ Exception -> 0x034f }
            r9.<init>(r7, r7, r7, r7)     // Catch:{ Exception -> 0x034f }
        L_0x0142:
            com.moat.analytics.mobile.ogury.v$d r13 = new com.moat.analytics.mobile.ogury.v$d     // Catch:{ Exception -> 0x034f }
            r13.<init>()     // Catch:{ Exception -> 0x034f }
            int r15 = r9.width()     // Catch:{ Exception -> 0x034f }
            int r16 = r9.height()     // Catch:{ Exception -> 0x034f }
            int r15 = r15 * r16
            r16 = 49
            r10 = 0
            if (r0 == 0) goto L_0x01dd
            if (r4 == 0) goto L_0x01dd
            if (r11 == 0) goto L_0x01dd
            if (r12 != 0) goto L_0x01dd
            int r4 = f11681
            int r4 = r4 + r8
            int r8 = r4 % 128
            f11680 = r8
            int r4 = r4 % 2
            if (r15 <= 0) goto L_0x01dd
            android.graphics.Rect r4 = new android.graphics.Rect     // Catch:{ Exception -> 0x034f }
            r4.<init>(r7, r7, r7, r7)     // Catch:{ Exception -> 0x034f }
            boolean r8 = m14598((android.view.View) r0, (android.graphics.Rect) r4)     // Catch:{ Exception -> 0x034f }
            if (r8 == 0) goto L_0x01dd
            int r8 = r4.width()     // Catch:{ Exception -> 0x034f }
            int r11 = r4.height()     // Catch:{ Exception -> 0x034f }
            int r8 = r8 * r11
            if (r8 >= r15) goto L_0x019d
            int r11 = f11681
            int r11 = r11 + 49
            int r12 = r11 % 128
            f11680 = r12
            int r11 = r11 % 2
            if (r11 == 0) goto L_0x018c
            r11 = 1
            goto L_0x018d
        L_0x018c:
            r11 = 0
        L_0x018d:
            java.lang.String r12 = "Ad is clipped"
            java.lang.String r7 = "VisibilityInfo"
            if (r11 == r6) goto L_0x0197
            com.moat.analytics.mobile.ogury.C4315e.C43161.m14443(r7, r10, r12)     // Catch:{ Exception -> 0x034f }
            goto L_0x019d
        L_0x0197:
            com.moat.analytics.mobile.ogury.C4315e.C43161.m14443(r7, r10, r12)     // Catch:{ Exception -> 0x034f }
            super.hashCode()     // Catch:{ Exception -> 0x034f }
        L_0x019d:
            android.view.View r7 = r19.getRootView()     // Catch:{ Exception -> 0x034f }
            boolean r7 = r7 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x034f }
            if (r7 == 0) goto L_0x01dd
            r13.f11695 = r4     // Catch:{ Exception -> 0x034f }
            com.moat.analytics.mobile.ogury.v$c r0 = m14597((android.graphics.Rect) r4, (android.view.View) r0)     // Catch:{ Exception -> 0x034f }
            boolean r7 = r0.f11693     // Catch:{ Exception -> 0x034f }
            if (r7 == 0) goto L_0x01b4
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r13.f11694 = r7     // Catch:{ Exception -> 0x034f }
            goto L_0x01dd
        L_0x01b4:
            java.util.Set<android.graphics.Rect> r0 = r0.f11692     // Catch:{ Exception -> 0x034f }
            int r0 = m14595(r4, r0)     // Catch:{ Exception -> 0x034f }
            if (r0 <= 0) goto L_0x01d1
            int r4 = f11680
            int r4 = r4 + 59
            int r7 = r4 % 128
            f11681 = r7
            int r4 = r4 % 2
            double r11 = (double) r0
            double r6 = (double) r8
            java.lang.Double.isNaN(r11)
            java.lang.Double.isNaN(r6)
            double r11 = r11 / r6
            r13.f11694 = r11     // Catch:{ Exception -> 0x034f }
        L_0x01d1:
            int r8 = r8 - r0
            double r6 = (double) r8
            double r11 = (double) r15
            java.lang.Double.isNaN(r6)
            java.lang.Double.isNaN(r11)
            double r6 = r6 / r11
            r13.f11696 = r6     // Catch:{ Exception -> 0x034f }
        L_0x01dd:
            org.json.JSONObject r0 = r1.f11687     // Catch:{ Exception -> 0x034f }
            if (r0 == 0) goto L_0x022f
            double r6 = r13.f11696     // Catch:{ Exception -> 0x034f }
            com.moat.analytics.mobile.ogury.v$d r0 = r1.f11684     // Catch:{ Exception -> 0x034f }
            double r11 = r0.f11696     // Catch:{ Exception -> 0x034f }
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x022f
            int r0 = f11680
            int r0 = r0 + 93
            int r6 = r0 % 128
            f11681 = r6
            int r0 = r0 % 2
            r6 = 89
            if (r0 != 0) goto L_0x01fc
            r0 = 49
            goto L_0x01fe
        L_0x01fc:
            r0 = 89
        L_0x01fe:
            if (r0 == r6) goto L_0x0216
            android.graphics.Rect r0 = r13.f11695     // Catch:{ Exception -> 0x034f }
            com.moat.analytics.mobile.ogury.v$d r6 = r1.f11684     // Catch:{ Exception -> 0x034f }
            android.graphics.Rect r6 = r6.f11695     // Catch:{ Exception -> 0x034f }
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x034f }
            r6 = 36
            if (r0 == 0) goto L_0x0211
            r0 = 41
            goto L_0x0213
        L_0x0211:
            r0 = 36
        L_0x0213:
            if (r0 == r6) goto L_0x022f
            goto L_0x0222
        L_0x0216:
            android.graphics.Rect r0 = r13.f11695     // Catch:{ Exception -> 0x034f }
            com.moat.analytics.mobile.ogury.v$d r6 = r1.f11684     // Catch:{ Exception -> 0x034f }
            android.graphics.Rect r6 = r6.f11695     // Catch:{ Exception -> 0x034f }
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x034f }
            if (r0 == 0) goto L_0x022f
        L_0x0222:
            double r6 = r13.f11694     // Catch:{ Exception -> 0x034f }
            com.moat.analytics.mobile.ogury.v$d r0 = r1.f11684     // Catch:{ Exception -> 0x034f }
            double r11 = r0.f11694     // Catch:{ Exception -> 0x034f }
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x022d
            goto L_0x022f
        L_0x022d:
            r0 = 0
            goto L_0x0245
        L_0x022f:
            r1.f11684 = r13     // Catch:{ Exception -> 0x034f }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x034f }
            com.moat.analytics.mobile.ogury.v$d r6 = r1.f11684     // Catch:{ Exception -> 0x034f }
            android.graphics.Rect r6 = r6.f11695     // Catch:{ Exception -> 0x034f }
            android.graphics.Rect r6 = m14591(r6, r5)     // Catch:{ Exception -> 0x034f }
            java.util.Map r6 = m14592(r6)     // Catch:{ Exception -> 0x034f }
            r0.<init>(r6)     // Catch:{ Exception -> 0x034f }
            r1.f11687 = r0     // Catch:{ Exception -> 0x034f }
            r0 = 1
        L_0x0245:
            java.lang.String r6 = "coveredPercent"
            double r7 = r13.f11694     // Catch:{ Exception -> 0x034f }
            java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x034f }
            r2.put(r6, r7)     // Catch:{ Exception -> 0x034f }
            org.json.JSONObject r6 = r1.f11689     // Catch:{ Exception -> 0x034f }
            if (r6 == 0) goto L_0x025c
            android.graphics.Rect r6 = r1.f11688     // Catch:{ Exception -> 0x034f }
            boolean r6 = r14.equals(r6)     // Catch:{ Exception -> 0x034f }
            if (r6 != 0) goto L_0x026e
        L_0x025c:
            r1.f11688 = r14     // Catch:{ Exception -> 0x034f }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x034f }
            android.graphics.Rect r6 = m14591(r14, r5)     // Catch:{ Exception -> 0x034f }
            java.util.Map r6 = m14592(r6)     // Catch:{ Exception -> 0x034f }
            r0.<init>(r6)     // Catch:{ Exception -> 0x034f }
            r1.f11689 = r0     // Catch:{ Exception -> 0x034f }
            r0 = 1
        L_0x026e:
            org.json.JSONObject r6 = r1.f11690     // Catch:{ Exception -> 0x034f }
            if (r6 == 0) goto L_0x0275
            r4 = 1
            r7 = 1
            goto L_0x0277
        L_0x0275:
            r4 = 1
            r7 = 0
        L_0x0277:
            if (r7 == r4) goto L_0x027a
            goto L_0x0282
        L_0x027a:
            android.graphics.Rect r6 = r1.f11685     // Catch:{ Exception -> 0x034f }
            boolean r6 = r9.equals(r6)     // Catch:{ Exception -> 0x034f }
            if (r6 != 0) goto L_0x0294
        L_0x0282:
            r1.f11685 = r9     // Catch:{ Exception -> 0x034f }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x034f }
            android.graphics.Rect r5 = m14591(r9, r5)     // Catch:{ Exception -> 0x034f }
            java.util.Map r5 = m14592(r5)     // Catch:{ Exception -> 0x034f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x034f }
            r1.f11690 = r0     // Catch:{ Exception -> 0x034f }
            r0 = 1
        L_0x0294:
            java.util.Map<java.lang.String, java.lang.Object> r5 = r1.f11682     // Catch:{ Exception -> 0x034f }
            if (r5 == 0) goto L_0x02a0
            java.util.Map<java.lang.String, java.lang.Object> r5 = r1.f11682     // Catch:{ Exception -> 0x034f }
            boolean r5 = r2.equals(r5)     // Catch:{ Exception -> 0x034f }
            if (r5 != 0) goto L_0x02a3
        L_0x02a0:
            r1.f11682 = r2     // Catch:{ Exception -> 0x034f }
            r0 = 1
        L_0x02a3:
            com.moat.analytics.mobile.ogury.m r2 = com.moat.analytics.mobile.ogury.C4333m.m14517()     // Catch:{ Exception -> 0x034f }
            android.location.Location r2 = r2.mo29177()     // Catch:{ Exception -> 0x034f }
            android.location.Location r5 = r1.f11683     // Catch:{ Exception -> 0x034f }
            boolean r5 = com.moat.analytics.mobile.ogury.C4333m.m14523(r2, r5)     // Catch:{ Exception -> 0x034f }
            if (r5 != 0) goto L_0x02b7
            r1.f11683 = r2     // Catch:{ Exception -> 0x034f }
            r6 = 1
            goto L_0x02b8
        L_0x02b7:
            r6 = r0
        L_0x02b8:
            if (r6 == 0) goto L_0x034e
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x034f }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r1.f11682     // Catch:{ Exception -> 0x034f }
            r0.<init>(r4)     // Catch:{ Exception -> 0x034f }
            java.lang.String r4 = "screen"
            org.json.JSONObject r5 = r1.f11689     // Catch:{ Exception -> 0x034f }
            r0.accumulate(r4, r5)     // Catch:{ Exception -> 0x034f }
            java.lang.String r4 = "view"
            org.json.JSONObject r5 = r1.f11690     // Catch:{ Exception -> 0x034f }
            r0.accumulate(r4, r5)     // Catch:{ Exception -> 0x034f }
            java.lang.String r4 = "visible"
            org.json.JSONObject r5 = r1.f11687     // Catch:{ Exception -> 0x034f }
            r0.accumulate(r4, r5)     // Catch:{ Exception -> 0x034f }
            java.lang.String r4 = "maybe"
            org.json.JSONObject r5 = r1.f11687     // Catch:{ Exception -> 0x034f }
            r0.accumulate(r4, r5)     // Catch:{ Exception -> 0x034f }
            java.lang.String r4 = "visiblePercent"
            com.moat.analytics.mobile.ogury.v$d r5 = r1.f11684     // Catch:{ Exception -> 0x034f }
            double r5 = r5.f11696     // Catch:{ Exception -> 0x034f }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x034f }
            r0.accumulate(r4, r5)     // Catch:{ Exception -> 0x034f }
            if (r2 == 0) goto L_0x02ef
            r4 = 21
            goto L_0x02f1
        L_0x02ef:
            r4 = 86
        L_0x02f1:
            r5 = 21
            if (r4 == r5) goto L_0x02f6
            goto L_0x0348
        L_0x02f6:
            java.lang.String r4 = "location"
            if (r2 != 0) goto L_0x02fc
            r5 = r10
            goto L_0x0335
        L_0x02fc:
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x034f }
            r5.<init>()     // Catch:{ Exception -> 0x034f }
            java.lang.String r6 = "latitude"
            double r7 = r2.getLatitude()     // Catch:{ Exception -> 0x034f }
            java.lang.String r7 = java.lang.Double.toString(r7)     // Catch:{ Exception -> 0x034f }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x034f }
            java.lang.String r6 = "longitude"
            double r7 = r2.getLongitude()     // Catch:{ Exception -> 0x034f }
            java.lang.String r7 = java.lang.Double.toString(r7)     // Catch:{ Exception -> 0x034f }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x034f }
            java.lang.String r6 = "timestamp"
            long r7 = r2.getTime()     // Catch:{ Exception -> 0x034f }
            java.lang.String r7 = java.lang.Long.toString(r7)     // Catch:{ Exception -> 0x034f }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x034f }
            java.lang.String r6 = "horizontalAccuracy"
            float r2 = r2.getAccuracy()     // Catch:{ Exception -> 0x034f }
            java.lang.String r2 = java.lang.Float.toString(r2)     // Catch:{ Exception -> 0x034f }
            r5.put(r6, r2)     // Catch:{ Exception -> 0x034f }
        L_0x0335:
            r2 = 29
            if (r5 != 0) goto L_0x033c
            r6 = 29
            goto L_0x033e
        L_0x033c:
            r6 = 85
        L_0x033e:
            if (r6 == r2) goto L_0x0345
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x034f }
            r10.<init>(r5)     // Catch:{ Exception -> 0x034f }
        L_0x0345:
            r0.accumulate(r4, r10)     // Catch:{ Exception -> 0x034f }
        L_0x0348:
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x034f }
            r1.f11686 = r3     // Catch:{ Exception -> 0x034f }
        L_0x034e:
            return
        L_0x034f:
            r0 = move-exception
            com.moat.analytics.mobile.ogury.C4332l.m14509(r0)
            r1.f11686 = r3
        L_0x0355:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4362v.mo29192(java.lang.String, android.view.View):void");
    }

    /* renamed from: ˋ */
    private static Rect m14591(Rect rect, DisplayMetrics displayMetrics) {
        float f = displayMetrics.density;
        if (!(f == 0.0f)) {
            return new Rect(Math.round(((float) rect.left) / f), Math.round(((float) rect.top) / f), Math.round(((float) rect.right) / f), Math.round(((float) rect.bottom) / f));
        }
        int i = f11680 + 27;
        f11681 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i2 = i % 2;
        int i3 = f11680 + 17;
        f11681 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i4 = i3 % 2;
        return rect;
    }

    /* renamed from: ˏ */
    private static int m14595(Rect rect, Set<Rect> set) {
        int i;
        int i2 = f11680 + 41;
        f11681 = i2 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        if (!(i2 % 2 == 0)) {
            if (set.isEmpty()) {
                return 0;
            }
            i = 0;
        } else if (set.isEmpty()) {
            return 1;
        } else {
            i = 1;
        }
        ArrayList<Rect> arrayList = new ArrayList<>();
        arrayList.addAll(set);
        Collections.sort(arrayList, new Comparator<Rect>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return Integer.valueOf(((Rect) obj).top).compareTo(Integer.valueOf(((Rect) obj2).top));
            }
        });
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if ((it.hasNext() ? (char) 3 : 21) != 3) {
                break;
            }
            Rect rect2 = (Rect) it.next();
            arrayList2.add(Integer.valueOf(rect2.left));
            arrayList2.add(Integer.valueOf(rect2.right));
        }
        Collections.sort(arrayList2);
        int i3 = f11680 + 29;
        f11681 = i3 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        int i4 = i3 % 2;
        int i5 = 0;
        while (true) {
            if (i5 >= arrayList2.size() - 1) {
                return i;
            }
            int i6 = i5 + 1;
            if (!((Integer) arrayList2.get(i5)).equals(arrayList2.get(i6))) {
                Rect rect3 = new Rect(((Integer) arrayList2.get(i5)).intValue(), rect.top, ((Integer) arrayList2.get(i6)).intValue(), rect.bottom);
                int i7 = rect.top;
                for (Rect rect4 : arrayList) {
                    if (Rect.intersects(rect4, rect3)) {
                        if (!(rect4.bottom <= i7)) {
                            i += rect3.width() * (rect4.bottom - Math.max(i7, rect4.top));
                            i7 = rect4.bottom;
                        }
                        if (rect4.bottom == rect3.bottom) {
                            break;
                        }
                    }
                }
            }
            i5 = i6;
        }
    }

    /* renamed from: ॱ */
    private static boolean m14598(View view, Rect rect) {
        int i = f11681 + 45;
        f11680 = i % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
        if ((i % 2 == 0) ? !view.getGlobalVisibleRect(rect) : !view.getGlobalVisibleRect(rect)) {
            int i2 = f11680 + 73;
            f11681 = i2 % OguryChoiceManager.TcfV2.Purpose.MEASURE_AD_PERFORMANCE;
            int i3 = i2 % 2;
            return false;
        }
        int[] iArr = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationInWindow(iArr);
        int[] iArr2 = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(iArr2);
        rect.offset(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00a4 A[EDGE_INSN: B:78:0x00a4->B:49:0x00a4 ?: BREAK  , SYNTHETIC] */
    /* renamed from: ˊ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m14590(com.moat.analytics.mobile.ogury.C4362v.C4366e r9, android.graphics.Rect r10, com.moat.analytics.mobile.ogury.C4362v.C4364c r11) {
        /*
            android.view.View r0 = r9.f11698
            boolean r1 = r0.isShown()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            if (r1 == 0) goto L_0x001c
            float r0 = r0.getAlpha()
            double r0 = (double) r0
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 != 0) goto L_0x0020
            return
        L_0x0020:
            android.view.View r0 = r9.f11698
            boolean r1 = r0 instanceof android.view.ViewGroup
            r4 = 2
            if (r1 == 0) goto L_0x00a3
            java.lang.Class<android.view.ViewGroup> r1 = android.view.ViewGroup.class
            java.lang.Class r0 = r0.getClass()
            java.lang.Class r0 = r0.getSuperclass()
            boolean r0 = r1.equals(r0)
            android.view.View r1 = r9.f11698
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 19
            if (r5 < r6) goto L_0x0063
            android.graphics.drawable.Drawable r5 = r1.getBackground()
            if (r5 == 0) goto L_0x0045
            r5 = 0
            goto L_0x0046
        L_0x0045:
            r5 = 1
        L_0x0046:
            if (r5 == r3) goto L_0x005a
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            int r1 = r1.getAlpha()
            if (r1 != 0) goto L_0x0054
            r1 = 0
            goto L_0x0055
        L_0x0054:
            r1 = 1
        L_0x0055:
            if (r1 == r3) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r1 = 0
            goto L_0x0064
        L_0x005a:
            int r1 = f11681
            int r1 = r1 + 59
            int r5 = r1 % 128
            f11680 = r5
            int r1 = r1 % r4
        L_0x0063:
            r1 = 1
        L_0x0064:
            if (r0 == 0) goto L_0x0070
            if (r1 == 0) goto L_0x006a
            r0 = 1
            goto L_0x006b
        L_0x006a:
            r0 = 0
        L_0x006b:
            if (r0 == r3) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r0 = 0
            goto L_0x0071
        L_0x0070:
            r0 = 1
        L_0x0071:
            android.view.View r1 = r9.f11698
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r5 = r1.getChildCount()
            r6 = 0
        L_0x007a:
            r7 = 44
            if (r6 >= r5) goto L_0x0081
            r8 = 16
            goto L_0x0083
        L_0x0081:
            r8 = 44
        L_0x0083:
            if (r8 == r7) goto L_0x00a4
            int r7 = r11.f11691
            int r7 = r7 + r3
            r11.f11691 = r7
            r8 = 500(0x1f4, float:7.0E-43)
            if (r7 <= r8) goto L_0x008f
            return
        L_0x008f:
            com.moat.analytics.mobile.ogury.v$e r7 = new com.moat.analytics.mobile.ogury.v$e
            android.view.View r8 = r1.getChildAt(r6)
            r7.<init>(r8, r9)
            m14590(r7, r10, r11)
            boolean r7 = r11.f11693
            if (r7 == 0) goto L_0x00a0
            return
        L_0x00a0:
            int r6 = r6 + 1
            goto L_0x007a
        L_0x00a3:
            r0 = 1
        L_0x00a4:
            if (r0 == 0) goto L_0x014c
            int r0 = f11681
            int r0 = r0 + 33
            int r1 = r0 % 128
            f11680 = r1
            int r0 = r0 % r4
            android.graphics.Rect r0 = r9.f11697
            boolean r1 = r0.setIntersect(r10, r0)
            if (r1 == 0) goto L_0x014c
            int r1 = f11680
            int r1 = r1 + 89
            int r5 = r1 % 128
            f11681 = r5
            int r1 = r1 % r4
            int r1 = android.os.Build.VERSION.SDK_INT
            r5 = 22
            if (r1 < r5) goto L_0x0100
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>(r2, r2, r2, r2)
            android.view.View r1 = r9.f11698
            boolean r1 = m14598((android.view.View) r1, (android.graphics.Rect) r0)
            r5 = 65
            if (r1 == 0) goto L_0x00d8
            r1 = 65
            goto L_0x00da
        L_0x00d8:
            r1 = 96
        L_0x00da:
            if (r1 == r5) goto L_0x00dd
            return
        L_0x00dd:
            int r1 = f11680
            int r1 = r1 + 61
            int r5 = r1 % 128
            f11681 = r5
            int r1 = r1 % r4
            if (r1 != 0) goto L_0x00ea
            r1 = 1
            goto L_0x00eb
        L_0x00ea:
            r1 = 0
        L_0x00eb:
            if (r1 == 0) goto L_0x00f6
            android.graphics.Rect r1 = r9.f11697
            boolean r0 = r1.setIntersect(r0, r1)
            if (r0 != 0) goto L_0x00ff
            return
        L_0x00f6:
            android.graphics.Rect r1 = r9.f11697
            boolean r0 = r1.setIntersect(r0, r1)
            if (r0 != 0) goto L_0x00ff
            return
        L_0x00ff:
            r0 = r1
        L_0x0100:
            com.moat.analytics.mobile.ogury.q r1 = com.moat.analytics.mobile.ogury.C4346q.m14542()
            boolean r1 = r1.f11637
            if (r1 == 0) goto L_0x013f
            int r1 = f11681
            int r1 = r1 + 39
            int r5 = r1 % 128
            f11680 = r5
            int r1 = r1 % r4
            android.view.View r1 = r9.f11698
            java.util.Locale r5 = java.util.Locale.ROOT
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Class r7 = r1.getClass()
            java.lang.String r7 = r7.getName()
            r6[r2] = r7
            java.lang.String r2 = r0.toString()
            r6[r3] = r2
            android.view.View r9 = r9.f11698
            float r9 = r9.getAlpha()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r6[r4] = r9
            java.lang.String r9 = "Covered by %s-%s alpha=%f"
            java.lang.String r9 = java.lang.String.format(r5, r9, r6)
            java.lang.String r2 = "VisibilityInfo"
            com.moat.analytics.mobile.ogury.C4315e.C43161.m14443(r2, r1, r9)
        L_0x013f:
            java.util.Set<android.graphics.Rect> r9 = r11.f11692
            r9.add(r0)
            boolean r9 = r0.contains(r10)
            if (r9 == 0) goto L_0x014c
            r11.f11693 = r3
        L_0x014c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.ogury.C4362v.m14590(com.moat.analytics.mobile.ogury.v$e, android.graphics.Rect, com.moat.analytics.mobile.ogury.v$c):void");
    }
}
