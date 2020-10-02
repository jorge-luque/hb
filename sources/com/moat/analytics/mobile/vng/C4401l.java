package com.moat.analytics.mobile.vng;

import android.app.Application;
import android.media.AudioManager;

/* renamed from: com.moat.analytics.mobile.vng.l */
public class C4401l {

    /* renamed from: a */
    private static final Long f11814a = 200L;

    /* renamed from: b */
    private static final C4401l f11815b = new C4401l();

    /* renamed from: c */
    private AudioManager f11816c;

    /* renamed from: d */
    private double f11817d = 0.0d;

    /* renamed from: e */
    private Long f11818e;

    private C4401l() {
        m14744c();
    }

    /* renamed from: a */
    public static C4401l m14743a() {
        return f11815b;
    }

    /* renamed from: c */
    private void m14744c() {
        Application a = C4371a.m14615a();
        if (a != null) {
            this.f11816c = (AudioManager) a.getSystemService("audio");
        }
    }

    /* renamed from: d */
    private AudioManager m14745d() {
        if (this.f11816c == null) {
            m14744c();
        }
        return this.f11816c;
    }

    /* renamed from: e */
    private void m14746e() {
        try {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (this.f11818e == null || valueOf.longValue() - this.f11818e.longValue() > f11814a.longValue()) {
                this.f11818e = valueOf;
                AudioManager d = m14745d();
                if (d != null) {
                    double streamVolume = (double) d.getStreamVolume(3);
                    double streamMaxVolume = (double) d.getStreamMaxVolume(3);
                    Double.isNaN(streamVolume);
                    Double.isNaN(streamMaxVolume);
                    this.f11817d = streamVolume / streamMaxVolume;
                }
            }
        } catch (Exception e) {
            C4403n.m14758a(e);
            this.f11817d = 0.0d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public double mo29329b() {
        try {
            m14746e();
            return this.f11817d;
        } catch (Exception e) {
            C4403n.m14758a(e);
            return 0.0d;
        }
    }
}
