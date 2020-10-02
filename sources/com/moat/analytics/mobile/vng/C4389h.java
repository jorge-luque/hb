package com.moat.analytics.mobile.vng;

import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.h */
abstract class C4389h extends C4378c {

    /* renamed from: l */
    int f11759l = Integer.MIN_VALUE;

    /* renamed from: m */
    private C4391a f11760m = C4391a.UNINITIALIZED;

    /* renamed from: n */
    private int f11761n = Integer.MIN_VALUE;

    /* renamed from: o */
    private double f11762o = Double.NaN;

    /* renamed from: p */
    private int f11763p = Integer.MIN_VALUE;

    /* renamed from: q */
    private int f11764q = 0;

    /* renamed from: com.moat.analytics.mobile.vng.h$a */
    enum C4391a {
        UNINITIALIZED,
        PAUSED,
        PLAYING,
        STOPPED,
        COMPLETED
    }

    C4389h(String str) {
        super(str);
    }

    /* renamed from: t */
    private void m14677t() {
        this.f11733i.postDelayed(new Runnable() {
            public void run() {
                C4389h hVar;
                try {
                    if (!C4389h.this.mo29296n() || C4389h.this.mo29283m()) {
                        hVar = C4389h.this;
                    } else if (Boolean.valueOf(C4389h.this.mo29301s()).booleanValue()) {
                        C4389h.this.f11733i.postDelayed(this, 200);
                        return;
                    } else {
                        hVar = C4389h.this;
                    }
                    hVar.mo29282l();
                } catch (Exception e) {
                    C4389h.this.mo29282l();
                    C4403n.m14758a(e);
                }
            }
        }, 200);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo29275a(MoatAdEvent moatAdEvent) {
        Integer num;
        int i;
        if (!moatAdEvent.f11702b.equals(MoatAdEvent.f11700a)) {
            num = moatAdEvent.f11702b;
        } else {
            try {
                num = mo29297o();
            } catch (Exception unused) {
                num = Integer.valueOf(this.f11761n);
            }
            moatAdEvent.f11702b = num;
        }
        if (moatAdEvent.f11702b.intValue() < 0 || (moatAdEvent.f11702b.intValue() == 0 && moatAdEvent.f11704d == MoatAdEventType.AD_EVT_COMPLETE && this.f11761n > 0)) {
            num = Integer.valueOf(this.f11761n);
            moatAdEvent.f11702b = num;
        }
        if (moatAdEvent.f11704d == MoatAdEventType.AD_EVT_COMPLETE) {
            if (num.intValue() == Integer.MIN_VALUE || (i = this.f11759l) == Integer.MIN_VALUE || !mo29276a(num, Integer.valueOf(i))) {
                this.f11760m = C4391a.STOPPED;
                moatAdEvent.f11704d = MoatAdEventType.AD_EVT_STOPPED;
            } else {
                this.f11760m = C4391a.COMPLETED;
            }
        }
        return super.mo29275a(moatAdEvent);
    }

    /* renamed from: a */
    public boolean mo29277a(Map<String, String> map, View view) {
        try {
            boolean a = super.mo29277a(map, view);
            if (!a || !mo29298p()) {
                return a;
            }
            m14677t();
            return a;
        } catch (Exception e) {
            C4409p.m14772a(3, "IntervalVideoTracker", (Object) this, "Problem with video loop");
            mo29260a("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public abstract boolean mo29296n();

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public abstract Integer mo29297o();

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo29298p() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public abstract boolean mo29299q();

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public abstract Integer mo29300r();

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009d A[Catch:{ Exception -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f A[Catch:{ Exception -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00bf A[Catch:{ Exception -> 0x00d4 }] */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo29301s() {
        /*
            r12 = this;
            boolean r0 = r12.mo29296n()
            r1 = 0
            if (r0 == 0) goto L_0x00df
            boolean r0 = r12.mo29283m()
            if (r0 == 0) goto L_0x000f
            goto L_0x00df
        L_0x000f:
            r0 = 1
            java.lang.Integer r2 = r12.mo29297o()     // Catch:{ Exception -> 0x00d4 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x00d4 }
            int r3 = r12.f11761n     // Catch:{ Exception -> 0x00d4 }
            if (r3 < 0) goto L_0x001f
            if (r2 >= 0) goto L_0x001f
            return r1
        L_0x001f:
            r12.f11761n = r2     // Catch:{ Exception -> 0x00d4 }
            if (r2 != 0) goto L_0x0024
            return r0
        L_0x0024:
            java.lang.Integer r3 = r12.mo29300r()     // Catch:{ Exception -> 0x00d4 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x00d4 }
            boolean r4 = r12.mo29299q()     // Catch:{ Exception -> 0x00d4 }
            double r5 = (double) r3
            r7 = 4616189618054758400(0x4010000000000000, double:4.0)
            java.lang.Double.isNaN(r5)
            double r5 = r5 / r7
            java.lang.Double r7 = r12.mo29280j()     // Catch:{ Exception -> 0x00d4 }
            double r7 = r7.doubleValue()     // Catch:{ Exception -> 0x00d4 }
            r9 = 0
            int r10 = r12.f11763p     // Catch:{ Exception -> 0x00d4 }
            if (r2 <= r10) goto L_0x0046
            r12.f11763p = r2     // Catch:{ Exception -> 0x00d4 }
        L_0x0046:
            int r10 = r12.f11759l     // Catch:{ Exception -> 0x00d4 }
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 != r11) goto L_0x004e
            r12.f11759l = r3     // Catch:{ Exception -> 0x00d4 }
        L_0x004e:
            if (r4 == 0) goto L_0x0090
            com.moat.analytics.mobile.vng.h$a r3 = r12.f11760m     // Catch:{ Exception -> 0x00d4 }
            com.moat.analytics.mobile.vng.h$a r4 = com.moat.analytics.mobile.vng.C4389h.C4391a.UNINITIALIZED     // Catch:{ Exception -> 0x00d4 }
            if (r3 != r4) goto L_0x005d
            com.moat.analytics.mobile.vng.MoatAdEventType r9 = com.moat.analytics.mobile.vng.MoatAdEventType.AD_EVT_START     // Catch:{ Exception -> 0x00d4 }
            com.moat.analytics.mobile.vng.h$a r3 = com.moat.analytics.mobile.vng.C4389h.C4391a.PLAYING     // Catch:{ Exception -> 0x00d4 }
        L_0x005a:
            r12.f11760m = r3     // Catch:{ Exception -> 0x00d4 }
            goto L_0x009b
        L_0x005d:
            com.moat.analytics.mobile.vng.h$a r3 = r12.f11760m     // Catch:{ Exception -> 0x00d4 }
            com.moat.analytics.mobile.vng.h$a r4 = com.moat.analytics.mobile.vng.C4389h.C4391a.PAUSED     // Catch:{ Exception -> 0x00d4 }
            if (r3 != r4) goto L_0x0068
            com.moat.analytics.mobile.vng.MoatAdEventType r9 = com.moat.analytics.mobile.vng.MoatAdEventType.AD_EVT_PLAYING     // Catch:{ Exception -> 0x00d4 }
            com.moat.analytics.mobile.vng.h$a r3 = com.moat.analytics.mobile.vng.C4389h.C4391a.PLAYING     // Catch:{ Exception -> 0x00d4 }
            goto L_0x005a
        L_0x0068:
            double r3 = (double) r2
            java.lang.Double.isNaN(r3)
            double r3 = r3 / r5
            double r3 = java.lang.Math.floor(r3)     // Catch:{ Exception -> 0x00d4 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x00d4 }
            int r3 = r3 - r0
            r4 = -1
            if (r3 <= r4) goto L_0x009b
            r4 = 3
            if (r3 >= r4) goto L_0x009b
            com.moat.analytics.mobile.vng.MoatAdEventType[] r4 = com.moat.analytics.mobile.vng.C4378c.f11731g     // Catch:{ Exception -> 0x00d4 }
            r3 = r4[r3]     // Catch:{ Exception -> 0x00d4 }
            java.util.Map<com.moat.analytics.mobile.vng.MoatAdEventType, java.lang.Integer> r4 = r12.f11732h     // Catch:{ Exception -> 0x00d4 }
            boolean r4 = r4.containsKey(r3)     // Catch:{ Exception -> 0x00d4 }
            if (r4 != 0) goto L_0x009b
            java.util.Map<com.moat.analytics.mobile.vng.MoatAdEventType, java.lang.Integer> r4 = r12.f11732h     // Catch:{ Exception -> 0x00d4 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00d4 }
            r4.put(r3, r5)     // Catch:{ Exception -> 0x00d4 }
            r9 = r3
            goto L_0x009b
        L_0x0090:
            com.moat.analytics.mobile.vng.h$a r3 = r12.f11760m     // Catch:{ Exception -> 0x00d4 }
            com.moat.analytics.mobile.vng.h$a r4 = com.moat.analytics.mobile.vng.C4389h.C4391a.PAUSED     // Catch:{ Exception -> 0x00d4 }
            if (r3 == r4) goto L_0x009b
            com.moat.analytics.mobile.vng.MoatAdEventType r9 = com.moat.analytics.mobile.vng.MoatAdEventType.AD_EVT_PAUSED     // Catch:{ Exception -> 0x00d4 }
            com.moat.analytics.mobile.vng.h$a r3 = com.moat.analytics.mobile.vng.C4389h.C4391a.PAUSED     // Catch:{ Exception -> 0x00d4 }
            goto L_0x005a
        L_0x009b:
            if (r9 == 0) goto L_0x009f
            r3 = 1
            goto L_0x00a0
        L_0x009f:
            r3 = 0
        L_0x00a0:
            if (r3 != 0) goto L_0x00bd
            double r4 = r12.f11762o     // Catch:{ Exception -> 0x00d4 }
            boolean r4 = java.lang.Double.isNaN(r4)     // Catch:{ Exception -> 0x00d4 }
            if (r4 != 0) goto L_0x00bd
            double r4 = r12.f11762o     // Catch:{ Exception -> 0x00d4 }
            double r4 = r4 - r7
            double r4 = java.lang.Math.abs(r4)     // Catch:{ Exception -> 0x00d4 }
            r10 = 4587366580439587226(0x3fa999999999999a, double:0.05)
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x00bd
            com.moat.analytics.mobile.vng.MoatAdEventType r9 = com.moat.analytics.mobile.vng.MoatAdEventType.AD_EVT_VOLUME_CHANGE     // Catch:{ Exception -> 0x00d4 }
            r3 = 1
        L_0x00bd:
            if (r3 == 0) goto L_0x00cf
            com.moat.analytics.mobile.vng.MoatAdEvent r3 = new com.moat.analytics.mobile.vng.MoatAdEvent     // Catch:{ Exception -> 0x00d4 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00d4 }
            java.lang.Double r4 = r12.mo29281k()     // Catch:{ Exception -> 0x00d4 }
            r3.<init>(r9, r2, r4)     // Catch:{ Exception -> 0x00d4 }
            r12.dispatchEvent(r3)     // Catch:{ Exception -> 0x00d4 }
        L_0x00cf:
            r12.f11762o = r7     // Catch:{ Exception -> 0x00d4 }
            r12.f11764q = r1     // Catch:{ Exception -> 0x00d4 }
            return r0
        L_0x00d4:
            int r2 = r12.f11764q
            int r3 = r2 + 1
            r12.f11764q = r3
            r3 = 5
            if (r2 >= r3) goto L_0x00df
            r1 = 1
        L_0x00df:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moat.analytics.mobile.vng.C4389h.mo29301s():boolean");
    }

    public void setPlayerVolume(Double d) {
        super.setPlayerVolume(d);
        this.f11762o = mo29280j().doubleValue();
    }

    public void stopTracking() {
        try {
            dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            super.stopTracking();
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
    }
}
