package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.impl.sdk.C1941j;
import com.applovin.impl.sdk.p050b.C1841c;

public class AppLovinTouchToClickListener implements View.OnTouchListener {

    /* renamed from: a */
    private final long f4722a;

    /* renamed from: b */
    private final int f4723b;

    /* renamed from: c */
    private final ClickRecognitionState f4724c;

    /* renamed from: d */
    private long f4725d;

    /* renamed from: e */
    private PointF f4726e;

    /* renamed from: f */
    private boolean f4727f;

    /* renamed from: g */
    private final Context f4728g;

    /* renamed from: h */
    private final OnClickListener f4729h;

    public enum ClickRecognitionState {
        DISABLED,
        ACTION_DOWN,
        ACTION_POINTER_UP,
        ACTION_UP
    }

    public interface OnClickListener {
        void onClick(View view, PointF pointF);
    }

    public AppLovinTouchToClickListener(C1941j jVar, Context context, OnClickListener onClickListener) {
        this(jVar, C1841c.f5804aD, context, onClickListener);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.applovin.impl.sdk.b.c, com.applovin.impl.sdk.b.c<java.lang.Integer>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppLovinTouchToClickListener(com.applovin.impl.sdk.C1941j r3, com.applovin.impl.sdk.p050b.C1841c<java.lang.Integer> r4, android.content.Context r5, com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener r6) {
        /*
            r2 = this;
            r2.<init>()
            com.applovin.impl.sdk.b.c<java.lang.Long> r0 = com.applovin.impl.sdk.p050b.C1841c.f5802aB
            java.lang.Object r0 = r3.mo8549a(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2.f4722a = r0
            com.applovin.impl.sdk.b.c<java.lang.Integer> r0 = com.applovin.impl.sdk.p050b.C1841c.f5803aC
            java.lang.Object r0 = r3.mo8549a(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r2.f4723b = r0
            java.lang.Object r3 = r3.mo8549a(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState[] r4 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.values()
            r3 = r4[r3]
            r2.f4724c = r3
            r2.f4728g = r5
            r2.f4729h = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AppLovinTouchToClickListener.<init>(com.applovin.impl.sdk.j, com.applovin.impl.sdk.b.c, android.content.Context, com.applovin.impl.adview.AppLovinTouchToClickListener$OnClickListener):void");
    }

    /* renamed from: a */
    private float m5845a(float f) {
        return f / this.f4728g.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    private float m5846a(PointF pointF, PointF pointF2) {
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return m5845a((float) Math.sqrt((double) ((f * f) + (f2 * f2))));
    }

    /* renamed from: a */
    private void m5847a(View view, MotionEvent motionEvent) {
        this.f4729h.onClick(view, new PointF(motionEvent.getRawX(), motionEvent.getRawY()));
        this.f4727f = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r2 >= r4) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        if (r0 >= ((float) r2)) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r9.f4724c != com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_POINTER_UP) goto L_0x0080;
     */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            r9 = this;
            int r0 = r11.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x005e
            if (r0 == r1) goto L_0x0019
            r2 = 6
            if (r0 == r2) goto L_0x000e
            goto L_0x0080
        L_0x000e:
            boolean r0 = r9.f4727f
            if (r0 != 0) goto L_0x0080
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f4724c
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_POINTER_UP
            if (r0 != r2) goto L_0x0080
            goto L_0x0064
        L_0x0019:
            boolean r0 = r9.f4727f
            if (r0 != 0) goto L_0x0024
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f4724c
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_UP
            if (r0 != r2) goto L_0x0024
            goto L_0x0064
        L_0x0024:
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f4724c
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.DISABLED
            if (r0 != r2) goto L_0x0080
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r9.f4725d
            long r2 = r2 - r4
            android.graphics.PointF r0 = r9.f4726e
            android.graphics.PointF r4 = new android.graphics.PointF
            float r5 = r11.getX()
            float r6 = r11.getY()
            r4.<init>(r5, r6)
            float r0 = r9.m5846a((android.graphics.PointF) r0, (android.graphics.PointF) r4)
            boolean r4 = r9.f4727f
            if (r4 != 0) goto L_0x0080
            long r4 = r9.f4722a
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0054
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0080
        L_0x0054:
            int r2 = r9.f4723b
            if (r2 < 0) goto L_0x0064
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0080
            goto L_0x0064
        L_0x005e:
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f4724c
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN
            if (r0 != r2) goto L_0x0068
        L_0x0064:
            r9.m5847a((android.view.View) r10, (android.view.MotionEvent) r11)
            goto L_0x0080
        L_0x0068:
            long r2 = android.os.SystemClock.elapsedRealtime()
            r9.f4725d = r2
            android.graphics.PointF r10 = new android.graphics.PointF
            float r0 = r11.getX()
            float r11 = r11.getY()
            r10.<init>(r0, r11)
            r9.f4726e = r10
            r10 = 0
            r9.f4727f = r10
        L_0x0080:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AppLovinTouchToClickListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
