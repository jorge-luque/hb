package com.moat.analytics.mobile.ogury;

import android.view.View;
import com.moat.analytics.mobile.ogury.C4315e;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.ogury.y */
final class C4368y extends C4315e implements ReactiveVideoTracker {

    /* renamed from: ˋॱ */
    private Integer f11699;

    public C4368y(String str) {
        super(str);
        C4315e.C43161.m14442(3, "ReactiveVideoTracker", this, "Initializing.");
        C4315e.C43161.m14446("[SUCCESS] ", "ReactiveVideoTracker created");
    }

    public final boolean trackVideoAd(Map<String, String> map, Integer num, View view) {
        try {
            mo29117();
            mo29112();
            this.f11699 = num;
            return super.mo29132(map, view);
        } catch (Exception e) {
            mo29114("trackVideoAd", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public final JSONObject mo29130(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.f11474 == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.f11475.equals(MoatAdEvent.f11471) && !C4315e.m14432(moatAdEvent.f11475, this.f11699)) {
            moatAdEvent.f11474 = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.mo29130(moatAdEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ */
    public final String mo29116() {
        return "ReactiveVideoTracker";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝ */
    public final Map<String, Object> mo29135() throws C4332l {
        Integer num;
        HashMap hashMap = new HashMap();
        View view = this.f11517.get();
        int i = 0;
        if (view != null) {
            i = Integer.valueOf(view.getWidth());
            num = Integer.valueOf(view.getHeight());
        } else {
            num = 0;
        }
        hashMap.put("duration", this.f11699);
        hashMap.put("width", i);
        hashMap.put("height", num);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ */
    public final void mo29110(List<String> list) throws C4332l {
        if (this.f11699.intValue() >= 1000) {
            super.mo29110(list);
            return;
        }
        throw new C4332l(String.format(Locale.ROOT, "Invalid duration = %d. Please make sure duration is in milliseconds.", new Object[]{this.f11699}));
    }
}
