package com.moat.analytics.mobile.vng;

import android.view.View;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.y */
class C4438y extends C4378c implements ReactiveVideoTracker {

    /* renamed from: l */
    private Integer f11895l;

    public C4438y(String str) {
        super(str);
        C4409p.m14772a(3, "ReactiveVideoTracker", (Object) this, "Initializing.");
        C4409p.m14775a("[SUCCESS] ", mo29257a() + " created");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo29257a() {
        return "ReactiveVideoTracker";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo29275a(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.f11704d == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.f11702b.equals(MoatAdEvent.f11700a) && !mo29276a(moatAdEvent.f11702b, this.f11895l)) {
            moatAdEvent.f11704d = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo29275a(moatAdEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29261a(List<String> list) {
        if (this.f11895l.intValue() >= 1000) {
            super.mo29261a(list);
            return;
        }
        throw new C4403n(String.format(Locale.ROOT, "Invalid duration = %d. Please make sure duration is in milliseconds.", new Object[]{this.f11895l}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Map<String, Object> mo29279i() {
        Integer num;
        HashMap hashMap = new HashMap();
        View view = (View) this.f11735k.get();
        int i = 0;
        if (view != null) {
            i = Integer.valueOf(view.getWidth());
            num = Integer.valueOf(view.getHeight());
        } else {
            num = 0;
        }
        hashMap.put("duration", this.f11895l);
        hashMap.put("width", i);
        hashMap.put("height", num);
        return hashMap;
    }

    public boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
        try {
            mo29263c();
            mo29265d();
            this.f11895l = num;
            return super.mo29277a(map, view);
        } catch (Exception e) {
            mo29260a("trackVideoAd", e);
            return false;
        }
    }
}
