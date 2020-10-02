package com.moat.analytics.mobile.vng;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.moat.analytics.mobile.vng.C4383g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.c */
abstract class C4378c extends C4377b {

    /* renamed from: g */
    static final MoatAdEventType[] f11731g = {MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};

    /* renamed from: h */
    final Map<MoatAdEventType, Integer> f11732h;

    /* renamed from: i */
    final Handler f11733i;

    /* renamed from: j */
    Map<String, String> f11734j;

    /* renamed from: k */
    WeakReference<View> f11735k;

    /* renamed from: l */
    private final Set<MoatAdEventType> f11736l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public VideoTrackerListener f11737m;

    /* renamed from: n */
    private boolean f11738n;

    /* renamed from: o */
    private Double f11739o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final C4383g f11740p;

    /* renamed from: q */
    private final String f11741q;

    C4378c(String str) {
        super((View) null, false, true);
        C4409p.m14772a(3, "BaseVideoTracker", (Object) this, "Initializing.");
        this.f11741q = str;
        C4383g gVar = new C4383g(C4371a.m14615a(), C4383g.C4388a.f11757b);
        this.f11740p = gVar;
        super.mo29259a(gVar.f11746b);
        try {
            super.mo29258a(this.f11740p.f11745a);
        } catch (C4403n e) {
            this.f11720a = e;
        }
        this.f11732h = new HashMap();
        this.f11736l = new HashSet();
        this.f11733i = new Handler();
        this.f11738n = false;
        this.f11739o = Double.valueOf(1.0d);
    }

    /* renamed from: a */
    private static boolean m14651a(MoatAdEventType moatAdEventType) {
        return moatAdEventType == MoatAdEventType.AD_EVT_COMPLETE || moatAdEventType == MoatAdEventType.AD_EVT_STOPPED || moatAdEventType == MoatAdEventType.AD_EVT_SKIPPED;
    }

    /* renamed from: b */
    private void m14652b(MoatAdEvent moatAdEvent) {
        C4395j jVar;
        JSONObject a = mo29275a(moatAdEvent);
        C4409p.m14772a(3, "BaseVideoTracker", (Object) this, String.format("Received event: %s", new Object[]{a.toString()}));
        C4409p.m14775a("[SUCCESS] ", mo29257a() + String.format(" Received event: %s", new Object[]{a.toString()}));
        if (mo29266e() && (jVar = this.f11722c) != null) {
            jVar.mo29315a(this.f11740p.f11747c, a);
            if (!this.f11736l.contains(moatAdEvent.f11704d)) {
                this.f11736l.add(moatAdEvent.f11704d);
                VideoTrackerListener videoTrackerListener = this.f11737m;
                if (videoTrackerListener != null) {
                    videoTrackerListener.onVideoEventReported(moatAdEvent.f11704d);
                }
            }
        }
        MoatAdEventType moatAdEventType = moatAdEvent.f11704d;
        if (m14651a(moatAdEventType)) {
            this.f11732h.put(moatAdEventType, 1);
            C4395j jVar2 = this.f11722c;
            if (jVar2 != null) {
                jVar2.mo29319c((C4377b) this);
            }
            mo29282l();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo29275a(MoatAdEvent moatAdEvent) {
        if (Double.isNaN(moatAdEvent.f11703c.doubleValue())) {
            moatAdEvent.f11703c = this.f11739o;
        }
        return new JSONObject(moatAdEvent.mo29194a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29261a(List<String> list) {
        if (this.f11734j == null) {
            list.add("Null adIds object");
        }
        if (list.isEmpty()) {
            super.mo29261a(list);
            return;
        }
        throw new C4403n(TextUtils.join(" and ", list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo29276a(Integer num, Integer num2) {
        int abs = Math.abs(num2.intValue() - num.intValue());
        double intValue = (double) num2.intValue();
        Double.isNaN(intValue);
        return ((double) abs) <= Math.min(750.0d, intValue * 0.05d);
    }

    /* renamed from: a */
    public boolean mo29277a(Map<String, String> map, View view) {
        try {
            mo29263c();
            mo29265d();
            if (view == null) {
                C4409p.m14772a(3, "BaseVideoTracker", (Object) this, "trackVideoAd received null video view instance");
            }
            this.f11734j = map;
            this.f11735k = new WeakReference<>(view);
            mo29262b();
            String format = String.format("trackVideoAd tracking ids: %s | view: %s", new Object[]{new JSONObject(map).toString(), C4409p.m14770a(view)});
            C4409p.m14772a(3, "BaseVideoTracker", (Object) this, format);
            C4409p.m14775a("[SUCCESS] ", mo29257a() + " " + format);
            if (this.f11723d != null) {
                this.f11723d.onTrackingStarted(mo29268g());
            }
            return true;
        } catch (Exception e) {
            mo29260a("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo29262b() {
        super.changeTargetView((View) this.f11735k.get());
        super.mo29262b();
        Map<String, Object> i = mo29279i();
        Integer num = (Integer) i.get("width");
        Integer num2 = (Integer) i.get("height");
        Integer num3 = (Integer) i.get("duration");
        C4409p.m14772a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "Player metadata: height = %d, width = %d, duration = %d", new Object[]{num2, num, num3}));
        this.f11740p.mo29290a(this.f11741q, this.f11734j, num, num2, num3);
    }

    public void changeTargetView(View view) {
        C4409p.m14772a(3, "BaseVideoTracker", (Object) this, "changing view to " + C4409p.m14770a(view));
        this.f11735k = new WeakReference<>(view);
        try {
            super.changeTargetView(view);
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
    }

    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        try {
            m14652b(moatAdEvent);
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public abstract Map<String, Object> mo29279i();

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public Double mo29280j() {
        return Double.valueOf(mo29281k().doubleValue() * C4401l.m14743a().mo29329b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public Double mo29281k() {
        return this.f11739o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo29282l() {
        if (!this.f11738n) {
            this.f11738n = true;
            this.f11733i.postDelayed(new Runnable() {
                public void run() {
                    try {
                        C4409p.m14772a(3, "BaseVideoTracker", (Object) this, "Shutting down.");
                        C4378c.this.f11740p.mo29288a();
                        VideoTrackerListener unused = C4378c.this.f11737m = null;
                    } catch (Exception e) {
                        C4403n.m14758a(e);
                    }
                }
            }, 500);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public boolean mo29283m() {
        return this.f11732h.containsKey(MoatAdEventType.AD_EVT_COMPLETE) || this.f11732h.containsKey(MoatAdEventType.AD_EVT_STOPPED) || this.f11732h.containsKey(MoatAdEventType.AD_EVT_SKIPPED);
    }

    public void removeVideoListener() {
        this.f11737m = null;
    }

    public void setPlayerVolume(Double d) {
        Double j = mo29280j();
        if (!d.equals(this.f11739o)) {
            C4409p.m14772a(3, "BaseVideoTracker", (Object) this, String.format(Locale.ROOT, "player volume changed to %f ", new Object[]{d}));
            this.f11739o = d;
            if (!j.equals(mo29280j())) {
                dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.f11700a, this.f11739o));
            }
        }
    }

    public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        this.f11737m = videoTrackerListener;
    }

    public void stopTracking() {
        try {
            super.stopTracking();
            mo29282l();
            if (this.f11737m != null) {
                this.f11737m = null;
            }
        } catch (Exception e) {
            C4403n.m14758a(e);
        }
    }
}
