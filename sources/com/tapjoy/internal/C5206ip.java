package com.tapjoy.internal;

import android.content.Context;
import android.view.ViewGroup;

/* renamed from: com.tapjoy.internal.ip */
public final class C5206ip extends C4886ai {

    /* renamed from: a */
    private final C3159hu f14297a;

    /* renamed from: b */
    private final C5207iq f14298b;

    /* renamed from: c */
    private C4874aa f14299c = null;

    public C5206ip(Context context, C3159hu huVar, C5207iq iqVar) {
        super(context);
        this.f14297a = huVar;
        this.f14298b = iqVar;
        addView(iqVar, new ViewGroup.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.C4874aa.m16656a(r0)
            com.tapjoy.internal.hu r1 = r6.f14297a
            boolean r1 = r1.mo18612a()
            r2 = 1
            r3 = 3
            r4 = 0
            if (r1 == 0) goto L_0x005b
            com.tapjoy.internal.hu r1 = r6.f14297a
            boolean r1 = r1.mo18613b()
            if (r1 == 0) goto L_0x0041
            boolean r1 = r0.mo30901a()
            if (r1 == 0) goto L_0x0024
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.C4874aa.PORTRAIT
            goto L_0x003d
        L_0x0024:
            boolean r0 = r0.mo30902b()
            if (r0 != 0) goto L_0x003b
            android.content.Context r0 = r6.getContext()
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.C4874aa.m16657b(r0)
            boolean r0 = r0.mo30901a()
            if (r0 == 0) goto L_0x003b
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.C4874aa.PORTRAIT
            goto L_0x003d
        L_0x003b:
            com.tapjoy.internal.aa r0 = com.tapjoy.internal.C4874aa.LANDSCAPE
        L_0x003d:
            r6.setRotationCount(r4)
            goto L_0x0075
        L_0x0041:
            com.tapjoy.internal.aa r1 = com.tapjoy.internal.C4874aa.PORTRAIT
            boolean r5 = r0.mo30902b()
            if (r5 == 0) goto L_0x0057
            int r0 = r0.mo30903c()
            if (r0 != r3) goto L_0x0053
            r6.setRotationCount(r2)
            goto L_0x0074
        L_0x0053:
            r6.setRotationCount(r3)
            goto L_0x0074
        L_0x0057:
            r6.setRotationCount(r4)
            goto L_0x0074
        L_0x005b:
            com.tapjoy.internal.aa r1 = com.tapjoy.internal.C4874aa.LANDSCAPE
            boolean r5 = r0.mo30901a()
            if (r5 == 0) goto L_0x0071
            int r0 = r0.mo30903c()
            if (r0 != r3) goto L_0x006d
            r6.setRotationCount(r2)
            goto L_0x0074
        L_0x006d:
            r6.setRotationCount(r2)
            goto L_0x0074
        L_0x0071:
            r6.setRotationCount(r4)
        L_0x0074:
            r0 = r1
        L_0x0075:
            com.tapjoy.internal.aa r1 = r6.f14299c
            if (r1 == r0) goto L_0x0084
            r6.f14299c = r0
            com.tapjoy.internal.iq r1 = r6.f14298b
            boolean r0 = r0.mo30902b()
            r1.setLandscape(r0)
        L_0x0084:
            super.onMeasure(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.C5206ip.onMeasure(int, int):void");
    }
}
