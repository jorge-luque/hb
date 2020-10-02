package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

/* renamed from: com.tapjoy.internal.dc */
public final class C4958dc {

    /* renamed from: a */
    private final C4955cz f13482a;

    private C4958dc(C4955cz czVar) {
        this.f13482a = czVar;
    }

    /* renamed from: a */
    public static C4958dc m16803a(C4948cs csVar) {
        C4955cz czVar = (C4955cz) csVar;
        C4975do.m16853a((Object) csVar, "AdSession is null");
        if (!(C4952cw.NATIVE == czVar.f13463a.f13441b)) {
            throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
        } else if (!czVar.f13466d) {
            C4975do.m16852a(czVar);
            if (czVar.f13465c.f13516c == null) {
                C4958dc dcVar = new C4958dc(czVar);
                czVar.f13465c.f13516c = dcVar;
                return dcVar;
            }
            throw new IllegalStateException("VideoEvents already exists for AdSession");
        } else {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: b */
    private static void m16804b(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Video volume");
        }
    }

    /* renamed from: b */
    public final void mo31048b() {
        C4975do.m16855b(this.f13482a);
        this.f13482a.f13465c.mo31072a(TJAdUnitConstants.String.VIDEO_MIDPOINT);
    }

    /* renamed from: c */
    public final void mo31049c() {
        C4975do.m16855b(this.f13482a);
        this.f13482a.f13465c.mo31072a(TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE);
    }

    /* renamed from: d */
    public final void mo31050d() {
        C4975do.m16855b(this.f13482a);
        this.f13482a.f13465c.mo31072a(TJAdUnitConstants.String.VIDEO_COMPLETE);
    }

    /* renamed from: e */
    public final void mo31051e() {
        C4975do.m16855b(this.f13482a);
        this.f13482a.f13465c.mo31072a("pause");
    }

    /* renamed from: f */
    public final void mo31052f() {
        C4975do.m16855b(this.f13482a);
        this.f13482a.f13465c.mo31072a("resume");
    }

    /* renamed from: g */
    public final void mo31053g() {
        C4975do.m16855b(this.f13482a);
        this.f13482a.f13465c.mo31072a(TJAdUnitConstants.String.VIDEO_BUFFER_START);
    }

    /* renamed from: h */
    public final void mo31054h() {
        C4975do.m16855b(this.f13482a);
        this.f13482a.f13465c.mo31072a("bufferFinish");
    }

    /* renamed from: i */
    public final void mo31055i() {
        C4975do.m16855b(this.f13482a);
        this.f13482a.f13465c.mo31072a(TJAdUnitConstants.String.VIDEO_SKIPPED);
    }

    /* renamed from: a */
    public final void mo31047a(C4957db dbVar) {
        C4975do.m16853a((Object) dbVar, "VastProperties is null");
        C4975do.m16852a(this.f13482a);
        this.f13482a.f13465c.mo31073a("loaded", dbVar.mo31043a());
    }

    /* renamed from: a */
    public final void mo31046a(float f, float f2) {
        if (f > 0.0f) {
            m16804b(f2);
            C4975do.m16855b(this.f13482a);
            JSONObject jSONObject = new JSONObject();
            C4972dm.m16845a(jSONObject, "duration", Float.valueOf(f));
            C4972dm.m16845a(jSONObject, "videoPlayerVolume", Float.valueOf(f2));
            C4972dm.m16845a(jSONObject, "deviceVolume", Float.valueOf(C4966dh.m16831a().f13500a));
            this.f13482a.f13465c.mo31073a(TJAdUnitConstants.String.VIDEO_START, jSONObject);
            return;
        }
        throw new IllegalArgumentException("Invalid Video duration");
    }

    /* renamed from: a */
    public final void mo31044a() {
        C4975do.m16855b(this.f13482a);
        this.f13482a.f13465c.mo31072a(TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE);
    }

    /* renamed from: a */
    public final void mo31045a(float f) {
        m16804b(f);
        C4975do.m16855b(this.f13482a);
        JSONObject jSONObject = new JSONObject();
        C4972dm.m16845a(jSONObject, "videoPlayerVolume", Float.valueOf(f));
        C4972dm.m16845a(jSONObject, "deviceVolume", Float.valueOf(C4966dh.m16831a().f13500a));
        this.f13482a.f13465c.mo31073a("volumeChange", jSONObject);
    }
}
