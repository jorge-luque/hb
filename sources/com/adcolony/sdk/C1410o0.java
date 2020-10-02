package com.adcolony.sdk;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/* renamed from: com.adcolony.sdk.o0 */
class C1410o0 {

    /* renamed from: a */
    private static int f4457a;

    /* renamed from: b */
    private static int f4458b;

    /* renamed from: c */
    private static int f4459c;

    /* renamed from: d */
    private static int f4460d;

    /* renamed from: com.adcolony.sdk.o0$a */
    private static class C1411a {
        private C1411a() {
        }

        /* renamed from: a */
        static int m5524a(WindowManager windowManager) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            return point.y;
        }
    }

    /* renamed from: com.adcolony.sdk.o0$b */
    private static class C1412b {
        private C1412b() {
        }

        /* renamed from: a */
        static int m5525a(WindowManager windowManager) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            return point.x;
        }
    }

    C1410o0() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x013a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x013b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static float m5515a(android.view.View r9, android.content.Context r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x0141
            if (r10 != 0) goto L_0x0007
            goto L_0x0141
        L_0x0007:
            int r1 = r9.getVisibility()
            if (r1 != 0) goto L_0x0141
            float r1 = m5521b((android.view.View) r9)
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L_0x0017
            goto L_0x0141
        L_0x0017:
            if (r11 != 0) goto L_0x001a
            return r0
        L_0x001a:
            if (r13 == 0) goto L_0x002c
            boolean r11 = r10 instanceof android.app.Activity
            if (r11 == 0) goto L_0x002c
            r11 = r10
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.hasWindowFocus()
            if (r11 != 0) goto L_0x002c
            if (r14 != 0) goto L_0x002c
            return r0
        L_0x002c:
            int r11 = r9.getHeight()
            r13 = 1120403456(0x42c80000, float:100.0)
            r14 = 2
            r1 = 0
            r2 = 1
            if (r11 <= 0) goto L_0x00c3
            int r11 = r9.getWidth()
            if (r11 <= 0) goto L_0x00c3
            int r11 = r9.getHeight()
            int r3 = r9.getWidth()
            int r11 = r11 * r3
            float r11 = (float) r11
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            boolean r4 = r9.getGlobalVisibleRect(r3)
            int[] r5 = new int[r14]
            r5 = {-1, -1} // fill-array
            r9.getLocationInWindow(r5)
            int[] r6 = new int[r14]
            r6 = {-1, -1} // fill-array
            r7 = r5[r1]
            int r8 = r9.getWidth()
            int r7 = r7 + r8
            r6[r1] = r7
            r7 = r5[r2]
            int r8 = r9.getHeight()
            int r7 = r7 + r8
            r6[r2] = r7
            int r7 = m5518a((android.content.Context) r10)
            int r10 = m5522b((android.content.Context) r10)
            r8 = r6[r1]
            if (r8 < 0) goto L_0x00c2
            r6 = r6[r2]
            if (r6 < 0) goto L_0x00c2
            r6 = r5[r1]
            if (r6 > r10) goto L_0x00c2
            r10 = r5[r2]
            if (r10 > r7) goto L_0x00c2
            int r10 = r3.top
            if (r10 != 0) goto L_0x0092
            r10 = r5[r2]
            int r7 = r7 / r14
            if (r10 <= r7) goto L_0x0092
            goto L_0x00c2
        L_0x0092:
            if (r4 == 0) goto L_0x0141
            int r10 = r3.height()
            int r14 = r3.width()
            int r10 = r10 * r14
            float r10 = (float) r10
            int r14 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r14 <= 0) goto L_0x0141
            if (r12 == 0) goto L_0x00b4
            float r9 = m5516a(r9, r3, r10, r1)     // Catch:{ Exception -> 0x00b3 }
            int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r12 <= 0) goto L_0x00b4
            int r12 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r12 > 0) goto L_0x00b4
            float r10 = r10 - r9
            goto L_0x00b4
        L_0x00b3:
        L_0x00b4:
            float r10 = r10 / r11
            float r10 = r10 * r13
            int r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r9 >= 0) goto L_0x00bc
            return r0
        L_0x00bc:
            int r9 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c1
            return r13
        L_0x00c1:
            return r10
        L_0x00c2:
            return r0
        L_0x00c3:
            android.view.ViewGroup$LayoutParams r11 = r9.getLayoutParams()
            int r11 = r11.height
            r3 = -2
            if (r11 != r3) goto L_0x0141
            int[] r11 = new int[r14]
            r11 = {-1, -1} // fill-array
            r9.getLocationInWindow(r11)
            int[] r3 = new int[r14]
            r3 = {-1, -1} // fill-array
            r4 = r11[r1]
            int r5 = r9.getWidth()
            int r4 = r4 + r5
            r3[r1] = r4
            r4 = r11[r2]
            int r4 = r4 + r2
            r3[r2] = r4
            android.graphics.Rect r4 = new android.graphics.Rect
            r5 = r11[r1]
            r6 = r11[r2]
            r7 = r3[r1]
            r8 = r3[r2]
            r4.<init>(r5, r6, r7, r8)
            int r5 = m5518a((android.content.Context) r10)
            int r10 = m5522b((android.content.Context) r10)
            r6 = r3[r1]
            if (r6 < 0) goto L_0x0141
            r3 = r3[r2]
            if (r3 < 0) goto L_0x0141
            r1 = r11[r1]
            if (r1 > r10) goto L_0x0141
            r10 = r11[r2]
            if (r10 > r5) goto L_0x0141
            int r10 = r4.top
            if (r10 != 0) goto L_0x0116
            r10 = r11[r2]
            int r5 = r5 / r14
            if (r10 <= r5) goto L_0x0116
            goto L_0x0141
        L_0x0116:
            int r10 = r4.height()
            int r11 = r4.width()
            int r10 = r10 * r11
            float r10 = (float) r10
            if (r12 == 0) goto L_0x0132
            float r9 = m5516a(r9, r4, r10, r2)     // Catch:{ Exception -> 0x0132 }
            int r11 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r11 <= 0) goto L_0x0132
            int r11 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r11 > 0) goto L_0x0132
            float r9 = r10 - r9
            goto L_0x0133
        L_0x0132:
            r9 = r10
        L_0x0133:
            float r9 = r9 / r10
            float r9 = r9 * r13
            int r10 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r10 >= 0) goto L_0x013b
            return r0
        L_0x013b:
            int r10 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r10 <= 0) goto L_0x0140
            return r13
        L_0x0140:
            return r9
        L_0x0141:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1410o0.m5515a(android.view.View, android.content.Context, boolean, boolean, boolean, boolean):float");
    }

    /* renamed from: b */
    private static float m5521b(View view) {
        if (view == null) {
            return 0.0f;
        }
        if (m5517a() < 11) {
            return 1.0f;
        }
        return view.getAlpha();
    }

    /* renamed from: c */
    private static boolean m5523c(View view) {
        if (view == null) {
            return false;
        }
        if (view.getBackground() == null || (m5517a() > 18 && view.getBackground().getAlpha() == 0)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private static int m5522b(Context context) {
        int i;
        int i2;
        int i3;
        int i4 = context != null ? context.getResources().getConfiguration().orientation : -1;
        if (i4 == 2 && (i3 = f4458b) > 0) {
            return i3;
        }
        if (i4 == 1 && (i2 = f4460d) > 0) {
            return i2;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
            if (m5517a() >= 13) {
                i = C1412b.m5525a(windowManager);
            } else {
                i = windowManager.getDefaultDisplay().getWidth();
            }
            if (i4 == 2) {
                f4458b = i;
            } else if (i4 == 1) {
                f4460d = i;
            }
            return i;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        return r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float m5516a(android.view.View r11, android.graphics.Rect r12, float r13, boolean r14) {
        /*
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.util.LinkedList r3 = new java.util.LinkedList
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r2.add(r12)
            android.view.ViewParent r5 = r11.getParent()
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            android.view.View r6 = r11.getRootView()
            android.content.Context r11 = r11.getContext()     // Catch:{ Exception -> 0x0034 }
            android.app.Activity r11 = (android.app.Activity) r11     // Catch:{ Exception -> 0x0034 }
            r7 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r11 = r11.findViewById(r7)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0035
        L_0x0034:
            r11 = 0
        L_0x0035:
            r7 = 0
            if (r5 == 0) goto L_0x006f
            android.view.ViewParent r8 = r5.getParent()
            if (r8 == r6) goto L_0x006f
            int r8 = r5.getVisibility()
            if (r8 != 0) goto L_0x006e
            float r8 = m5521b((android.view.View) r5)
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x004d
            goto L_0x006e
        L_0x004d:
            if (r11 == 0) goto L_0x0064
            if (r14 == 0) goto L_0x0064
            if (r5 == r11) goto L_0x0064
            android.view.ViewGroup$LayoutParams r7 = r5.getLayoutParams()
            int r7 = r7.height
            if (r7 == 0) goto L_0x0063
            android.view.ViewGroup$LayoutParams r7 = r5.getLayoutParams()
            int r7 = r7.width
            if (r7 != 0) goto L_0x0064
        L_0x0063:
            return r13
        L_0x0064:
            r0.addFirst(r5)
            android.view.ViewParent r5 = r5.getParent()
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            goto L_0x0035
        L_0x006e:
            return r13
        L_0x006f:
            if (r5 != 0) goto L_0x0072
            return r13
        L_0x0072:
            java.util.Iterator r11 = r0.iterator()
        L_0x0076:
            boolean r0 = r11.hasNext()
            r5 = 0
            r6 = 1
            if (r0 == 0) goto L_0x00d6
            java.lang.Object r0 = r11.next()
            android.view.View r0 = (android.view.View) r0
            android.view.ViewParent r8 = r0.getParent()
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            if (r8 != 0) goto L_0x008d
            return r13
        L_0x008d:
            java.lang.Class r9 = r8.getClass()
            java.lang.String r9 = r9.getSimpleName()
            java.lang.String r10 = "viewpager"
            boolean r9 = r10.equalsIgnoreCase(r9)
            if (r9 == 0) goto L_0x009e
            goto L_0x0076
        L_0x009e:
            int r0 = r8.indexOfChild(r0)
            int r9 = r8.getChildCount()
            int r9 = r9 - r6
            if (r0 >= r9) goto L_0x0076
        L_0x00a9:
            int r0 = r0 + r6
            int r9 = r8.getChildCount()
            if (r0 >= r9) goto L_0x0076
            android.view.View r9 = r8.getChildAt(r0)
            boolean r10 = m5523c(r9)
            if (r10 != 0) goto L_0x00cc
            int r10 = r9.getVisibility()
            if (r10 != 0) goto L_0x00a9
            float r10 = m5521b((android.view.View) r9)
            int r10 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r10 == 0) goto L_0x00a9
            r3.addFirst(r9)
            goto L_0x00a9
        L_0x00cc:
            java.util.ArrayList r9 = m5520a((android.view.View) r9)
            if (r9 == 0) goto L_0x00a9
            r3.addAll(r5, r9)
            goto L_0x00a9
        L_0x00d6:
            java.util.Iterator r11 = r3.iterator()
            r0 = 0
        L_0x00db:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x0131
            java.lang.Object r3 = r11.next()
            android.view.View r3 = (android.view.View) r3
            int r8 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r8 < 0) goto L_0x00ec
            goto L_0x0131
        L_0x00ec:
            if (r3 == 0) goto L_0x0104
            java.lang.Object r8 = r3.getTag()     // Catch:{ Exception -> 0x0103 }
            if (r8 == 0) goto L_0x0104
            java.lang.Object r8 = r3.getTag()     // Catch:{ Exception -> 0x0103 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0103 }
            java.lang.String r9 = "BTN_CLOSE"
            boolean r8 = r8.contains(r9)     // Catch:{ Exception -> 0x0103 }
            if (r8 == 0) goto L_0x0104
            goto L_0x00db
        L_0x0103:
        L_0x0104:
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            boolean r3 = r3.getGlobalVisibleRect(r8)
            if (r3 != 0) goto L_0x0110
            goto L_0x00db
        L_0x0110:
            if (r14 == 0) goto L_0x0117
            int r3 = r8.top
            int r3 = r3 + r6
            r8.top = r3
        L_0x0117:
            boolean r3 = r8.intersect(r12)
            if (r3 == 0) goto L_0x00db
            r1.add(r8)
            int r0 = r8.width()
            int r3 = r8.height()
            int r0 = r0 * r3
            float r0 = (float) r0
            int r3 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r3 < 0) goto L_0x00db
            r11 = 1
            goto L_0x0132
        L_0x0131:
            r11 = 0
        L_0x0132:
            if (r11 == 0) goto L_0x0135
            return r13
        L_0x0135:
            boolean r11 = r1.isEmpty()
            if (r11 != 0) goto L_0x01b9
            int r11 = r1.size()
            if (r11 != r6) goto L_0x0142
            return r0
        L_0x0142:
            java.util.Iterator r11 = r1.iterator()
        L_0x0146:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0190
            java.lang.Object r12 = r11.next()
            android.graphics.Rect r12 = (android.graphics.Rect) r12
            r4.clear()
            r4.addAll(r2)
            r14 = 0
        L_0x0159:
            int r1 = r4.size()
            if (r14 >= r1) goto L_0x0146
            java.lang.Object r1 = r4.get(r14)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            boolean r3 = r12.intersect(r1)
            if (r3 == 0) goto L_0x018d
            java.lang.Object r3 = r4.get(r14)
            r2.remove(r3)
            r3 = 1
        L_0x0173:
            r8 = 9
            if (r3 >= r8) goto L_0x018d
            android.graphics.Rect r8 = m5519a(r1, r12, r3)
            int r9 = r8.height()
            if (r9 <= 0) goto L_0x018a
            int r9 = r8.width()
            if (r9 <= 0) goto L_0x018a
            r2.add(r8)
        L_0x018a:
            int r3 = r3 + 1
            goto L_0x0173
        L_0x018d:
            int r14 = r14 + 1
            goto L_0x0159
        L_0x0190:
            boolean r11 = r2.isEmpty()
            if (r11 != 0) goto L_0x01b9
            java.util.Iterator r11 = r2.iterator()
        L_0x019a:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x01b3
            java.lang.Object r12 = r11.next()
            android.graphics.Rect r12 = (android.graphics.Rect) r12
            int r14 = r12.width()
            int r12 = r12.height()
            int r14 = r14 * r12
            float r12 = (float) r14
            float r7 = r7 + r12
            goto L_0x019a
        L_0x01b3:
            int r11 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r11 >= 0) goto L_0x01b9
            float r13 = r13 - r7
            return r13
        L_0x01b9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C1410o0.m5516a(android.view.View, android.graphics.Rect, float, boolean):float");
    }

    /* renamed from: a */
    private static Rect m5519a(Rect rect, Rect rect2, int i) {
        Rect rect3 = new Rect();
        switch (i) {
            case 1:
                rect3.set(rect.left, rect.top, rect2.left, rect2.top);
                break;
            case 2:
                rect3.set(rect2.left, rect.top, rect2.right, rect2.top);
                break;
            case 3:
                rect3.set(rect2.right, rect.top, rect.right, rect2.top);
                break;
            case 4:
                rect3.set(rect2.right, rect2.top, rect.right, rect2.bottom);
                break;
            case 5:
                rect3.set(rect2.right, rect2.bottom, rect.right, rect.bottom);
                break;
            case 6:
                rect3.set(rect2.left, rect2.bottom, rect2.right, rect.bottom);
                break;
            case 7:
                rect3.set(rect.left, rect2.bottom, rect2.left, rect.bottom);
                break;
            case 8:
                rect3.set(rect.left, rect2.top, rect2.left, rect2.bottom);
                break;
        }
        return rect3;
    }

    /* renamed from: a */
    private static ArrayList<View> m5520a(View view) {
        if ((view instanceof ViewGroup) && view.getVisibility() == 0 && m5521b(view) != 0.0f) {
            LinkedList linkedList = new LinkedList();
            ArrayList<View> arrayList = new ArrayList<>();
            linkedList.add((ViewGroup) view);
            ListIterator listIterator = linkedList.listIterator();
            while (listIterator.hasNext()) {
                ViewGroup viewGroup = (ViewGroup) listIterator.next();
                listIterator.remove();
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0 && m5521b(childAt) != 0.0f) {
                        if (childAt instanceof ViewGroup) {
                            if (m5523c(childAt)) {
                                listIterator.add((ViewGroup) childAt);
                                listIterator.previous();
                            } else {
                                arrayList.add(childAt);
                            }
                        } else if (!m5523c(childAt)) {
                            arrayList.add(childAt);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static int m5518a(Context context) {
        int i;
        int i2;
        int i3;
        int i4 = context != null ? context.getResources().getConfiguration().orientation : -1;
        if (i4 == 2 && (i3 = f4457a) > 0) {
            return i3;
        }
        if (i4 == 1 && (i2 = f4459c) > 0) {
            return i2;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
            if (m5517a() >= 13) {
                i = C1411a.m5524a(windowManager);
            } else {
                i = windowManager.getDefaultDisplay().getHeight();
            }
            if (i4 == 2) {
                f4457a = i;
            } else if (i4 == 1) {
                f4459c = i;
            }
            return i;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private static int m5517a() {
        return Build.VERSION.SDK_INT;
    }
}
